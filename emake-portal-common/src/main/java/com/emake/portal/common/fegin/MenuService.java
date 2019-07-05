package com.emake.portal.common.fegin;

import com.emake.portal.common.fegin.fallback.MenuServiceFallbackImpl;
import com.emake.portal.common.vo.SysMenuVO;
import com.emake.portal.common.vo.TreeMenu;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Set;

@FeignClient(name = "emake-portal-data",  fallback = MenuServiceFallbackImpl.class)
public interface MenuService {

    @GetMapping("/menu/findTreeMenusByUserId/{id}")
    List<TreeMenu> findTreeMenusByUserId(@PathVariable("id") String userId);

    @GetMapping("/menu/findMenusByRole/{role}")
    Set<SysMenuVO> findMenusByRole(@PathVariable("role") String roleCode);
}
