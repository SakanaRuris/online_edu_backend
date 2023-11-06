package com.sakana.eduorder.service;

import com.sakana.eduorder.entity.TOrder;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 订单 服务类
 * </p>
 *
 * @author YU Chenxi
 * @since 2023-10-31
 */
public interface TOrderService extends IService<TOrder> {

    String createOrder(String courseId, String memberIdByJwtToken);
}
