package ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JTabbedPane;
import java.awt.Color;
import javax.swing.border.SoftBevelBorder;

import entities.TaiKhoan;

import javax.swing.border.BevelBorder;

public class Giaodientongquat extends JFrame implements ActionListener {
	private JPanel contentPane;
	private JTabbedPane tabbedPane;

	private FramTinhtrangmathang framTinhtrangmathang = new FramTinhtrangmathang();
	private JMenu mnbTaiKhoan;
	private JMenuItem mnbLoaiTK;
	private JMenuItem mnbDangXuat;
	private DangNhapGUI gdtkdn;
	private JMenu mnQunLThng;
	private JMenu mnThngKBo;
	private JMenu mThueTra;
	private JMenu mDatTruoc;
	private JMenuItem mnbLoaiTK_3;
	private JMenuItem mnbTimKiemPhiTreHan;
	private JMenuItem mnbqlTTKH;
	private JMenuItem mnbQLTDTTmathang;
	private JMenuItem mnbQLTheLoai;
	private JMenuItem mnbQLTieuDe;
	private JMenuItem mnThue;
	private JMenuItem mnTra;
	private JMenuItem mnDatTruoc;
	private JMenuItem mnbDangNhap;
	private JMenuItem mnbQLKho;

	/**
	 * Create the frame.
	 */
	public Giaodientongquat(TaiKhoan tk) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1500, 900);

		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		JMenu mnQunLThue = new JMenu("Dịch vụ");
		menuBar.add(mnQunLThue);

		mnbTimKiemPhiTreHan = new JMenuItem("Tìm kiếm phí trễ hạn");
		mnQunLThue.add(mnbTimKiemPhiTreHan);

		mnQunLThng = new JMenu("Quản lý thông tin");
		menuBar.add(mnQunLThng);

		mThueTra = new JMenu("Thuê/Trả");
		menuBar.add(mThueTra);

		mDatTruoc = new JMenu("Quản lý Dặt Trước");
		menuBar.add(mDatTruoc);

		mnThue = new JMenuItem("Thuê Băng Đĩa");
		mThueTra.add(mnThue);

		mnTra = new JMenuItem("Trả Băng Đĩa");
		mThueTra.add(mnTra);

		mnDatTruoc = new JMenuItem("Đặt Trước");
		mDatTruoc.add(mnDatTruoc);

		mnbqlTTKH = new JMenuItem("Quàn lý thông tin khách hàng");
		mnQunLThng.add(mnbqlTTKH);
		
		mnbQLKho = new JMenuItem("Quàn lý kho");
		mnQunLThng.add(mnbQLKho);

		mnbQLTDTTmathang = new JMenuItem("Quản lý thây đổi thông tin mặt hàng");
		mnQunLThng.add(mnbQLTDTTmathang);

		mnbQLTheLoai = new JMenuItem("Quản lý thể loại");
		mnQunLThng.add(mnbQLTheLoai);

		mnbQLTieuDe = new JMenuItem("Quản lý tiêu đề");
		mnQunLThng.add(mnbQLTieuDe);

		mnThngKBo = new JMenu("Thống kê báo cáo");
		menuBar.add(mnThngKBo);

		mnbLoaiTK_3 = new JMenuItem("");
		mnThngKBo.add(mnbLoaiTK_3);

		mnbTaiKhoan = new JMenu("Tài khoản");
		menuBar.add(mnbTaiKhoan);

		mnbLoaiTK = new JMenuItem("");
		mnbTaiKhoan.add(mnbLoaiTK);

		mnbDangNhap = new JMenuItem("Đăng nhập");
		mnbTaiKhoan.add(mnbDangNhap);

		mnbDangXuat = new JMenuItem("Đăng xuất");
		mnbTaiKhoan.add(mnbDangXuat);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(12, 0, 1470, 827);
		tabbedPane.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		tabbedPane.setBackground(new Color(102, 204, 255));
		contentPane.add(tabbedPane);

		if (tk == null) {
			// cái nào nhân viên không sài được thì ẩn vào đây
			tk = new TaiKhoan();
			mnbLoaiTK.setText("Nhân Viên");
			mnbDangXuat.setVisible(false);
			mnbQLKho.setVisible(false);
			mnbQLTieuDe.setVisible(false);
			mnbQLTDTTmathang.setVisible(false);
			mnbQLTheLoai.setVisible(false);
		} else {
			mnbLoaiTK.setText("Admin");
			mnbDangXuat.setEnabled(true);
			mnbDangNhap.setVisible(false);
		}
		mnbDangXuat.addActionListener(this);
		mnbTimKiemPhiTreHan.addActionListener(this);
		mnbQLTDTTmathang.addActionListener(this);
		mnbqlTTKH.addActionListener(this);
		mnbQLTheLoai.addActionListener(this);
		mnbQLTieuDe.addActionListener(this);
		mnThue.addActionListener(this);
		mnTra.addActionListener(this);
		mnDatTruoc.addActionListener(this);
		mnbDangNhap.addActionListener(this);
		mnbQLKho.addActionListener(this);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object o = e.getSource();
		if (o.equals(mnbDangXuat)) {
			this.setVisible(false);
			gdtkdn = new DangNhapGUI();
			gdtkdn.setVisible(true);
			this.setVisible(false);
			DangNhapGUI tkdn = new DangNhapGUI();
			TaiKhoan tk = new TaiKhoan();
			tkdn.dangxuat();
		} else if (o.equals(mnbTimKiemPhiTreHan)) {
			TimKiemPhiTreHenGUI gdtkPTh = new TimKiemPhiTreHenGUI();
			gdtkPTh.setVisible(true);
			this.setVisible(false);
		} else if (o.equals(mnbqlTTKH)) {
			QuanLyKhachHangGUI gdQLKH = new QuanLyKhachHangGUI();
			gdQLKH.setVisible(true);
			this.setVisible(false);
		} else if (o.equals(mnbQLTDTTmathang)) {
			QuanLyThayDoiTTMatHangGUI gdQLTDTTMH = new QuanLyThayDoiTTMatHangGUI();
			gdQLTDTTMH.setVisible(true);
			this.setVisible(false);
		} else if (o.equals(mnbQLTheLoai)) {
			QuanLyTheLoaiGUI gdQLTL = new QuanLyTheLoaiGUI();
			gdQLTL.setVisible(true);
			this.setVisible(false);
		} else if (o.equals(mnbQLTieuDe)) {
			QuanLyTieuDeGUI gdQLTD = new QuanLyTieuDeGUI();
			gdQLTD.setVisible(true);
			this.setVisible(false);
		} else if (o.equals(mnThue)) {
			FrmThueDia frmThue = new FrmThueDia();
			frmThue.setVisible(true);
			this.setVisible(false);
		} else if (o.equals(mnTra)) {
			FrmTraDia frmTra = new FrmTraDia();
			frmTra.setVisible(true);
			this.setVisible(false);
		} else if (o.equals(mnDatTruoc)) {
			FrmDatTruoc frmDatTruoc = new FrmDatTruoc();
			frmDatTruoc.setVisible(true);
			this.setVisible(false);
		} else if (o.equals(mnbDangNhap)) {
			gdtkdn = new DangNhapGUI();
			gdtkdn.setVisible(true);
			this.setVisible(false);
		}else if (o.equals(mnbQLKho)) {
			FramQLiDia gdqlKho = new FramQLiDia();
			gdqlKho.setVisible(true);
			this.setVisible(false);
		}
	}
}
