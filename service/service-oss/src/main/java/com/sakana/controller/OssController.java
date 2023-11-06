package com.sakana.controller;

import com.sakana.commonutils.R;
import com.sakana.service.OssService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author YU Chenxi
 * @since 2023/10/18 16:36
 */
@RestController
@RequestMapping("/eduoss/fileoss")
public class OssController {
    @Autowired
    private OssService ossService;

    @PostMapping()
    public R uploadOssfile(MultipartFile file){
        String url = ossService.uploadFileAvatar(file);
        return R.ok().data("url",url);
    }

}
