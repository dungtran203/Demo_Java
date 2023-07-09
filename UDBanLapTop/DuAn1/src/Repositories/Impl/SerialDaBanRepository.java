/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repositories.Impl;

import DomainModels.SerialDaBan;
import Repositories.ISerialDaBanRepository;
import Utilities.DbConnection;

/**
 *
 * @author Dell Inpriron 5515
 */
public class SerialDaBanRepository implements ISerialDaBanRepository {

    @Override
    public Integer them(SerialDaBan serialDaBan) {
        String sql = "Insert into SerialDaBan values(?,?,?)";
        Integer row = DbConnection.excuteUpdate(sql, serialDaBan.getMaSerial(), serialDaBan.getTinhTrang(), serialDaBan.getMaHDCT());
        return row;
    }

}
