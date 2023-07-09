/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Services.lmpl;

import Services.ISanPhamService;
import DomainModels.SanPham;
import Repositories.ISanPhamRepository;
import Repositories.Impl.SanPhamRepositoryImpl;
import java.util.ArrayList;

/**
 *
 * @author Tran Thi My Dung
 */
public class SanPhamServiceImpl implements ISanPhamService {

    private ISanPhamRepository repository = new SanPhamRepositoryImpl();

    @Override
    public ArrayList<SanPham> getAll() {
        return repository.getAll();
    }

    @Override
    public ArrayList<SanPham> getAll1() {
        return repository.getAll1();
    }

    @Override
    public ArrayList<SanPham> getAll(String mau) {
        return repository.getAll(mau);
    }

    @Override
    public Integer themSanPham(SanPham sp) {
        return repository.themSanPham(sp);
    }

    @Override
    public Integer themChiTiet(SanPham sp) {
        return repository.themChiTiet(sp);
    }

    @Override
    public Integer upDateSanPham(SanPham sp, String ma) {
        return repository.upDateSanPham(sp, ma);
    }

    @Override
    public Integer upDateCTSanPham(SanPham sp, String ma) {
        return repository.upDateCTSanPham(sp, ma);
    }

    @Override
    public Integer xoaSanPham(String ma) {
        return repository.xoaSanPham(ma);
    }

    @Override
    public Integer xoaCTSanPham(String ma) {
        return repository.xoaCTSanPham(ma);
    }

    @Override
    public ArrayList<SanPham> getAll2(String ten) {
        return repository.getAll2(ten);
    }

    @Override
    public Integer updateTrangThai() {
        return repository.updateTrangThai();
    }

}
