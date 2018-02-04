package PIM.WEBSERIVE.ACTIVITIE.STUDENT.SERVICE.User;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import PIM.WEBSERIVE.ACTIVITIE.STUDENT.Model.Account;
import PIM.WEBSERIVE.ACTIVITIE.STUDENT.Model.Address;
import PIM.WEBSERIVE.ACTIVITIE.STUDENT.Model.Email;
import PIM.WEBSERIVE.ACTIVITIE.STUDENT.Model.Phone;
import PIM.WEBSERIVE.ACTIVITIE.STUDENT.Model.Student;
import PIM.WEBSERIVE.ACTIVITIE.STUDENT.Repository.AccountRepository;
import PIM.WEBSERIVE.ACTIVITIE.STUDENT.Repository.AddressRepository;
import PIM.WEBSERIVE.ACTIVITIE.STUDENT.Repository.EmailRepository;
import PIM.WEBSERIVE.ACTIVITIE.STUDENT.Repository.PhoneRepository;
import PIM.WEBSERIVE.ACTIVITIE.STUDENT.Repository.StudentRepository;

@Service
@Transactional
public class ProfileService {
	
	@Autowired
	AccountRepository accountRepository;
	@Autowired
	StudentRepository studentRepository;
	@Autowired
	EmailRepository emailRepository;
	@Autowired
	PhoneRepository phoneRepository;
	@Autowired
	AddressRepository addressRepository;
	

	public Map<String, Object> getProfile(String accountIdString) {
		Map<String, Object> dataResponse = new HashMap<>();
		long accountId=Long.parseLong(accountIdString);
		Account account=accountRepository.findById(accountId);
		dataResponse.put("FirstName", account.getPerson().getFirstName());
		dataResponse.put("LastName",account.getPerson().getLastName());
		dataResponse.put("Birthday",account.getPerson().getBirthDate());
		Student student=studentRepository.findByPersonByPersonIdId(account.getPerson().getId());
		dataResponse.put("StudentId", student.getId());
		dataResponse.put("Faculty", student.getMajor().getName());
		dataResponse.put("Major", student.getMajor().getFaculty().getName());
		Email email=emailRepository.findByPersonId(account.getPerson().getId());
		dataResponse.put("Email", email.getName());
		Phone phone=phoneRepository.findByPersonId(account.getPerson().getId());
		dataResponse.put("Tel", phone.getNumber());
		Address address=addressRepository.findByPersonId(account.getPerson().getId());
		dataResponse.put("Address", address.toString());
		return dataResponse;
	}

}
