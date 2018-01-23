package PIM.WEBSERIVE.ACTIVITIE.STUDENT.Service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import PIM.WEBSERIVE.ACTIVITIE.STUDENT.Model.Major;
import PIM.WEBSERIVE.ACTIVITIE.STUDENT.Repository.MajorRepository;

@Service
@Transactional
public class MajorService {
	
	private MajorRepository majorRepository;

	public MajorService(MajorRepository majorRepository) {
		this.majorRepository = majorRepository;
	}

	public List<Major> findAll(){
		return majorRepository.findAll();
	}
	
}
