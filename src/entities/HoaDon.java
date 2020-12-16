package entities;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity(name = "HoaDon")
public class HoaDon implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long maHoaDon;
	@Column(nullable = false)
	private LocalDate ngayThue;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "maKhachHang")
	private KhachHang khachHang;
	@OneToMany(mappedBy = "hoaDon", cascade = CascadeType.ALL)
	private Set<ChiTietHoaDon> dsChiTietHoaHon = new HashSet<ChiTietHoaDon>();

	public HoaDon() {
		super();
	}

	public HoaDon(LocalDate ngayThue, KhachHang khachHang) {
		super();
		this.ngayThue = ngayThue;
		this.khachHang = khachHang;
	}

	public long getMaHoaDon() {
		return maHoaDon;
	}

	public void setMaHoaDon(long maHoaDon) {
		this.maHoaDon = maHoaDon;
	}

	public LocalDate getNgayThue() {
		return ngayThue;
	}

	public void setNgayThue(LocalDate ngayThue) {
		this.ngayThue = ngayThue;
	}

	public KhachHang getKhachHang() {
		return khachHang;
	}

	public void setKhachHang(KhachHang khachHang) {
		this.khachHang = khachHang;
	}

	public Set<ChiTietHoaDon> getDsChiTietHoaHon() {
		return dsChiTietHoaHon;
	}

	public void setDsChiTietHoaHon(Set<ChiTietHoaDon> dsChiTietHoaHon) {
		this.dsChiTietHoaHon = dsChiTietHoaHon;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (maHoaDon ^ (maHoaDon >>> 32));
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
		HoaDon other = (HoaDon) obj;
		if (maHoaDon != other.maHoaDon)
			return false;
		return true;
	}

}
