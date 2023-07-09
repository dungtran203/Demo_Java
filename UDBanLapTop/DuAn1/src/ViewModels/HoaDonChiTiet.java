/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ViewModels;

/**
 *
 * @author Dell Inpriron 5515
 */
public class HoaDonChiTiet {

    String maHDCT;
    String maHD;
    String maSP;
    int soLuong;
    double donGia;
    String tienGiam;

    public HoaDonChiTiet() {
    }

    public HoaDonChiTiet( String maHD, String maSP, int soLuong, double donGia, String tienGiam) {
        
        this.maHD = maHD;
        this.maSP = maSP;
        this.soLuong = soLuong;
        this.donGia = donGia;
        this.tienGiam = tienGiam;
    }

    public String getMaHDCT() {
        return maHDCT;
    }

    public void setMaHDCT(String maHDCT) {
        this.maHDCT = maHDCT;
    }

    public String getMaHD() {
        return maHD;
    }

    public void setMaHD(String maHD) {
        this.maHD = maHD;
    }

    public String getMaSP() {
        return maSP;
    }

    public void setMaSP(String maSP) {
        this.maSP = maSP;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public double getDonGia() {
        return donGia;
    }

    public void setDonGia(double donGia) {
        this.donGia = donGia;
    }

    public String getTienGiam() {
        return tienGiam;
    }

    public void setTienGiam(String tienGiam) {
        this.tienGiam = tienGiam;
    }

    @Override
    public String toString() {
        return "HoaDonChiTiet{" + "maHDCT=" + maHDCT + ", maHD=" + maHD + ", maSP=" + maSP + ", soLuong=" + soLuong + ", donGia=" + donGia + ", tienGiam=" + tienGiam + '}';
    }

}
