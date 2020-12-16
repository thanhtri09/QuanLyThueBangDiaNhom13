package entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class ChiTietPhiTreHenID implements Serializable {

	private static final long serialVersionUID = 1L;
	@Column(name = "maPhiTreHen")
	private long maPhiTreHen;
	@Column(name = "maDia")
	private long maDia;
	
	public ChiTietPhiTreHenID(long maPhiTreHen, long maDia) {
		super();
		this.maPhiTreHen = maPhiTreHen;
		this.maDia = maDia;
	}

	public ChiTietPhiTreHenID() {
		super();
	}

	public long getMaPhiTreHen() {
		return maPhiTreHen;
	}

	public void setMaPhiTreHen(long maPhiTreHen) {
		this.maPhiTreHen = maPhiTreHen;
	}

	public long getMaDia() {
		return maDia;
	}

	public void setMaDia(long maDia) {
		this.maDia = maDia;
	}

	@Override
	public String toString() {
		return "ChiTietPhiTreHenID [maPhiTreHen=" + maPhiTreHen + ", maDia=" + maDia + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (maDia ^ (maDia >>> 32));
		result = prime * result + (int) (maPhiTreHen ^ (maPhiTreHen >>> 32));
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
		ChiTietPhiTreHenID other = (ChiTietPhiTreHenID) obj;
		if (maDia != other.maDia)
			return false;
		if (maPhiTreHen != other.maPhiTreHen)
			return false;
		return true;
	}

}
