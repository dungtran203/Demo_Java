/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Services.lmpl;

import Repositories.IHoaDonChiTietRepository;
import Repositories.Impl.HoaDonChiTietRepository;
import Services.IHoaDonChiTietServices;
import Services.IHoaDonServices;
import ViewModels.HoaDonChiTiet;
import java.util.ArrayList;

/**
 *
 * @author Dell Inpriron 5515
 */
public class HoaDonChiTietServices implements IHoaDonChiTietServices {

    private final IHoaDonChiTietRepository hoaDonChiTiet;

    public HoaDonChiTietServices() {
        this.hoaDonChiTiet = new HoaDonChiTietRepository();
    }

    @Override
    public Integer them(HoaDonChiTiet chiTiet) {
        return hoaDonChiTiet.them(chiTiet);
    }

    @Override
    public Integer upDate(int soLuong, String maHD, String maSP) {
        return hoaDonChiTiet.upDate(soLuong, maHD, maSP);
    }

    @Override
    public Integer xoa(String maHD, String maSP) {
        return hoaDonChiTiet.xoa(maHD, maSP);
    }

    @Override
    public ArrayList<String> getMaSP(String maHD) {
        return hoaDonChiTiet.getMaSP(maHD);
    }

    @Override
    public ArrayList<String> getMaHDCT(String maHD, String maSP) {
        return hoaDonChiTiet.getMaHDCT(maHD, maSP);
    }

    @Override
    public Integer xoa(String maHD) {
        return hoaDonChiTiet.xoa(maHD);
    }

}
