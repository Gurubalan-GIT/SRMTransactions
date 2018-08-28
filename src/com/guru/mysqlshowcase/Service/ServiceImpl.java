package com.guru.mysqlshowcase.Service;
import com.guru.mysqlshowcase.DAO.DAOImpl;
import com.guru.mysqlshowcase.LoginDTO.Bean;
import com.guru.mysqlshowcase.RegisterDTO.RegisterBean;

interface Service {
Boolean doLoginService(Bean bean);
int doRegisterService(RegisterBean registerBean);
}
public class ServiceImpl implements Service {
    @Override
    public Boolean doLoginService(Bean bean) {
        DAOImpl loginDao=new DAOImpl();
        Boolean result=loginDao.doLogin(bean);
        return result;
    }

    @Override
    public int doRegisterService(RegisterBean registerBean) {
        DAOImpl registerDao=new DAOImpl();
        int result=registerDao.doRegister(registerBean);
        return result;
    }
}
