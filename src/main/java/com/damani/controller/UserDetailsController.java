/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.damani.controller;

import com.damani.model.TblResult;
import com.damani.model.TblUserDetails;
import com.damani.service.UserDetailsService;
import java.math.BigInteger;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author ITMCS-PC
 */
@Controller
public class UserDetailsController {
    
    @Autowired
    UserDetailsService userDetailsService;
    
    ModelAndView mv=new ModelAndView();
    
    @RequestMapping(value = "/userdetail123" , method = RequestMethod.GET)
    public ModelAndView savedataandshowresult(HttpServletRequest req)
    {
        System.out.println("hy my name is hingu vikas in vontroller");
       String name=req.getParameter("name");
       String email=req.getParameter("email");
       BigInteger phone=new BigInteger(req.getParameter("phone"));
       String field=req.getParameter("field");
       int score=Integer.parseInt(req.getParameter("studentscore"));
       TblUserDetails tblUserDetails=new TblUserDetails();
       tblUserDetails.setStudentname(name);
       tblUserDetails.setEmail(email);
       tblUserDetails.setPhone(phone);
       tblUserDetails.setField(field);
       tblUserDetails.setScore(score);
       
    List<TblResult> lstresultofstudent = userDetailsService.savedataandshowresultservice(tblUserDetails);
        System.out.println("lstresultofstudent"+lstresultofstudent.size());
      mv.addObject("lstresultofstudent" , lstresultofstudent);
      mv.setViewName("view/User/showfinalresult");
       return mv;
    }
    
}
