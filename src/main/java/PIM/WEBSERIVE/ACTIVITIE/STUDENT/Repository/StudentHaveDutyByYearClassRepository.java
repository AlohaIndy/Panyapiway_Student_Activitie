package PIM.WEBSERIVE.ACTIVITIE.STUDENT.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import PIM.WEBSERIVE.ACTIVITIE.STUDENT.Model.StudentHaveDutyByYearClass;

public interface StudentHaveDutyByYearClassRepository extends JpaRepository<StudentHaveDutyByYearClass, Long>{

	@Query(value = "SELECT * FROM `student_have_duty_by_year_class`", nativeQuery = true)
	public List<StudentHaveDutyByYearClass> findAll();
	
	public List<StudentHaveDutyByYearClass> findByStudentHaveDutyDutyId(int dutyId);
	
	public List<StudentHaveDutyByYearClass> findByStudentHaveDutyStudentMajorIdAndStudentHaveDutyDutyId(int majorId,int dutyId);
}
