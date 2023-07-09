/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Services;

import DomainModels.RAM;
import java.util.ArrayList;

/**
 *
 * @author vuxua
 */
public interface ITHuocTinhRamService {
    ArrayList<RAM> getAll();
    
    String add(RAM ram);
    
    String update(RAM ram , String maRam);
    
    String delete(String maRam);
}
