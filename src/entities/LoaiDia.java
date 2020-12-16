package entities;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity(name = "loaiDia")
public class LoaiDia implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long maLoaiDia;
	private TenLoaiDia tenLoaiDia;
	private double giaThue;
	private double phiTreHan;
	private int soNgayThueToiDa;
	@OneToMany(mappedBy = "loaiDia")
	private Set<TieuDe> dsTuaDe = new HashSet<TieuDe>();

	public LoaiDia() {
		super();
	}

	public LoaiDia(TenLoaiDia tenLoaiDia, double giaThue, double phiTreHan, int soNgayThueToiDa) {
		super();
		this.tenLoaiDia = tenLoaiDia;
		this.giaThue = giaThue;
		this.phiTreHan = phiTreHan;
		this.soNgayThueToiDa = soNgayThueToiDa;
	}

	public long getMaLoaiDia() {
		return maLoaiDia;
	}

	public void setMaLoaiDia(long maLoaiDia) {
		this.maLoaiDia = maLoaiDia;
	}

	public TenLoaiDia getTenLoaiDia() {
		return tenLoaiDia;
	}

	public void setTenLoaiDia(TenLoaiDia tenLoaiDia) {
		this.tenLoaiDia = tenLoaiDia;
	}

	public double getGiaThue() {
		return giaThue;
	}

	public void setGiaThue(double giaThue) {
		this.giaThue = giaThue;
	}

	public double getPhiTreHan() {
		return phiTreHan;
	}

	public void setPhiTreHan(double phiTreHan) {
		this.phiTreHan = phiTreHan;
	}

	public int getSoNgayThueToiDa() {
		return soNgayThueToiDa;
	}

	public void setSoNgayThueToiDa(int soNgayThueToiDa) {
		this.soNgayThueToiDa = soNgayThueToiDa;
	}

	public Set<TieuDe> getDsTuaDe() {
		return dsTuaDe;
	}

	public void setDsTuaDe(Set<TieuDe> dsTuaDe) {
		this.dsTuaDe = dsTuaDe;
	}

	@Override
	public String toString() {
		return ""+tenLoaiDia;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (maLoaiDia ^ (maLoaiDia >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		LoaiDia other = (LoaiDia) obj;
		if (maLoaiDia != other.maLoaiDia)
			return false;
		return true;
	}

}
