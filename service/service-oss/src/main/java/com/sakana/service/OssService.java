package com.sakana.service;

import org.springframework.web.multipart.MultipartFile;

/**
 * @author YU Chenxi
 * @since 2023/10/18 16:37
 * 上传头像到阿里云
 */
public interface OssService {
    String uploadFileAvatar(MultipartFile file);
}
