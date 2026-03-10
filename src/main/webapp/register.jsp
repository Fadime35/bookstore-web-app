<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Kayıt Ol</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet" />
    <style>
        body {
            background-color: #f8f1f1;
            font-family: Arial, sans-serif;
            padding: 50px;
        }
        .register-container {
            max-width: 500px;
            margin: auto;
            background: #ffffff;
            padding: 30px;
            border-radius: 10px;
            box-shadow: 0 4px 8px rgba(0,0,0,0.1);
        }
        h2 {
            margin-bottom: 25px;
            color: #4a2e2a;
            text-align: center;
        }
        .alert {
            display: none; /* Başlangıçta gizli */
            margin-bottom: 15px;
        }
        .btn-primary {
            background-color: #cfa7a0;
            border: none;
        }
        .btn-primary:hover {
            background-color: #b68d87;
        }
    </style>
</head>
<body>
    <div class="register-container">
        <h2>Kayıt Ol</h2>

        <!-- Hata mesajı -->
        <c:if test="${not empty error}">
            <div class="alert alert-danger" style="display:block;">
                ${error}
            </div>
        </c:if>

        <!-- Başarı mesajı -->
        <c:if test="${not empty success}">
            <div class="alert alert-success" style="display:block;">
                ${success}
            </div>
        </c:if>

        <form action="${pageContext.request.contextPath}/register" method="post">
            <div class="mb-3">
                <label for="kullaniciAdi" class="form-label">Kullanıcı Adı:</label>
                <input type="text" class="form-control" id="kullaniciAdi" name="kullaniciAdi" required />
            </div>

            <div class="mb-3">
                <label for="sifre" class="form-label">Şifre:</label>
                <input type="password" class="form-control" id="sifre" name="sifre" required />
            </div>

            <div class="mb-3">
                <label for="email" class="form-label">E-posta:</label>
                <input type="email" class="form-control" id="email" name="email" required />
            </div>

            <button type="submit" class="btn btn-primary w-100">Kayıt Ol</button>
        </form>
    </div>
</body>
</html>


