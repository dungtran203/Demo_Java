/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repositories.Impl;

import Repositories.IChiTietSPRepository;
import Utilities.DbConnection;
import ViewModels.ChiTietSPViewModel;
import java.util.ArrayList;
import java.util.List;
import java.sql.*;
import java.util.HashSet;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author anhtu
 */
public class ChiTietSPRepository implements IChiTietSPRepository {

    @Override
    public List<ChiTietSPViewModel> getAll() {
        List<ChiTietSPViewModel> list = new ArrayList<>();
        String sql = "select TenSP,GiaBan,GiamGia,MauSac,TenNSX,KichThuoc,TrongLuong,SoLuong from "
                + "ChiTietSP,SanPham,KhuyenMai,NSX,ManHinh\n"
                + "where ChiTietSP.MaSP=SanPham.MaSP\n"
                + "and ChiTietSP.MaKM=KhuyenMai.MaKM\n"
                + "and ChiTietSP.MaNSX=NSX.MaNSX\n"
                + "and ChiTietSP.MaManHinh=ManHinh.MaManHinh";
        try {
            ResultSet rs = DbConnection.getDataFromQuery(sql);
            while (rs.next()) {
                list.add(new ChiTietSPViewModel(rs.getString(1), rs.getDouble(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getDouble(7), rs.getInt(8)));
            }
        } catch (SQLException ex) {
            Logger.getLogger(ChiTietSPRepository.class.getName()).log(Level.SEVERE, null, ex);
        }

        return list;
    }

    @Override
    public List<ChiTietSPViewModel> timKiemSP(String ten) {
        List<ChiTietSPViewModel> list = new ArrayList<>();
        String sql = "select TenSP,GiaBan,GiamGia,MauSac,TenNSX,KichThuoc,TrongLuong,SoLuong from ChiTietSP,SanPham,KhuyenMai,NSX,ManHinh\n"
                + "where ChiTietSP.MaSP=SanPham.MaSP\n"
                + "and ChiTietSP.MaKM=KhuyenMai.MaKM\n"
                + "and ChiTietSP.MaNSX=NSX.MaNSX\n"
                + "and ChiTietSP.MaManHinh=ManHinh.MaManHinh\n"
                + "and TenSP like ?";
        try {
            ResultSet rs = DbConnection.getDataFromQuery(sql, ten);
            while (rs.next()) {
                list.add(new ChiTietSPViewModel(rs.getString(1), rs.getDouble(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getDouble(7), rs.getInt(8)));
            }
        } catch (SQLException ex) {
            Logger.getLogger(ChiTietSPRepository.class.getName()).log(Level.SEVERE, null, ex);
        }

        return list;
    }

    @Override
    public List<ChiTietSPViewModel> locMauSac(String mauSac) {
        List<ChiTietSPViewModel> list = new ArrayList<>();
        String sql = "select TenSP,GiaBan,GiamGia,MauSac,TenNSX,KichThuoc,TrongLuong,SoLuong from ChiTietSP,SanPham,KhuyenMai,NSX,ManHinh\n"
                + "where ChiTietSP.MaSP=SanPham.MaSP\n"
                + "and ChiTietSP.MaKM=KhuyenMai.MaKM\n"
                + "and ChiTietSP.MaNSX=NSX.MaNSX\n"
                + "and ChiTietSP.MaManHinh=ManHinh.MaManHinh\n"
                + "and MauSac=?";
        try {
            ResultSet rs = DbConnection.getDataFromQuery(sql, mauSac);
            while (rs.next()) {
                list.add(new ChiTietSPViewModel(rs.getString(1), rs.getDouble(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getDouble(7), rs.getInt(8)));
            }
        } catch (SQLException ex) {
            Logger.getLogger(ChiTietSPRepository.class.getName()).log(Level.SEVERE, null, ex);
        }

        return list;
    }

    @Override
    public List<ChiTietSPViewModel> getAllID() {
        List<ChiTietSPViewModel> list = new ArrayList<>();
        String sql = "select ChiTietSP.MaSP,TenSP,GiaBan,GiamGia,MauSac,TenNSX,KichThuoc,TrongLuong,SoLuong from ChiTietSP,SanPham,KhuyenMai,NSX,ManHinh\n"
                + "where ChiTietSP.MaSP=SanPham.MaSP\n"
                + "and ChiTietSP.MaKM=KhuyenMai.MaKM\n"
                + "and ChiTietSP.MaNSX=NSX.MaNSX\n"
                + "and ChiTietSP.MaManHinh=ManHinh.MaManHinh";
        try {
            ResultSet rs = DbConnection.getDataFromQuery(sql);
            while (rs.next()) {
                list.add(new ChiTietSPViewModel(rs.getString(1), rs.getString(2), rs.getDouble(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getDouble(8), rs.getInt(9)));
            }
        } catch (SQLException ex) {
            Logger.getLogger(ChiTietSPRepository.class.getName()).log(Level.SEVERE, null, ex);
        }

        return list;
    }

    @Override
    public HashSet<String> getmau() {
        HashSet<String> li = new HashSet<>();
        String sql = "select MauSac from "
                + "SanPham\n";
        try {
            ResultSet rs = DbConnection.getDataFromQuery(sql);
            while (rs.next()) {
                li.add(rs.getString(1));
            }
        } catch (SQLException ex) {
            Logger.getLogger(ChiTietSPRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
        return li;
    }

    @Override
    public Integer upDateSL(String ma) {
        String sql1 = "select MaSP from ChiTietSP where MaSP = ? ";
        String maTam = null;
        try {
            ResultSet rs = DbConnection.getDataFromQuery(sql1, ma);
            while (rs.next()) {
                maTam = rs.getString(1);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ChiTietSPRepository.class.getName()).log(Level.SEVERE, null, ex);
        }

        String sql2 = "update ChiTietSP set SoLuong = ((select SoLuong from ChiTietSP where MaSP=?) - 1) where MaSP=?";
        Integer row = DbConnection.excuteUpdate(sql2, maTam, maTam);
        return row;
    }

    @Override
    public Integer upDateSLKhiAnXoa(String ma, int soLuong) {
        String sql2 = "update ChiTietSP set SoLuong = ((select SoLuong from ChiTietSP where MaSP=?) + ?) where MaSP=?";
        Integer row = DbConnection.excuteUpdate(sql2, ma, soLuong, ma);
        return row;
    }

    @Override
    public Integer upDateSLKhiAnThayDoiSL(String ma, int soLuong, int soLuongTD) {
        String sql2 = "update ChiTietSP set SoLuong = ((select SoLuong from ChiTietSP where MaSP=?) + ? - ? ) where MaSP=?";
        Integer row = DbConnection.excuteUpdate(sql2, ma, soLuong, soLuongTD, ma);
        return row;
    }

    @Override
    public Integer getSoLuong(String maSp) {
        Integer soLuong = null;
        String sql = "select SoLuong from ChiTietSP where MaSP=?";
        try {
            ResultSet rs = DbConnection.getDataFromQuery(sql, maSp);
            while (rs.next()) {
                soLuong = rs.getInt(1);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ChiTietSPRepository.class.getName()).log(Level.SEVERE, null, ex);
        }

        return soLuong;
    }

    @Override
    public List<ChiTietSPViewModel> getAll(String barcode) {
        List<ChiTietSPViewModel> li = new ArrayList<>();
        String sql = "Select ChiTietSP.MaSP,TenSP,GiaBan,GiamGia,SoLuong from ChiTietSP,SanPham,KhuyenMai\n"
                + "where ChiTietSP.MaSP= SanPham.MaSP \n"
                + "and ChiTietSP.MaKM=KhuyenMai.MaKM\n"
                + "and BarCode=?";
        try {
            ResultSet rs = DbConnection.getDataFromQuery(sql, barcode);
            while (rs.next()) {
                li.add(new ChiTietSPViewModel(rs.getString(1), rs.getString(2), rs.getDouble(3), rs.getString(4), rs.getInt(5)));
            }
        } catch (SQLException ex) {
            Logger.getLogger(ChiTietSPRepository.class.getName()).log(Level.SEVERE, null, ex);
        }

        return li;
    }

    @Override
    public Integer upDateSLKhiThemTrongBarcode(String ma, int soLuong) {
        String sql2 = "update ChiTietSP set SoLuong = ((select SoLuong from ChiTietSP where MaSP=?) - ?) where MaSP=?";
        Integer row = DbConnection.excuteUpdate(sql2, ma, soLuong, ma);
        return row;
    }

}
