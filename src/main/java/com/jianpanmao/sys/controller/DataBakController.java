package com.jianpanmao.sys.controller;

import com.jianpanmao.common.annotation.NoResultEntity;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;


@Controller
@RequestMapping("databak")
public class DataBakController {


    protected Log logger  = LogFactory.getLog(this.getClass());;

    @PreAuthorize("hasAuthority('databak:view')")
    @RequestMapping(method = RequestMethod.GET, value = "index")
    public String list() {
        return "databak/index";
    }


    @NoResultEntity
    @PreAuthorize("hasAuthority('databak:export')")
    @RequestMapping(method = RequestMethod.GET, value = "export")
    public void export(HttpServletResponse response){


        Date nowTime=new Date();

        SimpleDateFormat time=new SimpleDateFormat("yyyy-MM-dd");

        String format = time.format(nowTime);

        response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
        response.setHeader("Content-Disposition", "attachment; filename=" + "fc_bak_"+format + ".sql");
        response.setHeader("Pragma", "no-cache");
        response.setHeader("Expires", "0");
        response.setCharacterEncoding("utf-8");


        InputStream resource = this.getClass().getClassLoader().getResourceAsStream("export.properties");
        Properties properties=new Properties();
        try {
            properties.load(resource);
        } catch (IOException e) {
            e.printStackTrace();
        }
        String hostIP=properties.getProperty("host");
        String port=properties.getProperty("port");
        String userName=properties.getProperty("username");
        String password=properties.getProperty("password");
        String databaseName=properties.getProperty("db");
        String path=properties.getProperty("path");

        String command=path+"mysqldump -h" + hostIP +" -P"+port+" -u" + userName + " -p" + password + " --set-charset=utf8 " + databaseName;
        logger.info(command);

        Process process = null;
        InputStreamReader inputStreamReader=null;
        BufferedReader bufferedReader=null;
        try {
            process = Runtime.getRuntime().exec(command);
            inputStreamReader = new InputStreamReader(process.getInputStream(), "utf8");

            bufferedReader = new BufferedReader(inputStreamReader);

            String line;

            while((line = bufferedReader.readLine())!= null){
                //logger.info(line);
                response.getWriter().println(line);
            }
            response.getWriter().flush();

        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                response.getWriter().close();
                bufferedReader.close();
                inputStreamReader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


    }
}
