package net.savantly.sprout.web.configuration;

import java.io.IOException;

import org.springframework.boot.autoconfigure.mongo.MongoProperties;
import org.springframework.boot.autoconfigure.mongo.embedded.EmbeddedMongoAutoConfiguration;
import org.springframework.boot.autoconfigure.mongo.embedded.EmbeddedMongoProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.Profile;

import de.flapdoodle.embed.mongo.config.IMongoCmdOptions;
import de.flapdoodle.embed.mongo.config.IMongodConfig;
import de.flapdoodle.embed.mongo.config.MongoCmdOptionsBuilder;
import de.flapdoodle.embed.mongo.config.MongodConfigBuilder;
import de.flapdoodle.embed.mongo.distribution.Version;

@Configuration
@Profile("embedded")
@EnableConfigurationProperties(value={MongoProperties.class, EmbeddedMongoProperties.class})
@Import(EmbeddedMongoAutoConfiguration.class)
public class EmbeddedMongoConfiguration {

	private IMongoCmdOptions cmdOptions = new MongoCmdOptionsBuilder().useStorageEngine("mmapv1").build();

    @Bean
    public IMongodConfig mongodConfig() throws IOException {
        return new MongodConfigBuilder()
        		.version(Version.Main.PRODUCTION)
        		.cmdOptions(cmdOptions )
        		.build();
    }

}
