package sample.JPA;

import javax.persistence.*;
import java.util.List;

public class CategoriesDAO {


    public static void insert(Categories categories) {
        EntityManager entityManager = JPAUtil.getEntityManagerFactory().createEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();

        entityManager.persist(categories);

        entityManager.getTransaction().commit();
        entityManager.close();
    }

    public static List<Categories> searchByName(String name) {
        EntityManager entityManager = JPAUtil.getEntityManagerFactory().createEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();

        TypedQuery<Categories> query = entityManager.createQuery("Select e From Categories e WHERE e.name = ?1", Categories.class);
        List<Categories> categories = query.setParameter(1, name).getResultList();

        entityManager.getTransaction().commit();
        entityManager.close();

        return categories;
    }

    public static void deleteById(int id) {
        EntityManager entityManager = JPAUtil.getEntityManagerFactory().createEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();

        Categories categories = entityManager.find(Categories.class, id);
        entityManager.remove(categories);

        entityManager.getTransaction().commit();
        entityManager.close();
    }

    public static void updateById(Categories categories, int id) {
        EntityManager entityManager = JPAUtil.getEntityManagerFactory().createEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();

        Categories categories1 = entityManager.find(Categories.class, id);
        categories1.setName(categories.getName());
        categories1.setlft(categories.getlft());
        categories1.setrght(categories.getrght());

        entityManager.getTransaction().commit();
        entityManager.close();

    }


    public static List<Categories> selectCategory(String name) {
        EntityManager entityManager = JPAUtil.getEntityManagerFactory().createEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();

        TypedQuery<Categories> query = entityManager.createQuery("SELECT e FROM Categories e" +
                " JOIN Categories a  ON (e.lft >= a.lft AND e.rght <= a.rght) " +
                "WHERE a.name = ?1 ORDER BY e.lft", Categories.class);
        List<Categories> categories = query.setParameter(1, name).getResultList();

        entityManager.getTransaction().commit();
        entityManager.close();

        return categories;
    }

}

