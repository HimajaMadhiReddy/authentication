package com.ucm.authentication.repository;


import com.ucm.authentication.model.dao.Authentication;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.UUID;

public interface AuthenticationRepository extends MongoRepository <Authentication,String>{

    Authentication findAuthenticationByUserNameAndPassword(String userName,String password);

    Authentication findByUserName(String userName);

    Authentication findByResourceId(UUID resourceId);
}
