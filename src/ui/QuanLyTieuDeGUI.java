package ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import dao.implDAO.LoaiDiaDAO;
import dao.implDAO.TieuDeDAO;
import entities.LoaiDia;
import entities.TaiKhoan;
import entities.TenLoaiDia;
import entities.TieuDe;

import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JComboBox;

public class QuanLyTieuDeGUI extends JFrame implements ActionListener, MouseListener {

	private JPanel contentPane;
	private JTable table;
	private DefaultTableModel tableModel;
	private JTextField txt_TenTieuDe;
	private JButton btn_Them, btn_capNhat, btn_xoa, btn_timKiem, btn_LamMoi;
	private JComboBox cbo_loaiDia;
	private TieuDeDAO tieuDeDAO;
	private LoaiDiaDAO loaiDiaDAO;
	private Long maTieuDe = Long.parseLong("0");
	private JButton btnThoat;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					QuanLyTieuDeGUI frame = new QuanLyTieuDeGUI();
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
	public QuanLyTieuDeGUI() {
		setTitle("Quản Lý Tiêu Đề");
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setBounds(100, 100, 707, 550);
		setLocationRelativeTo(null);
		setResizable(false);

		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBorder(
				new TitledBorder(new LineBorder(new Color(0, 0, 0)), "T\u00ECm Ki\u1EBFm Ti\u00EAu \u0110\u1EC1",
						TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel.setBounds(10, 11, 479, 146);
		contentPane.add(panel);
		panel.setLayout(null);

		JLabel lblNewLabel = new JLabel("Tên Tiêu Đề :");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel.setBounds(10, 23, 86, 28);
		panel.add(lblNewLabel);

		txt_TenTieuDe = new JTextField();
		txt_TenTieuDe.setBounds(106, 26, 351, 25);
		panel.add(txt_TenTieuDe);
		txt_TenTieuDe.setColumns(10);

		JLabel lblLoia = new JLabel("Loại Đĩa  :");
		lblLoia.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblLoia.setBounds(10, 71, 86, 28);
		panel.add(lblLoia);

		cbo_loaiDia = new JComboBox();
		cbo_loaiDia.addItem("Không lựa chọn");
		cbo_loaiDia.setBounds(106, 74, 141, 25);
		panel.add(cbo_loaiDia);

		btn_timKiem = new JButton("Tìm Kiếm");
		btn_timKiem.setBounds(355, 71, 102, 30);
		panel.add(btn_timKiem);

		btn_LamMoi = new JButton("Làm Mới");
		btn_LamMoi.setBounds(355, 105, 102, 30);
		panel.add(btn_LamMoi);
		
		btnThoat = new JButton("Thoát");
		btnThoat.setBounds(10, 108, 102, 30);
		panel.add(btnThoat);

		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0)), "Ch\u1EE9c N\u0103ng",
				TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.setLayout(null);
		panel_1.setBounds(499, 11, 182, 146);
		contentPane.add(panel_1);

		btn_Them = new JButton("Thêm mới");
		btn_Them.setBounds(47, 24, 102, 30);
		panel_1.add(btn_Them);

		btn_capNhat = new JButton("Cập Nhật");
		btn_capNhat.setBounds(47, 65, 102, 30);
		panel_1.add(btn_capNhat);

		btn_xoa = new JButton("Xóa");
		btn_xoa.setBounds(47, 106, 102, 30);
		panel_1.add(btn_xoa);

		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0)), "Danh S\u00E1ch Ti\u00EAu \u0110\u1EC1",
				TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_2.setBounds(10, 168, 671, 337);
		contentPane.add(panel_2);
		panel_2.setLayout(null);

		JScrollPane scrollPane;
		String[] headers = "Mã Tiêu Đề;Tên Tiêu Đề;Loại Đĩa".split(";");
		tableModel = new DefaultTableModel(headers, 0);
		panel_2.add(scrollPane = new JScrollPane(table = new JTable(tableModel), JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED));
		// table.setEnabled(false);

		scrollPane.setBounds(10, 23, 647, 303);

		table.addMouseListener(this);
		btn_Them.addActionListener(this);
		btn_capNhat.addActionListener(this);
		btn_xoa.addActionListener(this);
		btn_timKiem.addActionListener(this);
		btn_LamMoi.addActionListener(this);
		btnThoat.addActionListener(this);
		tieuDeDAO = new TieuDeDAO();
		loaiDiaDAO = new LoaiDiaDAO();
		capNhatBangDuLieu();
		capNhatCombobox();
	}

	private void capNhatBangDuLieu() {
		int rowCount = table.getRowCount();
		for (int i = rowCount; i > 0; i--) {
			tableModel.removeRow(i - 1);
		}

		List<TieuDe> tieuDes = new ArrayList<TieuDe>();

		if (txt_TenTieuDe.getText().trim().equals(""))
			tieuDes = tieuDeDAO.findALL();
		else
			tieuDes = tieuDeDAO.timTieuDeTheoTen(txt_TenTieuDe.getText());

		if (cbo_loaiDia.getSelectedItem().equals("Không lựa chọn")) {
			for (TieuDe tieuDe : tieuDes) {
				String[] strings = { tieuDe.getMaTieuDe() + "", tieuDe.getTenTieuDe(),
						tieuDe.getLoaiDia().getTenLoaiDia().name() };
				tableModel.addRow(strings);
			}
		} else {
			for (TieuDe tieuDe : tieuDes) {
				String[] strings = { tieuDe.getMaTieuDe() + "", tieuDe.getTenTieuDe(),
						tieuDe.getLoaiDia().getTenLoaiDia().name() };
				if (cbo_loaiDia.getSelectedItem() == tieuDe.getLoaiDia().getTenLoaiDia())
					tableModel.addRow(strings);
			}
		}
	}

	private void capNhatCombobox() {
		List<LoaiDia> loaiDias = loaiDiaDAO.findALL();
		for (LoaiDia loaiDia : loaiDias) {
			cbo_loaiDia.addItem(loaiDia.getTenLoaiDia());
		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		Object object = e.getSource();
		if (object.equals(table)) {
			String ma = (String) table.getValueAt(table.getSelectedRow(), 0);
			this.maTieuDe = Long.parseLong(ma);
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
		if (o.equals(btn_Them)) {
			TieuDeGUI tieuDeUI = new TieuDeGUI(Long.parseLong("0"));
			tieuDeUI.setVisible(true);
		} else if (o.equals(btn_capNhat)) {
			if (maTieuDe != Long.parseLong("0")) {
				TieuDeGUI tieuDeUI = new TieuDeGUI(maTieuDe);
				tieuDeUI.setVisible(true);
			} else {
				JOptionPane.showMessageDialog(this, "Bạn phải chọn tiêu đề !");
			}
		} else if (o.equals(btn_xoa)) {
			if (maTieuDe != Long.parseLong("0")) {
				int i = JOptionPane.showConfirmDialog(null, "Bạn có muốn xóa tiêu đề ?", "Cảnh Báo",
						JOptionPane.YES_NO_OPTION);
				if (i == JOptionPane.YES_OPTION) {
					tieuDeDAO.xoa(tieuDeDAO.timTheoMa(maTieuDe));
					JOptionPane.showMessageDialog(this, "Đã xóa tiêu đề !");
					maTieuDe = Long.parseLong("0");
				}
			} else {
				JOptionPane.showMessageDialog(this, "Bạn phải chọn tiêu đề !");
			}
//			tieuDeDAO.xoa(tieuDeDAO.timTheoMa(maTieuDe));
//			JOptionPane.showMessageDialog(this, "Đã xóa tiêu đề !");
		} else if (o.equals(btn_timKiem)) {
			capNhatBangDuLieu();
		} else if (o.equals(btn_LamMoi)) {
			txt_TenTieuDe.setText("");
			cbo_loaiDia.setSelectedIndex(0);
			capNhatBangDuLieu();
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