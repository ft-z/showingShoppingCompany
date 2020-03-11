package com.zryx.company.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class Message {

    private int messageId;
    private String title;
    private String content;
    private String writer;
    private Date writeDate;
    private int count;

    public Message(int messageId, String title, String content, String writer, Date writeDate, int count) {
        this.messageId = messageId;
        this.title = title;
        this.content = content;
        this.writer = writer;
        this.writeDate = writeDate;
        this.count = count;
    }

    public Message() {
    }


    public int getMessageId() {
        return messageId;
    }

    public void setMessageId(int messageId) {
        this.messageId = messageId;
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

    public String getWriter() {
        return writer;
    }

    public void setWriter(String writer) {
        this.writer = writer;
    }
    public Date getWriteDate() {
        return writeDate;
    }

    public void setWriteDate(Date writeDate) {
        this.writeDate = writeDate;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public String toString(){
        SimpleDateFormat sdf = new SimpleDateFormat(" yyyy-MM-dd");
        return " 信息编号:" + messageId + " 信息标题:" + title + "内容: " +
                content +"作者："+writer+ " 日期:" + sdf.format(writeDate)+" 数量："+count;
    }

    public void setReverts(List<Revert> reverts) {
    }
}
