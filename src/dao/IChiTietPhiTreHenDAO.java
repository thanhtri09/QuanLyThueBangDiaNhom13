package dao;

import java.util.ArrayList;
import java.util.List;

import entities.ChiTietPhiTreHen;
import entities.ChiTietPhiTreHenID;
import entities.ChiTietPhieuDatTruoc;
import entities.ChiTietPhieuDatTruocID;

public interface IChiTietPhiTreHenDAO  extends IGenericDAO<ChiTietPhiTreHen, ChiTietPhiTreHenID> {
	public ArrayList<ChiTietPhiTreHen> timTheoMaKhachHang(Long ma);
	List<ChiTietPhiTreHen> timChiTietPhiTreHenTheoMaPhiTreHen(Long maPhiTreHen);
}
