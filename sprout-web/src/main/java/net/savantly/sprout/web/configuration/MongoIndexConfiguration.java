package net.savantly.sprout.web.configuration;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.index.TextIndexDefinition;
import org.springframework.data.mongodb.core.index.TextIndexDefinition.TextIndexDefinitionBuilder;

import net.savantly.sprout.domain.tree.Tree;

@Configuration
public class MongoIndexConfiguration implements InitializingBean{
	
	@Autowired
	MongoTemplate template;

	private void buildTreeTextIndex() {
		TextIndexDefinition textIndex = new TextIndexDefinitionBuilder()
				  .onField("name", 2F)
				  .onField("description")
				  .build();

				template.indexOps(Tree.class).ensureIndex(textIndex);
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		buildTreeTextIndex();
	}
}
