package com.yume.yume.component;

import com.yume.yume.YumeApplication;
import com.yume.yume.bean.LiveData;
import com.yume.yume.mapper.LiveDataMapper;
import com.yume.yume.pojo.LiveInfo;
import com.yume.yume.pojo.LiveInfoOne;
import com.yume.yume.service.DataLooperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author 李天宇
 * 说明：这个类的作用是定时任务，b站没有办法主动推送主播的直播状态，所以可以通过轮训服务器接口的方式获取yume直播的数据信息
 */
@Component
@EnableScheduling
public class ScheduleGetLiveData {

    @Autowired
    DataLooperService dataLooperService;

    @Autowired
    LiveDataMapper liveDataMapper;

    //表示8秒钟轮训一次服务器
    @Scheduled(cron ="0/8 * *  * * ? ")
    public void updateLiveStatus(){
        LiveData data=dataLooperService.getLastLiveData();
        RestTemplate restTemplate = new RestTemplate();
        LiveInfoOne liveInfo = restTemplate.getForObject("http://api.live.bilibili.com/room/v1/Room/getRoomInfoOld?mid="+ YumeApplication._UUID
                , LiveInfoOne.class);
        System.out.println(liveInfo);

        if(getRealTimeLiveStatus(liveInfo)==0 &&data!=null && data.getLiveStatus()==0){          //yume已经结束直播  并且数据库中最后一条记录也是结束直播的记录

        }
        else if(getRealTimeLiveStatus(liveInfo)==0 && data.getLiveStatus()==1){         //yume已经结束直播 更新    直播结束时间并刷新数据库状态
            LiveData lastLiveData = liveDataMapper.selectById(liveDataMapper.selectCount(null));  //获取最后一条记录
            lastLiveData.setLiveStatus(0);
            lastLiveData.setEnd(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date())+"");
            liveDataMapper.updateById(lastLiveData);
        }
        //如果数据库中不存在任何直播数据这里判断 数据库中数据的状态会出现空指针异常
        else if(getRealTimeLiveStatus(liveInfo)==1 && data==null){
            LiveData newLiveData = new LiveData();
            newLiveData.setTitle(getRealTimeLiveTitle(liveInfo));
            newLiveData.setLiveStatus(1);
            newLiveData.setStart(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date())+"");
            newLiveData.setUrl(getRealTimeLiveUrl(liveInfo));
            liveDataMapper.insert(newLiveData);
        }
        else if(getRealTimeLiveStatus(liveInfo)==1 && data!=null &&data.getLiveStatus()==0){     //yume已经开始播 数据库创建新的  记录  并记录开始直播的时间
            LiveData newLiveData = new LiveData();
            newLiveData.setTitle(getRealTimeLiveTitle(liveInfo));
            newLiveData.setLiveStatus(1);
            newLiveData.setStart(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date())+"");
            newLiveData.setUrl(getRealTimeLiveUrl(liveInfo));
            liveDataMapper.insert(newLiveData);
        }


        else if(getRealTimeLiveStatus(liveInfo)==1 && data.getLiveStatus()==1){     //yume 已经开始直播 并且数据库中已经记录了本次直播的记录 什么都不干
            //这里有个细节问题   当yume进行直播时 直播间的标题可能会发生变更 所以在开播的过程中需要实时监测直播间标题的变化并更新
            LiveData lastLiveData = liveDataMapper.selectById(liveDataMapper.selectCount(null));  //获取最后一条记录
            lastLiveData.setTitle(getRealTimeLiveTitle(liveInfo));
            liveDataMapper.updateById(lastLiveData);
        }

    }


    public Integer getRealTimeLiveStatus(LiveInfoOne liveInfo){
        return liveInfo.getData().getLiveStatus();
    }

    public String getRealTimeLiveTitle(LiveInfoOne liveInfo){
        return liveInfo.getData().getTitle();
    }

    public String getRealTimeLiveUrl(LiveInfoOne liveInfo){
        return liveInfo.getData().getUrl();
    }



}
