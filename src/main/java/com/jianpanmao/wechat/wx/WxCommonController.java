package com.jianpanmao.wechat.wx;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.jianpanmao.common.config.WxUserDetailService;
import com.jianpanmao.contacts.entity.Contacts;
import com.jianpanmao.contacts.service.ContactsService;
import com.jianpanmao.project.dao.ProjectMapper;
import com.jianpanmao.project.entity.Project;
import com.jianpanmao.projectComments.dao.ProjectCommentsMapper;
import com.jianpanmao.projectComments.entity.ProjectComments;
import com.jianpanmao.sys.entity.DingtalkUser;
import com.jianpanmao.sys.service.DingtalkUserService;
import com.jianpanmao.wechat.entity.WxPublic;
import com.jianpanmao.wechat.service.WxPublicService;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Map;

/**
 * 公众号页面
 * @author zdc
 * @since 2018-04-07 16:42
 */
@Controller
@RequestMapping("wx/common")
public class WxCommonController {

    @Autowired private ContactsService contactsService;

    @Autowired
    private ProjectCommentsMapper projectCommentsMapper;
    @Autowired
    private ProjectMapper projectMapper;
    @GetMapping("company")
    public String company(String sourceId, Model model){

        model.addAttribute("sourceId", sourceId);
        return "wx/company";
    }

    @GetMapping("index")
    public String index(){
        return "wx/index";
    }



    @GetMapping("equiprams")
    public String equiprams(){
        return "wx/equiprams";
    }

    @Autowired
    ObjectMapper mapper;


    @Autowired
    WxPublicService publicService;

    @GetMapping("project")
    public String project(String sourceId, Model model,String code,HttpSession session){
        WxPublic wxPublic = publicService.findBySourceId(sourceId);
      /*  try {
            //获取token
            System.out.println("code:"+code);
            String apiUrl="https://api.weixin.qq.com/sns/oauth2/access_token?appid=APPID&secret=SECRET&code=CODE&grant_type=authorization_code";
            String tokenUrl = apiUrl.replace("APPID", wxPublic.getAppId()).replace("SECRET", wxPublic.getAppSecret()).replace("CODE", code);
            System.out.println("tokenURL:"+tokenUrl);
            httpClient = new DefaultHttpClient();
            HttpGet httpGet = new HttpGet(tokenUrl);

            httpResponse = httpClient.execute(httpGet);
            HttpEntity httpEntity = httpResponse.getEntity();
            String tokens = EntityUtils.toString(httpEntity, "utf-8");
            System.out.println("tokesString:"+tokens);
            Map map = mapper.readValue(tokens, Map.class);
            System.out.println("tokesJson:"+tokens);
            ((CloseableHttpResponse) httpResponse).close();
            httpClient.close();

            //拉取用户信息
            String userinfo="https://api.weixin.qq.com/sns/userinfo?access_token=ACCESS_TOKEN&openid=OPENID&lang=zh_CN";
            String userinfoUrl = userinfo.replace("ACCESS_TOKEN", (CharSequence) map.get("access_token")).replace("OPENID", (CharSequence) map.get("access_token"));
            httpClient2 = new DefaultHttpClient();
            HttpGet httpGet2 = new HttpGet(userinfoUrl);

            httpResponse2 = httpClient2.execute(httpGet2);
            HttpEntity httpEntity2 = httpResponse2.getEntity();
            String user = EntityUtils.toString(httpEntity2, "utf-8");
            System.out.println("userString:"+user);
            Map userMap = mapper.readValue(user, Map.class);
            System.out.println("userJson:"+userMap);
            ((CloseableHttpResponse) httpResponse2).close();
            httpClient2.close();

            model.addAttribute("sourceId", sourceId);
            //model.addAttribute("user", userMap);
            session.setAttribute("wuser",userMap);

        } catch (IOException e) {


            try {
                ((CloseableHttpResponse) httpResponse).close();
                 httpClient.close();
                ((CloseableHttpResponse) httpResponse2).close();
                httpClient2.close();
            } catch (IOException e1) {
                e1.printStackTrace();
            }

            e.printStackTrace();
        }*/

        return "wx/project";
    }

    @GetMapping("projectinfo")
    public String projectinfo(){
        return "wx/projectinfo";
    }

    @GetMapping("sysparams")
    public String sysparams(){
        return "wx/sysparams";
    }
    @GetMapping("userparams")
    public String userparams(){
        return "wx/userparams";
    }
    @GetMapping("loginwx")
    public String loginwx(){
        return "wx/loginwx";
    }
    @GetMapping("changer")
    public String changer(){
        return "wx/changer";
    }
    @GetMapping("client")
    public String client(){
        return "wx/client";
    }





    @Autowired
    @Qualifier("wxAuthenticationManager")
    private AuthenticationManager wxAuthenticationManager;

    @PostMapping("login")
    public String loginAction(@RequestParam("username") String username, @RequestParam("password") String password, HttpSession session) throws Exception{

        UsernamePasswordAuthenticationToken authRequest=new UsernamePasswordAuthenticationToken(username,password);

        try {
            Authentication authentication = wxAuthenticationManager.authenticate(authRequest); //调用loadUserByUsername
            System.out.println(authentication);
            SecurityContextHolder.getContext().setAuthentication(authentication);
            session.setAttribute("SPRING_SECURITY_CONTEXT", SecurityContextHolder.getContext()); // 这个非常重要，否则验证后将无法登陆
            return "redirect:/wd/equipment";
        } catch (AuthenticationException ex) {
           ex.printStackTrace();
            return "redirect:/wx/common/loginwx";
        }
    }


    /**
     * 外部评论
     */
    @PostMapping("projectComments")
    @ResponseBody
    public Integer projectComments(String wxId,Integer projectId,Integer parent,String content,Integer topCommentsId){
        ProjectComments projectComments = new ProjectComments();
        Project project = projectMapper.selectByPrimaryKey(projectId);
        projectComments.setProjectId(projectId);
        projectComments.setProjectCommentsParent(parent);
        projectComments.setProjectCommentsContent(content);
        projectComments.setProjectTopCommentsId(topCommentsId);
        projectComments.setWxId(wxId);
        projectComments.setProjectCommentsStatus(project.getProjectStatus());
        projectComments.setProjectCommentsType(new Byte("1"));
        Integer commentsId = projectCommentsMapper.insert(projectComments);

        return commentsId;
    }
}
