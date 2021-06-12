package main.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import main.model.Pet;

@Repository
public interface PetRepository extends CrudRepository<Pet, String> {

	@Transactional
	@Query(value = "Select * from pet p where p.type = ?1", 
			nativeQuery = true)
	List<Pet> getPetByType(String type);
	
	
}
