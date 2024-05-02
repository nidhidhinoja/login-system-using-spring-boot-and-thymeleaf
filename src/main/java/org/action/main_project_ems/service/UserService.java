package org.action.main_project_ems.service;

import org.action.main_project_ems.model.UserDtls;

public interface UserService{
    public UserDtls createUser(UserDtls user);

    public boolean checkEmail(String email);
}
