package com.jianpanmao.codegen;

import org.junit.Test;
import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.config.*;
import org.mybatis.generator.config.xml.ConfigurationParser;
import org.mybatis.generator.exception.XMLParserException;
import org.mybatis.generator.internal.DefaultShellCallback;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

/**
 * Created by Administrator on 2018/4/27.
 */
public class Main {

    @Test
    public void testHello() throws Exception {
        String pkg="com.jianpanmao.news";
        String tableName="news";
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
        /****************************************锟斤拷锟�***************************************************/
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

        /****************************************注锟斤拷***************************************************/
        CommentGeneratorConfiguration commentGeneratorConfiguration = new CommentGeneratorConfiguration();
        commentGeneratorConfiguration.addProperty("suppressAllComments", "true");
        commentGeneratorConfiguration.addProperty("suppressDate", "true");
        context.setCommentGeneratorConfiguration(commentGeneratorConfiguration);
        /****************************************jdbc锟斤拷锟斤拷***************************************************/
        JDBCConnectionConfiguration jdbcConnectionConfiguration = new JDBCConnectionConfiguration();
        jdbcConnectionConfiguration.setDriverClass("com.mysql.jdbc.Driver");
        jdbcConnectionConfiguration.setConnectionURL("jdbc:mysql://47.104.144.238:6666/fc");
        jdbcConnectionConfiguration.setUserId("fc");
        jdbcConnectionConfiguration.setPassword("123456");
        context.setJdbcConnectionConfiguration(jdbcConnectionConfiguration);
        /****************************************锟斤拷锟斤拷转锟斤拷***************************************************/
        JavaTypeResolverConfiguration javaTypeResolverConfiguration = new JavaTypeResolverConfiguration();
        javaTypeResolverConfiguration.addProperty("forceBigDecimals", "false");
        context.setJavaTypeResolverConfiguration(javaTypeResolverConfiguration);
        /****************************************锟斤拷锟斤拷实锟斤拷锟斤拷锟街�***************************************************/
        JavaModelGeneratorConfiguration javaModelGeneratorConfiguration = new JavaModelGeneratorConfiguration();
        javaModelGeneratorConfiguration.setTargetPackage(pkg+".entity");
        javaModelGeneratorConfiguration.setTargetProject(javaFileProject);
        javaModelGeneratorConfiguration.addProperty("rootClass","com.jianpanmao.common.entity.BaseEntity");
        javaModelGeneratorConfiguration.addProperty("enableSubPackages", "false");
        javaModelGeneratorConfiguration.addProperty("trimStrings", "true");
        javaModelGeneratorConfiguration.addProperty("addRemarkComments", "true");
        context.setJavaModelGeneratorConfiguration(javaModelGeneratorConfiguration);
       /****************************************锟斤拷锟斤拷mapxml锟侥硷拷***************************************************/
        SqlMapGeneratorConfiguration sqlMapGeneratorConfiguration=new SqlMapGeneratorConfiguration();
        sqlMapGeneratorConfiguration.setTargetPackage("mapper");
        sqlMapGeneratorConfiguration.setTargetProject("src/main/resources");
        sqlMapGeneratorConfiguration.addProperty("enableSubPackages","false");
        context.setSqlMapGeneratorConfiguration(sqlMapGeneratorConfiguration);
        /****************************************锟斤拷锟斤拷mapxml锟斤拷应client锟斤拷也锟斤拷锟角接匡拷dao***************************************************/
        JavaClientGeneratorConfiguration javaClientGeneratorConfiguration=new JavaClientGeneratorConfiguration();
        javaClientGeneratorConfiguration.setTargetPackage(pkg+".dao");
        javaClientGeneratorConfiguration.setTargetProject(javaFileProject);
        javaClientGeneratorConfiguration.addProperty("enableSubPackages", "false");
        //javaClientGeneratorConfiguration.addProperty("rootInterface","com.jianpanmao.common.dao.BaseDao");
        javaClientGeneratorConfiguration.setConfigurationType("XMLMAPPER");
        context.setJavaClientGeneratorConfiguration(javaClientGeneratorConfiguration);
        //table锟斤拷锟斤拷锟叫讹拷锟�,每锟斤拷锟斤拷锟捷匡拷锟叫的憋拷锟斤拷锟斤拷写一锟斤拷table锟斤拷tableName锟斤拷示要匹锟斤拷锟斤拷锟斤拷菘锟斤拷,也锟斤拷锟斤拷锟斤拷tableName锟斤拷锟斤拷锟斤拷通锟斤拷使锟斤拷%通锟斤拷锟斤拷锟狡ワ拷锟斤拷锟斤拷锟斤拷锟斤拷菘锟斤拷,只锟斤拷匹锟斤拷谋锟脚伙拷锟皆讹拷锟斤拷锟斤拷锟侥硷拷
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

    }
}
