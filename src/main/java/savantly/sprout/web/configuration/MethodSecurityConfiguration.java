package savantly.sprout.web.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.access.PermissionEvaluator;

import savantly.sprout.security.DynamicFormSecurity;
import savantly.sprout.security.DynamicFormSecurityImpl;
import savantly.sprout.security.OrganizationSecurity;
import savantly.sprout.security.OrganizationSecurityImpl;
import savantly.sprout.security.SproutPermissionEvaluator;
import savantly.sprout.security.TreeSecurity;
import savantly.sprout.security.TreeSecurityImpl;
import savantly.sprout.security.UserActivitySecurity;
import savantly.sprout.security.UserActivitySecurityImpl;
import savantly.sprout.security.UserSecurity;
import savantly.sprout.security.UserSecurityImpl;

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