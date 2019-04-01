/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.damani.serviceimpl;

import com.damani.model.TblUser;
import com.damani.repo.UserProfileRepository;
import com.damani.service.UserProfileService;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author ITMCS
 */
@Service
public class UserProfileServiceImpl implements UserProfileService{

    @Autowired
    UserProfileRepository userProfileRepository;
    
    @Override
    public String updateProfileInformation(TblUser tblUser, HttpServletRequest request) {
        TblUser oldValue = userProfileRepository.fetchById(tblUser.getUserid());
        oldValue.setFullname(tblUser.getFullname());
        oldValue.setUserName(tblUser.getUserName());
        oldValue.setEmailAddress(tblUser.getEmailAddress());
        userProfileRepository.updateProfileInformation(tblUser);
        return "Profile Information Updated Successfully";
    }
    
}
