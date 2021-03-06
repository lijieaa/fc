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
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;


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

    @Override
    protected ResponseEntity hookExist(Intermediary intermediary) {
        ResponseEntity responseEntity = new ResponseEntity();
        Integer id = service.exist(intermediary.getId(), "intermediary_name", intermediary.getIntermediaryName());
        if (null != id) {
            responseEntity.setStatus("500");
            responseEntity.setMessages("中间商名称已被占用");
        }
        return responseEntity;
    }

    /*    public ResponseEntity exist1(String name, String value) {

        name = name.trim();
        value = value.trim();
        Integer id = getService().exist(name, value);
        if (id == null) {
            responseEntity.setMessages("参数未被占用");
        } else {
            responseEntity.setStatus("500");
            responseEntity.setMessages("参数被占用");
        }
        return responseEntity;
    }*/

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

    @GetMapping("idNameList")
    @ResponseBody
    public ResponseEntity selectIdNameList() {
        ResponseEntity responseEntity = new ResponseEntity();
        responseEntity.setList(service.selectIdNameList());
        return responseEntity;
    }

}
