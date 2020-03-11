package com.zryx.company.mapper;
import com.zryx.company.model.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author 123
 * @create 2019/7/14
 */
public interface UserMapper {
    User getUserByName(String userName);
//    User getUserByName(@Param("userName") String userName);

    List<User> getAllUser();
    int addUser(User user);
    int delUser(int userId);
    int updUser(User user);
    User getUserById(int userId);
    //int updUserStatus(User user);

}
