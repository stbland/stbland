/*
 * (c) Copyright 2005-2012 JAXIO, www.jaxio.com
 * Source code generated by Celerio, a Jaxio product
 * Want to use Celerio within your company? email us at info@jaxio.com
 * Follow us on twitter: @springfuse
 * Template pack-backend-sd:src/main/java/project/repository/support/CustomRepositoryImpl.p.vm.java
 */
package fr.cora.mesindicateurssi.repository.support;

import static com.google.common.base.Preconditions.checkNotNull;
import static org.springframework.data.jpa.domain.Specifications.where;
import static fr.cora.mesindicateurssi.repository.support.JpaUtil.isEntityIdManuallyAssigned;
import static fr.cora.mesindicateurssi.repository.support.ByExampleSpecifications.byExample;
import static fr.cora.mesindicateurssi.repository.support.ByPatternSpecifications.byPattern;
import static fr.cora.mesindicateurssi.repository.support.ByRangeSpecifications.byRanges;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.support.JpaEntityInformation;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.transaction.annotation.Transactional;

/**
 * Shared base repository providing query by example and query by string pattern.
 */
public class CustomRepositoryImpl<E, PK extends Serializable> extends SimpleJpaRepository<E, PK> implements
        CustomRepository<E, PK> {
    private final JpaEntityInformation<E, ?> entityInformation;
    private final EntityManager entityManager;
    private final Class<E> type;
    private static final int MAX_VALUES_RETREIVED = 500;

    public CustomRepositoryImpl(JpaEntityInformation<E, ?> entityInformation, EntityManager entityManager) {
        super(entityInformation, entityManager);
        this.entityInformation = entityInformation;
        this.entityManager = entityManager;
        this.type = entityInformation.getJavaType();
    }

    @Override
    public Page<E> findWithExample(E example, Pageable pageable) {
        return findAll(byExample(entityManager, example), pageable);
    }

    @Override
    public Page<E> findWithExample(E example, List<Range<E, ?>> ranges, Pageable pageable) {
        Specification<E> byExample = byExample(entityManager, example);
        Specification<E> byRanges = byRanges(ranges);
        return findAll(where(byExample).and(byRanges), pageable);
    }

    @Override
    public List<E> find() {
        return findAll(pageRequest()).getContent();
    }

    @Override
    public List<E> find(String pattern) {
        return findAll(byPattern(entityManager, pattern, type), pageRequest()).getContent();
    }

    @Override
    public Page<E> find(SearchForm<E> searchForm) {
        SearchParameters searchParameters = searchForm.getSp();
        Specification<E> byExample = byExample(entityManager, searchForm.getForm());
        Specification<E> byPattern = byPattern(entityManager, searchParameters.getSearchPattern(), type);
        Specification<E> byRanges = byRanges(searchForm.getRanges());
        return findAll(where(byExample).and(byPattern).and(byRanges), searchParameters.toPageRequest());
    }

    @Override
    @Transactional
    public E save(E entity) {
        checkNotNull(entity, "The entity to save cannot be null");

        // creation with auto generated id
        if (entityInformation.isNew(entity)) {
            entityManager.persist(entity);
            return entity;
        }

        // creation with manually assigned key
        if (isEntityIdManuallyAssigned(type) && !entityManager.contains(entity)) {
            entityManager.persist(entity);
            return entity;
        }

        return entity;
        // other cases are update
        // the simple fact to invoke this method, from a service method annotated with @Transactional,
        // does the job (assuming the passed entity is present in the persistence context)
    }

    private PageRequest pageRequest() {
        return new PageRequest(0, MAX_VALUES_RETREIVED);
    }
}
