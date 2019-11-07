package com.ucm.authentication.transformer;

import com.ucm.authentication.model.dao.Authentication;

public class DtoToDaoTransformer {

    public static Authentication dtoToDao(com.ucm.authentication.model.dto.Authentication authentication){

        Authentication authenticationDao = new Authentication();
        authenticationDao.setPassword(authentication.getPassword());
        authenticationDao.setUserName(authentication.getUserName());
        authenticationDao.setRole(authentication.getRole());
        authenticationDao.setPersonResourceId(authentication.getPersonResourceId());

        return authenticationDao;
    }
}
