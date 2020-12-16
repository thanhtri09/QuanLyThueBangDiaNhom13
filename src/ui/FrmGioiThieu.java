
package ui;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;

import javax.swing.ImageIcon;

import javax.swing.GroupLayout.Alignment;
import javax.swing.GroupLayout;

import javax.swing.JProgressBar;
import java.awt.Font;

import java.awt.Color;

public class FrmGioiThieu extends JFrame {

	private JPanel contentPane;
	private JPanel jPanel1;
	private JLabel jLabel1;
	public JProgressBar progressBar;

	public FrmGioiThieu() {
		java.awt.GridBagConstraints gridBagConstraints;

		jPanel1 = new javax.swing.JPanel();
		jLabel1 = new javax.swing.JLabel();

		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
		getContentPane().setLayout(new java.awt.GridBagLayout());

		jPanel1.setOpaque(false);

		progressBar = new JProgressBar();
		progressBar.setStringPainted(true);
		progressBar.setForeground(Color.BLUE);
		progressBar.setToolTipText("");
		progressBar.setFont(new Font("Times New Roman", Font.PLAIN, 13));

		javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
		jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(Alignment.LEADING)
				.addGroup(jPanel1Layout.createSequentialGroup().addGap(406)
						.addComponent(progressBar, GroupLayout.PREFERRED_SIZE, 188, GroupLayout.PREFERRED_SIZE)
						.addContainerGap(406, Short.MAX_VALUE)));
		jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(Alignment.TRAILING)
				.addGroup(jPanel1Layout.createSequentialGroup().addContainerGap(549, Short.MAX_VALUE)
						.addComponent(progressBar, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
						.addGap(26)));
		jPanel1.setLayout(jPanel1Layout);

		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.gridx = 1;
		gridBagConstraints.gridy = 1;
		gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
		getContentPane().add(jPanel1, gridBagConstraints);

		jLabel1.setIcon(new ImageIcon("T:\\QuanLyBangDia\\src\\icon\\manhinhchinh.jpg")); // NOI18N
		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.gridx = 1;
		gridBagConstraints.gridy = 1;
		gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
		getContentPane().add(jLabel1, gridBagConstraints);
		pack();

	}
}
