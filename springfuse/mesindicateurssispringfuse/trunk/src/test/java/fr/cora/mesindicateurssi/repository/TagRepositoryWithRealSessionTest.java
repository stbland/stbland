/*
 * (c) Copyright 2005-2012 JAXIO, www.jaxio.com
 * Source code generated by Celerio, a Jaxio product
 * Want to use Celerio within your company? email us at info@jaxio.com
 * Follow us on twitter: @springfuse
 * Template pack-backend-sd:src/test/java/repository/RepositoryWithRealSessionTest.e.vm.java
 */
package fr.cora.mesindicateurssi.repository;

import static org.fest.assertions.Assertions.assertThat;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.google.common.collect.Sets;

import fr.cora.mesindicateurssi.domain.Tag;
import fr.cora.mesindicateurssi.repository.TagGenerator;
import fr.cora.mesindicateurssi.repository.TagRepository;

/**
 * Integration test on {@link TagRepository}
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath*:spring/applicationContext-test.xml" })
@Transactional
public class TagRepositoryWithRealSessionTest {
    @SuppressWarnings("unused")
    private static final Logger log = Logger.getLogger(TagRepositoryWithRealSessionTest.class);

    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    private TagRepository tagRepository;

    @Autowired
    private TagGenerator tagGenerator;

    @Test
    public void identityShouldBePreserved() {
        Tag tag = tagGenerator.getTag();

        // add it to a Set before saving (force equals/hashcode)
        Sets.newHashSet(tag);

        tagRepository.save(tag);
        entityManager.flush();

        // reload it from cache and check equality
        Integer id = tag.getId();
        assertThat(tag).isEqualTo(tagRepository.findOne(id));

        // clear cache to force reload from db
        entityManager.clear();

        // pk are equals...
        assertThat(tag.getId()).isEqualTo(tagRepository.findOne(id).getId());

        // but since you do not use a business key, equality is lost.
        assertThat(tag).isNotEqualTo(tagRepository.findOne(id));
    }
}