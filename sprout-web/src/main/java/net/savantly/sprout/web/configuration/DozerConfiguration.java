package net.savantly.sprout.web.configuration;

import java.util.List;

import org.dozer.DozerBeanMapper;
import org.dozer.loader.api.BeanMappingBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DozerConfiguration {
	
	@Autowired(required=false)
	List<BeanMappingBuilder> builders;
	
	public DozerBeanMapper dozerBeanMapper(){
		DozerBeanMapper mapper = new DozerBeanMapper();
		for (BeanMappingBuilder beanMappingBuilder : builders) {
			mapper.addMapping(beanMappingBuilder);
		}
		return mapper;
	}

}
