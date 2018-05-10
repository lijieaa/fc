package com.we.fc.intermediary.web;

import com.we.fc.base.BaseController;
import com.we.fc.base.BaseService;
import com.we.fc.intermediary.entity.Intermediary;
import com.we.fc.intermediary.service.IntermediaryService;
import com.we.fc.unit.ResponseEntity;
import com.we.fc.utils.FileUpload;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;


/**
 * @author zdc
 * @since 2018-04-05 21:40
 */
@Controller
@RequestMapping("intermediary")
public class IntermediaryController extends BaseController<Intermediary> {

    @Autowired
    IntermediaryService service;

    @GetMapping("detail")
    public String IntermediaryDetail() {
        return "intermediary/detail";
    }

    @Override
    public BaseService<Intermediary> getService() {
        return service;
    }

    @GetMapping("index")
    public String index(Integer menuId, Model model) {
        model.addAttribute("loopMenu", getMenuById(menuId));
        return "intermediary/index";
    }


    @Override
    public ResponseEntity delete(@PathVariable("id") Integer id, HttpSession session) {
        ResponseEntity responseEntity = new ResponseEntity();
        Intermediary intermediary = getService().selectByPrimaryKey(id);
        if (null != intermediary && intermediary.getIsPlat() == 1) {
            responseEntity.setMessages("该条数据不能被删除");
            responseEntity.setStatus("500");
            return responseEntity;
        }
        return super.delete(id, session);
    }

    @PostMapping("upload")
    @ResponseBody
    public ResponseEntity upload(MultipartFile file) {
        ResponseEntity responseEntity = new ResponseEntity();
        String path = FileUpload.fileUpload(file);
        if (path == null || path.length() < 0) {
            responseEntity.setStatus("500");
            responseEntity.setMessages("文件上传失败");
            return responseEntity;
        }
        responseEntity.setData(path);
        return responseEntity;
    }

}
