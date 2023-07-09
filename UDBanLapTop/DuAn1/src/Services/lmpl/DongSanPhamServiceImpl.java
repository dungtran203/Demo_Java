/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Services.lmpl;

import DomainModels.DongSP;
import Repositories.IDongSanPhamRepository;
import Repositories.Impl.DongSanPhamRepositorysImpl;
import Services.IDongSanPhamService;
import java.util.ArrayList;

/**
 *
 * @author Tran Thi My Dung
 */
public class DongSanPhamServiceImpl implements IDongSanPhamService{
    private IDongSanPhamRepository repository = new DongSanPhamRepositorysImpl();

    @Override
    public ArrayList<DongSP> getAll() {
        return repository.getAll();
    }

    @Override
    public String add(DongSP dsp) {
        boolean add = repository.add(dsp);
        if (add) {
            return "Thêm thành công!";
        } else {
            return "Thêm thất bại!";
        }
    }

    @Override
    public String update(DongSP dsp, String maDSP) {
        boolean update = repository.update(dsp, maDSP);
        if (update) {
            return "Cập nhập thành công!";
        } else {
            return "Cập nhập thất bại!";
        }
    }

    @Override
    public String delete(String maDSP) {
        boolean delete = repository.delete(maDSP);
        if (delete) {
            return "Xóa thành công!";
        } else {
            return "Xóa thất bại!";
        }
    }
    
}
