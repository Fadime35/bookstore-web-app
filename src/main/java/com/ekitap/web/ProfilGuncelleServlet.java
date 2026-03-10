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

@WebServlet("/profilGuncelle")
public class ProfilGuncelleServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession(false);
        if (session == null || session.getAttribute("kullaniciId") == null) {
            // Giriş yapılmamışsa login sayfasına yönlendir
            response.sendRedirect(request.getContextPath() + "/login");
            return;
        }

        int kullaniciId = (int) session.getAttribute("kullaniciId");

        // Formdan gelen değerler
        String ad = request.getParameter("ad");
        String soyad = request.getParameter("soyad");
        String email = request.getParameter("email");
        String telefon = request.getParameter("telefon");
        String adres = request.getParameter("adres");
        String sifre = request.getParameter("sifre"); // opsiyonel

        try (Connection conn = ConnectionManager.getConnection()) {
            ProfilDao dao = new ProfilDao(conn);

            // Mevcut kullanıcı bilgilerini çek
            Profil profil = dao.getById(kullaniciId);
            if (profil != null) {
                profil.setAd(ad);
                profil.setSoyad(soyad);
                profil.setEmail(email);
                profil.setTelefon(telefon);
                profil.setAdres(adres);

                // Şifre güncelleme opsiyonel
                if (sifre != null && !sifre.isEmpty()) {
                    profil.setSifre(sifre);
                }

                boolean guncellemeBasarili = dao.guncelle(profil);

                if (guncellemeBasarili) {
                    request.setAttribute("success", "Profil başarıyla güncellendi.");
                } else {
                    request.setAttribute("error", "Profil güncellenirken hata oluştu.");
                }
            } else {
                request.setAttribute("error", "Kullanıcı bulunamadı.");
            }

            request.getRequestDispatcher("profil.jsp").forward(request, response);

        } catch (Exception e) {
            throw new ServletException("Profil güncellenirken hata oluştu", e);
        }
    }
}





