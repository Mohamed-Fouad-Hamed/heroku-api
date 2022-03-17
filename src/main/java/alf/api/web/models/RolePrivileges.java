package alf.api.web.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "role_privileges")
public class RolePrivileges {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	private long id = 0;

	@Column(name = "menu_privilege_id", nullable = false)
	private long menuPrivilegeId = 0;

	@Column(name = "allow")
	private boolean allow = false;

	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	@JoinColumn(name = "role_id")
	@JsonIgnore
	private Role role;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getMenuPrivilegeId() {
		return menuPrivilegeId;
	}

	public void setMenuPrivilegeId(long menuPrivilegeId) {
		this.menuPrivilegeId = menuPrivilegeId;
	}

	public boolean isAllow() {
		return allow;
	}

	public void setAllow(boolean allow) {
		this.allow = allow;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (allow ? 1231 : 1237);
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result + (int) (menuPrivilegeId ^ (menuPrivilegeId >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		RolePrivileges other = (RolePrivileges) obj;
		if (allow != other.allow)
			return false;
		if (id != other.id)
			return false;
		if (menuPrivilegeId != other.menuPrivilegeId)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "RolePrivileges [id=" + id + ", menuPrivilegeId=" + menuPrivilegeId + ", allow=" + allow + ", role="
				+ role + "]";
	}

}
