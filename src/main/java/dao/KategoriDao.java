package dao;

import com.ekitap.model.Kategori;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class KategoriDao {
    private final Connection conn;

    public KategoriDao(Connection conn) {
        this.conn = conn;
    }

    /** Tüm kategorileri getirir */
    public List<Kategori> getAll() throws SQLException {
        List<Kategori> kategoriler = new ArrayList<>();
        String sql = "SELECT * FROM kategori";

        try (Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Kategori k = new Kategori();
                k.setKategoriId(rs.getInt("kategori_id"));
                k.setKategoriAdi(rs.getString("kategori_adi"));
                kategoriler.add(k);
            }
        }
        return kategoriler;
    }

    /** ID'ye göre kategori getirir */
    public Kategori getById(int id) throws SQLException {
        Kategori kategori = null;
        String sql = "SELECT * FROM kategori WHERE kategori_id = ?";

        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    kategori = new Kategori();
                    kategori.setKategoriId(rs.getInt("kategori_id"));
                    kategori.setKategoriAdi(rs.getString("kategori_adi"));
                }
            }
        }
        return kategori;
    }

    /** Yeni kategori ekler */
    public boolean add(Kategori kategori) throws SQLException {
        String sql = "INSERT INTO kategori (kategori_adi) VALUES (?)";

        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, kategori.getKategoriAdi());
            int affected = ps.executeUpdate();
            return affected > 0;
        }
    }

    /** Kategoriyi günceller */
    public boolean update(Kategori kategori) throws SQLException {
        String sql = "UPDATE kategori SET kategori_adi = ? WHERE kategori_id = ?";

        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, kategori.getKategoriAdi());
            ps.setInt(2, kategori.getKategoriId());
            int affected = ps.executeUpdate();
            return affected > 0;
        }
    }

    /** Kategori siler */
    public boolean delete(int id) throws SQLException {
        String sql = "DELETE FROM kategori WHERE kategori_id = ?";

        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            int affected = ps.executeUpdate();
            return affected > 0;
        }
    }
}
