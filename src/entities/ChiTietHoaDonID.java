package entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class ChiTietHoaDonID implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Column(name = "maHoaDon")
	private long maHoaDon;
	@Column(name = "maDia")
	private long maDia;
	public ChiTietHoaDonID() {
		super();
	}
	public long getMaHoaDon() {
		return maHoaDon;
	}
	public void setMaHoaDon(long maHoaDon) {
		this.maHoaDon = maHoaDon;
	}
	public long getMaDia() {
		return maDia;
	}
	public void setMaDia(long maDia) {
		this.maDia = maDia;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (maDia ^ (maDia >>> 32));
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
		ChiTietHoaDonID other = (ChiTietHoaDonID) obj;
		if (maDia != other.maDia)
			return false;
		if (maHoaDon != other.maHoaDon)
			return false;
		return true;
	}
	
	
	
}
