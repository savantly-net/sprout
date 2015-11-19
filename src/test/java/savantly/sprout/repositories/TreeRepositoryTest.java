package savantly.sprout.repositories;

import static org.junit.Assert.fail;

import java.util.UUID;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import savantly.sprout.domain.Tree;
import savantly.sprout.web.Application;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
public class TreeRepositoryTest {
	
	@Autowired
	private TreeRepository treeRepository;
	

	@Test
	public void test() {
		Tree tree = new Tree();
		String id = UUID.randomUUID().toString();
		tree.setId(id);
		tree.setName("Test Tree");
		tree.setDescription("Test Description");

		treeRepository.save(tree);
	}

}