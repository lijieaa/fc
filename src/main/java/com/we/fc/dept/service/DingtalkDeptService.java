package com.we.fc.dept.service;

import com.we.fc.base.BaseService;
import com.we.fc.dept.entity.DingtalkDept;

import java.util.List;

public interface DingtalkDeptService extends BaseService<DingtalkDept>{

    List<DingtalkDept> findByParentId(Integer id);

}