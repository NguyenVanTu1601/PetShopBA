package main.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import main.model.User;


@Repository
public interface UserRepository extends CrudRepository<User,String>{

}
