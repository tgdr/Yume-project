package com.yume.yume.bean;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;



@ApiModel("日志实体类")
@Data
@TableName("live_log")
public class LiveData {
    @ApiModelProperty("记录id")
    @TableId(type=IdType.AUTO)
    Long id;
    @ApiModelProperty("直播状态")
    @TableField("live_status")
    Integer liveStatus;
    @ApiModelProperty("直播间标题")
    @TableField("live_title")
    String title;
    @ApiModelProperty("直播开始时间")
    @TableField("live_start")
    String start;
    @ApiModelProperty("直播结束时间")
    @TableField("live_end")
    String end;
    @ApiModelProperty("直播间地址")
    @TableField("live_url")
    String url;
}
