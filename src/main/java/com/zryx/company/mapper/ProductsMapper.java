package com.zryx.company.mapper;

import com.zryx.company.model.Product;
import org.apache.ibatis.annotations.Param;

import java.util.List;


public interface ProductsMapper {

    /**
     * 按照时间的倒叙显示前八条商品
     * @return
     */
    public List<Product> selTop8Product();

    /**
     * 获得所有的商品
     * @return 以List<Product>集合的形式返回商品列表
     */
    List<Product> allProducts();

    /**
     * 添加产品
     * @param
     * @return
     */
    int addProducts(Product product);

    /**product
     * 删除产品
     * @param productId
     * @return
     */
    int delProducts(@Param("nId") int productId);

    /**
     * 更新产品
     * @param product
     * @return
     */
    int updProducts(Product product);

    Product getProductById(@Param("id") int productId);

    List<Product> getProductByPage(@Param("from") int from,@Param("size") int size);

    int dataCount();

}
