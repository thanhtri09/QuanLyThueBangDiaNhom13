package entities;

import java.io.Serializable;
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

@Entity(name = "TieuDe")
public class TieuDe implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long maTieuDe;
	@Column(columnDefinition = "NVARCHAR(255)")
	private String tenTieuDe;
	@Column(columnDefinition = "NVARCHAR(255)")
	private String tomTat;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "maLoaiDia")
	private LoaiDia loaiDia;
	@OneToMany(mappedBy = "tuaDe", cascade = CascadeType.ALL)
	private Set<Dia> dsDia = new HashSet<Dia>();
	@OneToMany(mappedBy = "tieuDe", cascade = CascadeType.ALL)
	private Set<ChiTietPhieuDatTruoc> dsChiTietPhieuDatTruoc = new HashSet<ChiTietPhieuDatTruoc>();
	
	
	
	

	public TieuDe(long maTieuDe, String tenTieuDe, String tomTat, LoaiDia loaiDia, Set<Dia> dsDia,
			Set<ChiTietPhieuDatTruoc> dsChiTietPhieuDatTruoc) {
		super();
		this.maTieuDe = maTieuDe;
		this.tenTieuDe = tenTieuDe;
		this.tomTat = tomTat;
		this.loaiDia = loaiDia;
		this.dsDia = dsDia;
		this.dsChiTietPhieuDatTruoc = dsChiTietPhieuDatTruoc;
	}




	public TieuDe() {
		super();
		// TODO Auto-generated constructor stub
	}




	public TieuDe(String tenTieuDe, String tomTat, LoaiDia loaiDia) {
		super();
		this.tenTieuDe = tenTieuDe;
		this.tomTat = tomTat;
		this.loaiDia = loaiDia;
	}




	public long getMaTieuDe() {
		return maTieuDe;
	}

	public void setMaTieuDe(long maTieuDe) {
		this.maTieuDe = maTieuDe;
	}

	public String getTenTieuDe() {
		return tenTieuDe;
	}

	public void setTenTieuDe(String tenTieuDe) {
		this.tenTieuDe = tenTieuDe;
	}

	public String getTomTat() {
		return tomTat;
	}

	public void setTomTat(String tomTat) {
		this.tomTat = tomTat;
	}

	public LoaiDia getLoaiDia() {
		return loaiDia;
	}

	public void setLoaiDia(LoaiDia loaiDia) {
		this.loaiDia = loaiDia;
	}

	public Set<Dia> getDsDia() {
		return dsDia;
	}

	public void setDsDia(Set<Dia> dsDia) {
		this.dsDia = dsDia;
	}

	public Set<ChiTietPhieuDatTruoc> getDsChiTietPhieuDatTruoc() {
		return dsChiTietPhieuDatTruoc;
	}

	public void setDsChiTietPhieuDatTruoc(Set<ChiTietPhieuDatTruoc> dsChiTietPhieuDatTruoc) {
		this.dsChiTietPhieuDatTruoc = dsChiTietPhieuDatTruoc;
	}

	@Override
	public String toString() {
		return "TieuDe [maTieuDe=" + maTieuDe + ", tenTieuDe=" + tenTieuDe + ", tomTat=" + tomTat + ", loaiDia="
				+ loaiDia + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (maTieuDe ^ (maTieuDe >>> 32));
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
		TieuDe other = (TieuDe) obj;
		if (maTieuDe != other.maTieuDe)
			return false;
		return true;
	}

}
