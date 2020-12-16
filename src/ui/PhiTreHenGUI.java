package ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import dao.implDAO.ChiTietPhiTreHenDAO;
import dao.implDAO.KhachHangDAO;
import dao.implDAO.PhiTreHenDAO;
import entities.ChiTietPhiTreHen;
import entities.ChiTietPhiTreHenID;
import entities.KhachHang;
import entities.PhiTreHen;
import entities.TaiKhoan;

import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class PhiTreHenGUI extends JFrame implements ActionListener, MouseListener {

	private JPanel contentPane;
	private JTextField txt_MaKhachHang;
	private JTextField txt_TenKhachHang;
	private JTextField txt_PhiTreHen;
	private JTable table;
	private DefaultTableModel tableModel;
	private JButton btn_ThanhToanTatCa, btn_HuyPhiTreHen, btn_ThanhToanPhiTreHen;
	private Long maPhiTreHen;
	private ChiTietPhiTreHenDAO chiTietPhiTreHenDAO;
	private PhiTreHenDAO phiTreHenDAO;
	private ChiTietPhiTreHenID id = new ChiTietPhiTreHenID();
	private JButton btnThoat;

	public PhiTreHenGUI(Long maPhiTreHen) {
		this.maPhiTreHen = maPhiTreHen;

		setTitle("Phí Trễ Hẹn");
		setBounds(100, 100, 704, 593);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0)), "Th\u00F4ng Tin Kh\u00E1ch H\u00E0ng",
				TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(10, 11, 316, 159);
		contentPane.add(panel);
		panel.setLayout(null);

		JLabel lblMKhchHng = new JLabel("Mã Khách Hàng :");
		lblMKhchHng.setBounds(10, 21, 98, 28);
		panel.add(lblMKhchHng);

		txt_MaKhachHang = new JTextField();
		txt_MaKhachHang.setEditable(false);
		txt_MaKhachHang.setColumns(10);
		txt_MaKhachHang.setBounds(118, 25, 173, 20);
		panel.add(txt_MaKhachHang);

		JLabel lblTnKhchHng = new JLabel("Tên Khách Hàng :");
		lblTnKhchHng.setBounds(10, 60, 98, 28);
		panel.add(lblTnKhchHng);

		txt_TenKhachHang = new JTextField();
		txt_TenKhachHang.setEditable(false);
		txt_TenKhachHang.setColumns(10);
		txt_TenKhachHang.setBounds(118, 64, 173, 20);
		panel.add(txt_TenKhachHang);

		JLabel lblTngPhTr = new JLabel("Tổng Phí Trễ Hẹn : ");
		lblTngPhTr.setBounds(10, 99, 111, 28);
		panel.add(lblTngPhTr);

		txt_PhiTreHen = new JTextField();
		txt_PhiTreHen.setEditable(false);
		txt_PhiTreHen.setColumns(10);
		txt_PhiTreHen.setBounds(128, 103, 133, 20);
		panel.add(txt_PhiTreHen);

		JLabel lblVnd = new JLabel("VND");
		lblVnd.setBounds(271, 99, 65, 28);
		panel.add(lblVnd);

		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0)),
				"Danh S\u00E1ch \u0110\u0129a Tr\u1EC5 H\u1EB9n", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.setBounds(10, 181, 667, 332);
		contentPane.add(panel_1);
		panel_1.setLayout(null);

		JScrollPane scrollPane;
		String[] headers = "Mã Đĩa;Tên Tiêu Đề;Ngày Thuê;Ngày Phải Trả;Ngày Trả;Phí Trễ Hẹn".split(";");
		tableModel = new DefaultTableModel(headers, 0);
		panel_1.add(scrollPane = new JScrollPane(table = new JTable(tableModel), JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED));
		scrollPane.setBounds(10, 22, 647, 299);

		JPanel panel_1_1 = new JPanel();
		panel_1_1.setLayout(null);
		panel_1_1.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0)), "Ch\u1EE9c N\u0103ng",

				TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1_1.setBounds(336, 11, 341, 159);
		contentPane.add(panel_1_1);

		btn_ThanhToanPhiTreHen = new JButton("Thanh Toán Phí Trễ Hẹn");
		btn_ThanhToanPhiTreHen.setBounds(47, 24, 251, 30);
		panel_1_1.add(btn_ThanhToanPhiTreHen);

		btn_ThanhToanTatCa = new JButton("Thanh Toán Tất Cả");
		btn_ThanhToanTatCa.setBounds(47, 65, 251, 30);
		panel_1_1.add(btn_ThanhToanTatCa);

		btn_HuyPhiTreHen = new JButton("Hủy Phí Trễ Hẹn");
		btn_HuyPhiTreHen.setBounds(47, 106, 251, 30);
		panel_1_1.add(btn_HuyPhiTreHen);
		
		btnThoat = new JButton("Thoát");
		btnThoat.setBounds(580, 526, 97, 25);
		contentPane.add(btnThoat);

		btn_HuyPhiTreHen.addActionListener(this);
		btn_ThanhToanPhiTreHen.addActionListener(this);
		btn_ThanhToanTatCa.addActionListener(this);
		table.addMouseListener(this);

		phiTreHenDAO = new PhiTreHenDAO();
		chiTietPhiTreHenDAO = new ChiTietPhiTreHenDAO();
		loadDuLieu();
		btnThoat.addActionListener(this);
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		Object o = e.getSource();
		if (o.equals(table)) {
			String ma = (String) table.getValueAt(table.getSelectedRow(), 0);
			id.setMaPhiTreHen(this.maPhiTreHen);
			id.setMaDia(Long.parseLong(ma));
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
		// TODO Auto-generated method stub
		Object o = e.getSource();
		if (o.equals(btn_ThanhToanPhiTreHen)) {
			ChiTietPhiTreHen chiTietPhiTreHen = chiTietPhiTreHenDAO.timTheoMa(id);
			chiTietPhiTreHen.setTrangThai("1");
			if (chiTietPhiTreHenDAO.sua(chiTietPhiTreHen) != null) {
				capNhatBangDuLieu();
				JOptionPane.showMessageDialog(this, "Thanh toán thành công !");
			} else {
				JOptionPane.showMessageDialog(this, "Thanh toán không thành công !");
			}
		} else if (o.equals(btn_ThanhToanTatCa)) {
			List<ChiTietPhiTreHen> chiTietPhiTreHens = chiTietPhiTreHenDAO
					.timChiTietPhiTreHenTheoMaPhiTreHen(maPhiTreHen);
			for (ChiTietPhiTreHen chiTietPhiTreHen : chiTietPhiTreHens) {
				chiTietPhiTreHen.setTrangThai("1");
				chiTietPhiTreHenDAO.sua(chiTietPhiTreHen);
			}
			capNhatBangDuLieu();
			JOptionPane.showMessageDialog(this, "Thanh toán tất cả thành công !");
		} else if (o.equals(btn_HuyPhiTreHen)) {
			//phiTreHenDAO.xoa(phiTreHenDAO.timTheoMa(maPhiTreHen));
			ChiTietPhiTreHen chiTietPhiTreHen = chiTietPhiTreHenDAO.timTheoMa(id);
			chiTietPhiTreHenDAO.xoa(chiTietPhiTreHen);
			capNhatBangDuLieu();
			JOptionPane.showMessageDialog(this, "Đã hủy phí trễ hẹn của khách hàng");
			//setVisible(false);
		}else if(o.equals(btnThoat)) {
			DangNhapGUI tkdn = new DangNhapGUI();
			TaiKhoan tk = new TaiKhoan();
			tk = tkdn.getTk();
			Giaodientongquat gd=new Giaodientongquat(tk);
			gd.setVisible(true);
			this.setVisible(false);
		}

	}

	private void loadDuLieu() {
		PhiTreHen phiTreHen = phiTreHenDAO.timTheoMa(maPhiTreHen);
		txt_MaKhachHang.setText(phiTreHen.getKhachHang().getMaKhachHang() + "");
		txt_TenKhachHang.setText(phiTreHen.getKhachHang().getHoTen());
		capNhatBangDuLieu();
	}

	private void capNhatBangDuLieu() {
		List<ChiTietPhiTreHen> chiTietPhiTreHens = chiTietPhiTreHenDAO.timChiTietPhiTreHenTheoMaPhiTreHen(maPhiTreHen);
		double tongTien = 0;
		int rowCount = table.getRowCount();
		for (int i = rowCount; i > 0; i--) {
			tableModel.removeRow(i - 1);
		}
		for (ChiTietPhiTreHen chiTietPhiTreHen : chiTietPhiTreHens) {
			if (chiTietPhiTreHen.getTrangThai().equals("0")) {
				String[] rowData = { chiTietPhiTreHen.getDia().getMaDia() + "",
						chiTietPhiTreHen.getDia().getTuaDe().getTenTieuDe(), chiTietPhiTreHen.getNgayThue().toString(),
						chiTietPhiTreHen.getNgayPhaiTra().toString(), chiTietPhiTreHen.getNgayPhaiTra().toString(),
						chiTietPhiTreHen.getDia().getTuaDe().getLoaiDia().getPhiTreHan() + "" };
				tableModel.addRow(rowData);
				tongTien = tongTien + chiTietPhiTreHen.getDia().getTuaDe().getLoaiDia().getPhiTreHan();
			}
		}
		txt_PhiTreHen.setText(tongTien + "");
	}
}
