package fr.univ_smb.iae.ime.mailsorter.services;

import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.univ_smb.iae.ime.mailsorter.models.User;
import fr.univ_smb.iae.ime.mailsorter.repositories.UserRepository;

@Service
public class UserService {
	
	@Autowired
	UserRepository userRepository;
	
	public User saveOrUpdate(User user) {

		return userRepository.save(user);
	}

	public ArrayList<User> findAll() {
		return (ArrayList<User>)userRepository.findAll();
	}

	public User findById(long id) {
		return userRepository.getReferenceById(id);
	}

	public void delete(long id) {
		User user = findById(id);
		userRepository.delete(user);
	}
	
	public 	User findByUser(String name) {
		return userRepository.findByUser(name);
	}

}
