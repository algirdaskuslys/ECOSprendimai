package sample.JPA;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.ArrayList;

public class ProductCatalogDAO {




public static void insert(ProductCatalog productCatalog){
    EntityManager entityManager = JPAUtil.getEntityManagerFactory().createEntityManager();
    EntityTransaction entityTransaction = entityManager.getTransaction();
    entityTransaction.begin();

    entityManager.persist(productCatalog);

    entityManager.getTransaction().commit();
    entityManager.close();
    
}


public static ArrayList<ProductCatalog> displayAllItems(){
    EntityManager entityManager = JPAUtil.getEntityManagerFactory().createEntityManager();
    EntityTransaction entityTransaction = entityManager.getTransaction();
    entityTransaction.begin();

    ArrayList<ProductCatalog> produktuKatalogai = (ArrayList<ProductCatalog>) entityManager.
            createQuery("SELECT a FROM ProductCatalog a").
            getResultList();

    entityManager.getTransaction().commit();
    entityManager.close();

    return produktuKatalogai;
}

public static ProductCatalog findByName(String name){
    EntityManager entityManager = JPAUtil.getEntityManagerFactory().createEntityManager();

    // Pasichekinti užklausą į db pagal product name
    ProductCatalog productCatalog = entityManager.find( ProductCatalog.class, 1 );

    System.out.println("employee ID = " + productCatalog.getCatalogNo( ));
    System.out.println("employee NAME = " + productCatalog.getSymbol( ));
    System.out.println("employee SALARY = " + productCatalog.getPriceNet( ));
    System.out.println("employee DESIGNATION = " + productCatalog.getStock( ));

    return new ProductCatalog();
}

//TODO: create update(ProductCatalog productCatalog) method for updating price for particular product
}