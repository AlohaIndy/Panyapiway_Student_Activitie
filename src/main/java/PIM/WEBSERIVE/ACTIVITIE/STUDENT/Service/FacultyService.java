package PIM.WEBSERIVE.ACTIVITIE.STUDENT.Service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import PIM.WEBSERIVE.ACTIVITIE.STUDENT.Model.Faculty;
import PIM.WEBSERIVE.ACTIVITIE.STUDENT.Repository.FacultyRepository;

@Service
@Transactional
public class FacultyService {
	
	private FacultyRepository facultyRepository;

	public FacultyService(FacultyRepository facultyDAO) {
		this.facultyRepository = facultyDAO;
	}

	public List<Faculty> findAll() {
		return facultyRepository.findAll();
	}
	
	public Faculty findById(Integer id) {
		return facultyRepository.findById(id);
	}
	
	public Faculty findByName(String name) {
		return facultyRepository.findByName(name);
	}
	
}
