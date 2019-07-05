package com.emake.mps.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.emake.portal.common.controller.AbstractController;
import com.emake.mps.model.entity.Permission;
import com.emake.mps.service.PermissionService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/mps/permission")
public class PermissionContoller extends AbstractController<PermissionService,Permission> {

    @Override
    protected String getTemplatePath() {
        return "ftl/mps/permission/";
    }

    @Override
    protected QueryWrapper<Permission> getSearchQW(String search, Model model) {
        QueryWrapper<Permission> qw = new QueryWrapper<Permission>();
        if(StringUtils.isNotBlank(search)){
            qw.like("permission",search);
            model.addAttribute("search",search);
        }
        return qw;
    }

}
