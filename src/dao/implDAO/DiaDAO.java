package dao.implDAO;

import java.util.ArrayList;

import dao.IDiaDAO;
import entities.ChiTietHoaDonID;
import entities.Dia;

public class DiaDAO extends GenericDAOImpl<Dia, Long> implements IDiaDAO{

	@Override
	public ArrayList<Dia> timDiaTheoMaTieuDe(Long maTieuDe) {
		// TODO Auto-generated method stub
		ArrayList<Dia> list=new ArrayList<Dia>();
		String sql="select * from Dia d join TieuDe t on d.maTieuDe= t.maTieuDe where t.maTieuDe="+maTieuDe+"";
//		ArrayList<Object> temp= (ArrayList<Object>) entityManager.createNativeQuery(sql, Dia.class).getResultList();
//		for(Dia dia:temp) {
//			list.add(dia);
//		}
		return (ArrayList<Dia>) entityManager.createNativeQuery(sql, Dia.class).getResultList();
	}

}
