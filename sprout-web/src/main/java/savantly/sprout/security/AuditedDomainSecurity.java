package savantly.sprout.security;

import java.io.Serializable;

import net.savantly.sprout.core.security.SproutAuditable;

public interface AuditedDomainSecurity<T extends SproutAuditable<ID>, ID extends Serializable> extends RepositorySecurity<T>{


}
