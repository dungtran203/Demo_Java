/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Services;

import DomainModels.NSX;
import java.util.ArrayList;

/**
 *
 * @author ASUS
 */
public interface INSXService {

    ArrayList<NSX> getAllnsx();

    public String add(NSX nsx);

    public String update(NSX nsx);

    public String delete(String mansx);
}
