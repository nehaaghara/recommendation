/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.damani.serviceimpl;

import com.damani.model.TblResult;
import com.damani.model.TblUserDetails;
import com.damani.repo.UserDetailsRepo;
import com.damani.service.UserDetailsService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author ITMCS-PC
 */
@Service
public class UserDetailsServiceImpl implements UserDetailsService{

    @Autowired
    UserDetailsRepo userDetailsRepo; 
    
    @Override
    public List<TblResult> savedataandshowresultservice(TblUserDetails tblUserDetails) {
        
      return  userDetailsRepo.savedataandshowresultrepo(tblUserDetails);
        
    }
    
    
    
}
