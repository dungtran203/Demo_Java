/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Services;

import DomainModels.CPU;
import java.util.ArrayList;

/**
 *
 * @author Tran Thi My Dung
 */
public interface IThuocTinhCPUService {

    ArrayList<CPU> getAll();

    String add(CPU cpu);

    String update(CPU cpu, String maCPU);

    String delete(String maCPU);
    
}
