package main.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import main.model.Order;

@Repository
public interface OrderRepository extends CrudRepository<Order, String> {
	
	@Transactional
	@Query(value = "Select * from orders where user_id = ?1", 
	nativeQuery = true)
	List<Order> getOrderByIdUser(String idUser);
	
	
}
