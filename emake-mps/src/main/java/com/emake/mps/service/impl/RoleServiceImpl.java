package com.emake.mps.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import com.emake.mps.mapper.RoleMapper;
import com.emake.mps.model.entity.Role;
import com.emake.mps.service.RoleService;
import org.springframework.stereotype.Service;



@Service
public class RoleServiceImpl extends ServiceImpl<RoleMapper, Role> implements RoleService {


}
