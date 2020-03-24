package com.aistar.controller;

import com.aistar.pojo.Product;
import com.aistar.service.ProductService;
import com.aistar.service.impl.ProductServiceImpl;


public class ProductController {
    public void add(Product product){
        ProductService service = new ProductServiceImpl();
        service.add(product);
    }
    public void update(Product product){

    }

    public void delete(String proId){

    }
    public void getById(String ProId){

    }
    public void getAll(){}
}
