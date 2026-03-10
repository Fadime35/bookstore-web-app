<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Kategoriler</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet" />
    <style>
        body {
            background-color: #d8b4a6; /* toz pembe ton */
            min-height: 100vh;
            display: flex;
            margin: 0;
        }
        /* Sidebar */
        #sidebar {
            width: 220px;
            background-color: #cfa7a0;
            min-height: 100vh;
            padding: 20px;
            color: #fff;
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
            color: #4a2e2a;
        }

        ul.kategori-listesi {
            list-style: none;
            padding: 0;
            margin: 0;
        }
        ul.kategori-listesi li {
            margin: 15px 0;
        }
        ul.kategori-listesi li a {
            color: #4a2e2a;
            font-weight: 600;
            font-size: 1.2rem;
            text-decoration: none;
            padding: 8px 12px;
            display: block;
            border-radius: 5px;
            transition: background-color 0.3s ease;
            background-color: #f9e8e8;
            border: 1px solid #d9b8b1;
        }
        ul.kategori-listesi li a:hover {
            background-color: #b68d87;
            color: white;
            padding-left: 20px;
        }
    </style>
</head>
<body>
    <div id="sidebar">
        <h3>Menü</h3>
        <a href="${pageContext.request.contextPath}/anasayfa">Anasayfa</a>
        <a href="${pageContext.request.contextPath}/kategoriler">Kategoriler</a>
        <a href="${pageContext.request.contextPath}/iletisim">İletişim</a>
        <a href="${pageContext.request.contextPath}/profil">Profil</a>
    </div>

    <div id="main-content" class="container-fluid">
        <h2>Kategoriler</h2>

        <ul class="kategori-listesi">
            <c:forEach var="kategori" items="${kategoriler}">
                <li>
                    <a href="${pageContext.request.contextPath}/kitaplar?kategoriId=${kategori.kategoriId}">
                        ${kategori.kategoriAdi}
                    </a>
                </li>
            </c:forEach>
        </ul>
    </div>
</body>
</html>

