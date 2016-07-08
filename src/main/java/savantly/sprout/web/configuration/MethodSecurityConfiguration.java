package savantly.sprout.web.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.access.PermissionEvaluator;

import savantly.sprout.domain.dynamicForm.repository.DynamicFormSecurity;
import savantly.sprout.domain.dynamicForm.repository.DynamicFormSecurityImpl;
import savantly.sprout.domain.organization.security.OrganizationSecurity;
import savantly.sprout.domain.organization.security.OrganizationSecurityImpl;
import savantly.sprout.domain.report.security.UserActivitySecurity;
import savantly.sprout.domain.report.security.UserActivitySecurityImpl;
import savantly.sprout.domain.tree.security.TreeSecurity;
import savantly.sprout.domain.tree.security.TreeSecurityImpl;
import savantly.sprout.domain.user.security.UserSecurity;
import savantly.sprout.domain.user.security.UserSecurityImpl;
import savantly.sprout.security.SproutPermissionEvaluator;

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
    public UserActivitySecurity userActivitySecurity() {
        return new UserActivitySecurityImpl();
    }
    
    public static class PermissionEvaluationConfiguration{
        @Bean
        public PermissionEvaluator permissionEvaluator(){
        	return new SproutPermissionEvaluator();
        }
    }
}