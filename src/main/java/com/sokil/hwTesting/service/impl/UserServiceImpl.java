package com.sokil.hwTesting.service.impl;

import com.sokil.hwTesting.DAO.IUserDAO;
import com.sokil.hwTesting.entity.User;
import com.sokil.hwTesting.service.IUserService;
import com.sokil.hwTesting.service.SecurityService;

public class UserServiceImpl implements IUserService{
    private IUserDAO userDAO;
    private SecurityService securityService;

    public UserServiceImpl(IUserDAO userDAO, SecurityService securityService) {
        this.userDAO = userDAO;
        this.securityService = securityService;
    }

    @Override
    public void assignPassword(User user) {
        String passwordMD5 = securityService.md5(user.getPassword());
        user.setPassword(passwordMD5);
        userDAO.updateUser(user);
    }
}
