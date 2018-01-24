package PIM.WEBSERIVE.ACTIVITIE.STUDENT.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import PIM.WEBSERIVE.ACTIVITIE.STUDENT.Model.StudentHaveDutyByYearClass;
import PIM.WEBSERIVE.ACTIVITIE.STUDENT.Service.StudentHaveDutyByYearClassService;

@RestController
@CrossOrigin
@RequestMapping(path = "admin/pim")
public class admin_pim_studentHaveDutyByYearClass {

	@Autowired
	StudentHaveDutyByYearClassService studentHaveDutyByYearClassService;
	
	@RequestMapping(method = RequestMethod.GET)
	public List<StudentHaveDutyByYearClass> findByStudentHaveDutyDutyId(){
		return studentHaveDutyByYearClassService.findByMajorIdAndDutyId(401, 01);
	}
	
}
