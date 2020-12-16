package entities;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: ChiTietPhiTreHen
 *
 */
@Entity

public class ChiTietPhiTreHen implements Serializable {

	private static final long serialVersionUID = 1L;
	@EmbeddedId
	private ChiTietPhiTreHenID chiTietPhiTreHenID = new ChiTietPhiTreHenID();
	@ManyToOne(fetch = FetchType.LAZY)
	@MapsId("maDia")
	@JoinColumn(name = "maDia")
	private Dia dia;
	@ManyToOne(fetch = FetchType.LAZY)
	@MapsId("maPhiTreHen")
	@JoinColumn(name = "maPhiTreHen")
	private PhiTreHen phiTreHen;
	private LocalDate ngayThue;
	private LocalDate ngayPhaiTra;
	private LocalDate ngayTra;
	private String trangThai;

	public ChiTietPhiTreHen() {
		super();
	}

	public ChiTietPhiTreHenID getChiTietPhiTreHenID() {
		return chiTietPhiTreHenID;
	}

	public void setChiTietPhiTreHenID(ChiTietPhiTreHenID chiTietPhiTreHenID) {
		this.chiTietPhiTreHenID = chiTietPhiTreHenID;
	}

	public Dia getDia() {
		return dia;
	}

	public void setDia(Dia dia) {
		this.dia = dia;
	}

	public PhiTreHen getPhiTreHen() {
		return phiTreHen;
	}

	public void setPhiTreHen(PhiTreHen phiTreHen) {
		this.phiTreHen = phiTreHen;
	}

	public LocalDate getNgayThue() {
		return ngayThue;
	}

	public void setNgayThue(LocalDate ngayThue) {
		this.ngayThue = ngayThue;
	}

	public LocalDate getNgayPhaiTra() {
		return ngayPhaiTra;
	}

	public void setNgayPhaiTra(LocalDate ngayPhaiTra) {
		this.ngayPhaiTra = ngayPhaiTra;
	}

	public LocalDate getNgayTra() {
		return ngayTra;
	}

	public void setNgayTra(LocalDate ngayTra) {
		this.ngayTra = ngayTra;
	}

	public String getTrangThai() {
		return trangThai;
	}

	public void setTrangThai(String trangThai) {
		this.trangThai = trangThai;
	}

	@Override
	public String toString() {
		return "ChiTietPhiTreHen [chiTietPhiTreHenID=" + chiTietPhiTreHenID + ", dia=" + dia + ", phiTreHen="
				+ phiTreHen + ", ngayThue=" + ngayThue + ", ngayPhaiTra=" + ngayPhaiTra + ", ngayTra=" + ngayTra
				+ ", trangThai=" + trangThai + "]";
	}

}
