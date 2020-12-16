package GiaoDien;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import dao.implDAO.ChiTietHoaDonDAO;
import dao.implDAO.DiaDAO;
import dao.implDAO.HoaDonDAO;
import dao.implDAO.KhachHangDAO;
import dao.implDAO.LoaiDiaDAO;
import dao.implDAO.PhieuTreHenDAO;
import dao.implDAO.TuaDeDAO;
import entities.ChiTietHoaDon;
import entities.Dia;
import entities.HoaDon;
import entities.KhachHang;
import entities.PhiTreHen;
import entities.TieuDe;
import entities.TrangThaiDia;

import javax.swing.JTextArea;
import java.awt.SystemColor;
import javax.swing.UIManager;


public class FrmThueDia extends JFrame implements ActionListener {

	private JFrame frame;
	
	private JPanel contentPane;
	private JTable table,tblGioHang;
	private DefaultTableModel tablemodel, tablemodel1;
	private JTextField txtTimDia;
//	private QuanLyBangDia BD;
///	private QuanLyChiTietHoaDon CT;
////	private QuanLyHoaDon HD;
//	private QuanLyTheLoai TL;
//	private QuanLyKhachHang KH;
	private JButton btnTimKiemDia, btnHuyKH,btnTimKiemKH,btnThemGioHang,btnLapPhieuThue;
	private String maKH, maNV;
	private JTextField txtKhachHang;
	private JTextField txtSoDienThoai;
	private JLabel lblTimKiem;
	private JTextField txtTimKiemKH;
	private JPanel panel_3;
	private JLabel label;
	private JLabel lblMaDia;
	private JLabel lblTenDia;
	private JLabel lblLoai;
	private JLabel lblTomTacDia;
	private JLabel lblGiaDia;
	private JLabel lblNgayDia;
	private JTextField txtMaDia;
	private JTextField txtTenDia;
	private JTextField txtLoaiDia;
	private JTextField txtGiaDia;
	private JTextField txtNgayDia;
	private JTextArea txtrATomTac;
	private KhachHangDAO khacHangDAO=new KhachHangDAO();
	private DiaDAO diaDAO=new DiaDAO();
	private TuaDeDAO tuaDeDAO=new TuaDeDAO();
	private LoaiDiaDAO loaiDiaDAO=new LoaiDiaDAO();
	private HoaDonDAO hoaDonDAO= new HoaDonDAO();
	private ChiTietHoaDonDAO chiTietHoaDonDAO=new ChiTietHoaDonDAO();
	private PhieuTreHenDAO phieuTreHenDAO=new PhieuTreHenDAO();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmThueDia window = new FrmThueDia();
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
	public FrmThueDia() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
//		this.maKH = maKH;
//		this.maNV = maNV;
		setTitle("Thuê Băng Đĩa");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 1228, 643);
		setLocationRelativeTo(null);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		

		JPanel panel = new JPanel();
		panel.setBounds(10, 218, 568, 390);
		panel.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0)), "Gi\u1ECF H\u00E0ng", TitledBorder.LEADING,
				TitledBorder.TOP, null, null));
		panel.setBackground(Color.WHITE);
		contentPane.add(panel);
		panel.setLayout(null);

		String[] Name = "Mã Băng Đĩa;Tên Băng Đĩa;Đơn Giá;Số ngày thuê".split(";");
		tablemodel1 = new DefaultTableModel(Name, 0);
		JScrollPane scrollPane = new JScrollPane(tblGioHang = new JTable(tablemodel1),
				JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scrollPane.setBounds(10, 21, 502, 301);
		panel.add(scrollPane);
		
		btnLapPhieuThue = new JButton("LẬP PHIẾU THUÊ");
		btnLapPhieuThue.setBounds(77, 327, 175, 50);
		panel.add(btnLapPhieuThue);
		
		JButton btnTroLai = new JButton("TRỞ LẠI");
		btnTroLai.setBounds(301, 327, 127, 50);
		panel.add(btnTroLai);

		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0)),
				"T\u00ECm Ki\u1EBFm B\u0103ng \u0110\u0129a", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.setBackground(Color.WHITE);
		panel_1.setBounds(590, 13, 593, 183);
		contentPane.add(panel_1);
		panel_1.setLayout(null);

		JLabel lblMaDiaThue = new JLabel("Mã Đĩa Thuê :");
		lblMaDiaThue.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblMaDiaThue.setBounds(12, 77, 94, 22);
		panel_1.add(lblMaDiaThue);

		txtTimDia = new JTextField();
		txtTimDia.setColumns(10);
		txtTimDia.setBounds(122, 78, 405, 22);
		panel_1.add(txtTimDia);

		btnTimKiemDia = new JButton("Tìm Kiếm");
		btnTimKiemDia.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnTimKiemDia.setBounds(270, 134, 103, 23);
		panel_1.add(btnTimKiemDia);

		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0)), "Th\u00F4ng tin kh\u00E1ch h\u00E0ng ",
				TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_2.setBackground(Color.WHITE);
		panel_2.setBounds(10, 13, 556, 190);
		contentPane.add(panel_2);
		panel_2.setLayout(null);

		btnHuyKH = new JButton("ĐỔI KHÁCH HÀNG");
		btnHuyKH.setBounds(186, 156, 191, 23);
		panel_2.add(btnHuyKH);
		btnHuyKH.setFont(new Font("Tahoma", Font.PLAIN, 14));

		btnHuyKH.addActionListener(this);

		JLabel lblTnKhchHng = new JLabel("Tên Khách Hàng :");
		lblTnKhchHng.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblTnKhchHng.setBounds(12, 84, 115, 26);
		panel_2.add(lblTnKhchHng);

		txtKhachHang = new JTextField();
		txtKhachHang.setEnabled(false);
		txtKhachHang.setEditable(false);
		txtKhachHang.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtKhachHang.setColumns(10);
		txtKhachHang.setBounds(155, 88, 349, 20);
		panel_2.add(txtKhachHang);

		JLabel lblSinThoi = new JLabel("Số Điện Thoại :");
		lblSinThoi.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblSinThoi.setBounds(12, 123, 105, 26);
		panel_2.add(lblSinThoi);

		txtSoDienThoai = new JTextField();
		txtSoDienThoai.setEnabled(false);
		txtSoDienThoai.setEditable(false);
		txtSoDienThoai.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtSoDienThoai.setColumns(10);
		txtSoDienThoai.setBounds(155, 123, 349, 20);
		panel_2.add(txtSoDienThoai);
		
		lblTimKiem = new JLabel("Nhập mã Khách Hàng:");
		lblTimKiem.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblTimKiem.setBounds(12, 45, 145, 26);
		panel_2.add(lblTimKiem);
		
		txtTimKiemKH = new JTextField();
		txtTimKiemKH.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtTimKiemKH.setColumns(10);
		txtTimKiemKH.setBounds(155, 48, 234, 20);
		panel_2.add(txtTimKiemKH);
		
		btnTimKiemKH = new JButton("Tìm Kiếm");
		btnTimKiemKH.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnTimKiemKH.setBounds(401, 47, 103, 23);
		panel_2.add(btnTimKiemKH);
		
		panel_3 = new JPanel();
		panel_3.setBounds(590, 226, 593, 369);
		contentPane.add(panel_3);
		panel_3.setLayout(null);
		
		lblMaDia = new JLabel("Mã Băng Đĩa:");
		lblMaDia.setBounds(19, 49, 116, 17);
		lblMaDia.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panel_3.add(lblMaDia);
		
		lblTenDia = new JLabel("Tên Băng Đĩa:");
		lblTenDia.setBounds(19, 79, 116, 17);
		lblTenDia.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panel_3.add(lblTenDia);
		
		lblLoai = new JLabel("Loại Đĩa:");
		lblLoai.setBounds(19, 109, 116, 17);
		lblLoai.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panel_3.add(lblLoai);
		
		lblTomTacDia = new JLabel("Tóm tắc:");
		lblTomTacDia.setBounds(19, 149, 94, 17);
		lblTomTacDia.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panel_3.add(lblTomTacDia);
		
		lblGiaDia = new JLabel("Giá Cho Thuê:");
		lblGiaDia.setBounds(19, 217, 116, 17);
		lblGiaDia.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panel_3.add(lblGiaDia);
		
		lblNgayDia = new JLabel("Ngày Thuê Tối đa:");
		lblNgayDia.setBounds(19, 247, 132, 17);
		lblNgayDia.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panel_3.add(lblNgayDia);
		
		label = new JLabel("Chi Tiết Băng Đĩa");
		label.setBounds(189, 13, 176, 28);
		label.setFont(new Font("Tahoma", Font.PLAIN, 23));
		panel_3.add(label);
		
		txtMaDia = new JTextField();
		txtMaDia.setFont(new Font("Tahoma", Font.BOLD, 14));
		txtMaDia.setEditable(false);
		txtMaDia.setColumns(10);
		txtMaDia.setBounds(147, 47, 361, 20);
		panel_3.add(txtMaDia);
		
		txtTenDia = new JTextField();
		txtTenDia.setFont(new Font("Tahoma", Font.BOLD, 14));
		txtTenDia.setEditable(false);
		txtTenDia.setColumns(10);
		txtTenDia.setBounds(147, 77, 361, 20);
		panel_3.add(txtTenDia);
		
		txtLoaiDia = new JTextField();
		txtLoaiDia.setFont(new Font("Tahoma", Font.BOLD, 14));
		txtLoaiDia.setEditable(false);
		txtLoaiDia.setColumns(10);
		txtLoaiDia.setBounds(147, 107, 361, 20);
		panel_3.add(txtLoaiDia);
		
		txtGiaDia = new JTextField();
		txtGiaDia.setFont(new Font("Tahoma", Font.BOLD, 14));
		txtGiaDia.setEditable(false);
		txtGiaDia.setColumns(10);
		txtGiaDia.setBounds(147, 215, 361, 20);
		panel_3.add(txtGiaDia);
		
		txtNgayDia = new JTextField();
		txtNgayDia.setFont(new Font("Tahoma", Font.BOLD, 14));
		txtNgayDia.setEditable(false);
		txtNgayDia.setColumns(10);
		txtNgayDia.setBounds(147, 245, 361, 20);
		panel_3.add(txtNgayDia);
		
		btnThemGioHang = new JButton("THÊM VÀO GIỎ HÀNG");
		btnThemGioHang.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnThemGioHang.setBounds(147, 279, 160, 25);
		panel_3.add(btnThemGioHang);
		
		JButton btnHuyChiTiet = new JButton("Hủy");
		btnHuyChiTiet.setBounds(352, 279, 97, 25);
		panel_3.add(btnHuyChiTiet);
		
		txtrATomTac = new JTextArea();
		txtrATomTac.setEditable(false);
		txtrATomTac.setBackground(UIManager.getColor("Button.light"));
		txtrATomTac.setBounds(147, 147, 361, 57);
		panel_3.add(txtrATomTac);
		btnTimKiemDia.addActionListener(this);

		btnTimKiemKH.addActionListener(this);
		btnTimKiemDia.addActionListener(this);
		btnThemGioHang.addActionListener(this);
		btnHuyKH.addActionListener(this);
		btnLapPhieuThue.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object o = e.getSource();
		if(o.equals(btnTimKiemKH)) {
			long ma=Long.parseLong(txtTimKiemKH.getText());
			KhachHang kh= khacHangDAO.timTheoMa(ma);
			for(PhiTreHen p:phieuTreHenDAO.findALL()) {
				if(p.getKhachHang().getMaKhachHang() == ma) {
					int tb= JOptionPane.showConfirmDialog(this, "Khách Hàng có khoản phí trể hẹn! \n Khách hàng có muốn thanh toàn không!");
					if(tb == JOptionPane.YES_OPTION) {
						FrmThanhToanPhiTreHen frm=new FrmThanhToanPhiTreHen();
						frm.setVisible(true);
					}
					break;
				}
			}
			txtKhachHang.setText(kh.getHoTen());
			txtSoDienThoai.setText(kh.getSoDienThoai());
			txtTimKiemKH.setEditable(false);
		}
		else if(o.equals(btnTimKiemDia)) {
			String maDia=txtTimDia.getText();
			if(diaDAO.timTheoMa(Long.parseLong(maDia)).getTrangThai()==TrangThaiDia.sanSangChoThue) {
				Dia dia= diaDAO.timTheoMa(Long.parseLong(maDia));
				txtMaDia.setText(String.valueOf(dia.getMaDia()));	
				txtTenDia.setText(dia.getTuaDe().getTenTieuDe());
				txtNgayDia.setText(String.valueOf(dia.getTuaDe().getLoaiDia().getSoNgayThueToiDa()));
				txtGiaDia.setText(String.valueOf(dia.getTuaDe().getLoaiDia().getGiaThue()));
				txtrATomTac.setText(dia.getTuaDe().getTomTat());
				txtLoaiDia.setText(dia.getTuaDe().getLoaiDia().getTenLoaiDia().toString());
			}
			else if(diaDAO.timTheoMa(Long.parseLong(maDia)).getTrangThai()==TrangThaiDia.daThue) {
				JOptionPane.showMessageDialog(this, "Mã Đĩa Đã Có Người Thuê!");
			}
			else {
				JOptionPane.showMessageDialog(this, "Mã Đĩa Đã Có Người Đặt Trước!");
			}
		}
		else if(o.equals(btnThemGioHang)) {
			String maDia=txtMaDia.getText();
			String tenDia=txtTenDia.getText();
			String donGia=txtGiaDia.getText();
			String snt= JOptionPane.showInputDialog(this, "Nhập số ngày khách muốn thê");
			
			String[] rowData= {maDia,tenDia,donGia,snt};
			tablemodel1.addRow(rowData);
			tblGioHang.setModel(tablemodel1);
		}
		else if(o.equals(btnHuyKH)) {
			txtTimKiemKH.setEditable(true);
			txtKhachHang.setText("");
			txtSoDienThoai.setText("");
		}
		else if(o.equals(btnLapPhieuThue)) {
			HoaDon hd=new HoaDon(LocalDate.now(), khacHangDAO.timTheoMa(Long.parseLong(txtTimKiemKH.getText())));
			hoaDonDAO.them(hd);
			
			int rowCount = tblGioHang.getRowCount();
			
			for(int i=0 ; i < rowCount ; i++) {
				String maDia=tblGioHang.getValueAt(i, 0).toString();
				String soNgay=tblGioHang.getValueAt(i, 3).toString();
				ChiTietHoaDon ct= new ChiTietHoaDon(hd, diaDAO.timTheoMa(Long.parseLong(maDia)), Integer.parseInt(soNgay));
				chiTietHoaDonDAO.them(ct);
				Dia dia=diaDAO.timTheoMa(Long.parseLong(maDia));
				dia.setTrangThai(TrangThaiDia.daThue);
				diaDAO.sua(dia);
			}
			//Xóa dự liệu Table
			for(int i=rowCount;i >0;i--) {
				tablemodel1.removeRow(i-1);
			}
			XoaRong();
		}
		
	}
	public void XoaRong() {
		txtMaDia.setText("");	
		txtTenDia.setText("");
		txtNgayDia.setText("");
		txtGiaDia.setText("");
		txtrATomTac.setText("");
		txtLoaiDia.setText("");
		txtTimDia.setText("");
		
		txtKhachHang.setText("");
		txtSoDienThoai.setText("");
		txtTimKiemKH.setEditable(true);
		txtTimKiemKH.setText("");
		
	}
}
