package com.we.fc.intermediary.service;

import com.we.fc.base.BaseService;
import com.we.fc.intermediary.entity.Intermediary;

import java.util.List;

/**
 * Created by mayn on 2018/4/11.
 */
public interface IntermediaryService extends BaseService<Intermediary> {
    List<Intermediary> queryPage(String intermediaryName);
}
