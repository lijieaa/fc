package com.jianpanmao.wechat.service;

import com.jianpanmao.wechat.api.news.WxNewsContent;
import com.jianpanmao.wechat.base.BaseService;
import com.jianpanmao.wechat.entity.WxMaterial;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author zdc
 * @since 2018-05-02 21:12
 */
public interface WxMaterialService extends BaseService<WxMaterial> {

    void insert(WxMaterial wxMaterial, String accessToken, MultipartFile multipartFile) throws Exception;

    void insertWxNews(WxNewsContent wxNewsContent, String accessToken) throws Exception;

    WxMaterial findByMediaId(String mediaId);
}
