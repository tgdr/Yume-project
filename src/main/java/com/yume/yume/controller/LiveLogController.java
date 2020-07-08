package com.yume.yume.controller;

import com.yume.yume.pojo.LiveInfo;
import com.yume.yume.service.LiveLogService;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping("/log")
@Api(tags = {"获取直播日志接口"})
public class LiveLogController {

    @Autowired
    LiveLogService liveLogService;


    @ApiOperation("获取所有直播日志信息")
    @GetMapping(value = "/info",produces = "application/json; charset=utf-8")
    public LiveInfo getAllLiveInfo(){
        return liveLogService.findAllData();
    }


    @ApiOperation("分页获取直播日志信息")
    @GetMapping(value = "/infoByPage",produces = "application/json; charset=utf-8")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "page",value = "页码",required = true,dataType = "int",paramType="query"),
            @ApiImplicitParam(name = "limit",value = "每页显示的条数",required = true,dataType = "int",paramType="query")
    })
    public LiveInfo getLiveInfo(Integer page,  Integer limit){
       return liveLogService.findData(page,limit);
    }

    @ApiOperation("根据ID获取直播日志信息")
    @GetMapping(value = "/infoById",produces = "application/json; charset=utf-8")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id",value = "记录的id号",required = true,dataType = "long",paramType="query"),
    })
    public LiveInfo getLiveInfoById(Long id){
        return liveLogService.findDataById(id);
    }



}
