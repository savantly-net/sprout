package savantly.sprout.repositories;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.data.mongodb.repository.query.MongoEntityInformation;
import org.springframework.data.mongodb.repository.support.QueryDslMongoRepository;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ExtendedMongoRepositoryImpl<T, ID extends Serializable> extends QueryDslMongoRepository<T, ID>
		implements ExtendedMongoRepository<T, ID> {

	private Class<T> clazz;
	private MongoOperations mongoOperations;
	@SuppressWarnings("unused")
	private MongoEntityInformation<T, ID> metadata;
	
	public ExtendedMongoRepositoryImpl(MongoEntityInformation<T, ID> metadata, MongoOperations mongoOperations) {
		super(metadata, mongoOperations);
		this.mongoOperations = mongoOperations;
		this.clazz = metadata.getJavaType();
		this.metadata = metadata;
	}

	protected Query getByIdQuery(ID id) {
		return new Query(Criteria.where("_id").is(id));
	}

	/**
	 * Partial object update
	 * Skips null fields
	 * 
	 * @param entity
	 * @param id
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public T updatePartial(T entity, ID id) {

		ObjectMapper objectMapper = new ObjectMapper();
		// exclude null
		objectMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
		Map<String, Object> objectAsMap = objectMapper.convertValue(entity, Map.class);
		// exclude id
		objectAsMap.remove("id");
		// 
		//objectAsMap.remove(metadata.getIdAttribute());
		// exclude new
		objectAsMap.remove("new");

		// add fields to update
		Update u = new Update();
		for (Map.Entry<String, Object> e : objectAsMap.entrySet()) {
			u.set(e.getKey(), e.getValue());
		}

		mongoOperations.updateFirst(getByIdQuery(id), u, clazz);

		return mongoOperations.findById(id, clazz);

	}

	@Override
	public Page<T> query(Query query, Pageable pageable) {
		List<T> list =  mongoOperations.find(query.with(pageable), clazz);
		return new PageImpl<T>(list, pageable, list.size());
	}
}