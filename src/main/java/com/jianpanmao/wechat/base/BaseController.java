package com.jianpanmao.wechat.base;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.jianpanmao.sys.entity.DingtalkUser;
import com.jianpanmao.unit.ResponseEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.List;

/**
 * @author zdc
 * @since 2018-03-31 23:52
 */

public abstract class BaseController<T extends BaseEntity> {

    public abstract BaseService<T> getService();
    protected abstract ResponseEntity hookExist(T t);

    protected DingtalkUser getSelf(HttpSession session) {
        return (DingtalkUser) session.getAttribute("user");
    }

//    protected Menu getMenuById(Integer menuId) {
//        return menuService.selectByPrimaryKey(menuId);
//    }

    @GetMapping("{id}")
    @ResponseBody
    public T selectByPrimaryKey(@PathVariable("id") Integer id, HttpSession session) {
        return getService().selectByPrimaryKey(id);
    }

    @DeleteMapping("{id}")
    @ResponseBody
    public ResponseEntity delete(@PathVariable("id") Integer id, HttpSession session) {
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
    public ResponseEntity update(@Valid @RequestBody T t, BindingResult result, HttpSession session) {
        ResponseEntity responseEntity = new ResponseEntity();
        if (result.hasErrors()) {
            responseEntity.setStatus("500");
            responseEntity.setMessages("验证失败");
            responseEntity.setData(result.getAllErrors());
            return responseEntity;
        }
        if (hookExist(t)!=null&&hookExist(t).getStatus().equals("500")){
            return hookExist(t);
        }
        try {
            getService().updateByPrimaryKey(t);
            return responseEntity;
        } catch (Exception e) {
            e.printStackTrace();
            responseEntity.setStatus("500");
            responseEntity.setMessages(e.getMessage());
            return responseEntity;
        }
    }

    @PostMapping
    @ResponseBody
    public ResponseEntity add(@Valid @RequestBody T t, BindingResult result, HttpSession session) {
        ResponseEntity responseEntity = new ResponseEntity();
        if (result.hasErrors()) {
            responseEntity.setStatus("500");
            responseEntity.setMessages("验证失败");
            responseEntity.setData(result.getAllErrors());
            return responseEntity;
        }
        if (hookExist(t)!=null&&hookExist(t).getStatus().equals("500")){
            return hookExist(t);
        }
        try {
            getService().insert(t);
            return responseEntity;
        } catch (Exception e) {
            e.printStackTrace();
            responseEntity.setStatus("500");
            responseEntity.setMessages(e.getMessage());
            return responseEntity;
        }
    }

    @GetMapping("page")
    @ResponseBody
    public ResponseEntity pageList(@RequestParam("page") Integer page,
                                   @RequestParam("rows") Integer rows,
                                   T t,
                                   HttpSession session) {
        ResponseEntity responseEntity = new ResponseEntity();
        try {
            PageHelper.startPage(page, rows);
            t.setIntermediary(getSelf(session).getIntermediary());
            List<T> list = getService().selectAll(t);
            PageInfo pageInfo = new PageInfo(list);
            responseEntity.setData(pageInfo);
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
    public ResponseEntity all(@RequestBody(required = false) T t, HttpSession session) {
        ResponseEntity responseEntity = new ResponseEntity();
        if (t != null) t.setIntermediary(getSelf(session).getIntermediary());
        responseEntity.setList(getService().selectAll(t));
        return responseEntity;
    }



}