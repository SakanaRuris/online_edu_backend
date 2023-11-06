package com.sakana.eduservice.service.impl;

import com.alibaba.excel.EasyExcel;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.sakana.eduservice.entity.EduSubject;
import com.sakana.eduservice.entity.excel.SubjectData;
import com.sakana.eduservice.entity.subject.OneSubject;
import com.sakana.eduservice.entity.subject.TwoSubject;
import com.sakana.eduservice.listener.SubjectExcelListener;
import com.sakana.eduservice.mapper.EduSubjectMapper;
import com.sakana.eduservice.service.EduSubjectService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.apache.poi.ss.formula.functions.T;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * 课程科目 服务实现类
 * </p>
 *
 * @author YU Chenxi
 * @since 2023-10-20
 */
@Service
public class EduSubjectServiceImpl extends ServiceImpl<EduSubjectMapper, EduSubject> implements EduSubjectService {

    @Override
    public void saveSubject(MultipartFile file, EduSubjectService subjectService)  {
        try {
            InputStream in = file.getInputStream();
            EasyExcel.read(in, SubjectData.class,new SubjectExcelListener(subjectService)).sheet().doRead();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<OneSubject> getAllOneTwoSubject() {
        QueryWrapper<EduSubject> wrapperOne = new QueryWrapper<>();
        wrapperOne.eq("parent_id","0");
        wrapperOne.orderByAsc("sort", "id");
        List<EduSubject> oneSubjectList = baseMapper.selectList(wrapperOne);
//        List<EduSubject> oneSubjectList= this.list(wrapperOne);
        QueryWrapper<EduSubject> wrapperTwo = new QueryWrapper<>();
        wrapperTwo.ne("parent_id","0");
        wrapperTwo.orderByAsc("sort", "parent_id");
        List<EduSubject> twoSubjectList = baseMapper.selectList(wrapperTwo);

        List<OneSubject> finalSubjectList = new ArrayList<>();
        for (int i = 0; i < oneSubjectList.size(); i++) {
            EduSubject eduSubject = oneSubjectList.get(i);
            OneSubject oneSubject = new OneSubject();
//            oneSubject.setId(eduSubject.getId());
//            oneSubject.setTitle(eduSubject.getTitle());
            BeanUtils.copyProperties(eduSubject,oneSubject);
            List<TwoSubject> twoFinalSubjectList = new ArrayList<>();
            for (int j = 0; j < twoSubjectList.size(); j++) {
                EduSubject tSubject = twoSubjectList.get(j);
                if(tSubject.getParentId().equals(eduSubject.getId())){
                    TwoSubject twoSubject = new TwoSubject();
                    BeanUtils.copyProperties(tSubject,twoSubject);
                    twoFinalSubjectList.add(twoSubject);
                }
            }
            oneSubject.setChildren(twoFinalSubjectList);
            finalSubjectList.add(oneSubject);
        }
        return finalSubjectList;
    }
}
