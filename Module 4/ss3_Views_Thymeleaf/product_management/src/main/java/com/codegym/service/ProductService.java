package com.codegym.service;

import com.codegym.model.Product;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProductService implements IProductService{
    private static final Map<Integer, Product> products;
    static {
        products = new HashMap<>();
        products.put(1, new Product(1, "Iphone X pro", 12000000, "Apple"));
        products.put(2, new Product(2, "Samsung A2", 10000000, "Samsung"));
        products.put(3, new Product(3, "Oppo A1", 8000000, "Oppo"));
        products.put(4, new Product(4, "Xiaomi", 4000000, "Xiaomi"));
    }


    @Override
    public List<Product> findAll() {
        return new ArrayList<>(products.values());
    }

    @Override
    public void save(Product product) {
        products.put(product.getProduct_id(), product);
    }

    @Override
    public Product findById(int id) {
        return products.get(id);
    }

    @Override
    public void update(int id, Product product) {
        products.put(id, product);
    }

    @Override
    public void remove(int id) {
        products.remove(id);
    }

    @Override
    public List<Product> search(String name) {
        Map<Integer, Product> newProductList = new HashMap<>();
        for (Product product:products.values()) {
            if (product.getProduct_name().equals(name)){
                newProductList.put(product.getProduct_id(), product);
            }
        }
        return new ArrayList<>(newProductList.values());
    }
}
