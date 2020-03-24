package com.aistar.service.impl;

import com.aistar.dao.ProductDao;
import com.aistar.dao.impl.ProductDaoImpl;
import com.aistar.pojo.Product;
import com.aistar.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service //将service层注入到Spring容器中
public class ProductServiceImpl implements ProductService {

    private String name;//service 依赖于name: 通过spring name = "tom";

    @Autowired //根据类型自动匹配
    @Qualifier("productDaoImpl") //当有类型相同时，用以区分
    private ProductDao productDao;// service 依赖于productDao  : 通过spring赋值 productDao=  从spring中的bean获得

    public ProductServiceImpl(String name,ProductDao productDao){
        this.name = name;
        this.productDao = productDao;
    }
    public ProductServiceImpl(){
        System.out.println("ProductServiceImpl 无参构造函数");
    }

    public void setName(String name){
        this.name = name;
    }
    public void setProductDao(ProductDao productDao){
        this.productDao = productDao;
    }
    @Override
    public boolean add(Product product) {
        System.out.println("service insert");
        return productDao.insert(product);
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
    public Product getById(String proId) {
       Product product =  productDao.selectByPrimaryKey(proId);
        return product;
    }

    @Override
    public boolean getAll() {
        System.out.println("service getall.....");
        return false;
    }

    @Override
    public boolean updatePrice(Product p1, Product p2) {
        p1.setProPrice(p1.getProPrice()-1000);
        productDao.update(p1);

        p2.setProPrice(p2.getProPrice()-1000);
        productDao.update(p2);

        return false;
    }
}
