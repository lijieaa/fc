package com.we.fc.wechat.service;

import com.we.fc.base.BaseService;
import com.we.fc.wechat.entity.WxMaterial;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author zdc
 * @since 2018-05-02 21:12
 */
public interface WxMaterialService extends BaseService<WxMaterial> {

    void insert(WxMaterial wxMaterial, String accessToken, MultipartFile multipartFile) throws Exception;
}
