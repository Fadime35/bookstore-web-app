<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Ana Sayfa</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet" />
    <style>
        body {
            background-color: #d8b4a6; /* toz pembe ton */
            min-height: 100vh;
            display: flex;
            margin: 0;
            font-family: Arial, sans-serif;
        }
        /* Sidebar */
        #sidebar {
            width: 220px;
            background-color: #cfa7a0;
            min-height: 100vh;
            padding: 20px;
            color: #fff;
            box-sizing: border-box;
        }
        #sidebar h3 {
            margin-bottom: 30px;
            font-weight: bold;
            border-bottom: 2px solid #fff;
            padding-bottom: 10px;
        }
        #sidebar a {
            color: #fff;
            text-decoration: none;
            display: block;
            padding: 8px 0;
            font-weight: 500;
            border-bottom: 1px solid #d9b8b1;
            transition: all 0.3s ease;
        }
        #sidebar a:hover {
            background-color: #b68d87;
            border-radius: 5px;
            padding-left: 10px;
        }

        /* Main content */
        #main-content {
            flex: 1;
            padding: 20px 40px;
            overflow-y: auto;
            box-sizing: border-box;
        }

        .kategori-baslik {
            margin-top: 30px;
            color: #4a2e2a;
            font-weight: bold;
            border-bottom: 2px solid #6c4b48;
            padding-bottom: 5px;
        }
        .kitap-card {
            width: 18rem;
            margin: 15px;
            box-shadow: 0 4px 6px rgba(0,0,0,0.1);
            border-radius: 10px;
            background-color: #f9e8e8;
            display: flex;
            flex-direction: column;
        }
        .kitap-card img {
            height: 250px;
            object-fit: cover;
            border-top-left-radius: 10px;
            border-top-right-radius: 10px;
            width: 100%;
        }
        .kitap-bilgi {
            font-size: 14px;
            color: #5a3d3a;
            padding: 10px;
            flex-grow: 1;
        }
        .row {
            margin-left: 0;
            margin-right: 0;
        }
    </style>
</head>
<body>
    <div id="sidebar">
        <h3>Menü</h3>
        <a href="${pageContext.request.contextPath}/anasayfa">Anasayfa</a>
        <a href="${pageContext.request.contextPath}/kategoriler">Kategoriler</a>
        <a href="#">İletişim</a>
        <a href="${pageContext.request.contextPath}/profil">Profil</a>
    </div>

    <div id="main-content" class="container-fluid">
        <h1 class="text-center my-4" style="color: #4a2e2a;">Tüm Kitaplar</h1>

        <c:forEach var="kategori" items="${kategoriler}">
            <div class="kategori-baslik h4">${kategori.kategoriAdi}</div>
            <div class="row justify-content-start">
                <c:forEach var="kitap" items="${kitaplar}">
                    <c:if test="${kitap.kategori.kategoriId == kategori.kategoriId}">
                        <div class="col-12 col-sm-6 col-md-4 col-lg-3 d-flex justify-content-center">
                            <div class="card kitap-card">
                                <img src="${pageContext.request.contextPath}/resimler/${kitap.kitapResim}" 
                                     class="card-img-top" alt="${kitap.kitapAdi}" />
                                <div class="card-body kitap-bilgi">
                                    <h5 class="card-title">${kitap.kitapAdi}</h5>
                                    <p><strong>Yazar:</strong> ${kitap.yazar.yazarAdi}</p>
                                    <p><strong>Yayınevi:</strong> ${kitap.yayinevi.yayineviAdi}</p>
                                    <p><strong>Fiyat:</strong> ${kitap.kitapFiyati} TL</p>
                                </div>
                            </div>
                        </div>
                    </c:if>
                </c:forEach>
            </div>
        </c:forEach>
    </div>
</body>
</html>
