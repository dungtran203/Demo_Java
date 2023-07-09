/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repositories.Impl;

import DomainModels.NhanVien;
import DomainModels.VaiTro;
import Repositories.INhanVienRepository;
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
public class NhanVienRepository implements INhanVienRepository {

    @Override
    public List<NhanVien> getSelectSqlLV() {
        List<NhanVien> listNV = new ArrayList<>();
        String select = "select MaNV, HoTen, CONVERT (VARCHAR(10), NgaySinh, 103), GioiTinh, DiaChi, SDT, Email, MatKhau, VaiTro.TenVaiTro, TinhTrang from nhanvien "
                + "join VaiTro on VaiTro.MaVaiTro=NhanVien.MaVaiTro";
        try {
            ResultSet rs = DbConnection.getDataFromQuery(select);
            while (rs.next()) {
                listNV.add(new NhanVien(rs.getString(1), rs.getNString(2), rs.getString(3), rs.getString(4), rs.getNString(5),
                        rs.getString(6), rs.getString(7), rs.getString(8), rs.getNString(9), rs.getNString(10)));
            }
        } catch (SQLException ex) {
            Logger.getLogger(NhanVienRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listNV;
    }

    @Override
    public Integer insert(NhanVien nv, String tenVaiTro) {
        String select = "select MaVaiTro from VaiTro Where TenVaiTro = ? ";
        String chua = null;
        try {
            ResultSet rs1 = DbConnection.getDataFromQuery(select, tenVaiTro);
            while (rs1.next()) {
                chua = rs1.getString(1);
            }
        } catch (SQLException ex) {
            Logger.getLogger(NhanVienRepository.class.getName()).log(Level.SEVERE, null, ex);
        }

        String insert = "INSERT INTO NhanVien(MaNV, HoTen, NgaySinh, GioiTinh, DiaChi, SDT, Email, MatKhau, MaVaiTro, TinhTrang) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        Integer kq = DbConnection.excuteUpdate(insert, nv.getMa(), nv.getTen(), nv.getNgaySinh(), nv.getGioiTinh(), nv.getDiaChi(),
                nv.getSdt(), nv.getEmail(), nv.getMatKhau(), chua, nv.getTrangThai());
        return kq;
    }

    @Override
    public Boolean update(NhanVien nv, String tenVaiTro) {
        String select = "select MaVaiTro from VaiTro Where TenVaiTro = ? ";
        String chua = null;
        try {
            ResultSet rs1 = DbConnection.getDataFromQuery(select, tenVaiTro);
            while (rs1.next()) {
                chua = rs1.getString(1);
            }
        } catch (SQLException ex) {
            Logger.getLogger(NhanVienRepository.class.getName()).log(Level.SEVERE, null, ex);
        }

        String update = "UPDATE NhanVien SET HoTen = ? , NgaySinh = ?, GioiTinh = ?, DiaChi = ? , SDT = ?, Email = ?, MatKhau = ?, MaVaiTro = ?, TinhTrang = ? Where MaNV = ?";
        try {
            PreparedStatement ps = DbConnection.openDbConnection().prepareStatement(update);
            ps.setObject(1, nv.getTen());
            ps.setObject(2, nv.getNgaySinh());
            ps.setObject(3, nv.getGioiTinh());
            ps.setObject(4, nv.getDiaChi());
            ps.setObject(5, nv.getSdt());
            ps.setObject(6, nv.getEmail());
            ps.setObject(7, nv.getMatKhau());
            ps.setObject(8, chua);
            ps.setObject(9, nv.getTrangThai());
            ps.setObject(10, nv.getMa());
            ps.executeUpdate();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(NhanVienRepository.class.getName()).log(Level.SEVERE, null, ex);
        }

        return false;
    }

    @Override
    public Boolean delete(NhanVien nv) {
        String delete = "delete from nhanvien where manv = ?";

        try {
            PreparedStatement ps = DbConnection.openDbConnection().prepareStatement(delete);
            ps.setObject(1, nv.getMa());
            ps.executeUpdate();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(NhanVienRepository.class.getName()).log(Level.SEVERE, null, ex);
        }

        return false;
    }

    @Override
    public List<NhanVien> timSDT(String sdt) {
        List<NhanVien> listNV = new ArrayList<>();
        String select = "select MaNV, HoTen, CONVERT (VARCHAR(10), NgaySinh, 103), GioiTinh, DiaChi, SDT, Email, MatKhau, VaiTro.TenVaiTro, TinhTrang from nhanvien "
                + "join VaiTro on VaiTro.MaVaiTro=NhanVien.MaVaiTro Where SDT LIKE ? ";
        try {
            ResultSet rs = DbConnection.getDataFromQuery(select, sdt);
            while (rs.next()) {
                listNV.add(new NhanVien(rs.getString(1), rs.getNString(2), rs.getString(3), rs.getString(4), rs.getNString(5),
                        rs.getString(6), rs.getString(7), rs.getString(8), rs.getNString(9), rs.getNString(10)));
            }
        } catch (SQLException ex) {
            Logger.getLogger(NhanVienRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listNV;
    }

    @Override
    public List<NhanVien> timVT(String vt) {
        String select1 = "select MaVaiTro from VaiTro Where TenVaiTro = ? ";
        String chua = null;
        try {
            ResultSet rs1 = DbConnection.getDataFromQuery(select1, vt);
            while (rs1.next()) {
                chua = rs1.getString(1);
            }
        } catch (SQLException ex) {
            Logger.getLogger(NhanVienRepository.class.getName()).log(Level.SEVERE, null, ex);
        }

        List<NhanVien> listNV = new ArrayList<>();
        String select = "select MaNV, HoTen, CONVERT (VARCHAR(10), NgaySinh, 103), GioiTinh, DiaChi, SDT, Email, MatKhau, VaiTro.TenVaiTro, TinhTrang from nhanvien "
                + "join VaiTro on VaiTro.MaVaiTro=NhanVien.MaVaiTro Where NhanVien.MaVaiTro = ?";
        try {
            ResultSet rs = DbConnection.getDataFromQuery(select, chua);
            while (rs.next()) {
                listNV.add(new NhanVien(rs.getString(1), rs.getNString(2), rs.getString(3), rs.getString(4), rs.getNString(5),
                        rs.getString(6), rs.getString(7), rs.getString(8), rs.getNString(9), rs.getNString(10)));
            }
        } catch (SQLException ex) {
            Logger.getLogger(NhanVienRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listNV;
    }

    @Override
    public List<NhanVien> timGT(String giotinh) {
        List<NhanVien> listNV = new ArrayList<>();
        String select = "select MaNV, HoTen, CONVERT (VARCHAR(10), NgaySinh, 103), GioiTinh, DiaChi, SDT, Email, MatKhau, VaiTro.TenVaiTro, TinhTrang from nhanvien "
                + "join VaiTro on VaiTro.MaVaiTro=NhanVien.MaVaiTro Where GioiTinh = ?";
        try {
            ResultSet rs = DbConnection.getDataFromQuery(select, giotinh);
            while (rs.next()) {
                listNV.add(new NhanVien(rs.getString(1), rs.getNString(2), rs.getString(3), rs.getString(4), rs.getNString(5),
                        rs.getString(6), rs.getString(7), rs.getString(8), rs.getNString(9), rs.getNString(10)));
            }
        } catch (SQLException ex) {
            Logger.getLogger(NhanVienRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listNV;
    }

    @Override
    public List<NhanVien> getSelectSqlLV(String maNV) {
        List<NhanVien> listNV = new ArrayList<>();
        String select = "select MaNV, HoTen, CONVERT (VARCHAR(10), NgaySinh, 103), GioiTinh, DiaChi, SDT, Email, MatKhau, VaiTro.TenVaiTro, TinhTrang from nhanvien "
                + "join VaiTro on VaiTro.MaVaiTro=NhanVien.MaVaiTro and MaNV=? ";
        try {
            ResultSet rs = DbConnection.getDataFromQuery(select,maNV);
            while (rs.next()) {
                listNV.add(new NhanVien(rs.getString(1), rs.getNString(2), rs.getString(3), rs.getString(4), rs.getNString(5),
                        rs.getString(6), rs.getString(7), rs.getString(8), rs.getNString(9), rs.getNString(10)));
            }
        } catch (SQLException ex) {
            Logger.getLogger(NhanVienRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listNV;
    }

    
    //Đang nhập
    @Override
    public List<NhanVien> getUser(String tk, String mk) {
        List<NhanVien> listNV = new ArrayList<>();
        
        String select = "Select NhanVien.Email, NhanVien.HoTen, VaiTro.TenVaiTro from NhanVien "
                + "join VaiTro on VaiTro.MaVaiTro=NhanVien.MaVaiTro "
                + "WHERE Email = ? AND MatKhau = ?";
        
        try {
            ResultSet rs = DbConnection.getDataFromQuery(select, tk, mk);
            while(rs.next()){
                listNV.add(new NhanVien(rs.getString(1), rs.getNString(2), rs.getNString(3)));
            }
            return listNV;
        } catch (SQLException ex) {
            Logger.getLogger(NhanVienRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    @Override
    public String Check(String ma){
            String box =null;
             String select = "select MaNV  from nhanvien where MaNV = ? ";
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
