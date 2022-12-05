package fr.univ_smb.iae.ime.mailsorter.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import fr.univ_smb.iae.ime.mailsorter.models.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
	@Query(value = "SELECT * FROM utilisateur WHERE name = :name", nativeQuery = true)
	public User findByUser(@Param("name") String name);

}
