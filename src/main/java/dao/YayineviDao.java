package dao;

import com.ekitap.model.Yayinevi;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;



public class YayineviDao {
	 private Connection conn;

	    public YayineviDao(Connection conn) {
	        this.conn = conn;
	    }

	    public List<Yayinevi> getAll() {
	        List<Yayinevi> yayinevleri = new ArrayList<>();
	        String sql = "SELECT * FROM yayinevi";

	        try (Statement stmt = conn.createStatement();
	             ResultSet rs = stmt.executeQuery(sql)) {
	            while (rs.next()) {
	                Yayinevi y = new Yayinevi();
	                y.setYayineviId(rs.getInt("yayinevi_id"));
	                y.setYayineviAdi(rs.getString("yayinevi_adi"));
	                y.setYayineviAdresi(rs.getString("yayinevi_adresi"));
	                yayinevleri.add(y);
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return yayinevleri;
	    }

	    public Yayinevi getById(int id) {
	        Yayinevi y = null;
	        String sql = "SELECT * FROM yayinevi WHERE yayinevi_id = ?";

	        try (PreparedStatement ps = conn.prepareStatement(sql)) {
	            ps.setInt(1, id);
	            try (ResultSet rs = ps.executeQuery()) {
	                if (rs.next()) {
	                    y = new Yayinevi();
	                    y.setYayineviId(rs.getInt("yayinevi_id"));
	                    y.setYayineviAdi(rs.getString("yayinevi_adi"));
	                    y.setYayineviAdresi(rs.getString("yayinevi_adresi"));
	                }
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return y;
	    }

	    public boolean add(Yayinevi yayinevi) {
	        String sql = "INSERT INTO yayinevi (yayinevi_adi, yayinevi_adresi) VALUES (?, ?)";

	        try (PreparedStatement ps = conn.prepareStatement(sql)) {
	            ps.setString(1, yayinevi.getYayineviAdi());
	            ps.setString(2, yayinevi.getYayineviAdresi());
	            int affected = ps.executeUpdate();
	            return affected > 0;
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return false;
	    }

	    public boolean update(Yayinevi yayinevi) {
	        String sql = "UPDATE yayinevi SET yayinevi_adi = ?, yayinevi_adresi = ? WHERE yayinevi_id = ?";

	        try (PreparedStatement ps = conn.prepareStatement(sql)) {
	            ps.setString(1, yayinevi.getYayineviAdi());
	            ps.setString(2, yayinevi.getYayineviAdresi());
	            ps.setInt(3, yayinevi.getYayineviId());
	            int affected = ps.executeUpdate();
	            return affected > 0;
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return false;
	    }

	    public boolean delete(int id) {
	        String sql = "DELETE FROM yayinevi WHERE yayinevi_id = ?";

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