package fr.univ_smb.iae.ime.mailsorter.controllers;


import java.util.ArrayList;
import java.util.Map;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

import fr.univ_smb.iae.ime.mailsorter.models.Topic;
import fr.univ_smb.iae.ime.mailsorter.models.User;
import fr.univ_smb.iae.ime.mailsorter.models.UserTopic;
import fr.univ_smb.iae.ime.mailsorter.services.TopicService;
import fr.univ_smb.iae.ime.mailsorter.services.UserService;
import fr.univ_smb.iae.ime.mailsorter.services.UserTopicService;

@RestController
@RequestMapping("/mailsorter/usertopics")
@CrossOrigin
public class ControllerUserTopic {
	
	@Autowired
	UserTopicService userTopicService;
	@Autowired
	UserService userService;
	@Autowired
	TopicService topicService;
		
	
	@RequestMapping(value="/create", method = RequestMethod.POST, produces= "application/json")
	@ResponseStatus(code=HttpStatus.CREATED)
	public UserTopic addPTToBoard( @RequestBody Map<String, String> body) {
		
		String name = body.get("name");
		String topic = body.get("topic");
		
		System.out.println(name);
		System.out.println(topic);
		UserTopic newUserTopic = new UserTopic();
		
		User userCurrent = userService.findByUser(name);
		Topic topicCurrent = topicService.findByTopic(topic);
		
		if(userCurrent!=null && topicCurrent != null) {
			newUserTopic = userTopicService.saveOrUpdate(new UserTopic(userCurrent, topicCurrent ));	
		}
		
		if(userCurrent==null && topicCurrent!=null) {
			User newUser = userService.saveOrUpdate(new User(name)) ;
			newUserTopic = userTopicService.saveOrUpdate(new UserTopic(newUser, topicCurrent ));	

		}
		if(userCurrent!=null && topicCurrent==null) {
			Topic newTopic = topicService.saveOrUpdate(new Topic(topic)) ;
			newUserTopic = userTopicService.saveOrUpdate(new UserTopic(userCurrent, newTopic ));	

		}
		
		if(userCurrent==null && topicCurrent == null) {
			User newUser = userService.saveOrUpdate(new User(name)) ;
			Topic newTopic = topicService.saveOrUpdate(new Topic(topic)) ;
			newUserTopic = userTopicService.saveOrUpdate(new UserTopic(newUser, newTopic ));	
		}
		//System.out.println(newUserTopic.toString());
		
		return newUserTopic; //new UserTopic(userCurrent, topicCurrent);
	}

	@RequestMapping(value = "/all", method = RequestMethod.GET)
	public Iterable<UserTopic> getAllBuys() {
		return userTopicService.findAll();
	}
	
	
	@RequestMapping(value="allusers", method = RequestMethod.GET, consumes="application/json", produces= "application/json")
	@ResponseStatus(code=HttpStatus.FOUND)
	public ArrayList<User> getAllUserTopic(@RequestBody String body) {
				
		JsonObject topic = new Gson().fromJson(body, JsonObject.class);
				

		System.out.println(topic);

		System.out.println(topic.get("topic").toString());
		
		String res = topic.get("topic").toString();
		System.out.println(res.substring(1, res.length()-1));
		
		String res1 = res.substring(1, res.length()-1);

		Topic topicCurrent = topicService.findByTopic(res1);
				
		ArrayList<UserTopic> listUserTopic = userTopicService.findAllUser(topicCurrent.getId());
		
		ArrayList<User> listUser = new ArrayList<>();
		
		if (listUserTopic.isEmpty()) {
			String admin = "Administrateur";
			User defaultUser =  userService.findByUser(admin);
			System.out.println(defaultUser);
			listUser.add(defaultUser);
		}else {
			for (UserTopic p : listUserTopic) {
				listUser.add(p.getUser());
			}
		}
		
		return listUser;
		
	}
	

	@GetMapping("/{id}")
	public ResponseEntity<UserTopic> getBuyById(@PathVariable Long id) {
		UserTopic userTopic = userTopicService.findById(id);
		return new ResponseEntity<UserTopic>(userTopic, HttpStatus.OK);
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deleteBuy(@PathVariable Long id) {
		userTopicService.delete(id);
		return new ResponseEntity<String>("UserTopic supprimé avec succès. Merci au revoir !", HttpStatus.OK);
	}

}
