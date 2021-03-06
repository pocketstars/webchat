package com.xmu.middleware.service.impl;

import com.github.pagehelper.PageHelper;
import com.xmu.middleware.dao.RediscontentMapper;
import com.xmu.middleware.pojo.RedisContent;
import com.xmu.middleware.pojo.RedisContentExample;
import com.xmu.middleware.service.RediscontentService;
import com.xmu.middleware.util.PageEntity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RediscontentServiceImpl implements RediscontentService {

    @Autowired
    private RediscontentMapper rediscontentMapper;


    @Override
    public List<RedisContent> selectByExample(RedisContentExample example) {
        return rediscontentMapper.selectByExample(example);
    }

    @Override
    public RedisContent selectByPrimaryKey(Integer id) {
        return rediscontentMapper.selectByPrimaryKey(id);
    }

    @Override
    public PageEntity<RedisContent> selectByPage(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        //因为是demo，所以这里默认没有查询条件。
        List<RedisContent> redisContents = rediscontentMapper.selectByExample(new RedisContentExample());
        PageEntity<RedisContent> rediscontentPageEntity = new PageEntity<RedisContent>();
        rediscontentPageEntity.setList(redisContents);
        int size = rediscontentMapper.selectByExample(new RedisContentExample()).size();
        rediscontentPageEntity.setCount(size);
        return rediscontentPageEntity;
    }


}
