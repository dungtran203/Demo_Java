/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Repositories;

import DomainModels.KhuyenMai;
import ViewModels.SanPhamViewModel;
import java.util.List;

/**
 *
 * @author anhtu
 */
public interface IKhuyenMaiRepository {
    List<KhuyenMai> getSelectSql();
    Boolean insert(KhuyenMai km);
    Boolean update(KhuyenMai km);
    List<SanPhamViewModel> getSelectSP();
    Integer updateCTSP(String tenKM, String MaSP);
    
    Integer updateTrangThai();
}
