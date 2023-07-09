/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repositories.Impl;

import DomainModels.RAM;
import Repositories.IThuocTinhRamRepository;
import Utilities.DbConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author vuxua
 */
public class ThuocTinhRamRepository implements IThuocTinhRamRepository{

    @Override
    public ArrayList<RAM> getAll() {
     String sql = "SELECT [MaRAM]\n"
                + "      ,[TenRAM]\n"
                + "      ,[DUNGLUONG]\n"
                + "      ,[MoTa]\n"
                + "  FROM [DuAn1].[dbo].[RAM]";
        try (Connection con = DbConnection.openDbConnection(); 
                PreparedStatement ps=con.prepareStatement(sql)){
            ArrayList<RAM> listRam= new ArrayList<>();
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                listRam.add(new RAM(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4)));
            }
            return listRam;
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
        return null;}

    @Override
    public boolean add(RAM ram) {
     String sql = "INSERT INTO [dbo].[RAM]\n"
                + "           ([TenRAM]\n"
                + "           ,[DungLuong]\n"
                + "           ,[MoTa])\n"
                + "     VALUES (?,?,?)";
        int check = 0;
        try ( Connection con = DbConnection.openDbConnection();  PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setObject(1, ram.getTenRam());
            ps.setObject(2, ram.getDungLuong());
            ps.setObject(3, ram.getMoTa());
            check = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return check > 0;}

    @Override
    public boolean update(RAM ram, String maRam) {
    String sql = "UPDATE [dbo].[RAM]\n"
                + "   SET [TenCPU] = ?\n"
                + "      ,[DungLuong]=?\n"
                + "      ,[MoTa] = ?\n"
                + " WHERE MARAM = ?";
        int check = 0;
        try ( Connection con = DbConnection.openDbConnection();  PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setObject(1, ram.getTenRam());
            ps.setObject(2, ram.getDungLuong());
            ps.setObject(3, ram.getMoTa());
            ps.setObject(4, maRam);
            check = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return check > 0; }

    @Override
    public boolean delete(String maRam) {
    String sql = "DELETE FROM [dbo].[RAM]\n"
                + "      WHERE MaRAM = ?";
        int check = 0;
        try ( Connection con = DbConnection.openDbConnection();  PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setObject(1, maRam);
            check = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return check > 0;}
    
}
