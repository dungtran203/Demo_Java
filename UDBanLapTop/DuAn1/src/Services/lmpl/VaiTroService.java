/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Services.lmpl;

import DomainModels.VaiTro;
import Repositories.IVaiTroRepository;
import Repositories.Impl.VaiTroRepository;
import Services.IVaiTroService;
import java.util.List;

/**
 *
 * @author anhtu
 */
public class VaiTroService implements IVaiTroService{

    private final IVaiTroRepository repository;
    public VaiTroService() {
        this.repository = new VaiTroRepository();
    }
    
    @Override
    public List<VaiTro> getSelectSql() {
        return repository.getSelectSql();
    }
    
}
