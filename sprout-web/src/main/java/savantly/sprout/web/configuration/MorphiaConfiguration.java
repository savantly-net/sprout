package savantly.sprout.web.configuration;

import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.Morphia;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.mongodb.MongoClient;

@Configuration
public class MorphiaConfiguration {
	@Bean
	@Autowired
	public Datastore datastore(Morphia morphia, MongoClient client){
		Datastore ds = morphia.createDatastore(client, client.listDatabaseNames().first());
		return ds;
	}
	
	@Bean
	@Autowired
	public Morphia morphia(){
		Morphia morphia = new Morphia();
		morphia.mapPackage(MongoConfiguration.MONGO_REPOSITORIES_BASE_PACKAGE);
		return morphia;
	}
}
