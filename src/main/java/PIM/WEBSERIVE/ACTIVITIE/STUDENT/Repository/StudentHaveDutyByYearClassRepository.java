package PIM.WEBSERIVE.ACTIVITIE.STUDENT.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import PIM.WEBSERIVE.ACTIVITIE.STUDENT.Model.StudentHaveDutyByYearClass;

public interface StudentHaveDutyByYearClassRepository extends JpaRepository<StudentHaveDutyByYearClass, Long>{

	public List<StudentHaveDutyByYearClass> findAll();
	
	public List<StudentHaveDutyByYearClass> findByStudentHaveDutyDutyId(int dutyId);
	
	public List<StudentHaveDutyByYearClass> findByStudentHaveDutyStudentMajorIdAndStudentHaveDutyDutyId(int majorId,int dutyId);
	
	public List<StudentHaveDutyByYearClass> findByStudentHaveDutyStudentIdAndStudentHaveDutyDutyId(Long studentId,int dutyId);
}
