package xuli;

import java.awt.Color;

import ui.Giaodientongquat;
import ui.DangNhapGUI;
import ui.FrmGioiThieu;


public class CountDownThread extends Thread {
	public void run() {
		int count = 5;
		FrmGioiThieu frmGioiThieu = new FrmGioiThieu();
		frmGioiThieu.setVisible(true);
		frmGioiThieu.setLocationRelativeTo(null);
		for(int i=0;i<count;i++) {
			try {
				Thread.sleep(1000);
				frmGioiThieu.progressBar.setValue(25);
				if(i==1)
					frmGioiThieu.progressBar.setValue(55);
				if(i==2)
					frmGioiThieu.progressBar.setValue(75);
				if(i==3)
					frmGioiThieu.progressBar.setValue(95);
				if(i==4)
					frmGioiThieu.progressBar.setValue(99);
				if(i==5)
					frmGioiThieu.progressBar.setValue(100);
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		frmGioiThieu.setVisible(false);
//		DangNhapGUI gd=new DangNhapGUI();
//		gd.setVisible(true);
//		FrmManHinhChinh fraChinh=new FrmManHinhChinh();
//		fraChinh.setVisible(true);
//		fraChinh.setLocationRelativeTo(null);
//		Giaodientongquat gd=new Giaodientongquat();
//		gd.setVisible(true);
//		gd.setLocationRelativeTo(null);
//		gd.setLayout(null);
		Giaodientongquat gd = new Giaodientongquat(null);
		gd.setVisible(true);

	}
	
}
