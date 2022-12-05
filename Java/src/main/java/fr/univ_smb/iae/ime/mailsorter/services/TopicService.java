package fr.univ_smb.iae.ime.mailsorter.services;

import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.univ_smb.iae.ime.mailsorter.models.Topic;
import fr.univ_smb.iae.ime.mailsorter.repositories.TopicRepository;

@Service
public class TopicService {

	@Autowired
	TopicRepository topicRepository;

	public Topic saveOrUpdate(Topic topic) {

		return topicRepository.save(topic);
	}

	public ArrayList<Topic> findAll() {
		return (ArrayList<Topic>) topicRepository.findAll();
	}

	public Topic findById(Long id) {
		return (Topic) topicRepository.getReferenceById(id);
	}

	public void delete(Long id) {
		Topic topic = findById(id);
		topicRepository.delete(topic);
	}

	public Topic findByTopic(String topic) {
		return topicRepository.findByTopic(topic);
	}

}
