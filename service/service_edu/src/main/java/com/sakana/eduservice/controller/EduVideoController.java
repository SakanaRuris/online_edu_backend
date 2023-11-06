package com.sakana.eduservice.controller;


import com.sakana.commonutils.R;
import com.sakana.eduservice.entity.EduVideo;
import com.sakana.eduservice.service.EduVideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 * 课程视频 前端控制器
 * </p>
 *
 * @author YU Chenxi
 * @since 2023-10-22
 */
@RestController
@RequestMapping("/eduservice/video")
public class EduVideoController {

    @Autowired
    private EduVideoService videoService;

    /**
     * 添加小节
     * @param eduVideo
     * @return
     */
    @PostMapping("/addVideo")
    public R addVideo(@RequestBody EduVideo eduVideo){
        videoService.save(eduVideo);
        return R.ok();
    }

    /**
     * 删除小节
     * @param id
     * @return
     */
    @DeleteMapping("/deleteVideo/{id}")
    public R deleteVideo(@PathVariable String id){
        videoService.removeById(id);
        return R.ok();
    }
}

