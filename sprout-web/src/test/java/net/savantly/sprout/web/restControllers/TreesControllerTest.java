package net.savantly.sprout.web.restControllers;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import net.savantly.sprout.AbstractIntegrationTest;
import net.savantly.sprout.domain.CustomPageImpl;
import net.savantly.sprout.domain.tree.Tree;

public class TreesControllerTest extends AbstractIntegrationTest {
	@Autowired
    private TestRestTemplate restTemplate;

	@Test
	public void getTreeList() throws Exception {
		ResponseEntity<Tree[]> result = restTemplate.getForEntity("/rest/trees", Tree[].class);
		Assert.assertEquals(HttpStatus.OK, result.getStatusCode());
	}
	
	@Test
	@SuppressWarnings("unchecked")
	public void getTreePage() throws Exception {
		ResponseEntity<? extends Page> result = restTemplate.getForEntity("/rest/trees/page", (Class<? extends Page>)CustomPageImpl.class);
		Assert.assertEquals(HttpStatus.OK, result.getStatusCode());
	}
}