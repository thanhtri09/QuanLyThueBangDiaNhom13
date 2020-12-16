package ui;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.rmi.dgc.DGC;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.border.LineBorder;

import dao.implDAO.TaiKhoanDAO;
import entities.TaiKhoan;

import java.awt.SystemColor;
import javax.swing.SwingConstants;

public class DangNhapGUI extends JFrame implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private static JTextField txtTenTK;
	private static JPasswordField pwfMatKhau;
	private JLabel lblTiKhon;
	private JLabel lblMtKhu;
	private JButton btnDangNhap, btnThoat;
	private JLabel lblngNhp;
	private TaiKhoanDAO tkdao;
	private static TaiKhoan tkadmin;
	private JButton btnTroVe;

	public DangNhapGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Quản Lý Cửa Hàng Thuê Băng Đĩa");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 1014, 572);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBackground(SystemColor.inactiveCaptionBorder);
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.setBounds(340, 145, 340, 186);
		contentPane.add(panel);
		panel.setLayout(null);

		lblMtKhu = new JLabel("Mật Khẩu :");
		lblMtKhu.setBounds(10, 101, 85, 34);
		panel.add(lblMtKhu);
		lblMtKhu.setFont(new Font("Tahoma", Font.BOLD, 14));

		lblTiKhon = new JLabel("Tài Khoản :");
		lblTiKhon.setBounds(10, 61, 85, 34);
		panel.add(lblTiKhon);
		lblTiKhon.setFont(new Font("Tahoma", Font.BOLD, 14));

		btnDangNhap = new JButton("Đăng nhập");
		btnDangNhap.setBounds(103, 148, 117, 25);
		panel.add(btnDangNhap);
		btnDangNhap.setFont(new Font("Tahoma", Font.PLAIN, 14));

		btnThoat = new JButton("Thoát");
		btnThoat.setBounds(232, 148, 79, 25);
		panel.add(btnThoat);
		btnThoat.setFont(new Font("Tahoma", Font.PLAIN, 14));

		txtTenTK = new JTextField();
		txtTenTK.setBounds(105, 66, 206, 25);
		panel.add(txtTenTK);
		txtTenTK.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtTenTK.setColumns(10);

		pwfMatKhau = new JPasswordField();
		pwfMatKhau.setBounds(105, 106, 206, 25);
		panel.add(pwfMatKhau);
		pwfMatKhau.setFont(new Font("Tahoma", Font.PLAIN, 14));

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.CYAN);
		panel_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_1.setBounds(0, 0, 340, 34);
		panel.add(panel_1);
		panel_1.setLayout(null);

		lblngNhp = new JLabel("Đăng Nhập");
		lblngNhp.setHorizontalAlignment(SwingConstants.CENTER);
		lblngNhp.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblngNhp.setBounds(0, 0, 340, 34);
		panel_1.add(lblngNhp);

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(getClass().getResource("/icon/5474953677_e90dfcbb71_b.jpg")));
		lblNewLabel.setBounds(0, 0, 998, 533);
		contentPane.add(lblNewLabel);

		btnTroVe = new JButton("Trờ về màng hình chính");
		btnTroVe.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnTroVe.setBounds(775, 0, 223, 41);
		contentPane.add(btnTroVe);
		pwfMatKhau.addActionListener(this);
		btnDangNhap.addActionListener(this);
		btnThoat.addActionListener(this);
		btnTroVe.addActionListener(this);

	}

//	private String kiemTraTK(String tk, String mk) {
//		tkdao = new TaiKhoanDAO();
//		List<entities.TaiKhoan> list = tkdao.findALL();
//		for (TaiKhoan taiKhoan : list) {
//			if (tk.equals(taiKhoan.getUserName()))
//				if (mk.equals(taiKhoan.getPassWord()))
//					return taiKhoan.getUserName();
//		}
//		return null;
//
//	}
	private TaiKhoan kiemTraTK(String tk, String mk) {
		tkdao = new TaiKhoanDAO();
		List<entities.TaiKhoan> list = tkdao.findALL();
		for (TaiKhoan taiKhoan : list) {
			if (tk.equals(taiKhoan.getUserName()))
				if (mk.equals(taiKhoan.getPassWord()))
					return taiKhoan;
		}
		return null;

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object o = e.getSource();
		if (o.equals(btnDangNhap) || o.equals(pwfMatKhau)) {
			String tk = txtTenTK.getText();
			char[] m = pwfMatKhau.getPassword();
			String mk = "";
			for (int i = 0; i < m.length; i++) {
				mk += m[i];
			}
			tkadmin = kiemTraTK(tk, mk);
			if (tkadmin != null) {
				TaiKhoan tkgd = new TaiKhoan(tk.toString(), mk.toString());
				Giaodientongquat gd = new Giaodientongquat(tkgd);
				gd.setVisible(true);
				this.setVisible(false);
			} else {
				JOptionPane.showMessageDialog(this, "Sai tên tài khoản hoặc mật khẩu ");
				pwfMatKhau.setText("");
			}
		} else if (o.equals(btnThoat)) {
			setVisible(false);
			System.exit(1);
		} else if (o.equals(btnTroVe)) {
			Giaodientongquat gdtq = new Giaodientongquat(null);
			gdtq.setVisible(true);
			this.setVisible(false);
		}

	}

	public static TaiKhoan getTk() {
		return tkadmin;
	}

	public static void dangxuat() {
		tkadmin = null;
	}
}
