# Bookstore Web Uygulaması

## Proje Hakkında
Kitaplık (Bookstore) Web Uygulaması, kullanıcıların kitapları görüntüleyebildiği, arama yapabildiği ve yönetebildiği **Java tabanlı dinamik bir web uygulamasıdır**.

Proje, **MySQL veritabanı**, **JDBC (MySQL Connector/J)** ve **Apache Tomcat** kullanılarak geliştirilmiştir.

Amaç; backend geliştirme, veritabanı yönetimi ve CRUD işlemleri konusunda pratik deneyim kazanmaktır.

---

## Özellikler

- Kullanıcı kayıt ve giriş sistemi
- Kitap ekleme, silme, güncelleme ve listeleme (CRUD işlemleri)
- Kategori bazlı kitap yönetimi
- Kitap arama ve filtreleme
- MySQL ile dinamik veri yönetimi
- Admin paneli (varsa ekleyebilirsin)

---

## Kullanılan Teknolojiler

- **Java (Servlet / JSP)**
- **Apache Tomcat**
- **MySQL**
- **JDBC (MySQL Connector/J)**
- HTML, CSS, Bootstrap
- Git & GitHub

---

## Veritabanı Yapısı

### kullanıcılar
- id
- kullanıcı_adı
- email
- şifre

### kitaplar
- id
- kitap_adı
- yazar
- kategori_id
- fiyat
- stok
- açıklama

### kategoriler
- id
- kategori_adı

---

## Kurulum ve Çalıştırma

### 1. Projeyi klonlayın
```bash
git clone https://github.com/your-username/bookstore-web-app.git
```

### 2. IDE ile açın

* Eclipse / IntelliJ IDEA kullanabilirsiniz.

### 3. MySQL veritabanını oluşturun

```bash
CREATE DATABASE bookstore;
```
### 4. MySQL Connector ekleyin

* mysql-connector-j.jar dosyasını projeye dahil edin

### 5. Tomcat Server ayarlayın

* Projeyi Apache Tomcat üzerinde çalıştırın

### 6. Veritabanı bağlantısı

```bash
jdbc:mysql://localhost:3306/bookstore
username=root
password=yourpassword
```

## Gelecek Geliştirmeler

* REST API geliştirme
* Gelişmiş arama sistemi
* Modern frontend (React entegrasyonu)
