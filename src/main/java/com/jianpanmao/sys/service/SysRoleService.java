package com.jianpanmao.sys.service;

import com.jianpanmao.common.service.BaseService;
import com.jianpanmao.sys.entity.*;
import com.jianpanmao.sys.dto.*;




public interface SysRoleService extends BaseService<SysRole, SysRoleExample,SysRoleDto,Integer>{
    public int unbindUser(Integer userId);
}