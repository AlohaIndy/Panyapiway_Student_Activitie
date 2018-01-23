package PIM.WEBSERIVE.ACTIVITIE.STUDENT.Model;
// default package
// Generated 22 �.�. 2561, 22:56:21 by Hibernate Tools 4.3.5.Final

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * YearClass generated by hbm2java
 */
@Entity
@Table(name = "year_class", catalog = "panyapiway_student_activitie")
public class YearClass implements java.io.Serializable {

	private int id;
	private String name;
	private Set<Student> students = new HashSet<Student>(0);
	private Set<StudentHaveDutyByYearClass> studentHaveDutyByYearClasses = new HashSet<StudentHaveDutyByYearClass>(0);

	public YearClass() {
	}

	public YearClass(int id, String name) {
		this.id = id;
		this.name = name;
	}

	public YearClass(int id, String name, Set<Student> students,
			Set<StudentHaveDutyByYearClass> studentHaveDutyByYearClasses) {
		this.id = id;
		this.name = name;
		this.students = students;
		this.studentHaveDutyByYearClasses = studentHaveDutyByYearClasses;
	}

	@Id

	@Column(name = "id", unique = true, nullable = false)
	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Column(name = "name", nullable = false, length = 45)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "yearClass")
	public Set<Student> getStudents() {
		return this.students;
	}

	public void setStudents(Set<Student> students) {
		this.students = students;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "yearClass")
	public Set<StudentHaveDutyByYearClass> getStudentHaveDutyByYearClasses() {
		return this.studentHaveDutyByYearClasses;
	}

	public void setStudentHaveDutyByYearClasses(Set<StudentHaveDutyByYearClass> studentHaveDutyByYearClasses) {
		this.studentHaveDutyByYearClasses = studentHaveDutyByYearClasses;
	}

}