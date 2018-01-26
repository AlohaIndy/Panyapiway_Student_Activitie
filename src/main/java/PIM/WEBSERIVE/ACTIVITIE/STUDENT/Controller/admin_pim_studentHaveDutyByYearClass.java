package PIM.WEBSERIVE.ACTIVITIE.STUDENT.Controller;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import PIM.WEBSERIVE.ACTIVITIE.STUDENT.AdminService.Admin_Pim;
import PIM.WEBSERIVE.ACTIVITIE.STUDENT.AdminService.model.WorkStudentYearClass;

@RestController
@CrossOrigin
@RequestMapping(path = "admin/pim")
public class admin_pim_studentHaveDutyByYearClass {

	@Autowired
	Admin_Pim admin_Pim;
	
	@RequestMapping(method = RequestMethod.GET)
	public Set<WorkStudentYearClass>  findAll(){
		String k="5852100081";
		return admin_Pim.getWorkStudentYearClass(01, 401, 03, Long.parseLong(k));
	}
	
}
