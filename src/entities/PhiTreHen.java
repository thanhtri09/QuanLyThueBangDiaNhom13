package entities;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: PhiTreHen
 *
 */
@Entity
public class PhiTreHen implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long maPhiTreHan;
	@ManyToOne
	@JoinColumn(name = "maKhachHang")
	private KhachHang khachHang;
	@OneToMany(mappedBy = "phiTreHen", cascade = CascadeType.ALL)
	private Set<ChiTietPhiTreHen> dsChiTietPhiTreHen = new HashSet<ChiTietPhiTreHen>();
	private static final long serialVersionUID = 1L;

	public PhiTreHen() {
		super();
	}

	public PhiTreHen(KhachHang khachHang) {
		super();
		this.khachHang = khachHang;
	}

	public long getMaPhiTreHan() {
		return maPhiTreHan;
	}

	public void setMaPhiTreHan(long maPhiTreHan) {
		this.maPhiTreHan = maPhiTreHan;
	}

	public KhachHang getKhachHang() {
		return khachHang;
	}

	public void setKhachHang(KhachHang khachHang) {
		this.khachHang = khachHang;
	}

	public Set<ChiTietPhiTreHen> getDsChiTietPhiTreHen() {
		return dsChiTietPhiTreHen;
	}

	public void setDsChiTietPhiTreHen(Set<ChiTietPhiTreHen> dsChiTietPhiTreHen) {
		this.dsChiTietPhiTreHen = dsChiTietPhiTreHen;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (maPhiTreHan ^ (maPhiTreHan >>> 32));
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
		PhiTreHen other = (PhiTreHen) obj;
		if (maPhiTreHan != other.maPhiTreHan)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "PhiTreHen [maPhiTreHan=" + maPhiTreHan + ", khachHang=" + khachHang + "]";
	}

}
