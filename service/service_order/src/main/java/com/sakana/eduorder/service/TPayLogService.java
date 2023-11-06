package com.sakana.eduorder.service;

import com.sakana.eduorder.entity.TPayLog;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.Map;

/**
 * <p>
 * 支付日志表 服务类
 * </p>
 *
 * @author YU Chenxi
 * @since 2023-10-31
 */
public interface TPayLogService extends IService<TPayLog> {

    Map createNative(String orderNo);
}
