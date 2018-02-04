package PIM.WEBSERIVE.ACTIVITIE.STUDENT.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import PIM.WEBSERIVE.ACTIVITIE.STUDENT.Model.StudentHaveDutyByYearClass;

public interface StudentHaveDutyByYearClassRepository extends JpaRepository<StudentHaveDutyByYearClass, Long> {

	public List<StudentHaveDutyByYearClass> findAll();
	
	public StudentHaveDutyByYearClass findById(Long id);

	public List<StudentHaveDutyByYearClass> findByStudentHaveDutyDutyId(int dutyId);

	public List<StudentHaveDutyByYearClass> findByStudentHaveDutyDutyIdAndStudentHaveDutyStudentMajorId(int dutyId,
			int majorId);

	public List<StudentHaveDutyByYearClass> findByStudentHaveDutyDutyIdAndStudentHaveDutyStudentId(int dutyId,
			long studentId);

	public List<StudentHaveDutyByYearClass> findByStudentHaveDutyDutyIdAndStudentHaveDutyStudentMajorIdAndStudentHaveDutyStudentYearClassIdAndStudentHaveDutyStudentId(
			int dutyId,int majorId,int yearClassIdStudent,Long studentId);
	
	public List<StudentHaveDutyByYearClass> findByStudentHaveDutyDutyIdAndStudentHaveDutyStudentMajorIdAndStudentHaveDutyStudentYearClassId(
			int dutyId,int majorId,int yearClassIdStudent);
	
}
