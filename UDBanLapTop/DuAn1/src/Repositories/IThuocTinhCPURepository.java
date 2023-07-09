/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Repositories;

import DomainModels.CPU;
import java.util.ArrayList;

/**
 *
 * @author Tran Thi My Dung
 */
public interface IThuocTinhCPURepository {

    ArrayList<CPU> getAll();

    boolean add (CPU cpu);

    boolean update(CPU cpu, String maCPU);

    boolean delete(String maCPU);
    
}
