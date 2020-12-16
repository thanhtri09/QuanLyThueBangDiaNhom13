package entities;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;

@Entity(name = "ChiTietHoaDon")
public class ChiTietHoaDon implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@EmbeddedId
	private ChiTietHoaDonID ma = new ChiTietHoaDonID();
	@ManyToOne(fetch = FetchType.LAZY)
	@MapsId("maHoaDon")
	@JoinColumn(name = "maHoaDon")
	private HoaDon hoaDon;
	@ManyToOne(fetch = FetchType.LAZY)
	@MapsId("maDia")
	@JoinColumn(name = "maDia")
	private Dia dia;
	private int soNgayThue;
	
	public ChiTietHoaDon() {
		super();
	}
	
	public ChiTietHoaDon(HoaDon hoaDon, Dia dia, int soNgayThue) {
		super();
		this.hoaDon = hoaDon;
		this.dia = dia;
		this.soNgayThue = soNgayThue;
	}

	public ChiTietHoaDonID getMa() {
		return ma;
	}

	public void setMa(ChiTietHoaDonID ma) {
		this.ma = ma;
	}

	public HoaDon getHoaDon() {
		return hoaDon;
	}

	public void setHoaDon(HoaDon hoaDon) {
		this.hoaDon = hoaDon;
	}

	public Dia getDia() {
		return dia;
	}

	public void setDia(Dia dia) {
		this.dia = dia;
	}

	public int getSoNgayThue() {
		return soNgayThue;
	}

	public void setSoNgayThue(int soNgayThue) {
		this.soNgayThue = soNgayThue;
	}

	@Override
	public String toString() {
		return "ChiTietHoaDon [ma=" + ma + ", hoaDon=" + hoaDon + ", dia=" + dia + ", soNgayThue=" + soNgayThue + "]";
	}
	
	

}
