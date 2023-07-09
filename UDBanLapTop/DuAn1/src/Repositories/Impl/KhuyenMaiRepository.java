/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repositories.Impl;

import DomainModels.KhuyenMai;
import Utilities.DbConnection;
import java.util.ArrayList;
import java.util.List;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import Repositories.IKhuyenMaiRepository;
import ViewModels.SanPhamViewModel;
/**
 *
 * @author anhtu
 */
public class KhuyenMaiRepository implements IKhuyenMaiRepository{

    @Override
    public List<KhuyenMai> getSelectSql() {
        List<KhuyenMai> listKM = new ArrayList();
        String select = "select KhuyenMai.MaKM, TenKM, HinhThucGiam, GiamGia, sanpham.TenSP, NgayBatDau, NgayKetThuc, khuyenmai.TrangThai, KhuyenMai.MoTa from khuyenmai "
                + "join ChiTietSP on ChiTietSP.MaKM = KhuyenMai.MaKM "
                + "join sanpham on sanpham.MaSP=ChiTietSP.MaSP";
        try {
            ResultSet rs = DbConnection.getDataFromQuery(select);
            while(rs.next()){
                listKM.add(new KhuyenMai(rs.getString(1), rs.getNString(2), rs.getNString(3), rs.getNString(4), rs.getNString(5), rs.getDate(6), rs.getDate(7), rs.getString(8), rs.getNString(9)));
            }
        } catch (SQLException ex) {
            Logger.getLogger(KhuyenMaiRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listKM;
    }

    @Override
    public Boolean insert(KhuyenMai km) {
        String insertKM = "Insert into KhuyenMai(TenKM, HinhThucGiam, GiamGia, NgayBatDau, NgayKetThuc, TrangThai, MoTa) values (?,?,?,?,?,?,?)";
        try {
            PreparedStatement ps = DbConnection.openDbConnection().prepareStatement(insertKM);
            ps.setObject(1, km.getTen());
            ps.setObject(2, km.getHinhthuc());
            ps.setObject(3, km.getGiamgia());
            ps.setObject(4, km.getNgaybatdau());
            ps.setObject(5, km.getNgayketthuc());
            ps.setObject(6, km.getTrangthai());
            ps.setObject(7, km.getMota());
            ps.executeUpdate();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(KhuyenMaiRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public Boolean update(KhuyenMai km) {
        String updateKM = "UPDATE KhuyenMai SET TenKM=?, HinhThucGiam=?, GiamGia=?, NgayBatDau=?, NgayKetThuc=?, TrangThai=?, MoTa=? WHERE MaKM = ?";
        try {
            PreparedStatement ps = DbConnection.openDbConnection().prepareStatement(updateKM);
            ps.setObject(1, km.getTen());
            ps.setObject(2, km.getHinhthuc());
            ps.setObject(3, km.getGiamgia());
            ps.setObject(4, km.getNgaybatdau());
            ps.setObject(5, km.getNgayketthuc());
            ps.setObject(6, km.getTrangthai());
            ps.setObject(7, km.getMota());
            ps.setObject(8, km.getMa());
            ps.executeUpdate();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(KhuyenMaiRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public List<SanPhamViewModel> getSelectSP() {
        List<SanPhamViewModel> listSPV = new ArrayList<>();
        String select = "SELECT ChiTietSP.MaSP, TenSP From ChiTietSP "
                + "join SanPham on SanPham.MaSP = ChiTietSP.MaSP";
        try {
            ResultSet rs = DbConnection.getDataFromQuery(select);
            while(rs.next()){
                listSPV.add(new SanPhamViewModel(rs.getString(1), rs.getNString(2)));
            }
        } catch (SQLException ex) {
            Logger.getLogger(KhuyenMaiRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listSPV;
    }

    @Override
    public Integer updateCTSP(String tenKm, String MaSP) {
        String selectMa = "SELECT MaKM FROM KhuyenMai Where TenKM = ?";
        String chua = null;
        
        try {
            ResultSet rs = DbConnection.getDataFromQuery(selectMa, tenKm);
            while(rs.next()){
                chua = rs.getString(1);
            }
        } catch (SQLException ex) {
            Logger.getLogger(KhuyenMaiRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        String update = "UPDATE ChiTietSP SET MaKM = ? Where MaSP = ? ";
        Integer kq = DbConnection.excuteUpdate(update, chua, MaSP);
        
        return kq;
    }

    @Override
    public Integer updateTrangThai() {
        String updateTrangThai = "update khuyenmai set trangthai = N'Không áp dụng', GiamGia = '0' WHERE NgayKetThuc < GetDate()";
        Integer rs = DbConnection.excuteUpdate(updateTrangThai);
        return rs;
    }
}
