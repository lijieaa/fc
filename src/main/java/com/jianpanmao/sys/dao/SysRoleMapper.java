package com.jianpanmao.sys.dao;

import com.jianpanmao.common.dao.BaseDao;
import com.jianpanmao.sys.dto.SysRoleDto;
import com.jianpanmao.sys.entity.SysRole;
import com.jianpanmao.sys.entity.SysRoleExample;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface SysRoleMapper extends BaseDao<SysRole, SysRoleExample, SysRoleDto, Integer> {

    int insertRM(Integer roleId,Integer menuId);


    List<SysRole> findByGroupId(Integer gid);


    List<SysRole> findByIsCon(Integer isCon);


    List<SysRole> findByUserId(Integer uid,Integer intermediaryId);


    List<SysRole> findByConId(Integer conId);



    int deleteByGroupId(Integer gid);
}