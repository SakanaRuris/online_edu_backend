package com.sakana.eduservice.entity.chapter;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * 章节显示，一个章节中多个小节
 * @author YU Chenxi
 * @since 2023/10/23 23:01
 */
@Data
public class ChapterVo {

    private String id;

    private String title;

    private List<VideoVo> children = new ArrayList<>();
}
