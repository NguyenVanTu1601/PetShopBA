package main.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import main.model.Pet;
import main.repository.PetRepository;

@Service
@Transactional
public class PetService {

	@Autowired
	private PetRepository petRepository;
	
	public Pet getPetById(String id) {
		return petRepository.findById(id).get();
	}
	
	public List<Pet> getAllPet(){
		return (List<Pet>) petRepository.findAll();
	}
	
	public List<Pet> getPetByType(String type){
		return petRepository.getPetByType(type);
	}
	
	public Pet savePet(Pet pet) {
		pet.setState(0); // chưa mua
		return petRepository.save(pet);
	} 
	
	public Pet updatePet(Pet pet) {
		return petRepository.save(pet);
	}
}

