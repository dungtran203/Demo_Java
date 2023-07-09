/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DomainModels;

/**
 *
 * @author Tran Thi My Dung
 */
public class CPU {
    private String maCPU;
    private String tenCPU;
    private String moTa;

    public CPU() {
    }

    public CPU(String maCPU, String tenCPU, String moTa) {
        this.maCPU = maCPU;
        this.tenCPU = tenCPU;
        this.moTa = moTa;
    }

    public String getMaCPU() {
        return maCPU;
    }

    public void setMaCPU(String maCPU) {
        this.maCPU = maCPU;
    }

    public String getTenCPU() {
        return tenCPU;
    }

    public void setTenCPU(String tenCPU) {
        this.tenCPU = tenCPU;
    }

    public String getMoTa() {
        return moTa;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }
    
    public Object [] toDataRow(){
        return new Object[] {maCPU, tenCPU, moTa};
    }

    @Override
    public String toString() {
        return  tenCPU ;
    }

    
    
    
}
