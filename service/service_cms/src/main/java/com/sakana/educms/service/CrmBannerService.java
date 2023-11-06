package com.sakana.educms.service;

import com.sakana.educms.entity.CrmBanner;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 首页banner表 服务类
 * </p>
 *
 * @author YU Chenxi
 * @since 2023-10-26
 */
public interface CrmBannerService extends IService<CrmBanner> {

    Map<String, Object> pageListBanner(long page, long limit);

    List<CrmBanner> selectAllBanner();
}
