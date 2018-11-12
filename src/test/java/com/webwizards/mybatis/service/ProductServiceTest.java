package com.webwizards.mybatis.service;

import com.webwizards.mybatis.dao.ProductDao;
import com.webwizards.mybatis.entity.Product;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;
import static org.assertj.core.api.Assertions.*;
@RunWith(SpringRunner.class)
public class ProductServiceTest {

    @TestConfiguration
    static class EmployeeServiceImplTestContextConfiguration {

        @Bean
        public ProductService productService() {
            return new ProductServiceImpl();
        }
    }

    @Autowired
    private ProductService productService;

    @MockBean
    private ProductDao productDao;

    @Before
    public void setUp() {
        Product product = new Product();
        product.setName("Boots");

        Mockito.when(productDao.queryProductByName(product.getName()))
                .thenReturn(product);
    }


    @Test
    public void whenValidName_thenProductShouldBeFound() {
        String name = "Boots";
        Product found = productDao.queryProductByName(name);

        assertThat(found.getName())
                .isEqualTo(name);
    }

}
