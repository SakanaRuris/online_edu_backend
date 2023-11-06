package com.sakana.eduservice.client;

import com.sakana.commonutils.vo.UcenterMemberVo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * @author YU Chenxi
 * @since 2023/11/1 20:21
 */
@Component
@FeignClient(name="service-ucenter")
public interface UcenterClient {

    /**
     * 根据用户id获取用户信息
     * @param id
     * @return
     */
    @PostMapping("/educenter/member/getInfoUc/{id}")
    public UcenterMemberVo getInfo(@PathVariable("id") String id);
}
