
package Repositories;

import DomainModels.ManHinh;
import java.util.ArrayList;




public interface IManHinhRepository {
   
    ArrayList<ManHinh> getAll();
    
    public boolean add(ManHinh mh);
    public boolean update(ManHinh mh);
    public boolean delete(String maMH);
}
