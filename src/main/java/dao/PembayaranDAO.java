package DAO;

import Koneksi.Koneksi;
import java.sql.*;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class PembayaranDAO {

    Connection conn;

    public PembayaranDAO() {
        conn = new Koneksi().getConnection();
    }

    public void insert(int idOrder,
            String paymentDate,
            double amount,
            String paymentMethod) {

        try {

            String sql =
                    "INSERT INTO pembayaran(id_order,payment_date,amount,payment_method) VALUES(?,?,?,?)";

            PreparedStatement ps =
                    conn.prepareStatement(sql);

            ps.setInt(1, idOrder);
            ps.setString(2, paymentDate);
            ps.setDouble(3, amount);
            ps.setString(4, paymentMethod);

            ps.executeUpdate();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void update(int idPay,
            int idOrder,
            String paymentDate,
            double amount,
            String paymentMethod) {

        try {

            String sql =
                    "UPDATE pembayaran SET id_order=?, payment_date=?, amount=?, payment_method=? WHERE id_pay=?";

            PreparedStatement ps =
                    conn.prepareStatement(sql);

            ps.setInt(1, idOrder);
            ps.setString(2, paymentDate);
            ps.setDouble(3, amount);
            ps.setString(4, paymentMethod);
            ps.setInt(5, idPay);

            ps.executeUpdate();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void delete(int idPay) {

        try {

            String sql =
                    "DELETE FROM pembayaran WHERE id_pay=?";

            PreparedStatement ps =
                    conn.prepareStatement(sql);

            ps.setInt(1, idPay);

            ps.executeUpdate();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void tampilData(JTable table) {

        DefaultTableModel model =
                new DefaultTableModel();

        model.addColumn("ID Bayar");
        model.addColumn("ID Order");
        model.addColumn("Tanggal");
        model.addColumn("Jumlah");
        model.addColumn("Metode");

        try {

            String sql =
                    "SELECT * FROM pembayaran";

            PreparedStatement ps =
                    conn.prepareStatement(sql);

            ResultSet rs =
                    ps.executeQuery();

            while (rs.next()) {

                model.addRow(new Object[]{
                    rs.getInt("id_pay"),
                    rs.getInt("id_order"),
                    rs.getDate("payment_date"),
                    rs.getDouble("amount"),
                    rs.getString("payment_method")
                });
            }

            table.setModel(model);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}