/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Services.lmpl;

import Repositories.Impl.ThongKeTQRepository;
import ViewModels.DoanhThu;
import ViewModels.SPBanChay;
import ViewModels.TongHoaDon;
import ViewModels.TongKhachHang;
import java.util.List;
import Repositories.IThongKeTQRepository;
import Services.IThongKeTQService;

/**
 *
 * @author anhtu
 */
public class ThongKeTQBanChayServicrlmpl implements IThongKeTQService{
    private final IThongKeTQRepository repository;

    public ThongKeTQBanChayServicrlmpl() {
        repository = new ThongKeTQRepository();
    }
    
    //Sản phẩm bán chạy
    @Override
    public List<SPBanChay> getSelectSql() {
        return repository.getSelectSql();
    }

    @Override
    public List<SPBanChay> getSelectSqlT(String thang) {
        return repository.getSPBanChayT(thang);
    }

    @Override
    public List<SPBanChay> getSPBanChayN(String nam) {
        return repository.getSPBanChayN(nam);
    }

    //Tổng khách hàng
    @Override
    public List<TongKhachHang> getTKH() {
        try {
            return repository.getTKH();
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public List<TongKhachHang> getTKH_T(String thang) {
        try {
            return repository.getTKH_T(thang);
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public List<TongKhachHang> getTKH_N(String nam) {
        try {
            return repository.getTKH_N(nam);
        } catch (Exception e) {
            return null;
        }
    }

    //Tổng hóa đơn
    @Override
    public List<TongHoaDon> getTHD() {
        try {
            return repository.getTHD();
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public List<TongHoaDon> getTHD_T(String thang) {
        try {
            return repository.getTHD_T(thang);
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public List<TongHoaDon> getTHD_N(String nam) {
        try {
            return repository.getTHD_N(nam);
        } catch (Exception e) {
            return null;
        }
    }

    //Doanh thu
    @Override
    public List<DoanhThu> getDT() {
        return repository.getDT();
    }

    @Override
    public List<DoanhThu> getDT_T(String thang) {
        return repository.getDT_T(thang);
    }

    @Override
    public List<DoanhThu> getDT_N(String nam) {
        return repository.getDT_N(nam);
    }

    
    //Biều đồ
    @Override
    public Double getmonth1() {
        return repository.getmonth1();
    }

    @Override
    public Double getmonth2() {
        return repository.getmonth2();
    }

    @Override
    public Double getmonth3() {
        return repository.getmonth3();
    }

    @Override
    public Double getmonth4() {
        return repository.getmonth4();
    }

    @Override
    public Double getmonth5() {
        return repository.getmonth5();
    }

    @Override
    public Double getmonth6() {
        return repository.getmonth6();
    }

    @Override
    public Double getmonth7() {
        return repository.getmonth7();
    }

    @Override
    public Double getmonth8() {
        return repository.getmonth8();
    }

    @Override
    public Double getmonth9() {
        return repository.getmonth9();
    }

    @Override
    public Double getmonth10() {
        return repository.getmonth10();
    }

    @Override
    public Double getmonth11() {
        return repository.getmonth11();
    }

    @Override
    public Double getmonth12() {
        return repository.getmonth12();
    }
    
}
