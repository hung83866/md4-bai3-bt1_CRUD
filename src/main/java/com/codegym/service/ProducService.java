package com.codegym.service;

import com.codegym.model.Product;

import javax.swing.plaf.basic.BasicListUI;
import java.util.ArrayList;
import java.util.List;
import static java.util.Arrays.asList;

public class ProducService implements IProductService{
    public static List<Product> products ;
    public static int id = 1;
    static {
        products = new ArrayList<>();
                products.add(new Product(id++,"iphoneX","America",700));
                products.add(new Product(id++,"iphone9","America",500));
                products.add(new Product(id++,"Oppo","China",400));
                products.add(new Product(id++,"iphone14","America",1700));
                products.add(new Product(id++,"XiaoMi","China",300));
                products.add(new Product(id++,"Sony","Japan",650));
                products.add(new Product(id++,"SamSung Z100000","Korea",2700));
                products.add(new Product(id++,"iphone12 Promax","America",1200));
                products.add(new Product(id++,"iphone13","America",1300));
    }
    @Override
    public List<Product> findAll() {
        return products;
    }

    @Override
    public void save(Product product) {
        products.add(product);
    }


    @Override
    public Product findById(int id) {
        return products.get(id);
    }

    @Override
    public void update(int id, Product product) {
        products.get(id).setMade(product.getMade());
        products.get(id).setName(product.getName());
        products.get(id).setPrice(product.getPrice());
    }

    @Override
    public void remove(int id) {
        products.remove(id);
    }

    @Override
    public Product findByName(String name) {
        Product product = null;
        for (int i = 0; i < products.size(); i++) {
            if (products.get(i).getName().equalsIgnoreCase(name)){
                product = products.get(i);
            }
        }
        return product;
    }
}
