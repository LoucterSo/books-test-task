package io.github.books_test_task.service;

import io.github.books_test_task.entity.Book;
import org.springframework.data.jpa.domain.Specification;


public class BookSpecification {
    public static Specification<Book> hasBrand(String brand) {
        return (root, query, cb) -> brand == null ? null :
                cb.equal(root.get("brand"), brand);
    }

    public static Specification<Book> hasTitle(String title) {
        return (root, query, cb) -> title == null ? null :
                cb.equal(root.get("title"), title);
    }

    public static Specification<Book> hasYear(Integer year) {
        return (root, query, cb) -> year == null ? null :
                cb.equal(root.get("year"), year);
    }
}
