package com.jianpanmao.intermediary.service.impl;

import com.jianpanmao.common.service.impl.BaseServiceImpl;
import com.jianpanmao.exception.CustomException;
import com.jianpanmao.intermediary.entity.*;
import com.jianpanmao.intermediary.dto.*;
import com.jianpanmao.intermediary.service.IntermediaryService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class IntermediaryServiceImpl extends BaseServiceImpl<Intermediary, IntermediaryExample, IntermediaryDto, Integer> implements IntermediaryService {

    @Override
    @Transactional
    public int removeI(Integer TId) throws CustomException {
        Intermediary intermediary = super.get(TId);
        if (intermediary.getIsPlat().intValue() == 1) {
            throw new CustomException("该条数据不允许被删除");
        }
        return super.remove(TId);
    }
    
    @Override
    @Transactional
    public int removeBatchI(Integer[] ids) throws CustomException {
        for (Integer id : ids) {
            Intermediary intermediary = super.get(id);
            if (intermediary.getIsPlat().intValue() == 1) {
                throw new CustomException("该条数据不允许被删除");
            }
        }
        return super.removeBatch(ids);
    }
}