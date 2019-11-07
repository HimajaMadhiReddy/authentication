package com.ucm.authentication.service;


import com.ucm.authentication.exceptions.DuplicateRecordException;
import com.ucm.authentication.exceptions.InvalidRequestException;
import com.ucm.authentication.exceptions.ResourceNotFoundException;
import com.ucm.authentication.model.dao.Authentication;
import com.ucm.authentication.repository.AuthenticationRepository;
import com.ucm.authentication.transformer.DaoToDtoTransformer;
import com.ucm.authentication.transformer.DtoToDaoTransformer;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class AuthenticationService {

    @Autowired
    AuthenticationRepository authenticationRepository;

    public com.ucm.authentication.model.dto.Authentication validateCreateRequest(com.ucm.authentication.model.dto.Authentication authentication) throws DuplicateRecordException, InvalidRequestException {

        if(StringUtils.isBlank(authentication.getPassword())){
            throw new InvalidRequestException("Please enter correct username");
        }

        if(StringUtils.isBlank(authentication.getPassword())|| authentication.getPassword().length()<8){
            throw new InvalidRequestException("please enter correct password");
        }
        if(authenticationRepository.findAuthenticationByUserNameAndPassword(authentication.getUserName(),authentication.getPassword()) != null){
            throw new DuplicateRecordException("Document already exist with this username and password");
        }

        if(authenticationRepository.findByUserName(authentication.getUserName())!= null){

            throw new InvalidRequestException("Username already exists");

        }



        Authentication authenticationDao = DtoToDaoTransformer.dtoToDao(authentication);

        authenticationDao.setResourceId(UUID.randomUUID());

       authenticationDao = authenticationRepository.save(authenticationDao);

       return DaoToDtoTransformer.daoToDto(authenticationDao);

    }
    public com.ucm.authentication.model.dto.Authentication getUserByUserNameAndPassword(String userName, String password) throws InvalidRequestException, ResourceNotFoundException {

        if(StringUtils.isBlank(userName)){
            throw new InvalidRequestException("Please enter username");

        }
        if(StringUtils.isBlank(password)){
            throw  new InvalidRequestException("Please enter password");
        }

        Authentication authentication = authenticationRepository.findAuthenticationByUserNameAndPassword(userName, password);

        if(authentication == null){
            throw new ResourceNotFoundException("Resource not exists with the provided username and password");
        }

        return DaoToDtoTransformer.daoToDto(authentication);

    }

    public com.ucm.authentication.model.dto.Authentication getByResourceId(String resourceId) throws InvalidRequestException, ResourceNotFoundException {
       try {
           UUID.fromString(resourceId);
       }catch (Exception ex){
           throw  new InvalidRequestException("please enter valid resourceId"+ resourceId + " doesn't exist");
       }

       Authentication authenticationDao = authenticationRepository.findByResourceId(UUID.fromString(resourceId));

       if (authenticationDao == null){
           throw  new  ResourceNotFoundException("authentication with the given resourceId " + resourceId+ " doesn't exist");
       }
     return DaoToDtoTransformer.daoToDto(authenticationDao);
    }
}
