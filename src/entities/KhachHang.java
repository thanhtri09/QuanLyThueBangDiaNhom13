package entities;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity(name = "KhachHang")
public class KhachHang implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long maKhachHang;
	@Column(columnDefinition = "NVARCHAR(255)", nullable = false)
	private String hoTen;
	@Column(columnDefinition = "NVARCHAR(255)", nullable = false)
	private String diaChi;
	@Column(length = 10, nullable = false)
	private String soDienThoai;
	@Column(columnDefinition = "NVARCHAR(255)", nullable = false)
	private String trangThai;
	@OneToMany(mappedBy = "khachHang", cascade = CascadeType.ALL)
	private Set<HoaDon> dsHoaDon = new HashSet<HoaDon>();
	@OneToMany(mappedBy = "khachHang", cascade = CascadeType.ALL)
	private Set<PhieuDatTruoc> dsPhieuDatTruoc = new HashSet<PhieuDatTruoc>();
	@OneToMany(mappedBy = "khachHang", cascade = CascadeType.ALL)
	private Set<PhiTreHen> dsPhiTreHen = new HashSet<PhiTreHen>();
	
	

	public KhachHang() {
		super();
	}

	public KhachHang(String hoTen, String diaChi, String soDienThoai, String trangThai) {
		super();
		this.hoTen = hoTen;
		this.diaChi = diaChi;
		this.soDienThoai = soDienThoai;
		this.trangThai = trangThai;
	}

	public long getMaKhachHang() {
		return maKhachHang;
	}

	public void setMaKhachHang(long maKhachHang) {
		this.maKhachHang = maKhachHang;
	}

	public String getHoTen() {
		return hoTen;
	}

	public void setHoTen(String hoTen) {
		this.hoTen = hoTen;
	}

	public String getDiaChi() {
		return diaChi;
	}

	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}

	public String getSoDienThoai() {
		return soDienThoai;
	}

	public void setSoDienThoai(String soDienThoai) {
		this.soDienThoai = soDienThoai;
	}

	public Set<HoaDon> getDsHoaDon() {
		return dsHoaDon;
	}

	public void setDsHoaDon(Set<HoaDon> dsHoaDon) {
		this.dsHoaDon = dsHoaDon;
	}

	public Set<PhieuDatTruoc> getDsPhieuDaTruoc() {
		return dsPhieuDatTruoc;
	}

	public void setDsPhieuDaTruoc(Set<PhieuDatTruoc> dsPhieuDaTruoc) {
		this.dsPhieuDatTruoc = dsPhieuDaTruoc;
	}

	public String getTrangThai() {
		return trangThai;
	}

	public void setTrangThai(String trangThai) {
		this.trangThai = trangThai;
	}

	@Override
	public String toString() {
		return "KhachHang [maKhachHang=" + maKhachHang + ", hoTen=" + hoTen + ", diaChi=" + diaChi + ", soDienThoai="
				+ soDienThoai + ", trangThai=" + trangThai + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (maKhachHang ^ (maKhachHang >>> 32));
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
		KhachHang other = (KhachHang) obj;
		if (maKhachHang != other.maKhachHang)
			return false;
		return true;
	}

}
