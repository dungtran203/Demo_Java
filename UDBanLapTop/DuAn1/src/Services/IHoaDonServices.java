/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Services;

import ViewModels.HoaDon;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Dell Inpriron 5515
 */
public interface IHoaDonServices {

    Integer them(HoaDon hd);

    ArrayList<HoaDon> get();

    Integer updateDaTT(String ma);

    Integer updateHuyTT(String ma);

    ArrayList<String> trungMa();

    Integer updateNgayTT(String ma, HoaDon hd);

    Integer updateThanhTien(String ma, HoaDon hd);
    
    Integer updateChuaTTDu(String ma);

}
