package savantly.sprout.domain;

import java.util.List;

import javax.persistence.Transient;

import org.springframework.data.annotation.Id;

import com.fasterxml.jackson.annotation.JsonProperty;

public class DynamicFormField {
	
	@Id
	@JsonProperty("field_id")
	private String id;
	@JsonProperty("field_title")
	private String title;
	@JsonProperty("field_type")
	private String type;
	@JsonProperty("field_value")
	@Transient
	private String value;
	@JsonProperty("field_required")
	private boolean required;
	@JsonProperty("field_disabled")
	private boolean disabled;
	@JsonProperty("field_options")
	private List<DynamicFormFieldOption> options;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	public boolean isRequired() {
		return required;
	}
	public void setRequired(boolean required) {
		this.required = required;
	}
	public boolean isDisabled() {
		return disabled;
	}
	public void setDisabled(boolean disabled) {
		this.disabled = disabled;
	}
}
