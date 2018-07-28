package com.jianpanmao.common.controller;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jianpanmao.Application;
import com.jianpanmao.attach.entity.Attach;
import com.jianpanmao.attach.service.AttachService;
import com.jianpanmao.common.annotation.NoResultEntity;
import com.jianpanmao.common.config.MyConfig;
import com.jianpanmao.device.dto.control.DeviceControlVo;
import com.jianpanmao.device.entity.Device;
import com.jianpanmao.device.service.DeviceService;
import com.jianpanmao.deviceLog.entity.DeviceLog;
import com.jianpanmao.sys.entity.DingtalkUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;


@Controller
public class CommonController{

    @RequestMapping("login")
    public String login(){
        return "login";
    }

    @RequestMapping("index")
    public String index(){
        return "index";
    }

    @RequestMapping("upload")
    public String upload(){
        return "upload";
    }


    @RequestMapping("info")
    public String info(){
        return "info";
    }


    @RequestMapping("editIntermediary")
    public String editIntermediary(Model model){
        DingtalkUser user = (DingtalkUser) SecurityContextHolder.getContext().getAuthentication() .getPrincipal();
        Integer intermediaryId = user.getIntermediaryId();
        model.addAttribute("id", intermediaryId);
        return "intermediary/intermediary_edit";
    }

    @Autowired
    AttachService attachService;

    @Autowired
    DeviceService deviceService;


    @Value("${fc.uploadPath}")
    private String path;


    //@Autowired
    //MyConfig config;

    @PostMapping("/upload")
    @ResponseBody
    public Attach handleFileUpload(@RequestParam("file") MultipartFile file,HttpServletRequest request) throws IOException {



        Date nowTime=new Date();

        SimpleDateFormat time=new SimpleDateFormat("yyyy-MM-dd");



        String fileName = file.getOriginalFilename();

        String path="c:\\upload\\";

        File targetFile = new File(path+time.format(nowTime),fileName);


        if(!targetFile.getParentFile().exists()){

            targetFile.getParentFile().mkdirs();
        }



        String relativePath =time.format(nowTime)+File.separator+ UUID.randomUUID()+"_"+fileName;

        String newPath = path+relativePath;

        Attach attach=new Attach();
        attach.setPath(relativePath);
        attach.setFilename(fileName);
        attach.setMime(file.getContentType());
        attach.setSize(file.getSize());


        int add = attachService.add(attach);

        attach.setId(add);

        File newFile = new File(newPath);
        file.transferTo(newFile);


        return attach;
    }


    @PostMapping(value = "/editoUpload")
    @NoResultEntity
    public void editorUpload(@RequestParam("upload") MultipartFile file,HttpServletRequest request,HttpServletResponse response) throws IOException {



        Date nowTime=new Date();

        SimpleDateFormat time=new SimpleDateFormat("yyyy-MM-dd");



        String fileName = file.getOriginalFilename();

        File targetFile = new File(path+time.format(nowTime),fileName);


        if(!targetFile.getParentFile().exists()){

            targetFile.getParentFile().mkdirs();
        }



        String relativePath =time.format(nowTime)+File.separator+ UUID.randomUUID()+"_"+fileName;

        String newPath = path+relativePath;

        Attach attach=new Attach();
        attach.setPath(relativePath);
        attach.setFilename(fileName);
        attach.setMime(file.getContentType());
        attach.setSize(file.getSize());


        int add = attachService.add(attach);

        attach.setId(add);

        File newFile = new File(newPath);
        file.transferTo(newFile);
        String CKEditorFuncNum = request.getParameter("CKEditorFuncNum");
        response.setContentType("text/html;charset=UTF-8");

        PrintWriter out = response.getWriter();
        //out.println("<script type=\"text/javascript\">");
        //out.println("window.parent.CKEDITOR.tools.callFunction("
            //    + CKEditorFuncNum + ",'/uploadimg/"+attach.getPath().replace("\\","/")+"','')");
        //out.println("</script>");
        out.println("{\n" +
                "    \"uploaded\": 1,\n" +
                "    \"fileName\": \""+attach.getFilename()+"\",\n" +
                "    \"url\": \"/uploadimg/"+attach.getPath().replace("\\","/")+"\"\n" +
                "}");
    }


    @Autowired
    Application.MyGateway gateway;

    @PostMapping("/api/mqtt_send")
    @ResponseBody
    @Transactional
    public Map mqttSend(@RequestBody Map data) throws JsonProcessingException {

        //System.out.println(gateway);
      /*  ObjectMapper mapper=new ObjectMapper();

        String s = mapper.writeValueAsString(data);

       *//* for (int i = 0; i < 1000; i++) {
            gateway.sendToMqtt(s,"topic"+i);
        }*//*


        gateway.sendToMqtt(s,"/Control/json");


        Map rdata=new HashMap<>();
        if (saveDeviceLog(data)){
            rdata.put("msg","发送成功！");
        }else {
            rdata.put("msg","保存日志失败！");
        }

        return rdata;*/
        return null;
    }



    @RequestMapping(value = "/session_timeout")
    public void sessionTimeout(HttpServletRequest request,HttpServletResponse response) throws IOException {
        if (request.getHeader("x-requested-with") != null
                && request.getHeader("x-requested-with").equalsIgnoreCase(
                "XMLHttpRequest")) { // ajax 超时处理
            response.getWriter().print("timeout");  //设置超时标识
            response.getWriter().close();
        } else {
            response.sendRedirect("/login");
        }
    }

    //保存日志
    public boolean saveDeviceLog(Map data){
        DeviceControlVo old =  deviceService.deviceControl("a");
return true;
    }
}
