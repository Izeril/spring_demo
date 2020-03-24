package com.aistar.dao;

import com.aistar.pojo.Product;

import java.util.List;

public interface ProductDao {
    public boolean insert(Product product);
    public boolean update(Product product);
    public boolean delete(String proId);
    public Product selectByPrimaryKey(String proId);
    public List<Product> selectAll();
}
