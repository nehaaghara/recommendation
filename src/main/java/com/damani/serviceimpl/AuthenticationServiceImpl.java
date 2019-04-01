/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.damani.serviceimpl;

import com.damani.model.TblUser;
import com.damani.repo.AuthenticationRepo;
import com.damani.service.AuthenticationService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author ITMCS-PC
 */
@Service
public class AuthenticationServiceImpl implements  AuthenticationService{

    @Autowired
    AuthenticationRepo authenticationRepo;
    
    @Override
    public void registrationservice(TblUser tbluser) {
        authenticationRepo.registrationrepo(tbluser);
    }

    @Override
    public List<TblUser> loginservice(TblUser tbluser) {
        
        return authenticationRepo.loginrepo(tbluser); 
    }

    @Override
    public List<TblUser> fetchAllUser() {
        return authenticationRepo.fetchAllUser();
    }
    
}
