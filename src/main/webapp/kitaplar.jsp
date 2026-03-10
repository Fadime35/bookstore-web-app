<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<html>
<head>
    <title>Kitaplar</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css">
    <style>
        .kitap-card {
            width: 100%;
            max-width: 250px;
            margin-bottom: 20px;
        }

        .kitap-card img {
            height: 200px;
            object-fit: cover;
        }

        .kitap-bilgi {
            font-size: 14px;
        }

        .kategori-baslik {
            margin: 40px 0 20px 10px;
            color: #333;
            border-bottom: 2px solid #999;
            padding-bottom: 5px;
        }
    </style>
</head>
<body>
<div class="container mt-4">
    <!-- Kategori başlığı -->
    <h2 class="kategori-baslik h4">${secilenKategori.kategoriAdi}</h2>

    <div class="row justify-content-start">
        <c:forEach var="kitap" items="${kitaplar}">
            <div class="col-12 col-sm-6 col-md-4 col-lg-3 d-flex justify-content-center">
                <div class="card kitap-card">
                    <img src="resimler/${kitap.kitapResim}" class="card-img-top" alt="${kitap.kitapAdi}">
                    
                    <div class="card-body">
                        <h5 class="card-title">${kitap.kitapAdi}</h5>
                        <p class="kitap-bilgi mb-1"><strong>Yazar:</strong> ${kitap.yazar.yazarAdi}</p>
                        <p class="kitap-bilgi mb-1"><strong>Yayınevi:</strong> ${kitap.yayinevi.yayineviAdi}</p>
                        <p class="kitap-bilgi">
                            <strong>Fiyat:</strong> <fmt:formatNumber value="${kitap.kitapFiyati}" type="currency" currencySymbol="₺" />
                        </p>

                        <!-- ✅ Detay Butonu -->
                        <a href="${pageContext.request.contextPath}/kitapDetay?id=${kitap.kitapId}" 
                           class="btn btn-sm btn-outline-primary mt-2">Detay</a>
                    </div>
                </div>
            </div>
        </c:forEach>
    </div>

    <c:if test="${empty kitaplar}">
        <p class="text-muted">Bu kategoriye ait kitap bulunamadı.</p>
    </c:if>
</div>
</body>
</html>
