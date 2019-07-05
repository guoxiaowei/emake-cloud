package com.emake.mps.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.emake.mps.model.entity.SysZuulRoute;


public interface SysZuulRouteService extends IService<SysZuulRoute> {

    /**
     * 立即生效配置
     * @return
     */
    Boolean applyZuulRoute();
}
