package net.savantly.sprout.web.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.joda.JodaModule;

@Configuration
public class JacksonConfiguration {

    @Bean
    @Primary
    public Jackson2ObjectMapperBuilder  objectMapper() {
    	Jackson2ObjectMapperBuilder builder = new Jackson2ObjectMapperBuilder();
        builder.serializationInclusion(Include.NON_NULL);
        builder.failOnUnknownProperties(false);
        builder.featuresToEnable(
        		SerializationFeature.WRITE_DATES_AS_TIMESTAMPS,
        		MapperFeature.DEFAULT_VIEW_INCLUSION);
        builder.modules(new JodaModule());
        builder.indentOutput(true);

        return builder;
    }
}