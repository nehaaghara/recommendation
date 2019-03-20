/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.damani.repoimpl;

import com.damani.dal.CommonDAO;
import com.damani.dal.OperationTypeEnum;
import com.damani.model.TblUser;
import com.damani.repo.AuthenticationRepo;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author ITMCS-PC
 */
@Repository
public class AuthenticationRepoImpl implements  AuthenticationRepo{

    @Autowired
    CommonDAO commonDAO;
    
    @Override
    public void registrationrepo(TblUser tbluser) {
    
        commonDAO.saveOrUpdate(tbluser);
        
    }

        @Override
    public List<TblUser> loginrepo(TblUser tbluser) {
       List<TblUser> lstuser=commonDAO.findEntity(TblUser.class,"emailAddress",OperationTypeEnum.EQ,tbluser.getEmailAddress(),"password",OperationTypeEnum.EQ,tbluser.getPassword());
       return lstuser;
    }
    
}
