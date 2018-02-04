package PIM.WEBSERIVE.ACTIVITIE.STUDENT.Controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import PIM.WEBSERIVE.ACTIVITIE.STUDENT.SERVICE.Admin.PIM_WorkStudentService;

@RestController
@CrossOrigin
@RequestMapping(path = "ADMIN_pim")
public class ADMIN_pim {

	@Autowired
	private PIM_WorkStudentService pim_WorkStudentService;

	@RequestMapping(method = RequestMethod.GET, value = "getWorkStudent/majorId={majorId},studentIdStartingWith={studentIdBetweenStart},studentId={studentId},firstName={studentFirstName},lastName={studentLastName}")
	public ResponseEntity<List<Map<String, Object>>> getWorkStudent(@PathVariable String majorId, @PathVariable String studentIdBetweenStart,
			@PathVariable String studentId, @PathVariable String studentFirstName, @PathVariable String studentLastName) {
		return new ResponseEntity<List<Map<String, Object>>>(pim_WorkStudentService.getWorkStudent("01", majorId, studentIdBetweenStart, studentId, studentFirstName, studentLastName),HttpStatus.OK);	
	}

	// @RequestMapping(method = RequestMethod.GET, value =
	// "getWorkStudentByYearClass/dutyId={dutyId},majorId={majorId},yearClassIdStudent={yearClassIdStudent}")
	// public ResponseEntity<Set<WorkStudentYearClass>> findAll(@PathVariable int
	// dutyId, @PathVariable int majorId,
	// return new ResponseEntity<Account>(accountService.save(newAccount),HttpStatus.OK);	

}
