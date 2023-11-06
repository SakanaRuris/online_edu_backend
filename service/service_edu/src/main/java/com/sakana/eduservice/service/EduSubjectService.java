package com.sakana.eduservice.service;

import com.sakana.eduservice.entity.EduSubject;
import com.baomidou.mybatisplus.extension.service.IService;
import com.sakana.eduservice.entity.subject.OneSubject;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * <p>
 * 课程科目 服务类
 * </p>
 *
 * @author YU Chenxi
 * @since 2023-10-20
 */
public interface EduSubjectService extends IService<EduSubject> {
    /**
     * 用于添加学科
     * @param file
     * @param subjectService
     */
    void saveSubject(MultipartFile file, EduSubjectService subjectService);

    /**
     * 用于前端显示学科
     * @return
     */
    List<OneSubject> getAllOneTwoSubject();
}
