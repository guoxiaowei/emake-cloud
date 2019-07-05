package com.emake.mps.service.impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.emake.common.constants.CommonConstant;
import com.emake.common.validate.Assert;
import com.emake.mps.mapper.SysLogMapper;
import com.emake.mps.model.entity.SysLog;
import com.emake.mps.service.SysLogService;
import org.springframework.stereotype.Service;

import java.util.Date;


@Service
public class SysLogServiceImpl extends ServiceImpl<SysLogMapper, SysLog> implements SysLogService {

    @Override
    public Boolean updateByLogId(Long id) {
        Assert.isNull(id, "日志ID为空");

        SysLog sysLog = new SysLog();
        sysLog.setId(id);
        sysLog.setDelFlag(CommonConstant.STATUS_DEL);
        sysLog.setUpdateTime(new Date());
        return updateById(sysLog);
    }
}
