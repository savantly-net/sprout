package net.savantly.sprout.domain.dynamicForm;

import com.fasterxml.jackson.annotation.JsonProperty;

public class DynamicFormFieldOption {

	@JsonProperty("option_id")
	private int id;
	@JsonProperty("option_title")
	private String title;
	@JsonProperty("option_value")
	private String value;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
}
