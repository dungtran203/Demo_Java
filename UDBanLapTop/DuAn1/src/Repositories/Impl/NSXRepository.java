/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repositories.Impl;

import DomainModels.NSX;
import Repositories.INSXRepository;
import Utilities.DbConnection;
import java.util.ArrayList;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author ASUS
 */
public class NSXRepository implements INSXRepository {

    @Override
    public ArrayList<NSX> getAllnsx() {
        String sql = "SELECT MaNSX, TenNSX\n"
                + "FROM   dbo.NSX";
        try ( Connection con = DbConnection.openDbConnection();  PreparedStatement ps = con.prepareStatement(sql)) {
            ArrayList<NSX> listnsx = new ArrayList<>();
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                listnsx.add(new NSX(rs.getString(1), rs.getString(2)));
            }
            return listnsx;
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return null;
    }

    @Override
    public boolean addnsx(NSX nsx) {
        String sql = "insert into NSX values (newid(), ?)";
        int check = 0;
        try (Connection con = DbConnection.openDbConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setObject(1, nsx.getTennsx());
            check = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return check > 0;
    }

    @Override
    public boolean updatensx(NSX nsx) {
        String sql = "update NSX set TenNSX=? where MaNSX=?";
        int check = 0;
        try (Connection con = DbConnection.openDbConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setObject(1, nsx.getTennsx());
            ps.setObject(2, nsx.getMansx());
            check = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return check > 0;
    }

    @Override
    public boolean deletensx(String mansx) {
        String sql = "delete from NSX where MaNSX= ?";
        int check = 0;
        try (Connection con = DbConnection.openDbConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setObject(1, mansx);
            check = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return check > 0;
    }

}
