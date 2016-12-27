package savantly.sprout.security;

public interface CrudSecurity<T> {
	
	boolean canList();
	boolean canCreate(T t);
	boolean canUpdate(T t);
	boolean canDelete(T t);
}
