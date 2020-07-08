package com.yume.yume.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yume.yume.bean.LiveData;
import com.yume.yume.bean.LiveDataOne;
import com.yume.yume.mapper.LiveDataMapper;
import com.yume.yume.pojo.LiveInfo;
import com.yume.yume.pojo.LiveInfoOne;
import com.yume.yume.service.LiveLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
public class LiveLogServiceImpl implements LiveLogService {

    @Autowired
    private LiveDataMapper liveDataMapper;

    @Override
    public LiveInfo findData(Integer page,Integer limit) {
        LiveInfo liveInfo = new LiveInfo();
        liveInfo.setCode(200);
        IPage<LiveData> liveDataOneIPage = new Page<>(page,limit);
        IPage<LiveData> res =  liveDataMapper.selectPage(liveDataOneIPage,null);
        liveInfo.setCount(res.getTotal());
        liveInfo.setData(res.getRecords());
        return liveInfo;
    }

    @Override
    public LiveInfo findDataById(Long id) {
        LiveInfo liveInfo = new LiveInfo();
        liveInfo.setCode(200);
        List<LiveData>  resData = new ArrayList();
        resData.add(liveDataMapper.selectById(id));
        liveInfo.setCount(Long.valueOf(resData.size()));
        liveInfo.setData(resData);
        return liveInfo;
    }

    @Override
    public LiveInfo findAllData() {
        LiveInfo liveInfo = new LiveInfo();
        liveInfo.setCode(200);
        List<LiveData> liveData = liveDataMapper.selectList(null);
        liveInfo.setCount(Long.valueOf(liveData.size()));
        liveInfo.setData(liveData);
        return liveInfo;

    }
}
