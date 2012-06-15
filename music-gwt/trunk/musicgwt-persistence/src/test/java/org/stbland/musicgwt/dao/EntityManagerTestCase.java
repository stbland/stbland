package org.stbland.musicgwt.dao;

import javax.sql.DataSource;

import junit.framework.Assert;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:META-INF/spring/applicationContext-persistence.xml" })
public class EntityManagerTestCase {

	@Autowired
	private DataSource dataSource;

	@Test
	public void testLoadPersitenceSpringContext() {
		Assert.assertNotNull(dataSource);
	}
}
