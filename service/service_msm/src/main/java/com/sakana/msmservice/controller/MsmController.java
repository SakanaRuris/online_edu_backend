package com.sakana.msmservice.controller;

import com.sakana.commonutils.R;
import com.sakana.msmservice.service.MsmService;
import com.sakana.msmservice.utils.RandomUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.TimeUnit;

/**
 * @author YU Chenxi
 * @since 2023/10/27 15:09
 */
@RestController
@RequestMapping("/edumsm/msm")
public class MsmController {

    @Autowired
    private MsmService msmService;

    @Autowired
    private RedisTemplate<String,String> redisTemplate;

    @GetMapping("/send/{email}")
    public R senMsm(@PathVariable String email){
        String code = redisTemplate.opsForValue().get(email);

        if(!StringUtils.isEmpty(code)){
            return R.ok();
        }

        code = RandomUtil.getFourBitRandom();
        boolean isSend = msmService.send(email,code);

        if(isSend){
            redisTemplate.opsForValue().set(email,code,1, TimeUnit.MINUTES);
            return R.ok();
        }else {

            return R.error().message("邮件发送失败请检查邮件地址是否正确!");
        }
    }
}
