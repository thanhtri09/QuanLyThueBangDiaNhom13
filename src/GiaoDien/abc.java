package GiaoDien;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;


public class abc extends JFrame implements  ActionListener {

	private JFrame frame;
	private JPanel contentPane;
	private JTable table;
	private JTextField textField;
	private DefaultTableModel tablemodel;
	private JButton btnTraBangDia, btnTroVe, btnTimKiem;
	private String maNV;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					abc window = new abc();
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
	public abc() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.maNV = maNV;
		setTitle("Trả Băng Đĩa");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 941, 594);
		setLocationRelativeTo(null);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		String[] colNameHD = "Mã Phiếu Thuê;Tên Khách Hàng;Tên Nhân Viên;Ngày Lập Phiếu".split(";");
		tablemodel = new DefaultTableModel(colNameHD, 0);
		JScrollPane scrollPane = new JScrollPane(table = new JTable(tablemodel), JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scrollPane.setBounds(10, 57, 905, 391);
		contentPane.add(scrollPane);

//		capNhatBangDuLieuHoaDon();

		JLabel lblMPhiuThu = new JLabel("SDT Khách Hàng:");
		lblMPhiuThu.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblMPhiuThu.setBounds(10, 504, 140, 22);
		contentPane.add(lblMPhiuThu);

		textField = new JTextField();
		textField.setBounds(136, 507, 167, 20);
		contentPane.add(textField);
		textField.setColumns(10);

		btnTimKiem = new JButton("Tìm Kiếm");
		btnTimKiem.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnTimKiem.setBounds(313, 504, 116, 23);
		contentPane.add(btnTimKiem);

		btnTraBangDia = new JButton("Trả Băng Đĩa");
		btnTraBangDia.setBackground(Color.GREEN);
		btnTraBangDia.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnTraBangDia.setBounds(502, 494, 178, 43);
		contentPane.add(btnTraBangDia);

		JLabel lblTrBnga = new JLabel("Danh Sách Phiếu Thuê");
		lblTrBnga.setFont(new Font("Sitka Small", Font.BOLD, 22));
		lblTrBnga.setBounds(349, 11, 290, 35);
		contentPane.add(lblTrBnga);

		btnTroVe = new JButton("Trở Về");
		btnTroVe.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnTroVe.setBounds(773, 504, 116, 23);
		contentPane.add(btnTroVe);

		btnTraBangDia.addActionListener(this);
		btnTimKiem.addActionListener(this);
		btnTroVe.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

}
