package entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * Entity implementation class for Entity: ChiTietPhieuDatTruoc
 *
 */
@Entity(name = "ChiTietPhieuDatTruoc")
public class ChiTietPhieuDatTruoc implements Serializable {

	@EmbeddedId
	private ChiTietPhieuDatTruocID chiTietPhieuDatTruocID = new ChiTietPhieuDatTruocID();
	private boolean trangThai;
	@ManyToOne(fetch = FetchType.LAZY)
	@MapsId("maPhieuDatTruoc")
	@JoinColumn(name = "maPhieuDatTruoc")
	private PhieuDatTruoc phieuDatTruoc;
	@ManyToOne(fetch = FetchType.LAZY)
	@MapsId("maTuaDe")
	@JoinColumn(name = "maTuaDe")
	private TieuDe tieuDe;

	private static final long serialVersionUID = 1L;
	
	
	public ChiTietPhieuDatTruoc(boolean trangThai, PhieuDatTruoc phieuDatTruoc, TieuDe tieuDe) {
		super();
		this.trangThai = trangThai;
		this.phieuDatTruoc = phieuDatTruoc;
		this.tieuDe = tieuDe;
	}

	public ChiTietPhieuDatTruoc(ChiTietPhieuDatTruocID chiTietPhieuDatTruocID, boolean trangThai,
			PhieuDatTruoc phieuDatTruoc, TieuDe tieuDe) {
		super();
		this.chiTietPhieuDatTruocID = chiTietPhieuDatTruocID;
		this.trangThai = trangThai;
		this.phieuDatTruoc = phieuDatTruoc;
		this.tieuDe = tieuDe;
	}

	public ChiTietPhieuDatTruoc() {
		super();
	}

	public ChiTietPhieuDatTruocID getChiTietPhieuDatTruocID() {
		return chiTietPhieuDatTruocID;
	}

	public void setChiTietPhieuDatTruocID(ChiTietPhieuDatTruocID chiTietPhieuDatTruocID) {
		this.chiTietPhieuDatTruocID = chiTietPhieuDatTruocID;
	}

	public boolean isTrangThai() {
		return trangThai;
	}

	public void setTrangThai(boolean trangThai) {
		this.trangThai = trangThai;
	}

	public PhieuDatTruoc getPhieuDatTruoc() {
		return phieuDatTruoc;
	}

	public void setPhieuDatTruoc(PhieuDatTruoc phieuDatTruoc) {
		this.phieuDatTruoc = phieuDatTruoc;
	}

	public TieuDe getTieuDe() {
		return tieuDe;
	}

	public void setTieuDe(TieuDe tieuDe) {
		this.tieuDe = tieuDe;
	}

	@Override
	public String toString() {
		return "ChiTietPhieuDatTruoc [chiTietPhieuDatTruocID=" + chiTietPhieuDatTruocID + ", trangThai=" + trangThai
				+ ", phieuDatTruoc=" + phieuDatTruoc + ", tieuDe=" + tieuDe + "]";
	}

}
