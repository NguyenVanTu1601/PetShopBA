package main.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import main.model.Order;
import main.repository.OrderRepository;

@Service
@Transactional
public class OrderService {
	
	@Autowired
	private OrderRepository orderRepository;
	
	public List<Order> getListOrderUser(String idUser) {
		return orderRepository.getOrderByIdUser(idUser);
	}
	
	public Order saveOrder(Order order) {
		return orderRepository.save(order);
	}

}
