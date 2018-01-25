package PIM.WEBSERIVE.ACTIVITIE.STUDENT.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import PIM.WEBSERIVE.ACTIVITIE.STUDENT.Model.StudentHaveDuty;

public interface StudentHaveDutyRepository extends JpaRepository<StudentHaveDuty, Long>{
	
	public List<StudentHaveDuty> findAll();

}
