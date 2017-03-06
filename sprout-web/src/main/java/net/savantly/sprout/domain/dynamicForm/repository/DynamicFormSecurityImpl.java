package net.savantly.sprout.domain.dynamicForm.repository;

import net.savantly.sprout.domain.dynamicForm.DynamicForm;
import net.savantly.sprout.security.AuditableSecurityAdapter;

public class DynamicFormSecurityImpl extends AuditableSecurityAdapter<DynamicForm, String> implements DynamicFormSecurity{

}
