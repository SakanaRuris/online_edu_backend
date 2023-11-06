package com.sakana.eduservice.controller.front;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.sakana.commonutils.R;
import com.sakana.commonutils.vo.CourseVo;
import com.sakana.eduservice.entity.EduCourse;
import com.sakana.eduservice.entity.chapter.ChapterVo;
import com.sakana.eduservice.entity.frontVo.CourseFrontVo;
import com.sakana.eduservice.entity.frontVo.CourseWebVo;
import com.sakana.eduservice.service.EduChapterService;
import com.sakana.eduservice.service.EduCourseService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * @author YU Chenxi
 * @since 2023/10/30 23:06
 */
@RestController
@RequestMapping("/eduservice/coursefront")
public class CourseFrontController {
    @Autowired
    private EduCourseService courseService;

    @Autowired
    private EduChapterService chapterService;

    /**
     * 客户端条件分页查询课程
     * @param page
     * @param limit
     * @param courseFrontVo
     * @return
     */
    @PostMapping("/getFrontCourseList/{page}/{limit}")
    public R getFrontCourseList(@PathVariable long page, @PathVariable long limit,
                                @RequestBody(required = false)CourseFrontVo courseFrontVo){
        Page<EduCourse> pageCourse = new Page<>(page,limit);
        Map<String,Object> map = courseService.getCourseFrontList(pageCourse,courseFrontVo);
        return R.ok().data(map);
    }

    /**
     * 客户端查询课程
     * @param courseId
     * @return
     */
    @GetMapping("/getFrontCourseInfo/{courseId}")
    public R getFrontCourseInfo(@PathVariable String courseId){
        CourseWebVo courseWebVo = courseService.getBaseCourseInfo(courseId);

        List<ChapterVo> chapterVideoList = chapterService.getChapterVideoByCourseId(courseId);
        return R.ok().data("courseWebVo",courseWebVo).data("chapterVideoList",chapterVideoList);
    }

    /**
     * 用于全局的课程信息
     * @param id
     * @return
     */
    @PostMapping("/getCourseInfo/{id}")
    public CourseVo getCourseInfo(@PathVariable String id){
        CourseWebVo courseInfo = courseService.getBaseCourseInfo(id);
        CourseVo courseVo = new CourseVo();
        BeanUtils.copyProperties(courseInfo,courseVo);
        return courseVo;
    }
}
