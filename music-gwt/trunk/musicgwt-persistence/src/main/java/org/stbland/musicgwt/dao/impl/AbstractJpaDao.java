package org.stbland.musicgwt.dao.impl;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public abstract class AbstractJpaDao<T extends Serializable, K> {

	private Class<T> clazz;

	@PersistenceContext
	private EntityManager entityManager;

	public EntityManager getEntityManager() {
		return entityManager;
	}

	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	public void setClazz(final Class<T> clazzToSet) {
		this.clazz = clazzToSet;
	}

	public T findOne(final K id) {
		if (id == null) {
			return null;
		}

		return entityManager.find(clazz, id);
	}

	public List<T> findAll() {
		return entityManager.createQuery("from " + getEntityName())
				.getResultList();
	}

	protected String getEntityName() {
		return clazz.getName();
	}

	public T save(final T entity) {
		entityManager.persist(entity);
		return entity;
	}

	public void update(final T entity) {
		entityManager.merge(entity);
	}

	public void delete(final T entity) {
		entityManager.remove(entity);
	}

	public void deleteById(final K entityId) {
		final T entity = findOne(entityId);

		delete(entity);
	}
}