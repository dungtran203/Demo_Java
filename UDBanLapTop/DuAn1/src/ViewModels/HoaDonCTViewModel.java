/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ViewModels;

/**
 *
 * @author anhtu
 */
public class HoaDonCTViewModel {
    String mahd, masp, tensp;
    int soluong;
    double dongia;
    double thanhTien;

    public HoaDonCTViewModel() {
    }

    public HoaDonCTViewModel(String mahd, String masp, String tensp, int soluong, double dongia, double thanhTien) {
        this.mahd = mahd;
        this.masp = masp;
        this.tensp = tensp;
        this.soluong = soluong;
        this.dongia = dongia;
        this.thanhTien = thanhTien;
    }

    public String getMahd() {
        return mahd;
    }

    public void setMahd(String mahd) {
        this.mahd = mahd;
    }

    public String getMasp() {
        return masp;
    }

    public void setMasp(String masp) {
        this.masp = masp;
    }

    public String getTensp() {
        return tensp;
    }

    public void setTensp(String tensp) {
        this.tensp = tensp;
    }

    public int getSoluong() {
        return soluong;
    }

    public void setSoluong(int soluong) {
        this.soluong = soluong;
    }

    public double getDongia() {
        return dongia;
    }

    public void setDongia(double dongia) {
        this.dongia = dongia;
    }

    public double getThanhTien() {
        return thanhTien;
    }

    public void setThanhTien(double thanhTien) {
        this.thanhTien = thanhTien;
    }

    
    public Object[] toDataRow(){
        return new Object[]{mahd, masp, tensp, soluong, dongia, thanhTien};
    }
    
}
