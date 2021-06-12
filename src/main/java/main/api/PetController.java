package main.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import main.model.Pet;
import main.service.PetService;

@RestController
@RequestMapping(path = "/pets", produces = "application/json")
@CrossOrigin(origins = "*")
public class PetController {
	
	@Autowired
	private PetService petService;
	
	@GetMapping()
	public List<Pet> getAllPet(){
		System.out.println("type = all" );
		return petService.getAllPet();
	}
	
	@GetMapping("/id/{id}")
	public Pet getPetById(@PathVariable("id") String id) {
		return petService.getPetById(id);
	}
	
	@GetMapping("/{type}")
	public List<Pet> getPetByType(@PathVariable("type") String type){
		System.out.println("type = " + type);
		return petService.getPetByType(type);
	}
	
	@PostMapping(consumes="application/json")
	@ResponseStatus(HttpStatus.CREATED)
	public Pet postPet(@RequestBody Pet pet) {
		return petService.savePet(pet);
	}
	

}
