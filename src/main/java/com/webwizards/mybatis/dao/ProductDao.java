package com.webwizards.mybatis.dao;

import com.webwizards.mybatis.entity.Product;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ProductDao {

    Product selectByPrimaryKey(Integer id);

    Product queryProductByName(String name);

    List<Product> queryProductList(Product product);

    int edit(Product product);

    int insert(Product product);
}
