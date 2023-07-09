/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repositories.Impl;

import DomainModels.KhachHang;
import Repositories.IKhachHangRepository;
import Utilities.DbConnection;
import java.util.ArrayList;
import java.util.List;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author anhtu
 */
public class KhachHangRepository implements IKhachHangRepository {

    @Override
    public List<KhachHang> getSelectSql() {
        List<KhachHang> listKH = new ArrayList<>();
        String select = "select MaKH, TenKH, SDT, GioiTinh, Email, DiaChi from KhachHang";
        try {
            ResultSet rs = DbConnection.getDataFromQuery(select);
            while (rs.next()) {
                listKH.add(new KhachHang(rs.getString(1), rs.getNString(2), rs.getString(3), rs.getString(4), rs.getNString(5), rs.getNString(6)));
            }
            return listKH;
        } catch (SQLException ex) {
            Logger.getLogger(KhachHangRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public Boolean insert(KhachHang kh) {
        String insert = "insert into khachhang (MaKH, tenkh , sdt , gioitinh , email , diachi ) values (?,?,?,?,?,?) ";

        try {
            PreparedStatement ps = DbConnection.openDbConnection().prepareStatement(insert);
            ps.setObject(1, kh.getMa());
            ps.setObject(2, kh.getTen());
            ps.setObject(3, kh.getSdt());
            ps.setObject(4, kh.getGioitinh());
            ps.setObject(5, kh.getEmail());
            ps.setObject(6, kh.getDiachi());
            ps.executeUpdate();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(KhachHangRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public Boolean update(KhachHang kh) {
        String update = "update khachhang set tenkh = ? , sdt = ? , gioitinh = ? , email = ? , diachi = ? where makh = ?";

        try {
            PreparedStatement ps = DbConnection.openDbConnection().prepareStatement(update);

            ps.setObject(1, kh.getTen());
            ps.setObject(2, kh.getSdt());
            ps.setObject(3, kh.getGioitinh());
            ps.setObject(4, kh.getEmail());
            ps.setObject(5, kh.getDiachi());
            ps.setObject(6, kh.getMa());
            ps.executeUpdate();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(KhachHangRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public Boolean delete(KhachHang kh) {
        String delete = "delete from khachhang where makh = ? ";

        try {
            PreparedStatement ps = DbConnection.openDbConnection().prepareStatement(delete);
            ps.setObject(1, kh.getMa());
            ps.executeUpdate();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(KhachHangRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public List<KhachHang> timGT(String gt) {
        List<KhachHang> listKH = new ArrayList<>();
        String select = "select MaKH, TenKH, SDT, GioiTinh, Email, DiaChi from KhachHang WHERE GioiTinh = ?";
        try {
            ResultSet rs = DbConnection.getDataFromQuery(select, gt);
            while (rs.next()) {
                listKH.add(new KhachHang(rs.getString(1), rs.getNString(2), rs.getString(3), rs.getString(4), rs.getNString(5), rs.getNString(6)));
            }
            return listKH;
        } catch (SQLException ex) {
            Logger.getLogger(KhachHangRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public List<KhachHang> timDiaChi(String dt) {
        List<KhachHang> listKH = new ArrayList<>();
        String select = "select MaKH, TenKH, SDT, GioiTinh, Email, DiaChi from KhachHang WHERE DiaChi like ?";
        try {
            ResultSet rs = DbConnection.getDataFromQuery(select, dt);
            while (rs.next()) {
                listKH.add(new KhachHang(rs.getString(1), rs.getNString(2), rs.getString(3), rs.getString(4), rs.getNString(5), rs.getNString(6)));
            }
            return listKH;
        } catch (SQLException ex) {
            Logger.getLogger(KhachHangRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public List<KhachHang> timSDT(String sdt) {
        List<KhachHang> listKH = new ArrayList<>();
        String select = "select MaKH, TenKH, SDT, GioiTinh, Email, DiaChi from KhachHang WHERE SDT like ?";
        try {
            ResultSet rs = DbConnection.getDataFromQuery(select, sdt);
            while (rs.next()) {
                listKH.add(new KhachHang(rs.getString(1), rs.getNString(2), rs.getString(3), rs.getString(4), rs.getNString(5), rs.getNString(6)));
            }
            return listKH;
        } catch (SQLException ex) {
            Logger.getLogger(KhachHangRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public List<KhachHang> getSelectSql1(String maKH) {
        List<KhachHang> listKH = new ArrayList<>();
        String select = "select MaKH, TenKH, SDT, GioiTinh, Email, DiaChi from KhachHang where MaKH=?";
        try {
            ResultSet rs = DbConnection.getDataFromQuery(select, maKH);
            while (rs.next()) {
                listKH.add(new KhachHang(rs.getString(1), rs.getNString(2), rs.getString(3), rs.getString(4), rs.getNString(5), rs.getNString(6)));
            }
            return listKH;
        } catch (SQLException ex) {
            Logger.getLogger(KhachHangRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    @Override
    public String Check(String ma){
            String box =null;
             String select = "select MaKH  from KhachHang where MaKH = ? ";
        try {
            ResultSet rs = DbConnection.getDataFromQuery(select, ma);
            while(rs.next()){
                box=rs.getString(1);
            }
            return box;
        } catch (SQLException ex) {
            Logger.getLogger(KhachHangRepository.class.getName()).log(Level.SEVERE, null, ex);
            
        }
        return null;
       
    }

}
