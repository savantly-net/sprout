package net.savantly.sprout.domain.activity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import net.savantly.sprout.domain.StringPair;
import net.savantly.sprout.security.AbstractAuditableDomainObject;

@Document(collection="activity")
public class Activity extends AbstractAuditableDomainObject<String> {

	private static final long serialVersionUID = 616735134123056810L;
	
	@Id
	private String id;
	private String treeId;
	private String formId;
	private StringPair[] questionAnswers;
	private StringPair[] formAnswers;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public StringPair[] getQuestionAnswers() {
		return questionAnswers;
	}

	public void setQuestionAnswers(StringPair[] questionAnswers) {
		this.questionAnswers = questionAnswers;
	}

	public StringPair[] getFormAnswers() {
		return formAnswers;
	}

	public void setFormAnswers(StringPair[] formAnswers) {
		this.formAnswers = formAnswers;
	}

	public String getTreeId() {
		return treeId;
	}

	public void setTreeId(String treeId) {
		this.treeId = treeId;
	}

	public String getFormId() {
		return formId;
	}

	public void setFormId(String formId) {
		this.formId = formId;
	}

}
