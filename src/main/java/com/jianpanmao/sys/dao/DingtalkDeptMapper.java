package com.jianpanmao.sys.dao;

import com.jianpanmao.common.dao.BaseDao;
import com.jianpanmao.sys.dto.DeptUserDto;
import com.jianpanmao.sys.dto.DingtalkDeptDto;
import com.jianpanmao.sys.entity.DingtalkDept;
import com.jianpanmao.sys.entity.DingtalkDeptExample;
import com.jianpanmao.sys.entity.DingtalkUserDept;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface DingtalkDeptMapper extends BaseDao<DingtalkDept, DingtalkDeptExample, DingtalkDeptDto, Integer> {


    List<DingtalkDept> selectByPath(DingtalkDept dept);

    List<DingtalkDept> selectByParentId(DingtalkDept dept);

    List<DingtalkDept> selectByLikeName(DingtalkDept deptName);

    List<DingtalkDept> findByUserId(Integer uid,Integer intermediaryId);

    void updatePath(DingtalkDept dept);

    void sort(DingtalkDept dept);

    DingtalkDept selectByEqName(DingtalkDept dept);

    List<DeptUserDto> findByPI(@Param("path") String path, @Param("iId") Integer intermediaryId);


}