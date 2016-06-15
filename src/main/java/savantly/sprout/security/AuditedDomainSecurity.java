package savantly.sprout.security;

import java.io.Serializable;

import org.springframework.data.domain.Auditable;

import savantly.sprout.domain.SproutUser;

public interface AuditedDomainSecurity<T extends Auditable<SproutUser, ID>, ID extends Serializable> extends RepositorySecurity<T>{


}
