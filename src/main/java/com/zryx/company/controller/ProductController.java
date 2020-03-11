package com.zryx.company.controller;

import com.zryx.company.common.config.PageConfig;
import com.zryx.company.common.web.BaseController;
import com.zryx.company.model.Product;
import com.zryx.company.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController//后台控制器
@RequestMapping("/product")
public class ProductController extends BaseController {

    @Autowired
    ProductService productService;

    /**
     * 后台控制器当中的一个方法，该方法用来进行查询并返回一个json
     * @PostMapping用来处理post请求
     * @return 向客户返回json格式的字符串
     */
    @PostMapping("/allProducts")
    public String allProducts(@RequestParam(value="page",required = false,defaultValue = "1")Integer page){
        //List<Product> product = productService.allProducts();
        PageConfig pageConfig = productService.getProductByPage(page);
        String json = dealQueryResult(pageConfig,pageConfig);
        logger.debug("json===>" + json);
        return json;
    }

    @PostMapping("/delProducts")
    public String delProducts(int id) {
        productService.delProducts(id);
        return dealSuccessResutl("删除成功",null);
    }

    @PostMapping("/updProducts")
    public String updProducts(Product product) {
        productService.updProducts(product);
        return dealSuccessResutl("修改成功",null);
    }

    @PostMapping("/addProducts")
    public String addProducts(Product product) {
        productService.addProducts(product);
        return dealSuccessResutl("添加成功",null);
    }

    @PostMapping("/getProductById")
    public String getProductById(int id){
        Product product= productService.getProductById(id);
        return dealQueryResult(product,product);
    }

}

