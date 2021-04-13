package fr.istic.taa.jaxrs.dao.generic;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public abstract class CollaborateurDao<K, T extends Serializable> implements IGenericDao<K, T> {

	private Class<T> clazz;

	protected EntityManager entityManager;

	public CollaborateurDao() {
		this.entityManager = EntityManagerHelper.getEntityManager();
	}

	public void setClazz(Class<T> clazzToSet) {
		this.clazz = clazzToSet;
	}

	public T findOne(K id) {
		EntityTransaction t = this.entityManager.getTransaction();
		t.begin();
		T res = entityManager.find(clazz, id);
		t.commit();
		return res;
	}

	public List<T> findAll() {
		return entityManager.createQuery("select e from " + clazz.getName() + " as e",clazz).getResultList();
	}

	public void save(T entity) {
		EntityTransaction t = this.entityManager.getTransaction();
		t.begin();
		entityManager.persist(entity);
		t.commit();
	}

	public T update(final T entity) {
		EntityTransaction t = this.entityManager.getTransaction();
		t.begin();
		T res = entityManager.merge(entity);
		t.commit();
		return res;

	}

	public void delete(T entity) {
		EntityTransaction t = this.entityManager.getTransaction();
		t.begin();
		entityManager.remove(entity);
		t.commit();

	}

	public void deleteById(K entityId) {
		T entity = findOne(entityId);
		delete(entity);
	}
}
