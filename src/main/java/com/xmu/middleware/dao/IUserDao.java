package com.xmu.middleware.dao;

import org.apache.ibatis.session.RowBounds;

import com.xmu.middleware.pojo.User;

import java.util.List;
import java.util.Map;


public interface IUserDao {
    int deleteByPrimaryKey(Integer id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    User findByLogin(User user);

    List<User> findByParams(User u, RowBounds rowBound);

    int findAllCount(User u);

    List<User> findHotUser();

    List<User> findAllByQuery(User user) ;

    List<User> list(Map<String, Object> map);

    Long getTotal(Map<String, Object> map);

    User findUserByUsername(String username);
}
