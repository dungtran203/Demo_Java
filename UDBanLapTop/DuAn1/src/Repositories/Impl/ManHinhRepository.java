/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repositories.Impl;

import DomainModels.ManHinh;
import Repositories.IManHinhRepository;
import Utilities.DbConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author FPTShop
 */
public class ManHinhRepository implements IManHinhRepository {

    @Override
    public ArrayList<ManHinh> getAll() {
        String sql = "select MaManHinh, TenManHinh, DoPhanGiai, KichThuoc, MoTa from dbo.ManHinh";
        try ( Connection con = DbConnection.openDbConnection();  PreparedStatement ps = con.prepareStatement(sql)) {
            ArrayList<ManHinh> listmh = new ArrayList<>();
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                listmh.add(new ManHinh(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5)));
            }
            return listmh;
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return null;
    }

    @Override
    public boolean add(ManHinh mh) {
        String sql = "Insert into ManHinh values (newID(),?,?,?,?)";
        int check = 0;
        try ( Connection con = DbConnection.openDbConnection();  PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setObject(1, mh.getTenMH());
            ps.setObject(2, mh.getDoPhanGiai());
            ps.setObject(3, mh.getKichThuoc());
            ps.setObject(4, mh.getMoTa());
            check = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return check > 0;
    }

    @Override
    public boolean update(ManHinh mh) {
        String sql = "Update ManHinh set TenManHinh=?, DoPhanGiai=?, KichThuoc=?, MoTa=? where MaManHinh=?";
        int check = 0;
        try ( Connection con = DbConnection.openDbConnection();  PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setObject(1, mh.getTenMH());
            ps.setObject(2, mh.getDoPhanGiai());
            ps.setObject(3, mh.getKichThuoc());
            ps.setObject(4, mh.getMoTa());
            ps.setObject(5, mh.getMaMH());
            check = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return check > 0;

    }

    @Override
    public boolean delete(String maMH) {
        String sql = "Delete from ManHinh where MaManHinh = ?";
        int check = 0;
        try ( Connection con = DbConnection.openDbConnection();  PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setObject(1, maMH);
            check = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return check > 0;
    }
}
