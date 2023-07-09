/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Repositories;

import ViewModels.ThongKeSPViewModel;
import java.util.List;

/**
 *
 * @author anhtu
 */
public interface IThongKeSPViewModelRepository {
    List<ThongKeSPViewModel> getSelectSql();
    List<ThongKeSPViewModel> timNam(String nam);
    List<ThongKeSPViewModel> timTen(String ten);
}
