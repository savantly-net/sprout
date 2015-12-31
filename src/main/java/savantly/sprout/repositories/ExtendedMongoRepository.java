package savantly.sprout.repositories;

import java.io.Serializable;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface ExtendedMongoRepository<T, ID extends Serializable> extends MongoRepository<T, ID>{

  /**
   * Partial object update
   * @param entity
   * @param id
   * @return
   */
  public T updatePartial(T entity, ID id);

}