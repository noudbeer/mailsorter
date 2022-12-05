package fr.univ_smb.iae.ime.mailsorter.models;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.lang.NonNull;

@Entity
@Table(name = "user_topic")
public class UserTopic implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 4979830801670264122L;

	@NonNull
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@NonNull
	@ManyToOne
	@JoinColumn(name = "id_user")
	private User user;
	
	@NonNull
	@ManyToOne
	@JoinColumn(name = "id_topic")
	private Topic topic;
	
	
	

	public UserTopic() {
	}
	public UserTopic(User user, Topic topic) {
		this.user = user;
		this.topic = topic;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Topic getTopic() {
		return topic;
	}
	public void setTopic(Topic topic) {
		this.topic = topic;
	}
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
	
	
}
