/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.damani.service;

import com.damani.model.TblUser;
import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Service;

/**
 *
 * @author ITMCS
 */
@Service
public interface UserProfileService {
     public String updateProfileInformation(TblUser tblUser,HttpServletRequest request);
}
