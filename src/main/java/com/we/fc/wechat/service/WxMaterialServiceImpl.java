package com.we.fc.wechat.service;

import com.we.fc.base.BaseDao;
import com.we.fc.base.BaseServiceImpl;
import com.we.fc.utils.GsonUtils;
import com.we.fc.wechat.api.WxApiHandler;
import com.we.fc.wechat.api.msg.MediaMsg;
import com.we.fc.wechat.api.news.WxNews;
import com.we.fc.wechat.api.news.WxNewsContent;
import com.we.fc.wechat.api.response.UploadResponse;
import com.we.fc.wechat.dao.WxMaterialDao;
import com.we.fc.wechat.entity.WxMaterial;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.util.Arrays;
import java.util.Date;

/**
 * @author zdc
 * @since 2018-05-02 21:13
 */

@Service
@Transactional
public class WxMaterialServiceImpl extends BaseServiceImpl<WxMaterial> implements WxMaterialService {

    @Autowired private WxMaterialDao wxMaterialDao;

    @Autowired private WxApiHandler wxApiHandler;

    @Override
    public BaseDao<WxMaterial> getDao() {
        return wxMaterialDao;
    }

    @Override
    public void insert(WxMaterial wxMaterial, String accessToken, MultipartFile multipartFile) throws Exception {

        String result = wxApiHandler.addMaterial(accessToken, wxMaterial.getType(), multipartFile,wxMaterial.getDescription());
        if(result.indexOf("errcode") != -1) throw new Exception("添加异常，" + result);
        UploadResponse uploadResponse = GsonUtils.toBean(result, UploadResponse.class);
        wxMaterial.setName(multipartFile.getOriginalFilename());
        wxMaterial.setUrl(uploadResponse.getUrl());
        wxMaterial.setMediaId(uploadResponse.getMedia_id());
        wxMaterial.setUpdateTime(new Date());
        super.insert(wxMaterial);
    }

    @Override
    public void insertWxNews(WxNewsContent wxNewsContent, String accessToken) throws Exception {

        WxNews wxNews = new WxNews();
        wxNews.setArticles(Arrays.asList(wxNewsContent));
        String result = wxApiHandler.addNewsMaterial(wxNews, accessToken);
        if(result.indexOf("errcode") != -1) throw new Exception(result);
        WxMaterial wxMaterial = new WxMaterial();
        wxMaterial.setUpdateTime(new Date());
        wxMaterial.setType("news");
        String mediaId = GsonUtils.toBean(result, MediaMsg.class).getMedia_id();
        wxMaterial.setMediaId(mediaId);
        wxMaterial.setTitle(wxNewsContent.getTitle());
        wxMaterial.setThumbMediaId(wxNewsContent.getThumb_media_id());
        wxMaterial.setAuthor(wxNewsContent.getAuthor());
        wxMaterial.setDigest(wxNewsContent.getDigest());
        wxMaterial.setShowCoverPic(wxNewsContent.getShow_cover_pic());
        wxMaterial.setContent(wxNewsContent.getContent());
        wxMaterial.setContentSourceUrl(wxNewsContent.getContent_source_url());
        super.insert(wxMaterial);
    }
}
