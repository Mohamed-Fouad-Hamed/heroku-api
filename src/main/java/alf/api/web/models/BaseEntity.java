package alf.api.web.models;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import alf.api.web.by.CreatedBy;
import alf.api.web.by.ModifiedBy;

@MappedSuperclass
public abstract class BaseEntity<U> {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;

	@CreationTimestamp
	@Column(name = "created", updatable = false)
	protected LocalDateTime created;

	@UpdateTimestamp
	protected LocalDateTime lastModified;

	@CreatedBy
	@Column(name = "createdBy", updatable = false)
	protected U createdBy;

	@ModifiedBy
	protected U lastModifiedBy;

	@Column(name = "deleted")
	private boolean deleted = false;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public boolean isDeleted() {
		return deleted;
	}

	public void setDeleted(boolean deleted) {
		this.deleted = deleted;
	}

}
