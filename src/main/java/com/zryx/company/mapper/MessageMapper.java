package com.zryx.company.mapper;

import com.zryx.company.model.Message;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface MessageMapper {



    Message getMessageById(@Param("id") int messageId);

    public List<Message> getALLMessage();


    public  int addMessage(Message message);

    public int delMessage(@Param("mId") int messageId);

    public int updMessage(Message message);

    List<Message> getMessageByPage(@Param("from") int from,@Param("size") int size);

    int dataCount();

}


