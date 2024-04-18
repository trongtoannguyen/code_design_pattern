package org.example.sampledao.controller;

import org.example.sampledao.dao.CatalogDAO;
import org.example.sampledao.model.Category;
import org.example.sampledao.model.Product;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CatalogController {

    private final CatalogDAO catalogDAO;

    public CatalogController(CatalogDAO catalogDAO) {
        this.catalogDAO = catalogDAO;
    }

    @GetMapping("/products")
    List<Product> getAllProducts() {
        return List.of(catalogDAO.getProducts());
    }

    @GetMapping("/product/{id}")
    Product getProduct(@PathVariable int id ){
        return catalogDAO.getProduct(id);
    }

    @GetMapping("/categories")
    List<Category> getAllCategories() {
        return List.of(catalogDAO.getCategories());
    }

    @GetMapping("/category/{id}")
    Category getCategory(@PathVariable int id) {
        return catalogDAO.getCategory(id);
    }
}