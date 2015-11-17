package savantly.sprout.web.angular;

import java.io.Serializable;
import java.util.List;

import javax.validation.Valid;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

public class ResourceController<T, ID extends Serializable> {
 private MongoRepository<T, ID> entityRepository;
 
 public ResourceController(MongoRepository<T, ID> entityRepository) {
  this.entityRepository = entityRepository;
 }

 @RequestMapping(method=RequestMethod.POST)
 public T create(@RequestBody @Valid T model) {
  return (T) this.entityRepository.save(model);
 }

 @RequestMapping(method=RequestMethod.GET)
 public List<T> list() {
  return this.entityRepository.findAll();
 }

 @RequestMapping(value="/{id}", method=RequestMethod.GET)
 public T get(@PathVariable("id") ID id) {
  return this.entityRepository.findOne(id);
 }
 
 @RequestMapping(value="/{id}", method=RequestMethod.PUT)
 public T update(@PathVariable("id") ID id, @RequestBody @Valid T model) {
  return (T) entityRepository.save(model);
 }
 
 @RequestMapping(value="/{id}", method=RequestMethod.DELETE)
 public ResponseEntity<Boolean> delete(@PathVariable("id") ID id) {
  this.entityRepository.delete(id);
  return new ResponseEntity<Boolean>(Boolean.TRUE, HttpStatus.OK);
 }
}