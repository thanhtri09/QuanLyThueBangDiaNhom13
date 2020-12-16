package entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class ChiTietPhieuDatTruocID implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Column(name = "maPhieuDatTruoc")
	private long maPhieuDatTruoc;
	@Column(name = "maTuaDe")
	private long maTuaDe;

	public ChiTietPhieuDatTruocID() {
		super();
	}
	
	public ChiTietPhieuDatTruocID(long maPhieuDatTruoc, long maTuaDe) {
		super();
		this.maPhieuDatTruoc = maPhieuDatTruoc;
		this.maTuaDe = maTuaDe;
	}

	public long getMaPhieuDatTruoc() {
		return maPhieuDatTruoc;
	}

	public void setMaPhieuDatTruoc(long maPhieuDatTruoc) {
		this.maPhieuDatTruoc = maPhieuDatTruoc;
	}

	public long getMaTuaDe() {
		return maTuaDe;
	}

	public void setMaTuaDe(long maTuaDe) {
		this.maTuaDe = maTuaDe;
	}

	@Override
	public String toString() {
		return "ChiTietPhieuDatTruocID [maPhieuDatTruoc=" + maPhieuDatTruoc + ", maTuaDe=" + maTuaDe + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (maPhieuDatTruoc ^ (maPhieuDatTruoc >>> 32));
		result = prime * result + (int) (maTuaDe ^ (maTuaDe >>> 32));
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
		ChiTietPhieuDatTruocID other = (ChiTietPhieuDatTruocID) obj;
		if (maPhieuDatTruoc != other.maPhieuDatTruoc)
			return false;
		if (maTuaDe != other.maTuaDe)
			return false;
		return true;
	}

}
