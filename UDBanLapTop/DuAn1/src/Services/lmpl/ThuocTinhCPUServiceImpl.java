/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Services.lmpl;

import DomainModels.CPU;
import Repositories.IThuocTinhCPURepository;
import Repositories.Impl.ThuocTinhCPURepository;
import Services.IThuocTinhCPUService;
import java.util.ArrayList;

/**
 *
 * @author Tran Thi My Dung
 */
public class ThuocTinhCPUServiceImpl implements IThuocTinhCPUService{

    private IThuocTinhCPURepository repository = new ThuocTinhCPURepository();
    
    @Override
    public ArrayList<CPU> getAll() {
        return repository.getAll();
    }

    @Override
    public String add(CPU cpu) {
        boolean add = repository.add(cpu);
        if (add) {
            return "Thêm thành công!";
        } else {
            return "Thêm thất bại!";
        }
    }

    @Override
    public String update(CPU cpu, String maCPU) {
        boolean update = repository.update(cpu, maCPU);
        if (update) {
            return "Cập nhập thành công!";
        } else {
            return "Cập nhập thất bại!";
        }
    }

    @Override
    public String delete(String maCPU) {
        boolean delete = repository.delete(maCPU);
        if (delete) {
            return "Xóa thành công!";
        } else {
            return "Xóa thất bại!";
        }
    }
    
}
