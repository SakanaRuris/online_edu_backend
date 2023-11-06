package com.sakana.eduservice.entity.vo;

import lombok.Data;

/**
 * 封装最终发布的课程
 * @author YU Chenxi
 * @since 2023/10/24 16:09
 */
@Data
public class CoursePublishVo {
    private String id;
    private String title;
    private String cover;
    private Integer lessonNum;
    private String subjectLevelOne;
    private String subjectLevelTwo;
    private String teacherName;
    private String price;//只用于显示
}
