package com.webwizards.mybatis.dao;

import com.webwizards.mybatis.entity.Product;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.boot.test.autoconfigure.MybatisTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.test.context.junit4.SpringRunner;
import static org.assertj.core.api.Assertions.*;
import static org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace.NONE;

import java.util.List;

@RunWith(SpringRunner.class)
@MybatisTest
@AutoConfigureTestDatabase(replace = NONE)
public class ProductDaoTest {

    @Autowired
    private ProductDao productDao;

    @Test
    public void whenFindByName_thenReturnEmployee() {
        Product product = new Product();
        product.setName("Electrionics");

        productDao.insert(product);


        List<Product> list = productDao.queryProductList(product);

        Product found = (Product)list.get(0);

        assertThat(found.getName())
                .isEqualTo(product.getName());
    }

}
