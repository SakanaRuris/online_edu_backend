package com.sakana.eduorder.client;

import com.sakana.commonutils.vo.UcenterMemberVo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * @author YU Chenxi
 * @since 2023/10/31 21:30
 */
@Component
@FeignClient("service-ucenter")
public interface UcenterClient {

    @PostMapping("/educenter/member/getInfoUc/{id}")
    public UcenterMemberVo getInfo(@PathVariable("id") String id);
}
