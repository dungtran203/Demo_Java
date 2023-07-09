/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Services.lmpl;

import DomainModels.ManHinh;
import Repositories.IManHinhRepository;
import Repositories.Impl.ManHinhRepository;
import Services.IManHinhService;
import java.util.ArrayList;

/**
 *
 * @author FPTShop
 */
public class ManHinhServiceImpl implements IManHinhService {

    private IManHinhRepository repository = new ManHinhRepository();

    @Override
    public ArrayList<ManHinh> getAll() {
        return (ArrayList<ManHinh>) repository.getAll();
    }

    @Override
    public String add(ManHinh mh) {
        boolean add = repository.add(mh);
        if (add) {
            return "Add Thành Công";
        } else {
            return "Ađd Thất Bại";
        }
    }

    @Override
    public String update(ManHinh mh) {
        boolean update = repository.update(mh);
        if (update) {
            return "Update Thành Công";
        } else {
            return "Update Thất Bại";
        }
    }

    @Override
    public String delete(String maMH) {
        boolean delete = repository.delete(maMH);
        if (delete) {
            return "Delete Thành Công";
        } else {
            return "Delete Thất Bại";
        }
    }
}
