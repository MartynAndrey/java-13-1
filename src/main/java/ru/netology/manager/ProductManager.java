package ru.netology.manager;
import ru.netology.domain.Product;
import ru.netology.domain.Book;
import ru.netology.domain.TShort;
import ru.netology.repository.ProductRepository;

public class ProductManager {
    private ProductRepository repository;

    public ProductManager(ProductRepository repository) {
        this.repository = repository;
    }

    public ProductRepository getRepository() {
        return this.repository;
    }

    public void add(Product product) {
        this.repository.add(product);
    }

    public Product[] searchBy(String text) {
        Product[] result = new Product[0];
        for (Product product : this.repository.getItems()) {
            if (matches(product, text)) {
                Product[] tmp = new Product[result.length + 1];
                System.arraycopy(result, 0, tmp, 0, result.length);
                tmp[tmp.length - 1] = product;
                result = tmp;
            }
        }
        return result;
    }

    public boolean matches(Product product, String search) {
        if (product instanceof Book) {
            Book book = (Book) product;
            if (book.getName().contains(search)) {
                return true;
            }
            return book.getAuthor().contains(search);
        }
        if (product instanceof TShort) {
            TShort tshort = (TShort) product;
            if (tshort.getName().contains(search)) {
                return true;
            }
            return tshort.getColor().contains(search);
        }
        return false;
    }
}