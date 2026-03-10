package dao;

import com.ekitap.model.Yazar;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class YazarDao {
	
	 private Connection conn;

	    public YazarDao(Connection conn) {
	        this.conn = conn;
	    }

	    public List<Yazar> getAll() {
	        List<Yazar> yazarlar = new ArrayList<>();
	        String sql = "SELECT * FROM yazar";

	        try (Statement stmt = conn.createStatement();
	             ResultSet rs = stmt.executeQuery(sql)) {
	            while (rs.next()) {
	                Yazar y = new Yazar();
	                y.setYazarId(rs.getInt("yazar_id"));
	                y.setYazarAdi(rs.getString("yazar_adi"));
	                yazarlar.add(y);
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return yazarlar;
	    }

	    public Yazar getById(int id) {
	        Yazar y = null;
	        String sql = "SELECT * FROM yazar WHERE yazar_id = ?";

	        try (PreparedStatement ps = conn.prepareStatement(sql)) {
	            ps.setInt(1, id);
	            try (ResultSet rs = ps.executeQuery()) {
	                if (rs.next()) {
	                    y = new Yazar();
	                    y.setYazarId(rs.getInt("yazar_id"));
	                    y.setYazarAdi(rs.getString("yazar_adi"));
	                }
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return y;
	    }

	    public boolean add(Yazar yazar) {
	        String sql = "INSERT INTO yazar (yazar_adi) VALUES (?)";

	        try (PreparedStatement ps = conn.prepareStatement(sql)) {
	            ps.setString(1, yazar.getYazarAdi());
	            int affected = ps.executeUpdate();
	            return affected > 0;
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return false;
	    }

	    public boolean update(Yazar yazar) {
	        String sql = "UPDATE yazar SET yazar_adi = ? WHERE yazar_id = ?";

	        try (PreparedStatement ps = conn.prepareStatement(sql)) {
	            ps.setString(1, yazar.getYazarAdi());
	            ps.setInt(2, yazar.getYazarId());
	            int affected = ps.executeUpdate();
	            return affected > 0;
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return false;
	    }

	    public boolean delete(int id) {
	        String sql = "DELETE FROM yazar WHERE yazar_id = ?";

	        try (PreparedStatement ps = conn.prepareStatement(sql)) {
	            ps.setInt(1, id);
	            int affected = ps.executeUpdate();
	            return affected > 0;
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return false;
	    }


}
