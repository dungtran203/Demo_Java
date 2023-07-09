/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repositories.Impl;

import Repositories.IHoaDonRepository;
import Utilities.DbConnection;
import ViewModels.HoaDon;
import java.util.ArrayList;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Dell Inpriron 5515
 */
public class HoaDonRepository implements IHoaDonRepository {

    @Override
    public Integer them(HoaDon hd) {
        String sql = "Insert into HoaDon values(?,?,?,?,?,?,?)";
        Integer row = DbConnection.excuteUpdate(sql, hd.getMaHD(), hd.getNgayTao(), hd.getNgayThanhToan(), hd.getTinhTrang(), hd.getMaKH(), hd.getMaNV(), hd.getThanhTien());
        return row;

    }

    @Override
    public ArrayList<HoaDon> get() {
        String sql = "Select MaHD,NgayTao,MaKH,MaNV,TinhTrang from HoaDon Where TinhTrang=N'Chờ Thanh Toán'";
        ArrayList<HoaDon> list = new ArrayList<>();

        try {
            ResultSet rs = DbConnection.getDataFromQuery(sql);
            while (rs.next()) {
                list.add(new HoaDon(rs.getString(1), rs.getDate(2), rs.getString(3), rs.getString(4), rs.getString(5)));
            }
        } catch (SQLException ex) {
            Logger.getLogger(HoaDonRepository.class.getName()).log(Level.SEVERE, null, ex);
        }

        return list;
    }

    @Override
    public Integer updateDaTT(String ma) {
        String sql = " update HoaDon set TinhTrang=N'Đã Thanh Toán' where MaHD=?";
        Integer row = DbConnection.excuteUpdate(sql, ma);
        return row;
    }

    @Override
    public Integer updateHuy(String ma) {
        String sql = " update HoaDon set TinhTrang=N'Huỷ Hoá Đơn' where MaHD=?";
        Integer row = DbConnection.excuteUpdate(sql, ma);
        return row;
    }

    @Override
    public ArrayList<String> trungMa() {
        String sql = "Select MaHD from HoaDon";
        ArrayList<String> li = new ArrayList<>();

        try {
            ResultSet rs = DbConnection.getDataFromQuery(sql);
            while (rs.next()) {
                li.add(rs.getString(1));
            }
        } catch (SQLException ex) {
            Logger.getLogger(HoaDonRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
        return li;
    }

    @Override
    public Integer updateNgayTT(String ma, HoaDon hd) {
        String sql = " Update HoaDon set NgayThanhToan = ? where MaHD=?";
        Integer row = DbConnection.excuteUpdate(sql, hd.getNgayThanhToan(), ma);
        return row;
    }

    @Override
    public Integer updateThanhTien(String ma, HoaDon hd) {

        String sql = "  update HoaDon set ThanhTien =  ? where  MaHD =  ?";
        Integer row = DbConnection.excuteUpdate(sql, hd.getThanhTien(), ma);
        return row;
    }

    @Override
    public Integer updateChuaTTDu(String ma) {
        String sql = " update HoaDon set TinhTrang=N'Chưa Thanh Toán Đủ' where MaHD=?";
        Integer row = DbConnection.excuteUpdate(sql, ma);
        return row;
    }

}
