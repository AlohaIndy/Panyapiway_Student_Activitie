package PIM.WEBSERIVE.ACTIVITIE.STUDENT.Controller;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import PIM.WEBSERIVE.ACTIVITIE.STUDENT.AdminService.Admin_Pim;
import PIM.WEBSERIVE.ACTIVITIE.STUDENT.AdminService.model.DataWorkStudent;
import PIM.WEBSERIVE.ACTIVITIE.STUDENT.Model.StudentHaveDuty;

@RestController
@CrossOrigin
@RequestMapping(path = "admin/pim")
public class admin_pim_studentHaveDutyByYearClass {

	@Autowired
	Admin_Pim admin_Pim;
	
	@RequestMapping(method = RequestMethod.GET)
	public Set<DataWorkStudent> findAll(){
		return admin_Pim.findByMajorIdAndDutyId(401, 01);
	}
	
}
