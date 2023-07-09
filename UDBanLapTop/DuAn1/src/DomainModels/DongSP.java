/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DomainModels;

/**
 *
 * @author Tran Thi My Dung
 */
public class DongSP {
    private String maDSP;
    private String tenDSP;

    public DongSP() {
    }
    
    public DongSP(String maDSP, String tenDSP) {
        this.maDSP = maDSP;
        this.tenDSP = tenDSP;
    }

    public String getMaDSP() {
        return maDSP;
    }

    public void setMaDSP(String maDSP) {
        this.maDSP = maDSP;
    }

    public String getTenDSP() {
        return tenDSP;
    }

    public void setTenDSP(String tenDSP) {
        this.tenDSP = tenDSP;
    }
    
    public Object [] toDataRow(){
        return new Object[] {maDSP, tenDSP};
    }

    @Override
    public String toString() {
        return tenDSP;
    }
}
