package dao;

import entities.PhiTreHen;

public interface IPhiTreHenDAO extends IGenericDAO<PhiTreHen, Long>{
	PhiTreHen timPhiTreHenTheoMaKhachHang(Long maKhachHang);
}
