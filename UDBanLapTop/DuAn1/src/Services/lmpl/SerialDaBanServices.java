/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Services.lmpl;

import DomainModels.SerialDaBan;
import Repositories.ISerialDaBanRepository;
import Repositories.Impl.SerialDaBanRepository;
import Services.ISerialDaBanServices;

/**
 *
 * @author Dell Inpriron 5515
 */
public class SerialDaBanServices implements ISerialDaBanServices {

    private final ISerialDaBanRepository daBan;

    public SerialDaBanServices() {
        this.daBan = new SerialDaBanRepository();
    }

    @Override
    public Integer them(SerialDaBan serialDaBan) {
        return daBan.them(serialDaBan);
    }

}
