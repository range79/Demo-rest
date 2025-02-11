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

**Version 0.0.1-snapshot**
- ilk sürüm olduğundan çokta fazla sey eklemedim.

**Version 1.0.0-SNAPSHOT**
- bu sürümde docker ıle tüm projenın buıld edılmesını gereksız buldugumdan sadece mysqlin docker tarafından calışmasını sagladım
- Exception paketi eklendi
- Dto paketi eklendi
- GlobalExceptionHandler eklendi
- updateUser->Updatepassworda değisitirildi

**Version 1.1.0**
- bu sürümde Servıceye düzenlemeler yapıldı
- UserResponseDto EKlendı 
- ErrorResponse Paketı eklendı
- GlobalExceptıon handlerden duzenlemeler yapıldı
- Controllere duzenlemeler yapıldı