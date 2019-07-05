package com.emake.mps.model.dto;

import com.emake.mps.model.entity.Member;
import lombok.Data;

import java.io.Serializable;


@Data
public class MemberInfo implements Serializable {
    /**
     * 用户基本信息
     */
    private Member member;
    /**
     * 权限标识集合
     */
    private String[] permissions;

    /**
     * 角色集合
     */
    private String[] roles;
}
