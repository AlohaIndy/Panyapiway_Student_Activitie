package PIM.WEBSERIVE.ACTIVITIE.STUDENT.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import PIM.WEBSERIVE.ACTIVITIE.STUDENT.Model.Person;

public interface PersonRepository extends JpaRepository<Person, Long> {

	@Query(value = "SELECT * FORM PERSON", nativeQuery = true)
	public List<Person> findAll();

	@Query(value = "SELECT * FORM PERSON WHERE PERSON.ID = ?1", nativeQuery = true)
	public Person findById(long id);

}
