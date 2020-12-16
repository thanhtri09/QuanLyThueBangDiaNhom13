package dao;

import entities.ChiTietHoaDon;
import entities.ChiTietHoaDonID;

public interface IChiTietHoaDonDAO extends IGenericDAO<ChiTietHoaDon, ChiTietHoaDonID>{
	public ChiTietHoaDon timTheoMaDia(Long maDia);
}
