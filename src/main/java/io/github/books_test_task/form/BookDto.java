package io.github.books_test_task.form;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.github.books_test_task.entity.Book;
import jakarta.validation.constraints.*;
import java.math.BigDecimal;

public record BookDto(
        Long id,
        @NotNull
        @NotBlank
        @JsonProperty("vendor_code")
        String vendorCode,
        @NotNull
        @NotBlank
        String title,
        @NotNull
        @Min(value = 1000)
        Integer year,
        @NotNull
        @NotBlank
        String brand,
        @NotNull
        @PositiveOrZero
        Long stock,
        @NotNull
        @PositiveOrZero
        BigDecimal price
) {

    public static BookDto fromEntity(Book book) {
        return new BookDto(
                book.getId(),
                book.getVendorCode(),
                book.getTitle(),
                book.getYear(),
                book.getBrand(),
                book.getStock(),
                book.getPrice());
    }
}
