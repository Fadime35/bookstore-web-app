package com.ekitap.web;
import dao.KategoriDao;
import com.ekitap.model.Kategori;
import Classes.ConnectionManager;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.Connection;
import java.util.List;

@WebServlet("/kategoriler")
public class KategoriServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try (Connection conn = ConnectionManager.getConnection()) {
            KategoriDao dao = new KategoriDao(conn);
            List<Kategori> kategoriler = dao.getAll();

            request.setAttribute("kategoriler", kategoriler);
            request.getRequestDispatcher("/kategoriler.jsp").forward(request, response);
        } catch (Exception e) {
            throw new ServletException("Kategoriler yüklenirken hata oluştu", e);
        }
    }
}


