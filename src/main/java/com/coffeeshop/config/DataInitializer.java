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
                .image("https://images.unsplash.com/photo-1514432324607-a09d9b4aefdd?w=400")
                .build());

        productRepository.save(Product.builder()
                .name("Капучино")
                .description("Кофе с молочной пенкой")
                .price(BigDecimal.valueOf(220))
                .category("coffee")
                .image("https://images.unsplash.com/photo-1572442388796-11668a67e53d?w=400")
                .build());

        productRepository.save(Product.builder()
                .name("Латте")
                .description("Нежный кофе с молоком")
                .price(BigDecimal.valueOf(240))
                .category("coffee")
                .image("https://images.unsplash.com/photo-1561047029-3000c68339ca?w=400")
                .build());

        // Чай
        productRepository.save(Product.builder()
                .name("Зеленый чай")
                .description("Освежающий зеленый чай")
                .price(BigDecimal.valueOf(150))
                .category("tea")
                .image("https://images.unsplash.com/photo-1544787219-7f47ccb76574?w=400")
                .build());

        // Десерты
        productRepository.save(Product.builder()
                .name("Тирамису")
                .description("Итальянский десерт")
                .price(BigDecimal.valueOf(280))
                .category("dessert")
                .image("https://images.unsplash.com/photo-1571877227200-a0d98ea607e9?w=400")
                .build());

        productRepository.save(Product.builder()
                .name("Чизкейк")
                .description("Нежный чизкейк Нью-Йорк")
                .price(BigDecimal.valueOf(320))
                .category("dessert")
                .image("https://images.unsplash.com/photo-1567306301408-9b74779a11af?w=400")
                .build());
    }
}