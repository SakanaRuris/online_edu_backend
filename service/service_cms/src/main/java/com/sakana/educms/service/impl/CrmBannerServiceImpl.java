package com.sakana.educms.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.sakana.educms.entity.CrmBanner;
import com.sakana.educms.mapper.CrmBannerMapper;
import com.sakana.educms.service.CrmBannerService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 首页banner表 服务实现类
 * </p>
 *
 * @author YU Chenxi
 * @since 2023-10-26
 */
@Service
public class CrmBannerServiceImpl extends ServiceImpl<CrmBannerMapper, CrmBanner> implements CrmBannerService {

    /**
     * 分页查询banner
     * @param page
     * @param limit
     * @return
     */
    @Override
    public Map<String, Object> pageListBanner(long page, long limit) {
        Page<CrmBanner> pageBanner = new Page<>(page,limit);
        this.page(pageBanner,null);
        List<CrmBanner> records = pageBanner.getRecords();
        long total = pageBanner.getTotal();
        Map<String,Object> map = new HashMap<>();
        map.put("total",total);
        map.put("items",records);
        return map;
    }

    /**
     * 查询所有banner
     * @return
     */
    @Cacheable(value = "banner", key = "'selectIndexList'")
    @Override
    public List<CrmBanner> selectAllBanner() {
        QueryWrapper<CrmBanner> wrapper = new QueryWrapper<>();
        wrapper.orderByDesc("id").last("limit 2");
        List<CrmBanner> list = baseMapper.selectList(wrapper);
        return list;
    }


}
