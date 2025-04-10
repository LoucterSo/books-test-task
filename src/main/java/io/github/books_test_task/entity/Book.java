package io.github.books_test_task.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.math.BigDecimal;

@Entity
@Table
@Setter @Getter
@NoArgsConstructor
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(name = "vendor_code")
    private String vendorCode;

    @NotNull
    private String title;

    @NotNull
    private Integer year;

    @NotNull
    private String brand;

    @NotNull
    private Long stock;

    @NotNull
    private BigDecimal price;

    public Book(String vendorCode, String title, Integer year, String brand, Long stock, BigDecimal price) {
        this.vendorCode = vendorCode;
        this.title = title;
        this.brand = brand;
        setYear(year);
        setStock(stock);
        setPrice(price);
    }
}
