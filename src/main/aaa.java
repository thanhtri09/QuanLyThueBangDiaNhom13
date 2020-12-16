package main;

import java.time.LocalDate;
import java.util.ArrayList;

import dao.IKhachHangDAO;
import dao.QuanLyBangDiaEntityManager;
import dao.implDAO.ChiTietHoaDonDAO;
import dao.implDAO.ChiTietPhieuDatTruocDAO;
import dao.implDAO.DiaDAO;
import dao.implDAO.HoaDonDAO;
import dao.implDAO.KhachHangDAO;
import dao.implDAO.PhieuDatTruocDAO;
import dao.implDAO.TuaDeDAO;
import entities.ChiTietHoaDonID;
import entities.ChiTietPhieuDatTruoc;
import entities.Dia;
import entities.HoaDon;
import entities.KhachHang;
import entities.PhieuDatTruoc;
import entities.TieuDe;
import entities.TrangThaiDia;
import xuli.CountDownThread;

public class aaa {
	public static void main(String[] args) {
		QuanLyBangDiaEntityManager dao = new QuanLyBangDiaEntityManager();
		CountDownThread countDownThread=new CountDownThread();
		countDownThread.start();
	}

}
