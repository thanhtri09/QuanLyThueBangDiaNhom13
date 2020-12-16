package dao.implDAO;

import dao.IChiTietHoaDonDAO;
import entities.ChiTietHoaDon;
import entities.ChiTietHoaDonID;

public class ChiTietHoaDonDAO extends GenericDAOImpl<ChiTietHoaDon, ChiTietHoaDonID> implements IChiTietHoaDonDAO{

	@Override
	public ChiTietHoaDon timTheoMaDia(Long maDia) {
		// TODO Auto-generated method stub
		ChiTietHoaDon ct= (ChiTietHoaDon) entityManager.createNativeQuery("Select * from [dbo].[ChiTietHoaDon] c where c.maDia= "+maDia+"", ChiTietHoaDon.class).getResultList().get(0);
		return ct;
	}

}
