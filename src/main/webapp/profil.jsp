<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Profil Sayfası</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet"/>
    <style>
        body { background-color: #d8b4a6; font-family: Arial, sans-serif; padding: 20px; }
        .profil-container { max-width: 600px; margin: auto; background: #f9e8e8; padding: 30px; border-radius: 10px; box-shadow: 0 4px 6px rgba(0,0,0,0.1);}
        h2 { margin-bottom: 25px; color: #4a2e2a; }
        label { font-weight: 600; color: #5a3d3a; }
        .btn-primary { background-color: #cfa7a0; border: none; }
        .btn-primary:hover { background-color: #b68d87; }
    </style>
</head>
<body>
<div class="profil-container">
    <h2>Profil Bilgileriniz</h2>

    <!-- Başarı veya hata mesajları -->
    <c:if test="${not empty success}">
        <div class="alert alert-success">${success}</div>
    </c:if>
    <c:if test="${not empty error}">
        <div class="alert alert-danger">${error}</div>
    </c:if>

    <form action="${pageContext.request.contextPath}/profilGuncelle" method="post">
        <div class="mb-3">
            <label for="ad" class="form-label">Ad:</label>
            <input type="text" class="form-control" id="ad" name="ad" value="${profil.ad}" required />
        </div>
        <div class="mb-3">
            <label for="soyad" class="form-label">Soyad:</label>
            <input type="text" class="form-control" id="soyad" name="soyad" value="${profil.soyad}" required />
        </div>
        <div class="mb-3">
            <label for="email" class="form-label">E-posta:</label>
            <input type="email" class="form-control" id="email" name="email" value="${profil.email}" required />
        </div>
        <div class="mb-3">
            <label for="telefon" class="form-label">Telefon:</label>
            <input type="text" class="form-control" id="telefon" name="telefon" value="${profil.telefon}" />
        </div>
        <div class="mb-3">
            <label for="adres" class="form-label">Adres:</label>
            <textarea class="form-control" id="adres" name="adres" rows="3">${profil.adres}</textarea>
        </div>
        <div class="mb-3">
            <label for="sifre" class="form-label">Şifre (Değiştirmek istemiyorsanız boş bırakın):</label>
            <input type="password" class="form-control" id="sifre" name="sifre" />
        </div>
        <button type="submit" class="btn btn-primary">Bilgileri Güncelle</button>
    </form>
</div>
</body>
</html>








