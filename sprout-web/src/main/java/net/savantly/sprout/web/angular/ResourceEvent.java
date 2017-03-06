package net.savantly.sprout.web.angular;

public class ResourceEvent<T> {

	T entity;
	boolean handled;
	
	public ResourceEvent(T entity, boolean handled) {
		this.entity = entity;
		this.handled = handled;
	}
	public T getEntity() {
		return entity;
	}
	public void setEntity(T entity) {
		this.entity = entity;
	}
	public boolean isHandled() {
		return handled;
	}
	public void setHandled(boolean handled) {
		this.handled = handled;
	}
}
