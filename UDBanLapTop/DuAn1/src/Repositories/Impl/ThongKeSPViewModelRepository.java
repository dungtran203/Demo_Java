/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repositories.Impl;

import Repositories.IThongKeSPViewModelRepository;
import Utilities.DbConnection;
import ViewModels.ThongKeSPViewModel;
import java.util.ArrayList;
import java.util.List;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author anhtu
 */
public class ThongKeSPViewModelRepository implements IThongKeSPViewModelRepository{

    @Override
    public List<ThongKeSPViewModel> getSelectSql() {
        List<ThongKeSPViewModel> listTKSP = new ArrayList<>();
        String select = "Select sanpham.TenSP, SUM(HoaDonChiTiet.SoLuong), COUNT(*), (Sum(HoaDonChiTiet.DonGia * HoaDonChiTiet.SoLuong)-Sum(HoaDonChiTiet.TienGiamGia* HoaDonChiTiet.SoLuong))  from HoaDonChiTiet "
                + "join ChiTietSP on ChiTietSP.MaSP = HoaDonChiTiet.MaSP "
                + "join KhuyenMai on ChiTietSP.MaKM = KhuyenMai.MaKM "
                + "join sanpham on SanPham.MaSP= ChiTietSP.MaSP "
                + "join HoaDon on HoaDon.MaHD = HoaDonChiTiet.MaHD "
                + "WHERE HoaDon.TinhTrang = N'Đã thanh toán' "
                + "GROUP BY SANPHAM.TenSP, ChiTietSP.SoLuong, ChiTietSP.GiaBan ";
        
        try {
            ResultSet rs = DbConnection.getDataFromQuery(select);
            while(rs.next()){
                listTKSP.add(new ThongKeSPViewModel(rs.getNString(1), rs.getInt(2), rs.getInt(3), rs.getDouble(4)));
            }
            return listTKSP;
        } catch (SQLException ex) {
            Logger.getLogger(ThongKeSPViewModelRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public List<ThongKeSPViewModel> timNam(String nam) {
        List<ThongKeSPViewModel> listTKSP = new ArrayList<>();
        String select = "Select sanpham.TenSP, SUM(HoaDonChiTiet.SoLuong), COUNT(*), (Sum(HoaDonChiTiet.DonGia * HoaDonChiTiet.SoLuong)-Sum(HoaDonChiTiet.TienGiamGia* HoaDonChiTiet.SoLuong))  from HoaDonChiTiet "
                + "join ChiTietSP on ChiTietSP.MaSP = HoaDonChiTiet.MaSP "
                + "join KhuyenMai on ChiTietSP.MaKM = KhuyenMai.MaKM "
                + "join sanpham on SanPham.MaSP= ChiTietSP.MaSP "
                + "join HoaDon on HoaDon.MaHD = HoaDonChiTiet.MaHD "
                + "WHERE HoaDon.TinhTrang = N'Đã thanh toán' AND YEAR(HoaDon.NgayTao) = ? "
                + "GROUP BY SANPHAM.TenSP, ChiTietSP.SoLuong, ChiTietSP.GiaBan";
        
        try {
            ResultSet rs = DbConnection.getDataFromQuery(select, nam);
            while(rs.next()){
                listTKSP.add(new ThongKeSPViewModel(rs.getNString(1), rs.getInt(2), rs.getInt(3), rs.getDouble(4)));
            }
            return listTKSP;
        } catch (SQLException ex) {
            Logger.getLogger(ThongKeSPViewModelRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public List<ThongKeSPViewModel> timTen(String ten) {
        List<ThongKeSPViewModel> listTKSP = new ArrayList<>();
        String select = "Select sanpham.TenSP, SUM(HoaDonChiTiet.SoLuong), COUNT(*), (Sum(HoaDonChiTiet.DonGia * HoaDonChiTiet.SoLuong)-Sum(HoaDonChiTiet.TienGiamGia* HoaDonChiTiet.SoLuong))  from HoaDonChiTiet "
                + "join ChiTietSP on ChiTietSP.MaSP = HoaDonChiTiet.MaSP "
                + "join KhuyenMai on ChiTietSP.MaKM = KhuyenMai.MaKM "
                + "join sanpham on SanPham.MaSP= ChiTietSP.MaSP "
                + "join HoaDon on HoaDon.MaHD = HoaDonChiTiet.MaHD "
                + "WHERE HoaDon.TinhTrang = N'Đã thanh toán' AND SanPham.TenSP LIKE ? "
                + "GROUP BY SANPHAM.TenSP, ChiTietSP.SoLuong, ChiTietSP.GiaBan";

        
        try {
            ResultSet rs = DbConnection.getDataFromQuery(select, ten);
            while(rs.next()){
                listTKSP.add(new ThongKeSPViewModel(rs.getNString(1), rs.getInt(2), rs.getInt(3), rs.getDouble(4)));
            }
            return listTKSP;
        } catch (SQLException ex) {
            Logger.getLogger(ThongKeSPViewModelRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
}
