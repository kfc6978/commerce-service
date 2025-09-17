# E-Commerce Admim Dashboard API系統開發
### 根據 https://marmelab.com/react-admin-demo ，使用 Springboot+MySQL 開發管理後台 API 系統，並以 Swagger 呈現文件。

### 支援：
    A. 銷售模組
        a. 訂單管理 
        b. 發票管理
    B. 產品模組
        a. 產品管理
        b. 產品類別管理
    C. 用戶模組
        a. 用戶管理
        b. 用戶標籤管理
    D. 評論模組


# 初始化專案
## SQL 連線

### 預先於本地建立資料庫
```declarative
CREATE DATABASE commerce_db;
```
### DB連線資訊

application.properties
```declarative
spring.datasource.url=jdbc:mysql://localhost:3306/commerce_db
spring.datasource.username=<username>
spring.datasource.password=<password>

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
```