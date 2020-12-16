package dao;

import entities.ChiTietPhieuDatTruoc;
import entities.ChiTietPhieuDatTruocID;

public interface IChiTietPhieuDatTruoc extends IGenericDAO<ChiTietPhieuDatTruoc	, ChiTietPhieuDatTruocID> {
	public ChiTietPhieuDatTruoc timTheoPhieu(Long ma);
}
