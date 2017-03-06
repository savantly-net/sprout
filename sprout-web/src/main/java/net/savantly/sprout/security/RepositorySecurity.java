package net.savantly.sprout.security;

import java.util.List;

import org.springframework.data.domain.Page;

public interface RepositorySecurity<T> extends CrudSecurity<T>{
	
	T filter(T t);
	Page<T> filter(Page<T> page);
	List<T> filter(List<T> list);

}
