/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Services.lmpl;

import Repositories.IHoaDonViewModelRepository;
import Repositories.Impl.HoaDonViewModelRepository;
import Services.IHoaDonViewModelService;
import ViewModels.HoaDonCTViewModel;
import ViewModels.HoaDonViewModel;
import java.util.List;

/**
 *
 * @author anhtu
 */
public class HoaDonViewModelServicelmpl implements IHoaDonViewModelService{

    private final IHoaDonViewModelRepository repository;

    public HoaDonViewModelServicelmpl() {
        repository = new HoaDonViewModelRepository();
    }
    
    
    @Override
    public List<HoaDonViewModel> getSelectSql() {
        return repository.getSelectSql();
    }

    @Override
    public List<HoaDonViewModel> getTimTrangThai(String tinhtrang) {
        return repository.getTimTrangThai(tinhtrang);
    }

    @Override
    public List<HoaDonViewModel> getTimTheoThang(String thang, String nam) {
        return repository.getTimTheoThang(thang, nam);
    }

    @Override
    public List<HoaDonCTViewModel> getSelectHDCT(String maHD) {
        return repository.getSelectHDCT(maHD);
    }

    @Override
    public List<HoaDonViewModel> getSelectSql(String maHD) {
        return repository.getSelectSql(maHD);
    }
    
}
