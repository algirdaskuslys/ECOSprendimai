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

    List<ProductCatalog> productCatalog = (ArrayList<ProductCatalog>) entityManager.
            createQuery("SELECT a FROM ProductCatalog a").
            getResultList();

    entityManager.getTransaction().commit();
    entityManager.close();

    return productCatalog;
}

    public static List<ProductCatalog> searchByName(String name) {
        EntityManager entityManager = JPAUtil.getEntityManagerFactory().createEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();

        TypedQuery<ProductCatalog> query = entityManager.createQuery("Select e From Categories e WHERE e.name = ?1", ProductCatalog.class);
        List<ProductCatalog> productCatalog = query.setParameter(1, name).getResultList();

        entityManager.getTransaction().commit();
        entityManager.close();

        return productCatalog;
    }


    public static void updateByCatalog_no(ProductCatalog productCatalog, int catalog_no) {
        EntityManager entityManager = JPAUtil.getEntityManagerFactory().createEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();

        ProductCatalog productCatalog1 = entityManager.find(ProductCatalog.class, catalog_no);
        productCatalog1.setPriceNet(productCatalog.getPriceNet());


        entityManager.getTransaction().commit();
        entityManager.close();

    }
//TODO: create update(ProductCatalog productCatalog) method for updating price for particular product
}