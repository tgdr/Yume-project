package com.yume.yume.pojo;

import com.yume.yume.bean.LiveData;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiParam;
import lombok.Data;
import lombok.ToString;

import java.util.List;

@ApiModel("直播信息实体类")
@Data
public class LiveInfo {
    @ApiParam("b站返回的请求码")
    private int code;
    @ApiParam("日志记录总数量")
    private Long count;
    @ApiParam("直播详细数据记录列表")
    private List<LiveData> data;



}
