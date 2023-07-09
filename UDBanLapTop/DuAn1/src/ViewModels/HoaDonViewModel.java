/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ViewModels;

/**
 *
 * @author anhtu
 */
public class HoaDonViewModel {
    String maHD;
    double tongTien;
    double thanhToan;
    String ngaytao;
    String trangThai;
    String manv, tennv, makh, tenkh, ghichu;

    public HoaDonViewModel(String maHD, double tongTien, double thanhToan, String ngaytao, String trangThai, String manv, String tennv, String makh, String tenkh, String ghichu) {
        this.maHD = maHD;
        this.tongTien = tongTien;
        this.thanhToan = thanhToan;
        this.ngaytao = ngaytao;
        this.trangThai = trangThai;
        this.manv = manv;
        this.tennv = tennv;
        this.makh = makh;
        this.tenkh = tenkh;
        this.ghichu = ghichu;
    }

    public String getMaHD() {
        return maHD;
    }

    public void setMaHD(String maHD) {
        this.maHD = maHD;
    }

    public double getTongTien() {
        return tongTien;
    }

    public void setTongTien(double tongTien) {
        this.tongTien = tongTien;
    }

    public double getThanhToan() {
        return thanhToan;
    }

    public void setThanhToan(double thanhToan) {
        this.thanhToan = thanhToan;
    }

    public String getNgaytao() {
        return ngaytao;
    }

    public void setNgaytao(String ngaytao) {
        this.ngaytao = ngaytao;
    }

    public String getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(String trangThai) {
        this.trangThai = trangThai;
    }

    public String getManv() {
        return manv;
    }

    public void setManv(String manv) {
        this.manv = manv;
    }

    public String getTennv() {
        return tennv;
    }

    public void setTennv(String tennv) {
        this.tennv = tennv;
    }

    public String getMakh() {
        return makh;
    }

    public void setMakh(String makh) {
        this.makh = makh;
    }

    public String getTenkh() {
        return tenkh;
    }

    public void setTenkh(String tenkh) {
        this.tenkh = tenkh;
    }

    public String getGhichu() {
        return ghichu;
    }

    public void setGhichu(String ghichu) {
        this.ghichu = ghichu;
    }

    @Override
    public String toString() {
        return "HoaDonViewModel{" + "maHD=" + maHD + ", tongTien=" + tongTien + ", thanhToan=" + thanhToan + ", ngaytao=" + ngaytao + ", trangThai=" + trangThai + ", manv=" + manv + ", tennv=" + tennv + ", makh=" + makh + ", tenkh=" + tenkh + ", ghichu=" + ghichu + '}';
    }
    
    public Object[] toDataRow(){
        return new Object[]{maHD,tongTien,thanhToan, ngaytao, trangThai, manv, tennv, makh, tenkh, ghichu};
    }
}
