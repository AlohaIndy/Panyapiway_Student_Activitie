package PIM.WEBSERIVE.ACTIVITIE.STUDENT.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import PIM.WEBSERIVE.ACTIVITIE.STUDENT.Model.Major;

public interface MajorRepository extends JpaRepository<Major, Integer>{

	@Query(value = "SELECT * FORM MAJOR",nativeQuery = true)
	public List<Major> findAll();
	
}
