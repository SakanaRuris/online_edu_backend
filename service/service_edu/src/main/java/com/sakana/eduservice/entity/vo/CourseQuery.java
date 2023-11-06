package com.sakana.eduservice.entity.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 用于分页查询课程
 * @author YU Chenxi
 * @since 2023/10/24 22:23
 */
@Data
public class CourseQuery {
    @ApiModelProperty(value = "课程名称，模糊查询")
    private String title;
    @ApiModelProperty(value = "课程发布状态")
    private String status;
    @ApiModelProperty(value = "查询开始时间", example = "2023-01-01 10:10:10")
    private String begin;//注意，这里使用的是String类型，前端传过来的数据无需进行类型转换
    @ApiModelProperty(value = "查询结束时间", example = "2023-12-01 10:10:10")
    private String end;
}
