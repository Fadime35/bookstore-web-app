package com.ekitap.web;

import com.ekitap.model.Profil;
import dao.ProfilDao;
import Classes.ConnectionManager;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;
import java.sql.Connection;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("login.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String kullaniciAdi = request.getParameter("kullaniciAdi");
        String sifre = request.getParameter("sifre");

        try (Connection conn = ConnectionManager.getConnection()) {
            ProfilDao dao = new ProfilDao(conn);
            Profil profil = dao.getByKullaniciAdiVeSifre(kullaniciAdi, sifre);

            if (profil != null) {
                HttpSession session = request.getSession();
                session.setAttribute("kullaniciId", profil.getKullaniciId());
                response.sendRedirect(request.getContextPath() + "/profil");
            } else {
                request.setAttribute("error", "Kullanıcı adı veya şifre hatalı!");
                request.getRequestDispatcher("login.jsp").forward(request, response);
            }

        } catch (Exception e) {
            throw new ServletException("Giriş sırasında hata oluştu", e);
        }
    }
}




