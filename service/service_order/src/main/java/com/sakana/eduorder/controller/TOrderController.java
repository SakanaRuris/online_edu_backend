package com.sakana.eduorder.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.sakana.commonutils.JwtUtils;
import com.sakana.commonutils.R;
import com.sakana.eduorder.entity.TOrder;
import com.sakana.eduorder.service.TOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

/**
 * <p>
 * 订单 前端控制器
 * </p>
 *
 * @author YU Chenxi
 * @since 2023-10-31
 */
@RestController
@RequestMapping("/eduorder/order")
public class TOrderController {
    @Autowired
    public TOrderService orderService;

    /**
     * 创建订单
     * @param courseId
     * @return
     */
    @PostMapping("/createOrder/{courseId}")
    public R saveOrder(@PathVariable String courseId, HttpServletRequest request){
        String orderId = orderService.createOrder(courseId,JwtUtils.getMemberIdByJwtToken(request));
        return R.ok().data("order",orderId);
    }

    @GetMapping("/getOrderInfo/{orderId}")
    public R getOrderInfo(@PathVariable String orderId){
        QueryWrapper<TOrder> wrapper = new QueryWrapper<>();
        wrapper.eq("order_no",orderId);
        TOrder order = orderService.getOne(wrapper);
        return R.ok().data("item",order);
    }
}

