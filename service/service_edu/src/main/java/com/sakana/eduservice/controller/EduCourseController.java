package com.sakana.eduservice.controller;


import com.sakana.commonutils.R;
import com.sakana.eduservice.entity.EduCourse;
import com.sakana.eduservice.entity.vo.CourseInfoVo;
import com.sakana.eduservice.entity.vo.CoursePublishVo;
import com.sakana.eduservice.entity.vo.CourseQuery;
import com.sakana.eduservice.service.EduCourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 课程 前端控制器
 * </p>
 *
 * @author YU Chenxi
 * @since 2023-10-22
 */
@RestController
@RequestMapping("/eduservice/course")
public class EduCourseController {

    @Autowired
    private EduCourseService courseService;


    /**
     * 获得所有课程信息
     * @return
     */
    @GetMapping("/getAllCourse")
    public R getAllCourse(){
        List<EduCourse> list = courseService.list(null);
        return R.ok().data("list",list);
    }

    /**
     * 分页查询课程
     * @param current
     * @param limit
     * @param courseQuery
     * @return
     */
    @PostMapping("/pageCourseCondition/{current}/{limit}")
    public R pageCourseCondition(@PathVariable long current,
                                 @PathVariable long limit,
                                 @RequestBody(required = false) CourseQuery courseQuery){
        Map<String,Object> map = courseService.pageCourseCondition(current,limit,courseQuery);
        return R.ok().data(map);
    }
    /**
     * 添加课程信息
     * @param courseInfoVo
     * @return
     */
    @PostMapping("/addCourseInfo")
    public R addCourseInfo(@RequestBody CourseInfoVo courseInfoVo){
        String id = courseService.saveCourseInfo(courseInfoVo);
        return R.ok().data("courseId",id);
    }

    /**
     * 查询课程信息
     * @param courseId
     * @return
     */
    @GetMapping("/getCourseInfo/{courseId}")
    public R getCourseInfo(@PathVariable String courseId){
        CourseInfoVo courseInfoVo = courseService.getCourseInfo(courseId);
        return R.ok().data("courseInfoVo",courseInfoVo);
    }

    /**
     * 修改课程信息
     * @param courseInfoVo
     * @return
     */
    @PostMapping("/updateCourseInfo")
    public R updateCourseInfo(@RequestBody CourseInfoVo courseInfoVo){
        courseService.updateCourseInfo(courseInfoVo);
        return R.ok();
    }

    /**
     * 获得最终发布的课程信息
     * @param id
     * @return
     */
    @GetMapping("getPublishCourseInfo/{id}")
    public R getPublishCourseInfo(@PathVariable String id){
        CoursePublishVo coursePublishVo = courseService.publishCourseInfo(id);
        return R.ok().data("publishCourse",coursePublishVo);
    }

    /**
     * 课程最终发布
     * @param id
     * @return
     */
    @PostMapping("/publishCourse/{id}")
    public R publishCourse(@PathVariable String id){
        EduCourse eduCourse = new EduCourse();
        eduCourse.setId(id);
        eduCourse.setStatus("Normal");
        courseService.updateById(eduCourse);
        return R.ok();
    }

    /**
     * 删除课程
     * @param courseId
     * @return
     */
    @DeleteMapping("/{courseId}")
    public R deleteCourse(@PathVariable String courseId){
        courseService.removeCourse(courseId);
        return R.ok();
    }
}

