package PIM.WEBSERIVE.ACTIVITIE.STUDENT.Controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import PIM.WEBSERIVE.ACTIVITIE.STUDENT.SERVICE.User.ProfileService;

@RestController
@CrossOrigin
@RequestMapping(path = "profile/accountId={accountId}")
public class Profile {

	@Autowired
	ProfileService profileService;
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<Map<String, Object>> getWorkStudent(@PathVariable String accountId) {
		return new ResponseEntity<Map<String, Object>>(profileService.getProfile(accountId),HttpStatus.OK);	
	}
	
}
