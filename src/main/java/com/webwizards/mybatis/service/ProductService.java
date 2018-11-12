package com.webwizards.mybatis.service;

import com.webwizards.mybatis.entity.Product;

import java.util.List;

public interface ProductService {
    public Product getProductById(Integer id);
    public Product queryProductByName(String name);
    public List<Product> getPruduct(Product product);
    public int edit(Product product);
    public int insert(Product product);
}
