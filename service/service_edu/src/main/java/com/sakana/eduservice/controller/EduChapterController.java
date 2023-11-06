package com.sakana.eduservice.controller;


import com.sakana.commonutils.R;
import com.sakana.eduservice.entity.EduChapter;
import com.sakana.eduservice.entity.EduTeacher;
import com.sakana.eduservice.entity.chapter.ChapterVo;
import com.sakana.eduservice.service.EduChapterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 课程 前端控制器
 * </p>
 *
 * @author YU Chenxi
 * @since 2023-10-22
 */
@RestController
@RequestMapping("/eduservice/chapter")
public class EduChapterController {

    @Autowired
    private EduChapterService chapterService;

    /**
     * 获得所有章节信息（章节中包括小节）
     * @param courseId
     * @return
     */
    @GetMapping("getChapterVideo/{courseId}")
    public R getChapterVideo(@PathVariable String courseId) {
        List<ChapterVo> list = chapterService.getChapterVideoByCourseId(courseId);
        return R.ok().data("allChapterVideo",list);
    }

    /**
     * 添加章节
     * @param eduChapter
     * @return
     */
    @PostMapping("/addChapter")
    public R addChapter(@RequestBody EduChapter eduChapter) {
        chapterService.save(eduChapter);
        return R.ok();
    }

    /**
     * 根据id获取章节信息
     * @return
     */
    @GetMapping("/getChapterInfo/{chapterId}")
    public R getChapterInfo(@PathVariable String chapterId) {
        EduChapter eduChapter = chapterService.getById(chapterId);

        return R.ok().data("chapter",eduChapter);
    }

    /**
     * 修改章节
     * @param eduChapter
     * @return
     */
    @PostMapping("/updateChapter")
    public R updateChapter(@RequestBody EduChapter eduChapter) {
        chapterService.updateById(eduChapter);
        return R.ok();
    }

    /**
     * 删除章节
     * @param chapterId
     * @return
     */
    @DeleteMapping("/deleteChapter/{chapterId}")
    public R deleteChapter(@PathVariable String chapterId){
        boolean flag = chapterService.deleteChapter(chapterId);
        if(flag){
            return R.ok();
        }else {
            return R.error();
        }
    }


}

