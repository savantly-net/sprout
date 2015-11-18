package savantly.sprout.web;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.authentication.UserCredentials;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoDbFactory;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import com.mongodb.Mongo;

@Configuration
@EnableMongoRepositories({ "savantly.sprout.repositories" })
public class MongoConfiguration {

	@Value("${MONGO_HOST:localhost}")
	private String MONGO_HOST;
	@Value("${MONGO_DATABASE:sprout}")
	private String MONGO_DATABASE;
	@Value("${MONGO_PORT:27017}")
	private int MONGO_PORT;
	@Value("${MONGO_USERAME:}")
	private String MONGO_USERAME;
	@Value("${MONGO_PASSWORD:}")
	private String MONGO_PASSWORD;
	
	@SuppressWarnings("deprecation")
	@Bean
	public MongoDbFactory mongoDbFactory() throws Exception {
		UserCredentials userCredentials = new UserCredentials(MONGO_USERAME, MONGO_PASSWORD);
		return new SimpleMongoDbFactory(new Mongo(MONGO_HOST, MONGO_PORT), MONGO_DATABASE, userCredentials);
	}

	@Bean
	public MongoTemplate mongoTemplate() throws Exception {
		return new MongoTemplate(mongoDbFactory());
	}
}