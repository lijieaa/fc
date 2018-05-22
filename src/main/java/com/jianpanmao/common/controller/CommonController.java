package com.jianpanmao.common.controller;


import com.jianpanmao.attach.entity.Attach;
import com.jianpanmao.attach.service.AttachService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;


@Controller
public class CommonController {

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

    @Autowired
    AttachService attachService;


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
}
