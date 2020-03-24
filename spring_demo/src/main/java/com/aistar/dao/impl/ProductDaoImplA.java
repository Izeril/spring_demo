package com.aistar.dao.impl;

import com.aistar.dao.ProductDao;
import com.aistar.pojo.Product;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository //将dao层注入到Spring容器中
public class ProductDaoImplA implements ProductDao {

    public ProductDaoImplA(){
        System.out.println("ProductDaoImplA的无参构造函数.....");
    }
    @Override
    public boolean insert(Product product) {
        System.out.println("dao insert.....AAAAAA");
        return false;
    }

    @Override
    public boolean update(Product product) {
        return false;
    }

    @Override
    public boolean delete(String proId) {
        return false;
    }

    @Override
    public Product selectByPrimaryKey(String proId) {
        return null;
    }

    @Override
    public List<Product> selectAll() {
        System.out.println("dao selectAll");
        return null;
    }
}
