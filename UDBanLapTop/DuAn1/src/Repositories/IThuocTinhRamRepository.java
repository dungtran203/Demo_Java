/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Repositories;

import DomainModels.RAM;
import java.util.ArrayList;

/**
 *
 * @author vuxua
 */
public interface IThuocTinhRamRepository {
     ArrayList<RAM> getAll();

    boolean add(RAM ram);

    boolean update(RAM ram, String maRam);

    boolean delete(String maRam);
}
