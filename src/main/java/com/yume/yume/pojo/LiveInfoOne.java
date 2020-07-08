package com.yume.yume.pojo;

import com.yume.yume.bean.LiveData;
import com.yume.yume.bean.LiveDataOne;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiParam;
import lombok.Data;

import java.util.List;

@ApiModel("直播信息实体类1——去id")
@Data
public class LiveInfoOne {
    @ApiParam("b站返回的请求码")
    private int code;
    @ApiParam("日志记录总数量")
    private int count;
    @ApiParam("直播详细数据记录列表")
    private LiveDataOne data;
}
