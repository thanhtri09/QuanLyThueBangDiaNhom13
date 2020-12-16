package dao;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

public class QuanLyBangDiaEntityManager {
	private static QuanLyBangDiaEntityManager instance = null;
	private EntityManager entityManager;
	
	public QuanLyBangDiaEntityManager() {
		// TODO Auto-generated constructor stub
		entityManager = Persistence.createEntityManagerFactory("demo").createEntityManager();
	}
	public synchronized static QuanLyBangDiaEntityManager getInstance() {
			if (instance == null) {
				instance = new QuanLyBangDiaEntityManager();
			}
			return instance;
	}
	public  EntityManager getEntityManager() {
		return entityManager;
	}
}
