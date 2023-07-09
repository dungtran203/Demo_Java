/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package View;

import DomainModels.KhachHang;
import DomainModels.NhanVien;
import DomainModels.SerialDaBan;
import Repositories.IHoaDonChiTietRepository;
import Services.IChiTietSPService;
import Services.IGioHangServices;
import Services.IHoaDonChiTietServices;
import Services.IHoaDonServices;
import Services.IKhachHangService;
import Services.INhanVienService;
import Services.ISerialDaBanServices;
import Services.ISerialServices;
import Services.lmpl.ChiTietSPServiceImpl;
import Services.lmpl.GioHangServies;
import Services.lmpl.HoaDonChiTietServices;
import Services.lmpl.HoaDonServices;
import Services.lmpl.KhachHangServiceImpl;
import Services.lmpl.NhanVienService;
import Services.lmpl.SerialDaBanServices;
import Services.lmpl.SerialServices;
import ViewModels.ChiTietSPViewModel;
import ViewModels.GioHangViewModel;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import ViewModels.HoaDon;
import ViewModels.HoaDonChiTiet;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;
import java.util.Random;
import javax.swing.JTextField;
import org.apache.poi.xwpf.usermodel.ParagraphAlignment;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import org.apache.poi.xwpf.usermodel.XWPFTable;
import org.apache.poi.xwpf.usermodel.XWPFTableRow;

/**
 *
 * @author anhtu
 */
public class FormBanHang extends javax.swing.JPanel {

    /**
     * Creates new form FormBanHang
     */
    private final IChiTietSPService chiTietSPService;
    private final IHoaDonServices donServices;
    private final IHoaDonChiTietServices donChiTietServices;
    private final IGioHangServices gioHang;
    private final INhanVienService iNhanVienService;
    private final IKhachHangService khachHangService;
    private final ISerialDaBanServices serialDaBanServices;
    private final ISerialServices serialServices;
    public DefaultComboBoxModel boxModelMauSac;
    public DefaultComboBoxModel boxModelNV;
    DefaultTableModel defaultTableModel;
    DefaultTableModel defaultTableModel1;
    DefaultTableModel tableHoaDon;
    static List<GioHangViewModel> luuTam = new ArrayList<>();
    List<GioHangViewModel> luuTam2 = new ArrayList<>();
    static Object[] getKH = null;
    static Object[] getGH = null;
    static boolean check = false;
    static boolean checkQuetMa = false;

    private String MaNV;
    private String TenNV;

    public FormBanHang(String maNhanVien, String tenNhanVien) {
        initComponents();
        chiTietSPService = new ChiTietSPServiceImpl();
        donServices = new HoaDonServices();
        donChiTietServices = new HoaDonChiTietServices();
        gioHang = new GioHangServies();
        iNhanVienService = new NhanVienService();
        khachHangService = new KhachHangServiceImpl();
        serialDaBanServices = new SerialDaBanServices();
        serialServices = new SerialServices();
        loadData();
        addCBChucVu();
        addCBNhanVien(iNhanVienService.getSelectSqlLV());
        boxModelMauSac = (DefaultComboBoxModel) cb_mau.getModel();
        loadHoaDon();

        MaNV = maNhanVien;
        TenNV = tenNhanVien;

    }

    void addCBNhanVien(List<NhanVien> listNV) {
        boxModelNV = (DefaultComboBoxModel) cb_NhanVien.getModel();
        boxModelNV.removeAllElements();
        for (NhanVien nhanVien : listNV) {
            boxModelNV.addElement(nhanVien.getMa());
        }
    }

    void addCBChucVu() {// load màu lên cbox
        boxModelMauSac = (DefaultComboBoxModel) cb_mau.getModel();
//        List<ChiTietSPViewModel> list = chiTietSPService.getAll();
        HashSet<String> li = chiTietSPService.getmau();

        for (String string : li) {
            boxModelMauSac.addElement(string);
        }

    }

    void loadData() {// load lên bảng sản phẩm
        defaultTableModel1 = (DefaultTableModel) tbl_bangSanPham.getModel();
        List<ChiTietSPViewModel> list = chiTietSPService.getAll();
        for (ChiTietSPViewModel chiTietSPViewModel : list) {

            defaultTableModel1.addRow(new Object[]{chiTietSPViewModel.getTenSP(), chiTietSPViewModel.getDonGia(), chiTietSPViewModel.getGiamGia(),
                chiTietSPViewModel.getMauSac(), chiTietSPViewModel.getTenNSX(),
                chiTietSPViewModel.getKichThuoc(), chiTietSPViewModel.getTrongLuong(), chiTietSPViewModel.getSoLuongTon()});

        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane3 = new javax.swing.JScrollPane();
        jTable3 = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_hoadon = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbl_gioHang = new javax.swing.JTable();
        btn_xoa = new javax.swing.JButton();
        btn_xoaTat = new javax.swing.JButton();
        btn_themSL = new javax.swing.JButton();
        btn_themSL1 = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        tbl_bangSanPham = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        txt_tenSP = new javax.swing.JTextField();
        cb_mau = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        cb_NhanVien = new javax.swing.JComboBox<>();
        txt_maKH = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        btn_taoHoaDon = new javax.swing.JButton();
        lbl_tongThanhTien = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        lbl_giamGia = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        lbl_thanhToan = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        txt_tienKhachDua = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        lbl_TienThua = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        btn_huy = new javax.swing.JButton();
        btn_lamMoi = new javax.swing.JButton();
        btn_ThanhToan = new javax.swing.JButton();
        txt_maHoaDon1 = new javax.swing.JTextField();
        lbl_tienkhachdua = new javax.swing.JLabel();

        jTable3.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane3.setViewportView(jTable3);

        setBackground(new java.awt.Color(255, 255, 255));
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                formMouseEntered(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Hóa đơn chờ", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 14))); // NOI18N

        tbl_hoadon.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã Hoá Đơn", "Ngày Tạo", "Mã Khách Hàng", "Mã Nhân Viên", "Tình Trạng"
            }
        ));
        tbl_hoadon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_hoadonMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbl_hoadon);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 138, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Giỏ hàng", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 14))); // NOI18N

        tbl_gioHang.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Tên Sản Phẩm", "Số Lượng", "Đơn Giá", "Giảm Giá", "Thành Tiền"
            }
        ));
        jScrollPane2.setViewportView(tbl_gioHang);

        btn_xoa.setBackground(new java.awt.Color(153, 255, 204));
        btn_xoa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/close.png"))); // NOI18N
        btn_xoa.setText("Xóa");
        btn_xoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_xoaActionPerformed(evt);
            }
        });

        btn_xoaTat.setBackground(new java.awt.Color(153, 255, 204));
        btn_xoaTat.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/close.png"))); // NOI18N
        btn_xoaTat.setText("Xóa tất cả");
        btn_xoaTat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_xoaTatActionPerformed(evt);
            }
        });

        btn_themSL.setBackground(new java.awt.Color(153, 255, 204));
        btn_themSL.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/add.png"))); // NOI18N
        btn_themSL.setText("Thay Đổi SL");
        btn_themSL.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_themSLActionPerformed(evt);
            }
        });

        btn_themSL1.setBackground(new java.awt.Color(153, 255, 204));
        btn_themSL1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/qr (1).png"))); // NOI18N
        btn_themSL1.setText("Quét QR");
        btn_themSL1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_themSL1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 550, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btn_themSL, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btn_xoaTat, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btn_xoa, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btn_themSL1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btn_xoa)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btn_xoaTat)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btn_themSL)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btn_themSL1)
                .addGap(0, 24, Short.MAX_VALUE))
        );

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Sản phẩm", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 14))); // NOI18N

        tbl_bangSanPham.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Tên Sản Phẩm", "Đơn Giá", "Giảm Giá", "Màu Sắc", "NSX", "Kích Thước", "Trọng Lượng", "Số Lượng"
            }
        ));
        tbl_bangSanPham.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                tbl_bangSanPhamFocusGained(evt);
            }
        });
        tbl_bangSanPham.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_bangSanPhamMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(tbl_bangSanPham);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel1.setText("Tìm kiếm sản phẩm:");

        txt_tenSP.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txt_tenSPFocusGained(evt);
            }
        });
        txt_tenSP.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_tenSPKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_tenSPKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_tenSPKeyTyped(evt);
            }
        });

        cb_mau.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "All" }));
        cb_mau.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cb_mauActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel5.setText("Lọc màu sắc:");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane4)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(txt_tenSP, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 253, Short.MAX_VALUE)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(cb_mau, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(15, 15, 15)))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_tenSP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cb_mau, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27))
        );

        jPanel7.setBackground(new java.awt.Color(255, 255, 255));
        jPanel7.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Hóa đơn", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 14))); // NOI18N

        jPanel8.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel6.setText("Mã khách hàng");

        jLabel8.setText("Mã Nhân Viên");

        txt_maKH.setEditable(false);

        jButton1.setBackground(new java.awt.Color(153, 255, 204));
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/tap.png"))); // NOI18N
        jButton1.setText("Chọn Khách Hàng");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cb_NhanVien, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txt_maKH, javax.swing.GroupLayout.DEFAULT_SIZE, 175, Short.MAX_VALUE))))
                .addContainerGap(23, Short.MAX_VALUE))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(9, 9, 9)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txt_maKH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 10, Short.MAX_VALUE)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(cb_NhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jLabel2.setText("Mã hóa đơn:");

        jLabel3.setText("Tổng tiền:");

        jLabel4.setText("Giảm giá:");

        jLabel10.setText("Thanh toán:");

        jLabel11.setText("Tiền khách đưa:");

        jLabel12.setText("Tiền thừa trả khách:");

        btn_taoHoaDon.setBackground(new java.awt.Color(153, 255, 204));
        btn_taoHoaDon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/floppy-disk.png"))); // NOI18N
        btn_taoHoaDon.setText("Tạo");
        btn_taoHoaDon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_taoHoaDonActionPerformed(evt);
            }
        });

        lbl_tongThanhTien.setForeground(new java.awt.Color(255, 0, 0));
        lbl_tongThanhTien.setText("0");

        jLabel15.setText("VNĐ");

        lbl_giamGia.setForeground(new java.awt.Color(255, 0, 0));
        lbl_giamGia.setText("0");

        jLabel17.setText("VNĐ");

        lbl_thanhToan.setForeground(new java.awt.Color(255, 0, 0));
        lbl_thanhToan.setText("0");

        jLabel19.setText("VNĐ");

        txt_tienKhachDua.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        txt_tienKhachDua.setForeground(new java.awt.Color(102, 0, 255));
        txt_tienKhachDua.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_tienKhachDuaKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_tienKhachDuaKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_tienKhachDuaKeyTyped(evt);
            }
        });

        jLabel20.setText("VNĐ");

        lbl_TienThua.setForeground(new java.awt.Color(255, 0, 0));
        lbl_TienThua.setText("0");
        lbl_TienThua.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                lbl_TienThuaKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                lbl_TienThuaKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                lbl_TienThuaKeyTyped(evt);
            }
        });

        jLabel22.setText("VNĐ");

        btn_huy.setBackground(new java.awt.Color(153, 255, 204));
        btn_huy.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/bill.png"))); // NOI18N
        btn_huy.setText("Hủy hóa đơn");
        btn_huy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_huyActionPerformed(evt);
            }
        });

        btn_lamMoi.setBackground(new java.awt.Color(153, 255, 204));
        btn_lamMoi.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/exchange.png"))); // NOI18N
        btn_lamMoi.setText("Làm mới");
        btn_lamMoi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_lamMoiActionPerformed(evt);
            }
        });

        btn_ThanhToan.setBackground(new java.awt.Color(153, 255, 204));
        btn_ThanhToan.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btn_ThanhToan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/wallet.png"))); // NOI18N
        btn_ThanhToan.setText("Thanh toán");
        btn_ThanhToan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_ThanhToanActionPerformed(evt);
            }
        });

        txt_maHoaDon1.setEditable(false);

        lbl_tienkhachdua.setForeground(new java.awt.Color(255, 0, 51));
        lbl_tienkhachdua.setText(" ");

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(btn_huy)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel12, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel11, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel7Layout.createSequentialGroup()
                                        .addComponent(lbl_tongThanhTien, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jLabel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addGroup(jPanel7Layout.createSequentialGroup()
                                        .addComponent(lbl_giamGia, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jLabel17, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addGroup(jPanel7Layout.createSequentialGroup()
                                        .addComponent(lbl_TienThua, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jLabel22, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addGroup(jPanel7Layout.createSequentialGroup()
                                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(txt_tienKhachDua, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(lbl_thanhToan, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(3, 3, 3)
                                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel7Layout.createSequentialGroup()
                                                .addComponent(jLabel20, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addGap(8, 8, 8))
                                            .addComponent(jLabel19, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addGap(18, 18, 18)))
                                .addGap(99, 99, 99))
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel7Layout.createSequentialGroup()
                                        .addComponent(txt_maHoaDon1, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(btn_taoHoaDon))
                                    .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(btn_lamMoi, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(lbl_tienkhachdua, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(0, 0, Short.MAX_VALUE))))))
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(74, 74, 74)
                .addComponent(btn_ThanhToan, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(btn_taoHoaDon)
                    .addComponent(txt_maHoaDon1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(34, 34, 34)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(lbl_tongThanhTien)
                    .addComponent(jLabel15))
                .addGap(32, 32, 32)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(lbl_giamGia)
                    .addComponent(jLabel17))
                .addGap(34, 34, 34)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(lbl_thanhToan)
                    .addComponent(jLabel19))
                .addGap(31, 31, 31)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(txt_tienKhachDua, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel20))
                .addGap(11, 11, 11)
                .addComponent(lbl_tienkhachdua)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(lbl_TienThua)
                    .addComponent(jLabel22))
                .addGap(129, 129, 129)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_huy)
                    .addComponent(btn_lamMoi))
                .addGap(12, 12, 12)
                .addComponent(btn_ThanhToan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, 348, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 267, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void cb_mauActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cb_mauActionPerformed
        // TODO add your handling code here:

        boxModelMauSac = (DefaultComboBoxModel) cb_mau.getModel();
        defaultTableModel1 = (DefaultTableModel) tbl_bangSanPham.getModel();
        int mau = (int) cb_mau.getSelectedIndex();
        System.out.println(mau);
        //  All là index thứ 0 nên xét mau >0 là rơi vào trường hợp các tên màu 
        if (mau > 0) {
            defaultTableModel1.setRowCount(0);
//            ChiTietSPViewModel chiTiet = (ChiTietSPViewModel) cb_mau.getSelectedItem();
            String mau1 = (String) cb_mau.getSelectedItem();
            List<ChiTietSPViewModel> list = chiTietSPService.locMauSac(mau1);
            for (ChiTietSPViewModel chiTietSPViewModel : list) {

                defaultTableModel1.addRow(new Object[]{chiTietSPViewModel.getTenSP(), chiTietSPViewModel.getDonGia(), chiTietSPViewModel.getGiamGia(),
                    chiTietSPViewModel.getMauSac(), chiTietSPViewModel.getTenNSX(),
                    chiTietSPViewModel.getKichThuoc(), chiTietSPViewModel.getTrongLuong(), chiTietSPViewModel.getSoLuongTon()});
            }
        } else {// trường hợp nếu ấn All trên cbox
            defaultTableModel1.setRowCount(0);
            List<ChiTietSPViewModel> list1 = chiTietSPService.getAll();
            for (ChiTietSPViewModel chiTietSPViewModel : list1) {

                defaultTableModel1.addRow(new Object[]{chiTietSPViewModel.getTenSP(), chiTietSPViewModel.getDonGia(), chiTietSPViewModel.getGiamGia(),
                    chiTietSPViewModel.getMauSac(), chiTietSPViewModel.getTenNSX(),
                    chiTietSPViewModel.getKichThuoc(), chiTietSPViewModel.getTrongLuong(), chiTietSPViewModel.getSoLuongTon()});
            }
        }


    }//GEN-LAST:event_cb_mauActionPerformed

    private void btn_ThanhToanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_ThanhToanActionPerformed
        // TODO add your handling code here:
        if (tbl_hoadon.getSelectedRow() < 0) {
            JOptionPane.showMessageDialog(this, "Chọn hóa đơn muốn thanh toán");
        } else {
            if (txt_tienKhachDua.getText().equals("")) {
                JOptionPane.showMessageDialog(this, "Khách Hàng cần Thanh Toán");
                return;
            }
            if (Double.parseDouble(txt_tienKhachDua.getText()) <= 0 || Double.parseDouble(txt_tienKhachDua.getText()) < Double.parseDouble(lbl_thanhToan.getText())) {
                JOptionPane.showMessageDialog(this, "Số tiền khách hàng cần Thanh Toán là " + lbl_thanhToan.getText());
                return;
            }
            if (chiTietSPService.kiemTraLaSo(txt_tienKhachDua.getText()) == false) {
                JOptionPane.showMessageDialog(this, "Số lượng không hợp lệ");
                return;
            }
            String ma = txt_maHoaDon1.getText();
            for (int i = 0; i < luuTam.size(); i++) {
                if (donChiTietServices.upDate(luuTam.get(i).getSoLuong(), ma, luuTam.get(i).getMaSP()) != null) {
                    System.out.println("update sl thanhcong");
                }
            }

            ArrayList<String> li = donChiTietServices.getMaSP(ma);

//        for (int i = 0; i < luuTam.size(); i++) {
//            int dem = 0;
//            for (int j = 0; j < li.size(); j++) {
//                if (luuTam.get(i).getMaSP().equals(li.get(j))) {
//                    dem++;
//                }
//            }
//            if (dem == 0) {
//                HoaDonChiTiet chiTiet = new HoaDonChiTiet();
//                chiTiet.setMaHD(ma);
//                chiTiet.setDonGia(luuTam.get(i).getDonGia());
//                chiTiet.setSoLuong(luuTam.get(i).getSoLuong());
//                chiTiet.setMaSP(luuTam.get(i).getMaSP());
//                chiTiet.setTienGiam(luuTam.get(i).getGiamGia());
//                if (donChiTietServices.them(chiTiet) != null) {
//                    System.out.println("them lần 2 thành công");
//                }
//            }
//        }
            if (donChiTietServices.xoa(ma) != null) {
                System.out.println("xoa HDCT tc");
            } else {
                System.out.println("xoa HDCT ko tc");
            }
            for (int i = 0; i < luuTam.size(); i++) {
                HoaDonChiTiet chiTiet = new HoaDonChiTiet();
                chiTiet.setMaHD(ma);
                chiTiet.setDonGia(luuTam.get(i).getDonGia());
                chiTiet.setSoLuong(luuTam.get(i).getSoLuong());
                chiTiet.setMaSP(luuTam.get(i).getMaSP());
//            chiTiet.setTienGiam(luuTam.get(i).getGiamGia());
                if (luuTam.get(i).getGiamGia().endsWith("VNĐ")) {
                    char[] chars = luuTam.get(i).getGiamGia().toCharArray();
                    char[] chars1 = new char[chars.length - 3];
                    for (int k = 0; k < chars.length - 3; k++) {
                        chars1[k] = chars[k];

                    }
                    String str = new String(chars1);
                    chiTiet.setTienGiam(str);
                } else if (luuTam.get(i).getGiamGia().endsWith("%")) {
                    double donGia2 = luuTam.get(i).getDonGia();
                    char[] chars = luuTam.get(i).getGiamGia().toCharArray();
                    char[] chars1 = new char[chars.length - 1];
                    for (int l = 0; l < chars.length - 1; l++) {
                        chars1[l] = chars[l];

                    }
                    String str = new String(chars1);
                    int giaGiam = Integer.parseInt(str);
                    double thanhTienCua1SP = donGia2 - ((donGia2 * (100 - giaGiam)) / 100);
                    chiTiet.setTienGiam(String.valueOf(thanhTienCua1SP));
                } else {
                    chiTiet.setTienGiam("0");
                }
                if (donChiTietServices.them(chiTiet) != null) {
                    System.out.println("them lần 2 thành công");
                }

            }

            if (donServices.updateDaTT(ma) != null) {
                JOptionPane.showMessageDialog(this, "Thanh Toán Thành Công");
            }

            HoaDon hd2 = new HoaDon();
            hd2.setNgayThanhToan(new Date());
            hd2.setThanhTien(Double.parseDouble(lbl_thanhToan.getText()));
            if (donServices.updateNgayTT(ma, hd2) != null) {
                System.out.println("update ngayTT ok");
            }
            if (donServices.updateThanhTien(ma, hd2) != null) {
                System.out.println("update thanhTien ok");
            }

            for (int i = 0; i < luuTam.size(); i++) {
                ArrayList<String> li1 = donChiTietServices.getMaHDCT(ma, luuTam.get(i).getMaSP());
                int soLuong = luuTam.get(i).getSoLuong();
                for (int j = 0; j < soLuong; j++) {
                    ArrayList<String> li2 = serialServices.getMa(luuTam.get(i).getMaSP());
                    SerialDaBan serialDaBan = new SerialDaBan();
                    serialDaBan.setMaSerial(li2.get(0));
                    serialDaBan.setTinhTrang("Đã Bán");
                    serialDaBan.setMaHDCT(li1.get(0));
                    if (serialDaBanServices.them(serialDaBan) != null) {
                        System.out.println("Thêm serial đã bán ok");
                    } else {
                        System.out.println("Thêm serial đã bán !ok");

                    }

                    if (serialServices.xoaKhiDaBan(li2.get(0)) != null) {
                        System.out.println("xoá serial đã bán ok");
                    } else {
                        System.out.println("xoá serial đã bán !ok");

                    }
                }
//
            }
            xuatHoaDon();

            xoaTat();
            loadHoaDon();

            clear_hoaDon();
            tbl_bangSanPham.setRowSelectionInterval(0, 0);
        }

    }//GEN-LAST:event_btn_ThanhToanActionPerformed

    void xuatHoaDon() {

        String maKH = txt_maKH.getText();
        List<KhachHang> list = khachHangService.getSelectSql1(maKH);
        String tenKH = list.get(0).getTen();
        String dchi = list.get(0).getDiachi();
        String sdt = list.get(0).getSdt();

        String maNV = (String) cb_NhanVien.getSelectedItem();
        List<NhanVien> li = iNhanVienService.getSelectSqlLV(maNV);
        String tenNV = li.get(0).getTen();

        XWPFDocument document = new XWPFDocument();
        XWPFParagraph xWPFParagraph = document.createParagraph();
        XWPFRun run = xWPFParagraph.createRun();
        XWPFParagraph titleGraph = document.createParagraph();

        titleGraph.setAlignment(ParagraphAlignment.CENTER);

        String title = "CỬA HÀNG BÁN LAPTOP";

        XWPFRun titleRun = titleGraph.createRun();

        titleRun.setBold(true);

        titleRun.setText(title);

        XWPFParagraph xWPFParagraph1 = document.createParagraph();
        xWPFParagraph1.setAlignment(ParagraphAlignment.CENTER);
        run = xWPFParagraph1.createRun();
        run.setText("ĐC: Phố Trinh Văn Bô , Nam Từ Liêm , Hà Nội");

        XWPFParagraph xWPFParagraph2 = document.createParagraph();
        xWPFParagraph2.setAlignment(ParagraphAlignment.CENTER);
        run = xWPFParagraph2.createRun();
        run.setText("SĐT:0339999999 ");

        XWPFParagraph xWPFParagraph3 = document.createParagraph();

        xWPFParagraph3.setAlignment(ParagraphAlignment.CENTER);

        run = xWPFParagraph3.createRun();
        run.setText("HOÁ ĐƠN BÁN LAPTOP");

        XWPFParagraph xWPFParagraph0 = document.createParagraph();
        run = xWPFParagraph0.createRun();
        run.setText("Mã Hoá Đơn : " + txt_maHoaDon1.getText());

        XWPFParagraph xWPFParagraph4 = document.createParagraph();
        run = xWPFParagraph4.createRun();
        run.setText("Mã Khách Hàng : " + maKH);

        XWPFParagraph xWPFParagraph5 = document.createParagraph();
        run = xWPFParagraph5.createRun();
        run.setText("Tên Khách Hàng : " + tenKH);

        XWPFParagraph xWPFParagraph6 = document.createParagraph();
        run = xWPFParagraph6.createRun();
        run.setText("Địa Chỉ : " + dchi);

        XWPFParagraph xWPFParagraph7 = document.createParagraph();
        run = xWPFParagraph7.createRun();
        run.setText("Số Điện Thoại : " + sdt);

        XWPFParagraph xWPFParagraph8 = document.createParagraph();
        run = xWPFParagraph8.createRun();
        run.setText("Ngày lập : " + new Date());
        
        String tenHD = txt_maHoaDon1.getText();

        File f = new File("D://"+tenHD+".docx");
        try {
            FileOutputStream fos = new FileOutputStream(f);
            XWPFParagraph xWPFParagraph13 = document.createParagraph();
            run = xWPFParagraph13.createRun();
            run.setText("  ");
            XWPFTable table = document.createTable();
            table.setWidth(10000);
            XWPFTableRow tableRowOne = table.getRow(0);

            tableRowOne.getCell(0).setText("Tên Sản Phẩm");
            tableRowOne.addNewTableCell().setText("Số Lượng");
            tableRowOne.addNewTableCell().setText(
                    "Đơn Giá)");
            tableRowOne.addNewTableCell().setText(
                    "Giảm Giá");
            tableRowOne.addNewTableCell().setText(
                    "Thành Tiền");
            int row = 0;
            for (int i = 0; i < tbl_gioHang.getRowCount(); i++) {
                XWPFTableRow tableRowTwo = table.createRow();

                tableRowTwo.getCell(0).setText(tbl_gioHang.getValueAt(row, 0).toString());

                tableRowTwo.getCell(1).setText(tbl_gioHang.getValueAt(row, 1).toString());

                tableRowTwo.getCell(2).setText(tbl_gioHang.getValueAt(row, 2).toString());

                tableRowTwo.getCell(3).setText(tbl_gioHang.getValueAt(row, 3).toString());
                tableRowTwo.getCell(4).setText(tbl_gioHang.getValueAt(row, 4).toString());

                row++;
            }

            XWPFParagraph xWPFParagraph14 = document.createParagraph();
            run = xWPFParagraph14.createRun();
            run.setText("  ");

            XWPFParagraph xWPFParagraph9 = document.createParagraph();
            run = xWPFParagraph9.createRun();
            run.setText("Tổng Giảm Giá : " + lbl_giamGia.getText());

            XWPFParagraph xWPFParagraph10 = document.createParagraph();
            run = xWPFParagraph10.createRun();
            run.setText("Tổng Tiền Thanh Toán : " + lbl_tongThanhTien.getText());

            XWPFParagraph xWPFParagraph111 = document.createParagraph();
            run = xWPFParagraph111.createRun();
            run.setText("Tiền Khách Đưa : " + txt_tienKhachDua.getText());

            XWPFParagraph xWPFParagraph11 = document.createParagraph();
            run = xWPFParagraph11.createRun();
            run.setText("Tiền Trả Lại : " + lbl_TienThua.getText());

            XWPFParagraph xWPFParagraph12 = document.createParagraph();
            xWPFParagraph12.setAlignment(ParagraphAlignment.RIGHT);
            run = xWPFParagraph12.createRun();
            run.setText("Người Lập Hoá Đơn");

            XWPFParagraph xWPFParagraph133 = document.createParagraph();
            xWPFParagraph133.setAlignment(ParagraphAlignment.RIGHT);
            run = xWPFParagraph133.createRun();
            run.setText(tenNV);

            XWPFParagraph xWPFParagraph144 = document.createParagraph();
            run = xWPFParagraph144.createRun();
            run.setText("----------------------------------------------------"
                    + "---------------------------------------------------------"
                    + "-----------------------------");

            XWPFParagraph xWPFParagraph145 = document.createParagraph();
            xWPFParagraph145.setAlignment(ParagraphAlignment.CENTER);
            run = xWPFParagraph145.createRun();
            run.setText("Khách Hàng Kiểm Tra Lại Hoá Đơn Khi Ra Cửa Hàng");
            XWPFParagraph xWPFParagraph146 = document.createParagraph();
            xWPFParagraph146.setAlignment(ParagraphAlignment.CENTER);
            run = xWPFParagraph146.createRun();
            run.setText("Xin Cảm Ơn Quý Khách Hàng");

            document.write(fos);
            fos.close();
            document.close();
            System.out.println("xuất hoá đơn thành công");

        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }

    }

    ArrayList<HoaDonChiTiet> getHDCT(ArrayList<GioHangViewModel> gh) {
        ArrayList<HoaDonChiTiet> list = new ArrayList<>();

        for (GioHangViewModel gioHangViewModel : gh) {
            HoaDonChiTiet hd = new HoaDonChiTiet();
            hd.setMaHD(txt_maHoaDon1.getText());
            hd.setMaSP(gioHangViewModel.getMaSP());
            hd.setSoLuong(gioHangViewModel.getSoLuong());
            hd.setDonGia(gioHangViewModel.getDonGia());
//            double tienGiam = (gioHangViewModel.getDonGia() * gioHangViewModel.getSoLuong()) - gioHangViewModel.getThanhTien();
            hd.setTienGiam(gioHangViewModel.getGiamGia());
            list.add(hd);
        }

        return list;
    }
    private void txt_tenSPFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_tenSPFocusGained


    }//GEN-LAST:event_txt_tenSPFocusGained

    private void tbl_bangSanPhamFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tbl_bangSanPhamFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_tbl_bangSanPhamFocusGained

    private void txt_tenSPKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_tenSPKeyPressed
        // TODO add your handling code here:
        defaultTableModel = (DefaultTableModel) tbl_bangSanPham.getModel();
        String tenSP = "%" + txt_tenSP.getText() + "%";
        List<ChiTietSPViewModel> list = chiTietSPService.timKiemSP(tenSP);
        defaultTableModel.setRowCount(0);
        for (ChiTietSPViewModel chiTietSPViewModel : list) {

            defaultTableModel.addRow(new Object[]{chiTietSPViewModel.getTenSP(), chiTietSPViewModel.getDonGia(), chiTietSPViewModel.getGiamGia(),
                chiTietSPViewModel.getMauSac(), chiTietSPViewModel.getTenNSX(),
                chiTietSPViewModel.getKichThuoc(), chiTietSPViewModel.getTrongLuong(), chiTietSPViewModel.getSoLuongTon()});

        }
    }//GEN-LAST:event_txt_tenSPKeyPressed

    private void txt_tenSPKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_tenSPKeyReleased
        defaultTableModel = (DefaultTableModel) tbl_bangSanPham.getModel();
        String tenSP = "%" + txt_tenSP.getText() + "%";
        List<ChiTietSPViewModel> list = chiTietSPService.timKiemSP(tenSP);
        defaultTableModel.setRowCount(0);
        for (ChiTietSPViewModel chiTietSPViewModel : list) {

            defaultTableModel.addRow(new Object[]{chiTietSPViewModel.getTenSP(), chiTietSPViewModel.getDonGia(), chiTietSPViewModel.getGiamGia(),
                chiTietSPViewModel.getMauSac(), chiTietSPViewModel.getTenNSX(),
                chiTietSPViewModel.getKichThuoc(), chiTietSPViewModel.getTrongLuong(), chiTietSPViewModel.getSoLuongTon()});

        }        // TODO add your handling code here:
    }//GEN-LAST:event_txt_tenSPKeyReleased

    private void txt_tenSPKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_tenSPKeyTyped
        // TODO add your handling code here:
        defaultTableModel = (DefaultTableModel) tbl_bangSanPham.getModel();
        String tenSP = "%" + txt_tenSP.getText() + "%";
        List<ChiTietSPViewModel> list = chiTietSPService.timKiemSP(tenSP);
        defaultTableModel.setRowCount(0);
        for (ChiTietSPViewModel chiTietSPViewModel : list) {

            defaultTableModel.addRow(new Object[]{chiTietSPViewModel.getTenSP(), chiTietSPViewModel.getDonGia(), chiTietSPViewModel.getGiamGia(),
                chiTietSPViewModel.getMauSac(), chiTietSPViewModel.getTenNSX(),
                chiTietSPViewModel.getKichThuoc(), chiTietSPViewModel.getTrongLuong(), chiTietSPViewModel.getSoLuongTon()});

        }
    }//GEN-LAST:event_txt_tenSPKeyTyped

    private void tbl_bangSanPhamMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_bangSanPhamMouseClicked
        // TODO add your handling code here:

        int row = tbl_bangSanPham.getSelectedRow();
        int soLuong = (int) tbl_bangSanPham.getValueAt(row, 7);
        if (soLuong <= 0) {
            JOptionPane.showMessageDialog(this, "Sản phẩm này đã hết");
            return;
        }

        loadGH(row);
        List<ChiTietSPViewModel> li = chiTietSPService.getAllID();

        String maSP = li.get(row).getMaSP();
        if (chiTietSPService.upDateSL(maSP) != null) {
            System.out.println("giảm số lượng thành công1");
        } else {
            System.out.println("giảm số lượng không thành công1");
        }
        defaultTableModel1.setRowCount(0);
        loadData();


    }//GEN-LAST:event_tbl_bangSanPhamMouseClicked

    private void btn_xoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_xoaActionPerformed
        // TODO add your handling code here:

        int row = tbl_gioHang.getSelectedRow();
        if (row < 0) {
            JOptionPane.showMessageDialog(this, "Bạn cần chọn 1 sản phẩm trong giỏ");
            return;
        }
        int p = JOptionPane.showConfirmDialog(this, "Bạn có chắc chắn muốn xoá sản phẩm này ?", "PHẦN MỀM QUẢN LÝ BÁN HÀNG", JOptionPane.YES_NO_OPTION);
        if (p == JOptionPane.YES_OPTION) {
            String ma = luuTam.get(row).getMaSP();
            int soLuong = luuTam.get(row).getSoLuong();
            if (chiTietSPService.upDateSLKhiAnXoa(ma, soLuong) != null) {
                System.out.println("update sluong khi xoá ok");
                defaultTableModel1.setRowCount(0);
                loadData();
            }
            if (txt_maHoaDon1.getText().length() > 0) {

                String maHD = txt_maHoaDon1.getText();
                String maSP = luuTam.get(row).getMaSP();
                if (donChiTietServices.xoa(maHD, maSP) != null) {
                    System.out.println("xoá sp trong hdct thành công");

                }
            }
            luuTam.remove(row);
            JOptionPane.showMessageDialog(this, "Xoá thành công ");
            defaultTableModel.setRowCount(0);
            for (GioHangViewModel gioHangViewModel : luuTam) {
                defaultTableModel.addRow(new Object[]{gioHangViewModel.getTenSP(), gioHangViewModel.getSoLuong(), gioHangViewModel.getDonGia(), gioHangViewModel.getGiamGia(), gioHangViewModel.getThanhTien()});
            }
            thayDoi_lblHoaDon();
        }


    }//GEN-LAST:event_btn_xoaActionPerformed

    private void btn_xoaTatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_xoaTatActionPerformed
        // TODO add your handling code here:
        int i = JOptionPane.showConfirmDialog(this, "Bạn có chắc chắn muốn xoá tất các sản phẩm trong giỏ hàng ?", "PHẦN MỀM QUẢN LÝ BÁN HÀNG", JOptionPane.YES_NO_OPTION);
        if (i == JOptionPane.YES_OPTION) {
            for (int j = 0; j < luuTam.size(); j++) {
                String ma = luuTam.get(j).getMaSP();
                int soLuong = luuTam.get(j).getSoLuong();
                if (chiTietSPService.upDateSLKhiAnXoa(ma, soLuong) != null) {
                    System.out.println("update sluongChiTiet khi xoá ok");

                }
            }
            defaultTableModel1.setRowCount(0);
            loadData();

            if (txt_maHoaDon1.getText().length() > 0) {
                String maHD = txt_maHoaDon1.getText();
                for (int j = 0; j < luuTam.size(); j++) {

                    if (donChiTietServices.xoa(maHD, luuTam.get(j).getMaSP()) != null) {
                        System.out.println("xoá sp trong hdct thành công");

                    }
                }
            }
            xoaTat();
            JOptionPane.showMessageDialog(this, "Xoá thành công ");
            lbl_giamGia.setText("0");
            lbl_thanhToan.setText("0");
            lbl_tongThanhTien.setText("0");
            lbl_TienThua.setText("0");
            txt_tienKhachDua.setText("");
        }

    }//GEN-LAST:event_btn_xoaTatActionPerformed

    void xoaTat() {
        do {
            for (int j = 0; j < luuTam.size(); j++) {
                luuTam.remove(j);
            }

        } while (luuTam.size() != 0);
        defaultTableModel.setRowCount(0);
        for (GioHangViewModel gioHangViewModel : luuTam) {
            defaultTableModel.addRow(new Object[]{gioHangViewModel.getTenSP(), gioHangViewModel.getSoLuong(), gioHangViewModel.getDonGia(), gioHangViewModel.getGiamGia(), gioHangViewModel.getThanhTien()});
        }
    }
    private void btn_themSLActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_themSLActionPerformed
        // TODO add your handling code here:
        int row = tbl_gioHang.getSelectedRow();
        if (row < 0) {
            JOptionPane.showMessageDialog(this, "Bạn cần chọn 1 sản phẩm trong giỏ");
            return;
        }
        String i = JOptionPane.showInputDialog(this, "Mời bạn nhập số lượng");
        if (chiTietSPService.kiemTraLaSo(i) == false) {
            JOptionPane.showMessageDialog(this, "Số lượng không hợp lệ");

            return;
        }
        Integer soLuong = Integer.parseInt(i);
        int soLuongTrongGio = luuTam.get(row).getSoLuong();
        String maSP = luuTam.get(row).getMaSP();
        Integer soLuongChiTietSP = chiTietSPService.getSoLuong(maSP);
        if ((soLuongChiTietSP + soLuongTrongGio) < soLuong) {
            JOptionPane.showMessageDialog(this, "Số Lượng Không Đủ");
            return;
        }
        if (chiTietSPService.upDateSLKhiAnThayDoiSL(maSP, soLuongTrongGio, soLuong) != null) {
            System.out.println("update sluong khi ấn thay đổi SL OK ");
            defaultTableModel1.setRowCount(0);
            loadData();
        }

        tbl_gioHang.setValueAt(i, row, 1);
        String giamGia = (String) tbl_gioHang.getValueAt(row, 3);
        double donGia = Double.parseDouble(String.valueOf(tbl_gioHang.getValueAt(row, 2)));
        double thanhTien = 0;
        if (giamGia.endsWith("VNĐ")) {
            char[] chars = giamGia.toCharArray();
            char[] chars1 = new char[chars.length - 3];
            for (int k = 0; k < chars.length - 3; k++) {
                chars1[k] = chars[k];

            }
            String str = new String(chars1);
            double giaGiam = Double.parseDouble(str);
            double phanGiam = giaGiam * soLuong;
            double dg = donGia * soLuong;
            thanhTien = dg - phanGiam;

        } else if (giamGia.endsWith("%")) {
            String donGia2 = String.valueOf(tbl_gioHang.getValueAt(row, 2));
            char[] chars = giamGia.toCharArray();
            char[] chars1 = new char[chars.length - 1];
            for (int l = 0; l < chars.length - 1; l++) {
                chars1[l] = chars[l];

            }
            String str = new String(chars1);
            double dg = Double.parseDouble(donGia2);
            double giaGiam = Double.parseDouble(str);
            double thanhTienCua1SP = dg * ((100 - giaGiam) / 100);
            thanhTien = soLuong * thanhTienCua1SP;

        } else {
            thanhTien = soLuong * donGia;

        }
        String ma = luuTam.get(row).getMaSP();
        System.out.println(ma);
        for (int j = 0; j < luuTam.size(); j++) {
            if (luuTam.get(j).getMaSP().equals(ma)) {
                luuTam.get(j).setSoLuong(soLuong);
                luuTam.get(j).setThanhTien(thanhTien);
            }
        }
        defaultTableModel = (DefaultTableModel) tbl_gioHang.getModel();
        defaultTableModel.setRowCount(0);
        for (GioHangViewModel gioHangViewModel : luuTam) {
            defaultTableModel.addRow(new Object[]{gioHangViewModel.getTenSP(), gioHangViewModel.getSoLuong(), gioHangViewModel.getDonGia(), gioHangViewModel.getGiamGia(), gioHangViewModel.getThanhTien()});
        }
        JOptionPane.showMessageDialog(this, "Thay đổi số lượng thành công");
        thayDoi_lblHoaDon();


    }//GEN-LAST:event_btn_themSLActionPerformed

    private void lbl_TienThuaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_lbl_TienThuaKeyPressed
        // TODO add your handling code here:


    }//GEN-LAST:event_lbl_TienThuaKeyPressed

    private void lbl_TienThuaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_lbl_TienThuaKeyReleased
        // TODO add your handling code here:

    }//GEN-LAST:event_lbl_TienThuaKeyReleased

    private void lbl_TienThuaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_lbl_TienThuaKeyTyped
        // TODO add your handling code here:

    }//GEN-LAST:event_lbl_TienThuaKeyTyped

    private void txt_tienKhachDuaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_tienKhachDuaKeyPressed
        // TODO add your handling code here:
        try {
//            if (chiTietSPService.kiemTraLaSo(txt_tienKhachDua.getText().toString()) == false) {
//                JOptionPane.showMessageDialog(this, "Nhập không hợp lệ");
//                return;
//
//            }
            if (txt_tienKhachDua.getText().equals("")) {
                lbl_TienThua.setText("0");
            }
            double tienKhachDua = Double.parseDouble(String.valueOf(txt_tienKhachDua.getText()));
            double tienThanhToan = Double.parseDouble(String.valueOf(lbl_thanhToan.getText()));
            double tienThua = tienKhachDua - tienThanhToan;
            lbl_TienThua.setText(String.valueOf(tienThua));
        } catch (Exception e) {
        }
    }//GEN-LAST:event_txt_tienKhachDuaKeyPressed

    private void txt_tienKhachDuaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_tienKhachDuaKeyReleased
        // TODO add your handling code here:
        try {
            if (txt_tienKhachDua.getText().toString().length() > 0) {
                if (chiTietSPService.kiemTraLaSo(txt_tienKhachDua.getText().toString()) == false) {
                    lbl_tienkhachdua.setText("Nhập không hợp lệ");
                    return;

                } else {
                    lbl_tienkhachdua.setText("");
                }
            }
            if (txt_tienKhachDua.getText().equals("")) {
                lbl_tienkhachdua.setText("");

                lbl_TienThua.setText("0");
            }
            double tienKhachDua = Double.parseDouble(String.valueOf(txt_tienKhachDua.getText()));
            double tienThanhToan = Double.parseDouble(String.valueOf(lbl_thanhToan.getText()));
            double tienThua = tienKhachDua - tienThanhToan;
            lbl_TienThua.setText(String.valueOf(tienThua));

        } catch (Exception e) {
        }
    }//GEN-LAST:event_txt_tienKhachDuaKeyReleased

    private void txt_tienKhachDuaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_tienKhachDuaKeyTyped
        // TODO add your handling code here:
        try {
//            if (chiTietSPService.kiemTraLaSo(txt_tienKhachDua.getText().toString()) == false) {
//                JOptionPane.showMessageDialog(this, "Nhập không hợp lệ");
//                return;
//
//            }
            if (txt_tienKhachDua.getText().equals("")) {
                lbl_TienThua.setText("0");
            }
            double tienKhachDua = Double.parseDouble(String.valueOf(txt_tienKhachDua.getText()));
            double tienThanhToan = Double.parseDouble(String.valueOf(lbl_thanhToan.getText()));
            double tienThua = tienKhachDua - tienThanhToan;
            lbl_TienThua.setText(String.valueOf(tienThua));
        } catch (Exception e) {
        }
    }//GEN-LAST:event_txt_tienKhachDuaKeyTyped

    private void btn_taoHoaDonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_taoHoaDonActionPerformed
        // TODO add your handling code here:

        if (kiemTra()) {
            //get
            ArrayList<String> list = donServices.trungMa();
            HoaDon hd = new HoaDon();
            String i = null;
            do {
                Random rd = new Random();
                i = "HD" + rd.nextInt();

            } while (trungMa(i) == false);
            hd.setMaHD(i);
            hd.setNgayTao(new Date());
            hd.setMaKH(txt_maKH.getText());
            hd.setMaNV(cb_NhanVien.getSelectedItem().toString());
            hd.setTinhTrang("Chờ Thanh Toán");
            hd.setThanhTien(Double.parseDouble(lbl_thanhToan.getText()));

            if (donServices.them(hd) != null) {
                JOptionPane.showMessageDialog(this, "Tạo Hoá Đơn Thành Công");

            } else {
                JOptionPane.showMessageDialog(this, "Tạo Hoá Đơn Thất Bại");
            }

            for (GioHangViewModel gioHangViewModel : luuTam) {
                luuTam2.add(gioHangViewModel);
            }
            // them các sản phẩm ở giỏ hàng vào HDCT
            ArrayList<HoaDonChiTiet> list1 = new ArrayList<>();

            for (GioHangViewModel gioHangViewModel : luuTam2) {
                HoaDonChiTiet hd1 = new HoaDonChiTiet();
                hd1.setMaHD(i);
                hd1.setMaSP(gioHangViewModel.getMaSP());
                hd1.setSoLuong(gioHangViewModel.getSoLuong());
                hd1.setDonGia(gioHangViewModel.getDonGia());
//            double tienGiam = (gioHangViewModel.getDonGia() * gioHangViewModel.getSoLuong()) - gioHangViewModel.getThanhTien();
                if (gioHangViewModel.getGiamGia().endsWith("VNĐ")) {
                    char[] chars = gioHangViewModel.getGiamGia().toCharArray();
                    char[] chars1 = new char[chars.length - 3];
                    for (int k = 0; k < chars.length - 3; k++) {
                        chars1[k] = chars[k];

                    }
                    String str = new String(chars1);
                    hd1.setTienGiam(str);
                } else if (gioHangViewModel.getGiamGia().endsWith("%")) {
                    double donGia2 = gioHangViewModel.getDonGia();
                    char[] chars = gioHangViewModel.getGiamGia().toCharArray();
                    char[] chars1 = new char[chars.length - 1];
                    for (int l = 0; l < chars.length - 1; l++) {
                        chars1[l] = chars[l];

                    }
                    String str = new String(chars1);
                    int giaGiam = Integer.parseInt(str);
                    double thanhTienCua1SP = donGia2 - ((donGia2 * (100 - giaGiam)) / 100);
                    hd1.setTienGiam(String.valueOf(thanhTienCua1SP));
                } else {
                    hd1.setTienGiam("0");
                }

                list1.add(hd1);
            }
            int dem = 0;
            for (HoaDonChiTiet hoaDonChiTiet : list1) {
                if (donChiTietServices.them(hoaDonChiTiet) != null) {
                    dem++;
                }
            }
            if (dem == list1.size()) {
                System.out.println("them HDCT ok");
            }
            // xoá đi bảng giỏ hàng và các lbl ở Hoá Đơn
            xoaTat();
            clear_hoaDon();
            loadHoaDon();
        }


    }//GEN-LAST:event_btn_taoHoaDonActionPerformed

    private void tbl_hoadonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_hoadonMouseClicked
        // TODO add your handling code here:
        int row = tbl_hoadon.getSelectedRow();
        HoaDon hd = donServices.get().get(row);
        String maHD = (String) tbl_hoadon.getValueAt(row, 0);
        txt_maHoaDon1.setText(maHD);
        String maKH = (String) tbl_hoadon.getValueAt(row, 2);
        txt_maKH.setText(maKH);
        cb_NhanVien.setSelectedItem(hd.getMaNV());
        ArrayList<GioHangViewModel> li = gioHang.get(maHD);
        ArrayList<GioHangViewModel> li1 = gioHang.get1(maHD);
        do {
            for (int j = 0; j < luuTam.size(); j++) {
                luuTam.remove(j);
            }

        } while (luuTam.size() != 0);
        for (GioHangViewModel gioHangViewModel : luuTam) {
            System.out.println(gioHangViewModel);

        }
        for (GioHangViewModel gioHangViewModel : li1) {
            luuTam.add(gioHangViewModel);
        }
        defaultTableModel = (DefaultTableModel) tbl_gioHang.getModel();
        defaultTableModel.setRowCount(0);

        for (GioHangViewModel gioHangViewModel : li) {
            defaultTableModel.addRow(new Object[]{gioHangViewModel.getTenSP(), gioHangViewModel.getSoLuong(), gioHangViewModel.getDonGia(), gioHangViewModel.getGiamGia(), gioHangViewModel.getThanhTien()});
        }

        for (int i = 0; i < li.size(); i++) {
            String giamGia = (String) tbl_gioHang.getValueAt(i, 3);
            int soLuong = Integer.parseInt(String.valueOf(tbl_gioHang.getValueAt(i, 1)));
            double donGia = Double.parseDouble(String.valueOf(tbl_gioHang.getValueAt(i, 2)));
            double thanhTien = 0;
            if (giamGia.endsWith("VNĐ")) {
                char[] chars = giamGia.toCharArray();
                char[] chars1 = new char[chars.length - 3];
                for (int k = 0; k < chars.length - 3; k++) {
                    chars1[k] = chars[k];

                }
                String str = new String(chars1);
                double giaGiam = Double.parseDouble(str);
                double phanGiam = giaGiam * soLuong;
                double dg = donGia * soLuong;
                thanhTien = dg - phanGiam;

            } else if (giamGia.endsWith("%")) {
                String donGia2 = String.valueOf(tbl_gioHang.getValueAt(row, 2));
                char[] chars = giamGia.toCharArray();
                char[] chars1 = new char[chars.length - 1];
                for (int l = 0; l < chars.length - 1; l++) {
                    chars1[l] = chars[l];

                }
                String str = new String(chars1);
                double dg = Double.parseDouble(donGia2);
                double giaGiam = Double.parseDouble(str);
                double thanhTienCua1SP = dg * ((100 - giaGiam) / 100);
                thanhTien = soLuong * thanhTienCua1SP;

            } else {
                thanhTien = soLuong * donGia;

            }
            GioHangViewModel gh = new GioHangViewModel();
            gh.setThanhTien(thanhTien);
            tbl_gioHang.setValueAt(thanhTien, i, 4);
            luuTam.get(i).setThanhTien(thanhTien);
            thayDoi_lblHoaDon();
        }

    }//GEN-LAST:event_tbl_hoadonMouseClicked

    private void btn_huyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_huyActionPerformed
        // TODO add your handling code here:
        String ma = txt_maHoaDon1.getText();
        if (donServices.updateHuyTT(ma) != null) {
            JOptionPane.showMessageDialog(this, "Huỷ Hoá Đơn Thành Công");
        }
        for (int j = 0; j < luuTam.size(); j++) {
            String ma1 = luuTam.get(j).getMaSP();
            int soLuong = luuTam.get(j).getSoLuong();
            if (chiTietSPService.upDateSLKhiAnXoa(ma1, soLuong) != null) {
                System.out.println("update sluongChiTiet khi xoá ok");

            }
        }
        defaultTableModel1.setRowCount(0);
        loadData();
        xoaTat();
        loadHoaDon();

        clear_hoaDon();
    }//GEN-LAST:event_btn_huyActionPerformed

    private void btn_lamMoiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_lamMoiActionPerformed
        // TODO add your handling code here:
        if (txt_maHoaDon1.getText().equals("")) {
            if (luuTam.size() > 0) {
                for (int j = 0; j < luuTam.size(); j++) {
                    String ma = luuTam.get(j).getMaSP();
                    int soLuong = luuTam.get(j).getSoLuong();
                    if (chiTietSPService.upDateSLKhiAnXoa(ma, soLuong) != null) {
                        System.out.println("update sluongChiTiet khi xoá ok");

                    }
                }
                defaultTableModel1.setRowCount(0);
                loadData();
            }
        }
        xoaTat();
        tbl_bangSanPham.setRowSelectionInterval(0, 0);
        clear_hoaDon();

    }//GEN-LAST:event_btn_lamMoiActionPerformed

    private void formMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseEntered
        // TODO add your handling code here:
        if (check && getKH != null) {
            String maKH = getKH[0].toString();
            txt_maKH.setText(maKH);
            check = false;
        }
        if (checkQuetMa && luuTam != null) {
            int dem = 0;
            String maSP = getGH[0].toString();
            String tenSP = getGH[1].toString();
            double donGia = Double.parseDouble(getGH[2].toString());
            String giamGia = getGH[3].toString();
            int soLuong = Integer.parseInt((String) getGH[4]);
            double thanhTien = Double.parseDouble(getGH[5].toString());
            GioHangViewModel ghvm = new GioHangViewModel();
            ghvm.setMaSP(maSP);
            ghvm.setTenSP(tenSP);
            ghvm.setDonGia(donGia);
            ghvm.setGiamGia(giamGia);
            ghvm.setSoLuong(soLuong);
            ghvm.setThanhTien(thanhTien);

            for (int i = 0; i < luuTam.size(); i++) {
                if (maSP.equals(luuTam.get(i).getMaSP())) {
                    luuTam.get(i).setSoLuong(soLuong);
                    dem = 1;
                }
            }

            if (dem == 0) {
                luuTam.add(ghvm);

            }

            defaultTableModel = (DefaultTableModel) tbl_gioHang.getModel();
            defaultTableModel.setRowCount(0);
            for (GioHangViewModel gioHangViewModel : luuTam) {
                defaultTableModel.addRow(new Object[]{gioHangViewModel.getTenSP(), gioHangViewModel.getSoLuong(), gioHangViewModel.getDonGia(), gioHangViewModel.getGiamGia(), gioHangViewModel.getThanhTien()});
            }
            thayDoi_lblHoaDon();
            defaultTableModel1.setRowCount(0);
            loadData();
            checkQuetMa = false;
        }
    }//GEN-LAST:event_formMouseEntered

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        new KHACHHANG().setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void btn_themSL1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_themSL1ActionPerformed
        new FormQuetQR().setVisible(true);
    }//GEN-LAST:event_btn_themSL1ActionPerformed

    void loadHoaDon() {
        defaultTableModel = (DefaultTableModel) tbl_hoadon.getModel();
        defaultTableModel.setRowCount(0);
        ArrayList<HoaDon> li = donServices.get();
        for (HoaDon hoaDon : li) {
            defaultTableModel.addRow(new Object[]{hoaDon.getMaHD(), hoaDon.getNgayTao(), hoaDon.getMaKH(), hoaDon.getMaNV(), hoaDon.getTinhTrang()});
        }
    }

    Boolean kiemTra() {
//        if (txt_maHoaDon.getText().length() == 0 || txt_maHoaDon.getText().equals(" ")) {
//            JOptionPane.showMessageDialog(this, "Mã Hoá Đơn Không Được Trống");
//            return false;
//        }
        if (txt_maKH.getText().length() == 0) {
            JOptionPane.showMessageDialog(this, "Mã Khách Hàng Không Được Trống");
            return false;
        }
//        String ma = txt_maHoaDon.getText();
//        ArrayList<String> list = donServices.trungMa();
//        for (String string : list) {
//            if (ma.equals(string)) {
//                JOptionPane.showMessageDialog(this, "Mã Trùng");
//                return false;
//            }
//        }

//        if (txt_tienKhachDua.getText().equals("")) {
//            JOptionPane.showMessageDialog(this, "Tiền khách đưa không được trống");
//            return false;
//        }
        return true;
    }

    Boolean trungMa(String ma) {

        ArrayList<String> list = donServices.trungMa();
        for (String string : list) {
            if (ma.equals(string)) {
                JOptionPane.showMessageDialog(this, "Mã Trùng");
                return false;
            }
        }
        return true;

    }

    HoaDon get() {
        ArrayList<String> list = donServices.trungMa();
        HoaDon hd = new HoaDon();
        String i = null;
        do {
            Random rd = new Random();
            i = "HD" + rd.nextInt();

        } while (trungMa(i) == false);
        hd.setMaHD(i);
        hd.setNgayTao(new Date());
        hd.setMaKH(txt_maKH.getText());
        hd.setMaNV(cb_NhanVien.getSelectedItem().toString());
        hd.setTinhTrang("Chờ Thanh Toán");
        return hd;
    }

    void thayDoi_lblHoaDon() {
        // thay đổi lbl_tongThanhtien trên Hoá Đơn

        double TongThanhTien = 0;
        double TongThanhTien1 = 0;
        for (int tt = 0; tt < tbl_gioHang.getRowCount(); tt++) {
            TongThanhTien1 = Double.parseDouble(String.valueOf(tbl_gioHang.getValueAt(tt, 1)))
                    * Double.parseDouble(String.valueOf(tbl_gioHang.getValueAt(tt, 2)));
            TongThanhTien = TongThanhTien + TongThanhTien1;
        }
        lbl_tongThanhTien.setText(String.valueOf(TongThanhTien));

        // thay đổi lbl_giamgia trên hoá đơn
        String giamGia1 = null;
        double giaGiam1 = 0;
        double giaGiam2 = 0;
        int soLuong1 = 0;
        double donGia1 = 0;
        double thanhTien1 = 0;
        double vnd = 0;
        double phantram1 = 0;
        double phantram2 = 0;
        for (int g = 0; g < tbl_gioHang.getRowCount(); g++) {
            giamGia1 = (String) tbl_gioHang.getValueAt(g, 3);
            soLuong1 = Integer.parseInt(String.valueOf(tbl_gioHang.getValueAt(g, 1)));
            donGia1 = Double.parseDouble(String.valueOf(tbl_gioHang.getValueAt(g, 2)));
            thanhTien1 = Double.parseDouble(String.valueOf(tbl_gioHang.getValueAt(g, 4)));
            if (giamGia1.endsWith("VNĐ")) {
                char[] chars = giamGia1.toCharArray();
                char[] chars1 = new char[chars.length - 3];
                for (int i = 0; i < chars.length - 3; i++) {
                    chars1[i] = chars[i];
                }
                String str = new String(chars1);
                giaGiam1 = Double.parseDouble(str);
                giaGiam2 = giaGiam1 * (Integer.parseInt(String.valueOf(tbl_gioHang.getValueAt(g, 1))));
                vnd = vnd + giaGiam2;
            }
            if (giamGia1.endsWith("%")) {
                phantram1 = (donGia1 * soLuong1) - thanhTien1;
                phantram2 = phantram2 + phantram1;
            }

        }
        double tongGiamGia = phantram2 + vnd;
        double tongGiamGia1 = Math.round(tongGiamGia);
        lbl_giamGia.setText(String.valueOf(tongGiamGia1));
        double giamGia = Double.parseDouble(String.valueOf(lbl_giamGia.getText()));
        double tongThanhTien = Double.parseDouble(String.valueOf(lbl_tongThanhTien.getText()));
        double thanhToan = tongThanhTien - giamGia;
        // thay đổi lbl_thanhToan trên Hoá Đơn
        lbl_thanhToan.setText(String.valueOf(thanhToan));
    }

    void clear_hoaDon() {
        lbl_giamGia.setText("0");
        lbl_thanhToan.setText("0");
        lbl_tongThanhTien.setText("0");
        lbl_TienThua.setText("0");
        txt_tienKhachDua.setText("");
        txt_maHoaDon1.setText("");
        txt_maKH.setText("");
        cb_NhanVien.setSelectedIndex(0);
    }

    void loadGH(int row) {
        List<ChiTietSPViewModel> li = chiTietSPService.getAllID();
        // click chuột vào 1 sp mới chưa có trên giỏ hàng sẽ hiển thị lên bảng giỏ hàng (giỏ hàng đang trống)
        if (tbl_gioHang.getRowCount() <= 0) {
            GioHangViewModel gh = new GioHangViewModel();
            gh.setMaSP(li.get(row).getMaSP());
            gh.setTenSP((String) tbl_bangSanPham.getValueAt(row, 0));
            String donGia = String.valueOf(tbl_bangSanPham.getValueAt(row, 1));
            gh.setDonGia(Double.parseDouble(donGia));
            gh.setSoLuong(1);
            gh.setGiamGia((String) tbl_bangSanPham.getValueAt(row, 2));
            String giamGia = (String) tbl_bangSanPham.getValueAt(row, 2);
            // xét cột thành tiền ở bảng giỏ hàng theo phần giảm giá
            // giảm theo VNĐ
            if (giamGia.endsWith("VNĐ")) {
                char[] chars = giamGia.toCharArray();
                char[] chars1 = new char[chars.length - 3];
                for (int i = 0; i < chars.length - 3; i++) {
                    chars1[i] = chars[i];

                }
                String str = new String(chars1);
                double dg = Double.parseDouble(donGia);
                double giaGiam = Double.parseDouble(str);
                double thanhTien = dg - giaGiam;
                gh.setThanhTien(thanhTien);
                lbl_giamGia.setText(String.valueOf(giaGiam));
            } else if (giamGia.endsWith("%")) { // giảm theo %
                char[] chars = giamGia.toCharArray();
                char[] chars1 = new char[chars.length - 1];
                for (int i = 0; i < chars.length - 1; i++) {
                    chars1[i] = chars[i];

                }
                String str = new String(chars1);
                double dg = Double.parseDouble(donGia);
                double giaGiam = Double.parseDouble(str);
                double thanhTien = dg * ((100 - giaGiam) / 100);
                gh.setThanhTien(thanhTien);

            } else {// không được giảm
                gh.setThanhTien(gh.getDonGia());
            }

            luuTam.add(gh);
            defaultTableModel = (DefaultTableModel) tbl_gioHang.getModel();
            for (GioHangViewModel gioHangViewModel : luuTam) {
                defaultTableModel.addRow(new Object[]{gioHangViewModel.getTenSP(), gioHangViewModel.getSoLuong(), gioHangViewModel.getDonGia(), gioHangViewModel.getGiamGia(), gioHangViewModel.getThanhTien()});
            }
            // xet lbl_thanhTien trên Hoá Đơn
            lbl_tongThanhTien.setText(donGia);
            //xét lbl giảm giá trên hoá đơn
//            if (giamGia.endsWith("VNĐ")) {
//                lbl_giamGia.setText(Double);
//            } else 
            if (giamGia.endsWith("%")) {
                double gg1 = gh.getDonGia() - gh.getThanhTien();
                double gg2 = Math.round(gg1);
                lbl_giamGia.setText(String.valueOf(gg2));
            }
            double giamGia1 = Double.parseDouble(String.valueOf(lbl_giamGia.getText()));
            double tongThanhTien = Double.parseDouble(String.valueOf(lbl_tongThanhTien.getText()));
            double thanhToan = tongThanhTien - giamGia1;
            // thay đổi lbl_thanhToan trên Hoá Đơn
            lbl_thanhToan.setText(String.valueOf(thanhToan));

            return;
        }
        if (tbl_gioHang.getRowCount() > 0) {

            int dem = 0;
            // click chuột vào 1 sp đã có trên giỏ hàng và hiển thị lên bảng giỏ hàng 
            for (int j = 0; j < luuTam.size(); j++) {
                if (luuTam.get(j).getMaSP().equals(li.get(row).getMaSP())) {
                    Integer i = Integer.parseInt(String.valueOf(tbl_gioHang.getValueAt(j, 1)));
                    Integer sl = i + 1;
                    luuTam.get(j).setSoLuong(sl);
                    tbl_gioHang.setValueAt(luuTam.get(j).getSoLuong(), j, 1);
                    Integer soLuong = Integer.parseInt(String.valueOf(tbl_gioHang.getValueAt(j, 1)));
                    double donGia = Double.parseDouble(String.valueOf(tbl_gioHang.getValueAt(j, 2)));

                    String giamGia = (String) tbl_bangSanPham.getValueAt(row, 2);
                    // xét cột thành tiền ở bảng giỏ hàng theo phần giảm giá
                    // giảm theo VNĐ
                    if (giamGia.endsWith("VNĐ")) {
                        char[] chars = giamGia.toCharArray();
                        char[] chars1 = new char[chars.length - 3];
                        for (int k = 0; k < chars.length - 3; k++) {
                            chars1[k] = chars[k];

                        }
                        String str = new String(chars1);
                        double giaGiam = Double.parseDouble(str);
                        double phanGiam = giaGiam * soLuong;
                        double dg = donGia * soLuong;
                        double thanhTien = dg - phanGiam;
                        luuTam.get(j).setThanhTien(thanhTien);
                    } else if (giamGia.endsWith("%")) { //giảm theo %
                        String donGia2 = String.valueOf(tbl_bangSanPham.getValueAt(row, 1));
                        char[] chars = giamGia.toCharArray();
                        char[] chars1 = new char[chars.length - 1];
                        for (int l = 0; l < chars.length - 1; l++) {
                            chars1[l] = chars[l];

                        }
                        String str = new String(chars1);
                        double dg = Double.parseDouble(donGia2);
                        double giaGiam = Double.parseDouble(str);
                        double thanhTienCua1SP = dg * ((100 - giaGiam) / 100);
                        double thanhTien = soLuong * thanhTienCua1SP;
                        luuTam.get(j).setThanhTien(thanhTien);

                    } else {// không đc giảm 
                        double thanhTien = soLuong * donGia;
                        luuTam.get(j).setThanhTien(thanhTien);
                    }

                    tbl_gioHang.setValueAt(luuTam.get(j).getThanhTien(), j, 4);
                    System.out.println("thanh tien la " + luuTam.get(j).getThanhTien());
                    dem = 1;
                    break;
                }
            }
            // click chuột vào 1 sp mới chưa có trên giỏ hàng sẽ hiển thị lên bảng giỏ hàng (giỏ hàng đã có sp khác)
            if (dem == 0) {
                GioHangViewModel gh = new GioHangViewModel();
                gh.setMaSP(li.get(row).getMaSP());
                gh.setTenSP((String) tbl_bangSanPham.getValueAt(row, 0));
                String donGia = String.valueOf(tbl_bangSanPham.getValueAt(row, 1));
                gh.setDonGia(Double.parseDouble(donGia));
                gh.setGiamGia((String) tbl_bangSanPham.getValueAt(row, 2));
                gh.setSoLuong(1);
                String giamGia = (String) tbl_bangSanPham.getValueAt(row, 2);
                // xét cột thành tiền ở bảng giỏ hàng theo phần giảm giá
                // giảm theo VNĐ
                if (giamGia.endsWith("VNĐ")) {
                    char[] chars = giamGia.toCharArray();
                    char[] chars1 = new char[chars.length - 3];
                    for (int i = 0; i < chars.length - 3; i++) {
                        chars1[i] = chars[i];

                    }
                    String str = new String(chars1);
                    double dg = Double.parseDouble(donGia);
                    double giaGiam = Double.parseDouble(str);
                    double thanhTien = dg - giaGiam;
                    gh.setThanhTien(thanhTien);
                } else if (giamGia.endsWith("%")) { // giảm theo %
                    char[] chars = giamGia.toCharArray();
                    char[] chars1 = new char[chars.length - 1];
                    for (int i = 0; i < chars.length - 1; i++) {
                        chars1[i] = chars[i];

                    }
                    String str = new String(chars1);
                    double dg = Double.parseDouble(donGia);
                    double giaGiam = Double.parseDouble(str);
                    double thanhTien = dg * ((100 - giaGiam) / 100);
                    gh.setThanhTien(thanhTien);
                } else {// không đc giảm
                    gh.setThanhTien(gh.getDonGia());
                }
                luuTam.add(gh);
                defaultTableModel = (DefaultTableModel) tbl_gioHang.getModel();
                defaultTableModel.setRowCount(0);
                for (GioHangViewModel gioHangViewModel : luuTam) {
                    defaultTableModel.addRow(new Object[]{gioHangViewModel.getTenSP(),
                        gioHangViewModel.getSoLuong(), gioHangViewModel.getDonGia(),
                        gioHangViewModel.getGiamGia(), gioHangViewModel.getThanhTien()});
                }
                for (GioHangViewModel gioHangViewModel : luuTam) {
                    System.out.println(gioHangViewModel);
                }

            }

        }
        // thay đổi lbl_tongThanhtien trên Hoá Đơn

        double TongThanhTien = 0;
        double TongThanhTien1 = 0;
        for (int tt = 0; tt < tbl_gioHang.getRowCount(); tt++) {
            TongThanhTien1 = Double.parseDouble(String.valueOf(tbl_gioHang.getValueAt(tt, 1)))
                    * Double.parseDouble(String.valueOf(tbl_gioHang.getValueAt(tt, 2)));
            TongThanhTien = TongThanhTien + TongThanhTien1;
        }
        lbl_tongThanhTien.setText(String.valueOf(TongThanhTien));

        // thay đổi lbl_giamgia trên hoá đơn
        String giamGia1 = null;
        double giaGiam1 = 0;
        double giaGiam2 = 0;
        int soLuong1 = 0;
        double donGia1 = 0;
        double thanhTien1 = 0;
        double vnd = 0;
        double phantram1 = 0;
        double phantram2 = 0;
        for (int g = 0; g < tbl_gioHang.getRowCount(); g++) {
            giamGia1 = (String) tbl_gioHang.getValueAt(g, 3);
            soLuong1 = Integer.parseInt(String.valueOf(tbl_gioHang.getValueAt(g, 1)));
            donGia1 = Double.parseDouble(String.valueOf(tbl_gioHang.getValueAt(g, 2)));
            thanhTien1 = Double.parseDouble(String.valueOf(tbl_gioHang.getValueAt(g, 4)));
            if (giamGia1.endsWith("VNĐ")) {
                char[] chars = giamGia1.toCharArray();
                char[] chars1 = new char[chars.length - 3];
                for (int i = 0; i < chars.length - 3; i++) {
                    chars1[i] = chars[i];
                }
                String str = new String(chars1);
                giaGiam1 = Double.parseDouble(str);
                giaGiam2 = giaGiam1 * (Integer.parseInt(String.valueOf(tbl_gioHang.getValueAt(g, 1))));
                vnd = vnd + giaGiam2;
            }
            if (giamGia1.endsWith("%")) {
                phantram1 = (donGia1 * soLuong1) - thanhTien1;
                phantram2 = phantram2 + phantram1;
            }

        }
        double tongGiamGia = phantram2 + vnd;
        double tongGiamGia1 = Math.round(tongGiamGia);
        lbl_giamGia.setText(String.valueOf(tongGiamGia1));
        double giamGia = Double.parseDouble(String.valueOf(lbl_giamGia.getText()));
        double tongThanhTien = Double.parseDouble(String.valueOf(lbl_tongThanhTien.getText()));
        double thanhToan = tongThanhTien - giamGia;
        // thay đổi lbl_thanhToan trên Hoá Đơn
        lbl_thanhToan.setText(String.valueOf(thanhToan));

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_ThanhToan;
    private javax.swing.JButton btn_huy;
    private javax.swing.JButton btn_lamMoi;
    private javax.swing.JButton btn_taoHoaDon;
    private javax.swing.JButton btn_themSL;
    private javax.swing.JButton btn_themSL1;
    private javax.swing.JButton btn_xoa;
    private javax.swing.JButton btn_xoaTat;
    private javax.swing.JComboBox<String> cb_NhanVien;
    private javax.swing.JComboBox<String> cb_mau;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTable jTable3;
    private javax.swing.JLabel lbl_TienThua;
    private javax.swing.JLabel lbl_giamGia;
    private javax.swing.JLabel lbl_thanhToan;
    private javax.swing.JLabel lbl_tienkhachdua;
    private javax.swing.JLabel lbl_tongThanhTien;
    private javax.swing.JTable tbl_bangSanPham;
    private javax.swing.JTable tbl_gioHang;
    private javax.swing.JTable tbl_hoadon;
    private javax.swing.JTextField txt_maHoaDon1;
    private javax.swing.JTextField txt_maKH;
    private javax.swing.JTextField txt_tenSP;
    private javax.swing.JTextField txt_tienKhachDua;
    // End of variables declaration//GEN-END:variables
}
