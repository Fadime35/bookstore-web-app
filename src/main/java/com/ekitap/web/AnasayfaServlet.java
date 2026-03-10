package com.ekitap.web;

import dao.KategoriDao;
import dao.KitapDao;
import com.ekitap.model.Kategori;
import com.ekitap.model.Kitap;
import Classes.ConnectionManager;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.Connection;
import java.util.List;

@WebServlet("/anasayfa")
public class AnasayfaServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try (Connection conn = ConnectionManager.getConnection()) {
            KategoriDao kategoriDao = new KategoriDao(conn);
            KitapDao kitapDao = new KitapDao(conn);

            List<Kategori> kategoriler = kategoriDao.getAll();
            List<Kitap> kitaplar = kitapDao.getAll();

            request.setAttribute("kategoriler", kategoriler);
            request.setAttribute("kitaplar", kitaplar);

            request.getRequestDispatcher("/anasayfa.jsp").forward(request, response);
        } catch (Exception e) {
            throw new ServletException("Ana sayfa yüklenirken hata oluştu", e);
        }
    }
}
