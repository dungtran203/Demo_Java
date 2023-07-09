/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Repositories;

import ViewModels.HoaDon;
import java.sql.Date;
import java.util.ArrayList;

/**
 *
 * @author Dell Inpriron 5515
 */
public interface IHoaDonRepository {
    Integer them(HoaDon hd);
    
    Integer updateDaTT(String ma);
    
    Integer updateChuaTTDu(String ma);
    
    ArrayList<HoaDon> get();
    
    Integer updateHuy(String ma);
    
    ArrayList<String> trungMa();
    
    Integer updateNgayTT(String ma,HoaDon hd);
    
    Integer updateThanhTien(String ma,HoaDon hd);
}
