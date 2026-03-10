package com.ekitap.web;

import com.ekitap.model.Kitap;
import dao.KitapDao;
import Classes.ConnectionManager;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.Connection;

@WebServlet("/kitapDetay")
public class KitapDetayServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String kitapIdStr = request.getParameter("id");
        if (kitapIdStr == null || kitapIdStr.isEmpty()) {
            response.sendRedirect(request.getContextPath() + "/anasayfa");
            return;
        }

        try (Connection conn = ConnectionManager.getConnection()) {
            int kitapId = Integer.parseInt(kitapIdStr);

            KitapDao kitapDao = new KitapDao(conn);
            Kitap kitap = kitapDao.getById(kitapId);

            if (kitap == null) {
                response.sendRedirect(request.getContextPath() + "/anasayfa");
                return;
            }

            request.setAttribute("kitap", kitap);
            request.getRequestDispatcher("/kitapDetay.jsp").forward(request, response);

        } catch (Exception e) {
            throw new ServletException("Kitap detayı alınırken hata oluştu", e);
        }
    }
}
