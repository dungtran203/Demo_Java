/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DomainModels;

import java.util.Date;

/**
 *
 * @author anhtu
 */
public class KhuyenMai {
    String ma, ten, hinhthuc,giamgia, sanpham;
    Date ngaybatdau, ngayketthuc;
    String trangthai;
    String mota;

    public KhuyenMai() {
    }

    public KhuyenMai(String ma, String ten, String hinhthuc, String giamgia, String sanpham, Date ngaybatdau, Date ngayketthuc, String trangthai, String mota) {
        this.ma = ma;
        this.ten = ten;
        this.hinhthuc = hinhthuc;
        this.giamgia = giamgia;
        this.sanpham = sanpham;
        this.ngaybatdau = ngaybatdau;
        this.ngayketthuc = ngayketthuc;
        this.trangthai = trangthai;
        this.mota = mota;
    }

    public KhuyenMai(String ten, String hinhthuc, String giamgia, String sanpham, Date ngaybatdau, Date ngayketthuc, String trangthai, String mota) {
        this.ten = ten;
        this.hinhthuc = hinhthuc;
        this.giamgia = giamgia;
        this.sanpham = sanpham;
        this.ngaybatdau = ngaybatdau;
        this.ngayketthuc = ngayketthuc;
        this.trangthai = trangthai;
        this.mota = mota;
    }

    public String getMa() {
        return ma;
    }

    public void setMa(String ma) {
        this.ma = ma;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getHinhthuc() {
        return hinhthuc;
    }

    public void setHinhthuc(String hinhthuc) {
        this.hinhthuc = hinhthuc;
    }

    public String getGiamgia() {
        return giamgia;
    }

    public void setGiamgia(String giamgia) {
        this.giamgia = giamgia;
    }

    public String getSanpham() {
        return sanpham;
    }

    public void setSanpham(String sanpham) {
        this.sanpham = sanpham;
    }

    public Date getNgaybatdau() {
        return ngaybatdau;
    }

    public void setNgaybatdau(Date ngaybatdau) {
        this.ngaybatdau = ngaybatdau;
    }

    public Date getNgayketthuc() {
        return ngayketthuc;
    }

    public void setNgayketthuc(Date ngayketthuc) {
        this.ngayketthuc = ngayketthuc;
    }

    public String getTrangthai() {
        return trangthai;
    }

    public void setTrangthai(String trangthai) {
        this.trangthai = trangthai;
    }

    public String getMota() {
        return mota;
    }

    public void setMota(String mota) {
        this.mota = mota;
    }

    @Override
    public String toString() {
        return "KhuyenMai{" + "ma=" + ma + ", ten=" + ten + ", hinhthuc=" + hinhthuc + ", giamgia=" + giamgia + ", sanpham=" + sanpham + ", ngaybatdau=" + ngaybatdau + ", ngayketthuc=" + ngayketthuc + ", trangthai=" + trangthai + ", mota=" + mota + '}';
    }
}
