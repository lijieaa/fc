package com.jianpanmao.sys.service.impl;

import com.jianpanmao.common.service.impl.BaseServiceImpl;
import com.jianpanmao.sys.dao.SysMenuMapper;
import com.jianpanmao.sys.entity.*;
import com.jianpanmao.sys.dto.*;
import com.jianpanmao.sys.service.SysMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Service
public class SysMenuServiceImpl extends BaseServiceImpl<SysMenu,SysMenuExample,SysMenuDto,Integer> implements SysMenuService {

    @Autowired
    SysMenuMapper sysMenuMapper;

    @Override
    public int remove(Integer id) {

        return super.removeBatch(null);
    }

    @Override
    public int add(SysMenu record) {
        if(null==record.getMenuParentId()||record.getMenuParentId()==0){
            record.setPath(0+"");
        }else {
            SysMenu pmenu = this.get(record.getMenuParentId());
            record.setPath(pmenu.getPath()+","+pmenu.getMenuId());
        }
        //this.update(record);
        //int i = super.add(record);
        return super.add(record);
    }

    @Transactional
    @Override
    public int update(SysMenu record) {

        SysMenu menu=this.get(record.getMenuId());

        if(null==record.getMenuParentId()||record.getMenuParentId()==0){
            menu.setPath(0+"");
        }else {
            SysMenu pmenu = this.get(record.getMenuParentId());
            menu.setPath(pmenu.getPath()+","+pmenu.getMenuId());
        }
        int update = super.update(menu);

        SysMenu m=new SysMenu();
        m.setPath(menu.getMenuId()+"");
        List<SysMenu> sysMenus = sysMenuMapper.selectByPath(m);

        for (SysMenu sysMenu : sysMenus) {
            sysMenu.setPath(sysMenu.getPath().replace(menu.getPath(),record.getPath()));
            sysMenuMapper.updatePath(sysMenu);
        }
        return update;
    }
}