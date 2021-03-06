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
 * Message generated by hbm2java
 */
@Entity
@Table(name = "message", catalog = "panyapiway_student_activitie")
public class Message implements java.io.Serializable {

	private Long id;
	private Account account;
	private Date createDate;
	private String header;
	private String body;
	private Set<MessageHasAccount> messageHasAccounts = new HashSet<MessageHasAccount>(0);

	public Message() {
	}

	public Message(Account account, String header, String body) {
		this.account = account;
		this.header = header;
		this.body = body;
	}

	public Message(Account account, Date createDate, String header, String body,
			Set<MessageHasAccount> messageHasAccounts) {
		this.account = account;
		this.createDate = createDate;
		this.header = header;
		this.body = body;
		this.messageHasAccounts = messageHasAccounts;
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

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "create_date", length = 19)
	public Date getCreateDate() {
		return this.createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	@Column(name = "header", nullable = false, length = 60)
	public String getHeader() {
		return this.header;
	}

	public void setHeader(String header) {
		this.header = header;
	}

	@Column(name = "body", nullable = false, length = 200)
	public String getBody() {
		return this.body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "message")
	public Set<MessageHasAccount> getMessageHasAccounts() {
		return this.messageHasAccounts;
	}

	public void setMessageHasAccounts(Set<MessageHasAccount> messageHasAccounts) {
		this.messageHasAccounts = messageHasAccounts;
	}

}
