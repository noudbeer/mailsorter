package fr.univ_smb.iae.ime.mailsorter.repositories;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import fr.univ_smb.iae.ime.mailsorter.models.UserTopic;

@Repository
public interface UserTopicRepository extends JpaRepository<UserTopic, Long>{
		
	@Query(value = "SELECT * FROM user_topic WHERE id_topic = :id_topic", nativeQuery = true)
	public ArrayList<UserTopic> findUserByTopic(@Param("id_topic") Long topic);

}
