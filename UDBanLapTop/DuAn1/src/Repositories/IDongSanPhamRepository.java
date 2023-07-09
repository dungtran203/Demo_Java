/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Repositories;

import DomainModels.DongSP;
import java.util.ArrayList;

/**
 *
 * @author Tran Thi My Dung
 */
public interface IDongSanPhamRepository {
    
    ArrayList<DongSP> getAll();

    boolean add (DongSP dsp);

    boolean update(DongSP dsp, String maDSP);

    boolean delete(String maDSP);
    
}
