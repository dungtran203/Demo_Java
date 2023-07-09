/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Services;

import ViewModels.GioHangViewModel;
import java.util.ArrayList;

/**
 *
 * @author Dell Inpriron 5515
 */
public interface IGioHangServices {

    ArrayList<GioHangViewModel> get(String ma);

    ArrayList<GioHangViewModel> get1(String ma);
}
