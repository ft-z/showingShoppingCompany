package com.zryx.company;

import com.zryx.company.common.config.PageConfig;
import com.zryx.company.mapper.NewsMapper;
import com.zryx.company.model.News;
import com.zryx.company.model.User;
import com.zryx.company.service.NewsService;
import com.zryx.company.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CompanyApplicationTests {
    @Autowired
    private NewsService newsService;
    @Autowired
    private UserService userService;
    @Autowired
    private NewsMapper newsMapper;
    @Autowired
    private PageConfig<News> pageConfig;
    /*@Autowired
    private MessageMapper messageMapper;
    @Autowired
    private PageConfig<Message> pageConfig;
*/
    protected final Logger logger = LoggerFactory.getLogger(getClass());

    @Test
    public void selTop8NewsTest() {
        List<News> news = newsService.selTop8News();
        for(News n : news) {
            logger.debug(n.getTitle());
        }
    }
    /*
@Test
public  void getRevertByMessageId(){

    List<Revert>reverts=revertService.getRevertByMessageId();

}
*/
    @Test
    public void userLoginTest() {
        User user = userService.login("admin","123456");
        if(user!=null) {
            System.out.println("登录成功");
        }
    }

    @Test
    public void getPageDataTest() {
        List<News> news = newsMapper.getNewsByPage((pageConfig.pageNum-1)*pageConfig.pageSize,pageConfig.pageSize);
        pageConfig.setPageData(news);
        int row = newsMapper.dataCount();
        pageConfig.setDataCount(row);
        System.out.println("第"+pageConfig.pageNum+"页，共"+pageConfig.getPageCount()+"页，当前页的数据如下：");
        for(News n : pageConfig.getPageData()) {
            System.out.println(n);
        }
    }
    /*
    @Test
    public void getPageData1Test() {
        List<Message> message = messageMapper.getMessageByPage((pageConfig.pageNum-1)*pageConfig.pageSize,pageConfig.pageSize);
        pageConfig.setPageData(message);
        int row = messageMapper.dataCount();
        pageConfig.setDataCount(row);
        System.out.println("第"+pageConfig.pageNum+"页，共"+pageConfig.getPageCount()+"页，当前页的数据如下：");
        for(Message n : pageConfig.getPageData()) {
            System.out.println(n);
        }
    }
*/
}
