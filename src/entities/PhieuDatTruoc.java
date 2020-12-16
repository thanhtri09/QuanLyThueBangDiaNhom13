package entities;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;

import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import javax.persistence.OneToMany;

@Entity(name = "PhieuDatTruoc")
public class PhieuDatTruoc implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long maPhieuDatTruoc;
	@Column(nullable = false)
	private LocalDate ngayDat;
	@ManyToOne
	@JoinColumn(name = "maKhachHang")
	private KhachHang khachHang;
	@OneToMany(mappedBy = "phieuDatTruoc", cascade = CascadeType.ALL)
	private Set<ChiTietPhieuDatTruoc> dsChiTietPhieuDatTruoc = new HashSet<ChiTietPhieuDatTruoc>();

	public PhieuDatTruoc(LocalDate ngayDat, KhachHang khachHang) {
		super();
		this.ngayDat = ngayDat;
		this.khachHang = khachHang;
	}

	public PhieuDatTruoc() {
		super();
	}

	public long getMaPhieuDatTruoc() {
		return maPhieuDatTruoc;
	}

	public void setMaPhieuDatTruoc(long maPhieuDatTruoc) {
		this.maPhieuDatTruoc = maPhieuDatTruoc;
	}

	public LocalDate getNgayDat() {
		return ngayDat;
	}

	public void setNgayDat(LocalDate ngayDat) {
		this.ngayDat = ngayDat;
	}

	public KhachHang getKhachHang() {
		return khachHang;
	}

	public void setKhachHang(KhachHang khachHang) {
		this.khachHang = khachHang;
	}

	public Set<ChiTietPhieuDatTruoc> getDsChiTietPhieuDatTruoc() {
		return dsChiTietPhieuDatTruoc;
	}

	public void setDsChiTietPhieuDatTruoc(Set<ChiTietPhieuDatTruoc> dsChiTietPhieuDatTruoc) {
		this.dsChiTietPhieuDatTruoc = dsChiTietPhieuDatTruoc;
	}

	@Override
	public String toString() {
		return "PhieuDatTruoc [maPhieuDatTruoc=" + maPhieuDatTruoc + ", ngayDat=" + ngayDat + ", khachHang=" + khachHang
				+ ", dsChiTietPhieuDatTruoc=" + dsChiTietPhieuDatTruoc + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (maPhieuDatTruoc ^ (maPhieuDatTruoc >>> 32));
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
		PhieuDatTruoc other = (PhieuDatTruoc) obj;
		if (maPhieuDatTruoc != other.maPhieuDatTruoc)
			return false;
		return true;
	}

}
