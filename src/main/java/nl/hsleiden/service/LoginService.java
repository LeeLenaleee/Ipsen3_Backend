package nl.hsleiden.service;

import nl.hsleiden.model.LoginUser;
import nl.hsleiden.model.User;
import nl.hsleiden.persistence.LoginDao;
import nl.hsleiden.persistence.UserDAO;

import javax.inject.Inject;
import java.util.Collection;

public class LoginService extends BaseService<User>{
    private final LoginDao dao;
    private final UserDAO userDao;
    User user;

    @Inject
    public LoginService(LoginDao dao, UserDAO userDAO)
    {
        this.dao = dao;
        this.userDao = userDAO;
    }

    public boolean checkLogin(LoginUser loginUser){
        LoginUser check = dao.getUser(loginUser.getEmail());
        if (loginUser.getPassword().equals(check.getPassword())){
            this.user = userDao.getByEmailAddress(loginUser.getEmail());
            return true;
        }else {
            return false;
        }
    }

    public User getUser(){
        return this.user;

    }
}
