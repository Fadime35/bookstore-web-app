package com.ekitap.web;

import com.ekitap.model.Profil;
import dao.ProfilDao;
import Classes.ConnectionManager;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.Connection;

@WebServlet("/profil")
public class ProfilServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        Integer kullaniciId = (Integer) request.getSession().getAttribute("kullaniciId");

        if (kullaniciId == null) {
            // Kullanıcı login değilse login.jsp göster
            request.getRequestDispatcher("/login.jsp").forward(request, response);
            return;
        }

        try (Connection conn = ConnectionManager.getConnection()) {
            ProfilDao dao = new ProfilDao(conn);
            Profil profil = dao.getById(kullaniciId);

            request.setAttribute("profil", profil);
            request.getRequestDispatcher("/profil.jsp").forward(request, response);

        } catch (Exception e) {
            throw new ServletException("Profil yüklenirken hata oluştu", e);
        }
    }
}

