package sample.JPA;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

public class ProductCatalogDAO {




public static void insert(ProductCatalog productCatalog){
    EntityManager entityManager = JPAUtil.getEntityManagerFactory().createEntityManager();
    EntityTransaction entityTransaction = entityManager.getTransaction();
    entityTransaction.begin();

    entityManager.persist(productCatalog);

    entityManager.getTransaction().commit();
    entityManager.close();
    
}


public static List<ProductCatalog> displayAllItems(){
    EntityManager entityManager = JPAUtil.getEntityManagerFactory().createEntityManager();
    EntityTransaction entityTransaction = entityManager.getTransaction();
    entityTransaction.begin();

    TypedQuery<ProductCatalog> query = entityManager.createQuery("Select e From ProductCatalog e", ProductCatalog.class);
    List<ProductCatalog> productCatalog = query.getResultList();

    entityManager.getTransaction().commit();
    entityManager.close();

    return productCatalog;
}

    public static List<ProductCatalog> searchByName(String name) {
        EntityManager entityManager = JPAUtil.getEntityManagerFactory().createEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();

        TypedQuery<ProductCatalog> query = entityManager.createQuery("Select e From ProductCatalog e WHERE e.name = ?1", ProductCatalog.class);
        List<ProductCatalog> productCatalog = query.setParameter(1, name).getResultList();

        entityManager.getTransaction().commit();
        entityManager.close();

        return productCatalog;
    }


    public static void updateByCatalog_no(double price, int id) {
        EntityManager entityManager = JPAUtil.getEntityManagerFactory().createEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();


        ProductCatalog productCatalog1 = entityManager.find(ProductCatalog.class, id);
        productCatalog1.setPriceNet(price);
        entityManager.getTransaction().commit();
        entityManager.close();

    }
//TODO: create update(ProductCatalog productCatalog) method for updating price for particular product
}