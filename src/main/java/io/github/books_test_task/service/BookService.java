package io.github.books_test_task.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import io.github.books_test_task.entity.Book;
import io.github.books_test_task.form.BookDto;
import io.github.books_test_task.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BookService {
    private final BookRepository bookRepository;

    public Page<BookDto> getBooks(String title, String brand, Integer year, Pageable pageable) {
        Specification<Book> spec = Specification.where(BookSpecification.hasBrand(brand))
                .and(BookSpecification.hasYear(year))
                .and(BookSpecification.hasTitle(title));

        return bookRepository.findAll(spec, pageable).map(BookDto::fromEntity);
    }

    public BookDto createBook(BookDto bookDto) {
        Book book = new Book();
        book.setVendorCode(bookDto.vendorCode());
        book.setBrand(bookDto.brand());
        book.setTitle(bookDto.title());
        book.setYear(bookDto.year());
        book.setPrice(bookDto.price());
        book.setStock(bookDto.stock());
        return BookDto.fromEntity(bookRepository.save(book));
    }

    public BookDto updateBook(BookDto bookDto, Long id) {
        Book book = new Book();
        book.setId(id);
        book.setVendorCode(bookDto.vendorCode());
        book.setBrand(bookDto.brand());
        book.setTitle(bookDto.title());
        book.setYear(bookDto.year());
        book.setPrice(bookDto.price());
        book.setStock(bookDto.stock());
        return BookDto.fromEntity(bookRepository.save(book));
    }

    public void deleteBookById(Long id) {
        bookRepository.deleteById(id);
    }
}
