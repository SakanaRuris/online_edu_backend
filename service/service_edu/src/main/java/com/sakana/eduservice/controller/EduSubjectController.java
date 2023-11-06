package com.sakana.eduservice.controller;


import com.sakana.commonutils.R;
import com.sakana.eduservice.entity.subject.OneSubject;
import com.sakana.eduservice.service.EduSubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * <p>
 * 课程科目 前端控制器
 * </p>
 *
 * @author YU Chenxi
 * @since 2023-10-20
 */
@RestController
@RequestMapping("/eduservice/subject")
public class EduSubjectController {

    @Autowired
    private EduSubjectService subjectService;

    /**
     * 添加学科
     * @param file
     * @return
     */
    @PostMapping("/addSubject")
    public R addSubject(MultipartFile file){
        subjectService.saveSubject(file,subjectService);
        return R.ok();
    }

    /**
     * 获得所以学科
     * @return
     */
    @GetMapping("/getAllSubject")
    public R getAllSubject(){
        List<OneSubject> list = subjectService.getAllOneTwoSubject();
        return R.ok().data("list",list);
    }
}

