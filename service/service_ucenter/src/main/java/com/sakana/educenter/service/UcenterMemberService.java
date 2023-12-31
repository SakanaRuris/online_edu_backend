package com.sakana.educenter.service;

import com.sakana.educenter.entity.UcenterMember;
import com.baomidou.mybatisplus.extension.service.IService;
import com.sakana.educenter.entity.vo.RegisterVo;

/**
 * <p>
 * 会员表 服务类
 * </p>
 *
 * @author YU Chenxi
 * @since 2023-10-27
 */
public interface UcenterMemberService extends IService<UcenterMember> {

    String login(UcenterMember member);

    void register(RegisterVo registerVo);
}
