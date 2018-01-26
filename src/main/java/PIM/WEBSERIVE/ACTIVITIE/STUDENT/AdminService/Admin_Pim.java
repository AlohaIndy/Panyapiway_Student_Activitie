package PIM.WEBSERIVE.ACTIVITIE.STUDENT.AdminService;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import PIM.WEBSERIVE.ACTIVITIE.STUDENT.AdminService.model.WorkStudentYearClass;
import PIM.WEBSERIVE.ACTIVITIE.STUDENT.Model.StudentHaveDutyByYearClass;
import PIM.WEBSERIVE.ACTIVITIE.STUDENT.Repository.StudentHaveDutyByYearClassRepository;

@Service
@Transactional
public class Admin_Pim {

	@Autowired
	private StudentHaveDutyByYearClassRepository studentHaveDutyByYearClassRepository;

	public Set<WorkStudentYearClass> getWorkStudentYearClass(int dutyId, int majorId, int yearClassIdStudent) {
		List<StudentHaveDutyByYearClass> AllDataStudent = studentHaveDutyByYearClassRepository
				.findByStudentHaveDutyDutyIdAndStudentHaveDutyStudentMajorIdAndStudentHaveDutyStudentYearClassId(dutyId,
						majorId, yearClassIdStudent);
		Set<Long> studentIds = new HashSet<>();
		Set<WorkStudentYearClass> dataWorkStudents = new HashSet<>();
		for (int i = 0; i < AllDataStudent.size(); i++) {
			studentIds.add(AllDataStudent.get(i).getStudentHaveDuty().getStudent().getId());
		}
		Iterator<Long> iterator = studentIds.iterator();
		while (iterator.hasNext()) {
			Long idStudent = iterator.next();
			WorkStudentYearClass dataWorkStudent = new WorkStudentYearClass();
			dataWorkStudent.setId(idStudent);
			for (int i = 0; i < AllDataStudent.size(); i++) {
				dataWorkStudent.setFirstName(
						AllDataStudent.get(i).getStudentHaveDuty().getStudent().getPersonByPersonId().getFirstName());
				dataWorkStudent.setLastName(
						AllDataStudent.get(i).getStudentHaveDuty().getStudent().getPersonByPersonId().getLastName());
				if (1 == AllDataStudent.get(i).getYearClass().getId()) {
					dataWorkStudent.setCanDo1(AllDataStudent.get(i).getCanDo());
					dataWorkStudent.setLimitPerStudyLevel1(AllDataStudent.get(i).getLimitPerStudyLevel());
					dataWorkStudent.setStatus1(AllDataStudent.get(i).getStatus());
				}
				if (2 == AllDataStudent.get(i).getYearClass().getId()) {
					dataWorkStudent.setCanDo2(AllDataStudent.get(i).getCanDo());
					dataWorkStudent.setLimitPerStudyLevel2(AllDataStudent.get(i).getLimitPerStudyLevel());
					dataWorkStudent.setStatus2(AllDataStudent.get(i).getStatus());
				}
				if (3 == AllDataStudent.get(i).getYearClass().getId()) {
					dataWorkStudent.setCanDo3(AllDataStudent.get(i).getCanDo());
					dataWorkStudent.setLimitPerStudyLevel3(AllDataStudent.get(i).getLimitPerStudyLevel());
					dataWorkStudent.setStatus3(AllDataStudent.get(i).getStatus());
				}
				if (4 == AllDataStudent.get(i).getYearClass().getId()) {
					dataWorkStudent.setCanDo4(AllDataStudent.get(i).getCanDo());
					dataWorkStudent.setLimitPerStudyLevel4(AllDataStudent.get(i).getLimitPerStudyLevel());
					dataWorkStudent.setStatus4(AllDataStudent.get(i).getStatus());
				}
			}
			dataWorkStudents.add(dataWorkStudent);
		}
		return dataWorkStudents;

	}

	public Set<WorkStudentYearClass> getWorkStudentYearClass(int dutyId, int majorId, int yearClassIdStudent,
			Long studentId) {
		Set<WorkStudentYearClass> dataResponse = new HashSet<>();
		List<StudentHaveDutyByYearClass> studentHaveDutyByYearClasses = new ArrayList<>();
		studentHaveDutyByYearClasses = studentHaveDutyByYearClassRepository
				.findByStudentHaveDutyDutyIdAndStudentHaveDutyStudentMajorIdAndStudentHaveDutyStudentYearClassIdAndStudentHaveDutyStudentId(
						dutyId, majorId, yearClassIdStudent, studentId);
		WorkStudentYearClass dataWorkStudent = new WorkStudentYearClass();
		for (int i = 0; i < studentHaveDutyByYearClasses.size(); i++) {
			dataWorkStudent.setId(studentHaveDutyByYearClasses.get(i).getStudentHaveDuty().getStudent().getId());
			dataWorkStudent.setFirstName(studentHaveDutyByYearClasses.get(i).getStudentHaveDuty().getStudent()
					.getPersonByPersonId().getFirstName());
			dataWorkStudent.setLastName(studentHaveDutyByYearClasses.get(i).getStudentHaveDuty().getStudent()
					.getPersonByPersonId().getLastName());
			if (1 == studentHaveDutyByYearClasses.get(i).getYearClass().getId()) {
				dataWorkStudent.setCanDo1(studentHaveDutyByYearClasses.get(i).getCanDo());
				dataWorkStudent.setLimitPerStudyLevel1(studentHaveDutyByYearClasses.get(i).getLimitPerStudyLevel());
				dataWorkStudent.setStatus1(studentHaveDutyByYearClasses.get(i).getStatus());
			}
			if (2 == studentHaveDutyByYearClasses.get(i).getYearClass().getId()) {
				dataWorkStudent.setCanDo2(studentHaveDutyByYearClasses.get(i).getCanDo());
				dataWorkStudent.setLimitPerStudyLevel2(studentHaveDutyByYearClasses.get(i).getLimitPerStudyLevel());
				dataWorkStudent.setStatus2(studentHaveDutyByYearClasses.get(i).getStatus());
			}
			if (3 == studentHaveDutyByYearClasses.get(i).getYearClass().getId()) {
				dataWorkStudent.setCanDo3(studentHaveDutyByYearClasses.get(i).getCanDo());
				dataWorkStudent.setLimitPerStudyLevel3(studentHaveDutyByYearClasses.get(i).getLimitPerStudyLevel());
				dataWorkStudent.setStatus3(studentHaveDutyByYearClasses.get(i).getStatus());
			}
			if (4 == studentHaveDutyByYearClasses.get(i).getYearClass().getId()) {
				dataWorkStudent.setCanDo4(studentHaveDutyByYearClasses.get(i).getCanDo());
				dataWorkStudent.setLimitPerStudyLevel4(studentHaveDutyByYearClasses.get(i).getLimitPerStudyLevel());
				dataWorkStudent.setStatus4(studentHaveDutyByYearClasses.get(i).getStatus());
			}
		}
		dataResponse.add(dataWorkStudent);
		return dataResponse;
	}

}
