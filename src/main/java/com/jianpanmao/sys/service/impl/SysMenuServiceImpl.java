package com.jianpanmao.sys.service.impl;

import com.jianpanmao.common.service.impl.BaseServiceImpl;
import com.jianpanmao.sys.entity.*;
import com.jianpanmao.sys.dto.*;
import com.jianpanmao.sys.service.SysMenuService;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Service
public class SysMenuServiceImpl extends BaseServiceImpl<SysMenu,SysMenuExample,SysMenuDto,Integer> implements SysMenuService {


    @Override
    public int remove(Integer id) {
        SysMenu sysMenu = this.get(id);
        List<Integer> list=new ArrayList<>();
        SysMenu.r(sysMenu,list);
        return super.removeBatch(list.toArray(new Integer[list.size()]));
    }

    @Override
    public int add(SysMenu record) {
        int i = super.add(record);
        if(record.getMenuParentId()==0){
            record.setPath(record.getMenuId()+"");
        }else {
            SysMenu pmenu = this.get(record.getMenuParentId());
            record.setPath(pmenu.getPath()+","+record.getMenuId());
        }
        this.update(record);
        return i;
    }

    @Override
    public int update(SysMenu record) {
        if(record.getMenuParentId()==0){
            SysMenu sysMenu = get(record.getMenuId());
            record.setPath(record.getMenuId()+"");
        }else {
            SysMenu pmenu = this.get(record.getMenuParentId());
            record.setPath(pmenu.getPath()+","+record.getMenuId());
        }
        return super.update(record);
    }
}