package alf.api.web.dao;

import java.io.Serializable;

import java.lang.reflect.ParameterizedType;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.springframework.transaction.annotation.Transactional;

public abstract class AbstractDao<PK extends Serializable, T> {

	private final Class<T> persistentClass;

	@PersistenceContext
	EntityManager entityManager;

	@SuppressWarnings("unchecked")
	public AbstractDao() {
		this.persistentClass = (Class<T>) ((ParameterizedType) this.getClass().getGenericSuperclass())
				.getActualTypeArguments()[1];
	}

	public T getByKey(PK key) {
		return entityManager.find(persistentClass, key);
	}

	public void persist(T entity) {
		entityManager.persist(entity);
	}

	public void update(T entity) {
		entityManager.merge(entity);
	}

	public void delete(T entity) {
		entityManager.remove(entity);
	}

	@Transactional
	public List<T> findByAttributeContainsText(String attributeName, String text) {
		CriteriaBuilder builder = entityManager.getCriteriaBuilder();
		CriteriaQuery<T> cQuery = builder.createQuery(persistentClass);
		Root<T> root = cQuery.from(persistentClass);
		cQuery
				.select(root)
				.where(builder
						.like(root.<String>get(attributeName), "%" + text + "%"));
		TypedQuery<T> query = entityManager.createQuery(cQuery);
		return query.getResultList();
	}

	@Transactional
	public List<T> findNotInId(String attributeName, PK id) {
		CriteriaBuilder builder = entityManager.getCriteriaBuilder();
		CriteriaQuery<T> cQuery = builder.createQuery(persistentClass);
		Root<T> root = cQuery.from(persistentClass);
		cQuery
				.select(root)
				.where(builder.notEqual(root.<String>get(attributeName), id));
		TypedQuery<T> query = entityManager.createQuery(cQuery);
		return query.getResultList();
	}

	protected Query createEntityCriteria() {
		return entityManager.createQuery("from " + persistentClass.getName());
	}

}
