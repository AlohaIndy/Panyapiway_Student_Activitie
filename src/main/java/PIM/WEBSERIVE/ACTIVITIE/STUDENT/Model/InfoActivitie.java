package PIM.WEBSERIVE.ACTIVITIE.STUDENT.Model;
// default package
// Generated 22 �.�. 2561, 22:56:21 by Hibernate Tools 4.3.5.Final

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * InfoActivitie generated by hbm2java
 */
@Entity
@Table(name = "info_activitie", catalog = "panyapiway_student_activitie")
public class InfoActivitie implements java.io.Serializable {

	private Long id;
	private Account account;
	private Duty duty;
	private Date createDate;
	private String hearder;
	private String detail;
	private Integer rewardMoney;
	private Integer rewardHours;
	private Date dateTimeStart;
	private Date dateTimeEnd;
	private String location;
	private String holderName;
	private String holderPhone;
	private Integer personCount;
	private Integer personLimit;
	private String status;
	private Set<InfoActivitieHasAccount> infoActivitieHasAccounts = new HashSet<InfoActivitieHasAccount>(0);

	public InfoActivitie() {
	}

	public InfoActivitie(Account account, Duty duty, String hearder, String detail, Date dateTimeStart,
			Date dateTimeEnd, String location, String holderName, String holderPhone) {
		this.account = account;
		this.duty = duty;
		this.hearder = hearder;
		this.detail = detail;
		this.dateTimeStart = dateTimeStart;
		this.dateTimeEnd = dateTimeEnd;
		this.location = location;
		this.holderName = holderName;
		this.holderPhone = holderPhone;
	}

	public InfoActivitie(Account account, Duty duty, Date createDate, String hearder, String detail,
			Integer rewardMoney, Integer rewardHours, Date dateTimeStart, Date dateTimeEnd, String location,
			String holderName, String holderPhone, Integer personCount, Integer personLimit, String status,
			Set<InfoActivitieHasAccount> infoActivitieHasAccounts) {
		this.account = account;
		this.duty = duty;
		this.createDate = createDate;
		this.hearder = hearder;
		this.detail = detail;
		this.rewardMoney = rewardMoney;
		this.rewardHours = rewardHours;
		this.dateTimeStart = dateTimeStart;
		this.dateTimeEnd = dateTimeEnd;
		this.location = location;
		this.holderName = holderName;
		this.holderPhone = holderPhone;
		this.personCount = personCount;
		this.personLimit = personLimit;
		this.status = status;
		this.infoActivitieHasAccounts = infoActivitieHasAccounts;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "id", unique = true, nullable = false)
	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "create_by_account_id", nullable = false)
	public Account getAccount() {
		return this.account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "duty_id", nullable = false)
	public Duty getDuty() {
		return this.duty;
	}

	public void setDuty(Duty duty) {
		this.duty = duty;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "create_date", length = 19)
	public Date getCreateDate() {
		return this.createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	@Column(name = "hearder", nullable = false, length = 60)
	public String getHearder() {
		return this.hearder;
	}

	public void setHearder(String hearder) {
		this.hearder = hearder;
	}

	@Column(name = "detail", nullable = false, length = 200)
	public String getDetail() {
		return this.detail;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}

	@Column(name = "reward_money")
	public Integer getRewardMoney() {
		return this.rewardMoney;
	}

	public void setRewardMoney(Integer rewardMoney) {
		this.rewardMoney = rewardMoney;
	}

	@Column(name = "reward_hours")
	public Integer getRewardHours() {
		return this.rewardHours;
	}

	public void setRewardHours(Integer rewardHours) {
		this.rewardHours = rewardHours;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "date_time_start", nullable = false, length = 19)
	public Date getDateTimeStart() {
		return this.dateTimeStart;
	}

	public void setDateTimeStart(Date dateTimeStart) {
		this.dateTimeStart = dateTimeStart;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "date_time_end", nullable = false, length = 19)
	public Date getDateTimeEnd() {
		return this.dateTimeEnd;
	}

	public void setDateTimeEnd(Date dateTimeEnd) {
		this.dateTimeEnd = dateTimeEnd;
	}

	@Column(name = "location", nullable = false, length = 200)
	public String getLocation() {
		return this.location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	@Column(name = "holder_name", nullable = false, length = 100)
	public String getHolderName() {
		return this.holderName;
	}

	public void setHolderName(String holderName) {
		this.holderName = holderName;
	}

	@Column(name = "holder_phone", nullable = false, length = 15)
	public String getHolderPhone() {
		return this.holderPhone;
	}

	public void setHolderPhone(String holderPhone) {
		this.holderPhone = holderPhone;
	}

	@Column(name = "person_count")
	public Integer getPersonCount() {
		return this.personCount;
	}

	public void setPersonCount(Integer personCount) {
		this.personCount = personCount;
	}

	@Column(name = "person_limit")
	public Integer getPersonLimit() {
		return this.personLimit;
	}

	public void setPersonLimit(Integer personLimit) {
		this.personLimit = personLimit;
	}

	@Column(name = "status", length = 20)
	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "infoActivitie")
	public Set<InfoActivitieHasAccount> getInfoActivitieHasAccounts() {
		return this.infoActivitieHasAccounts;
	}

	public void setInfoActivitieHasAccounts(Set<InfoActivitieHasAccount> infoActivitieHasAccounts) {
		this.infoActivitieHasAccounts = infoActivitieHasAccounts;
	}

}