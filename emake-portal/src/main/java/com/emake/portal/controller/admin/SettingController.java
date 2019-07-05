package com.emake.portal.controller.admin;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.emake.common.utils.R;
import com.emake.portal.common.controller.AbstractController;
import com.emake.portal.model.entity.SysRole;
import com.emake.portal.model.entity.SysRoleMenu;
import com.emake.portal.model.entity.SysSetting;
import com.emake.portal.model.entity.SysSettingMenu;
import com.emake.portal.model.vo.TreeMenuAllowAccess;
import com.emake.portal.service.ISysMenuService;
import com.emake.portal.service.ISysSettingMenuService;
import com.emake.portal.service.ISysSettingService;
import com.google.common.collect.Lists;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * 系统设置控制器
 */
@Controller
@RequestMapping("/admin/setting")
public class SettingController extends AbstractController<ISysSettingService,SysSetting> {

    /**
     * 菜单服务
     */
    @Autowired
    private ISysMenuService sysMenuService;
    /**
     * 系统权限服务
     */
    @Autowired
    private ISysSettingMenuService sysSettingMenuService;

    @Override
    protected String getTemplatePath() {
        return "ftl/admin/setting/";
    }

    @Override
    protected QueryWrapper<SysSetting> getSearchQW(String search, Model model) {
        QueryWrapper<SysSetting> qw = new QueryWrapper<SysSetting>();
        if (StringUtils.isNotBlank(search)) {
            qw.like("sys_name", search);
            model.addAttribute("search", search);
        }
        return qw;
    }

    /**
     * 权限
     */
    @RequestMapping("/auth/{id}")
    public  String auth(@PathVariable String id, Model model){

        SysSetting sysSetting = baseService.getById(id);

        if(sysSetting == null){
            throw new RuntimeException("该系统不存在");
        }

        List<SysSettingMenu> sysSettingMenus = sysSettingMenuService.list(new QueryWrapper<SysSettingMenu>().eq("sys_id", id));
        List<String> menuIds = Lists.transform(sysSettingMenus, input -> input.getMenuId().toString());

        List<TreeMenuAllowAccess> treeMenuAllowAccesses = sysMenuService.selectTreeMenuAllowAccessByMenuIdsAndPid(menuIds, "0");

        model.addAttribute("sysSetting", sysSetting);
        model.addAttribute("treeMenuAllowAccesses", treeMenuAllowAccesses);

        return "ftl/admin/setting/auth";
    }

    /**
     * 权限
     */
    @RequestMapping("/doAuth")
    @ResponseBody
    public R<Boolean> doAuth(String sysId, @RequestParam(value="mid[]",required=false) String[] mid){
        sysSettingMenuService.addAuth(sysId,mid);
        R<Boolean> r = R.rest(true);
        r.setMsg("OK,授权成功,1分钟后生效  ~");
        return r;
    }
}