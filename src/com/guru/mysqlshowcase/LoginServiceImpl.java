package com.guru.mysqlshowcase;
interface LoginService{
Boolean doLoginService(Bean bean);
}
public class LoginServiceImpl implements LoginService {
    @Override
    public Boolean doLoginService(Bean bean) {
        DAOImpl dao=new DAOImpl();
        Boolean result=dao.doLogin(bean);
        return result;
    }
}
