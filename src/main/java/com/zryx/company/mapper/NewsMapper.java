package com.zryx.company.mapper;

import com.zryx.company.model.News;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author 123
 * @create 2019/7/11
 */
public interface NewsMapper {

    /**
     * 按照时间的倒叙显示前八条新闻
     * @return
     */
    public List<News> selTop8News();

    /**
     * 获得所有的新闻
     * @return 以List<News>集合的形式返回新闻列表
     */
    List<News> getAllNews();

    /**
     * 添加新闻
     * @param news
     * @return
     */
    int addNews(News news);

    /**
     * 删除新闻
     * @param newsId
     * @return
     */
    int delNews(@Param("nId") int newsId);

    /**
     * 更新新闻
     * @param news
     * @return
     */
    int updNews(News news);

    News getNewsById(@Param("id") int newsId);
    List<News> getNewsByPage(@Param("from") int from,@Param("size") int size);

    int dataCount();
}
