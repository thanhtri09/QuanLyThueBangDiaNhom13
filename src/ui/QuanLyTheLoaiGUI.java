package ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import dao.implDAO.LoaiDiaDAO;
import entities.LoaiDia;
import entities.TaiKhoan;
import entities.TenLoaiDia;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.List;

import javax.swing.JTextField;
import javax.swing.JButton;

public class QuanLyTheLoaiGUI extends JFrame implements ActionListener, ItemListener {

	private JPanel contentPane;
	private JTextField txtGiaThue;
	private JTextField txt_PhiTreHan;
	private JTextField txt_NgayThue;
	private LoaiDiaDAO loaiDiaDAO;
	private JButton btn_capNhat;
	private JComboBox cbo_LoaiDia;
	private JButton btnThoat;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
	public QuanLyTheLoaiGUI() {
		setTitle("Quản Lý Thể Loại");
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setBounds(100, 100, 310, 269);
		setLocationRelativeTo(null);
		setResizable(false);

		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		cbo_LoaiDia = new JComboBox();
		cbo_LoaiDia.setBounds(106, 16, 162, 20);
		contentPane.add(cbo_LoaiDia);
		cbo_LoaiDia.addItemListener(this);

		JLabel lblTnLoia = new JLabel("Tên Loại Đĩa :");
		lblTnLoia.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblTnLoia.setBounds(10, 11, 86, 28);
		contentPane.add(lblTnLoia);

		JLabel lblGiThu = new JLabel("Giá Thuê :");
		lblGiThu.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblGiThu.setBounds(10, 50, 86, 28);
		contentPane.add(lblGiThu);

		JLabel lblPhTrHn = new JLabel("Phí Trễ Hạn :");
		lblPhTrHn.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblPhTrHn.setBounds(10, 89, 86, 28);
		contentPane.add(lblPhTrHn);

		JLabel lblSNgyThu = new JLabel("Số Ngày Thuê Tối Đa :");
		lblSNgyThu.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblSNgyThu.setBounds(10, 128, 148, 28);
		contentPane.add(lblSNgyThu);

		txtGiaThue = new JTextField();
		txtGiaThue.setBounds(106, 55, 86, 20);
		contentPane.add(txtGiaThue);
		txtGiaThue.setColumns(10);

		txt_PhiTreHan = new JTextField();
		txt_PhiTreHan.setColumns(10);
		txt_PhiTreHan.setBounds(106, 94, 86, 20);
		contentPane.add(txt_PhiTreHan);

		txt_NgayThue = new JTextField();
		txt_NgayThue.setColumns(10);
		txt_NgayThue.setBounds(168, 133, 86, 20);
		contentPane.add(txt_NgayThue);

		btn_capNhat = new JButton("Cập Nhật");
		btn_capNhat.setBounds(83, 186, 102, 30);
		contentPane.add(btn_capNhat);
		btn_capNhat.addActionListener(this);

		JLabel lblVnd = new JLabel("VND");
		lblVnd.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblVnd.setBounds(202, 50, 86, 28);
		contentPane.add(lblVnd);

		JLabel lblVnd_1 = new JLabel("VND");
		lblVnd_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblVnd_1.setBounds(202, 89, 86, 28);
		contentPane.add(lblVnd_1);
		
		btnThoat = new JButton("Thoát");
		btnThoat.setBounds(190, 186, 102, 30);
		contentPane.add(btnThoat);

		loaiDiaDAO = new LoaiDiaDAO();
		btnThoat.addActionListener(this);
		init();
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object o = e.getSource();
		if (o.equals(btn_capNhat)) {
			if (cbo_LoaiDia.getSelectedItem() == TenLoaiDia.DVD) {
				LoaiDia loaiDia = loaiDiaDAO.timTheoMa(Long.parseLong("1"));
				loaiDia.setGiaThue(Double.parseDouble(txtGiaThue.getText()));
				loaiDia.setSoNgayThueToiDa(Integer.parseInt(txt_NgayThue.getText()));
				loaiDia.setPhiTreHan(Double.parseDouble(txt_PhiTreHan.getText()));
				loaiDiaDAO.sua(loaiDia);
				JOptionPane.showMessageDialog(this, "Cập nhật thành công");
			} else {
				LoaiDia loaiDia = loaiDiaDAO.timTheoMa(Long.parseLong("2"));
				loaiDia.setGiaThue(Double.parseDouble(txtGiaThue.getText()));
				loaiDia.setSoNgayThueToiDa(Integer.parseInt(txt_NgayThue.getText()));
				loaiDia.setPhiTreHan(Double.parseDouble(txt_PhiTreHan.getText()));
				loaiDiaDAO.sua(loaiDia);
				JOptionPane.showMessageDialog(this, "Cập nhật thành công");
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

	@Override
	public void itemStateChanged(ItemEvent e) {
		// TODO Auto-generated method stub
		Object o = e.getSource();
		if (o.equals(cbo_LoaiDia)) {
			if (cbo_LoaiDia.getSelectedItem() == TenLoaiDia.DVD) {
				LoaiDia loaiDia = loaiDiaDAO.timTheoMa(Long.parseLong("1"));
				txtGiaThue.setText(loaiDia.getGiaThue() + "");
				txt_PhiTreHan.setText(loaiDia.getPhiTreHan() + "");
				txt_NgayThue.setText(loaiDia.getSoNgayThueToiDa() + "");
			} else {
				LoaiDia loaiDia = loaiDiaDAO.timTheoMa(Long.parseLong("2"));
				txtGiaThue.setText(loaiDia.getGiaThue() + "");
				txt_PhiTreHan.setText(loaiDia.getPhiTreHan() + "");
				txt_NgayThue.setText(loaiDia.getSoNgayThueToiDa() + "");
			}
		}
	}

	private void init() {
		List<LoaiDia> loaiDias = loaiDiaDAO.findALL();
		for (LoaiDia loaiDia : loaiDias) {
			cbo_LoaiDia.addItem(loaiDia.getTenLoaiDia());
		}
		LoaiDia loaiDia = loaiDiaDAO.timTheoMa(Long.parseLong("1"));
		txtGiaThue.setText(loaiDia.getGiaThue() + "");
		txt_PhiTreHan.setText(loaiDia.getPhiTreHan() + "");
		txt_NgayThue.setText(loaiDia.getSoNgayThueToiDa() + "");
	}
}
