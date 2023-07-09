/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Services.lmpl;

import DomainModels.NSX;
import Repositories.INSXRepository;
import Repositories.Impl.NSXRepository;
import Services.INSXService;
import java.util.ArrayList;

/**
 *
 * @author ASUS
 */
public class NSXServiceImpl implements INSXService {

    INSXRepository repon = new NSXRepository();

    @Override
    public ArrayList<NSX> getAllnsx() {
        return repon.getAllnsx();
    }

    @Override
    public String add(NSX nsx) {
        boolean add = repon.addnsx(nsx);
        if (add) {
            return "Add Thành Công";
        } else {
            return "Ađd Thất Bại";
        }
    }

    @Override
    public String update(NSX nsx) {
        boolean update = repon.updatensx(nsx);
        if (update) {
            return "Update Thành Công";
        } else {
            return "Update Thất Bại";
        }
    }

    @Override
    public String delete(String mansx) {
        boolean delete = repon.deletensx(mansx);
        if (delete) {
            return "Delete Thành Công";
        } else {
            return "Delete Thất Bại";
        }
    }
}
