package dao;

import java.util.List;

import entities.TieuDe;

public interface ITuaDeDAO extends IGenericDAO<TieuDe, Long>{
	public TieuDe timTuaDeTheoTen(String ten);
	public List<TieuDe> timTuaDesTheoTen(String ten);
	
}
