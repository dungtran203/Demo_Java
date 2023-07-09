/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Repositories;

import DomainModels.SanPham;
import java.util.ArrayList;

/**
 *
 * @author Tran Thi My Dung
 */
public interface ISanPhamRepository {

    ArrayList<SanPham> getAll();

    ArrayList<SanPham> getAll1();

    ArrayList<SanPham> getAll(String mau);

    Integer themSanPham(SanPham sp);

    Integer themChiTiet(SanPham sp);

    Integer upDateSanPham(SanPham sp, String ma);

    Integer upDateCTSanPham(SanPham sp, String ma);

    Integer xoaSanPham( String ma);

    Integer xoaCTSanPham( String ma);
    
    ArrayList<SanPham> getAll2(String ten);
    
    Integer updateTrangThai();

}
