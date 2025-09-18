package com.gtelant.commerce.service.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "products")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id")
    private int id;

    @Column(name = "image_url",nullable = false)
    private String imageURL;

    @Column(name = "Thumbnail_url",nullable = false)
    private String thumbnailURL;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id")
    private Category category;

    @Column(name = "product_name")
    private String name;

    @Column(name = "width")
    private double width;
    @Column(name = "height")
    private double height;
//    @Column(name = "length")
//    private double length;

    @Column(name = "price")
    private BigDecimal price;

    @Column(name = "stock")
    private int stock;

    @Column(name = "sales")
    private int sales;

    @Column(name = "description")
    private String reference;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Column(name = "delete_at")
    private LocalDateTime deleteAt;

}
