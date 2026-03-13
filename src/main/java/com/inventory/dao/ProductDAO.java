package com.inventory.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.inventory.entity.Product;
import com.inventory.util.HibernateUtil;

public class ProductDAO {

    // Save Product
    public void saveProduct(Product product) {

        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;

        try {
            tx = session.beginTransaction();

            session.save(product);

            tx.commit();
            System.out.println("Product saved successfully");

        } catch (Exception e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    // Update Product
    public void updateProduct(int id, int price, int quantity) {

        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;

        try {
            tx = session.beginTransaction();

            Product product = session.get(Product.class, id);

            if (product != null) {
                product.setPrice(price);
                product.setQuantity(quantity);

                session.update(product);
                System.out.println("Product updated successfully");
            } else {
                System.out.println("Product not found");
            }

            tx.commit();

        } catch (Exception e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    // Delete Product
    public void deleteProduct(int id) {

        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;

        try {
            tx = session.beginTransaction();

            Product product = session.get(Product.class, id);

            if (product != null) {
                session.delete(product);
                System.out.println("Product deleted successfully");
            } else {
                System.out.println("Product not found");
            }

            tx.commit();

        } catch (Exception e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
}
}
