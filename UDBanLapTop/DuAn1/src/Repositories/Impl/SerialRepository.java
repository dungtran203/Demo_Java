/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repositories.Impl;

import DomainModels.Serial;
import Repositories.ISerialRepository;
import Utilities.DbConnection;
import java.util.ArrayList;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Dell Inpriron 5515
 */
public class SerialRepository implements ISerialRepository {

    @Override
    public Integer them(Serial serial) {
        String sql = "Insert into Serial values(NEWID(),N'Còn Hàng',?)";
        Integer row = DbConnection.excuteUpdate(sql, serial.getMaSP());
        return row;

    }

    @Override
    public Integer xoa(String maSP) {
        String sql = "DELETE Serial WHERE MaSP=?";
        Integer row = DbConnection.excuteUpdate(sql, maSP);
        return row;
    }

    @Override
    public Integer xoaKhiUpdate(String maSP) {
        String sql = "DELETE Serial WHERE MaSerial in (select top 1 MaSerial from Serial where MaSP = ? and TinhTrang = N'Còn Hàng')";
        Integer row = DbConnection.excuteUpdate(sql, maSP);
        return row;
    }

    @Override
    public ArrayList<String> getMa(String maSP) {
        ArrayList<String> li = new ArrayList<>();
        String sql = "select top 1 MaSerial from Serial where MaSP=? and TinhTrang =N'Còn Hàng'";
        try {
            ResultSet rs = DbConnection.getDataFromQuery(sql, maSP);
            while (rs.next()) {
                li.add(rs.getString(1));
            }
        } catch (SQLException ex) {
            Logger.getLogger(SerialRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
        return li;
    }

    @Override
    public Integer xoaKhiDaBan(String maSerial) {
        String sql = "DELETE Serial WHERE MaSerial=?";
        Integer row = DbConnection.excuteUpdate(sql, maSerial);
        return row;
    }

}
