package dao;

import Koneksi.Koneksi;
import java.sql.*;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class PesananDAO {

    Connection conn;

    public PesananDAO() {
        conn = new Koneksi().getConnection();
    }

    // SIMPAN PESANAN (HEADER)
    public int simpanPesanan(int idCust,
            String orderDate,
            double totalHarga,
            String status) {

        int idOrder = 0;

        try {

            String sql = "INSERT INTO pesanan(id_cust,order_date,total_harga,status) VALUES(?,?,?,?)";

            PreparedStatement ps = conn.prepareStatement(
                    sql,
                    Statement.RETURN_GENERATED_KEYS);

            ps.setInt(1, idCust);
            ps.setString(2, orderDate);
            ps.setDouble(3, totalHarga);
            ps.setString(4, status);

            ps.executeUpdate();

            ResultSet rs = ps.getGeneratedKeys();

            if (rs.next()) {
                idOrder = rs.getInt(1);
            }

        } catch (Exception e) {
            System.out.println("Simpan pesanan gagal : " + e.getMessage());
        }

        return idOrder;
    }

    // SIMPAN DETAIL PESANAN
    public void simpanDetail(int idOrder,
            int idProduk,
            int quantity,
            int subtotal) {

        try {

            String sql = "INSERT INTO detail_pesanan(id_order,id_produk,quantity,subtotal) VALUES(?,?,?,?)";

            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setInt(1, idOrder);
            ps.setInt(2, idProduk);
            ps.setInt(3, quantity);
            ps.setInt(4, subtotal);

            ps.executeUpdate();

        } catch (Exception e) {
            System.out.println("Simpan detail gagal : " + e.getMessage());
        }
    }

    // HAPUS DETAIL PESANAN
    public void hapusDetail(int idOrder) {

        try {

            String sql = "DELETE FROM detail_pesanan WHERE id_order=?";

            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setInt(1, idOrder);

            ps.executeUpdate();

        } catch (Exception e) {
            System.out.println("Hapus detail gagal : " + e.getMessage());
        }
    }

    // HAPUS PESANAN
    public void deletePesanan(int idOrder) {

        try {

            hapusDetail(idOrder);

            String sql = "DELETE FROM pesanan WHERE id_order=?";

            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setInt(1, idOrder);

            ps.executeUpdate();

        } catch (Exception e) {
            System.out.println("Delete gagal : " + e.getMessage());
        }
    }

    // TAMPIL DATA PESANAN
    public void tampilData(JTable table) {

        DefaultTableModel model = new DefaultTableModel();

        model.addColumn("ID Order");
        model.addColumn("Customer");
        model.addColumn("Tanggal");
        model.addColumn("Total");
        model.addColumn("Status");

        try {

            String sql = """
                SELECT p.id_order,
                       c.nama,
                       p.order_date,
                       p.total_harga,
                       p.status
                FROM pesanan p
                JOIN customer c
                ON p.id_cust = c.id_cust
                """;

            PreparedStatement ps = conn.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                model.addRow(new Object[]{
                    rs.getInt("id_order"),
                    rs.getString("nama"),
                    rs.getDate("order_date"),
                    rs.getDouble("total_harga"),
                    rs.getString("status")
                });
            }

            table.setModel(model);

        } catch (Exception e) {
            System.out.println("Tampil data gagal : " + e.getMessage());
        }
    }
}