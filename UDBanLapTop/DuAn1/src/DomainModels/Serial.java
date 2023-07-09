/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DomainModels;

/**
 *
 * @author Dell Inpriron 5515
 */
public class Serial {

    String maSerial;
    String tinhtrang;
    String maSP;

    public Serial() {
    }

    public Serial(String maSerial, String tinhtrang, String maSP) {
        this.maSerial = maSerial;
        this.tinhtrang = tinhtrang;
        this.maSP = maSP;
    }

    public String getMaSerial() {
        return maSerial;
    }

    public void setMaSerial(String maSerial) {
        this.maSerial = maSerial;
    }

    public String getTinhtrang() {
        return tinhtrang;
    }

    public void setTinhtrang(String tinhtrang) {
        this.tinhtrang = tinhtrang;
    }

    public String getMaSP() {
        return maSP;
    }

    public void setMaSP(String maSP) {
        this.maSP = maSP;
    }

    @Override
    public String toString() {
        return "Serial{" + "maSerial=" + maSerial + ", tinhtrang=" + tinhtrang + ", maSP=" + maSP + '}';
    }

   

   

}
