/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repositories.Impl;

import DomainModels.DongSP;
import Repositories.IDongSanPhamRepository;
import Utilities.DbConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Tran Thi My Dung
 */
public class DongSanPhamRepositorysImpl implements IDongSanPhamRepository {

    @Override
    public ArrayList<DongSP> getAll() {
        String sql = "SELECT [MaDongSP]\n"
                + "      ,[TenDongSP]\n"
                + "  FROM [dbo].[DongSP]";
        try ( Connection con = DbConnection.openDbConnection();  PreparedStatement ps = con.prepareStatement(sql)) {
            ArrayList<DongSP> listDSP = new ArrayList<>();
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                listDSP.add(new DongSP(rs.getString(1), rs.getString(2)));
            }
            return listDSP;
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
        return null;
    }

    @Override
    public boolean add(DongSP dsp) {
        String sql = "INSERT INTO [dbo].[DongSP]\n"
                + "           ([TenDongSP])\n"
                + "     VALUES (?)";
        int check = 0;
        try ( Connection con = DbConnection.openDbConnection();  PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setObject(1, dsp.getTenDSP());
            check = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return check > 0;
    }

    @Override
    public boolean update(DongSP dsp, String maDSP) {
        String sql = "UPDATE [dbo].[DongSP]\n"
                + "   SET [TenDongSP] = ?\n"
                + " WHERE MaDongSP = ?";
        int check = 0;
        try ( Connection con = DbConnection.openDbConnection();  PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setObject(1, dsp.getTenDSP());
            ps.setObject(2, maDSP);
            check = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return check > 0;
    }

    @Override
    public boolean delete(String maDSP) {
        String sql = "DELETE FROM [dbo].[DongSP]\n"
                + "      WHERE MaDongSP = ?";
        int check = 0;
        try ( Connection con = DbConnection.openDbConnection();  PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setObject(1, maDSP);
            check = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return check > 0;
    }

}
