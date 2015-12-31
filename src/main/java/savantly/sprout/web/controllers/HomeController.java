package savantly.sprout.web.controllers;

import java.io.IOException;
import java.net.URI;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.security.authentication.AuthenticationTrustResolverImpl;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.expression.WebSecurityExpressionRoot;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import savantly.sprout.domain.SproutUser;

@Controller
public class HomeController {
	static final Logger log = LoggerFactory.getLogger(HomeController.class);

	@RequestMapping("/")
	public String index(Model model, HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		ServletRequest req = (ServletRequest) request;
        ServletResponse resp = (ServletResponse) response;
        FilterInvocation filterInvocation = new FilterInvocation(req, resp, new FilterChain()
        {
            public void doFilter(ServletRequest request, ServletResponse response) throws IOException, ServletException
            {
                throw new UnsupportedOperationException();
            }
        });
		
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null)
        {
        	if(authentication.getPrincipal() instanceof SproutUser){
        		((SproutUser)authentication.getPrincipal()).eraseCredentials();
        	}
            WebSecurityExpressionRoot sec = new WebSecurityExpressionRoot(authentication, filterInvocation);
            sec.setTrustResolver(new AuthenticationTrustResolverImpl());
            model.addAttribute("security", sec);
        }

		List<String> resourceArray = new ArrayList<String>();

		getResourcePaths("classpath:/public/modules/*/*.js", resourceArray);
		getResourcePaths("classpath:/public/modules/*/config/*.js", resourceArray);
		getResourcePaths("classpath:/public/modules/*/controllers/*.js", resourceArray);
		getResourcePaths("classpath:/public/modules/*/services/*.js", resourceArray);
		getResourcePaths("classpath:/public/modules/*/directives/*.js", resourceArray);

		model.addAttribute("moduleResources", resourceArray);

		List<String> cssResourceArray = new ArrayList<String>();
		getResourcePaths("classpath:/public/modules/*/css/*.css", cssResourceArray);
		model.addAttribute("moduleCSSResources", cssResourceArray);

		return "index";
	}

	private List<String> getResourcePaths(String pattern, List<String> resourceArray) {
		log.info(String.format("Finding embedded resource paths for: %s", pattern));
		PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
		try {
			Resource[] moduleResources = resolver.getResources(pattern);
			for (Resource resource : moduleResources) {
				log.debug(String.format("Processing resource: %s", resource));
				
				URL resourceURL = resource.getURL();
				log.debug(String.format("Found resource URL: %s", resourceURL));
				resourceArray.add(truncateBeginningOfPath(resourceURL.getPath(), "/public/"));
			}
		} catch (IOException e) {
			log.error(String.format("Error processing resources for pattern: %s", pattern));
		}
		return resourceArray;
	}

	private String truncateBeginningOfPath(String fullPath, String stringToMatch) {
		if (fullPath == null || fullPath.length() == 0) {
			throw new RuntimeException("fullPath is null or empty.");
		}
		if (stringToMatch == null || stringToMatch.length() == 0) {
			throw new RuntimeException("stringToMatch is null or empty.");
		}
		int matchIndex = fullPath.indexOf(stringToMatch);
		int splitIndex = matchIndex + stringToMatch.length();
		if (matchIndex == -1) {
			return fullPath;
		} else {
			return fullPath.substring(splitIndex);
		}
	}

}
