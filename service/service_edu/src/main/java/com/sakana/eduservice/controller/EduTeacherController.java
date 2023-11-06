package com.sakana.eduservice.controller;



import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.sakana.commonutils.R;
import com.sakana.eduservice.entity.EduTeacher;
import com.sakana.eduservice.entity.vo.TeacherQuery;
import com.sakana.eduservice.service.EduTeacherService;
import com.sakana.servicebase.exceptionhandler.GuliException;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 讲师 前端控制器
 * </p>
 *
 * @author YU Chenxi
 * @since 2023-10-10
 */
@Api(description = "讲师管理")
@RestController
@RequestMapping("/eduservice/teacher")
public class EduTeacherController {
    @Autowired
    private EduTeacherService eduTeacherService;


    /**
     * 获得所有讲师信息
     * @return
     */
    @ApiOperation(value = "所有讲师列表")
    @GetMapping("/findAll")
    public R findAllTeacher(){
        List<EduTeacher> list = eduTeacherService.list(null);
        return R.ok().data("items",list);
    }

    /**
     * 根据id删除讲师信息
     * @param id 讲师id
     * @return
     */

    @ApiOperation(value = "逻辑删除讲师")
    @DeleteMapping("/{id}")
    public R removeTeacher(@ApiParam(name = "id", value = "讲师ID", required = true) @PathVariable String id){
        boolean flag = eduTeacherService.removeById(id);
        if(flag)
            return R.ok();
        else
            return R.error();
    }

    /**
     * 分页查询讲师信息
     * @param current 当前页
     * @param limit   每页记录数
     * @return
     */
    @ApiOperation(value = "分页查询讲师信息")
    @GetMapping("/pageTeacher/{current}/{limit}")
    public R pageListTeacher(@PathVariable long current,
                             @PathVariable long limit){
        Map<String,Object> map = eduTeacherService.pageListTeacher(current, limit);
        return R.ok().data(map);
    }

    /**
     * 分页条件查询
     * @param current 当前页
     * @param limit   每页记录数
     * @param teacherQuery 条件
     * @return
     */
    @ApiOperation(value = "分页条件查询讲师信息")
    @PostMapping("pageTeacherCondition/{current}/{limit}")
    public R pageTeacherCondition(@PathVariable long current,
                                  @PathVariable long limit,
                                  @RequestBody(required = false) TeacherQuery teacherQuery){
        Map<String,Object> map = eduTeacherService.pageTeacherCondition(current,limit,teacherQuery);
        return R.ok().data(map);
    }

    /**
     * 添加讲师
     * @param eduTeacher
     * @return
     */
    @ApiOperation(value = "添加讲师")
    @PostMapping("/addTeacher")
    public R addTeacher(@RequestBody EduTeacher eduTeacher){
        boolean save = eduTeacherService.save(eduTeacher);
        if(save){
            return R.ok();
        }
        else {
            return R.error();
        }
    }

    /**
     * 根据id查询讲师
     * @param id
     * @return
     */
    @ApiOperation(value = "根据id查询讲师")
    @GetMapping("/getTeacher/{id}")
    public R getTeacher(@PathVariable String id){
        EduTeacher teacher = eduTeacherService.getById(id);
        return R.ok().data("teacher",teacher);
    }

    /**
     * 修改讲师
     * @param eduTeacher
     * @return
     */
    @ApiOperation(value = "修改讲师")
    @PostMapping("/updateTeacher")
    public R updateTeacher(@RequestBody EduTeacher eduTeacher){
        boolean flag = eduTeacherService.updateById(eduTeacher);
        if(flag){
            return R.ok();
        }
        else {
            return R.error();
        }
    }
}

