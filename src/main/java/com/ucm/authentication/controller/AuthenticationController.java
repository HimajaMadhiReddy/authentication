package com.ucm.authentication.controller;

import com.ucm.authentication.exceptions.DuplicateRecordException;
import com.ucm.authentication.exceptions.InvalidRequestException;
import com.ucm.authentication.exceptions.ResourceNotFoundException;
import com.ucm.authentication.model.dto.Authentication;
import com.ucm.authentication.service.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/authentications")
public class AuthenticationController {


    @Autowired
    AuthenticationService authenticationService;

    @ResponseBody
    @RequestMapping(method = RequestMethod.POST,produces = "application/json",consumes = "application/json")
    Authentication createAuthentication(@RequestBody Authentication authentication) throws DuplicateRecordException, InvalidRequestException {

        return authenticationService.validateCreateRequest(authentication);

    }

    @RequestMapping(value = "/{userName}/{password}",produces = "application/json")
    @ResponseBody
    Authentication getAuthentication(@PathVariable String userName, @PathVariable String password) throws InvalidRequestException, ResourceNotFoundException {

        return authenticationService.getUserByUserNameAndPassword(userName, password);
    }
    @ResponseBody
    @RequestMapping(value = "/{resourceId}",produces = "application/json")
    Authentication getByResouceId(@PathVariable String resourceId) throws InvalidRequestException, ResourceNotFoundException {

        return authenticationService.getByResourceId(resourceId);

    }

}
