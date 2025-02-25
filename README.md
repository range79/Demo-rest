# Demo REST API

Bu proje, Spring Boot kullanarak geliştirilmiş bir REST API örneğidir. Amacı, Spring Boot'un çeşitli özelliklerini ve entegrasyonlarını kullanarak backend geliştirme becerilerimi test etmektir.

## Kullandığım Teknolojiler

- **Spring Boot**: Uygulamanın temel çatısı. API'yi oluşturmak ve yönetmek için kullanılır.
    - `spring-boot-starter-web`: Web uygulamaları geliştirmek için gerekli olan bağımlılıkları içerir.
    - `spring-boot-starter-data-jpa`: JPA (Java Persistence API) kullanarak veritabanı işlemleri yapmayı sağlar.
    - `springdoc-openapi-starter-webmvc-ui`: OpenAPI (Swagger) desteği sağlar, API'yi test etmek ve dökümantasyon sağlamak için kullanılır.
- **MySQL**: Veritabanı yönetim sistemi olarak kullanılmıştır. `mysql-connector-j` bağımlılığı ile bağlantı sağlanır.
- **Lombok**: Java sınıflarındaki getter, setter, toString gibi metodları otomatik olarak oluşturur.
- **Spring Boot DevTools**: Geliştirme sürecini hızlandırmak için otomatik yeniden başlatma ve diğer araçları sağlar.

## Kurulum

Proje, Spring Boot kullanılarak geliştirilmiştir. Aşağıdaki adımları izleyerek projeyi kurabilir ve çalıştırabilirsiniz.

1. **Java ve Maven Kurulumu**:
    - Projeyi çalıştırmadan önce, Java ve Maven'ın sisteminizde yüklü olduğundan emin olun.

2. **Bağımlılıkların İndirilmesi**:
    - Terminal veya komut satırında aşağıdaki komutu çalıştırarak bağımlılıkları indirin:
      ```bash
      ./mvnw install
      ```

3. **Uygulamanın Çalıştırılması**:
    - Spring Boot uygulamasını çalıştırmak için aşağıdaki komutu kullanın:
      ```bash
      ./mvnw spring-boot:run
      ```

## Kullanım

Uygulama başlatıldığında, API'ye aşağıdaki URL üzerinden erişebilirsiniz:

- [http://localhost:8080](http://localhost:8080)

## Docker Desteği

Proje, Docker üzerinden çalıştırılabilir. Docker Compose kullanılarak gerekli hizmetler (örneğin, MySQL veritabanı) ile birlikte projeyi başlatabilirsiniz.

### Docker Compose ile Veritabanı Başlatma

Proje, Docker Compose kullanarak veritabanını başlatmaktadır. MySQL veritabanı, aşağıdaki `docker-compose.yml` dosyası ile çalıştırılmaktadır:

# 📌 Sürüm Notları

---

## 🚀 **Version 0.0.1-SNAPSHOT**
✔ İlk sürüm yayımlandı, **temel fonksiyonlar** eklendi.

---

## 🎯 **Version 1.0.0-SNAPSHOT**

### 🛠 **Docker Optimizasyonu**
🔹 Tüm proje yerine **yalnızca MySQL’in Docker üzerinden çalışması** sağlandı.

### 📂 **Yeni Paketler & Yapılandırmalar**
✅ **`exception`** paketi eklendi.  
✅ **`dto`** paketi oluşturuldu.  
✅ **GlobalExceptionHandler** sınıfı eklendi.

### 🔄 **Metot Güncellemeleri**
🔹 `updateUser` metodu, yalnızca şifre güncelleme işlemi yapacak şekilde **`updatePassword`** olarak değiştirildi.

---

## 🚀 **Version 1.1.0**

### ⚡ **Service Katmanı Optimizasyonları**
🔹 Service katmanında performans iyileştirmeleri yapıldı.

### 🏗 **Yeni DTO'lar**
✅ **`UserResponseDto`** eklendi.  
✅ **`ErrorResponse`** eklendi.

### 🚨 **Exception Yönetimi Güncellendi**
🔹 **GlobalExceptionHandler** üzerinde daha kapsamlı hata yakalama mekanizmaları eklendi.

### 🎛 **Controller Güncellemeleri**
🔹 **UserController** içinde kod refaktör edildi ve iyileştirmeler yapıldı.

---

## 🔐 **Version 1.2.0**

### ✅ **Validation Geliştirmeleri**
🔹 **Validation kütüphanesi** projeye eklendi.  
🔹 **Şifre güvenliği artırıldı** → **Minimum 8 karakter olmalı.**

### 🆕 **Yeni DTO Güncellemeleri**
✅ **`UserRegisterRequest`** DTO’su eklendi.

### 🛠 **Service Güncellemeleri**
🔹 **`UserServiceImpl`** içinde kod düzenlemeleri ve optimizasyonlar yapıldı.

---

## 🔐 **Version 1.3.0**

### 🔒 **Güvenlik Geliştirmeleri**
🔹 **`getAllUsers` metodu** daha güvenli hale getirildi; artık **`User`** nesnesi yerine **`UserResponseDto`** döndürüyor.  
🔹 **`changePassword` metodu** güncellendi; artık şifre ile birlikte kullanıcı adı da değiştirilebiliyor.  
🔹 **`getById` metodu** daha güvenli hale getirildi.

### 🛠 **Diğer Güncellemeler**
🔹 **`impl` paketi** artık küçük harf ile yazılıyor.  
🔹 **Controller sınıfında dönüş tipleri düzenlendi**, kod daha okunaklı hale getirildi.

