/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Services.lmpl;

import Repositories.IGioHangRepository;
import Repositories.Impl.GioHangRepository;
import Services.IGioHangServices;
import ViewModels.GioHangViewModel;
import java.util.ArrayList;

/**
 *
 * @author Dell Inpriron 5515
 */
public class GioHangServies implements IGioHangServices {

    private final IGioHangRepository gioHang;

    public GioHangServies() {
        this.gioHang = new GioHangRepository();
    }

    @Override
    public ArrayList<GioHangViewModel> get(String ma) {
        return gioHang.get(ma);
    }

    @Override
    public ArrayList<GioHangViewModel> get1(String ma) {
        return gioHang.get1(ma);
    }

}
