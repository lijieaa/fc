package com.jianpanmao.wxmaterial.dao;

import com.jianpanmao.common.dao.BaseDao;
import com.jianpanmao.wxmaterial.dto.WxMaterialDto;
import com.jianpanmao.wxmaterial.entity.WxMaterial;
import com.jianpanmao.wxmaterial.entity.WxMaterialExample;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface WxMaterialMapper extends BaseDao<WxMaterial, WxMaterialExample, WxMaterialDto, Integer> {
}