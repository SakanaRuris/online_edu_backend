package com.sakana.msmservice.service.impl;

import com.sakana.commonutils.MailUtils;
import com.sakana.commonutils.R;
import com.sakana.msmservice.service.MsmService;
import com.sakana.servicebase.exceptionhandler.GuliException;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

/**
 * @author YU Chenxi
 * @since 2023/10/27 15:11
 */
@Service
public class MsmServiceImpl implements MsmService {


    /**
     * 发送邮件服务类
     * @param email
     * @param code
     * @return
     */
    @Override
    public boolean send(String email, String code) {
        if(StringUtils.isEmpty(email)){
            return false;
        }

        String context = "感谢您注册谷粒学苑，你的验证码为:"+code+"。请在一分钟之内填写!";
        String title = "谷粒学苑注册";
        return MailUtils.sendMail(email, title, context);
    }
}
