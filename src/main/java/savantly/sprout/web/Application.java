package savantly.sprout.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
/*@EnableAutoConfiguration*/
/*@ComponentScan(basePackages = {"savantly.sprout.web"})*/
/*@ComponentScan(basePackages = {
		"savantly.sprout.web.controllers", 
		"savantly.sprout.web.restControllers", 
		"savantly.sprout.web.security"})*/
/*@Import({
	WebSecurityConfig.class, 
	MongoConfiguration.class, 
	AuthenticationManagerConfiguration.class,
	MvcConfiguration.class,
	MethodSecurityConfiguration.class})*/
/*@ImportResource({ "classpath*:/spring/applicationContext.xml" })*/
public class Application {

	public static void main(String[] args) throws Exception {
		SpringApplication.run(Application.class, args);
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
