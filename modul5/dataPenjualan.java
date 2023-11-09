/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package modul5;

import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ASUS
 */
public class dataPenjualan extends javax.swing.JFrame {
    private boolean EditMode = false;
    
    
    public dataPenjualan() {
        initComponents();
        autonumber();
        tampilData();
        tambahDropdown();
        tabelHistory();
    }
    public void clear(){
        txtNamabarang.setText("");
        txtHargabarang.setText("");
    }
    
    public void clearPembeli(){
        dropdown.setSelectedIndex(0);
        txtKode.setText("");
        txtHarga.setText("");
        txtNama.setText("");
        txtJumlah.setText("");
        txtTotal.setText("");
        txtBayar.setText("");
        txtKembalian.setText("");
    }
    public void keyTyped(KeyEvent e) {
        char karakter = e.getKeyChar();
        if (!((karakter >= '0' && karakter <= '9') || (karakter == KeyEvent.VK_BACK_SPACE) || (karakter == KeyEvent.VK_DELETE))) {
            e.consume(); 
        }
    }
    private void autonumber(){
        try{
            Connection c = Koneksi.getKoneksi();
            Statement s = c.createStatement();
            String sql = "SELECT * FROM databarang ORDER BY kode_barang DESC LIMIT 1"; 
            ResultSet r = s.executeQuery(sql);
            if (r.next()) {
                String NoID = r.getString("kode_barang").substring(2);
                int ID = Integer.parseInt(NoID) + 1; 
                String IDString = String.format("%03d", ID); 
                txtKodebarang.setText("AD" + IDString);
            } else {
                txtKodebarang.setText("AD001");
            }
            r.close();
            s.close();
        } catch(Exception e) {
            System.out.println("autonumber error");
        }
    }


    
    public void tambahDropdown() {
        dropdown.removeAllItems();
        
        try {
            dropdown.addItem("");
            Connection c = Koneksi.getKoneksi();
            Statement s = c.createStatement();
            String sql = "SELECT nama_barang FROM databarang";
            ResultSet r = s.executeQuery(sql);

            while (r.next()) {
                String namaBarang = r.getString("nama_barang");
                dropdown.addItem(namaBarang);
            }

            s.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void tabelHistory(){
        DefaultTableModel tbl = new DefaultTableModel();
        tbl.addColumn("Pembeli");
        tbl.addColumn("Barang");
        tbl.addColumn("Kode");
        tbl.addColumn("Harga");
        tbl.addColumn("Jumlah");
        tbl.addColumn("Harga Total");
        tbl.addColumn("Uang");
        tbl.addColumn("Kembalian");
        
        history.setModel(tbl);
        try{
            Connection c = Koneksi.getKoneksi();
            Statement s = c.createStatement();
            String sql = "SELECT * FROM datapembeli";
            ResultSet r = s.executeQuery(sql);
            
            while (r.next()){
                tbl.addRow(new Object[]{
                    r.getString("nama_pembeli"),
                    r.getString("nama_barang"),
                    r.getString("kode_barang"),
                    r.getString("harga_barang"),
                    r.getString("jumlah_beli"),
                    r.getString("harga_total"),
                    r.getString("uang_pembeli"),
                    r.getString("kembalian"),
                });
                history.setModel(tbl);
            }
        }catch(SQLException e){
            e.printStackTrace();
        }

    }
    public void tampilData(){
        DefaultTableModel tabel = new DefaultTableModel();
        tabel.addColumn("kode");
        tabel.addColumn("barang");
        tabel.addColumn("harga");
        
        jTabel.setModel(tabel); 
        try {
            Connection c = Koneksi.getKoneksi();
            Statement s = c.createStatement();
            String sql = "SELECT * FROM databarang";
            ResultSet r = s.executeQuery(sql);
            
            while (r.next()) {
                tabel.addRow( new Object[] {
                    r.getString("kode_barang"),
                    r.getString("nama_barang"),
                    r.getString("harga_barang")
                });
                //Dropdown.addElement(rs.getString("nama_barang"));
                jTabel.setModel(tabel);
            }
        } catch (Exception e) {
            e.printStackTrace();
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

        jInternalFrame1 = new javax.swing.JInternalFrame();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        history = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        dropdown = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        txtKode = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtHarga = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtNama = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtJumlah = new javax.swing.JTextField();
        txtTotal = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtBayar = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txtKembalian = new javax.swing.JTextField();
        btnCek = new javax.swing.JButton();
        btnBayar = new javax.swing.JButton();
        btnSimpanPembeli = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        btnHapusPembeli = new javax.swing.JButton();
        btnReset = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        txtNamabarang = new javax.swing.JTextField();
        txtKodebarang = new javax.swing.JTextField();
        txtHargabarang = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTabel = new javax.swing.JTable();
        btnSimpan = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        btnHapus = new javax.swing.JButton();
        jLabel14 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jInternalFrame1.setVisible(true);

        jPanel2.setBackground(new java.awt.Color(0, 255, 255));

        history.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4", "Title 5", "Title 6", "Title 7", "Title 8"
            }
        ));
        history.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                historyMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(history);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("MAU BELI APA KAK ?");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel2.setText("Pilih Barang");

        dropdown.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        dropdown.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dropdownActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel3.setText("Kode Barang");

        txtKode.setEditable(false);
        txtKode.setForeground(new java.awt.Color(153, 153, 153));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel4.setText("Harga Barang");

        txtHarga.setEditable(false);
        txtHarga.setForeground(new java.awt.Color(153, 153, 153));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel5.setText("Nama Pembeli");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel6.setText("Jumlah Beli");

        txtJumlah.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtJumlahKeyTyped(evt);
            }
        });

        txtTotal.setEditable(false);
        txtTotal.setForeground(new java.awt.Color(153, 153, 153));
        txtTotal.setText("Klik Button disamping");
        txtTotal.setRequestFocusEnabled(false);

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel7.setText("Total Harga");

        txtBayar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtBayarKeyTyped(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel8.setText("Uang Pembeli");

        txtKembalian.setEditable(false);
        txtKembalian.setForeground(new java.awt.Color(153, 153, 153));
        txtKembalian.setRequestFocusEnabled(false);

        btnCek.setBackground(new java.awt.Color(153, 255, 102));
        btnCek.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnCek.setText("Cek Harga");
        btnCek.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCekActionPerformed(evt);
            }
        });

        btnBayar.setBackground(new java.awt.Color(153, 255, 102));
        btnBayar.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnBayar.setText("Bayar");
        btnBayar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBayarActionPerformed(evt);
            }
        });

        btnSimpanPembeli.setBackground(new java.awt.Color(51, 255, 0));
        btnSimpanPembeli.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnSimpanPembeli.setForeground(new java.awt.Color(255, 255, 255));
        btnSimpanPembeli.setText("SIMPAN DATA");
        btnSimpanPembeli.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSimpanPembeliActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 8, Short.MAX_VALUE)
        );

        jLabel15.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel15.setText("Kembalian");

        btnHapusPembeli.setBackground(new java.awt.Color(255, 51, 51));
        btnHapusPembeli.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnHapusPembeli.setForeground(new java.awt.Color(255, 255, 255));
        btnHapusPembeli.setText("HAPUS");
        btnHapusPembeli.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHapusPembeliActionPerformed(evt);
            }
        });

        btnReset.setBackground(new java.awt.Color(204, 204, 204));
        btnReset.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnReset.setText("Reset Form");
        btnReset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResetActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 696, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 621, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(31, 31, 31)
                                .addComponent(dropdown, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(txtNama, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(44, 44, 44)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(jLabel7)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtHarga))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addGap(27, 27, 27)
                                .addComponent(txtKode, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(44, 44, 44)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel15)
                            .addComponent(jLabel8))))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtJumlah)
                            .addComponent(txtTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnCek))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtKembalian, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(txtBayar, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnBayar, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(18, 18, 18))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(122, 122, 122)
                .addComponent(btnSimpanPembeli)
                .addGap(70, 70, 70)
                .addComponent(btnHapusPembeli, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(56, 56, 56)
                .addComponent(btnReset)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtNama, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel6)
                        .addComponent(txtJumlah, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(jLabel5)))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(dropdown, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel7))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnCek))))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtKode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtBayar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8)
                            .addComponent(btnBayar)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(jLabel3)))
                .addGap(17, 17, 17)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtHarga, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel4))
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtKembalian, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel15)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(11, 11, 11)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnHapusPembeli)
                    .addComponent(btnReset, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSimpanPembeli, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(17, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("PENJUALAN", jPanel2);

        jPanel1.setBackground(new java.awt.Color(0, 255, 255));

        txtKodebarang.setEditable(false);
        txtKodebarang.setForeground(new java.awt.Color(153, 153, 153));

        txtHargabarang.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtHargabarangKeyTyped(evt);
            }
        });

        jTabel.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTabelMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTabel);

        btnSimpan.setBackground(new java.awt.Color(51, 255, 0));
        btnSimpan.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnSimpan.setForeground(new java.awt.Color(255, 255, 255));
        btnSimpan.setText("Simpan");
        btnSimpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSimpanActionPerformed(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel10.setText("Nama Barang");

        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel11.setText("Kode Barang");

        jLabel12.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel12.setText("Harga Barang");

        btnHapus.setBackground(new java.awt.Color(255, 0, 51));
        btnHapus.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnHapus.setForeground(new java.awt.Color(255, 255, 255));
        btnHapus.setText("Hapus");
        btnHapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHapusActionPerformed(evt);
            }
        });

        jLabel14.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel14.setText("-- INI BUAT LIHAT, EDIT, HAPUS BARANG YA --");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 8, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 41, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 615, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(185, 185, 185)
                        .addComponent(btnSimpan, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(46, 46, 46)
                        .addComponent(btnHapus, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(40, 40, 40))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(198, 198, 198)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel11)
                    .addComponent(jLabel10)
                    .addComponent(jLabel12))
                .addGap(26, 26, 26)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtNamabarang)
                    .addComponent(txtKodebarang)
                    .addComponent(txtHargabarang, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(jLabel14)
                .addGap(18, 18, 18)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNamabarang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtKodebarang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtHargabarang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 39, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSimpan)
                    .addComponent(btnHapus))
                .addGap(26, 26, 26))
        );

        jTabbedPane1.addTab("DATA BARANG", jPanel1);

        javax.swing.GroupLayout jInternalFrame1Layout = new javax.swing.GroupLayout(jInternalFrame1.getContentPane());
        jInternalFrame1.getContentPane().setLayout(jInternalFrame1Layout);
        jInternalFrame1Layout.setHorizontalGroup(
            jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jInternalFrame1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1))
        );
        jInternalFrame1Layout.setVerticalGroup(
            jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jInternalFrame1, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jInternalFrame1, javax.swing.GroupLayout.Alignment.TRAILING)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSimpanActionPerformed
        String namabarang = txtNamabarang.getText();
        String kodebarang = txtKodebarang.getText();
        String hargabarang = txtHargabarang.getText();
        
        if(EditMode){
            try{
                Connection c = Koneksi.getKoneksi();
                String sql = "UPDATE databarang SET kode_barang=?,nama_barang=?, harga_barang=? WHERE kode_barang=?";

                PreparedStatement p = c.prepareStatement(sql);
                p.setString(1, kodebarang);
                p.setString(2, namabarang);
                p.setString(3, hargabarang);
                p.setString(4, kodebarang);
                p.executeUpdate();
                p.close();
                JOptionPane.showMessageDialog(null, "Data Berhasil Diubah ");
                tampilData();
            }catch(SQLException e){
                e.printStackTrace();
            }
            EditMode = false;
            btnSimpan.setText("Simpan");
        }else{
            try{
                Connection c = Koneksi.getKoneksi();
                String sql = "INSERT INTO databarang (kode_barang,nama_barang,harga_barang ) VALUES (?, ?,?)";

                PreparedStatement p = c.prepareStatement(sql);
                p.setString(1, kodebarang);
                p.setString(2, namabarang);
                p.setString(3, hargabarang);
                p.executeUpdate();
                p.close();
                JOptionPane.showMessageDialog(null, "Data Berhasil Ditambahkan ");
            }catch(SQLException e){
                e.printStackTrace();
            }
        }
        clear();
        tampilData();
        tambahDropdown();
        autonumber();
    }//GEN-LAST:event_btnSimpanActionPerformed

    private void jTabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTabelMouseClicked
        DefaultTableModel model = (DefaultTableModel) jTabel.getModel();
        int selectedRow = jTabel.getSelectedRow();

        if (selectedRow >= 0) {
            txtNamabarang.setText(model.getValueAt(selectedRow, 1).toString());
            txtKodebarang.setText(model.getValueAt(selectedRow, 0).toString());
            txtHargabarang.setText(model.getValueAt(selectedRow, 2).toString());
            EditMode = true; // Set mode pengeditan
            btnSimpan.setText("Edit"); // Ubah teks tombol menjadi "Edit"
        }
    }//GEN-LAST:event_jTabelMouseClicked

    private void btnHapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHapusActionPerformed
        int selectedRow = jTabel.getSelectedRow();
        
        if (selectedRow >= 0) {
        String kode_barang = jTabel.getValueAt(selectedRow, 0).toString();
            try {
                Connection c = Koneksi.getKoneksi();
                String sql = "DELETE FROM databarang WHERE kode_barang = ?";
                PreparedStatement p = c.prepareStatement(sql);
                p.setString(1, kode_barang);
                p.executeUpdate();
                p.close();
                JOptionPane.showMessageDialog(null, "Data berhasil dihapus");
                clear();
                tampilData(); 
                tambahDropdown();
                
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else {
            JOptionPane.showMessageDialog(null, "Pilih data yang ingin dihapus");
        }
    }//GEN-LAST:event_btnHapusActionPerformed

    private void dropdownActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dropdownActionPerformed
        String selectedBarang = dropdown.getSelectedItem() != null ? dropdown.getSelectedItem().toString() : "";

        if (!selectedBarang.isEmpty()) {
            try {
                Connection c = Koneksi.getKoneksi();
                String sql = "SELECT kode_barang, harga_barang FROM databarang WHERE nama_barang=?";
                PreparedStatement p = c.prepareStatement(sql);
                p.setString(1, selectedBarang);
                ResultSet r = p.executeQuery();

                if (r.next()) {
                    txtKode.setText(r.getString("kode_barang"));
                    txtHarga.setText(r.getString("harga_barang"));
                }

                p.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else {
            txtKode.setText("");
            txtHarga.setText("");
        }
    }//GEN-LAST:event_dropdownActionPerformed

    private void txtHargabarangKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtHargabarangKeyTyped
        keyTyped(evt);
    }//GEN-LAST:event_txtHargabarangKeyTyped

    private void btnCekActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCekActionPerformed
        String barang = dropdown.getSelectedItem().toString();
        String kode = txtKode.getText();
        String nama = txtNama.getText();
        String jumlah = txtJumlah.getText();
        String harga = txtHarga.getText();
                if(barang.isEmpty()||kode.isEmpty()||harga.isEmpty()||nama.isEmpty()||jumlah.isEmpty()){
                    JOptionPane.showMessageDialog(null, "Isi semuanya");
                }else{
                    int price = Integer.parseInt(harga);
                    int count = Integer.parseInt(txtJumlah.getText());
                    int total = price*count;
                    String finalPrice = Integer.toString(total);
                    txtTotal.setText(finalPrice);
                }
    }//GEN-LAST:event_btnCekActionPerformed

    private void btnBayarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBayarActionPerformed
        String price = txtTotal.getText();
        int harga = Integer.parseInt(price);
        String biaya = txtBayar.getText();

        if (biaya != null && !biaya.isEmpty()) { // Mengecek apakah biaya tidak kosong
            int cost = Integer.parseInt(biaya);

            if (cost < 0) {
                JOptionPane.showMessageDialog(null, "Masukkan uang yang benar");
            } else {
                if(cost < harga){
                    JOptionPane.showMessageDialog(null, "uang kurang");
                }else if(cost == harga){
                    txtKembalian.setText("0");
                }
                else{
                    int kembalian = cost - harga;
                    String sisa = Integer.toString(kembalian);
                    txtKembalian.setText(sisa);
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "Masukkan uang pembeli");
        }

        
    }//GEN-LAST:event_btnBayarActionPerformed

    private void txtJumlahKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtJumlahKeyTyped
        keyTyped(evt);
    }//GEN-LAST:event_txtJumlahKeyTyped

    private void txtBayarKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBayarKeyTyped
        keyTyped(evt);
    }//GEN-LAST:event_txtBayarKeyTyped

    private void btnSimpanPembeliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSimpanPembeliActionPerformed
        String barang = dropdown.getSelectedItem().toString();
        String kode = txtKode.getText();
        String harga = txtHarga.getText();
        String nama = txtNama.getText();
        String jumlah = txtJumlah.getText();
        String total = txtTotal.getText();
        String bayar = txtBayar.getText();
        String kembalian = txtKembalian.getText();
        
        
        
        if(barang.isEmpty()||kode.isEmpty()||harga.isEmpty()||nama.isEmpty()||jumlah.isEmpty()||total.isEmpty()||bayar.isEmpty()||kembalian.isEmpty()){
            JOptionPane.showMessageDialog(null, "Isi semuanya dulu");
            
        }else{
            if(EditMode){
                try{
                    Connection c = Koneksi.getKoneksi();
                    String sql = "UPDATE datapembeli SET "
                            + "nama_pembeli=?,"
                            + "nama_barang=?, "
                            + "kode_barang=?,"
                            + "harga_barang=?,"
                            + "jumlah_beli=?,"
                            + "harga_total=?,"
                            + "uang_pembeli=?,"
                            + "kembalian=? WHERE kode_barang=?";

                    PreparedStatement p = c.prepareStatement(sql);
                    p.setString(1, nama);
                    p.setString(2, barang);
                    p.setString(3, kode);
                    p.setString(4, harga);
                    p.setString(5, jumlah);
                    p.setString(6, total);
                    p.setString(7, bayar);
                    p.setString(8, kembalian);
                    p.setString(9, kode);

                    p.executeUpdate();
                    p.close();
                    JOptionPane.showMessageDialog(null, "Data Berhasil Diubah ");
                    clearPembeli();
                    tabelHistory();
                    
                }catch(SQLException e){
                    e.printStackTrace();
                }
                
                btnSimpanPembeli.setText("Simpan");
                EditMode = false;
            }else{
                try{
                    Connection c = Koneksi.getKoneksi();
                    String sql = "INSERT INTO datapembeli VALUES (?,?,?,?,?,?,?,?)";
                    PreparedStatement p = c.prepareStatement(sql);
                    p.setString(1, nama);
                    p.setString(2, barang);
                    p.setString(3, kode);
                    p.setString(4, harga);
                    p.setString(5, jumlah);
                    p.setString(6, total);
                    p.setString(7, bayar);
                    p.setString(8, kembalian);
                    p.executeUpdate();
                    p.close();
                    clearPembeli();
                    tabelHistory();
                    JOptionPane.showMessageDialog(null, "Data Berhasil Ditambahkan ");
                }catch(SQLException e){
                    e.printStackTrace();
                }
            }
        }
    }//GEN-LAST:event_btnSimpanPembeliActionPerformed

    private void historyMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_historyMouseClicked
        DefaultTableModel model = (DefaultTableModel) history.getModel();
        int selectedRow = history.getSelectedRow();

        if (selectedRow >= 0) {
            txtNama.setText(model.getValueAt(selectedRow, 0).toString());
            dropdown.setSelectedItem(model.getValueAt(selectedRow, 1).toString());
            txtKode.setText(model.getValueAt(selectedRow, 2).toString());
            txtHarga.setText(model.getValueAt(selectedRow, 3).toString());
            txtJumlah.setText(model.getValueAt(selectedRow, 4).toString());
            txtBayar.setText(model.getValueAt(selectedRow, 6).toString());

            EditMode = true; 
            btnSimpanPembeli.setText("Edit"); 
        }
    }//GEN-LAST:event_historyMouseClicked

    private void btnHapusPembeliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHapusPembeliActionPerformed
        int selectedRow = history.getSelectedRow();
        
        if (selectedRow >= 0) {
        String nama = history.getValueAt(selectedRow, 0).toString();
            try {
                Connection c = Koneksi.getKoneksi();
                String sql = "DELETE FROM datapembeli WHERE nama_pembeli = ?";
                PreparedStatement p = c.prepareStatement(sql);
                p.setString(1, nama);
                p.executeUpdate();
                p.close();
                JOptionPane.showMessageDialog(null, "Data berhasil dihapus");
                clearPembeli();
                tabelHistory(); 
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else {
            JOptionPane.showMessageDialog(null, "Pilih data yang ingin dihapus");
        }
    }//GEN-LAST:event_btnHapusPembeliActionPerformed

    private void btnResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResetActionPerformed
        clearPembeli();
    }//GEN-LAST:event_btnResetActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(dataPenjualan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(dataPenjualan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(dataPenjualan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(dataPenjualan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new dataPenjualan().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBayar;
    private javax.swing.JButton btnCek;
    private javax.swing.JButton btnHapus;
    private javax.swing.JButton btnHapusPembeli;
    private javax.swing.JButton btnReset;
    private javax.swing.JButton btnSimpan;
    private javax.swing.JButton btnSimpanPembeli;
    private javax.swing.JComboBox<String> dropdown;
    private javax.swing.JTable history;
    private javax.swing.JInternalFrame jInternalFrame1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTabel;
    private javax.swing.JTextField txtBayar;
    private javax.swing.JTextField txtHarga;
    private javax.swing.JTextField txtHargabarang;
    private javax.swing.JTextField txtJumlah;
    private javax.swing.JTextField txtKembalian;
    private javax.swing.JTextField txtKode;
    private javax.swing.JTextField txtKodebarang;
    private javax.swing.JTextField txtNama;
    private javax.swing.JTextField txtNamabarang;
    private javax.swing.JTextField txtTotal;
    // End of variables declaration//GEN-END:variables
}
