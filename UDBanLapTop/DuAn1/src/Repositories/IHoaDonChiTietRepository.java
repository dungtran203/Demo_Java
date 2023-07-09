/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Repositories;

import ViewModels.HoaDonChiTiet;
import java.util.ArrayList;

/**
 *
 * @author Dell Inpriron 5515
 */
public interface IHoaDonChiTietRepository {
    
    Integer them(HoaDonChiTiet chiTiet);
    
    Integer upDate(int soLuong,String maHD,String maSP);
    
    Integer xoa( String maHD,String maSP);
    
    Integer xoa( String maHD);
    
    ArrayList<String> getMaSP(String maHD);
    
    ArrayList<String> getMaHDCT(String maHD,String maSP);
    
}
