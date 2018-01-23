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

/**
 * ActivitieType generated by hbm2java
 */
@Entity
@Table(name = "activitie_type", catalog = "panyapiway_student_activitie")
public class ActivitieType implements java.io.Serializable {

	private Integer id;
	private String name;
	private Set<Activitie> activities = new HashSet<Activitie>(0);

	public ActivitieType() {
	}

	public ActivitieType(String name, Set<Activitie> activities) {
		this.name = name;
		this.activities = activities;
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

	@Column(name = "name", length = 60)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "activitieType")
	public Set<Activitie> getActivities() {
		return this.activities;
	}

	public void setActivities(Set<Activitie> activities) {
		this.activities = activities;
	}

}