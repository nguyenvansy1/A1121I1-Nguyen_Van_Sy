package product_management.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import product_management.model.Product;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.ArrayList;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService{
    @PersistenceContext
    public EntityManager entityManager;

    @Override
    public List<Product> findAll() {
        String query = "SELECT p FROM Product AS p";
        return entityManager.createQuery(query,Product.class).getResultList();
    }
    @Transactional
    @Override
    public void save(Product product) {
        entityManager.persist(product);
    }

    @Override
    public Product findById(String id) {
        Product product = entityManager.find(Product.class,id);
        return product;
    }

    @Override
    public Product findByName(String name) {
        String query = "SELECT p FROM Product as p WHERE p.name =:name";
        TypedQuery<Product> product = entityManager.createQuery(query,Product.class);
        product.setParameter("name",name);

        return product.getSingleResult();
    }
    @Transactional
    @Override
    public void update(String id, Product product) {
        entityManager.merge(product);
    }

    @Override
    @Transactional
    public void remove(Product product) {
        entityManager.remove(findById(product.getId()));
    }
}
