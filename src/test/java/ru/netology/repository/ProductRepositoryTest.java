package ru.netology.repository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.NotFoundException;
import ru.netology.domain.Product;
import ru.netology.domain.TShort;

import static org.junit.jupiter.api.Assertions.*;

class ProductRepositoryTest {
    private ProductRepository repository = new ProductRepository();
    private Product book1 = new Book(1, "book1", 1, "author1");
    private Product book2 = new Book(2, "book2", 2, "author2");
    private Product tshort1 = new TShort(3, "t-short1", 100, "red");
    private Product tshort2 = new TShort(4, "t-short2", 200, "white");

    @BeforeEach
    public void repositoryInit() {
        repository.add(book1);
        repository.add(book2);
        repository.add(tshort1);
        repository.add(tshort2);
    }

    @Test
    void ShouldRemoveExistItemById() {
        this.repository.removeById(2);
        Product[] actual = this.repository.getItems();
        Product[] expected = {book1, tshort1, tshort2};
        assertArrayEquals(expected, actual);
    }

    @Test
    void ShouldRemoveNoexistItemById() {
        assertThrows(NotFoundException.class, () -> {
            this.repository.removeById(10);
        });
    }
}