package dao.implDAO;

import java.util.ArrayList;
import java.util.List;

import dao.IChiTietPhiTreHenDAO;
import entities.ChiTietPhiTreHen;
import entities.ChiTietPhiTreHenID;

public class ChiTietPhiTreHenDAO extends GenericDAOImpl<ChiTietPhiTreHen, ChiTietPhiTreHenID> implements IChiTietPhiTreHenDAO {

	@Override
	public ArrayList<ChiTietPhiTreHen> timTheoMaKhachHang(Long ma) {
		// TODO Auto-generated method stub
		String sql="select * from ChiTietPhiTreHen c join PhiTreHen p on c.maPhiTreHen=p.maPhiTreHan where p.maKhachHang ="+ma+"";
		return (ArrayList<ChiTietPhiTreHen>) entityManager.createNativeQuery(sql, ChiTietPhiTreHen.class).getResultList();
	}

	@Override
	public List<ChiTietPhiTreHen> timChiTietPhiTreHenTheoMaPhiTreHen(Long maPhiTreHen) {
		// TODO Auto-generated method stub
		return entityManager.createNativeQuery("select * from ChiTietPhiTreHen where maPhiTreHen = " + maPhiTreHen,ChiTietPhiTreHen.class).getResultList();
	}
	

}
