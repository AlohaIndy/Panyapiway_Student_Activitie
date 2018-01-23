package PIM.WEBSERIVE.ACTIVITIE.STUDENT.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import PIM.WEBSERIVE.ACTIVITIE.STUDENT.Model.Major;

public interface MajorRepository extends JpaRepository<Major, Integer>{

	@Query(value = "select m from Major m order by m.id asc")
	public List<Major> findAll();
	
}
