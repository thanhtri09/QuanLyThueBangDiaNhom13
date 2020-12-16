package ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import dao.implDAO.LoaiDiaDAO;
import dao.implDAO.TieuDeDAO;
import entities.LoaiDia;
import entities.TaiKhoan;
import entities.TenLoaiDia;
import entities.TieuDe;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.TextArea;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;

public class TieuDeGUI extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JTextField txt_TieuDe;
	private TextArea ta_TomTat;
	private Long maTieuDe;
	private JButton btn_Luu;
	private TieuDeDAO tieuDeDAO;
	private JComboBox cbo_LoaiDia;
	private LoaiDiaDAO loaiDiaDAO;
	private JButton btnThoat;

	public TieuDeGUI(Long maTieuDe) {
		setTitle("Tiêu Đề");
		setBounds(100, 100, 532, 351);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);
		setResizable(false);

		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("Tên Tiêu Đề :");
		lblNewLabel.setBounds(10, 11, 85, 28);
		contentPane.add(lblNewLabel);

		JLabel lblTmTt = new JLabel("Tóm Tắt :");
		lblTmTt.setBounds(30, 50, 65, 28);
		contentPane.add(lblTmTt);

		txt_TieuDe = new JTextField();
		txt_TieuDe.setBounds(105, 13, 376, 24);
		contentPane.add(txt_TieuDe);
		txt_TieuDe.setColumns(10);

		ta_TomTat = new TextArea();
		ta_TomTat.setBounds(101, 50, 380, 160);
		contentPane.add(ta_TomTat);

		JLabel lblLoia = new JLabel("Loại Đĩa :");
		lblLoia.setBounds(30, 226, 65, 28);
		contentPane.add(lblLoia);

		cbo_LoaiDia = new JComboBox();
		cbo_LoaiDia.setBounds(105, 228, 178, 25);
		contentPane.add(cbo_LoaiDia);

		btn_Luu = new JButton("Lưu");
		btn_Luu.setBounds(304, 273, 102, 30);
		contentPane.add(btn_Luu);
		
		btnThoat = new JButton("Thoát");
		btnThoat.setBounds(412, 273, 102, 30);
		contentPane.add(btnThoat);

		btn_Luu.addActionListener(this);

		this.maTieuDe = maTieuDe;
		this.tieuDeDAO = new TieuDeDAO();
		this.loaiDiaDAO = new LoaiDiaDAO();
		btnThoat.addActionListener(this);
		capNhatCombobox();
		Long ma = (long) 0;
		if (maTieuDe != ma) {
			upDuLieu();
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object o = e.getSource();
		if (o.equals(btn_Luu)) {
			Long ma = (long) 0;
			if (maTieuDe != ma) {
				String tenTieuDe = txt_TieuDe.getText();
				String tomTat = ta_TomTat.getText();
				LoaiDia loaiDia;
				if (cbo_LoaiDia.getSelectedItem() == TenLoaiDia.DVD) {
					// loaiDia = loaiDiaDAO.timLoaiDiaTheoTen(TenLoaiDia.DVD);
					loaiDia = loaiDiaDAO.timTheoMa(Long.parseLong("1"));
				} else {
					loaiDia = loaiDiaDAO.timTheoMa(Long.parseLong("2"));
				}
				TieuDe tieuDe = tieuDeDAO.timTheoMa(maTieuDe);
				tieuDe.setTenTieuDe(tenTieuDe);
				tieuDe.setTomTat(tomTat);
				tieuDe.setLoaiDia(loaiDia);
				if (tieuDeDAO.sua(tieuDe) != null) {
					JOptionPane.showMessageDialog(this, "Cập Nhật thành công !");
					setVisible(false);
				}

			} else {

				String tenTieuDe = txt_TieuDe.getText();
				String tomTat = ta_TomTat.getText();
				LoaiDia loaiDia;
				if (cbo_LoaiDia.getSelectedItem() == TenLoaiDia.DVD) {
					// loaiDia = loaiDiaDAO.timLoaiDiaTheoTen(TenLoaiDia.DVD);
					loaiDia = loaiDiaDAO.timTheoMa(Long.parseLong("1"));
				} else {
					loaiDia = loaiDiaDAO.timTheoMa(Long.parseLong("2"));
				}

				TieuDe tieuDe = new TieuDe(tenTieuDe, tomTat, loaiDia);
				if (tieuDeDAO.them(tieuDe) != null) {
					JOptionPane.showMessageDialog(this, "Thêm thành công !");
					setVisible(false);
				}
			}
		}
		else if(o.equals(btnThoat)) {
			DangNhapGUI tkdn = new DangNhapGUI();
			TaiKhoan tk = new TaiKhoan();
			tk = tkdn.getTk();
			Giaodientongquat gd=new Giaodientongquat(tk);
			gd.setVisible(true);
			this.setVisible(false);
		}

	}

	private void capNhatCombobox() {
		List<LoaiDia> loaiDias = loaiDiaDAO.findALL();
		for (LoaiDia loaiDia : loaiDias) {
			cbo_LoaiDia.addItem(loaiDia.getTenLoaiDia());
		}
	}

	private void upDuLieu() {
		TieuDe tieuDe = tieuDeDAO.timTheoMa(maTieuDe);
		txt_TieuDe.setText(tieuDe.getTenTieuDe());
		ta_TomTat.setText(tieuDe.getTomTat());
		cbo_LoaiDia.setSelectedItem(tieuDe.getLoaiDia().getTenLoaiDia());
	}
}