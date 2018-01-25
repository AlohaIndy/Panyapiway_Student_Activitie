package PIM.WEBSERIVE.ACTIVITIE.STUDENT.AdminService;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import PIM.WEBSERIVE.ACTIVITIE.STUDENT.AdminService.model.DataWorkStudent;
import PIM.WEBSERIVE.ACTIVITIE.STUDENT.Model.StudentHaveDutyByYearClass;
import PIM.WEBSERIVE.ACTIVITIE.STUDENT.Repository.StudentHaveDutyByYearClassRepository;

@Service
@Transactional
public class Admin_Pim {

	@Autowired
	private StudentHaveDutyByYearClassRepository studentHaveDutyByYearClassRepository;

	public Set<DataWorkStudent> findByMajorIdAndDutyId(int majorId, int dutyId) {
		Map<Long, Object> respone = new HashMap<>();
		List<StudentHaveDutyByYearClass> AllDataStudent = studentHaveDutyByYearClassRepository
				.findByStudentHaveDutyStudentMajorIdAndStudentHaveDutyDutyId(majorId, dutyId);
		Set<Long> studentIds = new HashSet<>();
		Set<DataWorkStudent> dataWorkStudents = new HashSet<>();
		for (int i = 0; i < AllDataStudent.size(); i++) {
			studentIds.add(AllDataStudent.get(i).getStudentHaveDuty().getStudent().getId());
		}
		Iterator<Long> iterator = studentIds.iterator();
		System.out.println("studentIds size = " + studentIds.size());
		while (iterator.hasNext()) {
			Long idStudent = iterator.next();
			System.out.println("idStudent = " + idStudent);
			List<StudentHaveDutyByYearClass> DataStudent = studentHaveDutyByYearClassRepository
					.findByStudentHaveDutyStudentIdAndStudentHaveDutyDutyId(idStudent, 01);
			DataWorkStudent dataWorkStudent = new DataWorkStudent();
			dataWorkStudent.setId(idStudent);
			for (int i = 0; i < DataStudent.size(); i++) {
				dataWorkStudent.setFirstName(
						DataStudent.get(i).getStudentHaveDuty().getStudent().getPersonByPersonId().getFirstName());
				dataWorkStudent.setLastName(
						DataStudent.get(i).getStudentHaveDuty().getStudent().getPersonByPersonId().getLastName());
				if (1 == DataStudent.get(i).getYearClass().getId()) {
					dataWorkStudent.setLimitPerStudyLevel1(DataStudent.get(i).getLimitPerStudyLevel());
					dataWorkStudent.setStatus1(DataStudent.get(i).getStatus());
				}
				if (2 == DataStudent.get(i).getYearClass().getId()) {
					dataWorkStudent.setLimitPerStudyLevel2(DataStudent.get(i).getLimitPerStudyLevel());
					dataWorkStudent.setStatus2(DataStudent.get(i).getStatus());
				}
				if (3 == DataStudent.get(i).getYearClass().getId()) {
					dataWorkStudent.setLimitPerStudyLevel3(DataStudent.get(i).getLimitPerStudyLevel());
					dataWorkStudent.setStatus3(DataStudent.get(i).getStatus());
				}
				if (4 == DataStudent.get(i).getYearClass().getId()) {
					dataWorkStudent.setLimitPerStudyLevel4(DataStudent.get(i).getLimitPerStudyLevel());
					dataWorkStudent.setStatus4(DataStudent.get(i).getStatus());
				}
			}
			dataWorkStudents.add(dataWorkStudent);
		}
		return dataWorkStudents;

	}

	public List<StudentHaveDutyByYearClass> findByMajorIdAndDutyId1(int majorId, int dutyId) {
		return studentHaveDutyByYearClassRepository.findByStudentHaveDutyStudentMajorIdAndStudentHaveDutyDutyId(majorId,
				dutyId);
	}

}
