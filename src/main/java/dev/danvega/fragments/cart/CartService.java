package dev.danvega.fragments.cart;

import dev.danvega.fragments.product.Product;
import dev.danvega.fragments.product.Size;
import dev.danvega.fragments.product.Stock;
import jakarta.annotation.PostConstruct;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CartService {

    private static final Logger log = LoggerFactory.getLogger(CartService.class);
    private final List<Product> products = new ArrayList<>();

    public List<Product> findAll() {
        return products;
    }

    public void remove(Integer id) {
        log.info("Removing product with id: {}", id);
        products.removeIf(p -> p.id().equals(id));
    }

    public Integer getOrderSubTotal() {
        return products.stream()
                .mapToInt(Product::price)
                .sum();
    }

    public Integer getOrderTotal() {
        return getOrderSubTotal() + 5;
    }

    /**
     * Initialize the collection with 3 products
     */
    @PostConstruct
    private void init() {
        var p1 = new Product(1,"Basic Tee", "Sienna", Size.LARGE,32, Stock.IN_STOCK,"shopping-cart-page-01-product-01.jpg","Front of men&#039;s Basic Tee in sienna.");
        var p2 = new Product(2,"Basic Tee", "Black", Size.LARGE,32, Stock.ONE_MONTH,"shopping-cart-page-01-product-02.jpg","Front of men&#039;s Basic Tee in black.");
        var p3 = new Product(3,"Nomad Tumbler", "White",null,35, Stock.IN_STOCK,"shopping-cart-page-01-product-03.jpg","Insulated bottle with white base and black snap lid.");
        products.addAll(List.of(p1,p2,p3));
    }

}
