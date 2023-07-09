/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DomainModels;

/**
 *
 * @author anhtu
 */
public class KhachHang {
    String ma, ten, sdt;
    String gioitinh;
    String email, diachi;

    public KhachHang() {
    }

    public KhachHang(String ma, String ten, String sdt, String gioitinh, String email, String diachi) {
        this.ma = ma;
        this.ten = ten;
        this.sdt = sdt;
        this.gioitinh = gioitinh;
        this.email = email;
        this.diachi = diachi;
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

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public String getGioitinh() {
        return gioitinh;
    }

    public void setGioitinh(String gioitinh) {
        this.gioitinh = gioitinh;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDiachi() {
        return diachi;
    }

    public void setDiachi(String diachi) {
        this.diachi = diachi;
    }

    @Override
    public String toString() {
        return  ma ;
    }
    
    public Object[] toDataRow(){
        return new Object[]{ma, ten, sdt, gioitinh, email, diachi};
    }
}
