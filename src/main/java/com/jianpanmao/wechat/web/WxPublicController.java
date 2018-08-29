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
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.io.InputStream;
import java.io.StringWriter;
import java.nio.charset.StandardCharsets;
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

    @PreAuthorize("hasAuthority('wxpublic:view')")
    @GetMapping("index")
    public String index(Integer menuId, Model model){
        return "wechat/index";
    }

    @PreAuthorize("hasAuthority('wxpublic:add')")
    @GetMapping("add")
    public String add(Integer menuId){
        return "wechat/wxpublic_add";
    }

    @PreAuthorize("hasAuthority('wxpublic:edit')")
    @GetMapping("edit")
    public String edit(Integer id, Model model){
        model.addAttribute("id", id);
        return "wechat/wxpublic_edit";
    }

    @PreAuthorize("hasAuthority('wxmenu:view')")
    @GetMapping("menu")
    public String menu(Integer menuId, Integer wxPublicId,Model model){
        model.addAttribute("wxPublicId", wxPublicId);
        return "wechat/menu";
    }

    @PreAuthorize("hasAuthority('wxuser:view')")
    @GetMapping("user")
    public String user(Integer menuId, Integer wxPublicId, Model model){
        model.addAttribute("wxPublicId", wxPublicId);
        return "wechat/user";
    }

    @PreAuthorize("hasAuthority('wxmsg:view')")
    @GetMapping("msg")
    public String msg(Integer menuId, Integer wxPublicId, Model model){
        model.addAttribute("wxPublicId", wxPublicId);
        return "wechat/msg";
    }

    @PreAuthorize("hasAuthority('wxmaterial:view')")
    @GetMapping("material")
    public String material(Integer menuId, Integer wxPublicId, Model model){
        model.addAttribute("wxPublicId", wxPublicId);
        return "wechat/material";
    }

    @PreAuthorize("hasAuthority('wxpublic:view')")
    @GetMapping
    @ResponseBody
    public WxPublic get(Integer id){
        return wxPublicService.selectByPrimaryKey(id);
    }

    @PreAuthorize("hasAuthority('wxpublic:add')")
    @PostMapping
    @ResponseBody
    public ResponseEntity add(@Valid @RequestBody WxPublic wxPublic, BindingResult result, HttpSession session, HttpServletRequest request) throws Exception {

        String accessToken = wxApiHandler.getAccessToken(wxPublic.getAppId(), wxPublic.getAppSecret());
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
            createDefaultMenu(accessToken, request, wxPublic);
            return responseEntity;
        } catch (Exception e) {
            e.printStackTrace();
            responseEntity.setStatus("500");
            responseEntity.setMessages(e.getMessage());
            return responseEntity;
        }
    }

    private void createDefaultMenu(String accessToken, HttpServletRequest request, WxPublic wxPublic) throws Exception {

        InputStream resourceAsStream = this.getClass().getClassLoader().getResourceAsStream("wx-menu");

        StringWriter writer=new StringWriter();

        IOUtils.copy(resourceAsStream,writer,StandardCharsets.UTF_8);

       String menus=writer.toString().replaceAll("\\$\\{sourceId\\}",wxPublic.getSourceId()).replaceAll("\\$\\{appid\\}",wxPublic.getAppId());

        System.out.println(menus);

       // String path = request.getContextPath();
       // String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
       // String basePath = "http://meplink.com";
        String menu = wxApiHandler.createMenu(accessToken, menus);
    }

    @PreAuthorize("hasAuthority('wxpublic:edit')")
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

    @PreAuthorize("hasAuthority('wxpublic:delete')")
    @DeleteMapping
    @ResponseBody
    public ResponseEntity delete(Integer id, HttpSession session) throws Exception{

        try {
            WxUtils.checkParam(session, id);
            String accessToken = WxUtils.getAccessToken(session, id);
            wxApiHandler.deleteMenu(accessToken);
        } catch (Exception e) {
            e.printStackTrace();
        }


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

    @PreAuthorize("hasAuthority('wxpublic:view')")
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
