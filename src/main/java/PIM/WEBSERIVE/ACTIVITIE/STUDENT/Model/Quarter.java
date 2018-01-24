package PIM.WEBSERIVE.ACTIVITIE.STUDENT.Model;
// default package
// Generated 22 �.�. 2561, 22:56:21 by Hibernate Tools 4.3.5.Final

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * Quarter generated by hbm2java
 */
@SuppressWarnings("serial")
@Entity
@Table(name = "quarter", catalog = "panyapiway_student_activitie")
public class Quarter implements java.io.Serializable {

	private Integer id;
	private String name;
	@JsonIgnore
	private Set<StudentHaveDutyByYearClassQuarter> studentHaveDutyByYearClassQuarters = new HashSet<StudentHaveDutyByYearClassQuarter>(
			0);

	public Quarter() {
	}

	public Quarter(String name) {
		this.name = name;
	}

	public Quarter(String name, Set<StudentHaveDutyByYearClassQuarter> studentHaveDutyByYearClassQuarters) {
		this.name = name;
		this.studentHaveDutyByYearClassQuarters = studentHaveDutyByYearClassQuarters;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "id", unique = true, nullable = false)
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Column(name = "name", nullable = false, length = 45)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "quarter")
	public Set<StudentHaveDutyByYearClassQuarter> getStudentHaveDutyByYearClassQuarters() {
		return this.studentHaveDutyByYearClassQuarters;
	}

	public void setStudentHaveDutyByYearClassQuarters(
			Set<StudentHaveDutyByYearClassQuarter> studentHaveDutyByYearClassQuarters) {
		this.studentHaveDutyByYearClassQuarters = studentHaveDutyByYearClassQuarters;
	}

}
