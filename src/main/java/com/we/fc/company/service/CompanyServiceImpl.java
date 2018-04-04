package com.we.fc.company.service;

import com.we.fc.base.BaseDao;
import com.we.fc.base.BaseServiceImpl;
import com.we.fc.company.dao.CompanyDao;
import com.we.fc.company.entity.Company;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author zdc
 * @since 2018-04-01 11:06
 */
@Service
@Transactional
public class CompanyServiceImpl extends BaseServiceImpl<Company> implements CompanyService {

    @Autowired private CompanyDao companyDao;

    @Override
    public BaseDao<Company> getDao() {
        return companyDao;
    }
}
