/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Services.lmpl;

import DomainModels.KhachHang;
import Repositories.IKhachHangRepository;
import Repositories.Impl.KhachHangRepository;
import Services.IKhachHangService;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author anhtu
 */
public class KhachHangServiceImpl implements IKhachHangService {

    private final IKhachHangRepository repository;

    public KhachHangServiceImpl() {
        this.repository = new KhachHangRepository();
    }

    @Override
    public List<KhachHang> getSelectSql() {
        return repository.getSelectSql();
    }

    @Override
    public Boolean insert(KhachHang kh) {
        return repository.insert(kh);
    }

    @Override
    public Boolean update(KhachHang kh) {
        return repository.update(kh);
    }

    @Override
    public Boolean delete(KhachHang kh) {
        return repository.delete(kh);
    }

    @Override
    public List<KhachHang> timGT(String gt) {
        return repository.timGT(gt);
    }

    @Override
    public List<KhachHang> timDiaChi(String dt) {
        return repository.timDiaChi(dt);
    }

    @Override
    public List<KhachHang> timSDT(String sdt) {
        return repository.timSDT(sdt);
    }

    @Override
    public List<KhachHang> getSelectSql1(String maKH) {
        return repository.getSelectSql1(maKH);
    }

    @Override
    public String Check(String ma) {
        return repository.Check(ma);
    }

}
