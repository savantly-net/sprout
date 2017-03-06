package net.savantly.sprout.security;

import java.io.Serializable;

public interface AuditedDomainSecurity<T extends SproutAuditable<ID>, ID extends Serializable> extends RepositorySecurity<T>{


}
