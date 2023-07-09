/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Services.lmpl;

import DomainModels.RAM;
import Repositories.IThuocTinhRamRepository;
import Repositories.Impl.ThuocTinhRamRepository;
import Services.ITHuocTinhRamService;
import java.util.ArrayList;

/**
 *
 * @author vuxua
 */
public class ThuocTinhRamService implements ITHuocTinhRamService {

    private IThuocTinhRamRepository _repository = new ThuocTinhRamRepository();

    @Override
    public ArrayList<RAM> getAll() {
        return _repository.getAll();
    }

    @Override
    public String add(RAM ram) {
        boolean add = _repository.add(ram);
        if (add) {
            return "Thêm thành công!";
        } else {
            return "Thêm thất bại!";
        }
    }

    @Override
    public String update(RAM ram, String maRam) {
        boolean update = _repository.update(ram, maRam);
        if (update) {
            return "Cập nhập thành công!";
        } else {
            return "Cập nhập thất bại!";
        }
    }

    @Override
    public String delete(String maRam) {
        boolean delete = _repository.delete(maRam);
        if (delete) {
            return "Xóa thành công!";
        } else {
            return "Xóa thất bại!";
        }
    }

}
