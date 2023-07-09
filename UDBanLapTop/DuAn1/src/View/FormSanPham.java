/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package View;

import DomainModels.CPU;
import DomainModels.DongSP;
import DomainModels.ManHinh;
import DomainModels.NSX;
import DomainModels.RAM;
import DomainModels.SanPham;
import DomainModels.Serial;
import Services.IChiTietSPService;
import Services.IDongSanPhamService;
import Services.IManHinhService;
import Services.INSXService;
import Services.ITHuocTinhRamService;
import Services.IThuocTinhCPUService;
import Services.lmpl.ChiTietSPServiceImpl;
import Services.lmpl.DongSanPhamServiceImpl;
import java.util.ArrayList;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;
import Services.ISanPhamService;
import Services.ISerialServices;
import Services.lmpl.ManHinhServiceImpl;
import Services.lmpl.NSXServiceImpl;
import Services.lmpl.SanPhamServiceImpl;
import Services.lmpl.SerialServices;
import Services.lmpl.ThuocTinhCPUServiceImpl;
import Services.lmpl.ThuocTinhRamService;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;

/**
 *
 * @author anhtu
 */
public class FormSanPham extends javax.swing.JPanel {

    /**
     * Creates new form FormSanPham
     */
    private JPanel paneTC;
    private final ITHuocTinhRamService ramService;
    private final IThuocTinhCPUService cPUService;
    private final IDongSanPhamService dongSanPhamService;
    private final IManHinhService hinhService;
    private final INSXService nSXService;
    private final IChiTietSPService chiTietSPService;
    private final ISanPhamService sanPhamService;
    private final ISerialServices serialServices;

    private DefaultComboBoxModel boxModelRam;
    private DefaultComboBoxModel boxModelDongSP;
    private DefaultComboBoxModel boxModelCPU;
    private DefaultComboBoxModel boxModelManHinh;
    private DefaultComboBoxModel boxModelNSX;
    private DefaultComboBoxModel boxModelMauSac;
    static String barcode = "";
    static boolean getBarCode = false;

    private DefaultTableModel defaultTableModel;

    public FormSanPham() {
        initComponents();
        setpanal(new ThuocTinhRAM());
        ramService = new ThuocTinhRamService();
        cPUService = new ThuocTinhCPUServiceImpl();
        dongSanPhamService = new DongSanPhamServiceImpl();
        hinhService = new ManHinhServiceImpl();
        nSXService = new NSXServiceImpl();
        chiTietSPService = new ChiTietSPServiceImpl();
        sanPhamService = new SanPhamServiceImpl();
        sanPhamService.updateTrangThai();
        serialServices = new SerialServices();
        addCBMauSac();
        loadCB_RAM();
        loadCB_CPU();
        loadCB_DongSP();
        loadCB_ManHinh();
        loadCB_NSX();
        loadData();

    }

    void loadData() {
        defaultTableModel = (DefaultTableModel) tbl_sanPham.getModel();
        ArrayList<SanPham> list = sanPhamService.getAll();
        for (SanPham sanPham : list) {
            defaultTableModel.addRow(new Object[]{sanPham.getMaSP(), sanPham.getTenSP(), sanPham.getMauSac(),
                sanPham.getHeDieuHanh(), sanPham.getTrangThai(), sanPham.getGiaNhap(), sanPham.getGiaBan(), sanPham.getSoLuong()});
        }

    }

    void loadCB_DongSP() {
        boxModelDongSP = (DefaultComboBoxModel) cb_DONGSP.getModel();
        boxModelDongSP.removeAllElements();
        ArrayList<DongSP> list = dongSanPhamService.getAll();
        for (DongSP dong : list) {
            boxModelDongSP.addElement(dong);
        }

    }

    void loadCB_RAM() {
        boxModelRam = (DefaultComboBoxModel) cb_Ram.getModel();
        boxModelRam.removeAllElements();
        ArrayList<RAM> list = ramService.getAll();
        for (RAM ram : list) {
            boxModelRam.addElement(ram);
        }

    }

    void loadCB_CPU() {
        boxModelCPU = (DefaultComboBoxModel) cb_CPU.getModel();
        boxModelCPU.removeAllElements();
        ArrayList<CPU> list = cPUService.getAll();
        for (CPU cpu : list) {
            boxModelCPU.addElement(cpu);
        }

    }

    void loadCB_NSX() {
        boxModelNSX = (DefaultComboBoxModel) cb_NSX.getModel();
        boxModelNSX.removeAllElements();
        ArrayList<NSX> list = nSXService.getAllnsx();
        for (NSX nsx : list) {
            boxModelNSX.addElement(nsx);
        }

    }

    void loadCB_ManHinh() {
        boxModelManHinh = (DefaultComboBoxModel) cb_ManHinh.getModel();
        boxModelManHinh.removeAllElements();
        ArrayList<ManHinh> list = hinhService.getAll();
        for (ManHinh mh : list) {
            boxModelManHinh.addElement(mh);
        }

    }

    void addCBMauSac() {// load màu lên cbox
        boxModelMauSac = (DefaultComboBoxModel) cb_mauSac.getModel();
//        List<ChiTietSPViewModel> list = chiTietSPService.getAll();
        HashSet<String> li = chiTietSPService.getmau();

        for (String string : li) {
            boxModelMauSac.addElement(string);
        }

    }

    private void lamMoi() {
        txtMa.setText("");
        txtTenSp.setText("");
        txtNamBH.setText("");
        radConHang.setSelected(true);
        txtHeDH.setText("");
        txtTrongLuong.setText("");
        txtMauSac.setText("");
        txtMoTa.setText("");
        txtXuatXu.setText("");
        txt_giaNhap.setText("");
        txt_giaBan.setText("");
        txt_barcode.setText("");
        txt_soLuong.setText("");
        cb_Ram.setSelectedIndex(0);
        cb_CPU.setSelectedIndex(0);
        cb_DONGSP.setSelectedIndex(0);
        cb_NSX.setSelectedIndex(0);
        cb_ManHinh.setSelectedIndex(0);
    }

    private void fillData(int index) {
        ArrayList<SanPham> listSP = sanPhamService.getAll1();
        txtMa.setText(listSP.get(index).getMaSP());
        txtTenSp.setText(listSP.get(index).getTenSP());
        txtNamBH.setText(String.valueOf(listSP.get(index).getNamBH()));
        txtXuatXu.setText(listSP.get(index).getXuatXu());
        txtMoTa.setText(listSP.get(index).getMoTa());
        txtHeDH.setText(listSP.get(index).getHeDieuHanh());
        txtTrongLuong.setText(String.valueOf(listSP.get(index).getTrongLuong()));
        txtMauSac.setText(listSP.get(index).getMauSac());
        if (listSP.get(index).getTrangThai().equals("Còn Hàng")) {
            radConHang.setSelected(true);
        }
        if (listSP.get(index).getTrangThai().equals("Hết Hàng")) {
            radHetHang.setSelected(true);
        }
        txt_giaNhap.setText(String.valueOf(listSP.get(index).getGiaNhap()));
        txt_giaBan.setText(String.valueOf(listSP.get(index).getGiaBan()));
        txt_soLuong.setText(String.valueOf(listSP.get(index).getSoLuong()));
        txt_barcode.setText(listSP.get(index).getBarCode());

        // hiển thị lên cbdongSP
        String dongSP = listSP.get(index).getMaDongSP();
        ArrayList<DongSP> list = dongSanPhamService.getAll();
        for (int i = 0; i < list.size(); i++) {
            if (dongSP.equals(list.get(i).getMaDSP())) {
                cb_DONGSP.setSelectedIndex(i);
            }
        }

        //hiển thị lên cbRam
        String ram = listSP.get(index).getMaRAM();
        ArrayList<RAM> list1 = ramService.getAll();
        for (int i = 0; i < list1.size(); i++) {
            if (ram.equals(list1.get(i).getMaRam())) {
                cb_Ram.setSelectedIndex(i);
            }
        }
        //hiển thị lên cbNSX 
        String nsx = listSP.get(index).getMaNSX();
        ArrayList<NSX> list2 = nSXService.getAllnsx();
        for (int i = 0; i < list2.size(); i++) {
            if (nsx.equals(list2.get(i).getMansx())) {
                cb_NSX.setSelectedIndex(i);
            }
        }

        //hiển thị lên cbCPU
        String cpu = listSP.get(index).getMaCPU();
        ArrayList<CPU> list3 = cPUService.getAll();
        for (int i = 0; i < list3.size(); i++) {
            if (cpu.equals(list3.get(i).getMaCPU())) {
                cb_CPU.setSelectedIndex(i);
            }
        }
        //hiển thị lên cbManHinh
        String manHinh = listSP.get(index).getMaManHinh();
        ArrayList<ManHinh> list4 = hinhService.getAll();
        for (int i = 0; i < list4.size(); i++) {
            if (manHinh.equals(list4.get(i).getMaMH())) {
                cb_ManHinh.setSelectedIndex(i);
            }
        }

    }

    private void setpanal(JPanel panel) {
        paneTC = panel;
        formThuocTinh.removeAll();
        formThuocTinh.add(paneTC);
        formThuocTinh.validate();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtMa = new javax.swing.JTextField();
        txtTenSp = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        btnThem = new javax.swing.JButton();
        btnSua = new javax.swing.JButton();
        btnXoa = new javax.swing.JButton();
        btnLamMoi = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        txtHeDH = new javax.swing.JTextField();
        txtTrongLuong = new javax.swing.JTextField();
        txtMauSac = new javax.swing.JTextField();
        radConHang = new javax.swing.JRadioButton();
        radHetHang = new javax.swing.JRadioButton();
        jLabel9 = new javax.swing.JLabel();
        txtNamBH = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtXuatXu = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        txtMoTa = new javax.swing.JTextArea();
        cb_DONGSP = new javax.swing.JComboBox<>();
        cb_NSX = new javax.swing.JComboBox<>();
        cb_CPU = new javax.swing.JComboBox<>();
        cb_Ram = new javax.swing.JComboBox<>();
        cb_ManHinh = new javax.swing.JComboBox<>();
        txt_giaNhap = new javax.swing.JTextField();
        txt_giaBan = new javax.swing.JTextField();
        txt_soLuong = new javax.swing.JTextField();
        txt_barcode = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        btnQuetMa = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_sanPham = new javax.swing.JTable();
        jPanel5 = new javax.swing.JPanel();
        txtTimKiem = new javax.swing.JTextField();
        jLabel22 = new javax.swing.JLabel();
        cb_mauSac = new javax.swing.JComboBox<>();
        jPanel2 = new javax.swing.JPanel();
        formThuocTinh = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        rdo_ram = new javax.swing.JRadioButton();
        rdo_cpu = new javax.swing.JRadioButton();
        rdo_nsx = new javax.swing.JRadioButton();
        rdo_dongsp = new javax.swing.JRadioButton();
        rdo_manhinh = new javax.swing.JRadioButton();

        setBackground(new java.awt.Color(255, 255, 255));

        jTabbedPane1.setBackground(new java.awt.Color(255, 255, 255));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(1050, 650));

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Thông tin sản phẩm", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 14))); // NOI18N
        jPanel4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jPanel4MouseEntered(evt);
            }
        });

        jLabel1.setText("Mã sản phẩm :");

        jLabel2.setText("Tên sản phẩm :");

        jLabel6.setText("Trạng thái :");

        txtMa.setEnabled(false);

        jLabel8.setText("Hệ điều hành :");

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        btnThem.setBackground(new java.awt.Color(153, 255, 204));
        btnThem.setText("Thêm");
        btnThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemActionPerformed(evt);
            }
        });

        btnSua.setBackground(new java.awt.Color(153, 255, 204));
        btnSua.setText("Sửa");
        btnSua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaActionPerformed(evt);
            }
        });

        btnXoa.setBackground(new java.awt.Color(153, 255, 204));
        btnXoa.setText("Xóa");
        btnXoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaActionPerformed(evt);
            }
        });

        btnLamMoi.setBackground(new java.awt.Color(153, 255, 204));
        btnLamMoi.setText("Làm mới");
        btnLamMoi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLamMoiActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnLamMoi, javax.swing.GroupLayout.DEFAULT_SIZE, 118, Short.MAX_VALUE)
                    .addComponent(btnSua, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnThem, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnXoa, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(btnThem)
                .addGap(18, 18, 18)
                .addComponent(btnSua)
                .addGap(18, 18, 18)
                .addComponent(btnXoa)
                .addGap(18, 18, 18)
                .addComponent(btnLamMoi)
                .addContainerGap(20, Short.MAX_VALUE))
        );

        jLabel11.setText("Trọng lượng :");

        jLabel12.setText("Màu sắc :");

        radConHang.setBackground(new java.awt.Color(255, 255, 255));
        buttonGroup2.add(radConHang);
        radConHang.setSelected(true);
        radConHang.setText("Còn hàng");

        radHetHang.setBackground(new java.awt.Color(255, 255, 255));
        buttonGroup2.add(radHetHang);
        radHetHang.setText("Hết hàng");

        jLabel9.setText("Năm BH :");

        jLabel3.setText("Xuất xứ :");

        jLabel5.setText("Mô tả :");

        txtMoTa.setColumns(20);
        txtMoTa.setRows(5);
        jScrollPane3.setViewportView(txtMoTa);

        jLabel4.setText("Dòng Sản Phẩm :");

        jLabel7.setText("Nhà Sản Xuất :");

        jLabel10.setText("CPU :");

        jLabel13.setText("RAM : ");

        jLabel14.setText("Màn Hình :");

        jLabel15.setText("Giá Nhập :");

        jLabel16.setText("Giá Bán :");

        jLabel17.setText("BarCode :");

        jLabel18.setText("Số Lượng :");

        btnQuetMa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/qr.png"))); // NOI18N
        btnQuetMa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnQuetMaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane3)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(radConHang)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(radHetHang)
                                .addGap(70, 70, 70))))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtXuatXu)
                            .addComponent(txtNamBH)))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtTenSp))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtMa, javax.swing.GroupLayout.PREFERRED_SIZE, 283, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, 81, Short.MAX_VALUE)
                            .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtTrongLuong)
                            .addComponent(txtHeDH)
                            .addComponent(txtMauSac))))
                .addGap(108, 108, 108)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(cb_DONGSP, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cb_NSX, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cb_CPU, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cb_Ram, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cb_ManHinh, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txt_giaNhap, javax.swing.GroupLayout.DEFAULT_SIZE, 264, Short.MAX_VALUE)
                    .addComponent(txt_giaBan)
                    .addComponent(txt_soLuong)
                    .addComponent(txt_barcode))
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(btnQuetMa)))
                .addGap(60, 60, 60))
        );

        jPanel4Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jLabel1, jLabel11, jLabel12, jLabel2, jLabel3, jLabel5, jLabel6, jLabel9});

        jPanel4Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {cb_CPU, cb_DONGSP, cb_ManHinh, cb_NSX, cb_Ram, txt_barcode, txt_giaBan, txt_giaNhap, txt_soLuong});

        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel1)
                        .addComponent(txtMa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(cb_DONGSP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(txtTenSp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cb_NSX, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9)
                            .addComponent(txtNamBH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(8, 8, 8)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(txtXuatXu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cb_Ram, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel13))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(txtHeDH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cb_ManHinh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel14))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtTrongLuong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel11)
                            .addComponent(txt_giaNhap, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel15))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(txtMauSac, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txt_giaBan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel16))
                            .addComponent(jLabel12))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel6)
                                .addComponent(radConHang))
                            .addComponent(radHetHang)
                            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(txt_soLuong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel18))))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(46, 46, 46)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel10)
                            .addComponent(cb_CPU, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(12, 12, 12)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(txt_barcode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel17)
                    .addComponent(btnQuetMa))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel4Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jLabel1, jLabel11, jLabel12, jLabel2, jLabel3, jLabel5, jLabel6, jLabel8, jLabel9});

        jPanel4Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {cb_CPU, cb_DONGSP, cb_ManHinh, cb_NSX, cb_Ram, txt_barcode, txt_giaBan, txt_giaNhap, txt_soLuong});

        tbl_sanPham.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã", "Tên", "Màu Sắc", "Hệ Điều Hành", "Trạng Thái", "Giá Nhập", "Giá Bán", "Số Lượng"
            }
        ));
        tbl_sanPham.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_sanPhamMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbl_sanPham);

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder("Lọc sản phẩm"));

        txtTimKiem.setText("Tìm kiếm Sản Phẩm theo tên ....");
        txtTimKiem.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtTimKiemMouseClicked(evt);
            }
        });
        txtTimKiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTimKiemActionPerformed(evt);
            }
        });
        txtTimKiem.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtTimKiemKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtTimKiemKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtTimKiemKeyTyped(evt);
            }
        });

        jLabel22.setText("Màu Sắc");

        cb_mauSac.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "All" }));
        cb_mauSac.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cb_mauSacActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(txtTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 349, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel22)
                .addGap(26, 26, 26)
                .addComponent(cb_mauSac, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(109, 109, 109))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel22)
                    .addComponent(cb_mauSac, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jPanel4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 1073, Short.MAX_VALUE)
                    .addComponent(jPanel5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 12, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1012, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(81, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Sản phẩm", jPanel1);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        formThuocTinh.setBackground(new java.awt.Color(255, 255, 255));
        formThuocTinh.setLayout(new java.awt.BorderLayout());

        jPanel8.setBackground(new java.awt.Color(255, 255, 255));
        jPanel8.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        rdo_ram.setBackground(new java.awt.Color(255, 255, 255));
        buttonGroup1.add(rdo_ram);
        rdo_ram.setSelected(true);
        rdo_ram.setText("RAM");
        rdo_ram.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdo_ramActionPerformed(evt);
            }
        });

        rdo_cpu.setBackground(new java.awt.Color(255, 255, 255));
        buttonGroup1.add(rdo_cpu);
        rdo_cpu.setText("CPU");
        rdo_cpu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdo_cpuActionPerformed(evt);
            }
        });

        rdo_nsx.setBackground(new java.awt.Color(255, 255, 255));
        buttonGroup1.add(rdo_nsx);
        rdo_nsx.setText("NSX");
        rdo_nsx.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdo_nsxActionPerformed(evt);
            }
        });

        rdo_dongsp.setBackground(new java.awt.Color(255, 255, 255));
        buttonGroup1.add(rdo_dongsp);
        rdo_dongsp.setText("Dòng SP");
        rdo_dongsp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdo_dongspActionPerformed(evt);
            }
        });

        rdo_manhinh.setBackground(new java.awt.Color(255, 255, 255));
        buttonGroup1.add(rdo_manhinh);
        rdo_manhinh.setText("Màn hình");
        rdo_manhinh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdo_manhinhActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addComponent(rdo_manhinh)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(rdo_ram)
                            .addComponent(rdo_nsx))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 58, Short.MAX_VALUE)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(rdo_dongsp)
                            .addComponent(rdo_cpu))
                        .addGap(16, 16, 16))))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rdo_ram)
                    .addComponent(rdo_cpu))
                .addGap(29, 29, 29)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rdo_nsx)
                    .addComponent(rdo_dongsp))
                .addGap(31, 31, 31)
                .addComponent(rdo_manhinh)
                .addContainerGap(30, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(formThuocTinh, javax.swing.GroupLayout.PREFERRED_SIZE, 755, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37)
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(74, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(formThuocTinh, javax.swing.GroupLayout.DEFAULT_SIZE, 641, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Thuộc tính sản phẩm", jPanel2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void rdo_manhinhActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdo_manhinhActionPerformed
        // TODO add your handling code here:
        setpanal(new ThuocTinhManHinh());
    }//GEN-LAST:event_rdo_manhinhActionPerformed

    private void rdo_dongspActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdo_dongspActionPerformed
        // TODO add your handling code here:
        setpanal(new ThuocTinhDongSP());
    }//GEN-LAST:event_rdo_dongspActionPerformed

    private void rdo_nsxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdo_nsxActionPerformed
        // TODO add your handling code here:
        setpanal(new ThuocTinhNSX());
    }//GEN-LAST:event_rdo_nsxActionPerformed

    private void rdo_cpuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdo_cpuActionPerformed
        // TODO add your handling code here:
        setpanal(new ThuocTinhCPU());
    }//GEN-LAST:event_rdo_cpuActionPerformed

    private void rdo_ramActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdo_ramActionPerformed
        // TODO add your handling code here:
        setpanal(new ThuocTinhRAM());
    }//GEN-LAST:event_rdo_ramActionPerformed

    private void txtTimKiemKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTimKiemKeyTyped
        String ten = "%" + txtTimKiem.getText() + "%";
        ArrayList<SanPham> li = sanPhamService.getAll2(ten);
        defaultTableModel = (DefaultTableModel) tbl_sanPham.getModel();
        defaultTableModel.setRowCount(0);
        for (SanPham sanPham : li) {
            defaultTableModel.addRow(new Object[]{sanPham.getMaSP(), sanPham.getTenSP(), sanPham.getMauSac(),
                sanPham.getHeDieuHanh(), sanPham.getTrangThai(), sanPham.getGiaNhap(), sanPham.getGiaBan(), sanPham.getSoLuong()});
        }
    }//GEN-LAST:event_txtTimKiemKeyTyped

    private void txtTimKiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTimKiemActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTimKiemActionPerformed

    private void tbl_sanPhamMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_sanPhamMouseClicked
        int row = tbl_sanPham.getSelectedRow();
        fillData(row);
    }//GEN-LAST:event_tbl_sanPhamMouseClicked

    private void btnLamMoiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLamMoiActionPerformed
        lamMoi();
    }//GEN-LAST:event_btnLamMoiActionPerformed

    private void btnXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaActionPerformed
        int index = tbl_sanPham.getSelectedRow();
        if (index == -1) {
            JOptionPane.showMessageDialog(this, "Không có dữ liệu !!!");
            return;
        }
        int dem = 0;
        String ma = (String) tbl_sanPham.getValueAt(index, 0);
        //xoá abngr serial
        if (serialServices.xoa(ma) != null) {
            System.out.println("xoá serial ok");
        } else {
            System.out.println("xoá serial !ok");
        }

        // xoá bảng chi tiết SP
        if (sanPhamService.xoaCTSanPham(ma) != null) {
            System.out.println("xoá CTSP OK");
            dem++;
        } else {
            System.out.println("xoá CTSP notOK");
        }

        // xoá bảng SP
        if (sanPhamService.xoaSanPham(ma) != null) {
            dem++;
            System.out.println("xoá SP OK");
        } else {
            System.out.println("xoá SP notOK");
        }
        if (dem == 2) {
            JOptionPane.showMessageDialog(this, "Xoá Thành Công");
        }

        boxModelMauSac.removeAllElements();
        cb_mauSac.addItem("All");
        addCBMauSac();
        defaultTableModel.setRowCount(0);
        loadData();
        lamMoi();

    }//GEN-LAST:event_btnXoaActionPerformed

    private void btnSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaActionPerformed

        int row = tbl_sanPham.getSelectedRow();
        int sLuong = Integer.parseInt(String.valueOf(tbl_sanPham.getValueAt(row, 7)));
        String ma = (String) tbl_sanPham.getValueAt(row, 0);
        SanPham sp = new SanPham();
        sp.setTenSP(txtTenSp.getText());
        sp.setMauSac(txtMauSac.getText());
        sp.setHeDieuHanh(txtHeDH.getText());
        sp.setNamBH(Integer.parseInt(txtNamBH.getText()));
        sp.setTrongLuong((float) Double.parseDouble(txtTrongLuong.getText()));
        sp.setXuatXu(txtXuatXu.getText());

        RAM ram = (RAM) cb_Ram.getSelectedItem();
        sp.setMaRAM(ram.getMaRam());
        DongSP dongSP = (DongSP) cb_DONGSP.getSelectedItem();
        sp.setMaDongSP(dongSP.getMaDSP());
        NSX nsx = (NSX) cb_NSX.getSelectedItem();
        sp.setMaNSX(nsx.getMansx());
        CPU cpu = (CPU) cb_CPU.getSelectedItem();
        sp.setMaCPU(cpu.getMaCPU());
        ManHinh hinh = (ManHinh) cb_ManHinh.getSelectedItem();
        sp.setMaManHinh(hinh.getMaMH());
        sp.setGiaNhap(Double.parseDouble(txt_giaNhap.getText()));
        sp.setGiaBan(Double.parseDouble(txt_giaBan.getText()));
        sp.setSoLuong(Integer.parseInt(txt_soLuong.getText()));
        sp.setBarCode(txt_barcode.getText());
        if (Integer.parseInt(txt_soLuong.getText())>0) {
            sp.setTrangThai("Còn Hàng");
        }
        if (Integer.parseInt(txt_soLuong.getText())<=0) {
            sp.setTrangThai("Hết Hàng");
        }
        sp.setMoTa(txtMoTa.getText());

        int dem = 0;
        if (sLuong > sp.getSoLuong()) {
            int sLuongTam = sLuong - sp.getSoLuong();

            for (int i = 0; i < sLuongTam; i++) {
                if (serialServices.xoaKhiUpdate(ma) != null) {
                    System.out.println("xoá serial ok");
                } else {
                    System.out.println("xoá serial !ok");
                }

            }

        } else if (sLuong < sp.getSoLuong()) {
            int SL = sp.getSoLuong() - sLuong;
            Serial serial = new Serial();
            serial.setMaSP(ma);
            for (int i = 0; i < SL; i++) {
                if (serialServices.them(serial) != null) {
                    System.out.println("them serial ok");
                } else {
                    System.out.println("them serial !ok");
                }

            }

        }

        //update chi tiết sản phẩm
        if (sanPhamService.upDateCTSanPham(sp, ma) != null) {
            System.out.println("update CTSP ok");
            dem++;
        } else {
            System.out.println("update CTSP notok");

        }

        // update sản phẩm
        if (sanPhamService.upDateSanPham(sp, ma) != null) {
            System.out.println("update SP ok");
            dem++;
        } else {
            System.out.println("update SP notok");

        }
        if (dem == 2) {
            JOptionPane.showMessageDialog(this, "Update Thành Công");
        }

        defaultTableModel.setRowCount(0);
        loadData();
        boxModelMauSac.removeAllElements();
        cb_mauSac.addItem("All");
        addCBMauSac();
        lamMoi();
    }//GEN-LAST:event_btnSuaActionPerformed

    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed

        if (kiemTra()) {
            SanPham sp = new SanPham();
            Random rd = new Random();
            String ma = "SP" + rd.nextInt();
            sp.setMaSP(ma);
            sp.setTenSP(txtTenSp.getText());
            sp.setMauSac(txtMauSac.getText());
            sp.setHeDieuHanh(txtHeDH.getText());
            sp.setNamBH(Integer.parseInt(txtNamBH.getText()));
            sp.setTrongLuong((float) Double.parseDouble(txtTrongLuong.getText()));
            sp.setXuatXu(txtXuatXu.getText());

            RAM ram = (RAM) cb_Ram.getSelectedItem();
            sp.setMaRAM(ram.getMaRam());
            DongSP dongSP = (DongSP) cb_DONGSP.getSelectedItem();
            sp.setMaDongSP(dongSP.getMaDSP());
            NSX nsx = (NSX) cb_NSX.getSelectedItem();
            sp.setMaNSX(nsx.getMansx());
            CPU cpu = (CPU) cb_CPU.getSelectedItem();
            sp.setMaCPU(cpu.getMaCPU());
            ManHinh hinh = (ManHinh) cb_ManHinh.getSelectedItem();
            sp.setMaManHinh(hinh.getMaMH());
            sp.setGiaNhap(Double.parseDouble(txt_giaNhap.getText()));
            sp.setGiaBan(Double.parseDouble(txt_giaBan.getText()));
            sp.setSoLuong(Integer.parseInt(txt_soLuong.getText()));
            sp.setBarCode(txt_barcode.getText());
            if (Integer.parseInt(txt_soLuong.getText())>0) {
                sp.setTrangThai("Còn Hàng");
            }
            if (Integer.parseInt(txt_soLuong.getText())==0) {
                sp.setTrangThai("Hết Hàng");
            }
            int dem = 0;
            sp.setMoTa(txtMoTa.getText());
            if (sanPhamService.themSanPham(sp) != null) {
                System.out.println("thêm vào bảng spham ok");
                dem++;
            } else {
                System.out.println("thêm vào bảng spham notok");
            }
            if (sanPhamService.themChiTiet(sp) != null) {
                System.out.println("thêm vào bảng CTspham ok");
                dem++;
            } else {
                System.out.println("thêm vào bảng CTspham notok");
            }
            if (dem == 2) {
                JOptionPane.showMessageDialog(this, "Thêm Thành Công");
            }
            int sLuong = sp.getSoLuong();
            Serial serial = new Serial();
            serial.setMaSP(ma);
            for (int i = 0; i < sLuong; i++) {
                if (serialServices.them(serial) != null) {
                    System.out.println("them serial ok");
                } else {
                    System.out.println("them serial !ok");
                }

            }

            defaultTableModel.setRowCount(0);
            loadData();
            boxModelMauSac.removeAllElements();
            cb_mauSac.addItem("All");
            addCBMauSac();
            lamMoi();
        }
    }//GEN-LAST:event_btnThemActionPerformed

    Boolean kiemTra() {
        if (txtTenSp.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Tên không được trống");
            return false;
        }
        try {
            if (Integer.parseInt(txtTenSp.getText()) >= 0 || Integer.parseInt(txtTenSp.getText()) < 0) {
                JOptionPane.showMessageDialog(this, "Tên không phải là số");
                return false;
            }
        } catch (Exception e) {
        }
        if (txtNamBH.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Năm bảo hành không được trống");
            return false;
        }
        try {
            if (Integer.parseInt(txtNamBH.getText()) <= 0) {
                JOptionPane.showMessageDialog(this, "Số năm không hợp lệ ");
                return false;
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Số năm không hợp lệ");
            return false;
        }
        if (txtXuatXu.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Xuất xứ không được trống");
            return false;
        }
        if (txtHeDH.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Hệ điều hành không được trống");
            return false;
        }
        if (txtTrongLuong.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Trọng lượng không được trống");
            return false;
        }
        try {
            if (Double.parseDouble(txtTrongLuong.getText()) <= 0) {
                JOptionPane.showMessageDialog(this, "Trọng lượng không hợp lệ ");
                return false;
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Trọng lượng không hợp lệ");
            return false;
        }
        if (txtMauSac.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Màu sắc không được trống");
            return false;
        }
        if (txt_giaNhap.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Giá nhập không được trống");
            return false;
        }
        try {
            if (Double.parseDouble(txt_giaNhap.getText()) <= 0) {
                JOptionPane.showMessageDialog(this, "Giá nhập không hợp lệ ");
                return false;
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Giá nhập không hợp lệ");
            return false;
        }
        if (txt_giaBan.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Giá bán không được trống");
            return false;
        }
        try {
            if (Double.parseDouble(txt_giaBan.getText()) <= Double.parseDouble(txt_giaNhap.getText())) {
                JOptionPane.showMessageDialog(this, "Giá bán phải lớn hơn giá nhập");
                return false;
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Giá bán không hợp lệ");
            return false;
        }
        if (txt_soLuong.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Số lượng không được trống");
            return false;
        }
        try {
            if (Double.parseDouble(txt_soLuong.getText()) <= 0) {
                JOptionPane.showMessageDialog(this, "Số lượng không hợp lệ ");
                return false;
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Số lượng không hợp lệ");
            return false;
        }
        if (txt_barcode.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "BarCode không được trống");
            return false;
        }
        try {
            if (Long.parseLong(txt_barcode.getText()) <= 0) {
                JOptionPane.showMessageDialog(this, "BarCode không hợp lệ ");
                return false;
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "BarCode không hợp lệ");
            return false;
        }
        return true;
    }

    private void txtTimKiemKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTimKiemKeyPressed
        // TODO add your handling code here:
        String ten = "%" + txtTimKiem.getText() + "%";
        ArrayList<SanPham> li = sanPhamService.getAll2(ten);
        defaultTableModel = (DefaultTableModel) tbl_sanPham.getModel();
        defaultTableModel.setRowCount(0);
        for (SanPham sanPham : li) {
            defaultTableModel.addRow(new Object[]{sanPham.getMaSP(), sanPham.getTenSP(), sanPham.getMauSac(),
                sanPham.getHeDieuHanh(), sanPham.getTrangThai(), sanPham.getGiaNhap(), sanPham.getGiaBan(), sanPham.getSoLuong()});
        }

    }//GEN-LAST:event_txtTimKiemKeyPressed

    private void txtTimKiemKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTimKiemKeyReleased
        // TODO add your handling code here:
        String ten = "%" + txtTimKiem.getText() + "%";
        ArrayList<SanPham> li = sanPhamService.getAll2(ten);
        defaultTableModel = (DefaultTableModel) tbl_sanPham.getModel();
        defaultTableModel.setRowCount(0);
        for (SanPham sanPham : li) {
            defaultTableModel.addRow(new Object[]{sanPham.getMaSP(), sanPham.getTenSP(), sanPham.getMauSac(),
                sanPham.getHeDieuHanh(), sanPham.getTrangThai(), sanPham.getGiaNhap(), sanPham.getGiaBan(), sanPham.getSoLuong()});
        }

    }//GEN-LAST:event_txtTimKiemKeyReleased

    private void cb_mauSacActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cb_mauSacActionPerformed

        boxModelMauSac = (DefaultComboBoxModel) cb_mauSac.getModel();
        defaultTableModel = (DefaultTableModel) tbl_sanPham.getModel();
        int mau = (int) cb_mauSac.getSelectedIndex();
        //  All là index thứ 0 nên xét mau >0 là rơi vào trường hợp các tên màu 
        if (mau > 0) {
            defaultTableModel.setRowCount(0);
//            ChiTietSPViewModel chiTiet = (ChiTietSPViewModel) cb_mau.getSelectedItem();
            String mau1 = (String) cb_mauSac.getSelectedItem();
            List<SanPham> list1 = sanPhamService.getAll(mau1);
            for (SanPham sanPham : list1) {
                defaultTableModel.addRow(new Object[]{sanPham.getMaSP(), sanPham.getTenSP(), sanPham.getMauSac(),
                    sanPham.getHeDieuHanh(), sanPham.getTrangThai(), sanPham.getGiaNhap(), sanPham.getGiaBan(), sanPham.getSoLuong()});
            }
        } else {// trường hợp nếu ấn All trên cbox
            defaultTableModel.setRowCount(0);
            ArrayList<SanPham> list = sanPhamService.getAll();
            for (SanPham sanPham : list) {
                defaultTableModel.addRow(new Object[]{sanPham.getMaSP(), sanPham.getTenSP(), sanPham.getMauSac(),
                    sanPham.getHeDieuHanh(), sanPham.getTrangThai(), sanPham.getGiaNhap(), sanPham.getGiaBan(), sanPham.getSoLuong()});
            }
        }
    }//GEN-LAST:event_cb_mauSacActionPerformed

    private void txtTimKiemMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtTimKiemMouseClicked
        // TODO add your handling code here:
        txtTimKiem.setText("");
    }//GEN-LAST:event_txtTimKiemMouseClicked

    private void btnQuetMaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnQuetMaActionPerformed
        // TODO add your handling code here:
        new FormThemQR().setVisible(true);
    }//GEN-LAST:event_btnQuetMaActionPerformed

    private void jPanel4MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel4MouseEntered
        // TODO add your handling code here:
        if (getBarCode) {
            txt_barcode.setText(barcode);
            getBarCode = false;
        }
    }//GEN-LAST:event_jPanel4MouseEntered


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnLamMoi;
    private javax.swing.JButton btnQuetMa;
    private javax.swing.JButton btnSua;
    private javax.swing.JButton btnThem;
    private javax.swing.JButton btnXoa;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.JComboBox<String> cb_CPU;
    private javax.swing.JComboBox<String> cb_DONGSP;
    private javax.swing.JComboBox<String> cb_ManHinh;
    private javax.swing.JComboBox<String> cb_NSX;
    private javax.swing.JComboBox<String> cb_Ram;
    private javax.swing.JComboBox<String> cb_mauSac;
    private javax.swing.JPanel formThuocTinh;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JRadioButton radConHang;
    private javax.swing.JRadioButton radHetHang;
    private javax.swing.JRadioButton rdo_cpu;
    private javax.swing.JRadioButton rdo_dongsp;
    private javax.swing.JRadioButton rdo_manhinh;
    private javax.swing.JRadioButton rdo_nsx;
    private javax.swing.JRadioButton rdo_ram;
    private javax.swing.JTable tbl_sanPham;
    private javax.swing.JTextField txtHeDH;
    private javax.swing.JTextField txtMa;
    private javax.swing.JTextField txtMauSac;
    private javax.swing.JTextArea txtMoTa;
    private javax.swing.JTextField txtNamBH;
    private javax.swing.JTextField txtTenSp;
    private javax.swing.JTextField txtTimKiem;
    private javax.swing.JTextField txtTrongLuong;
    private javax.swing.JTextField txtXuatXu;
    private javax.swing.JTextField txt_barcode;
    private javax.swing.JTextField txt_giaBan;
    private javax.swing.JTextField txt_giaNhap;
    private javax.swing.JTextField txt_soLuong;
    // End of variables declaration//GEN-END:variables
}
