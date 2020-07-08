package com.yume.yume.service;

import com.yume.yume.bean.LiveData;
import com.yume.yume.pojo.LiveInfo;

public interface LiveLogService {
    public LiveInfo findData(Integer page,Integer limit);
    public LiveInfo findDataById(Long id);
    public LiveInfo findAllData();
}
