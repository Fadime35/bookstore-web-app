<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Giriş Yap</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet"/>
    <style>
        body { background-color: #d8b4a6; font-family: Arial, sans-serif; padding: 20px; }
        .panel { max-width: 500px; margin: auto; background: #f9e8e8; padding: 30px; border-radius: 10px; box-shadow: 0 4px 6px rgba(0,0,0,0.1);}
        .btn-primary { background-color: #cfa7a0; border: none; }
        .btn-primary:hover { background-color: #b68d87; }
        .alert { margin-bottom: 15px; }
    </style>
</head>
<body>
<div class="panel">
    <h2 class="mb-3">Giriş Yap</h2>

    <c:if test="${not empty error}">
        <div class="alert alert-danger">${error}</div>
    </c:if>

    <form action="${pageContext.request.contextPath}/login" method="post">
        <div class="mb-3">
            <label for="kullaniciAdi">Kullanıcı Adı</label>
            <input type="text" class="form-control" id="kullaniciAdi" name="kullaniciAdi" required/>
        </div>
        <div class="mb-3">
            <label for="sifre">Şifre</label>
            <input type="password" class="form-control" id="sifre" name="sifre" required/>
        </div>
        <button type="submit" class="btn btn-primary">Giriş Yap</button>
    </form>

    <hr/>

    <a href="${pageContext.request.contextPath}/register.jsp" class="btn btn-secondary mt-2">Kayıt Ol</a>
</div>
</body>
</html>




