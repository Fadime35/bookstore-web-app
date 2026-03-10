<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<html>
<head>
    <title>Kitap Detay</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css">
    <style>
        body {
            background-color: #f9e8e8;
            font-family: Arial, sans-serif;
        }
        .detay-kapsayici {
            max-width: 700px;
            margin: 50px auto;
            background-color: #fff;
            border-radius: 10px;
            box-shadow: 0 0 15px rgba(0,0,0,0.1);
            padding: 30px;
        }
        .kitap-resim {
            max-height: 300px;
            object-fit: contain;
            border-radius: 8px;
        }
    </style>
</head>
<body>

<div class="detay-kapsayici">
    <h2 class="mb-3">${kitap.kitapAdi}</h2>
    <div class="row">
        <div class="col-md-4">
            <img src="${pageContext.request.contextPath}/resimler/${kitap.kitapResim}" class="img-fluid kitap-resim" alt="${kitap.kitapAdi}">
        </div>
        <div class="col-md-8">
            <p><strong>Yazar:</strong> ${kitap.yazar.yazarAdi}</p>
            <p><strong>Yayınevi:</strong> ${kitap.yayinevi.yayineviAdi}</p>
            <p><strong>Sayfa Sayısı:</strong> ${kitap.sayfaSayisi}</p>
            <p><strong>Stok Adedi:</strong> ${kitap.stokAdedi}</p>
            <p><strong>Açıklama:</strong> ${kitap.aciklama}</p>
            <p><strong>Fiyat:</strong> 
                <fmt:formatNumber value="${kitap.kitapFiyati}" type="currency" currencySymbol="₺" />
            </p>

            <!-- Satın Al Formu -->
            <form action="${pageContext.request.contextPath}/satinal" method="post">
                <input type="hidden" name="kitapId" value="${kitap.kitapId}">
                <button type="submit" class="btn btn-success">Satın Al</button>
            </form>

            <a href="${pageContext.request.contextPath}/kitaplar?kategoriId=${kitap.kategori.kategoriId}" class="btn btn-secondary mt-3">← Geri Dön</a>
        </div>
    </div>
</div>

</body>
</html>
