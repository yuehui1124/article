package com.wofeng.articlemanagement.service.impl;

import com.wofeng.articlemanagement.baseDao.BusinessMessage;
import com.wofeng.articlemanagement.entity.SysMenu;
import com.wofeng.articlemanagement.mapper.SysMenuMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import tk.mybatis.mapper.entity.Example;
import tk.mybatis.mapper.util.StringUtil;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

/**
 * @author yueyueyue
 * @date 2019/4/19 11:49
 * Description: article-management
 */
@Slf4j
@Service
public class SystemService {
    @Autowired
    private SysMenuMapper menuMapper;

    public BusinessMessage<String> getMenus(String menuIds) {
        BusinessMessage businessMessage = new BusinessMessage();
        try {

            if (!StringUtil.isEmpty(menuIds)) {
                String[] ids = menuIds.split(",");
                List<Integer> listIds = new ArrayList<>();
                for (String id : ids) {
                    listIds.add(Integer.parseInt(id));
                }
                Example menuExample = new Example(SysMenu.class);
                menuExample.createCriteria().andIn("id", listIds);
                //根据这个东西排序
                menuExample.setOrderByClause("sorter");
                List<SysMenu> menuList = this.menuMapper.selectByExample(menuExample);
                //查询所有一级菜单

                List<SysMenu> FirstMenus = menuList.stream()
                        .filter(menu -> 0 == menu.getParentId())
                        .collect(Collectors.toList());
                //获取所有二级菜单 拼接
                Map<Object,Object> map = new TreeMap<>();
                StringBuffer menusb = new StringBuffer();
                HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
                String contextPath = request.getContextPath();
                for (SysMenu menu : FirstMenus) {
                    if (menu.getLevel() == 0) {
                        menusb.append("<li class=\"active\"><a href="+contextPath +menu.getUrl()+"><i class=\"fa fa-home\"></i><span class=\"link-title menu_hide\">&nbsp;"+menu.getName()+"</span></a></li>");
                    }

                    List<SysMenu> twoMenus = menuList.stream()
                            .filter(twoMenu -> menu.getId() == twoMenu.getParentId())
                            .collect(Collectors.toList());
                    if (menu.getLevel() == 1){
                        menusb.append(
                                "<li class=\"dropdown_menu\"><a href=\"javascript:;\"><i class=\"fa fa-anchor\"></i><span class=\"link-title menu_hide\">&nbsp; "+menu.getName()+"</span><span class=\"fa arrow menu_hide\"></span></a>"
                        );
                        if (twoMenus.size() > 0) {
                            for (SysMenu twoMenu : twoMenus) {
                                menusb.append(
                                        "<ul><li><a href=\""+contextPath+twoMenu.getUrl()+"\"><i class=\"fa fa-angle-right\"></i>&nbsp; "+twoMenu.getName()+"</a></li></ul>"
                                );
                            }
                            menusb.append("</li>");
                        }else {
                            menusb.append(
                                    "</li>"
                            );
                        }


                    }
                }
                businessMessage.setSuccess(true);
                businessMessage.setData(menusb.toString());

            }else {
                log.error("该用户没有菜单,{}");
                businessMessage.setSuccess(false);
            }
        } catch (Exception e) {
            e.printStackTrace();
            log.error("查询菜单错误,{}",e);
            businessMessage.setSuccess(false);
            businessMessage.setMsg("该用户没菜单");
        }
        return businessMessage;
    }

    public BusinessMessage<Object> getTwoMenus(String firstMenuId) {
        BusinessMessage businessMessage = new BusinessMessage();
        try {
            Example menuExample = new Example(SysMenu.class);
            menuExample.setOrderByClause("sorter");
            List<SysMenu> menus = this.menuMapper.selectByExample(menuExample);
            businessMessage.setSuccess(true);
            businessMessage.setData(menus);

        } catch (Exception e) {
            log.error("查询二级菜单失败,{}",e);
            businessMessage.setSuccess(false);
        }
        return businessMessage;
    }
}
