/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Services.lmpl;

import Repositories.IThongKeSPViewModelRepository;
import Repositories.Impl.ThongKeSPViewModelRepository;
import Services.IThongKeSPViewModelService;
import ViewModels.ThongKeSPViewModel;
import java.util.List;

/**
 *
 * @author anhtu
 */
public class ThongKeSPViewModelServicelmpl implements IThongKeSPViewModelService{
    private final IThongKeSPViewModelRepository repository;

    public ThongKeSPViewModelServicelmpl() {
        repository = new ThongKeSPViewModelRepository();
    }
    
    
    @Override
    public List<ThongKeSPViewModel> getSelectSql() {
        return repository.getSelectSql();
    }

    @Override
    public List<ThongKeSPViewModel> timNam(String nam) {
        return repository.timNam(nam);
    }

    @Override
    public List<ThongKeSPViewModel> timTen(String ten) {
        return repository.timTen(ten);
    }
    
}
