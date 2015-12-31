package savantly.sprout.web.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.access.expression.method.DefaultMethodSecurityExpressionHandler;
import org.springframework.security.access.expression.method.MethodSecurityExpressionHandler;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.method.configuration.GlobalMethodSecurityConfiguration;

import savantly.sprout.web.security.MethodSecurityService;
import savantly.sprout.web.security.MethodSecurityServiceImpl;
import savantly.sprout.web.security.SproutPermissionEvaluator;

@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class MethodSecurityConfiguration extends GlobalMethodSecurityConfiguration {
	
/*    @Autowired
    private AuthenticationManager am;

    @Override
    protected AuthenticationManager authenticationManager() {
        return am;
    }
    @Override
    protected MethodSecurityExpressionHandler createExpressionHandler() {
    	DefaultMethodSecurityExpressionHandler expressionHandler = new DefaultMethodSecurityExpressionHandler();
        expressionHandler.setPermissionEvaluator(new SproutPermissionEvaluator());
        return expressionHandler;
    }
    
    @Bean
    public MethodSecurityService methodSecurityService() {
        return new MethodSecurityServiceImpl();
    }*/
}