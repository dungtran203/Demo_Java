/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repositories.Impl;

import Repositories.IThuocTinhCPURepository;
import Utilities.DbConnection;
import DomainModels.CPU;
import java.util.ArrayList;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.PreparedStatement;

/**
 *
 * @author Tran Thi My Dung
 */
public class ThuocTinhCPURepository implements IThuocTinhCPURepository {

    @Override
    public ArrayList<CPU> getAll() {
        String sql = "SELECT [MaCPU]\n"
                + "      ,[TenCPU]\n"
                + "      ,[MoTa]\n"
                + "  FROM [DuAn1].[dbo].[CPU]";
        try ( Connection con = DbConnection.openDbConnection();  PreparedStatement ps = con.prepareStatement(sql)) {
            ArrayList<CPU> listCPU = new ArrayList<>();
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                listCPU.add(new CPU(rs.getString(1), rs.getString(2), rs.getString(3)));
            }
            return listCPU;
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
        return null;
    }

    @Override
    public boolean add(CPU cpu) {
        String sql = "INSERT INTO [dbo].[CPU]\n"
                + "           ([TenCPU]\n"
                + "           ,[MoTa])\n"
                + "     VALUES (?,?)";
        int check = 0;
        try ( Connection con = DbConnection.openDbConnection();  PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setObject(1, cpu.getTenCPU());
            ps.setObject(2, cpu.getMoTa());
            check = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return check > 0;
    }

    @Override
    public boolean update(CPU cpu, String maCPU) {
        String sql = "UPDATE [dbo].[CPU]\n"
                + "   SET [TenCPU] = ?\n"
                + "      ,[MoTa] = ?\n"
                + " WHERE MaCPU = ?";
        int check = 0;
        try ( Connection con = DbConnection.openDbConnection();  PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setObject(1, cpu.getTenCPU());
            ps.setObject(2, cpu.getMoTa());
            ps.setObject(3, maCPU);
            check = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return check > 0;
    }

    @Override
    public boolean delete(String maCPU) {
        String sql = "DELETE FROM [dbo].[CPU]\n"
                + "      WHERE MaCPU = ?";
        int check = 0;
        try ( Connection con = DbConnection.openDbConnection();  PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setObject(1, maCPU);
            check = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return check > 0;
    }

}
