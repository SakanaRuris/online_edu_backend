package com.sakana.educms.controller;


import com.sakana.commonutils.R;
import com.sakana.educms.entity.CrmBanner;
import com.sakana.educms.service.CrmBannerService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * <p>
 * 后端banner管理接口
 * </p>
 *
 * @author YU Chenxi
 * @since 2023-10-26
 */
@RestController
@RequestMapping("/educms/banneradmin")
public class BannerAdminController {

    @Autowired
    private CrmBannerService bannerService;
    /**
     * 分页查询banner
     * @param page
     * @param limit
     * @return
     */
    @GetMapping("/pageBanner/{page}/{limit}")
    public R pageBanner(@PathVariable long page, @PathVariable long limit){
        Map<String,Object> map = bannerService.pageListBanner(page, limit);
        return R.ok().data(map);
    }

    /**
     * 获取Banner
     * @param id
     * @return
     */
    @ApiOperation(value = "获取Banner")
    @GetMapping("get/{id}")
    public R get(@PathVariable String id) {
        CrmBanner banner = bannerService.getById(id);
        return R.ok().data("item", banner);
    }

    /**
     * 新增Banner
     * @param banner
     * @return
     */
    @ApiOperation(value = "新增Banner")
    @PostMapping("/addBanner")
    public R save(@RequestBody CrmBanner banner) {
        bannerService.save(banner);
        return R.ok();
    }

    /**
     * 修改Banner
     * @param banner
     * @return
     */
    @ApiOperation(value = "修改Banner")
    @PutMapping("update")
    public R updateById(@RequestBody CrmBanner banner) {
        bannerService.updateById(banner);
        return R.ok();
    }

    /**
     * 删除Banner
     * @param id
     * @return
     */
    @ApiOperation(value = "删除Banner")
    @DeleteMapping("remove/{id}")
    public R remove(@PathVariable String id) {
        bannerService.removeById(id);
        return R.ok();
    }

}

