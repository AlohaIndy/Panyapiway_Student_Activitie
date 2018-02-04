package PIM.WEBSERIVE.ACTIVITIE.STUDENT.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import PIM.WEBSERIVE.ACTIVITIE.STUDENT.Model.Phone;

public interface PhoneRepository extends JpaRepository<Phone, Long>{

	@Query(value = "SELECT * FORM PHONE", nativeQuery = true)
	public List<Phone> findAll();
	
	@Query(value = "SELECT * FORM PHONE WHERE PHONE.ID = ?1", nativeQuery = true)
	public Phone findById(Long id);
	
	public Phone findByPersonId(long personId);
	
}
