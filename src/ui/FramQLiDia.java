package ui;


import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JTable;

import javax.swing.border.EtchedBorder;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import dao.implDAO.DiaDAO;
import dao.implDAO.LoaiDiaDAO;
import dao.implDAO.TieuDeDAO;

import entities.LoaiDia;
import entities.TaiKhoan;

import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JTextArea;

public class FramQLiDia extends JFrame implements ActionListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtMaidia;
	public static JPanel jp1;
	private JTable tblDSLoaiDia,tblDSDia,tblDSTieuDe,tblDSTuaDe;

	public static DefaultTableModel tablemodel = new DefaultTableModel();
	private JTextField txtMatieude;
	private JTextField txtTentieude;
	private JTextField txtMaLoaiDia;
	private JTextField txtGiathue;
	private JTextField txtPhiTreHen;
	private JTextField txtTenLoaiDia;
	private JTextField txtThoiGianThue;
	private JTextField txtmaTuaDe;
	private JTextField txtTenTuaDe;
	private DefaultTableModel tableModel,tableModel1,tableModel2,tableModel3;
	
	private JComboBox cmbTrangthai;
	private JComboBox cmbMaTieuDe;
	private JComboBox cmbTimkiemdia;
	
	
	
	
	private JPanel jpnDia ;
	private JPanel jpnListDia;
	private JPanel jpnChucNangDia;
	
	private JLabel lblMadia;
	private JLabel lblTrangthai;
	private JLabel lblMaTieuDe;
	private JLabel lblTimkiemDia;
	private JLabel lblMaLoaiDia_TuaDe;
	private JLabel lblMaTuaDe;
	private JLabel lblTentuaDe;
	
	
	
	private JButton btnSuaTuaDe;
	private JButton btnXoa_TuaDe;
	private JButton btnThemTuaDe;
	private JComboBox cmbMaLoaiDia_TuaDe;
	private LoaiDiaDAO loaiDiaDAO=new LoaiDiaDAO();
	private TieuDeDAO tuaDeDAO=new TieuDeDAO();
	private DiaDAO diaDAO=new DiaDAO();
	
	private JButton btnThemDia;
	private JButton btnThoat;
	
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FramQLiDia frame = new FramQLiDia();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public FramQLiDia() {
		setTitle("Quản lí đĩa");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1500, 900);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		 jp1 = new JPanel();
		jp1.setBackground(new Color(0, 206, 209));
		jp1.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		jp1.setBounds(10, 10, 1466, 778);
		contentPane.add(jp1);
		jp1.setLayout(null);
		
		jpnDia = new JPanel();
		jpnDia.setBackground(new Color(255, 255, 204));
		jpnDia.setBounds(10, 83, 677, 353);
		jpnDia.setBorder(new TitledBorder(null, "Thu\u1ED9c t\u00EDnh c\u1EE7a \u0111\u0129a", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(255, 0, 0)));
		jp1.add(jpnDia);
		jpnDia.setLayout(null);
		
		lblMadia = new JLabel("Mã đĩa:");
		lblMadia.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblMadia.setBounds(10, 28, 81, 25);
		jpnDia.add(lblMadia);
		
		txtMaidia = new JTextField();
		txtMaidia.setBounds(101, 29, 131, 19);
		jpnDia.add(txtMaidia);
		txtMaidia.setColumns(10);
		
		lblTrangthai = new JLabel("Trạng thái:");
		lblTrangthai.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblTrangthai.setBounds(10, 63, 81, 25);
		jpnDia.add(lblTrangthai);
		
		lblMaTieuDe = new JLabel("Mã tiêu đề:");
		lblMaTieuDe.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblMaTieuDe.setBounds(10, 98, 81, 25);
		jpnDia.add(lblMaTieuDe);
		
		cmbTrangthai = new JComboBox();
		cmbTrangthai.setBounds(101, 63, 130, 19);
		jpnDia.add(cmbTrangthai);
		
		cmbMaTieuDe = new JComboBox();
		cmbMaTieuDe.setBounds(101, 102, 131, 19);
		jpnDia.add(cmbMaTieuDe);
		
		jpnListDia = new JPanel();
		jpnListDia.setBorder(new TitledBorder(null, "List \u0110\u0129a", TitledBorder.LEADING, TitledBorder.TOP, null, Color.RED));
		jpnListDia.setBounds(242, 28, 372, 196);
		jpnDia.add(jpnListDia);
		jpnListDia.setLayout(null);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(10, 17, 352, 169);
		jpnListDia.add(scrollPane_1);
		

		String[] Name = "Mã Đĩa;Trạng Thái;Mã Tiêu Đề".split(";");
		tableModel1 = new DefaultTableModel(Name, 0);
		tblDSDia = new JTable();
		tblDSDia.setModel(tableModel1);
		scrollPane_1.setViewportView(tblDSDia);
		
		
		
		jpnChucNangDia = new JPanel();
		jpnChucNangDia.setBorder(new TitledBorder(null, "Ch\u1EE9c n\u0103ng", TitledBorder.LEADING, TitledBorder.TOP, null, Color.RED));
		jpnChucNangDia.setBounds(10, 245, 604, 85);
		jpnDia.add(jpnChucNangDia);
		jpnChucNangDia.setLayout(null);
		
		lblTimkiemDia = new JLabel("Tìm kiếm đĩa theo mã:");
		lblTimkiemDia.setBounds(10, 10, 162, 20);
		jpnChucNangDia.add(lblTimkiemDia);
		lblTimkiemDia.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		cmbTimkiemdia = new JComboBox();
		cmbTimkiemdia.setBounds(182, 12, 287, 20);
		jpnChucNangDia.add(cmbTimkiemdia);
		
		JButton btnTimkiemdia = new JButton("Tìm kiếm");
		btnTimkiemdia.setBounds(479, 9, 111, 20);
		jpnChucNangDia.add(btnTimkiemdia);
		btnTimkiemdia.setBackground(Color.LIGHT_GRAY);
		btnTimkiemdia.setFont(new Font("Tahoma", Font.PLAIN, 18));
		
		JButton btnXoaDia = new JButton("Xóa");
		btnXoaDia.setBounds(300, 48, 74, 31);
		jpnChucNangDia.add(btnXoaDia);
		btnXoaDia.setBackground(Color.LIGHT_GRAY);
		btnXoaDia.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		JButton btnSuaDia = new JButton("Sửa");
		btnSuaDia.setBounds(482, 48, 74, 31);
		jpnChucNangDia.add(btnSuaDia);
		btnSuaDia.setBackground(Color.LIGHT_GRAY);
		btnSuaDia.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		btnThemDia = new JButton("Thêm");
		btnThemDia.setBounds(78, 47, 79, 31);
		jpnChucNangDia.add(btnThemDia);
		btnThemDia.setBackground(Color.LIGHT_GRAY);
		btnThemDia.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnThemDia.addActionListener(this);
		
		JLabel lblNewLabel_2 = new JLabel("QUẢN LÍ ĐĨA");
		lblNewLabel_2.setForeground(new Color(255, 0, 0));
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 39));
		lblNewLabel_2.setBounds(577, 28, 261, 45);
		jp1.add(lblNewLabel_2);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Thu\u00F4c t\u00EDnh ti\u00EAu \u0111\u1EC1", TitledBorder.LEADING, TitledBorder.TOP, null, Color.RED));
		panel.setBounds(690, 83, 766, 353);
		jp1.add(panel);
		panel.setLayout(null);
		
		JLabel lblMatieude = new JLabel("Mã tiêu đề:");
		lblMatieude.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblMatieude.setBounds(20, 27, 81, 25);
		panel.add(lblMatieude);
		
		txtMatieude = new JTextField();
		txtMatieude.setColumns(10);
		txtMatieude.setBounds(111, 31, 131, 19);
		panel.add(txtMatieude);
		
		JLabel lblteniteude = new JLabel("Tên tiêu đề:");
		lblteniteude.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblteniteude.setBounds(20, 63, 81, 25);
		panel.add(lblteniteude);
		
		txtTentieude = new JTextField();
		txtTentieude.setColumns(10);
		txtTentieude.setBounds(111, 67, 131, 19);
		panel.add(txtTentieude);
		
		JLabel lblTomtattieude = new JLabel("Tóm tắt:");
		lblTomtattieude.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblTomtattieude.setBounds(20, 98, 81, 25);
		panel.add(lblTomtattieude);
		
		JTextArea txtTomTattieude = new JTextArea();
		txtTomTattieude.setBounds(111, 99, 131, 44);
		panel.add(txtTomTattieude);
		
		JLabel lblMaloaidia_tieude = new JLabel("Mã loại đĩa:");
		lblMaloaidia_tieude.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblMaloaidia_tieude.setBounds(20, 168, 81, 25);
		panel.add(lblMaloaidia_tieude);
		
		JComboBox cmbMaloaiDia_tieude = new JComboBox();
		cmbMaloaiDia_tieude.setBounds(111, 171, 131, 19);
		panel.add(cmbMaloaiDia_tieude);
		
		JPanel jpnTieuDe = new JPanel();
		jpnTieuDe.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "List Ti\u00EAu \u0110\u1EC1", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(255, 0, 0)));
		jpnTieuDe.setBounds(260, 27, 397, 196);
		panel.add(jpnTieuDe);
		jpnTieuDe.setLayout(null);
		
		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(10, 20, 352, 169);
		jpnTieuDe.add(scrollPane_2);
		
		

		String[] Name12 = "Mã Tiêu Đề;Tên Tiêu Đề;Tóm Tắt;Mã Loại Đĩa".split(";");
		tableModel2 = new DefaultTableModel(Name12, 0);
		tblDSTieuDe = new JTable();
		tblDSTieuDe.setModel(tableModel2);
		scrollPane_2.setViewportView(tblDSTieuDe);
		
		JPanel jpnChucnangTieude = new JPanel();
		jpnChucnangTieude.setLayout(null);
		jpnChucnangTieude.setBorder(new TitledBorder(null, "Ch\u1EE9c n\u0103ng", TitledBorder.LEADING, TitledBorder.TOP, null, Color.RED));
		jpnChucnangTieude.setBounds(20, 233, 629, 85);
		panel.add(jpnChucnangTieude);
		
		JLabel lblTimkiemtieude = new JLabel("Tìm kiếm tiêu đề theo mã:");
		lblTimkiemtieude.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblTimkiemtieude.setBounds(10, 10, 200, 20);
		jpnChucnangTieude.add(lblTimkiemtieude);
		
		JComboBox cmbTieude = new JComboBox();
		cmbTieude.setBounds(220, 12, 249, 20);
		jpnChucnangTieude.add(cmbTieude);
		
		JButton btnTimkiemtiuede = new JButton("Tìm kiếm");
		btnTimkiemtiuede.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnTimkiemtiuede.setBackground(Color.LIGHT_GRAY);
		btnTimkiemtiuede.setBounds(508, 12, 111, 20);
		jpnChucnangTieude.add(btnTimkiemtiuede);
		
		JButton btnXoaTieuDe = new JButton("Xóa");
		btnXoaTieuDe.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnXoaTieuDe.setBackground(Color.LIGHT_GRAY);
		btnXoaTieuDe.setBounds(287, 48, 74, 31);
		jpnChucnangTieude.add(btnXoaTieuDe);
		
		JButton btnSuaTieude = new JButton("Sửa");
		btnSuaTieude.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnSuaTieude.setBackground(Color.LIGHT_GRAY);
		btnSuaTieude.setBounds(482, 48, 74, 31);
		jpnChucnangTieude.add(btnSuaTieude);
		
		JButton btnThemtieude = new JButton("Thêm");
		btnThemtieude.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnThemtieude.setBackground(Color.LIGHT_GRAY);
		btnThemtieude.setBounds(78, 47, 79, 31);
		jpnChucnangTieude.add(btnThemtieude);
		
		JPanel jpnLoaiDia = new JPanel();
		jpnLoaiDia.setBorder(new TitledBorder(null, "Thu\u1ED9c t\u00EDnh lo\u1EA1i \u0111\u0129a:", TitledBorder.LEADING, TitledBorder.TOP, null, Color.RED));
		jpnLoaiDia.setBounds(10, 446, 677, 304);
		jp1.add(jpnLoaiDia);
		jpnLoaiDia.setLayout(null);
		
		JLabel lblMaLoaiDia = new JLabel("Mã loại đĩa:");
		lblMaLoaiDia.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblMaLoaiDia.setBounds(10, 27, 81, 25);
		jpnLoaiDia.add(lblMaLoaiDia);
		
		txtMaLoaiDia = new JTextField();
		txtMaLoaiDia.setColumns(10);
		txtMaLoaiDia.setBounds(101, 31, 131, 19);
		jpnLoaiDia.add(txtMaLoaiDia);
		
		JLabel lblGiaThue = new JLabel("Giá thuê:");
		lblGiaThue.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblGiaThue.setBounds(10, 71, 81, 25);
		jpnLoaiDia.add(lblGiaThue);
		
		txtGiathue = new JTextField();
		txtGiathue.setColumns(10);
		txtGiathue.setBounds(101, 75, 131, 19);
		jpnLoaiDia.add(txtGiathue);
		
		JLabel lblPhiTreHen = new JLabel("Phí trễ hẹn:");
		lblPhiTreHen.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblPhiTreHen.setBounds(10, 119, 81, 25);
		jpnLoaiDia.add(lblPhiTreHen);
		
		txtPhiTreHen = new JTextField();
		txtPhiTreHen.setColumns(10);
		txtPhiTreHen.setBounds(101, 123, 131, 19);
		jpnLoaiDia.add(txtPhiTreHen);
		
		JLabel lblTenLoaiDia = new JLabel("Tên loại đĩa:");
		lblTenLoaiDia.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblTenLoaiDia.setBounds(10, 166, 81, 25);
		jpnLoaiDia.add(lblTenLoaiDia);
		
		txtTenLoaiDia = new JTextField();
		txtTenLoaiDia.setColumns(10);
		txtTenLoaiDia.setBounds(101, 170, 131, 19);
		jpnLoaiDia.add(txtTenLoaiDia);
		
		JLabel lblThoigainthue = new JLabel("Thời gian thuê:");
		lblThoigainthue.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblThoigainthue.setBounds(10, 215, 88, 25);
		jpnLoaiDia.add(lblThoigainthue);
		
		txtThoiGianThue = new JTextField();
		txtThoiGianThue.setColumns(10);
		txtThoiGianThue.setBounds(101, 219, 131, 19);
		jpnLoaiDia.add(txtThoiGianThue);
		
		JPanel jpnListLoaiDia = new JPanel();
		jpnListLoaiDia.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "List Lo\u1EA1i \u0111\u0129a", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(255, 0, 0)));
		jpnListLoaiDia.setBounds(242, 27, 372, 213);
		jpnLoaiDia.add(jpnListLoaiDia);
		jpnListLoaiDia.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 24, 352, 179);
		jpnListLoaiDia.add(scrollPane);
		
		
		String[] Name1 = "Mã Loại Đĩa;Giá Thuê;Tên Loại Đĩa;Phí Trễ Hẹn;Thời Gian Thuê".split(";");
		tableModel = new DefaultTableModel(Name1, 0);
		tblDSLoaiDia = new JTable();
		tblDSLoaiDia.setModel(tableModel);
		scrollPane.setViewportView(tblDSLoaiDia);
		
		JPanel jpnListTuaDe = new JPanel();
		jpnListTuaDe.setLayout(null);
		jpnListTuaDe.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Thu\u1ED9c t\u00EDnh t\u1EF1a \u0111\u1EC1:", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(255, 0, 0)));
		jpnListTuaDe.setBounds(690, 446, 766, 304);
		jp1.add(jpnListTuaDe);
		
		lblMaTuaDe = new JLabel("Mã tựa đề:");
		lblMaTuaDe.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblMaTuaDe.setBounds(10, 27, 81, 25);
		jpnListTuaDe.add(lblMaTuaDe);
		
		txtmaTuaDe = new JTextField();
		txtmaTuaDe.setColumns(10);
		txtmaTuaDe.setBounds(101, 31, 131, 19);
		jpnListTuaDe.add(txtmaTuaDe);
		
		lblTentuaDe = new JLabel("Tên tựa đề:");
		lblTentuaDe.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblTentuaDe.setBounds(10, 71, 81, 25);
		jpnListTuaDe.add(lblTentuaDe);
		
		txtTenTuaDe = new JTextField();
		txtTenTuaDe.setColumns(10);
		txtTenTuaDe.setBounds(101, 75, 131, 19);
		jpnListTuaDe.add(txtTenTuaDe);
		
		
		
		lblMaLoaiDia_TuaDe = new JLabel("Mã loại đĩa:");
		lblMaLoaiDia_TuaDe.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblMaLoaiDia_TuaDe.setBounds(10, 119, 81, 25);
		jpnListTuaDe.add(lblMaLoaiDia_TuaDe);
		
		JPanel panel_2_2_1 = new JPanel();
		panel_2_2_1.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "List t\u1EF1a \u0111\u1EC1", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(255, 0, 0)));
		panel_2_2_1.setBounds(242, 27, 397, 213);
		jpnListTuaDe.add(panel_2_2_1);
		panel_2_2_1.setLayout(null);
		
		JScrollPane scrollPane_2_1 = new JScrollPane();
		scrollPane_2_1.setBounds(10, 20, 377, 183);
		panel_2_2_1.add(scrollPane_2_1);
		
		String[] Name123 = "Mã Tựa Đề;Tên Tựa Đề;Mã Loại Đĩa".split(";");
		tableModel3 = new DefaultTableModel(Name123, 0);
		tblDSTuaDe = new JTable();
		tblDSTuaDe.setModel(tableModel3);
		scrollPane_2_1.setViewportView(tblDSTuaDe);
		
		
		cmbMaLoaiDia_TuaDe = new JComboBox();
		cmbMaLoaiDia_TuaDe.setBounds(101, 122, 131, 19);
		jpnListTuaDe.add(cmbMaLoaiDia_TuaDe);
		
		btnThemTuaDe = new JButton("Thêm");
		btnThemTuaDe.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnThemTuaDe.setBackground(Color.LIGHT_GRAY);
		btnThemTuaDe.setBounds(215, 250, 79, 31);
		jpnListTuaDe.add(btnThemTuaDe);
		
		btnXoa_TuaDe = new JButton("Xóa");
		btnXoa_TuaDe.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnXoa_TuaDe.setBackground(Color.LIGHT_GRAY);
		btnXoa_TuaDe.setBounds(636, 250, 74, 31);
		jpnListTuaDe.add(btnXoa_TuaDe);
		
		btnSuaTuaDe = new JButton("Sửa");
		btnSuaTuaDe.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnSuaTuaDe.setBackground(Color.LIGHT_GRAY);
		btnSuaTuaDe.setBounds(430, 250, 74, 31);
		jpnListTuaDe.add(btnSuaTuaDe);
		
		btnThoat = new JButton("Thoát");
		btnThoat.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnThoat.setBounds(1352, 801, 118, 39);
		contentPane.add(btnThoat);
		
		btnThoat.addActionListener(this);
		
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object o=e.getSource();
		if(o.equals(btnThemDia)){
			String maDia =txtMaidia.getText();	
		}else if (o.equals(btnThoat)) {
			DangNhapGUI tkdn = new DangNhapGUI();
			TaiKhoan tk = new TaiKhoan();
			tk = tkdn.getTk();
			Giaodientongquat gd = new Giaodientongquat(tk);
			gd.setVisible(true);
			this.setVisible(false);
		}
		
		// TODO Auto-generated method stub
		
		
	}
	public void getDuLieuBangLoaiDia() {
		
		for(LoaiDia ld:loaiDiaDAO.findALL()) {
			String maLoaiDia=String.valueOf(ld.getMaLoaiDia());
			String giaThue=String.valueOf(ld.getGiaThue());
			String phiTreHen=String.valueOf(ld.getPhiTreHan());
			String tenLoaiDia=String.valueOf(ld.getTenLoaiDia());
			String soNgayThue=String.valueOf(ld.getSoNgayThueToiDa());
			
			

		
		}
	}
}
