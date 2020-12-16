package ui;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import dao.implDAO.KhachHangDAO;
import entities.KhachHang;
import entities.TaiKhoan;
import entities.TrangThaiKhachHang;

public class QuanLyKhachHangGUI extends JFrame implements ActionListener, MouseListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;
	private DefaultTableModel tableModel;
	private JButton btnthem, btnbochon;
	private JButton btnSuaTTKH, btnxoaKH;
	private JButton btnTroVe;
	private JPanel panel;
	private JLabel lblmaKH;
	private JLabel lbltenKH;
	private JLabel lbldiaChi;
	private JTextField txtmaKH;
	private JTextField txttenKH;
	private JTextField txtdiaChi;
	private ButtonGroup group;
	private JRadioButton raddanghoatdong, radngunghoatdong;

	private JTextField txtsdt;
	private KhachHangDAO khDao;

	public QuanLyKhachHangGUI() {
		taoGiaoDien();
		khDao = new KhachHangDAO();
		capNhatBangDuLieu();
	}

	public void taoGiaoDien() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Quản Lý Khách Hàng");
		setBounds(100, 100, 1266, 705);
		setLocationRelativeTo(null);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		String[] header = "Mã Khách Hàng; Tên Khách Hàng; Số Điện Thoại;Địa chỉ;Trạng thái".split(";");
		tableModel = new DefaultTableModel(header, 0) {
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			public boolean isCellEditable(int rowIndex, int columnIndex) {
				return false;
			}
		};

		JScrollPane scrollPane = new JScrollPane(table = new JTable(tableModel), JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.addMouseListener(this);
		scrollPane.setBounds(10, 11, 695, 643);
		contentPane.add(scrollPane);

		panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(704, 14, 536, 643);
		contentPane.add(panel);
		panel.setLayout(null);

		JLabel lblNewLabel = new JLabel("THÔNG TIN KHÁCH HÀNG");
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 26));
		lblNewLabel.setForeground(Color.BLUE);
		lblNewLabel.setBounds(59, 11, 346, 52);
		panel.add(lblNewLabel);

		lblmaKH = new JLabel("Mã Khách Hàng:");
		lblmaKH.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblmaKH.setBounds(12, 93, 175, 33);
		panel.add(lblmaKH);

		lbltenKH = new JLabel("Tên Khách Hàng:");
		lbltenKH.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lbltenKH.setBounds(12, 161, 183, 33);
		panel.add(lbltenKH);

		lbldiaChi = new JLabel("Địa Chỉ:");
		lbldiaChi.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lbldiaChi.setBounds(12, 300, 83, 33);
		panel.add(lbldiaChi);

		txtmaKH = new JTextField();
		txtmaKH.setEditable(false);
		txtmaKH.setFont(new Font("Tahoma", Font.BOLD, 24));
		txtmaKH.setBackground(Color.WHITE);
		txtmaKH.setBounds(232, 93, 217, 33);
		panel.add(txtmaKH);
		txtmaKH.setColumns(10);

		txttenKH = new JTextField();
		txttenKH.setFont(new Font("Tahoma", Font.PLAIN, 24));
		txttenKH.setBackground(Color.WHITE);
		txttenKH.setColumns(10);
		txttenKH.setBounds(232, 160, 283, 34);
		panel.add(txttenKH);

		txtdiaChi = new JTextField();
		txtdiaChi.setFont(new Font("Tahoma", Font.PLAIN, 24));
		txtdiaChi.setBackground(Color.WHITE);
		txtdiaChi.setColumns(10);
		txtdiaChi.setBounds(107, 300, 408, 33);
		panel.add(txtdiaChi);

		JLabel label = new JLabel("Số Điện Thoại:");
		label.setFont(new Font("Tahoma", Font.PLAIN, 24));
		label.setBounds(12, 232, 183, 33);
		panel.add(label);

		txtsdt = new JTextField();
		txtsdt.setFont(new Font("Tahoma", Font.PLAIN, 24));
		txtsdt.setBackground(Color.WHITE);
		txtsdt.setColumns(10);
		txtsdt.setBounds(232, 232, 283, 33);
		panel.add(txtsdt);

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.WHITE);
		panel_1.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0)), "Thanh C\u00F4ng C\u1EE5",
				TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.setBounds(8, 423, 528, 207);
		panel.add(panel_1);
		panel_1.setLayout(null);

		btnbochon = new JButton("Bỏ chọn");
		btnbochon.setBounds(20, 32, 219, 42);
		panel_1.add(btnbochon);
		btnbochon.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnbochon.setBackground(Color.WHITE);
		btnbochon.setVisible(false);

		btnSuaTTKH = new JButton("Sửa đổi thông tin KH");
		btnSuaTTKH.setBounds(20, 87, 219, 42);
		panel_1.add(btnSuaTTKH);
		btnSuaTTKH.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnSuaTTKH.setBackground(Color.WHITE);

		btnxoaKH = new JButton("Xóa khách hàng");
		btnxoaKH.setBounds(20, 142, 219, 42);
		panel_1.add(btnxoaKH);
		btnxoaKH.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnxoaKH.setBackground(Color.WHITE);

		btnTroVe = new JButton("Thoát");
		btnTroVe.setBounds(409, 152, 107, 42);
		panel_1.add(btnTroVe);
		btnTroVe.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnTroVe.setBackground(Color.WHITE);

		btnthem = new JButton("Thêm khách hàng");
		btnthem.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnthem.setBackground(Color.WHITE);
		btnthem.setBounds(20, 32, 219, 42);
		panel_1.add(btnthem);

		JLabel lblTrangThai = new JLabel("Trạng thái:");
		lblTrangThai.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblTrangThai.setBounds(12, 361, 127, 33);
		panel.add(lblTrangThai);

		group = new ButtonGroup();
		raddanghoatdong = new JRadioButton("Đang hoạt động");
		raddanghoatdong.setFont(new Font("Tahoma", Font.PLAIN, 18));
		raddanghoatdong.setBackground(Color.WHITE);
		raddanghoatdong.setBounds(147, 368, 166, 25);
		group.add(raddanghoatdong);
		panel.add(raddanghoatdong);
		group.clearSelection();

		radngunghoatdong = new JRadioButton("Ngưng hoạt động");
		radngunghoatdong.setFont(new Font("Tahoma", Font.PLAIN, 18));
		radngunghoatdong.setBackground(Color.WHITE);
		radngunghoatdong.setBounds(334, 368, 181, 25);
		group.add(radngunghoatdong);
		panel.add(radngunghoatdong);

		// Hien thi cac button
		btnSuaTTKH.setVisible(false);
		btnxoaKH.setVisible(false);

		btnTroVe.addActionListener(this);
		btnxoaKH.addActionListener(this);
		btnSuaTTKH.addActionListener(this);
		btnthem.addActionListener(this);
		btnbochon.addActionListener(this);
		table.addMouseListener(this);

	}

	private void capNhatBangDuLieu() {
		int rowCount = table.getRowCount();
		for (int i = rowCount; i > 0; i--) {
			tableModel.removeRow(i - 1);
		}
		List<KhachHang> list = khDao.findALL();
		for (KhachHang khachHang : list) {
			String[] rowData = { khachHang.getMaKhachHang() + "", khachHang.getHoTen(), khachHang.getSoDienThoai(),
					khachHang.getDiaChi(), khachHang.getTrangThai().toString() };
			tableModel.addRow(rowData);
		}
		table.setModel(tableModel);

	}

	private void dienThongTin(int row) {
		if (row != -1) {
			String ma = table.getValueAt(row, 0).toString();
			String hoten = table.getValueAt(row, 1).toString();
			String sdt = table.getValueAt(row, 2).toString();
			String diachi = table.getValueAt(row, 3).toString();
			String trangthai = table.getValueAt(row, 4).toString().trim();

			txtmaKH.setText(ma);
			txttenKH.setText(hoten);
			txtdiaChi.setText(diachi);
			txtsdt.setText(sdt);
			if (trangthai.equalsIgnoreCase(TrangThaiKhachHang.dangHoatDong.toString())) {
				raddanghoatdong.setSelected(true);
			} else {
				radngunghoatdong.setSelected(true);
			}
		}
	}

	private boolean kiemTraDinhDang() {
		String ten = txttenKH.getText();
		String sdt = txtsdt.getText();
		String diachi = txtdiaChi.getText();
		if (ten.matches("\\s*")) {
			JOptionPane.showMessageDialog(this, "Tên không được để trống!");
			txttenKH.requestFocus();
			txttenKH.selectAll();
			return false;
		} else if (!ten.matches("^[\\p{L} ]+$")) {
			JOptionPane.showMessageDialog(this, "Vui lòng điền tên chính xác!");
			txttenKH.requestFocus();
			txttenKH.selectAll();
			return false;
		} else if (sdt.matches("\\s*")) {
			JOptionPane.showMessageDialog(this, "Số điện thoại không được để trống!");
			txtsdt.requestFocus();
			txtsdt.selectAll();
			return false;
		} else if (!sdt.matches("[0-9]{10}")) {
			JOptionPane.showMessageDialog(this, "Số điện thoại phải là số và phải đủ 10 số!");
			txtsdt.requestFocus();
			txtsdt.selectAll();
			return false;
		} else if (diachi.matches("\\s*")) {
			JOptionPane.showMessageDialog(this, "Địa chỉ không được để trống!");
			txtdiaChi.requestFocus();
			txtdiaChi.selectAll();
			return false;
		} else if (!diachi.matches("^[\\p{L}0-9 -/]+$")) {
			JOptionPane.showMessageDialog(this, "Vui lòng nhập đúng địa chỉ!");
			txtdiaChi.requestFocus();
			txtdiaChi.selectAll();
			return false;
		} else if (raddanghoatdong.isSelected() == false && radngunghoatdong.isSelected() == false) {
			JOptionPane.showMessageDialog(this, "Vui lòng chọn trạng thái!");
			return false;
		}

		return true;
	}

	private void xoaRong() {
		txtmaKH.setText("");
		txttenKH.setText("");
		txtdiaChi.setText("");
		txtsdt.setText("");
		group.clearSelection();

	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		Object o = e.getSource();
		if (o.equals(table)) {
			dienThongTin(table.getSelectedRow());
			btnbochon.setVisible(true);
			btnSuaTTKH.setVisible(true);
			btnxoaKH.setVisible(true);

		}
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

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
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		if (obj.equals(btnthem)) {
			if (kiemTraDinhDang()) {
				String ten = txttenKH.getText();
				String diaChi = txtdiaChi.getText();
				String sdt = txtsdt.getText();
				TrangThaiKhachHang trangthai;
				if (radngunghoatdong.isSelected())
					trangthai = TrangThaiKhachHang.dangHoatDong;
				else
					trangthai = TrangThaiKhachHang.ngungHoatDong;
				if (khDao.them(new KhachHang(ten, diaChi, sdt, trangthai.toString())) != null) {
					int rowcount = table.getSelectedRowCount();
					for (int i = rowcount; i > 0; i--) {
						tableModel.removeRow(i - 1);
					}
					capNhatBangDuLieu();
					JOptionPane.showMessageDialog(this, "Thêm thành công!");
				} else
					JOptionPane.showMessageDialog(this, "Thêm không thành công!");
			}

		} else if (obj.equals(btnSuaTTKH)) {
			if (kiemTraDinhDang()) {
				int chon = JOptionPane.showConfirmDialog(null, "Xác nhận cập nhật thông tin khách hàng ?",
						"Thông báo xác nhận!", JOptionPane.YES_NO_OPTION);
				if (chon == JOptionPane.YES_OPTION) {
					Long ma = new Long(txtmaKH.getText());
					String ten = txttenKH.getText();
					String diaChi = txtdiaChi.getText();
					String sdt = txtsdt.getText();
					TrangThaiKhachHang trangthai;
					if (raddanghoatdong.isSelected())
						trangthai = TrangThaiKhachHang.dangHoatDong;
					else
						trangthai = TrangThaiKhachHang.ngungHoatDong;
					KhachHang kh = new KhachHang(ten, diaChi, sdt, trangthai.toString());
					kh.setMaKhachHang(ma);
					if (khDao.sua(kh) != null) {
						int rowcount = table.getSelectedRowCount();
						for (int i = rowcount; i > 0; i--) {
							tableModel.removeRow(i - 1);
						}
						capNhatBangDuLieu();
						xoaRong();
						JOptionPane.showMessageDialog(this, "Sửa thông tin thành công!");
						btnSuaTTKH.setVisible(false);
						btnxoaKH.setVisible(false);
						btnthem.setVisible(true);
						btnbochon.setVisible(false);
					} else
						JOptionPane.showMessageDialog(this, "Sửa thông tin không thành công!");

				}
			}

		} else if (obj.equals(btnTroVe)) {
			DangNhapGUI tkdn = new DangNhapGUI();
			TaiKhoan tk = new TaiKhoan();
			tk = tkdn.getTk();
			Giaodientongquat gd=new Giaodientongquat(tk);
			gd.setVisible(true);
			this.setVisible(false);
			
		} else if (obj.equals(btnxoaKH)) {
			int row = table.getSelectedRow();
			if (row == -1) {
				JOptionPane.showMessageDialog(this, "Chưa chọn khách hàng để xóa !!!");
				return;
			}
			int chon = JOptionPane.showConfirmDialog(null,
					"Xác nhận xóa khách hàng " + table.getValueAt(row, 1).toString() + " ?", "Thông báo xác nhận!",
					JOptionPane.YES_NO_OPTION);
			if (chon == JOptionPane.YES_OPTION) {
				Long ma = new Long((String) table.getValueAt(row, 0));
				boolean xoa = khDao.xoaTheoMa(ma);
				if (xoa == true) {
					capNhatBangDuLieu();
					xoaRong();
					JOptionPane.showMessageDialog(this, "Xóa thông tin khách hàng thành công!");
					btnSuaTTKH.setVisible(false);
					btnxoaKH.setVisible(false);
					btnthem.setVisible(true);
					btnbochon.setVisible(false);
				} else {
					JOptionPane.showMessageDialog(this, "Xóa thông tin khách hàng không thành công!");
				}
			}

		} else if (obj.equals(btnbochon)) {
			table.clearSelection();
			xoaRong();
			btnbochon.setVisible(false);
			btnthem.setVisible(true);
			btnSuaTTKH.setVisible(false);
			btnxoaKH.setVisible(false);
			btnbochon.setVisible(false);
		}

	}
}
