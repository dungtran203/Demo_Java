/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repositories.Impl;

import Repositories.IHoaDonChiTietRepository;
import Utilities.DbConnection;
import ViewModels.HoaDonChiTiet;
import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Dell Inpriron 5515
 */
public class HoaDonChiTietRepository implements IHoaDonChiTietRepository {

    @Override
    public Integer them(HoaDonChiTiet chiTiet) {
        String sql = "Insert into HoaDonChiTiet values(NEWID(),?,?,?,?,?)";
        Integer row = DbConnection.excuteUpdate(sql, chiTiet.getMaHD(), chiTiet.getMaSP(),
                chiTiet.getSoLuong(), chiTiet.getDonGia(), chiTiet.getTienGiam());
        return row;
    }

    @Override
    public Integer upDate(int soLuong, String maHD, String maSP) {
        String sql = "update HoaDonChiTiet set SoLuong = ? where MaHD=? and MaSP=?";
        Integer row = DbConnection.excuteUpdate(sql, soLuong, maHD, maSP);
        return row;
    }

    @Override
    public Integer xoa(String maHD, String maSP) {
        String sql = "delete HoaDonChiTiet where MaHD=? and MaSP=?";
        Integer row = DbConnection.excuteUpdate(sql, maHD, maSP);
        return row;
    }

    @Override
    public ArrayList<String> getMaSP(String maHD) {
        String sql = "select MaSP from HoaDonChiTiet where MaHD=?";
        ArrayList<String> li = new ArrayList<>();
        try {
            ResultSet rs = DbConnection.getDataFromQuery(sql, maHD);
            while (rs.next()) {
                li.add(rs.getString(1));
            }
        } catch (SQLException ex) {
            Logger.getLogger(HoaDonChiTietRepository.class.getName()).log(Level.SEVERE, null, ex);
        }

        return li;

    }

    @Override
    public ArrayList<String> getMaHDCT(String maHD, String maSP) {
        String sql = "select MaHoaDonCT from HoaDonChiTiet where MaHD=? and MaSP=?";
        ArrayList<String> li = new ArrayList<>();
        try {
            ResultSet rs = DbConnection.getDataFromQuery(sql, maHD, maSP);
            while (rs.next()) {
                li.add(rs.getString(1));
            }
        } catch (SQLException ex) {
            Logger.getLogger(HoaDonChiTietRepository.class.getName()).log(Level.SEVERE, null, ex);
        }

        return li;
    }

    @Override
    public Integer xoa(String maHD) {
        String sql = "delete HoaDonChiTiet where MaHD=? ";
        Integer row = DbConnection.excuteUpdate(sql, maHD);
        return row;
    }

}
