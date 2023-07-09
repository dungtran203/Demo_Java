/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Services;

import ViewModels.ChiTietSPViewModel;
import java.util.HashSet;
import java.util.List;

/**
 *
 * @author anhtu
 */
public interface IChiTietSPService {

    List<ChiTietSPViewModel> getAll();

    List<ChiTietSPViewModel> timKiemSP(String ten);

    List<ChiTietSPViewModel> locMauSac(String mauSac);

    List<ChiTietSPViewModel> getAllID();

    HashSet<String> getmau();

    Boolean kiemTraLaSo(String s);

    Integer upDateSL(String ma);

    Integer upDateSLKhiAnXoa(String ma, int soLuong);

    Integer upDateSLKhiAnThayDoiSL(String ma, int soLuong, int soLuongTD);

    Integer getSoLuong(String maSp);
    
    List<ChiTietSPViewModel> getAll(String barcode);
    
    Integer upDateSLKhiThemTrongBarcode(String ma, int soLuong);
}
