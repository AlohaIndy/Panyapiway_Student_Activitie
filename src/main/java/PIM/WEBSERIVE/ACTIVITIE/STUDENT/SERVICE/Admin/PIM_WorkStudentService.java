package PIM.WEBSERIVE.ACTIVITIE.STUDENT.SERVICE.Admin;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import PIM.WEBSERIVE.ACTIVITIE.STUDENT.Model.StudentHaveDuty;
import PIM.WEBSERIVE.ACTIVITIE.STUDENT.Repository.StudentHaveDutyRepository;

@Service
@Transactional
public class PIM_WorkStudentService {

	@Autowired
	private StudentHaveDutyRepository studentHaveDutyRepository;

	public List<Map<String, Object>> getWorkStudent(String dutyId, String majorId, String studentIdBetweenStart,
			String studentId, String studentFirstName, String studentLastName) {
		List<StudentHaveDuty> studentHaveDuties = new ArrayList<>();
		if (studentId.equals("") && studentFirstName.equals("") && studentLastName.equals("")) {
			studentHaveDuties = studentHaveDutyRepository.findByDutyIdAndStudentMajorIdAndStudentIdBetween(
					Integer.parseInt(dutyId), Integer.parseInt(majorId),
					Long.parseLong(studentIdBetweenStart + "00000000"),
					Long.parseLong(Long.toString(Long.parseLong(studentIdBetweenStart) + 1) + "00000000"));
		}else if (!studentId.equals("")) {
			studentHaveDuties = studentHaveDutyRepository.findByDutyIdAndStudentId(Integer.parseInt(dutyId), Long.parseLong(studentId));
		}else{
			studentHaveDuties = studentHaveDutyRepository.findByDutyIdAndStudentPersonByPersonIdFirstNameStartingWithAndStudentPersonByPersonIdLastNameStartingWith(Integer.parseInt(dutyId), studentFirstName, studentLastName);
		}
		List<Map<String, Object>> dataResponse = new ArrayList<>();
		for (int i = 0; i < studentHaveDuties.size(); i++) {
			Map<String, Object> JSON = new HashMap<>();
			JSON.put("studentId", studentHaveDuties.get(i).getStudent().getId());
			JSON.put("studentFirstName", studentHaveDuties.get(i).getStudent().getPersonByPersonId().getFirstName());
			JSON.put("studentLastName", studentHaveDuties.get(i).getStudent().getPersonByPersonId().getLastName());
			for (int j = 0; j < studentHaveDuties.get(i).getStudentHaveDutyByYearClasses().size(); j++) {
				JSON.put(
						studentHaveDuties.get(i).getStudentHaveDutyByYearClasses().get(j).getYearClass().getName()
								+ "CanDo",
						studentHaveDuties.get(i).getStudentHaveDutyByYearClasses().get(j).getCanDo());
				JSON.put(
						studentHaveDuties.get(i).getStudentHaveDutyByYearClasses().get(j).getYearClass().getName()
								+ "Limited",
						studentHaveDuties.get(i).getStudentHaveDutyByYearClasses().get(j).getLimitPerStudyLevel());
				JSON.put(studentHaveDuties.get(i).getStudentHaveDutyByYearClasses().get(j).getYearClass().getName()
						+ "Status", studentHaveDuties.get(i).getStudentHaveDutyByYearClasses().get(j).getStatus());
				for (int k = 0; k < studentHaveDuties.get(i).getStudentHaveDutyByYearClasses().get(j)
						.getStudentHaveDutyByYearClassQuarters().size(); k++) {
					JSON.put(
							studentHaveDuties.get(i).getStudentHaveDutyByYearClasses().get(j).getYearClass().getName()
									+ "_"
									+ studentHaveDuties.get(i).getStudentHaveDutyByYearClasses().get(j)
											.getStudentHaveDutyByYearClassQuarters().get(k).getQuarter().getName()
									+ "CanDo",
							studentHaveDuties.get(i).getStudentHaveDutyByYearClasses().get(j)
									.getStudentHaveDutyByYearClassQuarters().get(k).getCanDo());
					JSON.put(
							studentHaveDuties.get(i).getStudentHaveDutyByYearClasses().get(j).getYearClass().getName()
									+ "_"
									+ studentHaveDuties.get(i).getStudentHaveDutyByYearClasses().get(j)
											.getStudentHaveDutyByYearClassQuarters().get(k).getQuarter().getName()
									+ "Limited",
							studentHaveDuties.get(i).getStudentHaveDutyByYearClasses().get(j)
									.getStudentHaveDutyByYearClassQuarters().get(k).getAveragePerQuarter());
					JSON.put(
							studentHaveDuties.get(i).getStudentHaveDutyByYearClasses().get(j).getYearClass().getName()
									+ "_"
									+ studentHaveDuties.get(i).getStudentHaveDutyByYearClasses().get(j)
											.getStudentHaveDutyByYearClassQuarters().get(k).getQuarter().getName()
									+ "Status",
							studentHaveDuties.get(i).getStudentHaveDutyByYearClasses().get(j)
									.getStudentHaveDutyByYearClassQuarters().get(k).getStatus());
				}
			}
			dataResponse.add(JSON);
		}
		return dataResponse;
	}

}
