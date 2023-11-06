package com.sakana.eduservice.service;

import com.sakana.eduservice.entity.EduChapter;
import com.baomidou.mybatisplus.extension.service.IService;
import com.sakana.eduservice.entity.chapter.ChapterVo;

import java.util.List;

/**
 * <p>
 * 课程 服务类
 * </p>
 *
 * @author YU Chenxi
 * @since 2023-10-22
 */
public interface EduChapterService extends IService<EduChapter> {

    List<ChapterVo> getChapterVideoByCourseId(String courseId);

    boolean deleteChapter(String chapterId);

    void removeChapterByCourseId(String courseId);
}
