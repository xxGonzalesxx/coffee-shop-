package com.coffeeshop.config;

import com.coffeeshop.entity.Product;
import com.coffeeshop.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import java.math.BigDecimal;

@Component
@RequiredArgsConstructor
public class DataInitializer implements CommandLineRunner {
    private final ProductRepository productRepository;

    @Override
    public void run(String... args) {
        // Кофе
        productRepository.save(Product.builder()
                .name("Эспрессо")
                .description("Классический крепкий кофе")
                .price(BigDecimal.valueOf(180))
                .category("coffee")
                .image("/images/menu/coffee/espresso.jpg")  // Убрал "(1)"
                .build());

        productRepository.save(Product.builder()
                .name("Капучино")
                .description("Кофе с молочной пенкой")
                .price(BigDecimal.valueOf(220))
                .category("coffee")
                .image("/images/menu/coffee/cappuccino.jpg")
                .build());

        productRepository.save(Product.builder()
                .name("Латте")
                .description("Нежный кофе с молоком")
                .price(BigDecimal.valueOf(240))
                .category("coffee")
                .image("/images/menu/coffee/latte.jpg")
                .build());

        // Чай
        productRepository.save(Product.builder()
                .name("Зеленый чай")
                .description("Освежающий зеленый чай")
                .price(BigDecimal.valueOf(150))
                .category("tea")
                .image("/images/menu/tea/green-tea.jpg")  // Изменил на локальный
                .build());

        // Десерты
        productRepository.save(Product.builder()
                .name("Тирамису")
                .description("Итальянский десерт")
                .price(BigDecimal.valueOf(280))
                .category("dessert")
                .image("/images/menu/desserts/tiramisu.jpg")  // Изменил на локальный
                .build());

        productRepository.save(Product.builder()
                .name("Круассан")
                .description("Свежая французская выпечка")
                .price(BigDecimal.valueOf(120))
                .category("dessert")
                .image("/images/menu/desserts/croissant.jpg")  // Добавил новый
                .build());
    }
}