/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DomainModels;


public class ManHinh {
    private String maMH, tenMH, doPhanGiai, kichThuoc, moTa;

    public ManHinh() {
    }

    public ManHinh(String maMH, String tenMH, String doPhanGiai, String kichThuoc, String moTa) {
        this.maMH = maMH;
        this.tenMH = tenMH;
        this.doPhanGiai = doPhanGiai;
        this.kichThuoc = kichThuoc;
        this.moTa = moTa;
    }

    public String getMaMH() {
        return maMH;
    }

    public void setMaMH(String maMH) {
        this.maMH = maMH;
    }

    public String getTenMH() {
        return tenMH;
    }

    public void setTenMH(String tenMH) {
        this.tenMH = tenMH;
    }

    public String getDoPhanGiai() {
        return doPhanGiai;
    }

    public void setDoPhanGiai(String doPhanGiai) {
        this.doPhanGiai = doPhanGiai;
    }

    public String getKichThuoc() {
        return kichThuoc;
    }

    public void setKichThuoc(String kichThuoc) {
        this.kichThuoc = kichThuoc;
    }

    public String getMoTa() {
        return moTa;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }

    @Override
    public String toString() {
        return  tenMH;
    }
    
}
