package dao;

import com.ekitap.model.Profil;
import java.sql.*;

public class ProfilDao {
    private Connection conn;

    public ProfilDao(Connection conn) {
        this.conn = conn;
    }

    // 1️⃣ ID ile profil çekme
    public Profil getById(int id) {
        String sql = "SELECT kullanici_id, ad, soyad, email, sifre, telefon, adres FROM kullanici WHERE kullanici_id = ?";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    Profil p = new Profil();
                    p.setKullaniciId(rs.getInt("kullanici_id"));
                    p.setAd(rs.getString("ad"));
                    p.setSoyad(rs.getString("soyad"));
                    p.setEmail(rs.getString("email"));
                    p.setSifre(rs.getString("sifre"));
                    p.setTelefon(rs.getString("telefon"));
                    p.setAdres(rs.getString("adres"));
                    return p;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    // 2️⃣ Kullanıcı adı ve şifre ile giriş kontrolü
    public Profil getByKullaniciAdiVeSifre(String kullaniciAdi, String sifre) {
        String sql = "SELECT kullanici_id, ad, soyad, email, sifre, telefon, adres FROM kullanici WHERE ad = ? AND sifre = ?";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, kullaniciAdi);
            ps.setString(2, sifre);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    Profil p = new Profil();
                    p.setKullaniciId(rs.getInt("kullanici_id"));
                    p.setAd(rs.getString("ad"));
                    p.setSoyad(rs.getString("soyad"));
                    p.setEmail(rs.getString("email"));
                    p.setSifre(rs.getString("sifre"));
                    p.setTelefon(rs.getString("telefon"));
                    p.setAdres(rs.getString("adres"));
                    return p;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    // 3️⃣ Kullanıcı adı kontrolü (kayıt sırasında)
    public Profil getByKullaniciAdi(String kullaniciAdi) {
        String sql = "SELECT * FROM kullanici WHERE ad = ?";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, kullaniciAdi);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    Profil p = new Profil();
                    p.setKullaniciId(rs.getInt("kullanici_id"));
                    p.setAd(rs.getString("ad"));
                    p.setSoyad(rs.getString("soyad"));
                    p.setEmail(rs.getString("email"));
                    p.setSifre(rs.getString("sifre"));
                    p.setTelefon(rs.getString("telefon"));
                    p.setAdres(rs.getString("adres"));
                    return p;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    // 4️⃣ Yeni kullanıcı kayıt
    public boolean kayitOl(Profil profil) {
        String sql = "INSERT INTO kullanici (ad, soyad, email, sifre, telefon, adres) VALUES (?, ?, ?, ?, ?, ?)";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, profil.getAd());
            ps.setString(2, profil.getSoyad() != null ? profil.getSoyad() : ""); // opsiyonel
            ps.setString(3, profil.getEmail());
            ps.setString(4, profil.getSifre());
            ps.setString(5, profil.getTelefon() != null ? profil.getTelefon() : "");
            ps.setString(6, profil.getAdres() != null ? profil.getAdres() : "");
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    // 5️⃣ Profil güncelleme
    public boolean guncelle(Profil profil) {
        String sql = "UPDATE kullanici SET ad = ?, soyad = ?, email = ?, sifre = ?, telefon = ?, adres = ? WHERE kullanici_id = ?";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, profil.getAd());
            ps.setString(2, profil.getSoyad());
            ps.setString(3, profil.getEmail());
            ps.setString(4, profil.getSifre());
            ps.setString(5, profil.getTelefon());
            ps.setString(6, profil.getAdres());
            ps.setInt(7, profil.getKullaniciId());
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}

