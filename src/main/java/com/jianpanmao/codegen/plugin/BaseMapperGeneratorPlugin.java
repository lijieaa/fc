package com.jianpanmao.codegen.plugin;

import com.jianpanmao.common.utils.StringUtil;
import freemarker.template.DefaultObjectWrapper;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import org.mybatis.generator.api.*;
import org.mybatis.generator.api.dom.java.*;
import org.mybatis.generator.api.dom.xml.Attribute;
import org.mybatis.generator.api.dom.xml.Document;
import org.mybatis.generator.api.dom.xml.TextElement;
import org.mybatis.generator.api.dom.xml.XmlElement;
import org.mybatis.generator.exception.ShellException;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;
import java.util.function.Predicate;

import static org.mybatis.generator.internal.util.messages.Messages.getString;

/**
 * Created by Administrator on 2018/4/29.
 */
public class BaseMapperGeneratorPlugin extends PluginAdapter {

    private String pkg;
    private String project;
    private String modelPkg;
    private String modelName;
    private String modelExampleName;
    private String servicePkg;
    private String modelExamplePkg;
    private String resource;
    @Override
    public void initialized(IntrospectedTable introspectedTable) {
        Properties properties = this.getProperties();
        this.pkg = (String) properties.get("pkg");
        System.out.println(pkg);


        this.project = (String) properties.get("project");
        System.out.println(project);

        this.resource = (String) properties.get("resource");
        System.out.println(resource);

        this.modelPkg = introspectedTable.getBaseRecordType();
        modelExamplePkg = introspectedTable.getExampleType();

        int modelIndexOf = modelPkg.lastIndexOf(".");
        this.modelName = modelPkg.substring(modelIndexOf + 1);
        System.out.println(modelName);


        int modelExampleIndexOf = modelExamplePkg.lastIndexOf(".");
        this.modelExampleName = modelExamplePkg.substring(modelExampleIndexOf + 1);
        System.out.println(modelExampleName);


        this.servicePkg = pkg + ".service";

        super.initialized(introspectedTable);
    }


    @Override
    public boolean validate(List<String> list) {
        return true;
    }

    @Override
    public List<GeneratedJavaFile> contextGenerateAdditionalJavaFiles(IntrospectedTable introspectedTable) {



        List<IntrospectedColumn> primaryKeyColumns = introspectedTable.getPrimaryKeyColumns();



        Map root = new HashMap();
        root.put("pkg", pkg);
        root.put("servicePkg", servicePkg);
        root.put("modelPkg", modelPkg);
        root.put("modelExamplePkg", modelExamplePkg);
        root.put("modelName", modelName);
        root.put("modelExampleName", modelExampleName);
        freemarker.template.Configuration configuration = new freemarker.template.Configuration(freemarker.template.Configuration.VERSION_2_3_28);
        try {
            configuration.setDirectoryForTemplateLoading(new File("src\\main\\resources\\ftl"));
            configuration.setObjectWrapper(new DefaultObjectWrapper(freemarker.template.Configuration.VERSION_2_3_28));

            Template template=null;
            String filename=null;
            File directory=null;
            File targetFile=null;
            FileWriter fw=null;
            BufferedWriter bw=null;

            template = configuration.getTemplate("service.ftl");
            filename = modelName + "Service.java";
            directory = this.getDirectory(project, servicePkg);
            System.out.println(directory);
            targetFile = new File(directory, filename);
            fw = new FileWriter(targetFile);
            bw = new BufferedWriter(fw);
            template.process(root, bw);
            bw.flush();
            fw.close();


            template = configuration.getTemplate("service_impl.ftl");
            filename = modelName + "ServiceImpl.java";
            directory = this.getDirectory(project, servicePkg + ".impl");
            System.out.println(directory);
            targetFile = new File(directory, filename);
            fw = new FileWriter(targetFile);
            bw = new BufferedWriter(fw);
            template.process(root, bw);
            bw.flush();
            fw.close();



            template = configuration.getTemplate("rest_controller.ftl");
            filename = modelName + "RestController.java";
            directory = this.getDirectory(project, pkg + ".controller");
            System.out.println(directory);
            targetFile = new File(directory, filename);
            fw = new FileWriter(targetFile);
            bw = new BufferedWriter(fw);
            template.process(root, bw);
            bw.flush();
            fw.close();


            template = configuration.getTemplate("controller.ftl");
            filename = modelName + "Controller.java";
            directory = this.getDirectory(project, pkg + ".controller");
            System.out.println(directory);
            targetFile = new File(directory, filename);
            fw = new FileWriter(targetFile);
            bw = new BufferedWriter(fw);
            template.process(root, bw);
            bw.flush();
            fw.close();

            Map cols=new HashMap<>();
            List<IntrospectedColumn> columns = introspectedTable.getAllColumns();
            for (IntrospectedColumn column : columns) {
                for (IntrospectedColumn primaryKeyColumn : primaryKeyColumns) {
                    if (column.getActualColumnName().equals(primaryKeyColumn.getActualColumnName())){
                        cols.put(column.getJavaProperty()+"_primaryKey",column.getLength());
                        root.put("primaryKey",column.getJavaProperty());
                    }else{
                        cols.put(column.getJavaProperty(),column.getLength());
                    }
                }
            }

            root.put("cols",cols);


            template = configuration.getTemplate("list.ftl");
            filename = modelName.toLowerCase()+"_list.html";
            directory = this.getDirectory(resource, "templates."+modelName.toLowerCase());
            System.out.println(directory);
            targetFile = new File(directory, filename);
            fw = new FileWriter(targetFile);
            bw = new BufferedWriter(fw);
            template.process(root, bw);
            bw.flush();
            fw.close();



            template = configuration.getTemplate("add.ftl");
            filename = modelName.toLowerCase()+"_add.html";
            directory = this.getDirectory(resource, "templates."+modelName.toLowerCase());
            System.out.println(directory);
            targetFile = new File(directory, filename);
            fw = new FileWriter(targetFile);
            bw = new BufferedWriter(fw);
            template.process(root, bw);
            bw.flush();
            fw.close();


            template = configuration.getTemplate("edit.ftl");
            filename = modelName.toLowerCase()+"_edit.html";
            directory = this.getDirectory(resource, "templates."+modelName.toLowerCase());
            System.out.println(directory);
            targetFile = new File(directory, filename);
            fw = new FileWriter(targetFile);
            bw = new BufferedWriter(fw);
            template.process(root, bw);
            bw.flush();
            fw.close();


            template = configuration.getTemplate("detail.ftl");
            filename = modelName.toLowerCase()+"_detail.html";
            directory = this.getDirectory(resource, "templates."+modelName.toLowerCase());
            System.out.println(directory);
            targetFile = new File(directory, filename);
            fw = new FileWriter(targetFile);
            bw = new BufferedWriter(fw);
            template.process(root, bw);
            bw.flush();
            fw.close();




        } catch (Exception e) {
            e.printStackTrace();
        }


        return super.contextGenerateAdditionalJavaFiles(introspectedTable);
    }

    @Override
    public boolean clientGenerated(Interface interfaze, TopLevelClass topLevelClass, IntrospectedTable introspectedTable) {
        /**
         * 主键默认采用java.lang.Integer
         */
        FullyQualifiedJavaType fqjt = new FullyQualifiedJavaType("BaseDao<"
                + introspectedTable.getBaseRecordType() + ","
                + introspectedTable.getExampleType() + ","
                + ""+pkg+".dto."+modelName+"Dto" + ","
                + "java.lang.Integer" + ">");
        FullyQualifiedJavaType imp = new FullyQualifiedJavaType(
                "com.jianpanmao.common.dao.BaseDao");
        /**
         * 添加 extends MybatisBaseMapper
         */
        interfaze.addSuperInterface(fqjt);

        /**
         * 添加import my.mabatis.example.base.MybatisBaseMapper;
         */
        interfaze.addImportedType(imp);

        interfaze.addAnnotation("@Mapper");

        interfaze.addImportedType(new FullyQualifiedJavaType("org.apache.ibatis.annotations.Mapper"));
        interfaze.addImportedType(new FullyQualifiedJavaType(pkg + ".dto." + modelName + "Dto"));
        /**
         * 方法不需要
         */
        interfaze.getMethods().clear();


        interfaze.getImportedTypes().removeIf(new Predicate<FullyQualifiedJavaType>() {
            @Override
            public boolean test(FullyQualifiedJavaType fullyQualifiedJavaType) {
                if (fullyQualifiedJavaType.getFullyQualifiedName().equals("java.util.List")) {
                    return true;
                } else if (fullyQualifiedJavaType.getFullyQualifiedName().equals("org.apache.ibatis.annotations.Param")) {
                    return true;
                }
                return false;
            }
        });

        return super.clientGenerated(interfaze, topLevelClass, introspectedTable);
    }

    @Override
    public boolean modelBaseRecordClassGenerated(TopLevelClass topLevelClass, IntrospectedTable introspectedTable) {


        Map root = new HashMap();



        List<Field> fields = topLevelClass.getFields();
        fields.add(new Field("od",new FullyQualifiedJavaType("java.lang.String")));
        Map<String,String> types = new HashMap<>();

        for (Field field : fields) {
            StringBuffer sb=new StringBuffer();
            if(field.getType().getPrimitiveTypeWrapper()==null){
                //types.add(field.getType().getFullyQualifiedName());
                String fullyQualifiedName = field.getType().getFullyQualifiedName();
                sb.append(fullyQualifiedName.substring(fullyQualifiedName.lastIndexOf(".")+1));
            }else{
                //types.add(field.getType().getPrimitiveTypeWrapper().getFullyQualifiedName());
                String fullyQualifiedName = field.getType().getPrimitiveTypeWrapper().getFullyQualifiedName();
                sb.append(fullyQualifiedName.substring(fullyQualifiedName.lastIndexOf(".")+1));
            }

            if(!"serialVersionUID".equals(field.getName())){
                types.put(field.getName(),sb.toString());
            }


        }

        root.put("st",new StringUtil());
        root.put("pkg",pkg);
        root.put("types",types);
        root.put("modelName",modelName);
        root.put("fields",fields);


        freemarker.template.Configuration configuration = new freemarker.template.Configuration(freemarker.template.Configuration.VERSION_2_3_28);

        try {
            configuration.setDirectoryForTemplateLoading(new File("src\\main\\resources\\ftl"));

            configuration.setObjectWrapper(new DefaultObjectWrapper(freemarker.template.Configuration.VERSION_2_3_28));


            String modelPkg = introspectedTable.getBaseRecordType();
            String modelExamplePkg = introspectedTable.getExampleType();

            int modelIndexOf = modelPkg.lastIndexOf(".");
            String modelName = modelPkg.substring(modelIndexOf + 1);
            System.out.println(modelName);

            Template temp = configuration.getTemplate("dto.ftl");
            String fileName = modelName + "Dto.java";
            File directory = this.getDirectory(project, pkg+".dto");
            System.out.println(directory);
            File targetFile = new File(directory, fileName);
            FileWriter fw = new FileWriter(targetFile);
            BufferedWriter bw = new BufferedWriter(fw);
            temp.process(root, bw);
            bw.flush();
            fw.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
        topLevelClass.addImportedType("javax.validation.constraints.NotNull");
        topLevelClass.addImportedType("javax.validation.constraints.Max");
        return super.modelBaseRecordClassGenerated(topLevelClass, introspectedTable);
    }

    @Override
    public boolean modelFieldGenerated(Field field, TopLevelClass topLevelClass, IntrospectedColumn introspectedColumn, IntrospectedTable introspectedTable, ModelClassType modelClassType) {
        //主键不添加验证注解
        List<IntrospectedColumn> primaryKeyColumns = introspectedTable.getPrimaryKeyColumns();
        for (IntrospectedColumn primaryKeyColumn : primaryKeyColumns) {
            if (!field.getName().equals(primaryKeyColumn.getJavaProperty())) {
                if (!introspectedColumn.isNullable()) {
                    field.addAnnotation("@NotNull(message = \"" + field.getName() + "不能为空！\")");
                }
               /* if (introspectedColumn.getLength()>0) {
                    field.addAnnotation("@Max(message = \""+field.getName()+"长度不能超过"+introspectedColumn.getLength()+"\",value = "+introspectedColumn.getLength()+")");
                }*/
            }
        }

        field.addJavaDocLine("//" + introspectedColumn.getRemarks());
        return super.modelFieldGenerated(field, topLevelClass, introspectedColumn, introspectedTable, modelClassType);
    }

    @Override
    public boolean sqlMapDocumentGenerated(Document document, IntrospectedTable introspectedTable) {
        //查询所有
        XmlElement rootElement = document.getRootElement();
        XmlElement selectAll = new XmlElement("select");
        Attribute id = new Attribute("id", "selectAll");
        selectAll.addAttribute(id);
        Attribute resultMap = new Attribute("resultMap", "BaseResultMap");
        selectAll.addAttribute(resultMap);
        Attribute parameterType = new Attribute("parameterType", introspectedTable.getBaseRecordType());
        selectAll.addAttribute(parameterType);
        TextElement textElement = new TextElement("select * from " + introspectedTable.getTableConfiguration().getTableName());
        selectAll.addElement(textElement);
        rootElement.addElement(selectAll);

        //批量删除
        List<IntrospectedColumn> primaryKeyColumns = introspectedTable.getPrimaryKeyColumns();
        IntrospectedColumn introspectedColumn = primaryKeyColumns.get(0);
        String actualColumnName = introspectedColumn.getActualColumnName();
        String batchDeleteSql = "delete from "+introspectedTable.getTableConfiguration().getTableName()+"\n" +
                "    where " + actualColumnName + " in\n" +
                "    <foreach collection=\"array\" index=\"index\" item=\"item\" open=\"(\" separator=\",\" close=\")\">\n" +
                "              #{item}\n" +
                "    </foreach>";


        XmlElement deleteBatch = new XmlElement("delete");
        Attribute deleteBatchId = new Attribute("id", "deleteBatch");
        deleteBatch.addAttribute(deleteBatchId);
        Attribute deleteBatchParameterType = new Attribute("parameterType", "java.util.ArrayList");
        deleteBatch.addAttribute(deleteBatchParameterType);
        TextElement deleteBatchTextElement = new TextElement(batchDeleteSql);
        deleteBatch.addElement(deleteBatchTextElement);
        rootElement.addElement(deleteBatch);


        //selectByDto
        XmlElement selectByDto = new XmlElement("select");
        Attribute selectByDtoId = new Attribute("id", "selectByDto");
        selectByDto.addAttribute(selectByDtoId);
        Attribute selectByDtoResultMap = new Attribute("resultMap", "BaseResultMap");
        selectByDto.addAttribute(selectByDtoResultMap);
        Attribute selectByDtoParameterType = new Attribute("parameterType", pkg+".dto."+modelName+"Dto");
        selectByDto.addAttribute(selectByDtoParameterType);

        TextElement selectByDtoTextElement = new TextElement("select <include refid=\"Base_Column_List\" /> from " + introspectedTable.getTableConfiguration().getTableName()+" where 1=1");
        selectByDto.addElement(selectByDtoTextElement);

        List<IntrospectedColumn> allColumns = introspectedTable.getAllColumns();
        for (IntrospectedColumn col : allColumns) {
            XmlElement e=new XmlElement("if");
            String str=null;
            if(col.getJdbcTypeName().equals("VARCHAR")){
                str = col.getJavaProperty()+"!=null and '' neq "+col.getJavaProperty();
            }else if((col.getJdbcTypeName().equals("LONGVARCHAR"))){
                str = col.getJavaProperty()+"!=null and '' neq "+col.getJavaProperty();
            }else {
                str=col.getJavaProperty()+"!=null";
            }
            Attribute a=new Attribute("test",str);
            TextElement te=new TextElement("and "+col.getActualColumnName()+"=#{"+col.getJavaProperty()+"}");
            e.addElement(te);
            e.addAttribute(a);
            selectByDto.addElement(e);
        }

        XmlElement e=new XmlElement("if");
        Attribute a=new Attribute("test","od!=null and od neq ''");
        e.addAttribute(a);
        TextElement te=new TextElement("order by ${od}");
        e.addElement(te);
        selectByDto.addElement(e);

        rootElement.addElement(selectByDto);


        return super.sqlMapDocumentGenerated(document, introspectedTable);
    }

    private File getDirectory(String targetProject, String targetPackage)
            throws ShellException {
        // targetProject is interpreted as a directory that must exist
        //
        // targetPackage is interpreted as a sub directory, but in package
        // format (with dots instead of slashes). The sub directory will be
        // created
        // if it does not already exist

        File project = new File(targetProject);
        if (!project.isDirectory()) {
            throw new ShellException(getString("Warning.9", //$NON-NLS-1$
                    targetProject));
        }

        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(targetPackage, "."); //$NON-NLS-1$
        while (st.hasMoreTokens()) {
            sb.append(st.nextToken());
            sb.append(File.separatorChar);
        }

        File directory = new File(project, sb.toString());
        if (!directory.isDirectory()) {
            boolean rc = directory.mkdirs();
            if (!rc) {
                throw new ShellException(getString("Warning.10", //$NON-NLS-1$
                        directory.getAbsolutePath()));
            }
        }

        return directory;
    }

}
