/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DomainModels;

/**
 *
 * @author Tran Thi My Dung
 */
public class SanPham {

    private String maSP;
    private String tenSP;
    private String mauSac;
    private String heDieuHanh;
    private int namBH;
    private float trongLuong;
    private String xuatXu;
    private String trangThai;
    private String moTa;
    String maDongSP;
    String maNSX;
    String maCPU;
    String maRAM;
    String maManHinh;
    double giaNhap;
    double giaBan;
    int soLuong;
    String barCode;

    public SanPham() {
    }

    public SanPham(String maSP, String tenSP, String mauSac, String heDieuHanh, String trangThai, double giaNhap, double giaBan, int soLuong) {
        this.maSP = maSP;
        this.tenSP = tenSP;
        this.mauSac = mauSac;
        this.heDieuHanh = heDieuHanh;
        this.trangThai = trangThai;
        this.giaNhap = giaNhap;
        this.giaBan = giaBan;
        this.soLuong = soLuong;
    }

    public SanPham(String maSP, String tenSP, String mauSac, String heDieuHanh, int namBH, float trongLuong, String xuatXu, String trangThai, String moTa, String maDongSP, String maNSX, String maCPU, String maRAM, String maManHinh, double giaNhap, double giaBan, int soLuong, String barCode) {
        this.maSP = maSP;
        this.tenSP = tenSP;
        this.mauSac = mauSac;
        this.heDieuHanh = heDieuHanh;
        this.namBH = namBH;
        this.trongLuong = trongLuong;
        this.xuatXu = xuatXu;
        this.trangThai = trangThai;
        this.moTa = moTa;
        this.maDongSP = maDongSP;
        this.maNSX = maNSX;
        this.maCPU = maCPU;
        this.maRAM = maRAM;
        this.maManHinh = maManHinh;
        this.giaNhap = giaNhap;
        this.giaBan = giaBan;
        this.soLuong = soLuong;
        this.barCode = barCode;
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

    public String getMauSac() {
        return mauSac;
    }

    public void setMauSac(String mauSac) {
        this.mauSac = mauSac;
    }

    public String getHeDieuHanh() {
        return heDieuHanh;
    }

    public void setHeDieuHanh(String heDieuHanh) {
        this.heDieuHanh = heDieuHanh;
    }

    public int getNamBH() {
        return namBH;
    }

    public void setNamBH(int namBH) {
        this.namBH = namBH;
    }

    public float getTrongLuong() {
        return trongLuong;
    }

    public void setTrongLuong(float trongLuong) {
        this.trongLuong = trongLuong;
    }

    public String getXuatXu() {
        return xuatXu;
    }

    public void setXuatXu(String xuatXu) {
        this.xuatXu = xuatXu;
    }

    public String getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(String trangThai) {
        this.trangThai = trangThai;
    }

    public String getMoTa() {
        return moTa;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }

    public String getMaDongSP() {
        return maDongSP;
    }

    public void setMaDongSP(String maDongSP) {
        this.maDongSP = maDongSP;
    }

    public String getMaNSX() {
        return maNSX;
    }

    public void setMaNSX(String maNSX) {
        this.maNSX = maNSX;
    }

    public String getMaCPU() {
        return maCPU;
    }

    public void setMaCPU(String maCPU) {
        this.maCPU = maCPU;
    }

    public String getMaRAM() {
        return maRAM;
    }

    public void setMaRAM(String maRAM) {
        this.maRAM = maRAM;
    }

    public String getMaManHinh() {
        return maManHinh;
    }

    public void setMaManHinh(String maManHinh) {
        this.maManHinh = maManHinh;
    }

    public double getGiaNhap() {
        return giaNhap;
    }

    public void setGiaNhap(double giaNhap) {
        this.giaNhap = giaNhap;
    }

    public double getGiaBan() {
        return giaBan;
    }

    public void setGiaBan(double giaBan) {
        this.giaBan = giaBan;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public String getBarCode() {
        return barCode;
    }

    public void setBarCode(String barCode) {
        this.barCode = barCode;
    }

}
