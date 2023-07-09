/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ViewModels;

import java.util.Date;

/**
 *
 * @author Dell Inpriron 5515
 */
public class HoaDon {

    String maHD;
    Date ngayTao;
    Date ngayThanhToan;
    String tinhTrang;
    String maKH;
    String maNV;
    double thanhTien;

    public HoaDon(String maHD, Date ngayTao, Date ngayThanhToan, String tinhTrang, String maKH, String maNV, double thanhTien) {
        this.maHD = maHD;
        this.ngayTao = ngayTao;
        this.ngayThanhToan = ngayThanhToan;
        this.tinhTrang = tinhTrang;
        this.maKH = maKH;
        this.maNV = maNV;
        this.thanhTien = thanhTien;
    }

    public HoaDon(String maHD, Date ngayTao, String maKH, String maNV, String tinhTrang) {
        this.maHD = maHD;
        this.ngayTao = ngayTao;
        this.maKH = maKH;
        this.maNV = maNV;
        this.tinhTrang = tinhTrang;
    }

    public HoaDon(String maHD, Date ngayTao, Date ngayThanhToan, String tinhTrang, String maKH, String maNV) {
        this.maHD = maHD;
        this.ngayTao = ngayTao;
        this.ngayThanhToan = ngayThanhToan;
        this.tinhTrang = tinhTrang;
        this.maKH = maKH;
        this.maNV = maNV;
    }

    public HoaDon() {
    }

    public String getMaHD() {
        return maHD;
    }

    public void setMaHD(String maHD) {
        this.maHD = maHD;
    }

    public Date getNgayTao() {
        return ngayTao;
    }

    public void setNgayTao(Date ngayTao) {
        this.ngayTao = ngayTao;
    }

    public Date getNgayThanhToan() {
        return ngayThanhToan;
    }

    public void setNgayThanhToan(Date ngayThanhToan) {
        this.ngayThanhToan = ngayThanhToan;
    }

    public String getMaKH() {
        return maKH;
    }

    public void setMaKH(String maKH) {
        this.maKH = maKH;
    }

    public String getMaNV() {
        return maNV;
    }

    public void setMaNV(String maNV) {
        this.maNV = maNV;
    }

    public String getTinhTrang() {
        return tinhTrang;
    }

    public void setTinhTrang(String tinhTrang) {
        this.tinhTrang = tinhTrang;
    }

    public double getThanhTien() {
        return thanhTien;
    }

    public void setThanhTien(double thanhTien) {
        this.thanhTien = thanhTien;
    }

}
