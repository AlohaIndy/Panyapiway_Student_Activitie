package PIM.WEBSERIVE.ACTIVITIE.STUDENT.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import PIM.WEBSERIVE.ACTIVITIE.STUDENT.Model.Faculty;

public interface FacultyRepository extends JpaRepository<Faculty, Integer> {

	@Query(value = "select f from Faculty f order by f.id asc")
	public List<Faculty> findAll();
	
	@Query(value = "select f from Faculty f where f.id = ?1 order by f.id asc")
	public Faculty findById(Integer id);
	
	@Query(value = "select f from Faculty f where f.name = ?1 order by f.id asc")
	public Faculty findByName(String name);
	
}
