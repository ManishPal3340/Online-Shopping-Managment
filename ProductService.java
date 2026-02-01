package com.shopingsystem.service;
//package com.onlineshop.service;

import com.shopingsystem.dao.ProductDAO;
import com.shopingsystem.model.Product;

import java.util.List;

public class ProductService {

    private ProductDAO productDAO = new ProductDAO();

    public void addProduct(Product product) {
        productDAO.saveProduct(product);
    }

    public Product getProductById(int id) {
        return productDAO.getProductById(id);
    }

    public List<Product> getAllProducts() {
        return productDAO.getAllProducts();
    }

    public void updateProduct(Product product) {
        productDAO.updateProduct(product);
    }
}
