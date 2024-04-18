package org.example.sampledao.exceptions;

public class CatalogDAOSysException extends RuntimeException {

    /**
     * Constructor
     * @param str    a string that explains what the exception condition is
     */
    public CatalogDAOSysException(String str) {
        super(str);
    }

    /**
     * Default constructor. Takes no arguments
     */
    public CatalogDAOSysException() {
        super();
    }
}
