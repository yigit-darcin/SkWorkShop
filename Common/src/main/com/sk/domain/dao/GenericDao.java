package com.sk.domain.dao;import java.util.List;import org.hibernate.Session;import org.hibernate.SessionFactory;import org.springframework.beans.factory.annotation.Autowired;import org.springframework.transaction.annotation.Transactional;import com.sk.domain.BaseEntity;@SuppressWarnings("unchecked")public abstract class GenericDao<T extends BaseEntity> {	private Class<T> persistentClass;	@Autowired	private SessionFactory sessionFactory;	public GenericDao(final Class<T> persistentClass) {		this.persistentClass = persistentClass;	}	public List<T> getAll() {		return getSession().createCriteria(persistentClass).list();	}	public T get(Long id) {		T entity = (T) getSession().get(this.persistentClass, id);		return entity;	}	@Transactional	public T persist(T toPersist) {		return (T) getSession().merge(toPersist);	}	@Transactional	public void delete(T toDelete) {		toDelete = get(toDelete.getId());		getSession().delete(toDelete);	}	protected Session getSession() {		return sessionFactory.getCurrentSession();	}}