package com.sakana.eduservice.controller.front;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.sakana.commonutils.R;
import com.sakana.eduservice.entity.EduCourse;
import com.sakana.eduservice.entity.EduTeacher;
import com.sakana.eduservice.service.EduCourseService;
import com.sakana.eduservice.service.EduTeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * 前端讲师类
 * @author YU Chenxi
 * @since 2023/10/30 21:41
 */
@RestController
@RequestMapping("/eduservice/teacherfront")
public class TeacherFrontController {
    @Autowired
    private EduTeacherService teacherService;

    @Autowired
    private EduCourseService courseService;

    /**
     * 客户端分页显示讲师
     * @param page
     * @param limit
     * @return
     */
    @PostMapping("/getTeacherFrontList/{page}/{limit}")
    public R getTeacherFrontList(@PathVariable long page, @PathVariable long limit){
        Page<EduTeacher> pageTeacher = new Page<>(page,limit);
        Map<String, Object> map = teacherService.getTeacherFrontList(pageTeacher);
        return R.ok().data(map);
    }

    /**
     * 根据讲师id获得讲师信息和其教的课程
     * @param id
     * @return
     */
    @GetMapping("/getTeacherFrontInfo/{id}")
    public R getTeacherFrontInfo(@PathVariable String id){
        EduTeacher teacher = teacherService.getById(id);
        QueryWrapper<EduCourse> wrapper = new QueryWrapper<>();
        wrapper.eq("teacher_id",id);
        List<EduCourse> courseList = courseService.list(wrapper);
        return R.ok().data("teacher",teacher).data("courseList",courseList);
    }
}
