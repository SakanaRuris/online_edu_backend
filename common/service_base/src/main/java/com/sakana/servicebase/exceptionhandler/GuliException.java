package com.sakana.servicebase.exceptionhandler;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 自定义异常类
 * @author YU Chenxi
 * @since 2023/10/11 21:03
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class GuliException extends RuntimeException{
    private Integer code;

    private String msg;
}
