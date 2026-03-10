package com.ekitap.web;

import com.ekitap.model.Profil;
import dao.ProfilDao;
import Classes.ConnectionManager;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.sql.Connection;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String kullaniciAdi = request.getParameter("kullaniciAdi");
        String sifre = request.getParameter("sifre");
        String email = request.getParameter("email");

        try (Connection conn = ConnectionManager.getConnection()) {
            ProfilDao dao = new ProfilDao(conn);

            // Aynı kullanıcı adı kontrolü (ad sütununa göre)
            Profil varMi = dao.getByKullaniciAdi(kullaniciAdi);
            if (varMi != null) {
                request.setAttribute("error", "Bu kullanıcı adı zaten mevcut!");
                request.getRequestDispatcher("register.jsp").forward(request, response);
                return;
            }

            // Yeni kullanıcı oluştur
            Profil profil = new Profil();
            profil.setAd(kullaniciAdi);
            profil.setEmail(email);
            profil.setSifre(sifre);

            boolean kayitBasarili = dao.kayitOl(profil);

            if (kayitBasarili) {
                // Otomatik giriş ve profil sayfasına yönlendirme
                Profil yeniKullanici = dao.getByKullaniciAdiVeSifre(kullaniciAdi, sifre);
                HttpSession session = request.getSession();
                session.setAttribute("kullaniciId", yeniKullanici.getKullaniciId());

                response.sendRedirect(request.getContextPath() + "/profil");
            } else {
                request.setAttribute("error", "Kayıt sırasında bir hata oluştu.");
                request.getRequestDispatcher("register.jsp").forward(request, response);
            }

        } catch (Exception e) {
            throw new ServletException("Kayıt sırasında hata oluştu", e);
        }
    }
}

