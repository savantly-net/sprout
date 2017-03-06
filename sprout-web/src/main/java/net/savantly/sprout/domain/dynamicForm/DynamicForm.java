package net.savantly.sprout.domain.dynamicForm;

import java.util.List;

import org.springframework.data.annotation.Id;

import com.fasterxml.jackson.annotation.JsonProperty;

import net.savantly.sprout.security.AbstractAuditableDomainObject;

public class DynamicForm extends AbstractAuditableDomainObject<String>{
	
	private static final long serialVersionUID = 7179856640502754018L;
	
	@Id
	@JsonProperty("form_id")
	private String id;
	@JsonProperty("form_name")
	private String name;
	@JsonProperty("form_fields")
	private List<DynamicFormField> formFields;
	private boolean submitted;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<DynamicFormField> getFormFields() {
		return formFields;
	}
	public void setFormFields(List<DynamicFormField> formFields) {
		this.formFields = formFields;
	}
	public boolean isSubmitted() {
		return submitted;
	}
	public void setSubmitted(boolean submitted) {
		this.submitted = submitted;
	}
	
}
