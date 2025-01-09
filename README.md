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
- **Spring security** Güvenlık saglamak içın kullanIrim
## Kurulum

Proje, Spring Boot kullanılarak geliştirilmiştir. Aşağıdaki adımları izleyerek projeyi kurabilir ve çalıştırabilirsiniz.

1. **Java ve Maven Kurulumu**:
    - Projeyi çalıştırmadan önce, Java ve Maven'ın sisteminizde yüklü olduğundan emin olun.(eger docker kullanmıyacaksanız)
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
   - ilk sürüm olduğundan çokta fazla sey eklemedimç



2. **Version 1.1.0**
   - Bu sürümde Docker ile tam uygulama başlatma desteği ve Banner eklenmiştir ve readme düzeltildi.
3. **Version 1.2.0**  
   - Bu sürümde Docker içinde uygulama derleneniyor ve başlıyor eger docker compose olmadan derlemek ıstıyorsanız
 
   #### MYSQL varsa çalışan
```shell
 ./gradlew  build  
 ```
 #### MYSQL çalıştırmadan derlemek ıstıyorsanız 
```shell
 ./gradlew build -x test
```
   - composefile  duzenlendi 
   - gelen guncellemede security eklicem
4. **Version 2.0**
   - Security eklendi ama securitye role gerektiren endpointler ayarlanmadi onlari gelen güncellemede ayarlıyacam
   - Roller enumu eklendı
5. **Version 2.0,1**
  - Jwtden vazgectim bu uygulamada jwt kullanmiyacagim