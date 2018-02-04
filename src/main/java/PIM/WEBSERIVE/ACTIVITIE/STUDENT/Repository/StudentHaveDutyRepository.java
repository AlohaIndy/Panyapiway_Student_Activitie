package PIM.WEBSERIVE.ACTIVITIE.STUDENT.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import PIM.WEBSERIVE.ACTIVITIE.STUDENT.Model.StudentHaveDuty;

public interface StudentHaveDutyRepository extends JpaRepository<StudentHaveDuty, Long>{
	
	public List<StudentHaveDuty> findAll();
	
	public List<StudentHaveDuty> findByDutyId(int dutyId);
	
	public List<StudentHaveDuty> findByDutyIdAndStudentId(int dutyId,long studentId);
	
	public List<StudentHaveDuty> findByDutyIdAndStudentPersonByPersonIdFirstName(int dutyId,String studentFirstName);
	
	public List<StudentHaveDuty> findByDutyIdAndStudentPersonByPersonIdLastName(int dutyId,String studentLastName);
	
	public List<StudentHaveDuty> findByDutyIdAndStudentPersonByPersonIdFirstNameStartingWithAndStudentPersonByPersonIdLastNameStartingWith(int dutyId,String studentFirstName,String studentLastName);
	
	public List<StudentHaveDuty> findByDutyIdAndStudentMajorIdAndStudentIdBetween(int dutyId,int majorId,long studentIdBetweenStart,long studentIdBetweenEnd);

}
