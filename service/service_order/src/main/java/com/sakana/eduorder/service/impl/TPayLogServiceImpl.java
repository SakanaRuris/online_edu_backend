package com.sakana.eduorder.service.impl;

import com.sakana.eduorder.entity.TPayLog;
import com.sakana.eduorder.mapper.TPayLogMapper;
import com.sakana.eduorder.service.TOrderService;
import com.sakana.eduorder.service.TPayLogService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * <p>
 * 支付日志表 服务实现类
 * </p>
 *
 * @author YU Chenxi
 * @since 2023-10-31
 */
@Service
public class TPayLogServiceImpl extends ServiceImpl<TPayLogMapper, TPayLog> implements TPayLogService {

    @Autowired
    private TOrderService orderService;

    @Override
    public Map createNative(String orderNo) {
        return null;
    }
}
