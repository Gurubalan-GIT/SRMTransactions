package com.guru.mysqlshowcase.Service;
import com.guru.mysqlshowcase.DAO.DAOImpl;
import com.guru.mysqlshowcase.DTO.LoginDTO.Bean;
import com.guru.mysqlshowcase.DTO.RegisterDTO.RegisterBean;

interface Service {
Bean doLoginService(Bean bean);
RegisterBean doRegisterService(RegisterBean registerBean);
}
public class ServiceImpl implements Service {
    @Override
    public Bean doLoginService(Bean bean) {
        DAOImpl loginDao=new DAOImpl();
        Bean result=loginDao.doLogin(bean);
        return result;
    }

    @Override
    public RegisterBean doRegisterService(RegisterBean registerBean) {
        DAOImpl registerDao=new DAOImpl();
        RegisterBean result=registerDao.doRegister(registerBean);
        return result;
    }
}
