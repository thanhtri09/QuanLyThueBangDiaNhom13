package dao;

import entities.PhiTreHen;

public interface IPhieuTreHenDAO extends IGenericDAO<PhiTreHen, Long> {
	PhiTreHen timPhiTreHenTheoMaKhachHang(Long maKhachHang);
}
