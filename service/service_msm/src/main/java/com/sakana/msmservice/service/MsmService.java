package com.sakana.msmservice.service;

/**
 * @author YU Chenxi
 * @since 2023/10/27 15:10
 */
public interface MsmService {
    boolean send(String email, String code);
}
