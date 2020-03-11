package com.zryx.company.service;

import com.zryx.company.common.config.PageConfig;
import com.zryx.company.model.Product;

import java.util.List;

public interface ProductService {

    List<Product> selTop8Product();

    /**
     * 查询所有的产品
     * @return
     */
    List<Product> allProducts();

    /**
     * 根据id删除产品
     * @param id
     * @return
     */
    public void delProducts(int id);

    /**
     * 修改
     * @param product
     */
    public void updProducts(Product product);

    /**
     * 添加
     * @param product
     */
    public void addProducts(Product product);

    /**根据id查询产品
     * @param id 被查询的id
     * @return
     */
    Product getProductById(int id);

    /**
     * 得到当前页的数据
     * @param page 就是第几页
     * @return
     */
    PageConfig<Product> getProductByPage(int page);
}

