package be.scorgar.demo.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import be.scorgar.demo.domain.User;
import be.scorgar.demo.repository.UserRepository;

@Service
public class UserService {

	@Inject private UserRepository userRepository;

	public List<User> findAll() {
		return userRepository.findAll();
	}

	public void save(User user) {
		userRepository.save(user);
	}

}
