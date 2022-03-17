package alf.api.web.models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "roles")
public class Role {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	// @Enumerated(EnumType.STRING)
	@Column(length = 25)
	private String name;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "role", orphanRemoval = true)
	private List<RolePrivileges> privileges = new ArrayList<>();

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "role", orphanRemoval = true)
	private List<RoleBaseItemType> role_baseitemtypes = new ArrayList<>();

	public Role(long id, String name) {
		this.id = id;
		this.name = name;
	}

	public Role() {

	}

	public Role(String name) {
		this.name = name;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<RolePrivileges> getPrivileges() {
		return privileges;
	}

	public void setPrivileges(List<RolePrivileges> privileges) {
		this.privileges = privileges;
	}

	public List<RoleBaseItemType> getRole_baseitemtypes() {
		return role_baseitemtypes;
	}

	public void setRole_baseitemtypes(List<RoleBaseItemType> role_baseitemtypes) {
		this.role_baseitemtypes = role_baseitemtypes;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
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
		Role other = (Role) obj;

		if (name != other.name)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Role [id=" + id + ", name=" + name + "]";
	}

}