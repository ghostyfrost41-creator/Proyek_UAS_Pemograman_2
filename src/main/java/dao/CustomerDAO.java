package dao;

import Koneksi.Koneksi;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class CustomerDAO {

    Connection conn;

    public CustomerDAO() {
        conn = new Koneksi().getConnection();
    }

    // INSERT
    public void insert(String nama, String hp, String alamat) {

        try {

            String sql = "INSERT INTO customer(nama,hp,alamat) VALUES(?,?,?)";

            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1, nama);
            ps.setString(2, hp);
            ps.setString(3, alamat);

            ps.executeUpdate();

            System.out.println("Data berhasil disimpan");

        } catch (Exception e) {
            System.out.println("Insert gagal : " + e.getMessage());
        }
    }

    // UPDATE
    public void update(int id, String nama, String hp, String alamat) {

        try {

            String sql = "UPDATE customer SET nama=?, hp=?, alamat=? WHERE id_cust=?";

            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1, nama);
            ps.setString(2, hp);
            ps.setString(3, alamat);
            ps.setInt(4, id);

            ps.executeUpdate();

            System.out.println("Data berhasil diupdate");

        } catch (Exception e) {
            System.out.println("Update gagal : " + e.getMessage());
        }
    }

    // DELETE
    public void delete(int id) {

        try {

            String sql = "DELETE FROM customer WHERE id_cust=?";

            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setInt(1, id);

            ps.executeUpdate();

            System.out.println("Data berhasil dihapus");

        } catch (Exception e) {
            System.out.println("Delete gagal : " + e.getMessage());
        }
    }

    // DATA KE JTABLE
    public void tampilData(JTable table) {

        DefaultTableModel model = new DefaultTableModel();

        model.addColumn("ID");
        model.addColumn("Nama");
        model.addColumn("HP");
        model.addColumn("Alamat");

        try {

            String sql = "SELECT * FROM customer";

            PreparedStatement ps = conn.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                model.addRow(new Object[]{
                    rs.getInt("id_cust"),
                    rs.getString("nama"),
                    rs.getString("hp"),
                    rs.getString("alamat")
                });
            }

            table.setModel(model);

        } catch (Exception e) {
            System.out.println("Tampil data gagal : " + e.getMessage());
        }
    }
}