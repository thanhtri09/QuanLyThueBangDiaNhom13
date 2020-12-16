package ui;

import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.LayoutStyle.ComponentPlacement;

import dao.implDAO.LoaiDiaDAO;
import entities.LoaiDia;
import entities.TaiKhoan;

import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;

public class QuanLyThayDoiTTMatHangGUI extends JFrame implements ActionListener {
	private LoaiDiaDAO lddao;
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JComboBox cbLoaiDia;
	private JLabel lblGiaThueHienTai;
	private JTextField txtGiaThueMoi;
	private JButton btnDatLaiGiaTHue;
	private JButton btnLuuGiaThue;
	private JButton btnHuyLuuGiaThue;
	private JButton btnDatLaiTGThue;
	private JLabel lblThoiGianThueHienTai;
	private JTextField txtThoiGianThueMoi;
	private DefaultComboBoxModel<LoaiDia> tenLD;
	private JButton btnLuuTGThueMoi;
	private JButton btnHuyLuuTGThueMoi;
	private JButton btnTroVe;

	/**
	 * Create the panel.
	 */
	public QuanLyThayDoiTTMatHangGUI() {
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		setBounds(100, 100, 508, 521);
		setResizable(false);
		setLocationRelativeTo(null);
		btnHuyLuuTGThueMoi = new JButton("Hủy");
		btnHuyLuuTGThueMoi.setVisible(false);
		btnHuyLuuTGThueMoi.setFont(new Font("Tahoma", Font.PLAIN, 20));

		JLabel lblNewLabel = new JLabel("QUẢN LÝ THÂY ĐỔI THÔNG TIN LOẠI ĐĨA");
		lblNewLabel.setFont(new Font("Verdana", Font.BOLD, 20));

		JLabel lblNewLabel_1 = new JLabel("Loại đĩa:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 24));

		lddao = new LoaiDiaDAO();
		tenLD = new DefaultComboBoxModel<LoaiDia>();
		List<LoaiDia> dsLd = new ArrayList<LoaiDia>();
		dsLd = lddao.findALL();
		for (LoaiDia loaiDia : dsLd) {
			tenLD.addElement(loaiDia);
		}

		cbLoaiDia = new JComboBox(tenLD);
		cbLoaiDia.setFont(new Font("Tahoma", Font.PLAIN, 24));

		LoaiDia ldChon = new LoaiDia();
		ldChon = (LoaiDia) cbLoaiDia.getSelectedItem();
		JLabel lblNewLabel_1_1 = new JLabel("Giá thuê hiện tại:");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 24));

		JLabel lblNewLabel_1_1_1 = new JLabel("Giá thuê mới:");
		lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 24));

		JLabel lblNewLabel_1_1_2 = new JLabel("Thời gian thuê hiện tại:");
		lblNewLabel_1_1_2.setFont(new Font("Tahoma", Font.PLAIN, 24));

		JLabel lblNewLabel_1_1_2_1 = new JLabel("Thời gian thuê mới:");
		lblNewLabel_1_1_2_1.setFont(new Font("Tahoma", Font.PLAIN, 24));

		btnDatLaiTGThue = new JButton("Đặt lại thời gian thuê");
		btnDatLaiTGThue.setFont(new Font("Tahoma", Font.PLAIN, 20));

		btnDatLaiGiaTHue = new JButton("Đặt lại giá thuê");
		btnDatLaiGiaTHue.setFont(new Font("Tahoma", Font.PLAIN, 20));

		btnLuuTGThueMoi = new JButton("Lưu");
		btnLuuTGThueMoi.setVisible(false);
		btnLuuTGThueMoi.setFont(new Font("Tahoma", Font.PLAIN, 20));

		txtGiaThueMoi = new JTextField();
		txtGiaThueMoi.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtGiaThueMoi.setEnabled(false);
		txtGiaThueMoi.setColumns(10);

		lblThoiGianThueHienTai = new JLabel("");
		lblThoiGianThueHienTai.setFont(new Font("Tahoma", Font.PLAIN, 24));

		lblGiaThueHienTai = new JLabel("");
		lblGiaThueHienTai.setFont(new Font("Tahoma", Font.PLAIN, 24));

		txtThoiGianThueMoi = new JTextField();
		txtThoiGianThueMoi.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtThoiGianThueMoi.setEnabled(false);
		txtThoiGianThueMoi.setColumns(10);

		btnLuuGiaThue = new JButton("Lưu");
		btnLuuGiaThue.setVisible(false);
		btnLuuGiaThue.setFont(new Font("Tahoma", Font.PLAIN, 20));

		btnHuyLuuGiaThue = new JButton("Hủy");
		btnHuyLuuGiaThue.setVisible(false);
		btnHuyLuuGiaThue.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		btnTroVe = new JButton("Trở về");
		btnTroVe.setFont(new Font("Tahoma", Font.PLAIN, 20));
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addContainerGap()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(lblNewLabel_1_1_2, GroupLayout.PREFERRED_SIZE, 247, GroupLayout.PREFERRED_SIZE)
									.addGap(7)
									.addComponent(lblThoiGianThueHienTai, GroupLayout.PREFERRED_SIZE, 183, GroupLayout.PREFERRED_SIZE))
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(btnDatLaiTGThue, GroupLayout.PREFERRED_SIZE, 235, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
									.addComponent(btnLuuTGThueMoi, GroupLayout.PREFERRED_SIZE, 88, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(btnHuyLuuTGThueMoi, GroupLayout.PREFERRED_SIZE, 89, GroupLayout.PREFERRED_SIZE))
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(lblNewLabel_1_1_2_1, GroupLayout.PREFERRED_SIZE, 208, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED, 46, Short.MAX_VALUE)
									.addComponent(txtThoiGianThueMoi, GroupLayout.PREFERRED_SIZE, 183, GroupLayout.PREFERRED_SIZE))
								.addGroup(groupLayout.createSequentialGroup()
									.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
										.addComponent(btnHuyLuuGiaThue, GroupLayout.PREFERRED_SIZE, 82, GroupLayout.PREFERRED_SIZE)
										.addGroup(groupLayout.createSequentialGroup()
											.addComponent(lblNewLabel_1_1_1, GroupLayout.PREFERRED_SIZE, 184, GroupLayout.PREFERRED_SIZE)
											.addPreferredGap(ComponentPlacement.RELATED)
											.addComponent(txtGiaThueMoi, GroupLayout.PREFERRED_SIZE, 166, GroupLayout.PREFERRED_SIZE)))
									.addGap(82)))
							.addGap(53))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(16)
							.addComponent(lblNewLabel)))
					.addGap(0))
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(btnDatLaiGiaTHue)
					.addGap(18, 18, Short.MAX_VALUE)
					.addComponent(btnLuuGiaThue, GroupLayout.PREFERRED_SIZE, 83, GroupLayout.PREFERRED_SIZE)
					.addGap(218))
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 91, GroupLayout.PREFERRED_SIZE)
					.addGap(47)
					.addComponent(cbLoaiDia, GroupLayout.PREFERRED_SIZE, 155, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(197, Short.MAX_VALUE))
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblNewLabel_1_1, GroupLayout.PREFERRED_SIZE, 183, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblGiaThueHienTai, GroupLayout.PREFERRED_SIZE, 165, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(135, Short.MAX_VALUE))
				.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
					.addContainerGap(401, Short.MAX_VALUE)
					.addComponent(btnTroVe)
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 43, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(3)
							.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE))
						.addComponent(cbLoaiDia, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE))
					.addGap(28)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNewLabel_1_1, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblGiaThueHienTai, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE))
					.addGap(28)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(lblNewLabel_1_1_1, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtGiaThueMoi, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnDatLaiGiaTHue, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnLuuGiaThue, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnHuyLuuGiaThue, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE))
					.addGap(28)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNewLabel_1_1_2, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblThoiGianThueHienTai, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE))
					.addGap(26)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNewLabel_1_1_2_1, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtThoiGianThueMoi, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE))
					.addGap(13)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(btnDatLaiTGThue, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnLuuTGThueMoi, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnHuyLuuTGThueMoi, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addComponent(btnTroVe, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
					.addGap(8))
		);
		getContentPane().setLayout(groupLayout);

		btnDatLaiGiaTHue.addActionListener(this);
		btnLuuGiaThue.addActionListener(this);
		btnHuyLuuGiaThue.addActionListener(this);
		btnDatLaiTGThue.addActionListener(this);
		btnHuyLuuTGThueMoi.addActionListener(this);
		btnLuuTGThueMoi.addActionListener(this);
		cbLoaiDia.addActionListener(this);
		btnTroVe.addActionListener(this);

		LoaiDia ldChonDefault = new LoaiDia();
		cbLoaiDia.setSelectedIndex(0);
		ldChon = (LoaiDia) cbLoaiDia.getSelectedItem();
		lblGiaThueHienTai.setText(ldChon.getGiaThue() + " VND");
		lblThoiGianThueHienTai.setText(ldChon.getSoNgayThueToiDa() + " Ngày");
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object obj = e.getSource();
		if (obj.equals(btnDatLaiGiaTHue)) {
			btnDatLaiGiaTHue.setVisible(false);
			btnLuuGiaThue.setVisible(true);
			btnHuyLuuGiaThue.setVisible(true);
			txtGiaThueMoi.setEnabled(true);
		} else if (obj.equals(btnLuuGiaThue)) {

			if (ktTTNhapGia()) {
				LoaiDia ldsua = new LoaiDia();
				ldsua = (LoaiDia) cbLoaiDia.getSelectedItem();
				ldsua.setGiaThue(Double.parseDouble(txtGiaThueMoi.getText().toString().trim()));
				if (lddao.sua(ldsua) != null) {
					JOptionPane.showMessageDialog(null, "Sửa giá thuê thành công!");
					lblGiaThueHienTai.setText(ldsua.getGiaThue()+" VND");
					txtGiaThueMoi.setText("");
					btnDatLaiGiaTHue.setVisible(true);
					btnLuuGiaThue.setVisible(false);
					btnHuyLuuGiaThue.setVisible(false);
					txtGiaThueMoi.setEnabled(false);
				} else {
					JOptionPane.showMessageDialog(null, "Sửa giá thuê không thành công!");
				}

			}

		} else if (obj.equals(btnHuyLuuGiaThue)) {
			btnDatLaiGiaTHue.setVisible(true);
			btnLuuGiaThue.setVisible(false);
			btnHuyLuuGiaThue.setVisible(false);
			txtGiaThueMoi.setEnabled(false);
			txtGiaThueMoi.setText("");
			txtThoiGianThueMoi.setText("");
			
		} else if (obj.equals(btnDatLaiTGThue)) {
			btnDatLaiTGThue.setVisible(false);
			btnLuuTGThueMoi.setVisible(true);
			btnHuyLuuTGThueMoi.setVisible(true);
			txtThoiGianThueMoi.setEnabled(true);
			
		} else if (obj.equals(btnLuuTGThueMoi)) {
			if(ktTTNhapTG()) {
				LoaiDia ldsua = new LoaiDia();
				ldsua = (LoaiDia) cbLoaiDia.getSelectedItem();
				ldsua.setSoNgayThueToiDa(Integer.parseInt(txtThoiGianThueMoi.getText().toString().trim()));
				if (lddao.sua(ldsua) != null) {
					JOptionPane.showMessageDialog(null, "Sửa thời gian thuê thành công!");
					txtThoiGianThueMoi.setText("");
					btnDatLaiTGThue.setVisible(true);
					btnLuuTGThueMoi.setVisible(false);
					btnHuyLuuTGThueMoi.setVisible(false);
					txtThoiGianThueMoi.setEnabled(false);
					
					lblThoiGianThueHienTai.setText(ldsua.getSoNgayThueToiDa()+" Ngày");
				} else {
					JOptionPane.showMessageDialog(null, "Sửa thời gian thuê không thành công!");
				}

			}

		} else if (obj.equals(btnHuyLuuTGThueMoi)) {
			btnDatLaiTGThue.setVisible(true);
			btnLuuTGThueMoi.setVisible(false);
			btnHuyLuuTGThueMoi.setVisible(false);
			txtThoiGianThueMoi.setEnabled(false);
			txtGiaThueMoi.setText("");
			txtThoiGianThueMoi.setText("");
			
		} else if (obj.equals(cbLoaiDia)) {
			LoaiDia ldChon = new LoaiDia();
			ldChon = (LoaiDia) cbLoaiDia.getSelectedItem();
			lblGiaThueHienTai.setText(ldChon.getGiaThue() + " VND");
			lblThoiGianThueHienTai.setText(ldChon.getSoNgayThueToiDa() + " Ngày");
		}else if(obj.equals(btnTroVe)) {
			DangNhapGUI tkdn = new DangNhapGUI();
			TaiKhoan tk = new TaiKhoan();
			tk = tkdn.getTk();
			Giaodientongquat gd = new Giaodientongquat(tk);
			gd.setVisible(true);
			this.setVisible(false);
		}

	}

	private boolean ktTTNhapGia() {
		String giamoi = txtGiaThueMoi.getText().toString().trim();

		if (giamoi.equalsIgnoreCase("")) {
			JOptionPane.showMessageDialog(null, "Giá mới không được rỗng!");
			txtGiaThueMoi.requestFocus();
			txtGiaThueMoi.selectAll();
			return false;
		}else if(!giamoi.matches("[0-9]")) {
			JOptionPane.showMessageDialog(null, "Giá thuê mới nhập không hợp lệ!");
			txtGiaThueMoi.requestFocus();
			txtGiaThueMoi.selectAll();
			return false;
		} else if (Double.parseDouble(giamoi) > 500000 || Double.parseDouble(giamoi) < 0) {
			JOptionPane.showMessageDialog(null, "Giá mới từ 0 đến 500.000!");
			txtGiaThueMoi.requestFocus();
			txtGiaThueMoi.selectAll();
			return false;
		}
		return true;
	}

	private boolean ktTTNhapTG() {
		String tgThueMoi = txtThoiGianThueMoi.getText().toString().trim();
		if (tgThueMoi.equalsIgnoreCase("")) {
			JOptionPane.showMessageDialog(null, "Thời gian thuê mới không được rỗng!");
			txtThoiGianThueMoi.requestFocus();
			txtThoiGianThueMoi.selectAll();
			return false;
		} else if(!tgThueMoi.matches("[0-9]")) {
			JOptionPane.showMessageDialog(null, "Thời gian thuê nhập không hợp lệ!");
			txtThoiGianThueMoi.requestFocus();
			txtThoiGianThueMoi.selectAll();
			return false;
		}else if (Integer.parseInt(tgThueMoi) > 30 || Integer.parseInt(tgThueMoi) < 1) {
			JOptionPane.showMessageDialog(null, "Thời gian thuê từ 1 đến 30 ngày!");
			txtThoiGianThueMoi.requestFocus();
			txtThoiGianThueMoi.selectAll();
			return false;
		}
		return true;
	}
}
