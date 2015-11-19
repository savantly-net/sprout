package savantly.sprout.web;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import com.mongodb.Mongo;
import com.mongodb.MongoClient;
import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;

@Configuration
@EnableMongoRepositories({ "savantly.sprout.repositories" })
public class MongoConfiguration extends AbstractMongoConfiguration {

	@Value("${MONGO_HOST}")
	private String MONGO_HOST;
	@Value("${MONGO_DATABASE}")
	private String MONGO_DATABASE;
	@Value("${MONGO_PORT}")
	private int MONGO_PORT;
	@Value("${MONGO_USERNAME:}")
	private String MONGO_USERNAME;
	@Value("${MONGO_PASSWORD:}")
	private String MONGO_PASSWORD;
	@Value("${MONGO_USERDB}")
	private String MONGO_USERDB;

	@Override
	protected String getDatabaseName() {
		return MONGO_DATABASE;
	}

	@Override
	@Bean
	public Mongo mongo() throws Exception {
		if(!MONGO_USERNAME.isEmpty()){
			return new MongoClient(singletonList(new ServerAddress(MONGO_HOST, MONGO_PORT)),
					singletonList(MongoCredential.createCredential(MONGO_USERNAME, MONGO_USERDB, MONGO_PASSWORD.toCharArray())));
		}
		else{
			return new MongoClient(new ServerAddress(MONGO_HOST, MONGO_PORT));
		}
	}

	private <T> List<T> singletonList(T object) {
		ArrayList<T> returnList = new ArrayList<T>(1);
		returnList.add(object);
		return returnList;
	}
}