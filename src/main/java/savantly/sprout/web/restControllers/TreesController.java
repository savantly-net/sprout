package savantly.sprout.web.restControllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/trees")
public class TreesController {
	
	@RequestMapping(value="/", method={RequestMethod.POST})
    public String index() {
        return "Greetings from Spring Boot!";
    }

}
