package service;

import model.Product;

import java.util.*;

public class ProductServiceImpl implements ProductService {


    private static Map<Integer, Product> products = new HashMap<>();;

    static {
        products.put(1,new Product(1,"Aaptop1","1000","New1","Dell1"));
        products.put(2,new Product(2,"Captop2","2000","New2","Dell2"));
        products.put(3,new Product(3,"Baptop3","3000","New3","Dell3"));
        products.put(4,new Product(4,"Saptop4","4000","New4","Dell4"));
        products.put(5,new Product(5,"Qaptop5","5000","New5","Dell5"));
    }





    @Override
    public List<Product> findAll() {
        return new ArrayList<>(products.values());
    }

    @Override
    public void save(Product product) {
       products.put(product.getId(),product);
    }

    @Override
    public Product findById(int id) {
       return products.get(id);
    }

    @Override
    public void update(int id, Product product) {

    }


    @Override
    public void remove(int id) {
        products.remove(id);
    }

    public List<Product>  sortByName(){
        List<Product> product = new ArrayList<>(products.values());


        Collections.sort(product,new Comparator<Product>()

        {
            @Override
            public int compare(Product o1, Product o2) {
                return o1.getName().compareTo(o2.getName());
            }
        });
        return new ArrayList<>(product);
    }



    public List<Product>  searchProduct(String s ){
        List<Product> product = new ArrayList<>(products.values());

        for (int i = 0; i < product.size(); i++){
            if (product.get(i).getName().equals(s)==false)
            {
                product.remove(product.get(i));
            }
        }
        return new ArrayList<>(product);
    }
}
