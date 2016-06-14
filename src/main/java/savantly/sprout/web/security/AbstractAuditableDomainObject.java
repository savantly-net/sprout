package savantly.sprout.web.security;

import java.io.Serializable;

import javax.persistence.MappedSuperclass;

import org.joda.time.DateTime;
import org.mongodb.morphia.annotations.Entity;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.domain.Auditable;
import org.springframework.data.mongodb.core.mapping.DBRef;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import savantly.sprout.domain.SproutUser;

@Entity
@MappedSuperclass
@JsonIgnoreProperties(value={ 
		"createdDate",
		"createdBy", 
		"lastModifiedDate", 
		"lastModifiedBy" }, allowGetters=true)
public abstract class AbstractAuditableDomainObject<ID extends Serializable> implements Auditable<SproutUser, ID> {

	private static final long serialVersionUID = -6599910493211110333L;

	// Auditing Metadata
	@CreatedDate
	private DateTime createdDate;
	@DBRef
	@CreatedBy
	private SproutUser createdBy;
	@LastModifiedDate
	private DateTime lastModifiedDate;
	@DBRef
	@LastModifiedBy
	private SproutUser lastModifiedBy;

	public DateTime getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(DateTime createdDate) {
		this.createdDate = createdDate;
	}

	public SproutUser getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(SproutUser createdBy) {
		this.createdBy = createdBy;
	}

	public DateTime getLastModifiedDate() {
		return lastModifiedDate;
	}

	public void setLastModifiedDate(DateTime lastModifiedDate) {
		this.lastModifiedDate = lastModifiedDate;
	}

	public SproutUser getLastModifiedBy() {
		return lastModifiedBy;
	}

	public void setLastModifiedBy(SproutUser lastModifiedBy) {
		this.lastModifiedBy = lastModifiedBy;
	}

	public boolean isNew() {
		return (createdDate == null || createdBy == null);
	}
}
