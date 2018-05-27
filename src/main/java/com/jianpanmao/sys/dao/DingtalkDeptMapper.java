package com.jianpanmao.sys.dao;

import com.jianpanmao.common.dao.BaseDao;
import com.jianpanmao.sys.dto.DingtalkDeptDto;
import com.jianpanmao.sys.entity.DingtalkDept;
import com.jianpanmao.sys.entity.DingtalkDeptExample;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface DingtalkDeptMapper extends BaseDao<DingtalkDept, DingtalkDeptExample, DingtalkDeptDto, Integer> {


    List<DingtalkDept> selectByPath(DingtalkDept dept);

    List<DingtalkDept> selectByParentId(DingtalkDept dept);

    List<DingtalkDept> selectByLikeName(DingtalkDept deptName);

    void updatePath(DingtalkDept dept);

    void sort(DingtalkDept dept);


}