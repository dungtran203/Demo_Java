/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Services.lmpl;

import DomainModels.NhanVien;
import DomainModels.VaiTro;
import Repositories.INhanVienRepository;
import Repositories.Impl.NhanVienRepository;
import Services.INhanVienService;
import View.GiaoDienDangNhap;
import View.GiaoDienPhanMem;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author anhtu
 */
public class NhanVienService implements INhanVienService {

    private final INhanVienRepository repository;

    public NhanVienService() {
        this.repository = new NhanVienRepository();
    }

    @Override
    public List<NhanVien> getSelectSqlLV() {
        return repository.getSelectSqlLV();
    }

    @Override
    public Integer insert(NhanVien nv, String tenVaiTro) {
        return repository.insert(nv, tenVaiTro);
    }

    @Override
    public Boolean update(NhanVien nv, String tenVaiTro) {
        return repository.update(nv, tenVaiTro);
    }

    @Override
    public Boolean delete(NhanVien nv) {
        return repository.delete(nv);
    }

    @Override
    public List<NhanVien> timSDT(String sdt) {
        return repository.timSDT(sdt);
    }

    @Override
    public List<NhanVien> timVT(String vt) {
        return repository.timVT(vt);
    }

    @Override
    public List<NhanVien> timGT(String giotinh) {
        return repository.timGT(giotinh);
    }

    @Override
    public List<NhanVien> getSelectSqlLV(String maNV) {
        return repository.getSelectSqlLV(maNV);
    }

    //Đăng nhập

    @Override
    public boolean getUser(String tk, String mk) {
        List<NhanVien> listNV = repository.getUser(tk, mk);
        if(tk.isEmpty()){
            JOptionPane.showMessageDialog(new GiaoDienDangNhap(), "Bạn chưa nhập tài khoản !");
            return false;
        }if(mk.isEmpty()){
            JOptionPane.showMessageDialog(new GiaoDienDangNhap(), "Bạn chưa nhập mật khẩu !");
            return false;
        }
        
        if(listNV != null){
            for(NhanVien nv : listNV){
                if(nv.getMaVaiTro().equalsIgnoreCase("Quản lý")){
                    JOptionPane.showMessageDialog(new GiaoDienDangNhap(), "Đăng nhập thành công !", "Quản lý", JOptionPane.PLAIN_MESSAGE);
                    new GiaoDienPhanMem(nv.getTen(), nv.getMa(), nv.getMaVaiTro()).setVisible(true);
                    return true;
                }else{
                    JOptionPane.showMessageDialog(new GiaoDienDangNhap(), "Đăng nhâp thành công !", "Nhân viên", JOptionPane.PLAIN_MESSAGE);
                    new GiaoDienPhanMem(nv.getTen(), nv.getMa(), nv.getMaVaiTro()).setVisible(true);
                    return true;
                }
            }
        }
        JOptionPane.showMessageDialog(new GiaoDienDangNhap(), "Tên tài khoản hoặc mật khẩu không đúng !", "Lỗi đăng nhập", JOptionPane.ERROR_MESSAGE);
        return false;
    }

    @Override
    public String Check(String ma) {
        return repository.Check(ma);
    }
    
}
