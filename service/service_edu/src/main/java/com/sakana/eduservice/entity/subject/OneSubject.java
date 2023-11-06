package com.sakana.eduservice.entity.subject;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * 课程一级分类
 * @author YU Chenxi
 * @since 2023/10/21 22:11
 */
@Data
public class OneSubject {
    private List<TwoSubject> children = new ArrayList<>();

    private String id;

    private String title;
}
