package com.we.fc.company.web;

import com.we.fc.base.BaseController;
import com.we.fc.base.BaseService;
import com.we.fc.company.entity.Company;
import com.we.fc.company.service.CompanyService;
import com.we.fc.dept.DeptUtils;
import com.we.fc.dept.entity.Dept;
import com.we.fc.dept.service.DeptService;
import com.we.fc.menu.service.MenuService;
import com.we.fc.user.entity.User;
import com.we.fc.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @author zdc
 * @since 2018-03-31 23:56
 */
@Controller
@RequestMapping("company")
public class CompanyController extends BaseController<Company> {

    @Autowired private CompanyService companyService;

    @Autowired private DeptService deptService;

    @Autowired private UserService userService;

    @Autowired private MenuService menuService;

    @Override
    public BaseService<Company> getService() {
        return companyService;
    }

    /**
     * 组织管理页面
     * @param menuId
     * @param model
     * @param session
     * @return
     */
    @GetMapping("index")
    public String index(Integer menuId, Model model, HttpSession session){
        model.addAttribute("userCount", userService.findCountByCompanyId(getSelf(session).getCompany().getId()));
        model.addAttribute("loopMenu", menuService.findById(menuId));
        return "sys/company/index";
    }

    @GetMapping("getDeptTree")
    @ResponseBody
    public List<Dept> getDeptTree(Integer parentId,HttpSession session){
        List<Dept> depts = deptService.findByCompanyId(getSelf(session).getCompany().getId());
        for(Dept dept : depts){
            dept.setUserCount(userService.findCountByDeptId(dept.getId()));
        }
        return DeptUtils.getDeptLevelByParentId(parentId, depts);
    }

}
