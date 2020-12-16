package dao;

import java.util.ArrayList;

import entities.Dia;

public interface IDiaDAO extends IGenericDAO<Dia, Long>{
	public ArrayList<Dia> timDiaTheoMaTieuDe(Long maTieuDe);
}
