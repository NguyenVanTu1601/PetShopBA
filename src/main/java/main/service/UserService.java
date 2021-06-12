package main.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import main.model.User;
import main.repository.UserRepository;

@Service
@Transactional
public class UserService {

	@Autowired
	private UserRepository userRepository;
	
	// lấy khách hàng theo id
	public User getUserById(String id) {
		return userRepository.findById(id).get();
	}
	
	// lưu khách hàng
	public User saveUser(User user) {
		return userRepository.save(user);
	}
}
