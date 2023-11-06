package com.sakana.eduorder.controller;


import com.sakana.commonutils.R;
import com.sakana.eduorder.entity.TPayLog;
import com.sakana.eduorder.service.TPayLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * <p>
 * 支付日志表 前端控制器
 * </p>
 *
 * @author YU Chenxi
 * @since 2023-10-31
 */
@RestController
@RequestMapping("/educenter/paylog")
public class TPayLogController {

    @Autowired
    private TPayLogService payLogService;

    /**
     * 账单页面
     * @param orderNo
     * @return
     */
    @GetMapping("/createNative/{orderNo}")
    public R createNative(@PathVariable String orderNo) {
        Map map = payLogService.createNative(orderNo);
        return R.ok().data(map);
    }

}

