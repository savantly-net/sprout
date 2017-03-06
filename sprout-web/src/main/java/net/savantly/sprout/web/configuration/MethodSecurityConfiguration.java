package net.savantly.sprout.web.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.access.PermissionEvaluator;

import net.savantly.sprout.domain.activity.security.ActivitySecurity;
import net.savantly.sprout.domain.activity.security.ActivitySecurityImpl;
import net.savantly.sprout.domain.dynamicForm.repository.DynamicFormSecurity;
import net.savantly.sprout.domain.dynamicForm.repository.DynamicFormSecurityImpl;
import net.savantly.sprout.domain.organization.security.OrganizationSecurity;
import net.savantly.sprout.domain.organization.security.OrganizationSecurityImpl;
import net.savantly.sprout.domain.tree.security.TreeSecurity;
import net.savantly.sprout.domain.tree.security.TreeSecurityImpl;
import net.savantly.sprout.domain.user.security.UserSecurity;
import net.savantly.sprout.domain.user.security.UserSecurityImpl;
import net.savantly.sprout.security.SproutPermissionEvaluator;

@Configuration
public class MethodSecurityConfiguration  {
	
    @Bean
    public DynamicFormSecurity dynamicFormSecurity() {
        return new DynamicFormSecurityImpl();
    }
    
    @Bean
    public OrganizationSecurity organizationSecurity() {
        return new OrganizationSecurityImpl();
    }
    
    @Bean
    public TreeSecurity treeSecurity() {
        return new TreeSecurityImpl();
    }
    
    @Bean
    public UserSecurity userSecurity() {
        return new UserSecurityImpl();
    }
    
    @Bean
    public ActivitySecurity userActivitySecurity() {
        return new ActivitySecurityImpl();
    }
    
    public static class PermissionEvaluationConfiguration{
        @Bean
        public PermissionEvaluator permissionEvaluator(){
        	return new SproutPermissionEvaluator();
        }
    }
}