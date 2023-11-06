package com.sakana.educenter.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.sakana.commonutils.JwtUtils;
import com.sakana.commonutils.MD5;
import com.sakana.educenter.entity.UcenterMember;
import com.sakana.educenter.entity.vo.RegisterVo;
import com.sakana.educenter.mapper.UcenterMemberMapper;
import com.sakana.educenter.service.UcenterMemberService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sakana.servicebase.exceptionhandler.GuliException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

/**
 * <p>
 * 会员表 服务实现类
 * </p>
 *
 * @author YU Chenxi
 * @since 2023-10-27
 */
@Service
public class UcenterMemberServiceImpl extends ServiceImpl<UcenterMemberMapper, UcenterMember> implements UcenterMemberService {
    @Autowired
    private RedisTemplate<String,String> redisTemplate;
    /**
     * 用户登录
     * @param member
     * @return
     */
    @Override
    public String login(UcenterMember member) {
        String email = member.getEmail();
        String password = member.getPassword();

        if(StringUtils.isEmpty(email) || StringUtils.isEmpty(password)){
            throw new GuliException(20001,"登录失败，用户名或密码为空!");
        }
        QueryWrapper<UcenterMember> wrapper = new QueryWrapper<>();
        wrapper.eq("email",email);
        UcenterMember mobileMember = baseMapper.selectOne(wrapper);
        if(mobileMember == null){
            throw new GuliException(20001,"登录失败，该邮箱未注册!");
        }

        //数据库密码为加密密码,MD5加密
        if(!MD5.encrypt(password).equals(mobileMember.getPassword())){
            throw new GuliException(20001,"登录失败，密码错误!");
        }

        if(mobileMember.getIsDisabled()){
            throw new GuliException(20001,"登录失败，该用户已被禁用!");
        }

        String jwtToken = JwtUtils.getJwtToken(mobileMember.getId(), mobileMember.getNickname());

        return jwtToken;
    }

    /**
     * 注册服务类
     * @param registerVo
     */
    @Override
    public void register(RegisterVo registerVo) {
        String code = registerVo.getCode();
        String email = registerVo.getEmail();
        String nickname = registerVo.getNickname();
        String password = registerVo.getPassword();

        if(StringUtils.isEmpty(email) || StringUtils.isEmpty(password) || StringUtils.isEmpty(code) || StringUtils.isEmpty(nickname)){
            throw new GuliException(20001,"注册失败，用户名或密码或邮箱或验证码为空!");
        }

        String redisCode = redisTemplate.opsForValue().get(email);
        if(!code.equals(redisCode)) {
            throw new GuliException(20001,"验证码错误或已经失效，注册失败!");
        }

        QueryWrapper<UcenterMember> wrapper = new QueryWrapper<>();
        wrapper.eq("email",email);
        Integer count = baseMapper.selectCount(wrapper);

        if(count > 0){
            throw new GuliException(20001,"该用户已经注册过!");
        }

        UcenterMember member = new UcenterMember();
        member.setEmail(email);
        member.setNickname(nickname);
        member.setPassword(MD5.encrypt(password));
        member.setIsDisabled(false);
        member.setAvatar("https://images.pexels.com/photos/264905/pexels-photo-264905.jpeg?cs=srgb&dl=pexels-pixabay-264905.jpg&fm=jpg&_gl=1*1x9mpqf*_ga*MjExNjI5NDM0OS4xNjk4NDE0ODkx*_ga_8JE65Q40S6*MTY5ODQxNDg5MS4xLjEuMTY5ODQxNDk1MC4wLjAuMA..");
        baseMapper.insert(member);
    }
}
