package PIM.WEBSERIVE.ACTIVITIE.STUDENT.Service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import PIM.WEBSERIVE.ACTIVITIE.STUDENT.Model.StudentHaveDutyByYearClass;
import PIM.WEBSERIVE.ACTIVITIE.STUDENT.Repository.StudentHaveDutyByYearClassRepository;

@Service
@Transactional
public class StudentHaveDutyByYearClassService {

	private StudentHaveDutyByYearClassRepository studentHaveDutyByYearClassRepository;

	public StudentHaveDutyByYearClassService(StudentHaveDutyByYearClassRepository studentHaveDutyByYearClassRepository) {
		this.studentHaveDutyByYearClassRepository = studentHaveDutyByYearClassRepository;
	}

	public List<StudentHaveDutyByYearClass> findAll() {
		return studentHaveDutyByYearClassRepository.findAll();
	}
	
	public List<StudentHaveDutyByYearClass> findByDutyId(int dutyId){
		return studentHaveDutyByYearClassRepository.findByStudentHaveDutyDutyId(dutyId);
	}
	
	public List<StudentHaveDutyByYearClass> findByMajorIdAndDutyId(int majorId,int dutyId){
		return studentHaveDutyByYearClassRepository.findByStudentHaveDutyStudentMajorIdAndStudentHaveDutyDutyId(majorId, dutyId);
	}
	
}
