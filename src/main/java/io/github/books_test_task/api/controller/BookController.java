package io.github.books_test_task.api.controller;

import io.github.books_test_task.form.BookDto;
import io.github.books_test_task.service.BookService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/books")
@RequiredArgsConstructor
public class BookController {
    private final BookService bookService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public String getBooks(
            Model model,
            @RequestParam(required = false) String title,
            @RequestParam(required = false) String brand,
            @RequestParam(required = false) Integer year,
            @PageableDefault Pageable pageable
    ) {
        model.addAttribute("books", bookService.getBooks(title, brand, year, pageable).get().toList());
        return "books";
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public BookDto createBook(
            @Valid @RequestBody BookDto bookDto
    ) {
        return bookService.createBook(bookDto);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public BookDto updateBook(
            @Valid @RequestBody BookDto bookDto,
            @PathVariable Long id
    ) {
        return bookService.updateBook(bookDto, id);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteBook(
            @PathVariable Long id
    ) {
        bookService.deleteBookById(id);
    }
}
