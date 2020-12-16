package ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import dao.implDAO.PhiTreHenDAO;
import dao.implDAO.PhieuDatTruocDAO;
import entities.PhiTreHen;
import entities.PhieuDatTruoc;
import entities.TaiKhoan;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;
import javax.swing.JButton;

public class TimKiemPhiTreHenGUI extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JTextField txt_maKhachHang;
	private JButton btn_TimKiem;
	private PhiTreHenDAO phiTreHenDAO;
	private JButton btnThoat;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TimKiemPhiTreHenGUI frame = new TimKiemPhiTreHenGUI();
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
	public TimKiemPhiTreHenGUI() {
		setTitle("Tìm Kiếm Phí Trễ Hẹn");
		setBounds(100, 100, 428, 164);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("Nhập Mã Khách Hàng : ");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel.setBounds(10, 11, 158, 40);
		contentPane.add(lblNewLabel);

		txt_maKhachHang = new JTextField();
		txt_maKhachHang.setBounds(178, 20, 213, 27);
		contentPane.add(txt_maKhachHang);
		txt_maKhachHang.setColumns(10);

		btn_TimKiem = new JButton("Tìm Kiếm");
		btn_TimKiem.setBounds(178, 75, 102, 30);
		contentPane.add(btn_TimKiem);
		
		btnThoat = new JButton("Thoát");
		btnThoat.setBounds(292, 75, 102, 30);
		contentPane.add(btnThoat);

		phiTreHenDAO = new PhiTreHenDAO();
		btn_TimKiem.addActionListener(this);
		btnThoat.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object o = e.getSource();
		if (o.equals(btn_TimKiem)) {
			try {
				PhiTreHen phiTreHen = phiTreHenDAO
						.timPhiTreHenTheoMaKhachHang(Long.parseLong(txt_maKhachHang.getText()));
				PhiTreHenGUI gui = new PhiTreHenGUI(phiTreHen.getMaPhiTreHan());
				gui.setVisible(true);
				txt_maKhachHang.setText("");
			} catch (Exception e2) {
				// TODO: handle exception
				JOptionPane.showMessageDialog(this, "Không tìm thấy phí trễ hẹn của khách hàng");
			}

		}else if(o.equals(btnThoat)) {
			DangNhapGUI tkdn = new DangNhapGUI();
			TaiKhoan tk = new TaiKhoan();
			tk = tkdn.getTk();
			Giaodientongquat gd=new Giaodientongquat(tk);
			gd.setVisible(true);
			this.setVisible(false);
		}
	}

}