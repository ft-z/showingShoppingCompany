package com.zryx.company.service;

import com.zryx.company.common.config.PageConfig;
import com.zryx.company.model.News;

import java.util.List;

/**
 * 完成对新闻模块的业务操作
 * @author tan
 * @create 2019/7/11
 */
public interface NewsService {
    List<News> selTop8News();

    /**
     * 查询所有的新闻
     * @return
     */
    List<News> getAllNews();

    /**
     * 根据id删除新闻
     * @param id
     * @return
     */
    void delNews(int id);

    /**
     * 修改
     * @param news
     */
    void updNews(News news);

    /**
     * 添加新闻
     * @param news
     */
    void addNews(News news);

    /**
     * 根据id查询新闻
     * @param id 被查询的id
     * @return
     */
    News getNewsById(int id);

    PageConfig<News> getNewsByPage(int page);
}
