package PIM.WEBSERIVE.ACTIVITIE.STUDENT.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import PIM.WEBSERIVE.ACTIVITIE.STUDENT.Model.Email;

public interface EmailRepository extends JpaRepository<Email, Long> {

	@Query(value = "SELECT * FORM EMAIL", nativeQuery = true)
	public List<Email> findAll();

	@Query(value = "SELECT * FORM EMAIL WHERE EMAIL.ID = ?1", nativeQuery = true)
	public Email findById(Long id);

}
