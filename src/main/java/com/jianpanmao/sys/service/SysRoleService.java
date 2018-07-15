package com.jianpanmao.sys.service;

import com.jianpanmao.common.service.BaseService;
import com.jianpanmao.sys.entity.*;
import com.jianpanmao.sys.dto.*;

import java.util.List;


public interface SysRoleService extends BaseService<SysRole, SysRoleExample,SysRoleDto,Integer>{
    public int unbindUser(Integer userId);

    int deleteByGroupId(Integer gid);

    List<SysRole> findByIsCon(Integer isCon);
}