package org.example.sampledao.dao;

import org.example.sampledao.exceptions.CatalogDAOSysException;
import org.example.sampledao.model.Category;
import org.example.sampledao.model.Product;

/**
 * This class is an interface which will be implemented by database specific
 * code.
 * This class encapsulates all the SQL calls made by Catalog REST
 * This layer maps the relational data stored in the database to
 * the objects needed by Catalog REST
*/
public interface CatalogDAO {
    public Category getCategory(int categoryId)
        throws CatalogDAOSysException;
    public Category[] getCategories()
        throws CatalogDAOSysException;
    public Product getProduct(int productId)
        throws CatalogDAOSysException;
    public Product[] getProducts()
        throws CatalogDAOSysException;
}