package com.sakana.educms.controller;

import com.sakana.commonutils.R;
import com.sakana.educms.entity.CrmBanner;
import com.sakana.educms.service.CrmBannerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author YU Chenxi
 * @since 2023/10/26 23:45
 */
@RestController
@RequestMapping("/educms/bannerfront")
public class BannerFrontController {

    @Autowired
    private CrmBannerService bannerService;

    @GetMapping("/getAllBanner")
    public R getAllBanner(){
        List<CrmBanner> list= bannerService.selectAllBanner();
        return R.ok().data("list",list);
    }
}
