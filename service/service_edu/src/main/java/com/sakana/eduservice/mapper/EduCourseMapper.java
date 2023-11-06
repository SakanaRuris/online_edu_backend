package com.sakana.eduservice.mapper;

import com.sakana.eduservice.entity.EduCourse;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.sakana.eduservice.entity.frontVo.CourseWebVo;
import com.sakana.eduservice.entity.vo.CourseInfoVo;
import com.sakana.eduservice.entity.vo.CoursePublishVo;

/**
 * <p>
 * 课程 Mapper 接口
 * </p>
 *
 * @author YU Chenxi
 * @since 2023-10-22
 */
public interface EduCourseMapper extends BaseMapper<EduCourse> {
    /**
     * 获得课程最终发布信息
     * @param courseId
     * @return
     */
    public CoursePublishVo getPublishCourseInfo(String courseId);

    CourseWebVo getBaseCourseInfo(String courseId);
}