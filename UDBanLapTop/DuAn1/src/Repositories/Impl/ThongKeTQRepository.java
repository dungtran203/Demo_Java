/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repositories.Impl;

import Utilities.DbConnection;
import ViewModels.DoanhThu;
import ViewModels.SPBanChay;
import ViewModels.TongHoaDon;
import ViewModels.TongKhachHang;
import java.util.ArrayList;
import java.util.List;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import Repositories.IThongKeTQRepository;
import javax.xml.transform.Result;

/**
 *
 * @author anhtu
 */
public class ThongKeTQRepository implements IThongKeTQRepository{
    
    // Sản phẩm bán chạy
    @Override
    public List<SPBanChay> getSelectSql() {
        List<SPBanChay> listSPBC = new ArrayList<>();
        String select = "SELECT TOP 1 SanPham.TenSP FROM HoaDonChiTiet "
                + "JOIN HoaDon ON HoaDon.MaHD = HoaDonChiTiet.MaHD "
                + "JOIN SanPham ON SanPham.MaSP=HoaDonChiTiet.MaSP "
                + "WHERE HoaDon.TinhTrang = N'Đã thanh toán' "
                + "GROUP BY HoaDonChiTiet.MaSP, SanPham.TenSP "
                + "HAVING Sum(SoLuong) >= ALL(SELECT Sum(SoLuong) FROM HoaDonChiTiet "
                + "JOIN HoaDon ON HoaDon.MaHD = HoaDonChiTiet.MaHD "
                + "WHERE HoaDon.TinhTrang = N'Đã thanh toán' "
                + "GROUP BY HoaDonChiTiet.MaSP) ";
        
        try {
            ResultSet rs = DbConnection.getDataFromQuery(select);
            while(rs.next()){
                listSPBC.add(new SPBanChay(rs.getNString(1)));
            }
            return listSPBC;
        } catch (SQLException ex) {
            Logger.getLogger(ThongKeTQRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public List<SPBanChay> getSPBanChayT(String thang) {
        List<SPBanChay> listSPBC = new ArrayList<>();
        String select = "SELECT TOP 1 SanPham.TenSP FROM HoaDonChiTiet "
                + "JOIN HoaDon ON HoaDon.MaHD = HoaDonChiTiet.MaHD "
                + "JOIN SanPham ON SanPham.MaSP=HoaDonChiTiet.MaSP "
                + "WHERE HoaDon.TinhTrang = N'Đã thanh toán' AND Month(HoaDon.NgayTao) = ? "
                + "GROUP BY HoaDonChiTiet.MaSP, SanPham.TenSP "
                + "HAVING Sum(SoLuong) >= ALL(SELECT Sum(SoLuong) FROM HoaDonChiTiet "
                + "JOIN HoaDon ON HoaDon.MaHD = HoaDonChiTiet.MaHD "
                + "WHERE HoaDon.TinhTrang = N'Đã thanh toán' AND Month(HoaDon.NgayTao) = ? "
                + "GROUP BY HoaDonChiTiet.MaSP) " ;
        
        try {
            ResultSet rs = DbConnection.getDataFromQuery(select, thang, thang);
            while(rs.next()){
                listSPBC.add(new SPBanChay(rs.getNString(1)));
            }
            return listSPBC;
        } catch (SQLException ex) {
            Logger.getLogger(ThongKeTQRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public List<SPBanChay> getSPBanChayN(String nam) {
        List<SPBanChay> listSPBC = new ArrayList<>();
        String select = "SELECT TOP 1 SanPham.TenSP FROM HoaDonChiTiet "
                + "JOIN HoaDon ON HoaDon.MaHD = HoaDonChiTiet.MaHD "
                + "JOIN SanPham ON SanPham.MaSP=HoaDonChiTiet.MaSP "
                + "WHERE HoaDon.TinhTrang = N'Đã thanh toán' AND YEAR(HoaDon.NgayTao) = ? "
                + "GROUP BY HoaDonChiTiet.MaSP, SanPham.TenSP "
                + "HAVING Sum(SoLuong) >= ALL(SELECT Sum(SoLuong) FROM HoaDonChiTiet "
                + "JOIN HoaDon ON HoaDon.MaHD = HoaDonChiTiet.MaHD "
                + "WHERE HoaDon.TinhTrang = N'Đã thanh toán' AND YEAR(HoaDon.NgayTao) = ? "
                + "GROUP BY HoaDonChiTiet.MaSP) ";
        
        try {
            ResultSet rs = DbConnection.getDataFromQuery(select, nam, nam);
            while(rs.next()){
                listSPBC.add(new SPBanChay(rs.getNString(1)));
            }
            return listSPBC;
        } catch (SQLException ex) {
            Logger.getLogger(ThongKeTQRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    
    //Tổng khách hàng
    @Override
    public List<TongKhachHang> getTKH() {
        List<TongKhachHang> listTKH = new ArrayList<>();
        String select = "select count(KhachHang.MaKH) from KhachHang "
                + "join HoaDon on HoaDon.MaKH=KhachHang.MaKH "
                + "Where HoaDon.TinhTrang = N'Đã thanh toán' ";
        
        try {
            ResultSet rs = DbConnection.getDataFromQuery(select);
            while(rs.next()){
                listTKH.add(new TongKhachHang(rs.getInt(1)));
            }
            return listTKH;
        } catch (SQLException ex) {
            Logger.getLogger(ThongKeTQRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public List<TongKhachHang> getTKH_T(String thang) {
        List<TongKhachHang> listTKH = new ArrayList<>();
        String select = "select count(KhachHang.MaKH) from KhachHang "
                + "join HoaDon on HoaDon.MaKH=KhachHang.MaKH "
                + "Where MONTH(HoaDon.NgayTao) = ? AND HoaDon.TinhTrang = N'Đã thanh toán' ";
        
        try {
            ResultSet rs = DbConnection.getDataFromQuery(select, thang);
            while(rs.next()){
                listTKH.add(new TongKhachHang(rs.getInt(1)));
            }
            return listTKH;
        } catch (SQLException ex) {
            Logger.getLogger(ThongKeTQRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public List<TongKhachHang> getTKH_N(String nam) {
        List<TongKhachHang> listTKH = new ArrayList<>();
        String select = "select count(KhachHang.MaKH) from KhachHang "
                + "join HoaDon on HoaDon.MaKH=KhachHang.MaKH "
                + "Where YEAR(HoaDon.NgayTao) = ? AND HoaDon.TinhTrang = N'Đã thanh toán' ";
        
        try {
            ResultSet rs = DbConnection.getDataFromQuery(select, nam);
            while(rs.next()){
                listTKH.add(new TongKhachHang(rs.getInt(1)));
            }
            return listTKH;
        } catch (SQLException ex) {
            Logger.getLogger(ThongKeTQRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    //Tổng hóa đơn
    @Override
    public List<TongHoaDon> getTHD() {
        List<TongHoaDon> listTHD = new ArrayList<>();
        String select = "select count(MaHD) from HoaDon "
                + "Where HoaDon.TinhTrang = N'Đã thanh toán' ";
        
        try {
            ResultSet rs = DbConnection.getDataFromQuery(select);
            while(rs.next()){
                listTHD.add(new TongHoaDon(rs.getInt(1)));
            }
            return listTHD;
        } catch (SQLException ex) {
            Logger.getLogger(ThongKeTQRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public List<TongHoaDon> getTHD_T(String thang) {
        List<TongHoaDon> listTHD = new ArrayList<>();
        String select = "Select Count(HoaDon.MaHD) from HoaDon "
                + "where Month(HoaDon.NgayTao) = ? AND HoaDon.TinhTrang = N'Đã thanh toán' ";
        
        try {
            ResultSet rs = DbConnection.getDataFromQuery(select, thang);
            while(rs.next()){
                listTHD.add(new TongHoaDon(rs.getInt(1)));
            }
            return listTHD;
        } catch (SQLException ex) {
            Logger.getLogger(ThongKeTQRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public List<TongHoaDon> getTHD_N(String nam) {
        List<TongHoaDon> listTHD = new ArrayList<>();
        String select = "Select Count(HoaDon.MaHD) from HoaDon "
                + "where YEAR(HoaDon.NgayTao) = ? AND HoaDon.TinhTrang = N'Đã thanh toán' ";
        
        try {
            ResultSet rs = DbConnection.getDataFromQuery(select, nam);
            while(rs.next()){
                listTHD.add(new TongHoaDon(rs.getInt(1)));
            }
            return listTHD;
        } catch (SQLException ex) {
            Logger.getLogger(ThongKeTQRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    //Doanh thu
    @Override
    public List<DoanhThu> getDT() {
        List<DoanhThu> listDT = new ArrayList<>();
        String select = "select Sum(HoaDonChiTiet.DonGia * HoaDonChiTiet.SoLuong)-Sum(HoaDonChiTiet.TienGiamGia* HoaDonChiTiet.SoLuong)  from  HoaDonChiTiet "
                + "join HoaDon on HoaDonChiTiet.MaHD = HoaDon.MaHD "
                + "Where HoaDon.TinhTrang = N'Đã thanh toán'";
        
        try {
            ResultSet rs = DbConnection.getDataFromQuery(select);
            while(rs.next()){
                listDT.add(new DoanhThu(rs.getDouble(1)));
            }
            return listDT;
        } catch (SQLException ex) {
            Logger.getLogger(ThongKeTQRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public List<DoanhThu> getDT_T(String thang) {
        List<DoanhThu> listDT = new ArrayList<>();
        String select = "select Sum(HoaDonChiTiet.DonGia * HoaDonChiTiet.SoLuong)-Sum(HoaDonChiTiet.TienGiamGia* HoaDonChiTiet.SoLuong)  from  HoaDonChiTiet "
                + "join HoaDon on HoaDonChiTiet.MaHD = HoaDon.MaHD "
                + "Where HoaDon.TinhTrang = N'Đã thanh toán' AND MONTH(HoaDon.NgayTao) = ? ";
        
        try {
            ResultSet rs = DbConnection.getDataFromQuery(select, thang);
            while(rs.next()){
                listDT.add(new DoanhThu(rs.getDouble(1)));
            }
            return listDT;
        } catch (SQLException ex) {
            Logger.getLogger(ThongKeTQRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public List<DoanhThu> getDT_N(String nam) {
        List<DoanhThu> listDT = new ArrayList<>();
        String select = "select Sum(HoaDonChiTiet.DonGia * HoaDonChiTiet.SoLuong)-Sum(HoaDonChiTiet.TienGiamGia* HoaDonChiTiet.SoLuong)  from  HoaDonChiTiet "
                + "join HoaDon on HoaDonChiTiet.MaHD = HoaDon.MaHD "
                + "Where HoaDon.TinhTrang = N'Đã thanh toán' AND YEAR(HoaDon.NgayTao) = ? ";
        
        try {
            ResultSet rs = DbConnection.getDataFromQuery(select, nam);
            while(rs.next()){
                listDT.add(new DoanhThu(rs.getDouble(1)));
            }
            return listDT;
        } catch (SQLException ex) {
            Logger.getLogger(ThongKeTQRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public Double getmonth1() {
        double chua = 0;
        String select = "select Sum(HoaDonChiTiet.DonGia * HoaDonChiTiet.SoLuong)-Sum(HoaDonChiTiet.TienGiamGia* HoaDonChiTiet.SoLuong)  from  HoaDonChiTiet "
                + "join HoaDon on HoaDonChiTiet.MaHD = HoaDon.MaHD "
                + "Where HoaDon.TinhTrang = N'Đã thanh toán' AND MONTH(HoaDon.NgayTao) = 1 ";
        try {
            ResultSet rs = DbConnection.getDataFromQuery(select);
            while(rs.next()){
                chua = rs.getDouble(1);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ThongKeTQRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
        return chua;
    }

    @Override
    public Double getmonth2() {
        double chua = 0;
        String select = "select Sum(HoaDonChiTiet.DonGia * HoaDonChiTiet.SoLuong)-Sum(HoaDonChiTiet.TienGiamGia* HoaDonChiTiet.SoLuong)  from  HoaDonChiTiet "
                + "join HoaDon on HoaDonChiTiet.MaHD = HoaDon.MaHD "
                + "Where HoaDon.TinhTrang = N'Đã thanh toán' AND MONTH(HoaDon.NgayTao) = 2 ";
        try {
            ResultSet rs = DbConnection.getDataFromQuery(select);
            while(rs.next()){
                chua = rs.getDouble(1);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ThongKeTQRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
        return chua;
    }

    @Override
    public Double getmonth3() {
        double chua = 0;
        String select = "select Sum(HoaDonChiTiet.DonGia * HoaDonChiTiet.SoLuong)-Sum(HoaDonChiTiet.TienGiamGia* HoaDonChiTiet.SoLuong)  from  HoaDonChiTiet "
                + "join HoaDon on HoaDonChiTiet.MaHD = HoaDon.MaHD "
                + "Where HoaDon.TinhTrang = N'Đã thanh toán' AND MONTH(HoaDon.NgayTao) = 3 ";
        try {
            ResultSet rs = DbConnection.getDataFromQuery(select);
            while(rs.next()){
                chua = rs.getDouble(1);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ThongKeTQRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
        return chua;
    }

    @Override
    public Double getmonth4() {
        double chua = 0;
        String select = "select Sum(HoaDonChiTiet.DonGia * HoaDonChiTiet.SoLuong)-Sum(HoaDonChiTiet.TienGiamGia* HoaDonChiTiet.SoLuong)  from  HoaDonChiTiet "
                + "join HoaDon on HoaDonChiTiet.MaHD = HoaDon.MaHD "
                + "Where HoaDon.TinhTrang = N'Đã thanh toán' AND MONTH(HoaDon.NgayTao) = 4 ";
        try {
            ResultSet rs = DbConnection.getDataFromQuery(select);
            while(rs.next()){
                chua = rs.getDouble(1);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ThongKeTQRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
        return chua;
    }

    @Override
    public Double getmonth5() {
        double chua = 0;
        String select = "select Sum(HoaDonChiTiet.DonGia * HoaDonChiTiet.SoLuong)-Sum(HoaDonChiTiet.TienGiamGia* HoaDonChiTiet.SoLuong)  from  HoaDonChiTiet "
                + "join HoaDon on HoaDonChiTiet.MaHD = HoaDon.MaHD "
                + "Where HoaDon.TinhTrang = N'Đã thanh toán' AND MONTH(HoaDon.NgayTao) = 5 ";
        try {
            ResultSet rs = DbConnection.getDataFromQuery(select);
            while(rs.next()){
                chua = rs.getDouble(1);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ThongKeTQRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
        return chua;
    }

    @Override
    public Double getmonth6() {
        double chua = 0;
        String select = "select Sum(HoaDonChiTiet.DonGia * HoaDonChiTiet.SoLuong)-Sum(HoaDonChiTiet.TienGiamGia* HoaDonChiTiet.SoLuong)  from  HoaDonChiTiet "
                + "join HoaDon on HoaDonChiTiet.MaHD = HoaDon.MaHD "
                + "Where HoaDon.TinhTrang = N'Đã thanh toán' AND MONTH(HoaDon.NgayTao) = 6 ";
        try {
            ResultSet rs = DbConnection.getDataFromQuery(select);
            while(rs.next()){
                chua = rs.getDouble(1);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ThongKeTQRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
        return chua;
    }

    @Override
    public Double getmonth7() {
        double chua = 0;
        String select = "select Sum(HoaDonChiTiet.DonGia * HoaDonChiTiet.SoLuong)-Sum(HoaDonChiTiet.TienGiamGia* HoaDonChiTiet.SoLuong)  from  HoaDonChiTiet "
                + "join HoaDon on HoaDonChiTiet.MaHD = HoaDon.MaHD "
                + "Where HoaDon.TinhTrang = N'Đã thanh toán' AND MONTH(HoaDon.NgayTao) = 7 ";
        try {
            ResultSet rs = DbConnection.getDataFromQuery(select);
            while(rs.next()){
                chua = rs.getDouble(1);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ThongKeTQRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
        return chua;
    }

    @Override
    public Double getmonth8() {
        double chua = 0;
        String select = "select Sum(HoaDonChiTiet.DonGia * HoaDonChiTiet.SoLuong)-Sum(HoaDonChiTiet.TienGiamGia* HoaDonChiTiet.SoLuong)  from  HoaDonChiTiet "
                + "join HoaDon on HoaDonChiTiet.MaHD = HoaDon.MaHD "
                + "Where HoaDon.TinhTrang = N'Đã thanh toán' AND MONTH(HoaDon.NgayTao) = 8 ";
        try {
            ResultSet rs = DbConnection.getDataFromQuery(select);
            while(rs.next()){
                chua = rs.getDouble(1);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ThongKeTQRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
        return chua;
    }

    @Override
    public Double getmonth9() {
        double chua = 0;
        String select = "select Sum(HoaDonChiTiet.DonGia * HoaDonChiTiet.SoLuong)-Sum(HoaDonChiTiet.TienGiamGia* HoaDonChiTiet.SoLuong)  from  HoaDonChiTiet "
                + "join HoaDon on HoaDonChiTiet.MaHD = HoaDon.MaHD "
                + "Where HoaDon.TinhTrang = N'Đã thanh toán' AND MONTH(HoaDon.NgayTao) = 9 ";
        try {
            ResultSet rs = DbConnection.getDataFromQuery(select);
            while(rs.next()){
                chua = rs.getDouble(1);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ThongKeTQRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
        return chua;
    }

    @Override
    public Double getmonth10() {
        double chua = 0;
        String select = "select Sum(HoaDonChiTiet.DonGia * HoaDonChiTiet.SoLuong)-Sum(HoaDonChiTiet.TienGiamGia* HoaDonChiTiet.SoLuong)  from  HoaDonChiTiet "
                + "join HoaDon on HoaDonChiTiet.MaHD = HoaDon.MaHD "
                + "Where HoaDon.TinhTrang = N'Đã thanh toán' AND MONTH(HoaDon.NgayTao) = 10 ";
        try {
            ResultSet rs = DbConnection.getDataFromQuery(select);
            while(rs.next()){
                chua = rs.getDouble(1);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ThongKeTQRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
        return chua;
    }

    @Override
    public Double getmonth11() {
        double chua = 0;
        String select = "select Sum(HoaDonChiTiet.DonGia * HoaDonChiTiet.SoLuong)-Sum(HoaDonChiTiet.TienGiamGia* HoaDonChiTiet.SoLuong)  from  HoaDonChiTiet "
                + "join HoaDon on HoaDonChiTiet.MaHD = HoaDon.MaHD "
                + "Where HoaDon.TinhTrang = N'Đã thanh toán' AND MONTH(HoaDon.NgayTao) = 11 ";
        try {
            ResultSet rs = DbConnection.getDataFromQuery(select);
            while(rs.next()){
                chua = rs.getDouble(1);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ThongKeTQRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
        return chua;
    }

    @Override
    public Double getmonth12() {
        double chua = 0;
        String select = "select Sum(HoaDonChiTiet.DonGia * HoaDonChiTiet.SoLuong)-Sum(HoaDonChiTiet.TienGiamGia* HoaDonChiTiet.SoLuong)  from  HoaDonChiTiet "
                + "join HoaDon on HoaDonChiTiet.MaHD = HoaDon.MaHD "
                + "Where HoaDon.TinhTrang = N'Đã thanh toán' AND MONTH(HoaDon.NgayTao) = 12 ";
        try {
            ResultSet rs = DbConnection.getDataFromQuery(select);
            while(rs.next()){
                chua = rs.getDouble(1);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ThongKeTQRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
        return chua;
    }
    
    
}
