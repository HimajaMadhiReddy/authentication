package com.ucm.authentication.transformer;

import com.ucm.authentication.model.dto.Authentication;

public class DaoToDtoTransformer {

    public static Authentication daoToDto(com.ucm.authentication.model.dao.Authentication authentication){

        Authentication authenticationDto = new Authentication();

        authenticationDto.setUserName(authentication.getUserName());
        authenticationDto.setPassword(authentication.getPassword());
        authenticationDto.setRole(authentication.getRole());
        authenticationDto.setResourceId(authentication.getResourceId());
        authenticationDto.setPersonResourceId(authentication.getPersonResourceId());

        return authenticationDto;
    }
}
