/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DomainModels;

/**
 *
 * @author ASUS
 */
public class NSX {
    private String mansx, tennsx;

    public NSX(String mansx, String tennsx) {
        this.mansx = mansx;
        this.tennsx = tennsx;
    }

    public NSX() {
    }

    public String getMansx() {
        return mansx;
    }

    public void setMansx(String mansx) {
        this.mansx = mansx;
    }

    public String getTennsx() {
        return tennsx;
    }

    public void setTennsx(String tennsx) {
        this.tennsx = tennsx;
    }

    @Override
    public String toString() {
        return  tennsx ;
    }
}
