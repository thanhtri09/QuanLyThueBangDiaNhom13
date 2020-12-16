package dao.implDAO;

import dao.IPhiTreHenDAO;
import entities.PhiTreHen;

public class PhiTreHenDAO extends GenericDAOImpl<PhiTreHen, Long> implements IPhiTreHenDAO {

	@Override
	public PhiTreHen timPhiTreHenTheoMaKhachHang(Long maKhachHang) {
		// TODO Auto-generated method stub
		return (PhiTreHen) entityManager.createNativeQuery("select * from PhiTreHen where maKhachHang = "+maKhachHang,PhiTreHen.class).getResultList().get(0);
	}

}
