/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Services.lmpl;

import DomainModels.KhuyenMai;
import Repositories.IKhuyenMaiRepository;
import Repositories.Impl.KhuyenMaiRepository;
import Services.IKhuyenMaiService;
import ViewModels.SanPhamViewModel;
import java.util.List;

/**
 *
 * @author anhtu
 */
public class KhuyenMaiServicelmpl implements IKhuyenMaiService{
    private final IKhuyenMaiRepository repository;

    public KhuyenMaiServicelmpl() {
        this.repository = new KhuyenMaiRepository();
    }
    
    
    
    @Override
    public List<KhuyenMai> getSelectSql() {
        return repository.getSelectSql();
    }

    @Override
    public Boolean insert(KhuyenMai km) {
        return repository.insert(km);
    }

    @Override
    public Boolean update(KhuyenMai km) {
        return repository.update(km);
    }

    @Override
    public List<SanPhamViewModel> getSelectSP() {
        return repository.getSelectSP();
    }

    @Override
    public Integer updateCTSP(String tenKM, String MaSP) {
        return repository.updateCTSP(tenKM, MaSP);
    }

    @Override
    public Integer updateTrangThai() {
        return repository.updateTrangThai();
    }
    
}
