package GiaoDien;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import dao.implDAO.ChiTietHoaDonDAO;
import dao.implDAO.ChiTietPhiTreHenDAO;
import dao.implDAO.DiaDAO;
import dao.implDAO.HoaDonDAO;
import dao.implDAO.KhachHangDAO;
import dao.implDAO.LoaiDiaDAO;
import dao.implDAO.PhieuDatTruocDAO;
import dao.implDAO.TuaDeDAO;
import entities.ChiTietPhiTreHen;
import entities.ChiTietPhiTreHenID;
import entities.Dia;
import entities.KhachHang;
import javax.swing.SwingConstants;

public class FrmThanhToanPhiTreHen extends JFrame implements ActionListener,MouseListener {
	private JPanel contentPane;
	private JTable table,tblChiTiet;
	private DefaultTableModel  tablemodel1;
	private JButton btnHuyKH,btnTimKiemKH,btnThanhToan,btnXacNhanKhachHang,btnXoa;
	private String maKH, maNV;
	private JTextField txtKhachHang;
	private JTextField txtSoDienThoai;
	private JLabel lblTimKiem;
	private JTextField txtTimKiemKH;
	private JPanel panel_3;
	private JLabel lblChiTitPh;
	private JLabel lblMaDia;
	private JLabel lblTenDia;
	private JLabel lblLoai;
	private JLabel lblGiaDia;
	private JLabel lblNgayDia;
	private JTextField txtMaDia;
	private JTextField txtMaPhi;
	private JTextField txtNgayThue;
	private JTextField txtNgayPhaiTra;
	private JTextField txtNgayTra;
	private KhachHangDAO khachHangDAO=new KhachHangDAO();
	private DiaDAO diaDAO=new DiaDAO();
	private TuaDeDAO tuaDeDAO=new TuaDeDAO();
	private LoaiDiaDAO loaiDiaDAO=new LoaiDiaDAO();
	private HoaDonDAO hoaDonDAO= new HoaDonDAO();
	private ChiTietHoaDonDAO chiTietHoaDonDAO=new ChiTietHoaDonDAO();
	private PhieuDatTruocDAO phieuDatTruocDAO=new PhieuDatTruocDAO();
	private ChiTietPhiTreHenDAO chiTietPhiTreHenDAO=new ChiTietPhiTreHenDAO();
	private JTextField txtTienPhat;
	private JButton btnThoat;
	
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmThanhToanPhiTreHen window = new FrmThanhToanPhiTreHen();
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
	public FrmThanhToanPhiTreHen() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
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
		panel.setBounds(10, 255, 568, 353);
		panel.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0)), "Gi\u1ECF H\u00E0ng", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel.setBackground(Color.WHITE);
		contentPane.add(panel);
		panel.setLayout(null);

		String[] Name = "Mã Phí Trễ Hẹn;Mã Băng Đĩa;Ngày Thuê;Ngày Phải Trả;Ngày Trả;Tiền Phạt".split(";");
		tablemodel1 = new DefaultTableModel(Name, 0);
		JScrollPane scrollPane = new JScrollPane(tblChiTiet = new JTable(tablemodel1),
				JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scrollPane.setBounds(10, 21, 502, 301);
		panel.add(scrollPane);

		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0)), "Th\u00F4ng tin kh\u00E1ch h\u00E0ng ",
				TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_2.setBackground(Color.WHITE);
		panel_2.setBounds(10, 13, 556, 229);
		contentPane.add(panel_2);
		panel_2.setLayout(null);

		btnHuyKH = new JButton("ĐỔI KHÁCH HÀNG");
		btnHuyKH.setBounds(259, 174, 191, 23);
		panel_2.add(btnHuyKH);
		btnHuyKH.setFont(new Font("Tahoma", Font.PLAIN, 14));

		btnHuyKH.addActionListener(this);

		JLabel lblTnKhchHng = new JLabel("Tên Khách Hàng :");
		lblTnKhchHng.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblTnKhchHng.setBounds(12, 84, 115, 26);
		panel_2.add(lblTnKhchHng);

		txtKhachHang = new JTextField();
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
		
		btnXacNhanKhachHang = new JButton("XÁC NHẬN");
		btnXacNhanKhachHang.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnXacNhanKhachHang.setBounds(105, 174, 103, 23);
		panel_2.add(btnXacNhanKhachHang);
		
		panel_3 = new JPanel();
		panel_3.setBounds(592, 13, 593, 286);
		contentPane.add(panel_3);
		panel_3.setLayout(null);
		
		lblMaDia = new JLabel("Mã Băng Đĩa:");
		lblMaDia.setBounds(19, 49, 116, 17);
		lblMaDia.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panel_3.add(lblMaDia);
		
		lblTenDia = new JLabel("Mã Phí Trễ Hẹn:");
		lblTenDia.setBounds(19, 79, 116, 17);
		lblTenDia.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panel_3.add(lblTenDia);
		
		lblLoai = new JLabel("Ngày Thuê:");
		lblLoai.setBounds(19, 109, 116, 17);
		lblLoai.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panel_3.add(lblLoai);
		
		lblGiaDia = new JLabel("Ngày Phải Trả");
		lblGiaDia.setBounds(12, 139, 116, 17);
		lblGiaDia.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panel_3.add(lblGiaDia);
		
		lblNgayDia = new JLabel("Ngày Trả :");
		lblNgayDia.setBounds(12, 169, 132, 17);
		lblNgayDia.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panel_3.add(lblNgayDia);
		
		lblChiTitPh = new JLabel("Chi Tiết Phí Trễ Hẹn");
		lblChiTitPh.setBounds(189, 13, 265, 28);
		lblChiTitPh.setFont(new Font("Tahoma", Font.PLAIN, 23));
		panel_3.add(lblChiTitPh);
		
		txtMaDia = new JTextField();
		txtMaDia.setFont(new Font("Tahoma", Font.BOLD, 14));
		txtMaDia.setEditable(false);
		txtMaDia.setColumns(10);
		txtMaDia.setBounds(147, 47, 361, 20);
		panel_3.add(txtMaDia);
		
		txtMaPhi = new JTextField();
		txtMaPhi.setFont(new Font("Tahoma", Font.BOLD, 14));
		txtMaPhi.setEditable(false);
		txtMaPhi.setColumns(10);
		txtMaPhi.setBounds(147, 77, 361, 20);
		panel_3.add(txtMaPhi);
		
		txtNgayThue = new JTextField();
		txtNgayThue.setFont(new Font("Tahoma", Font.BOLD, 14));
		txtNgayThue.setEditable(false);
		txtNgayThue.setColumns(10);
		txtNgayThue.setBounds(147, 107, 361, 20);
		panel_3.add(txtNgayThue);
		
		txtNgayPhaiTra = new JTextField();
		txtNgayPhaiTra.setFont(new Font("Tahoma", Font.BOLD, 14));
		txtNgayPhaiTra.setEditable(false);
		txtNgayPhaiTra.setColumns(10);
		txtNgayPhaiTra.setBounds(147, 139, 361, 20);
		panel_3.add(txtNgayPhaiTra);
		
		txtNgayTra = new JTextField();
		txtNgayTra.setFont(new Font("Tahoma", Font.BOLD, 14));
		txtNgayTra.setEditable(false);
		txtNgayTra.setColumns(10);
		txtNgayTra.setBounds(147, 169, 361, 20);
		panel_3.add(txtNgayTra);
		
		JLabel lblTinPht = new JLabel("Tiền Phạt:");
		lblTinPht.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblTinPht.setBounds(12, 205, 132, 17);
		panel_3.add(lblTinPht);
		
		txtTienPhat = new JTextField();
		txtTienPhat.setFont(new Font("Tahoma", Font.BOLD, 14));
		txtTienPhat.setEditable(false);
		txtTienPhat.setColumns(10);
		txtTienPhat.setBounds(147, 202, 361, 20);
		panel_3.add(txtTienPhat);
		
		btnThanhToan = new JButton("THANH TOÁN");
		btnThanhToan.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnThanhToan.setBounds(591, 388, 175, 50);
		contentPane.add(btnThanhToan);
		
		btnXoa = new JButton("XÓA");
		btnXoa.setBounds(778, 388, 127, 50);
		contentPane.add(btnXoa);
		
		btnThoat = new JButton("THOÁT");
		btnThoat.setBounds(937, 388, 127, 50);
		contentPane.add(btnThoat);
		btnTimKiemKH.addActionListener(this);
		btnXacNhanKhachHang.addActionListener(this);
		tblChiTiet.addMouseListener(this);
		btnXoa.addActionListener(this);
		btnThanhToan.addActionListener(this);
		btnHuyKH.addActionListener(this);
		btnThoat.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object o= e.getSource();
		if(o.equals(btnTimKiemKH)) {
			KhachHang khachHang=khachHangDAO.timTheoMa(Long.parseLong(txtTimKiemKH.getText()));
			txtKhachHang.setText(khachHang.getHoTen());
			txtSoDienThoai.setText(khachHang.getSoDienThoai());
		}
		else if(o.equals(btnXacNhanKhachHang)) {
			ArrayList<ChiTietPhiTreHen> listct= chiTietPhiTreHenDAO.timTheoMaKhachHang(Long.parseLong(txtTimKiemKH.getText()));
			int rowCount = tblChiTiet.getRowCount();
			for(int i=rowCount;i >0 ;i--) {
				tablemodel1.removeRow(i-1);
			}
			for(ChiTietPhiTreHen ct:listct) {
				if(ct.getTrangThai().equals("TRUE")) {
					String maPhieu=String.valueOf(ct.getPhiTreHen().getMaPhiTreHan());
					String maDia=String.valueOf(ct.getDia().getMaDia());
					DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
					String ngayTra=ct.getNgayTra().format(formatter);
					String ngayPhaiTra=ct.getNgayPhaiTra().format(formatter);
					String ngayThue =ct.getNgayThue().format(formatter);
					Period period= Period.between(ct.getNgayPhaiTra(),ct.getNgayTra());
					Dia dia=diaDAO.timTheoMa(Long.parseLong(maDia));
					Double donPhi=dia.getTuaDe().getLoaiDia().getPhiTreHan();
					Double tienPhat=period.getDays() * donPhi;
					String[] row = {maPhieu,maDia,ngayThue,ngayPhaiTra,ngayTra,String.valueOf(tienPhat)};
					
					tablemodel1.addRow(row);
				}
				
			}
			tblChiTiet.setModel(tablemodel1);
			txtTimKiemKH.setEditable(false);
			btnTimKiemKH.setEnabled(false);
		}
		else if(o.equals(btnXoa)) {
			String maPhi= txtMaPhi.getText();
			String maDia=txtMaDia.getText();
			ChiTietPhiTreHen ct=chiTietPhiTreHenDAO.timTheoMa(new ChiTietPhiTreHenID(Long.parseLong(maPhi), Long.parseLong(maDia)));
			ct.setTrangThai("FALSE");
			chiTietPhiTreHenDAO.sua(ct);
		}
		else if(o.equals(btnThanhToan)) {
			String maPhi= txtMaPhi.getText();
			String maDia=txtMaDia.getText();
			ChiTietPhiTreHen ct=chiTietPhiTreHenDAO.timTheoMa(new ChiTietPhiTreHenID(Long.parseLong(maPhi), Long.parseLong(maDia)));
			ct.setTrangThai("Đã Thanh Toán");
			chiTietPhiTreHenDAO.sua(ct);
		}
		else if(o.equals(btnHuyKH)) {
			txtTimKiemKH.setEditable(true);
			btnTimKiemKH.setEnabled(true);
		}
		else if(o.equals(btnThoat)) {
			setVisible(false);
		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		Object o=e.getSource();
		if(o.equals(tblChiTiet)) {
			int index= tblChiTiet.getSelectedRow();
			txtMaPhi.setText(tblChiTiet.getValueAt(index, 0).toString());
			txtMaDia.setText(tblChiTiet.getValueAt(index, 1).toString());
			txtNgayThue.setText(tblChiTiet.getValueAt(index, 2).toString());
			txtNgayPhaiTra.setText(tblChiTiet.getValueAt(index, 3).toString());
			txtNgayTra.setText(tblChiTiet.getValueAt(index, 4).toString());
			txtTienPhat.setText(tblChiTiet.getValueAt(index, 5).toString());

			
		}
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
}
