package fr.univ_smb.iae.ime.mailsorter.controllers;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import fr.univ_smb.iae.ime.mailsorter.models.Topic;
import fr.univ_smb.iae.ime.mailsorter.services.TopicService;

@RestController
@RequestMapping("/mailsorter/topics")
@CrossOrigin
public class ControllerTopic {
	
	@Autowired
	TopicService topicService;

	@PostMapping("/create")
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<?> addPTToBoard(@Validated @RequestBody Topic topic, BindingResult result) {

		if (result.hasErrors()) {
			Map<String, String> errorMap = new HashMap<String, String>();

			for (FieldError error : result.getFieldErrors()) {
				errorMap.put(error.getField(), error.getDefaultMessage());
			}
			return new ResponseEntity<Map<String, String>>(errorMap, HttpStatus.BAD_REQUEST);
		}
		
		//Topic newT = new Topic(topic);
		Topic newTopic = topicService.saveOrUpdate(topic);

		return new ResponseEntity<Topic>(newTopic, HttpStatus.CREATED);
	}

	@GetMapping("/all")
	public Iterable<Topic> getAllBuys() {
		return topicService.findAll();
	}

	@GetMapping("/{id}")
	public ResponseEntity<Topic> getBuyById(@PathVariable Long id) {
		
		Topic topic = topicService.findById(id);
		return new ResponseEntity<Topic>(topic, HttpStatus.OK);
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deleteBuy(@PathVariable Long id) {
		topicService.delete(id);
		return new ResponseEntity<String>("Topic supprimé avec succès. Merci au revoir !", HttpStatus.OK);
	}

}
