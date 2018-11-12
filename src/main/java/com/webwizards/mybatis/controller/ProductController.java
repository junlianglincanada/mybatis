package com.webwizards.mybatis.controller;

import com.webwizards.mybatis.entity.Product;
import com.webwizards.mybatis.service.ProductService;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
@EnableAutoConfiguration
@RequestMapping("/product")
public class ProductController {

    @Resource
    private ProductService productService;

    @RequestMapping("/getProduct")
    @ResponseBody
    public Product getProduct(HttpServletRequest request, Model model) {

        int id = Integer.parseInt(request.getParameter("id"));
        Product product = this.productService.getProductById(id);
        return product;
    }

    @RequestMapping("/details")
    public ModelAndView details(HttpServletRequest request){
        ModelAndView modelAndView = new ModelAndView();
        int id = Integer.parseInt(request.getParameter("id"));
        Product product = this.productService.getProductById(id);
        request.setAttribute("product", product);
        modelAndView.setViewName("/product/details");
        return modelAndView;
    }

    @RequestMapping("/create")
    public ModelAndView create(HttpServletRequest request){
        ModelAndView modelAndView = new ModelAndView();
        //int id = Integer.parseInt(request.getParameter("id"));
        //Product product = this.productService.getProductById(id);
        Product product = new Product();
        request.setAttribute("product", product);
        modelAndView.setViewName("/product/create");
        return modelAndView;
    }

    @RequestMapping("/edit")
    public ModelAndView edit(HttpServletRequest request){
        ModelAndView modelAndView = new ModelAndView();
        int id = Integer.parseInt(request.getParameter("id"));
        Product product = this.productService.getProductById(id);
        modelAndView.addObject("product",product);
        modelAndView.setViewName("/product/create");
        return modelAndView;
    }



    @RequestMapping(value="/save", method = RequestMethod.POST)
    public ModelAndView save(@Valid Product product, BindingResult bindingResult){
        ModelAndView modelAndView = new ModelAndView();
        if (!bindingResult.hasErrors()){
            if (product.getId()==0){
                this.productService.insert(product);
            }
            else{
                this.productService.edit(product);
            }

            //modelAndView.addObject("product",product);
           // modelAndView.setViewName("/product/list");

            //return new ModelAndView("redirect:/product/list");
            modelAndView.setViewName("redirect:/product/list");
        }
        else{
            modelAndView.addObject("product",product);
            modelAndView.setViewName("/product/create");

        }


        return modelAndView;
    }

    @RequestMapping(value="/findById", method = RequestMethod.GET)
    public ModelAndView findById(HttpServletRequest request){
        ModelAndView modelAndView = new ModelAndView();
        try{
            int id = Integer.parseInt(request.getParameter("id"));
            Product product = this.productService.getProductById(id);
            modelAndView.addObject("product",product);
        }
        catch (Exception ex){
            ex.printStackTrace();
        }
        modelAndView.setViewName("/product/details");
        return modelAndView;
    }

    @RequestMapping(value="/delete")
    public ModelAndView delete(HttpServletRequest request){
        ModelAndView modelAndView = new ModelAndView();
        int id = Integer.parseInt(request.getParameter("id"));
        List<Product> products = new ArrayList<Product>();

        for (int i=0;i<9;i++){
            Product product = new Product();
            product.setId(i);
            product.setName("name" + i);

            products.add(product);
        }
        modelAndView.addObject("products",products);
        modelAndView.setViewName("/product/list");
        return modelAndView;
    }

    @RequestMapping(value="/list", method = RequestMethod.GET)
    public ModelAndView list(HttpServletRequest request){
        ModelAndView modelAndView = new ModelAndView();
        try{
            //int id = Integer.parseInt(request.getParameter("id"));
            List<Product> products = productService.getPruduct(new Product());
            modelAndView.addObject("products",products);
        }
        catch (Exception ex){
            ex.printStackTrace();
        }
        modelAndView.setViewName("/product/list");
        return modelAndView;
    }
}
