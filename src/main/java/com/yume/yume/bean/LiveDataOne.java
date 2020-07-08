package com.yume.yume.bean;

import com.baomidou.mybatisplus.annotation.TableField;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

@ApiModel("日志实体类1——去id")
@Data
public class LiveDataOne {
    @ApiModelProperty("直播状态")
    @TableField("live_status")
    Integer liveStatus;
    @ApiModelProperty("直播间标题")
    @TableField("live_title")
    String title;
    @ApiModelProperty("直播开始时间")
    @TableField("live_start")
    String live_start;
    @ApiModelProperty("直播结束时间")
    @TableField("live_end")
    String live_end;
    @ApiModelProperty("直播间地址")
    @TableField("live_url")
    String url;

}
