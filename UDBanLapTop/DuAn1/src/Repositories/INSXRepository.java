/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Repositories;

import DomainModels.NSX;
import java.util.ArrayList;

/**
 *
 * @author ASUS
 */
public interface INSXRepository {

    ArrayList<NSX> getAllnsx();

    public boolean addnsx(NSX nsx);

    public boolean updatensx(NSX nsx);

    public boolean deletensx(String mansx);
}
