package com.aistar.service;

import com.aistar.pojo.Product;

public interface ProductService {
    public boolean add(Product product);
    public boolean update(Product product);
    public boolean delete(String proId);
    public Product getById(String proId);
    public boolean getAll();
    public boolean updatePrice(Product p1,Product p2);
}
