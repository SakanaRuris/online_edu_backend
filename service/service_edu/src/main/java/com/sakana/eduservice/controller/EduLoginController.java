package com.sakana.eduservice.controller;

import com.sakana.commonutils.R;
import org.springframework.web.bind.annotation.*;

/**
 * @author YU Chenxi
 * @since 2023/10/16 22:32
 */

@RestController
@RequestMapping("/eduservice/user")
public class EduLoginController {

    @PostMapping("/login")
    public R login(){
        return R.ok().data("token","admin");
    }

    @GetMapping("/info")
    public R info(){
        return R.ok().data("name","admin").data("avatar","https://wpimg.wallstcn.com/f778738c-e4f8-4870-b634-56703b4acafe.gif");
    }
}
