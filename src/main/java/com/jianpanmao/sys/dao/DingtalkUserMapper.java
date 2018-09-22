package com.jianpanmao.sys.dao;

import com.jianpanmao.common.dao.BaseDao;
import com.jianpanmao.sys.dto.ContactsDto;
import com.jianpanmao.sys.dto.DeptUserDto;
import com.jianpanmao.sys.dto.DingtalkUserDto;
import com.jianpanmao.sys.entity.DingtalkUser;
import com.jianpanmao.sys.entity.DingtalkUserExample;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface DingtalkUserMapper extends BaseDao<DingtalkUser, DingtalkUserExample, DingtalkUserDto, Integer> {

    DingtalkUser findByMobile(@Param("mobile") String mobile,@Param("id") Integer id);

    List<DingtalkUser> idNameList(Integer intermediaryId);

    List<DingtalkUser> selectByDeptId(Integer deptId);

    List<DingtalkUser> selectByLikeName(DingtalkUser user);

    List<DingtalkUser> selectByRoleId(Integer roleId);


    Integer editPwd(Integer id, String pwd);

    Integer updateInfo(DingtalkUser entity);

    List<DeptUserDto> selectDeptUser(@Param("iId") Integer iId, @Param("path") String path);

    List<ContactsDto> intermediaryContactUser(Integer iId);
}