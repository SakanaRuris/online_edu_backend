package com.sakana.educenter.controller;


import com.sakana.commonutils.JwtUtils;
import com.sakana.commonutils.R;
import com.sakana.commonutils.vo.UcenterMemberVo;
import com.sakana.educenter.entity.UcenterMember;
import com.sakana.educenter.entity.vo.RegisterVo;
import com.sakana.educenter.service.UcenterMemberService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

/**
 * <p>
 * 会员表 前端控制器
 * </p>
 *
 * @author YU Chenxi
 * @since 2023-10-27
 */
@RestController
@RequestMapping("/educenter/member")
public class UcenterMemberController {

    @Autowired
    private UcenterMemberService memberService;

    /**
     * 用户登录
     * @param member
     * @return
     */
    @PostMapping("/login")
    public R loginUser(@RequestBody UcenterMember member){
        String token= memberService.login(member);
        return R.ok().data("token",token);
    }

    /**
     * 用户注册
     * @param registerVo
     * @return
     */
    @PostMapping("/register")
    public R registerUser(@RequestBody RegisterVo registerVo){
        memberService.register(registerVo);
        return R.ok();
    }

    /**
     * 获取登录用户的信息，用于显示
     * @param request
     * @return
     */
    @GetMapping("/getMemberInfo")
    public R getMemberInfo(HttpServletRequest request){
        String memberId = JwtUtils.getMemberIdByJwtToken(request);
        UcenterMember member = memberService.getById(memberId);
        return R.ok().data("userInfo",member);
    }

    /**
     * 根据id获取用户信息
     * @param id
     * @return
     */
    @PostMapping("getInfoUc/{id}")
    public UcenterMemberVo getInfo(@PathVariable String id) {
        //根据用户id获取用户信息
        UcenterMember ucenterMember = memberService.getById(id);
        UcenterMemberVo ucenterMemberVo = new UcenterMemberVo();
        BeanUtils.copyProperties(ucenterMember,ucenterMemberVo);
        return ucenterMemberVo;
    }


}

