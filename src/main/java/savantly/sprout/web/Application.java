package savantly.sprout.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.ImportResource;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.core.SimpleMongoDbFactory;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import com.mongodb.MongoURI;

@EnableAutoConfiguration
@EnableMongoRepositories({ "savantly.sprout.repositories" })
// @EnableTransactionManagement
@ComponentScan(basePackages = { "savantly.sprout.web.controllers", "savantly.sprout.web.restControllers" })
@Import(WebSecurityConfig.class)
// @EntityScan("savantly.sprout.domain")
@ImportResource({ "classpath*:/spring/applicationContext.xml" })
public class Application {
	static final Logger log = LoggerFactory.getLogger(Application.class);
	
	@Value("${MONGOLAB_URI}")
	private String MONGO_URI;

	public static void main(String[] args) throws Exception {
		log.debug(String.format("PORT: ", System.getenv("PORT")));
		SpringApplication.run(Application.class, args);
	}

	/*
	 * Factory bean that creates the com.mongodb.Mongo instance
	 */
	public @Bean MongoDbFactory mongoDbFactory() throws Exception {
		return new SimpleMongoDbFactory(new MongoURI(MONGO_URI));
	}

	/*
	 * @Bean public DataSource dataSource() {
	 * 
	 * EmbeddedDatabaseBuilder builder = new EmbeddedDatabaseBuilder(); return
	 * builder.setType(EmbeddedDatabaseType.H2).build(); }
	 * 
	 * @Bean public EntityManagerFactory entityManagerFactory() {
	 * 
	 * HibernateJpaVendorAdapter vendorAdapter = new
	 * HibernateJpaVendorAdapter(); vendorAdapter.setGenerateDdl(true);
	 * 
	 * LocalContainerEntityManagerFactoryBean factory = new
	 * LocalContainerEntityManagerFactoryBean();
	 * factory.setJpaVendorAdapter(vendorAdapter);
	 * factory.setPackagesToScan("savantly.sprout.domain");
	 * factory.setDataSource(dataSource()); factory.afterPropertiesSet();
	 * 
	 * return factory.getObject(); }
	 * 
	 * @Bean public PlatformTransactionManager transactionManager() {
	 * 
	 * JpaTransactionManager txManager = new JpaTransactionManager();
	 * txManager.setEntityManagerFactory(entityManagerFactory()); return
	 * txManager; }
	 */

}
