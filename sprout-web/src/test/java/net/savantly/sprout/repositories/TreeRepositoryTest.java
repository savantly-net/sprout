package net.savantly.sprout.repositories;

import java.util.UUID;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.test.context.support.WithMockUser;

import net.savantly.sprout.AbstractIntegrationTest;
import net.savantly.sprout.domain.tree.Tree;
import net.savantly.sprout.domain.tree.repository.TreeRepository;

public class TreeRepositoryTest  extends AbstractIntegrationTest{
	
	@Autowired
	private TreeRepository treeRepository;
	

	@Test
	@WithMockUser(username = "admin", authorities = { "ADMIN", "USER" })
	public void test() {
		Tree tree = new Tree();
		String id = UUID.randomUUID().toString();
		tree.setId(id);
		tree.setName("Test Tree");
		tree.setDescription("Test Description");


	}

}