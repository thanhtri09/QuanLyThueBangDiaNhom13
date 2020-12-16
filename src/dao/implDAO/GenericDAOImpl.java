package dao.implDAO;

import java.lang.reflect.ParameterizedType;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;

import dao.IGenericDAO;
import dao.QuanLyBangDiaEntityManager;

public abstract class GenericDAOImpl<T, MA> implements IGenericDAO<T, MA> {
	protected EntityManager entityManager;
	private Class<T> doMainClass;

	public GenericDAOImpl() {
		// TODO Auto-generated constructor stub
		entityManager = QuanLyBangDiaEntityManager.getInstance().getEntityManager();
	}

	@Override
	public List<T> findALL() {

		CriteriaBuilder builder = entityManager.getCriteriaBuilder();
		CriteriaQuery<T> criteriaQuery = builder.createQuery(getDoMainClass());
		criteriaQuery.from(getDoMainClass());
		TypedQuery<T> query = entityManager.createQuery(criteriaQuery);
		return query.getResultList();
	}

	@Override
	public T timTheoMa(MA ma) {
		return entityManager.find(getDoMainClass(),ma );
	}

	@Override
	public T them(T obj) {
		EntityTransaction trans = entityManager.getTransaction();
		try {
			trans.begin();
			entityManager.persist(obj);
			trans.commit();
			return obj;
		} catch (Exception e) {
			trans.rollback();
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Boolean xoa(T obj) {
		EntityTransaction trans = entityManager.getTransaction();
		try {
			trans.begin();
			entityManager.remove(obj);
			trans.commit();
			return true;
		} catch (Exception e) {
			trans.rollback();
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public Boolean xoaTheoMa(MA ma) {
		EntityTransaction trans = entityManager.getTransaction();
		try {
			trans.begin();
			entityManager.remove(timTheoMa(ma));
			trans.commit();
			return true;
		} catch (Exception e) {
			trans.rollback();
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public T sua(T obj) {
		EntityTransaction trans = entityManager.getTransaction();
		try {
			trans.begin();
			entityManager.merge(obj);
			trans.commit();
			return obj;
		} catch (Exception e) {
			trans.rollback();
			e.printStackTrace();
		}
		return null;
	}
	
	protected Class<T> getDoMainClass(){
		if (doMainClass == null) {
			ParameterizedType  type =(ParameterizedType) getClass().getGenericSuperclass();
			doMainClass = (Class<T>) type.getActualTypeArguments()[0];
		}
		return doMainClass;
	}
}
