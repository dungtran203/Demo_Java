/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Services;

import DomainModels.DongSP;
import java.util.ArrayList;

/**
 *
 * @author Tran Thi My Dung
 */
public interface IDongSanPhamService {
    
    ArrayList<DongSP> getAll();

    String add(DongSP dsp);

    String update(DongSP dsp, String maDSP);

    String delete(String maDSP);
    
}
