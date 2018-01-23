package PIM.WEBSERIVE.ACTIVITIE.STUDENT.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import PIM.WEBSERIVE.ACTIVITIE.STUDENT.Model.Faculty;
import PIM.WEBSERIVE.ACTIVITIE.STUDENT.Service.FacultyService;

@RestController
@CrossOrigin
@RequestMapping(path = "test/faculty")
public class TestFaculty {

	@Autowired
	FacultyService facultyService;

	@RequestMapping(method = RequestMethod.GET)
	public List<Faculty> findAll() {
		return facultyService.findAll();
	}

	@RequestMapping(method = RequestMethod.GET, value = "id={id}")
	public Faculty findById(@PathVariable Integer id) {
		return facultyService.findById(id);
	}

	@RequestMapping(method = RequestMethod.GET, value = "name={name}")
	public Faculty findByName(@PathVariable String name) {
		return facultyService.findByName(name);
	}

}
