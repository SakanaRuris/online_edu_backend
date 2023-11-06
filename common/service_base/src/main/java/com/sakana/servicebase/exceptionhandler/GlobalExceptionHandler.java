package com.sakana.servicebase.exceptionhandler;

import com.sakana.commonutils.ExceptionUtil;
import com.sakana.commonutils.R;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 异常处理类
 * @author YU Chenxi
 * @since 2023/10/11 1:49
 */
@Slf4j
@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    @ResponseBody
    public R error(Exception e){
        log.error(e.getMessage());
        e.printStackTrace();
        return R.error().message("guli执行了全局异常处理！").data("异常", e.getMessage());
    }

    @ExceptionHandler(GuliException.class)
    @ResponseBody
    public R error(GuliException e){
        log.error(ExceptionUtil.getMessage(e));
        e.printStackTrace();
        return R.error().code(e.getCode()).message(e.getMsg());
    }
}
