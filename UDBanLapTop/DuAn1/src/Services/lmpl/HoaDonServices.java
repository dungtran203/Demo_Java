/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Services.lmpl;

import Repositories.IHoaDonRepository;
import Repositories.Impl.HoaDonRepository;
import Services.IHoaDonServices;
import ViewModels.HoaDon;
import java.sql.Date;
import java.util.ArrayList;

/**
 *
 * @author Dell Inpriron 5515
 */
public class HoaDonServices implements IHoaDonServices {

    private final IHoaDonRepository hoaDon;

    public HoaDonServices() {
        this.hoaDon = new HoaDonRepository();
    }

    @Override
    public Integer them(HoaDon hd) {
        return hoaDon.them(hd);
    }

    @Override
    public ArrayList<HoaDon> get() {
        return hoaDon.get();
    }

    @Override
    public Integer updateDaTT(String ma) {
        return hoaDon.updateDaTT(ma);
    }

    @Override
    public Integer updateHuyTT(String ma) {
        return hoaDon.updateHuy(ma);
    }

    @Override
    public ArrayList<String> trungMa() {
        return hoaDon.trungMa();
    }

    @Override
    public Integer updateNgayTT(String ma, HoaDon hd) {
        return hoaDon.updateNgayTT(ma, hd);
    }

    @Override
    public Integer updateThanhTien(String ma, HoaDon hd) {
        return hoaDon.updateThanhTien(ma, hd);
    }

    @Override
    public Integer updateChuaTTDu(String ma) {
        return hoaDon.updateChuaTTDu(ma);
    }

}
