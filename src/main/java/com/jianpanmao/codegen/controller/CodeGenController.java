package com.jianpanmao.codegen.controller;

import com.jianpanmao.codegen.dao.CodeGenMapper;
import com.jianpanmao.codegen.entity.Table;
import com.jianpanmao.common.entity.ResultEntity;
import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.config.*;
import org.mybatis.generator.config.Configuration;
import org.mybatis.generator.internal.DefaultShellCallback;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

/**
 * 代码生成控制器
 */
@Controller
@RequestMapping("code_gen")
public class CodeGenController {

    @Autowired
    CodeGenMapper codeGenMapper;

    @RequestMapping("index")
    public String index(Model model){
        List<Table> tables = codeGenMapper.selectAll();
        model.addAttribute("tables",tables);
        return "codegen/index";
    }

    @RequestMapping("gen")
    @ResponseBody
    public ResultEntity gen(
            @RequestParam(value = "name",required = true) String tableName,
            @RequestParam(value = "pkg",required = true) String pkg
    ) throws Exception {
        //String pkg="com.jianpanmao.news";
        //String tableName="news";
        String javaFileProject="src/main/java";
        String resource="src/main/resources";
        Context context = new Context(ModelType.FLAT);
        context.setTargetRuntime("com.jianpanmao.codegen.introspected.MyIntrospectedTableMyBatis3Impl");
        context.setId("test");
        context.addProperty("autoDelimitKeywords", "true");
        context.addProperty("javaFileEncoding", "utf-8");
        context.addProperty("beginningDelimiter", "`");
        context.addProperty("endingDelimiter", "`");
        context.addProperty("javaFormatter", "org.mybatis.generator.api.dom.DefaultJavaFormatter");
        context.addProperty("xmlFormatter", "org.mybatis.generator.api.dom.DefaultXmlFormatter");
        /****************************************插件***************************************************/
        PluginConfiguration pluginConfiguration = null;
        pluginConfiguration = new PluginConfiguration();
        pluginConfiguration.setConfigurationType("org.mybatis.generator.plugins.SerializablePlugin");
        context.addPluginConfiguration(pluginConfiguration);

        pluginConfiguration = new PluginConfiguration();
        pluginConfiguration.setConfigurationType("org.mybatis.generator.plugins.ToStringPlugin");
        context.addPluginConfiguration(pluginConfiguration);


        pluginConfiguration = new PluginConfiguration();
        pluginConfiguration.setConfigurationType("com.jianpanmao.codegen.plugin.BaseMapperGeneratorPlugin");
        pluginConfiguration.addProperty("pkg", pkg);
        pluginConfiguration.addProperty("project",javaFileProject);
        pluginConfiguration.addProperty("resource",resource);
        context.addPluginConfiguration(pluginConfiguration);

        /****************************************注释***************************************************/
        CommentGeneratorConfiguration commentGeneratorConfiguration = new CommentGeneratorConfiguration();
        commentGeneratorConfiguration.addProperty("suppressAllComments", "true");
        commentGeneratorConfiguration.addProperty("suppressDate", "true");
        context.setCommentGeneratorConfiguration(commentGeneratorConfiguration);
        /****************************************jdbc连接***************************************************/
        JDBCConnectionConfiguration jdbcConnectionConfiguration = new JDBCConnectionConfiguration();
        jdbcConnectionConfiguration.setDriverClass("com.mysql.jdbc.Driver");
        jdbcConnectionConfiguration.setConnectionURL("jdbc:mysql://47.104.144.238:6666/fc");
        jdbcConnectionConfiguration.setUserId("fc");
        jdbcConnectionConfiguration.setPassword("123456");
        context.setJdbcConnectionConfiguration(jdbcConnectionConfiguration);
        /****************************************类型解析***************************************************/
        JavaTypeResolverConfiguration javaTypeResolverConfiguration = new JavaTypeResolverConfiguration();
        javaTypeResolverConfiguration.addProperty("forceBigDecimals", "false");
        context.setJavaTypeResolverConfiguration(javaTypeResolverConfiguration);
        /****************************************model***************************************************/
        JavaModelGeneratorConfiguration javaModelGeneratorConfiguration = new JavaModelGeneratorConfiguration();
        javaModelGeneratorConfiguration.setTargetPackage(pkg+".entity");
        javaModelGeneratorConfiguration.setTargetProject(javaFileProject);
        //javaModelGeneratorConfiguration.addProperty("rootClass","com.jianpanmao.common.entity.BaseEntity");
        javaModelGeneratorConfiguration.addProperty("enableSubPackages", "false");
        javaModelGeneratorConfiguration.addProperty("trimStrings", "true");
        javaModelGeneratorConfiguration.addProperty("addRemarkComments", "true");
        context.setJavaModelGeneratorConfiguration(javaModelGeneratorConfiguration);
        /****************************************mapper***************************************************/
        SqlMapGeneratorConfiguration sqlMapGeneratorConfiguration=new SqlMapGeneratorConfiguration();
        sqlMapGeneratorConfiguration.setTargetPackage("mapper");
        sqlMapGeneratorConfiguration.setTargetProject("src/main/resources");
        sqlMapGeneratorConfiguration.addProperty("enableSubPackages","false");
        context.setSqlMapGeneratorConfiguration(sqlMapGeneratorConfiguration);
        /****************************************java client***************************************************/
        JavaClientGeneratorConfiguration javaClientGeneratorConfiguration=new JavaClientGeneratorConfiguration();
        javaClientGeneratorConfiguration.setTargetPackage(pkg+".dao");
        javaClientGeneratorConfiguration.setTargetProject(javaFileProject);
        javaClientGeneratorConfiguration.addProperty("enableSubPackages", "false");
        //javaClientGeneratorConfiguration.addProperty("rootInterface","com.jianpanmao.common.dao.BaseDao");
        javaClientGeneratorConfiguration.setConfigurationType("XMLMAPPER");
        context.setJavaClientGeneratorConfiguration(javaClientGeneratorConfiguration);
        TableConfiguration tableConfiguration=new TableConfiguration(context);
        tableConfiguration.setTableName(tableName);
        //tableConfiguration.setMapperName(tableConfiguration.getTableName().indexOf(0)"Dao");
        tableConfiguration.setCountByExampleStatementEnabled(true);
        tableConfiguration.setDeleteByExampleStatementEnabled(true);
        tableConfiguration.setDeleteByPrimaryKeyStatementEnabled(true);
        tableConfiguration.setSelectByPrimaryKeyStatementEnabled(true);
        tableConfiguration.setUpdateByExampleStatementEnabled(true);
        tableConfiguration.setUpdateByPrimaryKeyStatementEnabled(true);
        tableConfiguration.setInsertStatementEnabled(true);
        context.addTableConfiguration(tableConfiguration);

        List<String> warnings = new ArrayList<String>();
        boolean overwrite = true;
        DefaultShellCallback callback = new DefaultShellCallback(overwrite);
        Configuration config=new Configuration();
        config.addContext(context);
        MyBatisGenerator myBatisGenerator = new MyBatisGenerator(config, callback, warnings);
        myBatisGenerator.generate(null);

        return  new ResultEntity(200,"代码生成成功！","代码生成成功！");
    }
}
