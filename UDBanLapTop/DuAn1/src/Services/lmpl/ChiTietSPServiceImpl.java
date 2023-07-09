/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Services.lmpl;

import Repositories.IChiTietSPRepository;
import Repositories.Impl.ChiTietSPRepository;
import Services.IChiTietSPService;
import ViewModels.ChiTietSPViewModel;
import java.util.HashSet;
import java.util.List;

/**
 *
 * @author anhtu
 */
public class ChiTietSPServiceImpl implements IChiTietSPService {

    private final IChiTietSPRepository chiTietRePo;

    public ChiTietSPServiceImpl() {
        this.chiTietRePo = new ChiTietSPRepository();
    }

    @Override
    public List<ChiTietSPViewModel> getAll() {
        return chiTietRePo.getAll();
    }

    @Override
    public List<ChiTietSPViewModel> timKiemSP(String ten) {
        return chiTietRePo.timKiemSP(ten);
    }

    @Override
    public List<ChiTietSPViewModel> locMauSac(String mauSac) {
        return chiTietRePo.locMauSac(mauSac);
    }

    @Override
    public List<ChiTietSPViewModel> getAllID() {
        return chiTietRePo.getAllID();
    }

    @Override
    public HashSet<String> getmau() {
        return chiTietRePo.getmau();
    }

    @Override
    public Boolean kiemTraLaSo(String s) {

        for (int i = 0; i < s.length(); i++) {
            if (Character.isDigit(s.charAt(i))) {
                return true;
            }
        }
        return false;
    }

    @Override
    public Integer upDateSL(String ma) {
        return chiTietRePo.upDateSL(ma);
    }

    @Override
    public Integer upDateSLKhiAnXoa(String ma, int soLuong) {
        return chiTietRePo.upDateSLKhiAnXoa(ma, soLuong);
    }

    @Override
    public Integer upDateSLKhiAnThayDoiSL(String ma, int soLuong, int soLuongTD) {
        return chiTietRePo.upDateSLKhiAnThayDoiSL(ma, soLuong, soLuongTD);
    }

    @Override
    public Integer getSoLuong(String maSp) {
        return chiTietRePo.getSoLuong(maSp);
    }

    @Override
    public List<ChiTietSPViewModel> getAll(String barcode) {
        return chiTietRePo.getAll(barcode);
    }

    @Override
    public Integer upDateSLKhiThemTrongBarcode(String ma, int soLuong) {
        return chiTietRePo.upDateSLKhiThemTrongBarcode(ma, soLuong);
    }

}
