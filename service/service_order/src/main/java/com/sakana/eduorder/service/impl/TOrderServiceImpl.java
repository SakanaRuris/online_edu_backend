package com.sakana.eduorder.service.impl;

import com.sakana.commonutils.vo.CourseVo;
import com.sakana.commonutils.vo.UcenterMemberVo;
import com.sakana.eduorder.client.EduClient;
import com.sakana.eduorder.client.UcenterClient;
import com.sakana.eduorder.entity.TOrder;
import com.sakana.eduorder.mapper.TOrderMapper;
import com.sakana.eduorder.service.TOrderService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sakana.eduorder.utils.OrderNoUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 订单 服务实现类
 * </p>
 *
 * @author YU Chenxi
 * @since 2023-10-31
 */
@Service
public class TOrderServiceImpl extends ServiceImpl<TOrderMapper, TOrder> implements TOrderService {

    @Autowired
    private UcenterClient ucenterClient;

    @Autowired
    private EduClient eduClient;

    /**
     * 新建订单
     * @param courseId
     * @param memberIdByJwtToken
     * @return
     */
    @Override
    public String createOrder(String courseId, String memberIdByJwtToken) {
        UcenterMemberVo ucenterClientInfo = ucenterClient.getInfo(memberIdByJwtToken);
        CourseVo courseInfo = eduClient.getCourseInfo(courseId);
        TOrder order = new TOrder();

        order.setOrderNo(OrderNoUtil.getOrderNo());
        order.setCourseId(courseId);
        order.setCourseTitle(courseInfo.getTitle());
        order.setCourseCover(courseInfo.getCover());
        order.setTeacherName("test");
        order.setTotalFee(courseInfo.getPrice());
        order.setMemberId(memberIdByJwtToken);
        order.setEmail(ucenterClientInfo.getEmail());
        order.setNickname(ucenterClientInfo.getNickname());
        order.setStatus(0);
        order.setPayType(1);
        baseMapper.insert(order);

        return order.getOrderNo();
    }
}
