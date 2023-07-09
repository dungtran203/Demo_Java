/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repositories.Impl;

import Repositories.IHoaDonViewModelRepository;
import Utilities.DbConnection;
import ViewModels.HoaDonCTViewModel;
import ViewModels.HoaDonViewModel;
import java.util.ArrayList;
import java.util.List;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author anhtu
 */
public class HoaDonViewModelRepository implements IHoaDonViewModelRepository{

    @Override
    public List<HoaDonViewModel> getSelectSql() {
        List<HoaDonViewModel> listHDV = new ArrayList<>();
        
        String select = "select HoaDonChiTiet.MaHD, Sum(HoaDonChiTiet.DonGia * HoaDonChiTiet.SoLuong), HoaDon.ThanhTien, HoaDon.NgayTao, HoaDon.TinhTrang, "
                + "HoaDon.MaNV, NhanVien.HoTen, HoaDon.MaKH, KhachHang.TenKH, null from HoaDonChiTiet "
                + "join HoaDon on HoaDon.MaHD=HoaDonChiTiet.MaHD "
                + "join NhanVien on NhanVien.MaNV=HoaDon.MaNV "
                + "join KhachHang on KhachHang.MaKH=HoaDon.MaKH "
                + "GROUP BY HoaDon.ThanhTien, HoaDonChiTiet.MaHD, HoaDon.NgayTao, HoaDon.TinhTrang, HoaDon.MaNV, NhanVien.HoTen, HoaDon.MaKH, KhachHang.TenKH";
        
        try {
            ResultSet rs = DbConnection.getDataFromQuery(select);
            while(rs.next()){
                listHDV.add(new HoaDonViewModel(rs.getString(1), rs.getDouble(2), rs.getDouble(3), rs.getString(4), 
                        rs.getNString(5), rs.getString(6), rs.getNString(7), rs.getString(8), rs.getNString(9), rs.getString(10)));
            }
            return listHDV;
        } catch (SQLException ex) {
            Logger.getLogger(HoaDonViewModelRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public List<HoaDonViewModel> getTimTrangThai(String tinhtrang) {
        List<HoaDonViewModel> listHDV = new ArrayList<>();
        
        String select = "select HoaDonChiTiet.MaHD, Sum(HoaDonChiTiet.DonGia * HoaDonChiTiet.SoLuong), HoaDon.ThanhTien, HoaDon.NgayTao, HoaDon.TinhTrang, "
                + "HoaDon.MaNV, NhanVien.HoTen, HoaDon.MaKH, KhachHang.TenKH, null from HoaDonChiTiet "
                + "join HoaDon on HoaDon.MaHD=HoaDonChiTiet.MaHD "
                + "join NhanVien on NhanVien.MaNV=HoaDon.MaNV "
                + "join KhachHang on KhachHang.MaKH=HoaDon.MaKH "
                + "WHERE HoaDon.TinhTrang = ? "
                + "GROUP BY HoaDon.ThanhTien, HoaDonChiTiet.MaHD, HoaDon.NgayTao, HoaDon.TinhTrang, HoaDon.MaNV, NhanVien.HoTen, HoaDon.MaKH, KhachHang.TenKH";

        
        try {
            ResultSet rs = DbConnection.getDataFromQuery(select, tinhtrang);
            while(rs.next()){
                listHDV.add(new HoaDonViewModel(rs.getString(1), rs.getDouble(2), rs.getDouble(3), rs.getString(4), 
                        rs.getNString(5), rs.getString(6), rs.getNString(7), rs.getString(8), rs.getNString(9), rs.getString(10)));
            }
            return listHDV;
        } catch (SQLException ex) {
            Logger.getLogger(HoaDonViewModelRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    @Override
    public List<HoaDonViewModel> getTimTheoThang(String thang, String nam) {
        List<HoaDonViewModel> listHDV = new ArrayList<>();
        
        String select = "select HoaDonChiTiet.MaHD, Sum(HoaDonChiTiet.DonGia * HoaDonChiTiet.SoLuong), HoaDon.ThanhTien, HoaDon.NgayTao, HoaDon.TinhTrang, "
                + "HoaDon.MaNV, NhanVien.HoTen, HoaDon.MaKH, KhachHang.TenKH, null from HoaDonChiTiet "
                + "join HoaDon on HoaDon.MaHD=HoaDonChiTiet.MaHD "
                + "join NhanVien on NhanVien.MaNV=HoaDon.MaNV "
                + "join KhachHang on KhachHang.MaKH=HoaDon.MaKH "
                + "WHERE Month(HoaDon.NgayTao) = ? and Year(HoaDon.NgayTao) = ? "
                + "GROUP BY HoaDon.ThanhTien, HoaDonChiTiet.MaHD, HoaDon.NgayTao, HoaDon.TinhTrang, HoaDon.MaNV, NhanVien.HoTen, HoaDon.MaKH, KhachHang.TenKH";
   
        try {
            ResultSet rs = DbConnection.getDataFromQuery(select, thang, nam);
            while(rs.next()){
                listHDV.add(new HoaDonViewModel(rs.getString(1), rs.getDouble(2), rs.getDouble(3), rs.getString(4), 
                        rs.getNString(5), rs.getString(6), rs.getNString(7), rs.getString(8), rs.getNString(9), rs.getString(10)));
            }
            return listHDV;
        } catch (SQLException ex) {
            Logger.getLogger(HoaDonViewModelRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public List<HoaDonCTViewModel> getSelectHDCT(String maHD) {
        List<HoaDonCTViewModel> listHDCTV = new ArrayList<>();
        String select = "select MaHoaDonCT, HoaDonChiTiet.MaSP, SanPham.TenSP, HoaDonChiTiet.SoLuong, HoaDonChiTiet.DonGia, "
                + "(HoaDonChiTiet.DonGia - HoaDonChiTiet.TienGiamGia) * HoaDonChiTiet.SoLuong from HoaDonChiTiet "
                + "join ChiTietSP on ChiTietSP.MaSP = HoaDonChiTiet.MaSP "
                + "join SanPham on SanPham.MaSP=ChiTietSP.MaSP WHERE MaHD = ?";
        
        try {
            ResultSet rs = DbConnection.getDataFromQuery(select, maHD);
            while(rs.next()){
                listHDCTV.add(new HoaDonCTViewModel(rs.getString(1), rs.getString(2), rs.getNString(3), rs.getInt(4), rs.getDouble(5), rs.getDouble(6)));
            }
            return listHDCTV;
        } catch (SQLException ex) {
            Logger.getLogger(HoaDonViewModelRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public List<HoaDonViewModel> getSelectSql(String maHD) {
        List<HoaDonViewModel> listHDV = new ArrayList<>();
        
        String select = "select HoaDonChiTiet.MaHD, Sum(HoaDonChiTiet.DonGia * HoaDonChiTiet.SoLuong), HoaDon.ThanhTien, HoaDon.NgayTao, HoaDon.TinhTrang, "
                + "HoaDon.MaNV, NhanVien.HoTen, HoaDon.MaKH, KhachHang.TenKH, null from HoaDonChiTiet "
                + "join HoaDon on HoaDon.MaHD=HoaDonChiTiet.MaHD "
                + "join NhanVien on NhanVien.MaNV=HoaDon.MaNV "
                + "join KhachHang on KhachHang.MaKH=HoaDon.MaKH "
                + "WHERE HoaDon.MaHD LIKE ? "
                + "GROUP BY HoaDon.ThanhTien, HoaDonChiTiet.MaHD, HoaDon.NgayTao, HoaDon.TinhTrang, HoaDon.MaNV, NhanVien.HoTen, HoaDon.MaKH, KhachHang.TenKH";
                       
        try {
            ResultSet rs = DbConnection.getDataFromQuery(select, maHD);
            while(rs.next()){
                listHDV.add(new HoaDonViewModel(rs.getString(1), rs.getDouble(2), rs.getDouble(3), rs.getString(4), 
                        rs.getNString(5), rs.getString(6), rs.getNString(7), rs.getString(8), rs.getNString(9), rs.getString(10)));
            }
            return listHDV;
        } catch (SQLException ex) {
            Logger.getLogger(HoaDonViewModelRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    
}
