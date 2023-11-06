package com.sakana.eduservice.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.sakana.eduservice.entity.EduTeacher;
import com.sakana.eduservice.entity.vo.TeacherQuery;
import com.sakana.eduservice.mapper.EduTeacherMapper;
import com.sakana.eduservice.service.EduTeacherService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 讲师 服务实现类
 * </p>
 *
 * @author YU Chenxi
 * @since 2023-10-10
 */
@Service
public class EduTeacherServiceImpl extends ServiceImpl<EduTeacherMapper, EduTeacher> implements EduTeacherService {

    /**
     * 分页查询讲师信息
     * @param current
     * @param limit
     * @return
     */
    @Override
    public Map<String, Object> pageListTeacher(long current, long limit) {
        Page<EduTeacher> pageTeacher = new Page<>(current,limit);
        this.page(pageTeacher,null);
        return getStringObjectMap(pageTeacher);
    }

    /**
     * 分页查询讲师
     * @param current
     * @param limit
     * @param teacherQuery
     * @return
     */
    @Override
    public Map<String, Object> pageTeacherCondition(long current, long limit, TeacherQuery teacherQuery) {
        Page<EduTeacher> pageTeacher = new Page<>(current,limit);
        QueryWrapper<EduTeacher> wrapper = new QueryWrapper<>();
        String name = teacherQuery.getName();
        Integer level = teacherQuery.getLevel();
        String begin = teacherQuery.getBegin();
        String end = teacherQuery.getEnd();
        if(!StringUtils.isEmpty(name))
            wrapper.like("name",name);
        if(!StringUtils.isEmpty(level))
            wrapper.eq("level",level);
        if(!StringUtils.isEmpty(begin))
            wrapper.ge("gmt_create",begin);
        if(!StringUtils.isEmpty(end))
            wrapper.le("gmt_create",end);
        wrapper.orderByDesc("gmt_modified");
        this.page(pageTeacher,wrapper);
        return getStringObjectMap(pageTeacher);
    }

    /**
     * 客户端分页显示讲师
     * @param pageTeacher
     * @return
     */
    @Override
    public Map<String, Object> getTeacherFrontList(Page<EduTeacher> pageTeacher) {
        QueryWrapper<EduTeacher> wrapper = new QueryWrapper<>();
        wrapper.orderByDesc("id");
        baseMapper.selectPage(pageTeacher,wrapper);

        List<EduTeacher> records = pageTeacher.getRecords();
        long current = pageTeacher.getCurrent();
        long pages = pageTeacher.getPages();
        long size = pageTeacher.getSize();
        long total = pageTeacher.getTotal();
        boolean hasNext = pageTeacher.hasNext();
        boolean hasPrevious = pageTeacher.hasPrevious();
        Map<String, Object> map = new HashMap();
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
     * 封装函数，用于获取查询的数据
     * @param pageTeacher
     * @return
     */
    private Map<String, Object> getStringObjectMap(Page<EduTeacher> pageTeacher) {
        List<EduTeacher> records = pageTeacher.getRecords();
        long total = pageTeacher.getTotal();
        Map<String,Object> map = new HashMap<>();
        map.put("total",total);
        map.put("rows",records);
        return map;
    }
}
