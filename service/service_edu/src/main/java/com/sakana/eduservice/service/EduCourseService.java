package com.sakana.eduservice.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.sakana.eduservice.entity.EduCourse;
import com.baomidou.mybatisplus.extension.service.IService;
import com.sakana.eduservice.entity.frontVo.CourseFrontVo;
import com.sakana.eduservice.entity.frontVo.CourseWebVo;
import com.sakana.eduservice.entity.vo.CourseInfoVo;
import com.sakana.eduservice.entity.vo.CoursePublishVo;
import com.sakana.eduservice.entity.vo.CourseQuery;

import java.util.Map;

/**
 * <p>
 * 课程 服务类
 * </p>
 *
 * @author YU Chenxi
 * @since 2023-10-22
 */
public interface EduCourseService extends IService<EduCourse> {

    String saveCourseInfo(CourseInfoVo courseInfoVo);

    CourseInfoVo getCourseInfo(String courseId);

    void updateCourseInfo(CourseInfoVo courseInfoVo);

    CoursePublishVo publishCourseInfo(String id);

    void removeCourse(String courseId);

    Map<String, Object> pageCourseCondition(long current, long limit, CourseQuery courseQuery);

    Map<String, Object> getCourseFrontList(Page<EduCourse> pageCourse, CourseFrontVo courseFrontVo);

    CourseWebVo getBaseCourseInfo(String courseId);
}
