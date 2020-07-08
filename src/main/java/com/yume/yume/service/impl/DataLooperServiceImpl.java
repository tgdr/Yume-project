package com.yume.yume.service.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.yume.yume.bean.LiveData;
import com.yume.yume.mapper.LiveDataMapper;
import com.yume.yume.service.DataLooperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Service
public class DataLooperServiceImpl implements DataLooperService {

    @Autowired
    LiveDataMapper mapper;


    @Override
    public LiveData getLastLiveData() {
         return mapper.selectById(mapper.selectCount(null));
    }
}
