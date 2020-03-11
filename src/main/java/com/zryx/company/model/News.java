package com.zryx.company.model;

import java.util.Date;

/**
 * @author 123
 * @create 2019/7/11
 */
public class News {
    private long newsId;
    private String title;
    private String content;
    private Date writeDate;

    public News() {
    }

    public News(long newsId, String title, String contents, Date writeDate) {
        this.newsId = newsId;
        this.title = title;
        this.content = contents;
        this.writeDate = writeDate;
    }

    public long getNewsId() {
        return newsId;
    }

    public void setNewsId(long newsId) {
        this.newsId = newsId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getWriteDate() {
        return writeDate;
    }

    public void setWriteDate(Date writeDate) {
        this.writeDate = writeDate;
    }

    @Override
    public String toString() {
        return "News{" +
                "newsId=" + newsId +
                ", title='" + title + '\'' +
                ", contents='" + content + '\'' +
                ", writeDate=" + writeDate +
                '}';
    }
}
