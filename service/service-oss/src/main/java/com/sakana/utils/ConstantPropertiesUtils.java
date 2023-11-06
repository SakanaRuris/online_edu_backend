package com.sakana.utils;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @author YU Chenxi
 * @since 2023/10/18 16:27
 * 阿里云配置
 */
@Component
public class ConstantPropertiesUtils implements InitializingBean {

    @Value("${aliyun.oss.file.endpoint}") // your endpoint
    private String endpoint;

    @Value("${aliyun.oss.file.keyid}") //endpoint keyid
    private String keyId;

    @Value("${aliyun.oss.file.keysecret}") // your keysecret
    private String keySecret;

    @Value("${aliyun.oss.file.bucketname}") // your buckname
    private String bucketName;

    public static String END_POINT;
    public static String ACCESS_KEY_ID;
    public static String ACCESS_KEY_SECRET;
    public static String BUCKET_NAME;

    @Override
    public void afterPropertiesSet() throws Exception {
        END_POINT = endpoint;
        ACCESS_KEY_ID=keyId;
        ACCESS_KEY_SECRET=keySecret;
        BUCKET_NAME =bucketName;
    }
}
