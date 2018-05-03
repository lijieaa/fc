package com.we.fc.wechat.service;

import com.we.fc.base.BaseDao;
import com.we.fc.base.BaseServiceImpl;
import com.we.fc.utils.GsonUtils;
import com.we.fc.wechat.api.WxApiHandler;
import com.we.fc.wechat.api.response.UploadResponse;
import com.we.fc.wechat.dao.WxMaterialDao;
import com.we.fc.wechat.entity.WxMaterial;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

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

        String result = wxApiHandler.addMaterial(accessToken, wxMaterial.getType(), multipartFile);
        UploadResponse uploadResponse = GsonUtils.toBean(result, UploadResponse.class);
        wxMaterial.setName(multipartFile.getOriginalFilename());
        wxMaterial.setUrl(uploadResponse.getUrl());
        wxMaterial.setMediaId(uploadResponse.getMedia_id());
        wxMaterial.setUpdateTime(new Date());
        super.insert(wxMaterial);
    }
}
