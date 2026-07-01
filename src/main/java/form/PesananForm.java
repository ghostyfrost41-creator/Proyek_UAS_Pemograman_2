package form;

import dao.PesananDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import Koneksi.Koneksi;
import javax.swing.table.DefaultTableModel;

public class PesananForm extends javax.swing.JFrame {

    PesananDAO dao = new PesananDAO();
    DefaultTableModel modelKeranjang;
    DefaultTableModel modelPesanan;

    public PesananForm() {
        initComponents();
        setTableKeranjang();
        setTablePesanan();
        getIdCustomer();
        loadCustomer();
        loadProduk();
        dao.tampilData(tablePesanan);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel4 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        lblHarga = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableKeranjang = new javax.swing.JTable();
        btnSimpan = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        btnReset = new javax.swing.JButton();
        btnHapus = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        txtIdPesanan = new javax.swing.JTextField();
        cmbCustomer = new javax.swing.JComboBox<>();
        cmbProduk = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        txtHarga = new javax.swing.JLabel();
        txtQty = new javax.swing.JTextField();
        lblTotalHarga = new javax.swing.JLabel();
        btnTambahKeranjang = new javax.swing.JButton();
        txtTotal = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tablePesanan = new javax.swing.JTable();
        btnKembali2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel4.setBackground(new java.awt.Color(0, 153, 153));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Data Pesanan");

        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Customer :");

        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Produk :");

        lblHarga.setForeground(new java.awt.Color(255, 255, 255));
        lblHarga.setText("Harga :");

        tableKeranjang.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        tableKeranjang.setModel(new javax.swing.table.DefaultTableModel(
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
        tableKeranjang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableKeranjangMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tableKeranjang);

        btnSimpan.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnSimpan.setText("Simpan");
        btnSimpan.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnSimpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSimpanActionPerformed(evt);
            }
        });

        btnReset.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnReset.setText("Reset");
        btnReset.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnReset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResetActionPerformed(evt);
            }
        });

        btnHapus.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnHapus.setText("Hapus");
        btnHapus.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnHapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHapusActionPerformed(evt);
            }
        });

        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("ID Pesanan :");

        txtIdPesanan.setEditable(false);

        cmbCustomer.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cmbCustomer.setSelectedIndex(-1);
        cmbCustomer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbCustomerActionPerformed(evt);
            }
        });

        cmbProduk.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cmbProduk.setSelectedIndex(-1);
        cmbProduk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbProdukActionPerformed(evt);
            }
        });

        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Qty :");

        txtHarga.setForeground(new java.awt.Color(255, 255, 255));

        lblTotalHarga.setForeground(new java.awt.Color(255, 255, 255));
        lblTotalHarga.setText("Total Harga :");

        btnTambahKeranjang.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnTambahKeranjang.setText("Tambah Keranjang");
        btnTambahKeranjang.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnTambahKeranjang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTambahKeranjangActionPerformed(evt);
            }
        });

        txtTotal.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        txtTotal.setForeground(new java.awt.Color(255, 255, 255));

        tablePesanan.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        tablePesanan.setModel(new javax.swing.table.DefaultTableModel(
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
        tablePesanan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablePesananMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tablePesanan);

        btnKembali2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnKembali2.setText("Kembali");
        btnKembali2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnKembali2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnKembali2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                                .addComponent(btnSimpan, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnHapus, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnReset, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(54, 54, 54))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel4Layout.createSequentialGroup()
                                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel4Layout.createSequentialGroup()
                                                .addGap(59, 59, 59)
                                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addComponent(jLabel6)
                                            .addComponent(jLabel3)
                                            .addComponent(jLabel4)
                                            .addComponent(lblHarga)
                                            .addComponent(jLabel7))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                .addComponent(cmbProduk, 0, 224, Short.MAX_VALUE)
                                                .addComponent(cmbCustomer, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                            .addComponent(txtHarga)
                                            .addComponent(txtIdPesanan, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txtQty, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(jPanel4Layout.createSequentialGroup()
                                        .addComponent(lblTotalHarga)
                                        .addGap(18, 18, 18)
                                        .addComponent(txtTotal))
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 464, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel4Layout.createSequentialGroup()
                                        .addComponent(btnTambahKeranjang, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(26, 26, 26)
                                        .addComponent(btnKembali2, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 464, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(131, 131, 131)
                        .addComponent(jLabel1)))
                .addGap(120, 120, 120))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtIdPesanan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(cmbCustomer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(30, 30, 30)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(cmbProduk, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblHarga)
                            .addComponent(txtHarga))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(txtQty, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(143, 143, 143)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(36, 36, 36)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnTambahKeranjang, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnKembali2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTotalHarga)
                    .addComponent(txtTotal))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSimpan, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnHapus, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnReset, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(39, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 518, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private int getIdCustomer() {

        int id = 0;

        try {

            Connection conn = new Koneksi().getConnection();

            String sql
                    = "SELECT id_cust FROM customer WHERE nama=?";

            PreparedStatement ps
                    = conn.prepareStatement(sql);

            ps.setString(
                    1,
                    cmbCustomer.getSelectedItem().toString()
            );

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {

                id = rs.getInt("id_cust");
            }

        } catch (Exception e) {

            System.out.println(e.getMessage());
        }

        return id;
    }

    private void loadCustomer() {

        cmbCustomer.removeAllItems();

        try {

            String sql = "SELECT nama FROM customer";

            Connection conn = new Koneksi().getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                cmbCustomer.addItem(
                        rs.getString("nama")
                );
            }

        } catch (Exception e) {

            System.out.println(e.getMessage());
        }
    }

    private void loadProduk() {

        cmbProduk.removeAllItems();

        try {

            String sql = "SELECT nama_produk FROM produk";

            Connection conn = new Koneksi().getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                cmbProduk.addItem(
                        rs.getString("nama_produk")
                );
            }

        } catch (Exception e) {

            System.out.println(e.getMessage());
        }
    }

    private void setTableKeranjang() {

        modelKeranjang = new DefaultTableModel();

        modelKeranjang.addColumn("Produk");
        modelKeranjang.addColumn("Harga");
        modelKeranjang.addColumn("Qty");
        modelKeranjang.addColumn("Subtotal");

        tableKeranjang.setModel(modelKeranjang);
    }

    private void setTablePesanan() {

        modelPesanan = new DefaultTableModel();

        modelPesanan.addColumn("ID Order");
        modelPesanan.addColumn("Customer");
        modelPesanan.addColumn("Tanggal");
        modelPesanan.addColumn("Total");
        modelPesanan.addColumn("Status");

        tablePesanan.setModel(modelPesanan);
    }

    private void hitungTotal() {

        int total = 0;

        for (int i = 0; i < tableKeranjang.getRowCount(); i++) {

            total += Integer.parseInt(
                    tableKeranjang.getValueAt(i, 3).toString()
            );
        }

        txtTotal.setText(String.valueOf(total));
    }

    private void btnSimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSimpanActionPerformed
        try {

            int idCust = getIdCustomer();

            double totalHarga
                    = Double.parseDouble(txtTotal.getText());

            dao.simpanPesanan(
                    idCust,
                    new java.sql.Date(
                            System.currentTimeMillis()
                    ).toString(),
                    totalHarga,
                    "Diproses"
            );

            javax.swing.JOptionPane.showMessageDialog(
                    this,
                    "Pesanan berhasil disimpan"
            );

            dao.tampilData(tablePesanan);

        } catch (Exception e) {

            javax.swing.JOptionPane.showMessageDialog(
                    this,
                    e.getMessage()
            );
        }
    }//GEN-LAST:event_btnSimpanActionPerformed

    private void btnResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResetActionPerformed
        txtIdPesanan.setText("");

        if (cmbCustomer.getItemCount() > 0) {
            cmbCustomer.setSelectedIndex(0);
        }

        if (cmbProduk.getItemCount() > 0) {
            cmbProduk.setSelectedIndex(0);
        }

        txtQty.setText("");

        txtHarga.setText("");

        txtTotal.setText("");

        DefaultTableModel model
                = (DefaultTableModel) tableKeranjang.getModel();

        model.setRowCount(0);
    }//GEN-LAST:event_btnResetActionPerformed

    private void btnHapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHapusActionPerformed
        try {

            int konfirmasi
                    = javax.swing.JOptionPane.showConfirmDialog(
                            this,
                            "Yakin ingin menghapus pesanan?",
                            "Konfirmasi",
                            javax.swing.JOptionPane.YES_NO_OPTION
                    );

            if (konfirmasi == javax.swing.JOptionPane.YES_OPTION) {

                dao.deletePesanan(
                        Integer.parseInt(
                                txtIdPesanan.getText()
                        )
                );

                javax.swing.JOptionPane.showMessageDialog(
                        this,
                        "Data berhasil dihapus"
                );

                dao.tampilData(tablePesanan);

                btnResetActionPerformed(null);
            }

        } catch (Exception e) {

            javax.swing.JOptionPane.showMessageDialog(
                    this,
                    e.getMessage()
            );
        }
    }//GEN-LAST:event_btnHapusActionPerformed

    private void tableKeranjangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableKeranjangMouseClicked
        int row = tableKeranjang.getSelectedRow();

        cmbProduk.setSelectedItem(
                tableKeranjang.getValueAt(row, 0).toString()
        );

        txtQty.setText(
                tableKeranjang.getValueAt(row, 2).toString()
        );
    }//GEN-LAST:event_tableKeranjangMouseClicked

    private void btnTambahKeranjangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTambahKeranjangActionPerformed
        String produk
                = cmbProduk.getSelectedItem().toString();

        int harga
                = Integer.parseInt(txtHarga.getText());

        int qty
                = Integer.parseInt(txtQty.getText());

        int subtotal = harga * qty;

        modelKeranjang.addRow(new Object[]{
            produk,
            harga,
            qty,
            subtotal
        });

        hitungTotal();

        txtQty.setText("");
    }//GEN-LAST:event_btnTambahKeranjangActionPerformed

    private void tablePesananMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablePesananMouseClicked
        int row = tablePesanan.getSelectedRow();

        txtIdPesanan.setText(
                tablePesanan.getValueAt(row, 0).toString()
        );
    }//GEN-LAST:event_tablePesananMouseClicked

    private void cmbProdukActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbProdukActionPerformed

        if (cmbProduk.getSelectedItem() == null) {
            return;
        }

        try {

            Connection conn = new Koneksi().getConnection();

            String sql
                    = "SELECT harga FROM produk WHERE nama_produk=?";

            PreparedStatement ps
                    = conn.prepareStatement(sql);

            ps.setString(1,
                    cmbProduk.getSelectedItem().toString());

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {

                txtHarga.setText(
                        rs.getString("harga")
                );
            }

        } catch (Exception e) {

            System.out.println(e.getMessage());
        }
    }//GEN-LAST:event_cmbProdukActionPerformed

    private void btnKembali2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnKembali2ActionPerformed
        new MenuUtama().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnKembali2ActionPerformed

    private void cmbCustomerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbCustomerActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbCustomerActionPerformed

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
            java.util.logging.Logger.getLogger(PesananForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PesananForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PesananForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PesananForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PesananForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnHapus;
    private javax.swing.JButton btnKembali2;
    private javax.swing.JButton btnReset;
    private javax.swing.JButton btnSimpan;
    private javax.swing.JButton btnTambahKeranjang;
    private javax.swing.JComboBox<String> cmbCustomer;
    private javax.swing.JComboBox<String> cmbProduk;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel lblHarga;
    private javax.swing.JLabel lblTotalHarga;
    private javax.swing.JTable tableKeranjang;
    private javax.swing.JTable tablePesanan;
    private javax.swing.JLabel txtHarga;
    private javax.swing.JTextField txtIdPesanan;
    private javax.swing.JTextField txtQty;
    private javax.swing.JLabel txtTotal;
    // End of variables declaration//GEN-END:variables
}
