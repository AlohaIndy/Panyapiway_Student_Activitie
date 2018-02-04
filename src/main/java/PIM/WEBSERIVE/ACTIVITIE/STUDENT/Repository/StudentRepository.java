package PIM.WEBSERIVE.ACTIVITIE.STUDENT.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import PIM.WEBSERIVE.ACTIVITIE.STUDENT.Model.Student;

public interface StudentRepository  extends JpaRepository<Student, Long> {

	public Student findByPersonByPersonIdId(long idPerson);
	
}
