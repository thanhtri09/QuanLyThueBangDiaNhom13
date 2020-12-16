package ui;


import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import java.awt.Color;


public class FramTinhtrangmathang extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	public static JPanel jp2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FramTinhtrangmathang frame = new FramTinhtrangmathang();
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
	public FramTinhtrangmathang() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1500, 900);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		jp2 = new JPanel();
		jp2.setBackground(new Color(102, 204, 255));
		jp2.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		jp2.setBounds(10, 10, 1466, 825);
		contentPane.add(jp2);
		jp2.setLayout(null);
	}
}
