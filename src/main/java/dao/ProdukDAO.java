package dao;

import Koneksi.Koneksi;
import java.sql.*;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class ProdukDAO {

    Connection conn;

    public ProdukDAO() {
        conn = new Koneksi().getConnection();
    }

    public void insert(String namaProduk,
            int harga,
            String deskripsi) {

        try {

            String sql
                    = "INSERT INTO produk(nama_produk,harga,deskripsi) VALUES(?,?,?)";

            PreparedStatement ps
                    = conn.prepareStatement(sql);

            ps.setString(1, namaProduk);
            ps.setInt(2, harga);
            ps.setString(3, deskripsi);

            ps.executeUpdate();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void update(int idProduk,
            String namaProduk,
            int harga,
            String deskripsi) {

        try {

            String sql
                    = "UPDATE produk SET nama_produk=?, harga=?, deskripsi=? WHERE id_produk=?";

            PreparedStatement ps
                    = conn.prepareStatement(sql);

            ps.setString(1, namaProduk);
            ps.setInt(2, harga);
            ps.setString(3, deskripsi);
            ps.setInt(4, idProduk);

            ps.executeUpdate();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void delete(int idProduk) {

        try {

            String sql
                    = "DELETE FROM produk WHERE id_produk=?";

            PreparedStatement ps
                    = conn.prepareStatement(sql);

            ps.setInt(1, idProduk);

            ps.executeUpdate();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void tampilData(JTable table) {

        DefaultTableModel model
                = new DefaultTableModel();

        model.addColumn("ID");
        model.addColumn("Nama Produk");
        model.addColumn("Harga");
        model.addColumn("Deskripsi");

        try {

            String sql = "SELECT * FROM produk";

            PreparedStatement ps
                    = conn.prepareStatement(sql);

            ResultSet rs
                    = ps.executeQuery();

            while (rs.next()) {

                model.addRow(new Object[]{
                    rs.getInt("id_produk"),
                    rs.getString("nama_produk"),
                    rs.getInt("harga"),
                    rs.getString("deskripsi")
                });
            }

            table.setModel(model);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
