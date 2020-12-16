package dao.implDAO;

import java.util.List;

import dao.ITieuDeDAO;
import entities.TieuDe;

public class TieuDeDAO extends GenericDAOImpl<TieuDe, Long> implements ITieuDeDAO {

	@Override
	public List<TieuDe> timTieuDeTheoTen(String tenTieuDe) {
		// TODO Auto-generated method stub
		return entityManager
				.createNativeQuery("select * from TieuDe where tenTieuDe like N'%" + tenTieuDe + "%'", TieuDe.class)
				.getResultList();
	}

}
