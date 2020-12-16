package GiaoDien;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

import dao.implDAO.ChiTietHoaDonDAO;
import dao.implDAO.ChiTietPhiTreHenDAO;
import dao.implDAO.DiaDAO;
import dao.implDAO.KhachHangDAO;
import dao.implDAO.LoaiDiaDAO;
import dao.implDAO.PhieuTreHenDAO;
import dao.implDAO.TuaDeDAO;
import entities.ChiTietHoaDon;
import entities.ChiTietHoaDonID;
import entities.ChiTietPhiTreHen;
import entities.Dia;
import entities.KhachHang;
import entities.PhiTreHen;
import entities.PhieuDatTruoc;
import entities.TieuDe;
import entities.TrangThaiDia;

import javax.swing.JButton;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;

import java.awt.GridBagLayout;

public class FrmTraDia extends JFrame implements ActionListener {

	private JFrame frame;
	private JTextField txtMaDia;
	private JTextField txtTenDia;
	private JTextField txtMaHoaDon;
	private JTextField txtMaKH;
	private JTextField txtSoNgayThue;
	private JTextField txtNgayThue;
	private JTextField txtNgayTra;
	private JTextField txtPhiTreHen;
	private DiaDAO diaDAO=new DiaDAO();
	private TuaDeDAO tuaDeDAO = new TuaDeDAO();
	private LoaiDiaDAO loaiDiaDAO=new LoaiDiaDAO();
	private ChiTietHoaDonDAO chiTietHoaDonDAO=new ChiTietHoaDonDAO();
	private String maDia;
	private JButton btnTraDia,btnHuy,btnTiepTuc;
	private JTextField txtMaDiaTra;
	private JButton btnTimKiem;
	private PhieuTreHenDAO phieuTreHenDAO=new PhieuTreHenDAO();
	private ChiTietPhiTreHenDAO chiTietPhiTreHenDAO=new ChiTietPhiTreHenDAO();
	private KhachHangDAO khachHangDAO=new KhachHangDAO();
	private Boolean isKH=false;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmTraDia window = new FrmTraDia();
					window.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	public FrmTraDia() {
		initialize();
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		setTitle("Trả Băng Đĩa");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 1228, 643);
		setLocationRelativeTo(null);
		setResizable(false);
		getContentPane().setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(162, 13, 854, 582);
		getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblMaDia = new JLabel("Mã Đĩa Trả:");
		lblMaDia.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblMaDia.setBounds(12, 210, 144, 28);
		panel_1.add(lblMaDia);
		
		JLabel lblTenDiaTra = new JLabel("Tên Đĩa Trả:");
		lblTenDiaTra.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblTenDiaTra.setBounds(12, 251, 144, 28);
		panel_1.add(lblTenDiaTra);
		
		JLabel lblMaHoaDon = new JLabel("Mã Hóa Đơn:");
		lblMaHoaDon.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblMaHoaDon.setBounds(12, 160, 144, 28);
		panel_1.add(lblMaHoaDon);
		
		JLabel lblTomTac = new JLabel("Ngày Trả");
		lblTomTac.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblTomTac.setBounds(12, 436, 144, 34);
		panel_1.add(lblTomTac);
		
		JLabel lblKhachHang = new JLabel("Mã Khách Hàng:");
		lblKhachHang.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblKhachHang.setBounds(12, 292, 198, 34);
		panel_1.add(lblKhachHang);
		
		JLabel lblSNgyTi = new JLabel("Số Ngày Thuê:");
		lblSNgyTi.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblSNgyTi.setBounds(12, 345, 144, 28);
		panel_1.add(lblSNgyTi);
		
		JLabel lblNgaythue = new JLabel("Ngày Thuê:");
		lblNgaythue.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblNgaythue.setBounds(12, 386, 144, 34);
		panel_1.add(lblNgaythue);
		
		txtMaDia = new JTextField();
		txtMaDia.setEditable(false);
		txtMaDia.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		txtMaDia.setBounds(222, 203, 592, 28);
		panel_1.add(txtMaDia);
		txtMaDia.setColumns(10);
		
		txtTenDia = new JTextField();
		txtTenDia.setEditable(false);
		txtTenDia.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		txtTenDia.setColumns(10);
		txtTenDia.setBounds(222, 244, 592, 34);
		panel_1.add(txtTenDia);
		
		txtMaHoaDon = new JTextField();
		txtMaHoaDon.setEditable(false);
		txtMaHoaDon.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		txtMaHoaDon.setColumns(10);
		txtMaHoaDon.setBounds(222, 156, 592, 34);
		panel_1.add(txtMaHoaDon);
		
		txtMaKH = new JTextField();
		txtMaKH.setEditable(false);
		txtMaKH.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		txtMaKH.setColumns(10);
		txtMaKH.setBounds(222, 291, 592, 34);
		panel_1.add(txtMaKH);
		
		txtSoNgayThue = new JTextField();
		txtSoNgayThue.setEditable(false);
		txtSoNgayThue.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		txtSoNgayThue.setColumns(10);
		txtSoNgayThue.setBounds(222, 341, 592, 34);
		panel_1.add(txtSoNgayThue);
		
		txtNgayThue = new JTextField();
		txtNgayThue.setEditable(false);
		txtNgayThue.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		txtNgayThue.setColumns(10);
		txtNgayThue.setBounds(222, 388, 592, 34);
		panel_1.add(txtNgayThue);
		
		txtNgayTra = new JTextField();
		txtNgayTra.setEditable(false);
		txtNgayTra.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		txtNgayTra.setColumns(10);
		txtNgayTra.setBounds(222, 435, 592, 34);
		panel_1.add(txtNgayTra);
		
		JLabel lblNewLabel_1 = new JLabel("CHI TIẾT ĐĨA TRẢ");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblNewLabel_1.setBounds(178, 95, 538, 48);
		panel_1.add(lblNewLabel_1);
		
		JLabel lblPhTrHn = new JLabel("Phí Trễ Hẹn:");
		lblPhTrHn.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblPhTrHn.setBounds(12, 483, 144, 28);
		panel_1.add(lblPhTrHn);
		
		txtPhiTreHen = new JTextField();
		txtPhiTreHen.setEditable(false);
		txtPhiTreHen.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		txtPhiTreHen.setColumns(10);
		txtPhiTreHen.setBounds(222, 477, 592, 34);
		panel_1.add(txtPhiTreHen);
		
		btnTraDia = new JButton("TRẢ ĐĨA");
		btnTraDia.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnTraDia.setBounds(174, 535, 199, 34);
		panel_1.add(btnTraDia);
		
		btnHuy = new JButton("HỦY");
		btnHuy.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnHuy.setBounds(632, 535, 126, 34);
		panel_1.add(btnHuy);
		
		btnTiepTuc = new JButton("TIẾP TỤC");
		btnTiepTuc.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnTiepTuc.setBounds(409, 535, 178, 34);
		panel_1.add(btnTiepTuc);
		
		JLabel lblNewLabel = new JLabel("Nhập Mã Địa Trả:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel.setBounds(12, 38, 126, 28);
		panel_1.add(lblNewLabel);
		
		txtMaDiaTra = new JTextField();
		txtMaDiaTra.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		txtMaDiaTra.setColumns(10);
		txtMaDiaTra.setBounds(150, 32, 511, 34);
		panel_1.add(txtMaDiaTra);
		
		btnTimKiem = new JButton("TÌM KIẾM");
		btnTimKiem.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnTimKiem.setBounds(673, 32, 169, 34);
		panel_1.add(btnTimKiem);
		
		btnTraDia.addActionListener(this);
		btnHuy.addActionListener(this);
		btnTiepTuc.addActionListener(this);
//		btnTraDia.addActionListener(this);
		btnTimKiem.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object o=e.getSource();
		if(o.equals(btnHuy)) {
			setVisible(false);
		}
		if(o.equals(btnTiepTuc)) {
			
		}
		if(o.equals(btnTraDia)) {
			Dia dia= diaDAO.timTheoMa(Long.parseLong(txtMaDia.getText().toString()));
			dia.setTrangThai(TrangThaiDia.sanSangChoThue);
			diaDAO.sua(dia);
			
			String maDia=txtMaDia.getText();
			ChiTietHoaDon cthd=chiTietHoaDonDAO.timTheoMaDia(Long.parseLong(maDia));
			Period period= Period.between(cthd.getHoaDon().getNgayThue().plusDays(Long.parseLong(String.valueOf(cthd.getSoNgayThue()))),LocalDate.now()) ;
			System.out.println(period.getDays());
			if(period.getDays() >  0) {
				ChiTietPhiTreHen ct=new ChiTietPhiTreHen();
				ct.setDia(diaDAO.timTheoMa(Long.parseLong(txtMaDia.getText())));
				int soNgay=cthd.getSoNgayThue();
				ct.setNgayPhaiTra(cthd.getHoaDon().getNgayThue().plusDays(Long.parseLong(String.valueOf(soNgay))));
				ct.setNgayThue(cthd.getHoaDon().getNgayThue());
				ct.setNgayTra(LocalDate.now());
				ct.setTrangThai("TRUE");
				ct.setPhiTreHen(new PhiTreHen());
				System.out.println(ct);
				chiTietPhiTreHenDAO.them(ct);
				
			}
			
			txtMaHoaDon.setText("");
			txtMaKH.setText("");		
			txtMaDia.setText("");
			txtTenDia.setText("");
			txtNgayThue.setText("");
			txtNgayTra.setText("");
			txtSoNgayThue.setText("");
			txtMaDiaTra.setText("");
		}
		if(o.equals(btnTimKiem)) {
			maDia=txtMaDiaTra.getText();
			Dia dia=diaDAO.timTheoMa(Long.parseLong(maDia));
			if(dia.getTrangThai() == TrangThaiDia.daThue) {
				ChiTietHoaDon ct=chiTietHoaDonDAO.timTheoMaDia(Long.parseLong(maDia));
				
				DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
				txtMaHoaDon.setText(String.valueOf(ct.getHoaDon().getMaHoaDon()));
				txtMaKH.setText(String.valueOf(ct.getHoaDon().getKhachHang().getMaKhachHang()));		
				txtMaDia.setText(String.valueOf(dia.getMaDia()));
				txtTenDia.setText(dia.getTuaDe().getTenTieuDe());
				txtNgayThue.setText(ct.getHoaDon().getNgayThue().format(formatter));
				txtNgayTra.setText(LocalDate.now().format(formatter));
				txtSoNgayThue.setText(String.valueOf(ct.getSoNgayThue()));
				String songayThue=String.valueOf(ct.getSoNgayThue());
				
				LocalDate ngayPhaiTra=ct.getHoaDon().getNgayThue().plusDays(Long.parseLong(songayThue));
				Period period= Period.between(ngayPhaiTra,LocalDate.now()) ;
				if(period.getDays()>0) {
					Double tienPhi=period.getDays() * ct.getDia().getTuaDe().getLoaiDia().getPhiTreHan();
					txtPhiTreHen.setText(String.valueOf(tienPhi));
				}
				else {
					txtPhiTreHen.setText("0");
				}
			}
			else {
				JOptionPane.showMessageDialog(this, "Mã Đĩa Không Đúng!");
				
			}
		}
	}
}
