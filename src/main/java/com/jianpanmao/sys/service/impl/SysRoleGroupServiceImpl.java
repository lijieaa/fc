package com.jianpanmao.sys.service.impl;

import com.jianpanmao.common.service.impl.BaseServiceImpl;
import com.jianpanmao.sys.entity.*;
import com.jianpanmao.sys.dto.*;
import com.jianpanmao.sys.service.SysRoleGroupService;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
public class SysRoleGroupServiceImpl extends BaseServiceImpl<SysRoleGroup,SysRoleGroupExample,SysRoleGroupDto,Integer> implements SysRoleGroupService {

    @Override
    public int add(SysRoleGroup record) {
        DingtalkUser addUser = (DingtalkUser) SecurityContextHolder.getContext().getAuthentication() .getPrincipal();
        record.setIntermediaryId(addUser.getIntermediaryId());
        return super.add(record);
    }

    @Override
    public int update(SysRoleGroup record) {
        DingtalkUser uuser = (DingtalkUser) SecurityContextHolder.getContext().getAuthentication() .getPrincipal();
        record.setIntermediaryId(uuser.getIntermediaryId());
        return super.update(record);
    }
}