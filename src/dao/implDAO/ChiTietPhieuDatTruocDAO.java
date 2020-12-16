package dao.implDAO;

import dao.IChiTietPhieuDatTruoc;
import entities.ChiTietPhieuDatTruoc;
import entities.ChiTietPhieuDatTruocID;

public class ChiTietPhieuDatTruocDAO extends GenericDAOImpl<ChiTietPhieuDatTruoc, ChiTietPhieuDatTruocID> implements IChiTietPhieuDatTruoc {

	@Override
	public ChiTietPhieuDatTruoc timTheoPhieu(Long ma) {
		// TODO Auto-generated method stub
		return (ChiTietPhieuDatTruoc) entityManager.createNativeQuery("select * from ChiTietPhieuDatTruoc c where c.maPhieuDatTruoc="+ma+"", ChiTietPhieuDatTruoc.class).getResultList().get(0);
	}

}
