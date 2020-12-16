package dao.implDAO;

import dao.IPhieuTreHenDAO;
import entities.PhiTreHen;

public class PhieuTreHenDAO extends GenericDAOImpl<PhiTreHen, Long> implements IPhieuTreHenDAO{

	@Override
	public PhiTreHen timPhiTreHenTheoMaKhachHang(Long maKhachHang) {
		// TODO Auto-generated method stub
		return (PhiTreHen) entityManager.createNativeQuery("select * from PhiTreHen where maKhachHang = "+maKhachHang,PhiTreHen.class).getResultList().get(0);
	}

}
