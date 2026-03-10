package dao;

import com.ekitap.model.Kitap;
import com.ekitap.model.Kategori;
import com.ekitap.model.Yazar;
import com.ekitap.model.Yayinevi;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class KitapDao {
    private Connection conn;

    public KitapDao(Connection conn) {
        this.conn = conn;
    }

    // Belirli bir kategoriye ait kitapları getir
    public List<Kitap> getKitaplarByKategoriId(int kategoriId) {
        List<Kitap> kitapListesi = new ArrayList<>();

        String sql = "SELECT k.kitap_id, k.kitap_adi, k.kategori_id, k.sayfa_sayisi, k.aciklama, " +
                     "k.stok_adedi, k.kitap_fiyati, k.kitap_resim, " +
                     "y.yazar_id, y.yazar_adi, " +
                     "ya.yayinevi_id, ya.yayinevi_adi, ya.yayinevi_adresi " +
                     "FROM kitap k " +
                     "JOIN yazar y ON k.yazar_id = y.yazar_id " +
                     "JOIN yayinevi ya ON k.yayinevi_id = ya.yayinevi_id " +
                     "WHERE k.kategori_id = ?";

        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, kategoriId);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    Kitap kitap = new Kitap();
                    kitap.setKitapId(rs.getInt("kitap_id"));
                    kitap.setKitapAdi(rs.getString("kitap_adi"));

                    Kategori kategori = new Kategori();
                    kategori.setKategoriId(rs.getInt("kategori_id"));
                    kitap.setKategori(kategori);

                    kitap.setSayfaSayisi(rs.getInt("sayfa_sayisi"));
                    kitap.setAciklama(rs.getString("aciklama"));
                    kitap.setStokAdedi(rs.getInt("stok_adedi"));
                    kitap.setKitapFiyati(rs.getDouble("kitap_fiyati"));
                    kitap.setKitapResim(rs.getString("kitap_resim"));

                    Yazar yazar = new Yazar();
                    yazar.setYazarId(rs.getInt("yazar_id"));
                    yazar.setYazarAdi(rs.getString("yazar_adi"));
                    kitap.setYazar(yazar);

                    Yayinevi yayinevi = new Yayinevi();
                    yayinevi.setYayineviId(rs.getInt("yayinevi_id"));
                    yayinevi.setYayineviAdi(rs.getString("yayinevi_adi"));
                    yayinevi.setYayineviAdresi(rs.getString("yayinevi_adresi"));
                    kitap.setYayinevi(yayinevi);

                    kitapListesi.add(kitap);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return kitapListesi;
    }
    
    // Tüm kitapları getir
    public List<Kitap> getAll() {
        List<Kitap> kitapListesi = new ArrayList<>();
        String sql = "SELECT k.kitap_id, k.kitap_adi, k.kategori_id, k.sayfa_sayisi, k.aciklama, " +
                     "k.stok_adedi, k.kitap_fiyati, k.kitap_resim, " +
                     "y.yazar_id, y.yazar_adi, " +
                     "ya.yayinevi_id, ya.yayinevi_adi, ya.yayinevi_adresi " +
                     "FROM kitap k " +
                     "JOIN yazar y ON k.yazar_id = y.yazar_id " +
                     "JOIN yayinevi ya ON k.yayinevi_id = ya.yayinevi_id";

        try (PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                Kitap kitap = new Kitap();
                kitap.setKitapId(rs.getInt("kitap_id"));
                kitap.setKitapAdi(rs.getString("kitap_adi"));

                Kategori kategori = new Kategori();
                kategori.setKategoriId(rs.getInt("kategori_id"));
                kitap.setKategori(kategori);

                kitap.setSayfaSayisi(rs.getInt("sayfa_sayisi"));
                kitap.setAciklama(rs.getString("aciklama"));
                kitap.setStokAdedi(rs.getInt("stok_adedi"));
                kitap.setKitapFiyati(rs.getDouble("kitap_fiyati"));
                kitap.setKitapResim(rs.getString("kitap_resim"));

                Yazar yazar = new Yazar();
                yazar.setYazarId(rs.getInt("yazar_id"));
                yazar.setYazarAdi(rs.getString("yazar_adi"));
                kitap.setYazar(yazar);

                Yayinevi yayinevi = new Yayinevi();
                yayinevi.setYayineviId(rs.getInt("yayinevi_id"));
                yayinevi.setYayineviAdi(rs.getString("yayinevi_adi"));
                yayinevi.setYayineviAdresi(rs.getString("yayinevi_adresi"));
                kitap.setYayinevi(yayinevi);

                kitapListesi.add(kitap);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return kitapListesi;
    }

    // ID'ye göre kitap getir
    public Kitap getById(int id) {
        String sql = "SELECT k.kitap_id, k.kitap_adi, k.kategori_id, k.sayfa_sayisi, k.aciklama, " +
                     "k.stok_adedi, k.kitap_fiyati, k.kitap_resim, " +
                     "y.yazar_id, y.yazar_adi, " +
                     "ya.yayinevi_id, ya.yayinevi_adi, ya.yayinevi_adresi " +
                     "FROM kitap k " +
                     "JOIN yazar y ON k.yazar_id = y.yazar_id " +
                     "JOIN yayinevi ya ON k.yayinevi_id = ya.yayinevi_id " +
                     "WHERE k.kitap_id = ?";

        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    Kitap kitap = new Kitap();
                    kitap.setKitapId(rs.getInt("kitap_id"));
                    kitap.setKitapAdi(rs.getString("kitap_adi"));

                    Kategori kategori = new Kategori();
                    kategori.setKategoriId(rs.getInt("kategori_id"));
                    kitap.setKategori(kategori);

                    kitap.setSayfaSayisi(rs.getInt("sayfa_sayisi"));
                    kitap.setAciklama(rs.getString("aciklama"));
                    kitap.setStokAdedi(rs.getInt("stok_adedi"));
                    kitap.setKitapFiyati(rs.getDouble("kitap_fiyati"));
                    kitap.setKitapResim(rs.getString("kitap_resim"));

                    Yazar yazar = new Yazar();
                    yazar.setYazarId(rs.getInt("yazar_id"));
                    yazar.setYazarAdi(rs.getString("yazar_adi"));
                    kitap.setYazar(yazar);

                    Yayinevi yayinevi = new Yayinevi();
                    yayinevi.setYayineviId(rs.getInt("yayinevi_id"));
                    yayinevi.setYayineviAdi(rs.getString("yayinevi_adi"));
                    yayinevi.setYayineviAdresi(rs.getString("yayinevi_adresi"));
                    kitap.setYayinevi(yayinevi);

                    return kitap;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}

