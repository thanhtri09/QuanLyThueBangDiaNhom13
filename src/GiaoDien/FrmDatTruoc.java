package GiaoDien;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import java.time.LocalDate;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import org.jdesktop.swingx.autocomplete.AutoCompleteDecorator;
import org.w3c.dom.events.EventTarget;
import org.w3c.dom.events.MouseEvent;
import org.w3c.dom.views.AbstractView;

import dao.implDAO.ChiTietPhieuDatTruocDAO;
import dao.implDAO.DiaDAO;
import dao.implDAO.KhachHangDAO;
import dao.implDAO.PhieuDatTruocDAO;
import dao.implDAO.TuaDeDAO;
import entities.ChiTietPhieuDatTruoc;
import entities.ChiTietPhieuDatTruocID;
import entities.Dia;
import entities.KhachHang;
import entities.PhieuDatTruoc;
import entities.TieuDe;
import entities.TrangThaiDia;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;

public class FrmDatTruoc extends JFrame implements ActionListener,MouseListener {

	private JFrame frame;
	private JTable tblDSDatTruoc;
	private JTextField txtDTTim;
	private JTextField txtMaDT;
	private JTextField txtDTTenTieuDe;
	private JTextField txtTenKH;
	private JTextField txtNgayDat;
	private JTextField txtKhachHangTim;
	private JTextField txtMaKhachHang;
	private JTextField txtTenKhachHang;
	private JTextField txtSDTKhachHang;
	private JTextField txtMaTieuDe;
	private JTextField txtTenTieuDe;
	private JTextField txtLoaiDia;
	private JTextField txtTomTac;
	private DefaultTableModel tableModel;
	private JButton btnKhachHangTim,btnchonDia,btnTuaDeTim,btnXacNhanKhachHang,btnDoiKhachHang,btnDoiTieuDe,btnXacNhanTieuDe,btnMoThem,btnThemPhieuDatTruoc,btnXoa;
	private PhieuDatTruocDAO phieuDatTruocDAO=new PhieuDatTruocDAO();
	private ChiTietPhieuDatTruocDAO chiTietPhieuDatTruocDAO=new ChiTietPhieuDatTruocDAO();
	private KhachHangDAO khachHangDAO=new KhachHangDAO();
	private TuaDeDAO tuaDeDAO =new TuaDeDAO();
	private DiaDAO diaDAO=new DiaDAO();
	private JComboBox cmbTuaDe,cmbChonDia;
	private DefaultComboBoxModel cboModeTimKiemTuaDe= new DefaultComboBoxModel();
	private DefaultComboBoxModel cboModeChonDia= new DefaultComboBoxModel();
	
	private Boolean isKhachHang,isTieuDe;
	private JTextField txtMaDiaDT;
	private JLabel lblChna;
	private JLabel lblMat_1;
	private JTextField txtMaDia;
	private Boolean isBoolean = true;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmDatTruoc window = new FrmDatTruoc();
					window.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public FrmDatTruoc() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		setTitle("Đặt Trước Băng Đĩa");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 1264, 719);
		setLocationRelativeTo(null);
		setResizable(false);
		getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(12, 13, 687, 268);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblmaDT = new JLabel("Mã Phiếu Đặt Trước:");
		lblmaDT.setBounds(0, 16, 137, 29);
		panel.add(lblmaDT);
		
		JLabel lblDTTenTieuDe =  new JLabel("Tên tiêu đề:");
		lblDTTenTieuDe.setBounds(0, 88, 137, 29);
		panel.add(lblDTTenTieuDe);
		
		JLabel lblTenKH = new JLabel("Tên Khách Hàng:");
		lblTenKH.setBounds(0, 133, 137, 29);
		panel.add(lblTenKH);
		
		JLabel lblNgayDat = new JLabel("Ngày Đặt:");
		lblNgayDat.setBounds(0, 175, 137, 29);
		panel.add(lblNgayDat);
		
		txtMaDT = new JTextField();
		txtMaDT.setEditable(false);
		txtMaDT.setColumns(10);
		txtMaDT.setBounds(140, 16, 514, 29);
		panel.add(txtMaDT);
		
		txtDTTenTieuDe = new JTextField();
		txtDTTenTieuDe.setEditable(false);
		txtDTTenTieuDe.setColumns(10);
		txtDTTenTieuDe.setBounds(140, 88, 514, 29);
		panel.add(txtDTTenTieuDe);
		
		txtTenKH = new JTextField();
		txtTenKH.setEditable(false);
		txtTenKH.setColumns(10);
		txtTenKH.setBounds(140, 130, 514, 29);
		panel.add(txtTenKH);
		
		txtNgayDat = new JTextField();
		txtNgayDat.setEditable(false);
		txtNgayDat.setColumns(10);
		txtNgayDat.setBounds(140, 175, 514, 29);
		panel.add(txtNgayDat);
		
		btnMoThem = new JButton("THÊM");
		btnMoThem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnMoThem.setBounds(83, 217, 106, 38);
		panel.add(btnMoThem);
		
		btnXoa = new JButton("XÓA");
		btnXoa.setBounds(222, 217, 106, 38);
		panel.add(btnXoa);
		
		btnThemPhieuDatTruoc = new JButton("LẬP PHIẾU ĐẶT TRƯỚC");
		btnThemPhieuDatTruoc.setBounds(348, 217, 188, 38);
		panel.add(btnThemPhieuDatTruoc);
		
		btnThemPhieuDatTruoc.setEnabled(false);
		
		JLabel lblMat = new JLabel("Mã Đĩa Đặt Trước:");
		lblMat.setBounds(0, 55, 137, 29);
		panel.add(lblMat);
		
		txtMaDiaDT = new JTextField();
		txtMaDiaDT.setEditable(false);
		txtMaDiaDT.setColumns(10);
		txtMaDiaDT.setBounds(140, 55, 514, 29);
		panel.add(txtMaDiaDT);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(12, 294, 687, 377);
		getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 67, 663, 297);
		panel_1.add(scrollPane);
		
		String[] Name = "Mã Phiếu Đặt Trước;Tên Băng Đĩa;Tên khách hàng đặt;Ngày đặt".split(";");
		tableModel = new DefaultTableModel(Name, 0);
		tblDSDatTruoc = new JTable();
		tblDSDatTruoc.setModel(tableModel);
		scrollPane.setViewportView(tblDSDatTruoc);
		
		JLabel lblDTTim = new JLabel("Mã Phiếu Đặt Trước:");
		lblDTTim.setBounds(12, 13, 137, 29);
		panel_1.add(lblDTTim);
		
		txtDTTim = new JTextField();
		txtDTTim.setBounds(175, 16, 399, 29);
		panel_1.add(txtDTTim);
		txtDTTim.setColumns(10);
		
		JButton btnDTTim = new JButton("TÌM KIẾM");
		btnDTTim.setBounds(578, 15, 97, 29);
		panel_1.add(btnDTTim);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(726, 13, 506, 268);
		getContentPane().add(panel_2);
		panel_2.setLayout(null);
		panel_2.setEnabled(false);
		
		JLabel lblKhachHangTim = new JLabel("Nhập Mã Khách Hàng Tìm:");
		lblKhachHangTim.setBounds(12, 16, 185, 29);
		panel_2.add(lblKhachHangTim);
		
		txtKhachHangTim = new JTextField();
		txtKhachHangTim.setColumns(10);
		txtKhachHangTim.setBounds(172, 16, 230, 29);
		panel_2.add(txtKhachHangTim);
		
		btnKhachHangTim = new JButton("TÌM KIẾM");
		btnKhachHangTim.setBounds(409, 15, 97, 29);
		panel_2.add(btnKhachHangTim);
		
		JLabel lblMaKhachHang = new JLabel("Mã Khách Hàng :");
		lblMaKhachHang.setBounds(12, 58, 185, 29);
		panel_2.add(lblMaKhachHang);
		
		JLabel lblTenKhachHang = new JLabel("Tên Khách Hàng:");
		lblTenKhachHang.setBounds(12, 100, 185, 29);
		panel_2.add(lblTenKhachHang);
		
		JLabel lblSDTKhachHang = new JLabel("Số Điện Thoại Khách Hàng:");
		lblSDTKhachHang.setBounds(12, 154, 185, 29);
		panel_2.add(lblSDTKhachHang);
		
		txtMaKhachHang = new JTextField();
		txtMaKhachHang.setEditable(false);
		txtMaKhachHang.setColumns(10);
		txtMaKhachHang.setBounds(172, 61, 322, 29);
		panel_2.add(txtMaKhachHang);
		
		txtTenKhachHang = new JTextField();
		txtTenKhachHang.setEditable(false);
		txtTenKhachHang.setColumns(10);
		txtTenKhachHang.setBounds(172, 103, 322, 29);
		panel_2.add(txtTenKhachHang);
		
		txtSDTKhachHang = new JTextField();
		txtSDTKhachHang.setEditable(false);
		txtSDTKhachHang.setColumns(10);
		txtSDTKhachHang.setBounds(172, 154, 322, 29);
		panel_2.add(txtSDTKhachHang);
		
		btnXacNhanKhachHang = new JButton("XÁC NHẬN");
		btnXacNhanKhachHang.setBounds(147, 204, 106, 38);
		panel_2.add(btnXacNhanKhachHang);
		
		btnDoiKhachHang = new JButton("ĐỔI KHÁCH HÀNG");
		btnDoiKhachHang.setBounds(296, 204, 150, 38);
		panel_2.add(btnDoiKhachHang);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBounds(726, 309, 501, 362);
		getContentPane().add(panel_3);
		panel_3.setLayout(null);
		
		JLabel lblNhpTnTa = new JLabel("Nhập Tên Tựa Đề Tìm:");
		lblNhpTnTa.setBounds(12, 16, 153, 29);
		panel_3.add(lblNhpTnTa);
		
		btnTuaDeTim = new JButton("TÌM KIẾM");
		btnTuaDeTim.setBounds(392, 15, 97, 29);
		panel_3.add(btnTuaDeTim);
		
		JLabel lblMaTieuDe = new JLabel("Mã Tiêu Đề :");
		lblMaTieuDe.setBounds(12, 132, 185, 29);
		panel_3.add(lblMaTieuDe);
		
		JLabel lblTenTieuDe = new JLabel("Tên Tiêu Đề:");
		lblTenTieuDe.setBounds(12, 182, 185, 29);
		panel_3.add(lblTenTieuDe);
		
		JLabel lblLoaiDia = new JLabel("Loại Đĩa:");
		lblLoaiDia.setBounds(12, 224, 185, 29);
		panel_3.add(lblLoaiDia);
		
		JLabel lblTomTac = new JLabel("Tóm Tắc:");
		lblTomTac.setBounds(12, 270, 185, 29);
		panel_3.add(lblTomTac);
		
		txtMaTieuDe = new JTextField();
		txtMaTieuDe.setEditable(false);
		txtMaTieuDe.setColumns(10);
		txtMaTieuDe.setBounds(156, 132, 322, 29);
		panel_3.add(txtMaTieuDe);
		
		txtTenTieuDe = new JTextField();
		txtTenTieuDe.setEditable(false);
		txtTenTieuDe.setColumns(10);
		txtTenTieuDe.setBounds(156, 171, 322, 29);
		panel_3.add(txtTenTieuDe);
		
		txtLoaiDia = new JTextField();
		txtLoaiDia.setEditable(false);
		txtLoaiDia.setColumns(10);
		txtLoaiDia.setBounds(156, 216, 322, 29);
		panel_3.add(txtLoaiDia);
		
		txtTomTac = new JTextField();
		txtTomTac.setEditable(false);
		txtTomTac.setColumns(10);
		txtTomTac.setBounds(156, 259, 322, 29);
		panel_3.add(txtTomTac);
		
		btnXacNhanTieuDe = new JButton("XÁC NHẬN");
		btnXacNhanTieuDe.setBounds(125, 311, 106, 38);
		panel_3.add(btnXacNhanTieuDe);
		
		btnDoiTieuDe = new JButton("ĐỔI TIÊU ĐỀ");
		btnDoiTieuDe.setBounds(285, 311, 159, 38);
		panel_3.add(btnDoiTieuDe);
		
		btnKhachHangTim.setEnabled(false);
		btnXacNhanKhachHang.setEnabled(false);
		btnDoiKhachHang.setEnabled(false);
		txtKhachHangTim.setEnabled(false);
		
		btnTuaDeTim.setEnabled(false);
		btnXacNhanTieuDe.setEnabled(false);
		btnDoiTieuDe.setEnabled(false);
		
		cmbTuaDe = new JComboBox();
		cmbTuaDe.setBounds(156, 19, 224, 22);
		panel_3.add(cmbTuaDe);
		
		
			
			lblChna = new JLabel("Chọn Đĩa:");
			lblChna.setBounds(12, 58, 153, 29);
			panel_3.add(lblChna);
			
			cmbChonDia = new JComboBox();
			cmbChonDia.setBounds(156, 61, 224, 22);
			panel_3.add(cmbChonDia);
			
			btnchonDia = new JButton("TÌM KIẾM");
			btnchonDia.setEnabled(false);
			btnchonDia.setBounds(392, 57, 97, 29);
			panel_3.add(btnchonDia);
			
			lblMat_1 = new JLabel("Mã Đĩa Đặt Trước :");
			lblMat_1.setBounds(12, 96, 185, 29);
			panel_3.add(lblMat_1);
			
			txtMaDia = new JTextField();
			txtMaDia.setEditable(false);
			txtMaDia.setColumns(10);
			txtMaDia.setBounds(156, 96, 322, 29);
			panel_3.add(txtMaDia);
			
		//
		
			isKhachHang=false;
			isTieuDe=false;
			//Xử lý ComboBox
			cboModeTimKiemTuaDe.removeAllElements();
			for(TieuDe td:tuaDeDAO.findALL()) {
				cboModeTimKiemTuaDe.addElement(td.getTenTieuDe());
			}		
			cmbTuaDe.setModel(cboModeTimKiemTuaDe);
			AutoCompleteDecorator.decorate(cmbTuaDe);
			
			
			
		getDuLieuBang();
		tblDSDatTruoc.addMouseListener(this);
		btnKhachHangTim.addActionListener(this);
		btnTuaDeTim.addActionListener(this);
		btnXacNhanKhachHang.addActionListener(this);
		btnDoiKhachHang.addActionListener(this);
		btnXacNhanTieuDe.addActionListener(this);
		btnDoiTieuDe.addActionListener(this);
		btnMoThem.addActionListener(this);
		btnXoa.addActionListener(this);
		btnThemPhieuDatTruoc.addActionListener(this);
		btnchonDia.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object o=e.getSource();
		if(o.equals(btnKhachHangTim)) {
			Long maKH=Long.parseLong(txtKhachHangTim.getText().toString());
			KhachHang kh= khachHangDAO.timTheoMa(maKH);
			txtMaKhachHang.setText(String.valueOf(kh.getMaKhachHang()));
			txtTenKhachHang.setText(kh.getHoTen());
			txtSDTKhachHang.setText(kh.getSoDienThoai());
		}
		else if(o.equals(btnTuaDeTim)) {
			isBoolean=true;
			System.out.println(isBoolean);
			String tenTuaDeTim= (String) cboModeTimKiemTuaDe.getSelectedItem();
			TieuDe tuaDe=tuaDeDAO.timTuaDeTheoTen(tenTuaDeTim);
			for(Dia d:tuaDe.getDsDia()) {
				if(d.getTrangThai() == TrangThaiDia.sanSangChoThue) {
					isBoolean=false;
				}
			}
			if(isBoolean==true) {
				txtMaTieuDe.setText(String.valueOf(tuaDe.getMaTieuDe()));
				txtTenTieuDe.setText(tuaDe.getTenTieuDe());
				txtLoaiDia.setText(tuaDe.getLoaiDia().getTenLoaiDia().toString());
				txtTomTac.setText(tuaDe.getTomTat());
				
				cboModeChonDia.removeAllElements();
				for(Dia d:diaDAO.findALL()) {
					if(d.getTuaDe().getTenTieuDe().equalsIgnoreCase(tenTuaDeTim)) {
						cboModeChonDia.addElement(d.getMaDia());
						cmbChonDia.setModel(cboModeChonDia);
					}
				}
				
				AutoCompleteDecorator.decorate(cmbChonDia);
				btnchonDia.setEnabled(true);
				btnTuaDeTim.setEnabled(false);
			}
			else {
				JOptionPane.showMessageDialog(this, "Đang có đĩa có sẳn không thể đặt trước!");
			}
		}
		else if(o.equals(btnchonDia)) {
			String maDia= (String) cboModeChonDia.getSelectedItem().toString();
			Dia d= diaDAO.timTheoMa(Long.parseLong(maDia));
			txtMaDia.setText(String.valueOf(d.getMaDia()));
		}
		else if(o.equals(btnMoThem)){
			btnKhachHangTim.setEnabled(true);
			btnXacNhanKhachHang.setEnabled(true);
			btnDoiKhachHang.setEnabled(true);
			txtKhachHangTim.setEnabled(true);
			
			btnTuaDeTim.setEnabled(true);
			btnXacNhanTieuDe.setEnabled(true);
			btnDoiTieuDe.setEnabled(true);
			cmbTuaDe.setEnabled(true);
			
			btnThemPhieuDatTruoc.setEnabled(false);
		}
		else if(o.equals(btnXoa)) {
			String maPhieu=txtMaDT.getText();
			ChiTietPhieuDatTruoc ct=chiTietPhieuDatTruocDAO.timTheoPhieu(Long.parseLong(maPhieu));
			ct.setTrangThai(false);
			chiTietPhieuDatTruocDAO.sua(ct);
//			Dia dia=diaDAO.ti
			
			
		}
		else if(o.equals(btnThemPhieuDatTruoc)) {
			ArrayList<Dia> list=diaDAO.timDiaTheoMaTieuDe(Long.parseLong(txtMaTieuDe.getText().toString()));
			Dia dia=list.get(0);
			dia.setTrangThai(TrangThaiDia.daGan);
			diaDAO.sua(dia);
			PhieuDatTruoc p=new PhieuDatTruoc(LocalDate.now(), khachHangDAO.timTheoMa(Long.parseLong(txtMaKhachHang.getText())));
			phieuDatTruocDAO.them(p);
			chiTietPhieuDatTruocDAO.them(new ChiTietPhieuDatTruoc(true, p, tuaDeDAO.timTheoMa(Long.parseLong(txtMaTieuDe.getText().toString()))));
			btnThemPhieuDatTruoc.setEnabled(false);
			getDuLieuBang();
		}
		else if(o.equals(btnXacNhanKhachHang)) {
			if(txtMaKhachHang.getText().toString().equals("")) {
				JOptionPane.showMessageDialog(this, "Mời bạn tìm kiếm khách hàng trước khi xác nhận!");
			}
			else {
				isKhachHang=true;
				setBtnLap();
				txtKhachHangTim.setEnabled(false);
				btnKhachHangTim.setEnabled(false);
			}
		}
		else if(o.equals(btnDoiKhachHang)) {
			isKhachHang=false;
			setBtnLap();
			txtKhachHangTim.setEnabled(true);
			btnKhachHangTim.setEnabled(true);
		}
		else if(o.equals(btnXacNhanTieuDe)) {
			if(txtMaTieuDe.getText().toString().equals("")) {
				JOptionPane.showMessageDialog(this, "Mời bạn tìm kiếm tựa đề trước khi xác nhận!");
			}
			else {
				isTieuDe=true;
				setBtnLap();
				cmbTuaDe.setEnabled(false);
				btnTuaDeTim.setEnabled(false);
			}
		}
		else if(o.equals(btnDoiTieuDe)) {
			isTieuDe=false;
			setBtnLap();
			cmbTuaDe.setEnabled(true);
			btnTuaDeTim.setEnabled(true);
		}
		
	}
	public void setBtnLap() {
		if(isKhachHang==true && isTieuDe == true) {
			btnThemPhieuDatTruoc.setEnabled(true);
		}
		else {
			btnThemPhieuDatTruoc.setEnabled(false);
		}
	}
	public void getDuLieuBang() {
		int rowCount=tblDSDatTruoc.getRowCount();
		for(int i=rowCount;i>0;i--) {
			tableModel.removeRow(i-1);
		}
		for(PhieuDatTruoc p:phieuDatTruocDAO.findALL()) {
			String maPhieu= String.valueOf(p.getMaPhieuDatTruoc());
			String tenKhachHang=p.getKhachHang().getHoTen();
			String ngayDat= "1-1-2020";
			for(ChiTietPhieuDatTruoc c:chiTietPhieuDatTruocDAO.findALL()) {
				if(c.getPhieuDatTruoc().getMaPhieuDatTruoc()== p.getMaPhieuDatTruoc()) {
					System.out.println("bbb");
					String tenTieuDe=c.getTieuDe().getTenTieuDe();
					String[]  row= {maPhieu,tenTieuDe,tenKhachHang,ngayDat};	
					tableModel.addRow(row);
					tblDSDatTruoc.setModel(tableModel);
				}
			}
		}
	}

	@Override
	public void mouseClicked(java.awt.event.MouseEvent e) {
		// TODO Auto-generated method stub
		Object o=e.getSource();
		if(o.equals(tblDSDatTruoc)) {
			int index=tblDSDatTruoc.getSelectedRow();
//			System.out.println(tblDSDatTruoc.getValueAt(index, 1));
			txtMaDT.setText(tblDSDatTruoc.getValueAt(index, 0).toString());
			txtDTTenTieuDe.setText(tblDSDatTruoc.getValueAt(index, 1).toString());
			txtTenKH.setText(tblDSDatTruoc.getValueAt(index, 2).toString());
			txtNgayDat.setText(tblDSDatTruoc.getValueAt(index, 3).toString());
		}
	}

	@Override
	public void mousePressed(java.awt.event.MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(java.awt.event.MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(java.awt.event.MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(java.awt.event.MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
}
