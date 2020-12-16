package dao;

import java.util.List;

import entities.TieuDe;

public interface ITieuDeDAO extends IGenericDAO<TieuDe, Long>{
	List<TieuDe> timTieuDeTheoTen(String tenTieuDe);
}
