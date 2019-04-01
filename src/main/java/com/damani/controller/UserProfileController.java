/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.damani.controller;

import com.damani.model.TblUser;
import com.damani.service.UserProfileService;
import java.math.BigInteger;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author ITMCS
 */
@Controller
public class UserProfileController {
    @Autowired
    UserProfileService userProfileService;
    
    @RequestMapping(value = "/profileInformation", method = RequestMethod.GET)
    public String profile(Model model, HttpServletRequest request) {
        model.addAttribute("tblUser", new TblUser());
        return "com.damani.userProfile";
    }

    @RequestMapping(value = "/updateprofile/{userid}", method = RequestMethod.POST)
    public String UpdateProfileInformation(@PathVariable("userid") BigInteger userid, HttpServletRequest request, @ModelAttribute("tblUser") TblUser updateUser) {
       userProfileService.updateProfileInformation(updateUser, request);
        return "redirect:/dashboard";
    }
}
