package PIM.WEBSERIVE.ACTIVITIE.STUDENT.Model;
// default package
// Generated 22 �.�. 2561, 22:56:21 by Hibernate Tools 4.3.5.Final

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * MessageHasAccountId generated by hbm2java
 */
@Embeddable
public class MessageHasAccountId implements java.io.Serializable {

	private long messageId;
	private long accountId;

	public MessageHasAccountId() {
	}

	public MessageHasAccountId(long messageId, long accountId) {
		this.messageId = messageId;
		this.accountId = accountId;
	}

	@Column(name = "message_id", nullable = false)
	public long getMessageId() {
		return this.messageId;
	}

	public void setMessageId(long messageId) {
		this.messageId = messageId;
	}

	@Column(name = "account_id", nullable = false)
	public long getAccountId() {
		return this.accountId;
	}

	public void setAccountId(long accountId) {
		this.accountId = accountId;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof MessageHasAccountId))
			return false;
		MessageHasAccountId castOther = (MessageHasAccountId) other;

		return (this.getMessageId() == castOther.getMessageId()) && (this.getAccountId() == castOther.getAccountId());
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + (int) this.getMessageId();
		result = 37 * result + (int) this.getAccountId();
		return result;
	}

}
