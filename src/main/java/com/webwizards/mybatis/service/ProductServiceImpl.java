package com.webwizards.mybatis.service;

import com.webwizards.mybatis.dao.ProductDao;
import com.webwizards.mybatis.entity.Product;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("productService")
public class ProductServiceImpl implements ProductService {

    @Resource
    private ProductDao productDao;
    @Override
    public Product getProductById(Integer id) {

        return productDao.selectByPrimaryKey(id);
    }

    @Override
    public List<Product> getPruduct(Product product) {
        return productDao.queryProductList(product);
    }

    @Override
    public int edit(Product product) {
        return productDao.edit(product);
    }

    @Override
    public int insert(Product product) {
        return productDao.insert(product);
    }
    @Override
    public Product queryProductByName(String name){
        return productDao.queryProductByName(name);
    }
}
