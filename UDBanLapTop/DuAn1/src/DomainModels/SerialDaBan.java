/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DomainModels;

/**
 *
 * @author Dell Inpriron 5515
 */
public class SerialDaBan {

    String maSerial;
    String tinhTrang;
    String maHDCT;

    public SerialDaBan() {
    }

    public SerialDaBan(String maSerial, String tinhTrang, String maHDCT) {
        this.maSerial = maSerial;
        this.tinhTrang = tinhTrang;
        this.maHDCT = maHDCT;
    }

    public String getMaSerial() {
        return maSerial;
    }

    public void setMaSerial(String maSerial) {
        this.maSerial = maSerial;
    }

    public String getTinhTrang() {
        return tinhTrang;
    }

    public void setTinhTrang(String tinhTrang) {
        this.tinhTrang = tinhTrang;
    }

    public String getMaHDCT() {
        return maHDCT;
    }

    public void setMaHDCT(String maHDCT) {
        this.maHDCT = maHDCT;
    }

    @Override
    public String toString() {
        return "SerialDaBan{" + "maSerial=" + maSerial + ", tinhTrang=" + tinhTrang + ", maHDCT=" + maHDCT + '}';
    }

}
