package com.we.fc.base;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.we.fc.menu.entity.Menu;
import com.we.fc.menu.service.MenuService;
import com.we.fc.unit.ResponseEntity;
import com.we.fc.user.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.Arrays;
import java.util.List;

/**
 * @author zdc
 * @since 2018-03-31 23:52
 */

public abstract class BaseController<T> {

    public abstract BaseService<T> getService();

    @Autowired
    private MenuService menuService;

    protected User getSelf(HttpSession session){
        return (User)session.getAttribute("user");
    }

    protected Menu getMenuById(Integer menuId){
        return menuService.selectByPrimaryKey(menuId);
    }

    @GetMapping("selectByPrimaryKey")
    @ResponseBody
    public T selectByPrimaryKey(Integer id){
        return getService().selectByPrimaryKey(id);
    }

    @DeleteMapping
    @ResponseBody
    public ResponseEntity delete(Integer id){
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
    public ResponseEntity update(@RequestBody T t){
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
    public ResponseEntity add(@RequestBody T t){
        ResponseEntity responseEntity = new ResponseEntity();
        try {
            getService().insert(t);
            return responseEntity;
        } catch (Exception e) {
            e.printStackTrace();
            responseEntity.setStatus("500");
            responseEntity.setMessages("添加失败");
            return responseEntity;
        }
    }

    @GetMapping
    @ResponseBody
    public ResponseEntity pageList(Integer page, Integer rows){
        ResponseEntity responseEntity = new ResponseEntity();
        try {
            PageHelper.startPage(page,rows);
            List<T> list = getService().selectAll();
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

}
