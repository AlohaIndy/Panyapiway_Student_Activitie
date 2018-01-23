package PIM.WEBSERIVE.ACTIVITIE.STUDENT.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import PIM.WEBSERIVE.ACTIVITIE.STUDENT.Model.Major;
import PIM.WEBSERIVE.ACTIVITIE.STUDENT.Service.MajorService;

@RestController
@CrossOrigin
@RequestMapping(path = "test/major")
public class TestMajor {

	@Autowired
	MajorService majorService;

	@RequestMapping(method = RequestMethod.GET)
	public List<Major> findAll(){
		return majorService.findAll();
	}

}
