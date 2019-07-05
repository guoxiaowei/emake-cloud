package com.emake.auth.service;

import com.emake.auth.model.vo.MemberVO;
import com.emake.auth.fegin.MemberService;
import com.emake.auth.util.UserDetailsImpl;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;


@Service("userDetailService")
public class UserDetailServiceImpl implements UserDetailsService {

    @Resource
    private MemberService memberService;

    @Override
    public UserDetailsImpl loadUserByUsername(String username) throws UsernameNotFoundException {
        MemberVO memberVo = memberService.findMemberByMembername(username);
        if (memberVo != null) {
            return new UserDetailsImpl(memberVo);
        }
        throw new UsernameNotFoundException("error username");
    }
}
