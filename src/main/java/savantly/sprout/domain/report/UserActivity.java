package savantly.sprout.domain.report;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;

import savantly.sprout.domain.StringPair;
import savantly.sprout.domain.dynamicForm.DynamicForm;
import savantly.sprout.domain.tree.Tree;
import savantly.sprout.security.AbstractAuditableDomainObject;

public class UserActivity extends AbstractAuditableDomainObject<String> {

	private static final long serialVersionUID = 616735134123056810L;
	
	@Id
	private String id;
	@DBRef
	private Tree tree;
	@DBRef
	private DynamicForm form;
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

	public Tree getTree() {
		return tree;
	}

	public void setTree(Tree tree) {
		this.tree = tree;
	}

	public DynamicForm getForm() {
		return form;
	}

	public void setForm(DynamicForm form) {
		this.form = form;
	}

}
