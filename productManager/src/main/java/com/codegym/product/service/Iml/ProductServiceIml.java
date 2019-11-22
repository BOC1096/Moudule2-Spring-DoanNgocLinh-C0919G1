package com.codegym.product.service.Iml;

import com.codegym.product.model.Product;
import com.codegym.product.service.ProductService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class ProductServiceIml implements ProductService {
    private static Map<Integer, Product> productMap;

    static {
        productMap = new HashMap<Integer, Product>();
        productMap.put(1, new Product(1, "Iphone8", 500));
        productMap.put(2, new Product(2, "Nokia7", 400));
        productMap.put(3, new Product(3, "Bphone", 300));
        productMap.put(4, new Product(4, "Note10", 600));
        productMap.put(5, new Product(5, "IphoneSE", 150));
        productMap.put(6, new Product(6, "GalaxyS10", 450));
        productMap.put(7, new Product(7, "Iphone11Pro", 800));
    }

    @Override
    public List<Product> findAll() {
        return new ArrayList<Product>(productMap.values());
    }

    @Override
    public void save(Product product) {
        productMap.put(product.getId(), product);
    }

    @Override
    public Product findById(int id) {
        return productMap.get(id);
    }

    @Override
    public void delete(int id) {
        productMap.remove(id);
    }
}
