/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repositories.Impl;

import DomainModels.VaiTro;
import Repositories.IVaiTroRepository;
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
public class VaiTroRepository implements IVaiTroRepository{

    @Override
    public List<VaiTro> getSelectSql() {
        List<VaiTro> listVT = new ArrayList<>();
        String select = "select MaVaiTro, TenVaiTro from VaiTro";
        try {
            ResultSet rs = DbConnection.getDataFromQuery(select);
            while(rs.next()){
                listVT.add(new VaiTro(rs.getString(1), rs.getNString(2)));
            }
        } catch (SQLException ex) {
            Logger.getLogger(VaiTroRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listVT;
    }
    
}
