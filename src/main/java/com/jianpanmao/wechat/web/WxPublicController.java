package com.jianpanmao.wechat.web;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.jianpanmao.common.entity.DataTablesResponseEntity;
import com.jianpanmao.intermediary.entity.Intermediary;
import com.jianpanmao.unit.ResponseEntity;
import com.jianpanmao.utils.WxUtils;
import com.jianpanmao.wechat.api.WxApiHandler;
import com.jianpanmao.wechat.entity.WxPublic;
import com.jianpanmao.wechat.service.WxPublicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

/**
 * 公从号Controller
 * @author zdc
 * @since 2018-04-13 21:41
 */
@Controller
@RequestMapping("wxPublic")
public class WxPublicController {

    @Autowired private WxPublicService wxPublicService;

    @Autowired private WxApiHandler wxApiHandler;

    @GetMapping("index")
    public String index(Integer menuId, Model model){
        return "wechat/index";
    }

    @GetMapping("add")
    public String add(Integer menuId){
        return "wechat/wxpublic_add";
    }

    @GetMapping("menu")
    public String menu(Integer menuId, Integer wxPublicId,Model model){
        model.addAttribute("wxPublicId", wxPublicId);
        return "wechat/menu";
    }

    @GetMapping("user")
    public String user(Integer menuId, Integer wxPublicId, Model model){
        model.addAttribute("wxPublicId", wxPublicId);
        return "wechat/user";
    }

    @GetMapping("msg")
    public String msg(Integer menuId, Integer wxPublicId, Model model){
        model.addAttribute("wxPublicId", wxPublicId);
        return "wechat/msg";
    }

    @GetMapping("material")
    public String material(Integer menuId, Integer wxPublicId, Model model){
        model.addAttribute("wxPublicId", wxPublicId);
        return "wechat/material";
    }

    @PostMapping
    @ResponseBody
    public ResponseEntity add(@Valid @RequestBody WxPublic wxPublic, BindingResult result, HttpSession session) throws Exception {
        wxApiHandler.getAccessToken(wxPublic.getAppId(), wxPublic.getAppSecret());
        wxPublic.setIntermediary(WxUtils.getCompany(session));
        ResponseEntity responseEntity = new ResponseEntity();
        if (result.hasErrors()) {
            responseEntity.setStatus("500");
            responseEntity.setMessages("验证失败");
            responseEntity.setData(result.getAllErrors());
            return responseEntity;
        }
        try {
            wxPublicService.insert(wxPublic);
            return responseEntity;
        } catch (Exception e) {
            e.printStackTrace();
            responseEntity.setStatus("500");
            responseEntity.setMessages(e.getMessage());
            return responseEntity;
        }
    }

    @PutMapping
    @ResponseBody
    public ResponseEntity update(@RequestBody WxPublic wxPublic, BindingResult result, HttpSession session) throws Exception {
        wxApiHandler.getAccessToken(wxPublic.getAppId(), wxPublic.getAppSecret());
        wxPublic.setIntermediary(WxUtils.getCompany(session));
        ResponseEntity responseEntity = new ResponseEntity();
        if (result.hasErrors()) {
            responseEntity.setStatus("500");
            responseEntity.setMessages("验证失败");
            responseEntity.setData(result.getAllErrors());
            return responseEntity;
        }
        try {
            wxPublicService.updateByPrimaryKey(wxPublic);
            return responseEntity;
        } catch (Exception e) {
            e.printStackTrace();
            responseEntity.setStatus("500");
            responseEntity.setMessages(e.getMessage());
            return responseEntity;
        }
    }

    @DeleteMapping
    @ResponseBody
    public ResponseEntity delete(Integer id, HttpSession session) throws Exception{
        ResponseEntity responseEntity = new ResponseEntity();
        Intermediary intermediary = WxUtils.getCompany(session);
        List<WxPublic> wxPublics = wxPublicService.findByCompanyId(intermediary.getIntermediaryId());
        List<Integer> ids = new ArrayList<>();
        for(WxPublic wxPublic : wxPublics){
            ids.add(wxPublic.getId());
        }
        if(!ids.contains(id)){
            responseEntity.setMessages("没有权限删除该公众号");
            responseEntity.setStatus("500");
            return responseEntity;
        }
        wxPublicService.deleteByPrimaryKey(id);
        return ResponseEntity.ok();
    }

    @GetMapping("page")
    @ResponseBody
    public Object pageList(Integer pageNum,
                                   Integer pageSize,
                                   WxPublic wxPublic,
                            @RequestParam(value = "draw", required = false) Integer draw,
                                   HttpSession session) throws Exception{
            PageHelper.startPage(pageNum, pageSize);
            wxPublic.setIntermediary(WxUtils.getCompany(session));
            List<WxPublic> list = wxPublicService.selectAll(wxPublic);
            PageInfo pageInfo = new PageInfo(list);
        if (draw != null) {
            DataTablesResponseEntity<Intermediary> responseEntity = new DataTablesResponseEntity(draw, pageInfo.getTotal(), pageInfo.getTotal(), pageInfo.getList());
            return responseEntity;
        } else {
            return pageInfo;
        }
    }
}
