package GiaoDien;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;



public class FrmQLDia extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JTextField txtGiaChoThue, txtMaBangDia, txtTenBangDia;
	private JTable table;
	private JComboBox<String> cboNCC, cboTheLoai;
	// private List<BangDia> list;
	private DefaultTableModel tablemodel;
	private JLabel lblSoLuong;
	private JPanel panel_1;
	private JTextField txtSoLuong;
	private JTextArea txaMoTa;
	private JButton btnThem, btnCapNhat, btnTimKiem, btnXemAll, btnTroVe;
	private JButton btnXoaRong;
	private JPanel panel_2;
	JFrame frame = new JFrame();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmQLDia window = new FrmQLDia();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public FrmQLDia() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		setTitle("Thuê Băng Đĩa");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 1264, 719);
		setLocationRelativeTo(null);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		String[] colName = "Mã Băng Đĩa;Tên Băng Đĩa;Thể Loại;Giá Thuê".split(";");
		tablemodel = new DefaultTableModel(colName, 0);
		JScrollPane scrollPane = new JScrollPane(table = new JTable(tablemodel), JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scrollPane.setBounds(10, 10, 683, 668);
//		table.addMouseListener(this);
		contentPane.add(scrollPane);
		
				// XuatTTCombobox();
		
				panel_1 = new JPanel();
				panel_1.setBackground(Color.WHITE);
				panel_1.setBorder(new LineBorder(new Color(0, 0, 0)));
				panel_1.setBounds(703, 10, 541, 668);
				contentPane.add(panel_1);
				panel_1.setLayout(null);
				
						txtGiaChoThue = new JTextField();
						txtGiaChoThue.setFont(new Font("Tahoma", Font.PLAIN, 14));
						txtGiaChoThue.setBounds(124, 317, 140, 20);
						panel_1.add(txtGiaChoThue);
						txtGiaChoThue.setColumns(10);
						
								JLabel lblNewLabel_1 = new JLabel("Chi Tiết Băng Đĩa");
								lblNewLabel_1.setBounds(168, 11, 200, 39);
								panel_1.add(lblNewLabel_1);
								lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 23));
								
										JLabel lblMBnga = new JLabel("Mã Băng Đĩa:");
										lblMBnga.setBounds(27, 95, 87, 22);
										panel_1.add(lblMBnga);
										lblMBnga.setFont(new Font("Tahoma", Font.PLAIN, 14));
										
												txtMaBangDia = new JTextField();
												txtMaBangDia.setEditable(false);
												txtMaBangDia.setFont(new Font("Tahoma", Font.BOLD, 14));
												txtMaBangDia.setBounds(124, 96, 110, 20);
												panel_1.add(txtMaBangDia);
												txtMaBangDia.setColumns(10);
												
														JLabel lblTnBnga = new JLabel("Tên Băng Đĩa:");
														lblTnBnga.setBounds(27, 149, 94, 22);
														panel_1.add(lblTnBnga);
														lblTnBnga.setFont(new Font("Tahoma", Font.PLAIN, 14));
														
																txtTenBangDia = new JTextField();
																txtTenBangDia.setFont(new Font("Tahoma", Font.PLAIN, 14));
																txtTenBangDia.setBounds(124, 149, 368, 22);
																panel_1.add(txtTenBangDia);
																txtTenBangDia.setColumns(10);
																
																		JLabel lblThLoi = new JLabel("Thể Loại:");
																		lblThLoi.setBounds(53, 205, 68, 22);
																		panel_1.add(lblThLoi);
																		lblThLoi.setFont(new Font("Tahoma", Font.PLAIN, 14));
																		
																				cboTheLoai = new JComboBox<String>();
																				cboTheLoai.setFont(new Font("Tahoma", Font.PLAIN, 14));
																				cboTheLoai.setBounds(124, 205, 146, 22);
																				panel_1.add(cboTheLoai);
																				
																						JLabel lblNhCungCp = new JLabel("Nhà Cung Cấp:");
																						lblNhCungCp.setBounds(19, 256, 102, 22);
																						panel_1.add(lblNhCungCp);
																						lblNhCungCp.setFont(new Font("Tahoma", Font.PLAIN, 14));
																						
																								cboNCC = new JComboBox<String>();
																								cboNCC.setFont(new Font("Tahoma", Font.PLAIN, 14));
																								cboNCC.setBounds(124, 256, 368, 22);
																								panel_1.add(cboNCC);
																								
																										JLabel lblGiChoThu = new JLabel("Giá Cho Thuê:");
																										lblGiChoThu.setBounds(27, 314, 94, 22);
																										panel_1.add(lblGiChoThu);
																										lblGiChoThu.setFont(new Font("Tahoma", Font.PLAIN, 14));
																										
																												JLabel lblMT = new JLabel("Mô Tả:");
																												lblMT.setBounds(67, 363, 54, 22);
																												panel_1.add(lblMT);
																												lblMT.setFont(new Font("Tahoma", Font.PLAIN, 14));
																												
																														JLabel lblNewLabel = new JLabel("VND");
																														lblNewLabel.setBounds(274, 320, 35, 14);
																														panel_1.add(lblNewLabel);
																														lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
																														
																																lblSoLuong = new JLabel("Số Lượng :");
																																lblSoLuong.setBounds(306, 205, 78, 22);
																																panel_1.add(lblSoLuong);
																																lblSoLuong.setFont(new Font("Tahoma", Font.PLAIN, 14));
																																
																																		txtSoLuong = new JTextField();
																																		txtSoLuong.setFont(new Font("Tahoma", Font.PLAIN, 14));
																																		txtSoLuong.setBounds(382, 205, 110, 22);
																																		panel_1.add(txtSoLuong);
																																		txtSoLuong.setColumns(10);
																																		
																																				JScrollPane scrollPane_1 = new JScrollPane();
																																				scrollPane_1.setBounds(119, 367, 373, 112);
																																				panel_1.add(scrollPane_1);
																																				
																																						txaMoTa = new JTextArea();
																																						scrollPane_1.setViewportView(txaMoTa);
																																						
																																								JPanel panel = new JPanel();
																																								panel.setLayout(null);
																																								panel.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0)), "Thanh C\u00F4ng C\u1EE5",

																																										TitledBorder.LEADING, TitledBorder.TOP, null, null));
																																								panel.setBackground(Color.WHITE);
																																								panel.setBounds(10, 512, 521, 65);
																																								panel_1.add(panel);
																																								
																																										btnThem = new JButton("Thêm");
																																										btnThem.setBounds(10, 23, 89, 23);
																																										panel.add(btnThem);
																																										btnThem.setFont(new Font("Tahoma", Font.PLAIN, 14));
																																										
																																												btnCapNhat = new JButton("Cập Nhật");
																																												btnCapNhat.setBounds(145, 23, 102, 23);
																																												panel.add(btnCapNhat);
																																												btnCapNhat.setFont(new Font("Tahoma", Font.PLAIN, 14));
																																												
																																														btnXoaRong = new JButton("Xóa Rỗng");
																																														btnXoaRong.setBounds(292, 23, 102, 23);
																																														panel.add(btnXoaRong);
																																														btnXoaRong.setFont(new Font("Tahoma", Font.PLAIN, 14));
																																														
																																																btnTroVe = new JButton("Trở Về");
																																																btnTroVe.setBounds(422, 23, 89, 23);
																																																panel.add(btnTroVe);
																																																btnTroVe.setFont(new Font("Tahoma", Font.PLAIN, 14));
																																																
																																																		panel_2 = new JPanel();
																																																		panel_2.setLayout(null);
																																																		panel_2.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0)), "Thanh T\u00ECm Ki\u1EBFm",

																																																				TitledBorder.LEADING, TitledBorder.TOP, null, null));
																																																		panel_2.setBackground(Color.WHITE);
																																																		panel_2.setBounds(10, 588, 521, 71);
																																																		panel_1.add(panel_2);
																																																		
																																																				btnXemAll = new JButton("Xem toàn bộ danh sách");
																																																				btnXemAll.setBounds(60, 31, 200, 23);
																																																				panel_2.add(btnXemAll);
																																																				btnXemAll.setFont(new Font("Tahoma", Font.PLAIN, 14));
																																																				
																																																						btnTimKiem = new JButton("Tìm Kiếm");
																																																						btnTimKiem.setBounds(337, 31, 102, 23);
																																																						panel_2.add(btnTimKiem);
																																																						btnTimKiem.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnTimKiem.addActionListener(this);
		btnXemAll.addActionListener(this);
		btnTroVe.addActionListener(this);
		btnCapNhat.addActionListener(this);
		btnXoaRong.addActionListener(this);

		btnThem.addActionListener(this);

//		XuatTTCombobox();

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}
