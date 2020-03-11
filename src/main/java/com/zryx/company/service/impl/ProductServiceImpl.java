package com.zryx.company.service.impl;

import com.zryx.company.common.config.PageConfig;
import com.zryx.company.common.exception.CustomException;
import com.zryx.company.common.service.impl.BaseServiceImpl;
import com.zryx.company.mapper.ProductsMapper;
import com.zryx.company.model.Product;
import com.zryx.company.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl extends BaseServiceImpl implements ProductService {

    @Autowired
    private ProductsMapper productsMapper;

    @Autowired
    private PageConfig<Product> pageConfig;

    /**
     * 返回前八条产品信息
     * @return
     */
    @Override
    public List<Product> selTop8Product() {
        return productsMapper.selTop8Product();
    }

    /**
     * 查询所有的商品
     * @return
     */
    @Override
    public List<Product> allProducts() {
        return productsMapper.allProducts();
    }

    @Override
    public void delProducts(int id) {
        int row = productsMapper.delProducts(id);
        if(row == 0) {
            throw new CustomException(100,"删除产品出现异常");
        }
    }

    @Override
    public void updProducts(Product product) {
        int row = productsMapper.updProducts(product);
        if(row == 0) {
            throw new CustomException(100,"修改产品出现异常");
        }
    }

    @Override
    public void addProducts(Product product) {
        int row = productsMapper.addProducts(product);
        if(row == 0) {
            throw new CustomException(100,"添加产品出现异常");
        }
    }

    @Override
    public Product getProductById(int id){
        return productsMapper.getProductById(id);
    }

    /**
     * 分页的实现
     * @param page 就是第几页
     * @return 返回分页类的对象，该对象当中就包含当前页的数据
     */
    @Override
    public PageConfig<Product> getProductByPage(int page) {
        //设置当前页
        pageConfig.setPageNum(page);
        //得到从哪开始查询
        int from = (page - 1) * pageConfig.pageSize;
        //得到查几条
        int size = pageConfig.pageSize;
        //查出当前页的数据
        List<Product> product = productsMapper.getProductByPage(from,size);
        //设置当前页
        pageConfig.setPageData(product);
        //得到总数据量
        int count = productsMapper.dataCount();
        //设置一共有几条数据
        pageConfig.setDataCount(count);
        //返回包含当前页的数据、当前页、总页数、总记录数的一个对象
        return pageConfig;
    }

}

