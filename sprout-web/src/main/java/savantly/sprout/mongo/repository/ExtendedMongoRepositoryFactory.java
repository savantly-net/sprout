package savantly.sprout.mongo.repository;

import static org.springframework.data.querydsl.QueryDslUtils.QUERY_DSL_PRESENT;

import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.repository.support.MongoRepositoryFactory;
import org.springframework.data.mongodb.repository.support.QueryDslMongoRepository;
import org.springframework.data.mongodb.repository.support.SimpleMongoRepository;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;
import org.springframework.data.repository.core.RepositoryInformation;
import org.springframework.data.repository.core.RepositoryMetadata;

public class ExtendedMongoRepositoryFactory extends MongoRepositoryFactory{
	
	public ExtendedMongoRepositoryFactory(MongoOperations mongoOperations) {
		super(mongoOperations);
	}

	@Override
	protected Object getTargetRepository(RepositoryInformation metadata) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected Class<?> getRepositoryBaseClass(RepositoryMetadata metadata) {
		boolean isQueryDslRepository = QUERY_DSL_PRESENT
				&& QueryDslPredicateExecutor.class.isAssignableFrom(metadata.getRepositoryInterface());

		return isQueryDslRepository ? QueryDslMongoRepository.class : SimpleMongoRepository.class;
	}

}
