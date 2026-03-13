package com.inventory.main;

import com.inventory.dao.ProductDAO;
import com.inventory.entity.Product;

public class App {

    public static void main(String[] args) {

        ProductDAO dao = new ProductDAO();

        Product p1 = new Product("Laptop", 72000.0, 8, "Gaming Laptop");
        Product p2 = new Product("Mouse", 1200.0, 50, "Wireless Mouse");

        dao.saveProduct(p1);
        dao.saveProduct(p2);

        System.out.println("Products inserted successfully");
    }
}