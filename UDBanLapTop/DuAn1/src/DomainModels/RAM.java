/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DomainModels;

/**
 *
 * @author vuxua
 */
public class RAM {
    private String maRam;
    private String tenRam;
    private String dungLuong;
    private String moTa;

    public RAM() {
    }

    public RAM(String maRam, String tenRam, String dungLuong, String moTa) {
        this.maRam = maRam;
        this.tenRam = tenRam;
        this.dungLuong = dungLuong;
        this.moTa = moTa;
    }

    public String getMaRam() {
        return maRam;
    }

    public void setMaRam(String maRam) {
        this.maRam = maRam;
    }

    public String getTenRam() {
        return tenRam;
    }

    public void setTenRam(String tenRam) {
        this.tenRam = tenRam;
    }

    public String getDungLuong() {
        return dungLuong;
    }

    public void setDungLuong(String dungLuong) {
        this.dungLuong = dungLuong;
    }

    public String getMoTa() {
        return moTa;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }
    public Object [] toDataRow(){
        return new Object[] {maRam, tenRam,dungLuong, moTa};
    }

    @Override
    public String toString() {
        return  tenRam ;
    }
}
