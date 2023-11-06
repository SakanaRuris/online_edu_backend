package com.sakana.eduservice.controller.front;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.sakana.commonutils.R;
import com.sakana.eduservice.entity.EduCourse;
import com.sakana.eduservice.entity.EduTeacher;
import com.sakana.eduservice.service.EduCourseService;
import com.sakana.eduservice.service.EduTeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 用于客户端
 * @author YU Chenxi
 * @since 2023/10/27 1:06
 */
@RestController
@RequestMapping("/eduservice/indexfront")
public class IndexFrontController {
    @Autowired
    private EduCourseService courseService;

    @Autowired
    private EduTeacherService teacherService;

    /**
     * 前端首页显示8个热门课程，和4位名师
     * @return
     */
    
    @GetMapping("/index")
    public R index(){
        QueryWrapper<EduCourse> courseQueryWrapper = new QueryWrapper<>();
        courseQueryWrapper.orderByDesc("view_count").last("limit 8");
        List<EduCourse> courseList = courseService.list(courseQueryWrapper);


        QueryWrapper<EduTeacher> teacherQueryWrapper = new QueryWrapper<>();
        teacherQueryWrapper.orderByDesc("id").last("limit 4");
        List<EduTeacher> teacherList = teacherService.list(teacherQueryWrapper);

        return R.ok().data("courseList",courseList).data("teacherList",teacherList);
    }

}
