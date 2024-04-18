package org.example.sampledao.dao;

import org.example.sampledao.exceptions.CatalogDAOSysException;
import org.example.sampledao.model.Category;
import org.example.sampledao.model.Product;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class MysqlCatalogDAO implements CatalogDAO {
    public static String GET_CATEGORY_STATEMENT = "SELECT * FROM category WHERE id = ?";
    public static String GET_CATEGORIES_STATEMENT = "SELECT * FROM category";
    public static String GET_PRODUCT_STATEMENT = "SELECT * FROM product WHERE id = ?";
    public static String GET_PRODUCTS_STATEMENT = "SELECT * FROM product";

    // Helper method to connect to the database
    private Connection getConnection() throws CatalogDAOSysException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/test_sampledao";
            String user = "dev";
            String password = "something@complicated";
            Connection con = DriverManager.getConnection(url, user, password);
            System.out.println("Connect success!");
            return con;
        } catch (SQLException e) {
            throw new CatalogDAOSysException("Exception while getting connection: " + e.getMessage());
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("Driver class not found: " + e.getMessage());
        }
    }

    @Override
    public Category getCategory(int categoryId) throws CatalogDAOSysException {
        Connection con;
        PreparedStatement ps;
        ResultSet rs;
        Category category = null;
        try {
            con = getConnection();
            ps = con.prepareStatement(GET_CATEGORY_STATEMENT);
            ps.setInt(1, categoryId);
            rs = ps.executeQuery();
            if (rs.next()) {
                category = new Category(rs.getInt(1), rs.getString(2), rs.getString(3));
            }
            rs.close();
            ps.close();
            con.close();
            return category;
        } catch (SQLException e) {
            throw new CatalogDAOSysException("SQL Exception: " + e.getMessage());
        }
    }

    @Override
    public Category[] getCategories() throws CatalogDAOSysException {
        Connection con;
        PreparedStatement ps;
        ResultSet rs;
        List<Category> categories = new ArrayList<>();
        try {
            con = getConnection();
            ps = con.prepareStatement(GET_CATEGORIES_STATEMENT);
            rs = ps.executeQuery();
            while (rs.next()) {
                Category category = new Category(rs.getInt(1), rs.getString(2), rs.getString(3));
                categories.add(category);
            }
            rs.close();
            ps.close();
            con.close();
            return categories.toArray(new Category[0]);
        } catch (SQLException e) {
            throw new CatalogDAOSysException("SQL Exception: " + e.getMessage());
        }

    }

    @Override
    public Product getProduct(int productId) throws CatalogDAOSysException {
        Connection con;
        PreparedStatement ps;
        ResultSet rs;
        Product product = null;
        Category category;
        try {
            con = getConnection();
            ps = con.prepareStatement(GET_PRODUCT_STATEMENT);
            ps.setInt(1, productId);
            rs = ps.executeQuery();
            if (rs.next()) {
                product = new Product();
                product.setId(rs.getInt(1));
                product.setName(rs.getString(2));
                product.setDescription(rs.getString(3));
                product.setCategory(getCategory(rs.getInt(4)));
            }
            rs.close();
            ps.close();
            con.close();
            return product;
        } catch (SQLException e) {
            throw new CatalogDAOSysException("SQL Exception: " + e.getMessage());
        }

    }

    @Override
    public Product[] getProducts() throws CatalogDAOSysException {
        Connection con;
        PreparedStatement ps;
        ResultSet rs;
        List<Product> products = new ArrayList<>();
        try {
            con = getConnection();
            ps = con.prepareStatement(GET_PRODUCTS_STATEMENT);
            rs = ps.executeQuery();
            while (rs.next()) {
                Product product = new Product();
                product.setId(rs.getInt(1));
                product.setName(rs.getString(2));
                product.setDescription(rs.getString(3));
                product.setCategory(getCategory(rs.getInt(4)));
                products.add(product);
            }
            return products.toArray(new Product[0]);
        } catch (Exception e) {
            throw new CatalogDAOSysException("SQL Exception: " + e.getMessage());
        }
    }
}
