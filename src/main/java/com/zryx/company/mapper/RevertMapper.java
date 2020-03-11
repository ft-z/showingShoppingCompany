package com.zryx.company.mapper;

import com.zryx.company.model.Revert;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface RevertMapper {

    /**
     * 根据消息ID查询回帖
     * @param
     * @return
     */
    List<Revert> getRvertByMessageId(@Param("id")int revertID);

    int delRevert( int revertId);

    int addRevert(Revert revert);


}
