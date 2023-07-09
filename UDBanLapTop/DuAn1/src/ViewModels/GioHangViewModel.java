/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ViewModels;

/**
 *
 * @author Dell Inpriron 5515
 */
public class GioHangViewModel {

    String maSP;
    String tenSP;
    Integer soLuong;
    double donGia;
    String giamGia;
    double thanhTien;

    public GioHangViewModel() {
    }

    public String getGiamGia() {
        return giamGia;
    }

    public void setGiamGia(String giamGia) {
        this.giamGia = giamGia;
    }

    public GioHangViewModel(String maSP, String tenSP, Integer soLuong, double donGia, double thanhTien) {
        this.maSP = maSP;
        this.tenSP = tenSP;
        this.soLuong = soLuong;
        this.donGia = donGia;
        this.thanhTien = thanhTien;
    }

    public GioHangViewModel(String maSP, String tenSP, Integer soLuong, double donGia, String giamGia) {
        this.maSP = maSP;
        this.tenSP = tenSP;
        this.soLuong = soLuong;
        this.donGia = donGia;
        this.giamGia = giamGia;
    }

    public GioHangViewModel(String tenSP, Integer soLuong, double donGia, String giamGia) {
        this.tenSP = tenSP;
        this.soLuong = soLuong;
        this.donGia = donGia;
        this.giamGia = giamGia;
    }
     

    public String getMaSP() {
        return maSP;
    }

    public void setMaSP(String maSP) {
        this.maSP = maSP;
    }

    public String getTenSP() {
        return tenSP;
    }

    public void setTenSP(String tenSP) {
        this.tenSP = tenSP;
    }

    public Integer getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(Integer soLuong) {
        this.soLuong = soLuong;
    }

    public double getDonGia() {
        return donGia;
    }

    public void setDonGia(double donGia) {
        this.donGia = donGia;
    }

    public double getThanhTien() {
        return thanhTien;
    }

    public void setThanhTien(double thanhTien) {
        this.thanhTien = thanhTien;
    }

    @Override
    public String toString() {
        return "GioHangViewModel{" + "maSP=" + maSP + ", tenSP=" + tenSP + ", soLuong=" + soLuong + ", donGia=" + donGia + ", thanhTien=" + thanhTien + '}';
    }
    
}
