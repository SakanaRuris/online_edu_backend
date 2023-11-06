package com.sakana.eduservice.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.sakana.eduservice.entity.EduTeacher;
import com.baomidou.mybatisplus.extension.service.IService;
import com.sakana.eduservice.entity.vo.TeacherQuery;

import java.util.Map;

/**
 * <p>
 * 讲师 服务类
 * </p>
 *
 * @author YU Chenxi
 * @since 2023-10-10
 */
public interface EduTeacherService extends IService<EduTeacher> {

    Map<String, Object> pageListTeacher(long current, long limit);

    Map<String, Object> pageTeacherCondition(long current, long limit, TeacherQuery teacherQuery);

    Map<String, Object> getTeacherFrontList(Page<EduTeacher> pageTeacher);
}
