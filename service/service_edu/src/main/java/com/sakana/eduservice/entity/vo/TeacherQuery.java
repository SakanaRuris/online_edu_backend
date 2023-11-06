package com.sakana.eduservice.entity.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 分页讲师查询实体类
 * @author YU Chenxi
 * @since 2023/10/11 1:01
 */
@Data
public class TeacherQuery {
    @ApiModelProperty(value = "讲师名称，模糊查询")
    private String name;
    @ApiModelProperty(value = "头衔 1高级讲师 2首席讲师")
    private Integer level;
    @ApiModelProperty(value = "查询开始时间", example = "2023-01-01 10:10:10")
    private String begin;//注意，这里使用的是String类型，前端传过来的数据无需进行类型转换
    @ApiModelProperty(value = "查询结束时间", example = "2023-12-01 10:10:10")
    private String end;

}
