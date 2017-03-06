package net.savantly.sprout.web.configuration;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.mongo.MongoProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.core.env.Environment;
import org.springframework.data.mongodb.config.EnableMongoAuditing;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import com.mongodb.Mongo;
import com.mongodb.MongoClientOptions;

import net.savantly.sprout.mongo.repository.ExtendedMongoRepositoryImpl;

@Configuration
@EnableMongoRepositories(
		basePackages = MongoConfiguration.MONGO_REPOSITORIES_BASE_PACKAGE,
		repositoryBaseClass= ExtendedMongoRepositoryImpl.class)
@EnableMongoAuditing
public class MongoConfiguration {
	
	final static String MONGO_REPOSITORIES_BASE_PACKAGE = "savantly.sprout.**.repository" ;
	
    @Autowired
    private MongoProperties properties;
	@Autowired(required = false)
	private MongoClientOptions options;    
	@Autowired
    Environment environment;

	@Bean(destroyMethod = "close", name="mongo")
	@Profile("production")
	public Mongo mongo() throws Exception {
		return properties.createMongoClient(this.options, environment);
	}
	
/*	@Bean
	@Primary
	public MongoTemplate mongoTemplateBean() throws Exception{
		return this.mongoTemplate();
	}*/
	


	private <T> List<T> singletonList(T object) {
		ArrayList<T> returnList = new ArrayList<T>(1);
		returnList.add(object);
		return returnList;
	}
}