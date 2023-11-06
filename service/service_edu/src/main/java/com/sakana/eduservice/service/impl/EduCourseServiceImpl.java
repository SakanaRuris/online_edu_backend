package com.sakana.eduservice.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.sakana.eduservice.entity.EduCourse;
import com.sakana.eduservice.entity.EduCourseDescription;
import com.sakana.eduservice.entity.EduTeacher;
import com.sakana.eduservice.entity.frontVo.CourseFrontVo;
import com.sakana.eduservice.entity.frontVo.CourseWebVo;
import com.sakana.eduservice.entity.vo.CourseInfoVo;
import com.sakana.eduservice.entity.vo.CoursePublishVo;
import com.sakana.eduservice.entity.vo.CourseQuery;
import com.sakana.eduservice.mapper.EduCourseMapper;
import com.sakana.eduservice.service.EduChapterService;
import com.sakana.eduservice.service.EduCourseDescriptionService;
import com.sakana.eduservice.service.EduCourseService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sakana.eduservice.service.EduVideoService;
import com.sakana.servicebase.exceptionhandler.GuliException;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 课程 服务实现类
 * </p>
 *
 * @author YU Chenxi
 * @since 2023-10-22
 */
@Service
public class EduCourseServiceImpl extends ServiceImpl<EduCourseMapper, EduCourse> implements EduCourseService {

    @Autowired
    private EduCourseDescriptionService courseDescriptionService;

    @Autowired
    private EduVideoService videoService;

    @Autowired
    private EduChapterService chapterService;

    /**
     * 添加课程信息
     * @param courseInfoVo
     */
    @Override
    public String saveCourseInfo(CourseInfoVo courseInfoVo) {
        EduCourse eduCourse = new EduCourse();
        BeanUtils.copyProperties(courseInfoVo,eduCourse);
        int insert = baseMapper.insert(eduCourse);
        if(insert ==0){
            throw new GuliException(20001,"添加课程失败");
        }
        String cid = eduCourse.getId();
        EduCourseDescription courseDescription = new EduCourseDescription();
        courseDescription.setDescription(courseInfoVo.getDescription());
        courseDescription.setId(cid);
        courseDescriptionService.save(courseDescription);
        return cid;
    }

    /**
     * 查询课程信息
     * @param courseId
     * @return
     */
    @Override
    public CourseInfoVo getCourseInfo(String courseId) {
        EduCourse eduCourse = baseMapper.selectById(courseId);

        EduCourseDescription courseDescription = courseDescriptionService.getById(courseId);

        CourseInfoVo courseInfoVo = new CourseInfoVo();

        BeanUtils.copyProperties(eduCourse,courseInfoVo);
        BeanUtils.copyProperties(courseDescription,courseInfoVo);


        return courseInfoVo;
    }

    /**
     * 修改课程信息
     * @param courseInfoVo
     */
    @Override
    public void updateCourseInfo(CourseInfoVo courseInfoVo) {
        EduCourse eduCourse = new EduCourse();
        BeanUtils.copyProperties(courseInfoVo,eduCourse);
        int update = baseMapper.updateById(eduCourse);
        if(update == 0){
            throw new GuliException(20001,"修改课程信息失败");
        }

        EduCourseDescription eduCourseDescription = new EduCourseDescription();
        BeanUtils.copyProperties(courseInfoVo,eduCourseDescription);
        courseDescriptionService.updateById(eduCourseDescription);
    }

    /**
     * 获得最终发布的课程信息
     * @param id
     * @return
     */
    @Override
    public CoursePublishVo publishCourseInfo(String id) {
        CoursePublishVo publishCourseInfo = baseMapper.getPublishCourseInfo(id);
        return publishCourseInfo;
    }

    /**
     * 删除课程
     * @param courseId
     */
    @Override
    public void removeCourse(String courseId) {
        videoService.removeVideoByCourseId(courseId);
        chapterService.removeChapterByCourseId(courseId);
        courseDescriptionService.removeById(courseId);
        int result = baseMapper.deleteById(courseId);

        if(result == 0){
            throw new GuliException(20001,"删除课程失败");
        }
    }

    /**
     * 分页查询课程
     * @param current
     * @param limit
     * @param courseQuery
     * @return
     */
    @Override
    public Map<String, Object> pageCourseCondition(long current, long limit, CourseQuery courseQuery) {
        Page<EduCourse> pageCourse = new Page<>(current,limit);
        QueryWrapper<EduCourse> wrapper = new QueryWrapper<>();
        String title = courseQuery.getTitle();
        String status = courseQuery.getStatus();
        String begin = courseQuery.getBegin();
        String end = courseQuery.getEnd();
        if(!StringUtils.isEmpty(title))
            wrapper.like("title",title);
        if(!StringUtils.isEmpty(status))
            wrapper.eq("status",status);
        if(!StringUtils.isEmpty(begin))
            wrapper.ge("gmt_create",begin);
        if(!StringUtils.isEmpty(end))
            wrapper.le("gmt_create",end);
        wrapper.orderByDesc("gmt_modified");
        this.page(pageCourse,wrapper);
        List<EduCourse> records = pageCourse.getRecords();
        long total = pageCourse.getTotal();
        Map<String,Object> map = new HashMap<>();
        map.put("total",total);
        map.put("rows",records);
        return map;
    }

    /**
     * 客户端条件分页查询
     * @param pageCourse
     * @param courseFrontVo
     * @return
     */
    @Override
    public Map<String, Object> getCourseFrontList(Page<EduCourse> pageCourse, CourseFrontVo courseFrontVo) {
        QueryWrapper<EduCourse> wrapper = new QueryWrapper<>();
        if (!StringUtils.isEmpty(courseFrontVo.getSubjectParentId())) {
            wrapper.eq("subject_parent_id", courseFrontVo.getSubjectParentId());
        }

        if (!StringUtils.isEmpty(courseFrontVo.getSubjectId())) {
            wrapper.eq("subject_id", courseFrontVo.getSubjectId());
        }

        if (!StringUtils.isEmpty(courseFrontVo.getBuyCountSort())) {
            wrapper.orderByDesc("buy_count");
        }

        if (!StringUtils.isEmpty(courseFrontVo.getGmtCreateSort())) {
            wrapper.orderByDesc("gmt_create");
        }

        if (!StringUtils.isEmpty(courseFrontVo.getPriceSort())) {
            wrapper.orderByDesc("price");
        }
        baseMapper.selectPage(pageCourse, wrapper);

        List<EduCourse> records = pageCourse.getRecords();
        long current = pageCourse.getCurrent();
        long pages = pageCourse.getPages();
        long size = pageCourse.getSize();
        long total = pageCourse.getTotal();
        boolean hasNext = pageCourse.hasNext();
        boolean hasPrevious = pageCourse.hasPrevious();

        Map<String, Object> map = new HashMap<String, Object>();
        map.put("items", records);
        map.put("current", current);
        map.put("pages", pages);
        map.put("size", size);
        map.put("total", total);
        map.put("hasNext", hasNext);
        map.put("hasPrevious", hasPrevious);

        return map;
    }

    /**
     * 客户端显示课程信息
     * @param courseId
     * @return
     */
    @Override
    public CourseWebVo getBaseCourseInfo(String courseId) {
        return baseMapper.getBaseCourseInfo(courseId);
    }
}
