package com.ekitap.web;

import com.ekitap.model.Kitap;
import com.ekitap.model.Kategori;
import dao.KitapDao;
import dao.KategoriDao;
import Classes.ConnectionManager;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.Connection;
import java.util.List;

@WebServlet("/kitaplar")
public class KategoriyeGoreKitapServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try (Connection conn = ConnectionManager.getConnection()) {
            // kategoriId parametresini al
            String kategoriIdStr = request.getParameter("kategoriId");
            if (kategoriIdStr == null || kategoriIdStr.isEmpty()) {
                request.setAttribute("hata", "Kategori ID belirtilmemiş.");
                request.getRequestDispatcher("/kitaplar.jsp").forward(request, response);
                return;
            }
            int kategoriId = Integer.parseInt(kategoriIdStr);

            // Kitapları getir
            KitapDao kitapDao = new KitapDao(conn);
            List<Kitap> kitaplar = kitapDao.getKitaplarByKategoriId(kategoriId);

            // Seçilen kategori bilgisi
            KategoriDao kategoriDao = new KategoriDao(conn);
            Kategori secilenKategori = kategoriDao.getById(kategoriId);

            // Request attribute olarak koy
            request.setAttribute("kitaplar", kitaplar);
            request.setAttribute("secilenKategori", secilenKategori);

            // JSP sayfasına yönlendir
            request.getRequestDispatcher("/kitaplar.jsp").forward(request, response);

        } catch (Exception e) {
            throw new ServletException("Kitaplar yüklenirken hata oluştu", e);
        }
    }
}
