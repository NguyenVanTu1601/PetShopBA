package main.api;

import java.time.Instant;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import main.model.Order;
import main.model.Pet;
import main.service.OrderService;
import main.service.PetService;
import main.service.UserService;

@RestController
@RequestMapping(path = "/orders", produces = "application/json")
@CrossOrigin(origins = "*")
public class OrderController {

	@Autowired
	private OrderService orderService;
	
	@Autowired
	private PetService petService;
	
	@Autowired
	private JavaMailSender javaMailSender;
	
	@Autowired
	private UserService userService;
	
	// get order by user id
	@GetMapping("/user/{id}")
	public List<Order> getListOrderByIdUser(@PathVariable("id") String idUser){
		return orderService.getListOrderUser(idUser);
	}
	
	
	// post order 
	@PostMapping(consumes="application/json")
	@ResponseStatus(HttpStatus.CREATED)
	public Order postOrder(@RequestBody Order order) {
		order.setStatus("Đã đặt đơn");
		order.setCreateAt(Instant.now());
		order = orderService.saveOrder(order);
		if (order.getStatus() == "Đã đặt đơn") {
			// update state pet
			System.out.println("id pet buy = " + order.getListOrder().get(0).getPetId());
			Pet pet = (Pet) petService.getPetById(order.getListOrder().get(0).getPetId());
			pet.setState(1);
			petService.updatePet(pet); // cập nhật trạng thái pet là đã có ng đặt
			
			// get email User
			String email = userService.getUserById(order.getUserId()).getEmail();
			String content = "Đơn hàng " + order.getId_order() + " của bạn đã được tạo thành công!";
			// send a mail

			Thread sendMailThread = new Thread(new Runnable() {
				
				@Override
				public void run() {
					SimpleMailMessage message = new SimpleMailMessage();
					message.setFrom("noreply@petshop.com");
					message.setTo(email);
					message.setSubject("Thông báo: Đơn hàng đã được tạo");
					message.setText(content);
					javaMailSender.send(message);
					System.out.println("Đã send email");
				}
			});
			sendMailThread.start();
			
			
			return order;
			
			
		}
		return order;
		
	}
}
