package savantly.sprout.security;

import java.util.List;

import savantly.sprout.domain.Tree;

public class TreeSecurityImpl extends AuditableSecurityAdapter<Tree, String> implements TreeSecurity {

	@Override
	public List<Tree> filter(List<Tree> list) {
		// TODO Auto-generated method stub
		return super.filter(list);
	}
}
