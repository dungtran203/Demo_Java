/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Services;

import DomainModels.ManHinh;
import java.util.ArrayList;

/**
 *
 * @author FPTShop
 */
public interface IManHinhService {
    ArrayList<ManHinh> getAll();
    public String add(ManHinh mh);

    public String update(ManHinh mh);

    public String delete(String maMH);
}
