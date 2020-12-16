package dao.implDAO;

import antlr.collections.List;
import dao.ITuaDeDAO;
import entities.TieuDe;

public class TuaDeDAO extends GenericDAOImpl<TieuDe, Long> implements ITuaDeDAO{

	@Override
	public TieuDe timTuaDeTheoTen(String ten) {
		// TODO Auto-generated method stub
		return (TieuDe) entityManager.createNativeQuery("select * from TieuDe t where t.tenTieuDe like N'"+ten+"'", TieuDe.class).getResultList().get(0);
	}

	@Override
	public java.util.List<TieuDe> timTuaDesTheoTen(String ten) {
		// TODO Auto-generated method stub
		return entityManager.createNativeQuery("select * from TieuDe t where t.tenTieuDe like N'"+ten+"'", TieuDe.class).getResultList();
	}
	
	
	
	
	
}
