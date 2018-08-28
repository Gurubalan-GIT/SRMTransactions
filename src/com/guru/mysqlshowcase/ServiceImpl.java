package com.guru.mysqlshowcase;

import com.guru.mysqlshowcase.login.Bean;

interface Service {
Boolean doLoginService(Bean bean);
}
public class ServiceImpl implements Service {
    @Override
    public Boolean doLoginService(Bean bean) {
        DAOImpl dao=new DAOImpl();
        Boolean result=dao.doLogin(bean);
        return result;
    }
}
