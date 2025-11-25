☕ Кофейня "Уют" - Веб-приложение
Красивое веб-приложение кофейни с возможностью просмотра меню и оформления заказов. Разработано на Spring Boot с использованием Docker.

🚀 Быстрый старт
1. Установите Docker
Windows/Mac: Скачайте с официального сайта Docker

Linux:

bash
sudo apt update
sudo apt install docker.io
sudo systemctl start docker
sudo systemctl enable docker
2. Запустите приложение
bash
# Клонируйте репозиторий
git clone https://github.com/xxGonzalesxx/coffee-shop-.git
cd coffee-shop-

# Запустите в Docker
docker-compose up --build
3. Откройте в браузере
text
http://localhost:8080
📁 Структура проекта
🏗️ Архитектура

coffee-shop/
├── src/main/java/com/coffeeshop/
│   ├── entity/              # Сущности базы данных
│   ├── repository/          # Репозитории для работы с БД
│   ├── controller/          # Контроллеры веб-страниц
│   ├── config/              # Конфигурации
│   └── CoffeeShopApplication.java
├── src/main/resources/
│   ├── templates/           # HTML страницы
│   └── application.properties
├── Dockerfile              # Конфигурация Docker
├── docker-compose.yml      # Оркестрация контейнеров
└── pom.xml                # Зависимости Maven

🗃️ Классы и их назначение
Entity классы (Модели данных)
1. Product - Товары
java
@Entity
@Data
public class Product {
    private Long id;
    private String name;        // Название товара
    private String description; // Описание
    private BigDecimal price;   // Цена
    private String category;    // Категория (coffee, tea, dessert)
    private String image;       // URL изображения
}
2. Order - Заказы
java
@Entity
@Data
public class Order {
    private Long id;
    private String customerName; // Имя клиента
    private String phone;        // Телефон
    private String address;      // Адрес доставки
    private String status;       // Статус заказа
    private LocalDateTime createdAt; // Дата создания
    private List<OrderItem> items;   // Позиции заказа
}
3. OrderItem - Позиции заказа
java
@Entity
@Data
public class OrderItem {
    private Long id;
    private Long productId;     // ID товара
    private String productName; // Название товара
    private Integer quantity;   // Количество
    private BigDecimal price;   // Цена за единицу
}
Repository классы (Доступ к данным)
1. ProductRepository
java
public interface ProductRepository extends JpaRepository<Product, Long> {
    List<Product> findByCategory(String category); // Поиск по категории
}
2. OrderRepository
java
public interface OrderRepository extends JpaRepository<Order, Long> {
    // Базовые операции CRUD
}
Controller классы (Веб-контроллеры)
MainController - Основной контроллер
GET / - Главная страница

GET /menu - Страница меню

GET /about - Страница "О нас"

GET /order - Форма заказа

POST /order - Обработка заказа

GET /order-success - Страница успешного заказа

Config классы (Конфигурация)
DataInitializer - Инициализатор данных
Автоматически заполняет базу тестовыми товарами при запуске

🌐 Страницы приложения
📍 Главная страница (/)
Красивая шапка с hero-секцией

Блок преимуществ кофейни

Популярные товары

Адаптивный дизайн

📋 Меню (/menu)
Разделы: Кофе, Чай, Десерты

Карточки товаров с изображениями

Цены и описания

ℹ️ О нас (/about)
История кофейни

Фотография интерьера

Команда сотрудников

🛒 Заказ (/order)
Форма для оформления заказа

Ввод имени, телефона, адреса

Валидация данных

🛠️ Технологии
Backend: Spring Boot 3.2, Spring Data JPA, Lombok

Frontend: Thymeleaf, Bootstrap 5, HTML5, CSS3

Database: H2 (встроенная), PostgreSQL (готово для продакшена)

Container: Docker, Docker Compose

Java: 17

🗄️ База данных
H2 Console (для разработки)
text
http://localhost:8080/h2-console
JDBC URL: jdbc:h2:mem:coffeeshopdb

Username: sa

Password: (пусто)

📦 Docker контейнеры
coffee-shop - Основное приложение
Порт: 8080

Собирается из Dockerfile

Автоматический деплой

postgres - База данных (опционально)
Порт: 5432

Готова конфигурация для продакшена

🚀 Команды для работы
Разработка
bash
# Сборка и запуск
mvn clean package
docker-compose up --build

# Только сборка
docker-compose build

# Запуск в фоне
docker-compose up -d

# Остановка
docker-compose down
Миграция на PostgreSQL
bash
# В docker-compose.yml раскомментируйте секцию postgres
# В application.properties укажите:
# spring.datasource.url=jdbc:postgresql://postgres:5432/coffeeshop
👥 Для разработчиков
Добавление нового товара
Достаточно добавить запись в DataInitializer.java:

java
productRepository.save(new Product(
    null, "Новый кофе", "Описание", 
    BigDecimal.valueOf(250), "coffee", "image-url"
));
Добавление новой страницы
Создать HTML в templates/

Добавить метод в MainController

Обновить навигацию


📞 Контакты
Телефон: +7 (999) 123-45-67

Адрес: ул. Свободы, 2В

GitHub: xxGonzalesxx/coffee-shop-
Матвей универ
