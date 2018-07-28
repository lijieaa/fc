package com.jianpanmao.attach.service.impl;

import com.jianpanmao.attach.dao.AttachMapper;
import com.jianpanmao.common.service.impl.BaseServiceImpl;
import com.jianpanmao.attach.entity.*;
import com.jianpanmao.attach.dto.*;
import com.jianpanmao.attach.service.AttachService;
import com.jianpanmao.projectAttach.dao.ProjectAttachDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpServletResponse;
import java.io.*;

@Service
public class AttachServiceImpl extends BaseServiceImpl<Attach,AttachExample,AttachDto,Integer> implements AttachService {

    @Autowired
    private AttachMapper attachMapper;

    @Autowired
    private ProjectAttachDao projectAttachDao;

    @Value("${fc.uploadPath}")
    private String path;

    @Override
    @Transactional
    public int remove(Integer TId) {
        deleteFile(TId);
        projectAttachDao.deleteAttachType(TId);
        return super.remove(TId);
    }

    @Override
    @Transactional
    public int removeBatch(Integer[] ids) {
        for (Integer id :ids){
            deleteFile(id);
            projectAttachDao.deleteAttachType(id);
        }
        return super.removeBatch(ids);
    }

    private void deleteFile(Integer tId)  {
        Attach attach = attachMapper.selectByPrimaryKey(tId);
        File file = new File(path+attach.getPath());
        // 如果文件路径所对应的文件存在，并且是一个文件，则直接删除
        if (file.exists() && file.isFile()) {
            try {
                file.delete();
            }catch (Exception e){
                System.out.println("**************************************删除文件失败**************************************");
                e.printStackTrace();
            }
        }
    }

    @Override
    public void downFile(Integer id, HttpServletResponse response) {
        Attach attach = attachMapper.selectByPrimaryKey(id);
        String fileName = null;
        try {
             fileName = new String(attach.getFilename().getBytes(),"ISO8859-1");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        response.setHeader("content-type", "application/octet-stream");
        response.setContentType("application/octet-stream");
        response.setHeader("Content-Disposition", "attachment;filename=" +  fileName);
        byte[] buff = new byte[1024];
        BufferedInputStream bis = null;
        OutputStream os = null;
        try {
            os = response.getOutputStream();
            bis = new BufferedInputStream(new FileInputStream(path+attach.getPath()));
            int i = bis.read(buff);
            while (i != -1) {
                os.write(buff, 0, buff.length);
                os.flush();
                i = bis.read(buff);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (bis != null) {
                try {
                    bis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    }