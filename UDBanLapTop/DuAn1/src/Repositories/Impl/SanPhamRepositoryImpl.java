/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repositories.Impl;

import DomainModels.SanPham;
import Repositories.ISanPhamRepository;
import Utilities.DbConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Tran Thi My Dung
 */
public class SanPhamRepositoryImpl implements ISanPhamRepository {

    @Override
    public ArrayList<SanPham> getAll() {
        ArrayList<SanPham> list = new ArrayList<>();
        String sql = "Select SanPham.MaSP,TenSP,MauSac,HeDieuHanh,TrangThai,GiaNhap,GiaBan,SoLuong "
                + "from SanPham,ChiTietSP where SanPham.MaSP=ChiTietSP.MaSP";
        try {
            ResultSet rs = DbConnection.getDataFromQuery(sql);
            while (rs.next()) {
                list.add(new SanPham(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4),
                        rs.getString(5), rs.getDouble(6), rs.getDouble(7), rs.getInt(8)));
            }
        } catch (SQLException ex) {
            Logger.getLogger(SanPhamRepositoryImpl.class.getName()).log(Level.SEVERE, null, ex);
        }

        return list;
    }

    @Override
    public ArrayList<SanPham> getAll1() {
        ArrayList<SanPham> list = new ArrayList<>();
        String sql = "Select SanPham.MaSP,TenSP,MauSac,HeDieuHanh,NamBH,TrongLuong,XuatXu,TrangThai,SanPham.MoTa,\n"
                + "MaDongSP,MaNSX,MaCPU,MaRAM,MaManHinh,GiaNhap,GiaBan,SoLuong,BarCode from SanPham,ChiTietSP where SanPham.MaSP=ChiTietSP.MaSP";
        try {
            ResultSet rs = DbConnection.getDataFromQuery(sql);
            while (rs.next()) {
                list.add(new SanPham(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4),
                        rs.getInt(5), rs.getFloat(6), rs.getString(7), rs.getString(8), rs.getString(9),
                        rs.getString(10), rs.getString(11), rs.getString(12), rs.getString(13), rs.getString(14),
                        rs.getDouble(15), rs.getDouble(16), rs.getInt(17), rs.getString(18)));
            }
        } catch (SQLException ex) {
            Logger.getLogger(SanPhamRepositoryImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    @Override
    public ArrayList<SanPham> getAll(String mau) {
        String sql = "Select SanPham.MaSP,TenSP,MauSac,HeDieuHanh,TrangThai,GiaNhap,GiaBan,SoLuong "
                + "from SanPham,ChiTietSP where SanPham.MaSP=ChiTietSP.MaSP and MauSac=?";
        ArrayList<SanPham> list = new ArrayList<>();
        try {
            ResultSet rs = DbConnection.getDataFromQuery(sql, mau);
            while (rs.next()) {
                list.add(new SanPham(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4),
                        rs.getString(5), rs.getDouble(6), rs.getDouble(7), rs.getInt(8)));
            }
        } catch (SQLException ex) {
            Logger.getLogger(SanPhamRepositoryImpl.class.getName()).log(Level.SEVERE, null, ex);
        }

        return list;
    }

    @Override
    public Integer themSanPham(SanPham sp) {
        String sql = "insert into SanPham values(?,?,?,?,?,?,?,?,?)";
        Integer row = DbConnection.excuteUpdate(sql, sp.getMaSP(), sp.getTenSP(), sp.getMauSac(), sp.getHeDieuHanh(),
                sp.getNamBH(), sp.getTrongLuong(), sp.getXuatXu(), sp.getTrangThai(), sp.getMoTa());
        return row;
    }

    @Override
    public Integer themChiTiet(SanPham sp) {
        String sql = "insert into ChiTietSP(MaSP,MaDongSP,MaNSX,MaCPU,MaRAM,MaManHinh,GiaNhap,GiaBan,SoLuong,BarCode) values(?,?,?,?,?,?,?,?,?,?)";

//        String sql = "insert into ChiTietSP(MaSP,MaDongSP,MaNSX,MaCPU,MaRAM,MaManHinh,GiaNhap,GiaBan,SoLuong,BarCode) values(?,?,?,?,?,?,?,?,?,?)";
        Integer row = DbConnection.excuteUpdate(sql, sp.getMaSP(), sp.getMaDongSP(), sp.getMaNSX(), sp.getMaCPU(), sp.getMaRAM(),
                sp.getMaManHinh(), sp.getGiaNhap(), sp.getGiaBan(), sp.getSoLuong(), sp.getBarCode());
//        Integer row = DbConnection.excuteUpdate(sql, sp.getMaSP(), sp.getMaDongSP(),sp.getMaNSX(),sp.getMaCPU(), sp.getMaRAM(),sp.getMaManHinh(),sp.getGiaNhap(), sp.getGiaBan(), sp.getSoLuong(), sp.getBarCode());
        return row;
    }

    @Override
    public Integer upDateSanPham(SanPham sp, String ma) {
        String sql = "update SanPham set TenSP=?,MauSac=?,HeDieuHanh=?,NamBH=?,TrongLuong=?,XuatXu=?,TrangThai=?,MoTa=? where MaSP=?";
        Integer row = DbConnection.excuteUpdate(sql, sp.getTenSP(), sp.getMauSac(), sp.getHeDieuHanh(),
                sp.getNamBH(), sp.getTrongLuong(), sp.getXuatXu(), sp.getTrangThai(), sp.getMoTa(), ma);
        return row;
    }

    @Override
    public Integer upDateCTSanPham(SanPham sp, String ma) {
        String sql = "Update ChiTietSP set MaDongSP=?, MaNSX=?,MaCPU=?,MaRAM=?,MaManHinh=?,GiaNhap=?,GiaBan=?,SoLuong=?,BarCode=? where MaSP=?";
        Integer row = DbConnection.excuteUpdate(sql, sp.getMaDongSP(), sp.getMaNSX(), sp.getMaCPU(), sp.getMaRAM(),
                sp.getMaManHinh(), sp.getGiaNhap(), sp.getGiaBan(), sp.getSoLuong(), sp.getBarCode(), ma);
        return row;
    }

    @Override
    public Integer xoaSanPham(String ma) {
        String sql = "delete SanPham where MaSP=?";
        Integer row = DbConnection.excuteUpdate(sql, ma);
        return row;
    }

    @Override
    public Integer xoaCTSanPham(String ma) {
        String sql = "delete ChiTietSP where MaSP=?";
        Integer row = DbConnection.excuteUpdate(sql, ma);
        return row;
    }

    @Override
    public ArrayList<SanPham> getAll2(String ten) {
        String sql = "Select SanPham.MaSP,TenSP,MauSac,HeDieuHanh,TrangThai,GiaNhap,GiaBan,SoLuong "
                + "from SanPham,ChiTietSP where SanPham.MaSP=ChiTietSP.MaSP and TenSP like ?";
        ArrayList<SanPham> list = new ArrayList<>();
        try {
            ResultSet rs = DbConnection.getDataFromQuery(sql, ten);
            while (rs.next()) {
                list.add(new SanPham(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4),
                        rs.getString(5), rs.getDouble(6), rs.getDouble(7), rs.getInt(8)));
            }
        } catch (SQLException ex) {
            Logger.getLogger(SanPhamRepositoryImpl.class.getName()).log(Level.SEVERE, null, ex);
        }

        return list;
    }

    @Override
    public Integer updateTrangThai() {
        String up = "UPDATE SanPham set TrangThai = N'Hết Hàng' WHERE MaSP in (SELECT MaSP from ChiTietSP WHERE SoLuong = 0) ";
        Integer kq = DbConnection.excuteUpdate(up);
        return kq;
    }

}
