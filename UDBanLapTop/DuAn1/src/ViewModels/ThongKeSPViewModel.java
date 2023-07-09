/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ViewModels;

/**
 *
 * @author anhtu
 */
public class ThongKeSPViewModel {
    String ten;
    int soluongban;
    int soluotmua;
    double doanhthu;

    public ThongKeSPViewModel() {
    }

    public ThongKeSPViewModel(String ten, int soluongban, int soluotmua, double doanhthu) {
        this.ten = ten;
        this.soluongban = soluongban;
        this.soluotmua = soluotmua;
        this.doanhthu = doanhthu;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public int getSoluongban() {
        return soluongban;
    }

    public void setSoluongban(int soluongban) {
        this.soluongban = soluongban;
    }

    public int getSoluotmua() {
        return soluotmua;
    }

    public void setSoluotmua(int soluotmua) {
        this.soluotmua = soluotmua;
    }

    public double getDoanhthu() {
        return doanhthu;
    }

    public void setDoanhthu(double doanhthu) {
        this.doanhthu = doanhthu;
    }

    public Object[] toDataRow(){
        return new Object[]{ten, soluongban, soluotmua, doanhthu};
    }
}
