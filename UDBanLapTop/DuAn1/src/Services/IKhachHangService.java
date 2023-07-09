/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Services;

import DomainModels.KhachHang;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author anhtu
 */
public interface IKhachHangService {

    List<KhachHang> getSelectSql();
    
    List<KhachHang> getSelectSql1(String maKH);

    Boolean insert(KhachHang kh);

    Boolean update(KhachHang kh);

    Boolean delete(KhachHang kh);

    List<KhachHang> timGT(String gt);

    List<KhachHang> timDiaChi(String dt);
    
    List<KhachHang> timSDT(String sdt);

    String Check(String ma);
}
