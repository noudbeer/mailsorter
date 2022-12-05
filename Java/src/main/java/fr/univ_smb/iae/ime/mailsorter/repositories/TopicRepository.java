package fr.univ_smb.iae.ime.mailsorter.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import fr.univ_smb.iae.ime.mailsorter.models.Topic;

@Repository
public interface TopicRepository extends JpaRepository<Topic, Long>{
	
	@Query(value = "SELECT * FROM topic WHERE topic = :topic", nativeQuery = true)
	public Topic findByTopic(@Param("topic") String topic);
}
