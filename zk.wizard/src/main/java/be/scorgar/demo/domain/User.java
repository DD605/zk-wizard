package be.scorgar.demo.domain;

import java.util.Set;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="T_USER")
public class User {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long sid;

	@ManyToOne
	@JoinColumn(name="PERS_ID")
	private Person person;

	@ElementCollection(targetClass = Role.class, fetch=FetchType.EAGER)
	@Enumerated(EnumType.STRING)
	@CollectionTable(name="T_USER_ROLE", joinColumns=@JoinColumn(name="USER_ID", referencedColumnName="SID"))
	@Column(name="ROLE")
	private Set<Role> roles;

	private String account;

	public Person getPerson() {
		return person;
	}
	public void setPerson(Person person) {
		this.person = person;
	}
	public Set<Role> getRoles() {
		return roles;
	}
	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((account == null) ? 0 : account.hashCode());
		result = prime * result + ((sid == null) ? 0 : sid.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		User other = (User) obj;
		if (account == null) {
			if (other.account != null) {
				return false;
			}
		} else if (!account.equals(other.account)) {
			return false;
		}
		if (sid == null) {
			if (other.sid != null) {
				return false;
			}
		} else if (!sid.equals(other.sid)) {
			return false;
		}
		return true;
	}
	@Override
	public String toString() {
		return new StringBuilder(account).append(" (").append(person.toString()).append(") : ").append(null==roles?"[no roles]":roles.toString()).toString();
	}
}
