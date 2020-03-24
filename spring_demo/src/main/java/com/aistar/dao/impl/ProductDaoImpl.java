package com.aistar.dao.impl;

import com.aistar.dao.ProductDao;
import com.aistar.pojo.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository //将dao层注入到Spring容器中
public class ProductDaoImpl implements ProductDao {

    @Autowired //自动匹配（根据类型）
    private JdbcTemplate jdbcTemplate;

    public ProductDaoImpl(){
        System.out.println("ProductDaoImpl的无参构造函数.....");
    }
    public void myInit(){
        System.out.println("ProductDaoImpl initial 初始化");
    }
    public void myDestroy(){
        System.out.println("ProductDaoImpl destroy 消亡");
    }



    @Override
    public boolean insert(Product product) {
        System.out.println("dao insert....impl");
        String sql = "insert into product values(?,?,?,?,?,?,?,?)";
        Object[] args = {product.getProId(),product.getProName(),product.getProNum(),product.getProSize(),
        product.getProColor(),product.getProPrice(),product.getProAddress(),product.getProDate()};
        int rows = jdbcTemplate.update(sql,args);
        return rows>0;
    }

    @Override
    public boolean update(Product product) {
        String sql = "update product set pro_name = ?,pro_num = ?,pro_size = ?," +
                "pro_color = ?,pro_price = ?,pro_address = ?,pro_date = ? where pro_id = ?";
        Object[] args = {product.getProName(),product.getProNum(),product.getProSize(),product.getProColor(),product.getProPrice()
        ,product.getProAddress(),product.getProDate(),product.getProId()};
        int rows = jdbcTemplate.update(sql,args);
        return rows>0;
    }

    @Override
    public boolean delete(String proId) {
        String sql = "delete from product where pro_id = ?";
        Object[] args = {proId};
        int rows = jdbcTemplate.update(sql,args);
        return rows>0;
    }

    @Override
    public Product selectByPrimaryKey(String proId) {
        String sql = "select * from product where pro_id = ?";
        Object[] args = {proId};
        //BeanPropertyRowMapper 将resultset中的 查询到的数据库里每条行记录封装成 java pojo product对象
         RowMapper<Product> rowMapper = new BeanPropertyRowMapper<>(Product.class);
         return this.jdbcTemplate.queryForObject(sql,args,rowMapper);
    }

    @Override
    public List<Product> selectAll() {
        System.out.println("dao selectAll");
        String sql = "select * from product";
        RowMapper<Product> rowMapper = new BeanPropertyRowMapper<>(Product.class);
        List<Product> productList = jdbcTemplate.query(sql,rowMapper);
        return productList;
    }
}
