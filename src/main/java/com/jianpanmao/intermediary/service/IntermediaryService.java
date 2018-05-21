package com.jianpanmao.intermediary.service;

import com.jianpanmao.common.service.BaseService;
import com.jianpanmao.exception.CustomException;
import com.jianpanmao.intermediary.entity.*;
import com.jianpanmao.intermediary.dto.*;




public interface IntermediaryService extends BaseService<Intermediary, IntermediaryExample,IntermediaryDto,Integer>{
    public int removeI(Integer TId) throws CustomException;
    public int removeBatchI(Integer[] ids) throws CustomException;
}