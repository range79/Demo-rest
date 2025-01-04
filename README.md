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
- **Docker** Docker uygulamayı ızole ortamda çalışmasını sağlar.
- **Docker-compose** Birden fazla Docker uygulamasını aynı anda başlatmamı sağlar.
## Kurulum

Proje, Spring Boot kullanılarak geliştirilmiştir. Aşağıdaki adımları izleyerek projeyi kurabilir ve çalıştırabilirsiniz.

1. **Java ve Maven Kurulumu**:
    - Projeyi çalıştırmadan önce, Java ve Maven'ın sisteminizde yüklü olduğundan emin olun.

2. **Bağımlılıkların İndirilmesi**:
    - Terminal veya komut satırında aşağıdaki komutu çalıştırarak bağımlılıkları indirin:
      ```bash
      ./gradlew build 
      ```

3. **Uygulamanın Çalıştırılması**:
    - Spring Boot uygulamasını çalıştırmak için aşağıdaki komutu kullanın:
      ```bash
      ./gradlew bootrun
      ```

## Kullanım

Uygulama başlatıldığında, API'ye aşağıdaki URL üzerinden erişebilirsiniz:

- [http://localhost:8080](http://localhost:8080)



## APi Dokümantasyonu(Swagger-ui)

Uygulamanın Swagger-ui Endpointi:

- [Swagger-ui](http://localhost:8080/swagger-ui/index.html)




## Docker Desteği

Proje, Docker üzerinden çalıştırılabilir. Docker Compose kullanılarak gerekli hizmetler (örneğin, MySQL veritabanı) ile birlikte projeyi başlatabilirsiniz.

### Docker Compose ile Veritabanı Başlatma

Proje, Docker Compose kullanarak başlatmaktadır.    Uygulama, aşağıdaki `compose.yml` dosyası ile çalıştırılmaktadır:

1. **Docker Compose ile Projeyi Başlatma**:
   ```bash
   docker-compose up

### Version degisiklikleri
1. **Version 0.0.1**
   -ilk sürüm olduğundan çokta fazla sey eklemedimç



2. **Version 1.1.0**
   -Bu sürümde Docker ile tam uygulama başlatma desteği ve Banner eklenmiştir ve readme düzeltildi.

