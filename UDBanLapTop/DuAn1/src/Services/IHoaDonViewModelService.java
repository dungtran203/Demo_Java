/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Services;

import ViewModels.HoaDonCTViewModel;
import ViewModels.HoaDonViewModel;
import java.util.List;

/**
 *
 * @author anhtu
 */
public interface IHoaDonViewModelService {
    List<HoaDonViewModel> getSelectSql();
    List<HoaDonViewModel> getTimTrangThai(String tinhtrang);
    List<HoaDonViewModel> getTimTheoThang(String thang, String nam);
    List<HoaDonViewModel> getSelectSql(String maHD);
    
    List<HoaDonCTViewModel> getSelectHDCT(String maHD);
}
