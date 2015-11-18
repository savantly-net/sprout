package savantly.sprout.web.controllers;

import java.io.IOException;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
	static final Logger log = LoggerFactory.getLogger(HomeController.class);

	@RequestMapping("/")
	public String index(Model model) throws IOException {

		List<String> resourceArray = new ArrayList<String>();

		getResourcePaths("classpath:/public/modules/*/*.js", resourceArray);
		getResourcePaths("classpath:/public/modules/*/config/*.js", resourceArray);
		getResourcePaths("classpath:/public/modules/*/controllers/*.js", resourceArray);
		getResourcePaths("classpath:/public/modules/*/services/*.js", resourceArray);

		model.addAttribute("moduleResources", resourceArray);

		List<String> cssResourceArray = new ArrayList<String>();
		getResourcePaths("classpath:/public/modules/*/css/*.css", cssResourceArray);
		model.addAttribute("moduleCSSResources", cssResourceArray);

		model.addAttribute("firstName", "Jeremy");
		model.addAttribute("lastName", "Branham");
		return "index";
	}

	private List<String> getResourcePaths(String pattern, List<String> resourceArray) {
		log.info(String.format("Finding embedded resource paths for: %s", pattern));
		PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
		try {
			Resource[] moduleResources = resolver.getResources(pattern);
			for (Resource resource : moduleResources) {
				log.info(String.format("Processing resource: %s", resource));
				URI resourceURI = resource.getURI();
				log.info(String.format("Found resource URI: %s", resourceURI));
				String fullPath = resourceURI.getPath();
				resourceArray.add(truncateBeginningOfPath(fullPath, "/public/"));
			}
		} catch (IOException e) {
			log.info(String.format("Error processing resources for pattern: %s", pattern));
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
