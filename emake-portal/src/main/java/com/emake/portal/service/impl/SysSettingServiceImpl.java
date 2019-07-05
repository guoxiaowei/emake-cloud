package com.emake.portal.service.impl;

import java.util.List;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.emake.portal.model.entity.SysSetting;
import com.emake.portal.mapper.SysSettingMapper;
import com.emake.portal.service.ISysSettingService;
import org.springframework.stereotype.Service;

/**
 *
 * SysSetting 表数据服务层接口实现类
 *
 */
@Service
public class SysSettingServiceImpl extends ServiceImpl<SysSettingMapper, SysSetting> implements ISysSettingService {
	
	@Override
	public SysSetting findSysByGlobalKey(String sysGlobalKey) {
		QueryWrapper qw = new QueryWrapper<SysSetting>();
		qw.eq("sys_global_key",sysGlobalKey);
		qw.orderByAsc("sort");
		return this.getOne(qw);
	}


}