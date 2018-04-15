package com.we.fc.base;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException;
import com.we.fc.company.entity.Company;
import com.we.fc.menu.entity.Menu;
import com.we.fc.menu.service.MenuService;
import com.we.fc.unit.ResponseEntity;
import com.we.fc.user.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.Arrays;
import java.util.List;

/**
 * @author zdc
 * @since 2018-03-31 23:52
 */

public abstract class BaseController<T extends BaseEntity> {

    public abstract BaseService<T> getService();

    @Autowired
    private MenuService menuService;

    protected User getSelf(HttpSession session){
        return (User)session.getAttribute("user");
    }

    protected Menu getMenuById(Integer menuId){
        return menuService.selectByPrimaryKey(menuId);
    }

    @GetMapping("{id}")
    @ResponseBody
    public T selectByPrimaryKey(@PathVariable("id") Integer id,HttpSession session){
        return getService().selectByPrimaryKey(id);
    }

    @DeleteMapping("{id}")
    @ResponseBody
    public ResponseEntity delete(@PathVariable("id") Integer id,HttpSession session){
        ResponseEntity responseEntity = new ResponseEntity();
        try {
            getService().deleteByPrimaryKey(id);
            return responseEntity;
        } catch (Exception e) {
            e.printStackTrace();
            responseEntity.setStatus("500");
            responseEntity.setMessages("删除失败");
            return responseEntity;
        }
    }

    @PutMapping
    @ResponseBody
    public ResponseEntity update(@RequestBody T t,HttpSession session){
        ResponseEntity responseEntity = new ResponseEntity();
        try {
            getService().updateByPrimaryKey(t);
            return responseEntity;
        } catch (Exception e) {
            e.printStackTrace();
            responseEntity.setStatus("500");
            responseEntity.setMessages("更新失败");
            return responseEntity;
        }
    }

    @PostMapping
    @ResponseBody
    public ResponseEntity add(@RequestBody T t,HttpSession session){
        ResponseEntity responseEntity = new ResponseEntity();
        try {
            getService().insert(t);
            return responseEntity;
        } catch (DuplicateKeyException e) {
            e.printStackTrace();
            responseEntity.setStatus("500");
            responseEntity.setMessages("已存在的实体");
            return responseEntity;
        } catch (Exception e){
            e.printStackTrace();
            responseEntity.setStatus("500");
            responseEntity.setMessages(e.getMessage());
            return responseEntity;
        }
    }

    @GetMapping("page")
    @ResponseBody
    public ResponseEntity pageList(@RequestParam("page") Integer page,
                                   @RequestParam("rows")Integer rows,
                                   T t,
                                   HttpSession session){
        ResponseEntity responseEntity = new ResponseEntity();
        try {
            PageHelper.startPage(page,rows);
            t.setCompany(getSelf(session).getCompany());
            List<T> list = getService().selectAll(t);
            PageInfo pageInfo = new PageInfo(list);
            responseEntity.setData(Arrays.asList(pageInfo));
            return responseEntity;
        } catch (Exception e) {
            e.printStackTrace();
            responseEntity.setStatus("500");
            responseEntity.setMessages("获取失败");
            return responseEntity;
        }
    }

    @GetMapping("all")
    @ResponseBody
    public ResponseEntity all(@RequestBody(required = false) T t, HttpSession session){
        ResponseEntity responseEntity = new ResponseEntity();
        if(t != null) t.setCompany(getSelf(session).getCompany());
        responseEntity.setData(getService().selectAll(t));
        return responseEntity;
    }

}
