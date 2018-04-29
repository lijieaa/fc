package com.we.fc.dept.controller;

import com.we.fc.base.BaseController;
import com.we.fc.base.BaseService;
import com.we.fc.dept.entity.DingtalkDept;
import com.we.fc.dept.service.DingtalkDeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

/**
 * 模拟钉钉部门
 */
@Controller
@RequestMapping("dingtalk_dept")
public class DingtalkDeptController extends BaseController<DingtalkDept>{



    private DingtalkDeptService dingtalkDeptService;

    @Autowired
    public DingtalkDeptController(DingtalkDeptService dingtalkDeptService) {
        this.dingtalkDeptService=dingtalkDeptService;
    }

    @Override
    public BaseService<DingtalkDept> getService() {
        return dingtalkDeptService;
    }
}
