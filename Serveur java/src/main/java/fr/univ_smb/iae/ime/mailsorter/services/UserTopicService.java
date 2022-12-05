package fr.univ_smb.iae.ime.mailsorter.services;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.univ_smb.iae.ime.mailsorter.models.UserTopic;
import fr.univ_smb.iae.ime.mailsorter.repositories.UserTopicRepository;

@Service
public class UserTopicService {
	
	@Autowired
	UserTopicRepository userTopicRepository;
	
	public UserTopic saveOrUpdate(UserTopic userTopic) {

		return userTopicRepository.save(userTopic);
	}

	public ArrayList<UserTopic> findAll() {
		return userTopicRepository.findAllUserTopic();
	}
	
	public ArrayList<UserTopic> findAllUser(Long topic){
		return userTopicRepository.findUserByTopic(topic);
	}
	

	public UserTopic findById(long id) {
		return userTopicRepository.getReferenceById(id);
	}

	public void delete(long id) {
		UserTopic userTopic = findById(id);
		userTopicRepository.delete(userTopic);
	}

}
