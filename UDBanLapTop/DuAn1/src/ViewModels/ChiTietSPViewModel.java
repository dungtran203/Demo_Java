/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ViewModels;

/**
 *
 * @author anhtu
 */
public class ChiTietSPViewModel {

    String maSP;
    String tenSP;
    double donGia;
    String giamGia;
    String mauSac;
    String tenNSX;
    String kichThuoc;
    double trongLuong;
    Integer soLuongTon;

    public ChiTietSPViewModel() {
    }

    public ChiTietSPViewModel(String maSP, String tenSP, double donGia, String giamGia, Integer soLuongTon) {
        this.maSP = maSP;
        this.tenSP = tenSP;
        this.donGia = donGia;
        this.giamGia = giamGia;
        this.soLuongTon = soLuongTon;
    }

    public ChiTietSPViewModel(String maSP, String tenSP, double donGia, String giamGia, String mauSac, String tenNSX, String kichThuoc, double trongLuong, Integer soLuongTon) {
        this.maSP = maSP;
        this.tenSP = tenSP;
        this.donGia = donGia;
        this.giamGia = giamGia;
        this.mauSac = mauSac;
        this.tenNSX = tenNSX;
        this.kichThuoc = kichThuoc;
        this.trongLuong = trongLuong;
        this.soLuongTon = soLuongTon;
    }

    public ChiTietSPViewModel(String tenSP, double donGia, String giamGia, String mauSac, String tenNSX, String kichThuoc, double trongLuong, Integer soLuongTon) {
        this.tenSP = tenSP;
        this.donGia = donGia;
        this.giamGia = giamGia;
        this.mauSac = mauSac;
        this.tenNSX = tenNSX;
        this.kichThuoc = kichThuoc;
        this.trongLuong = trongLuong;
        this.soLuongTon = soLuongTon;
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

    public double getDonGia() {
        return donGia;
    }

    public void setDonGia(double donGia) {
        this.donGia = donGia;
    }

    public String getGiamGia() {
        return giamGia;
    }

    public void setGiamGia(String giamGia) {
        this.giamGia = giamGia;
    }

    public String getMauSac() {
        return mauSac;
    }

    public void setMauSac(String mauSac) {
        this.mauSac = mauSac;
    }

    public String getTenNSX() {
        return tenNSX;
    }

    public void setTenNSX(String tenNSX) {
        this.tenNSX = tenNSX;
    }

    public String getKichThuoc() {
        return kichThuoc;
    }

    public void setKichThuoc(String kichThuoc) {
        this.kichThuoc = kichThuoc;
    }

    public double getTrongLuong() {
        return trongLuong;
    }

    public void setTrongLuong(double trongLuong) {
        this.trongLuong = trongLuong;
    }

    public Integer getSoLuongTon() {
        return soLuongTon;
    }

    public void setSoLuongTon(Integer soLuongTon) {
        this.soLuongTon = soLuongTon;
    }

    @Override
    public String toString() {
        return mauSac;
    }

}
