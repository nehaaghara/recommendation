/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.damani.controller;

import com.damani.model.TblBranch;
import com.damani.model.TblInstitute;
import com.damani.model.TblInstituteBranch;
import com.damani.model.TblResult;
import com.damani.service.AllInstituteWiseBranchService;
import com.damani.service.ResultService;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 *
 * @author ITMCS-PC
 */
@Controller
public class IndexController {
    
   @Autowired
    AllInstituteWiseBranchService allInstituteWiseBranchService;     
   
   @Autowired
   ResultService  resultService;         
    
    ModelAndView mv=new ModelAndView();
    
    @RequestMapping(value = "/")
    public String index() {
        return "redirect:/loginindex";
    }
   @RequestMapping(value="/dashboard")
    public ModelAndView dashboard(RedirectAttributes redirectAttributes){
      Map<TblInstitute, List<TblInstituteBranch>> AllInstituteWiseBranch =  allInstituteWiseBranchService.AllInstituteWiseBranchservice();
     List<TblResult> lstallresult= resultService.viewresultservice();
     mv.addObject("lstallresult", lstallresult);
      mv.addObject("AllInstituteWiseBranch", AllInstituteWiseBranch);
      mv.setViewName("com.damani.adminIndex");
        return mv;
    }
    @RequestMapping(value = "/loginindex")
    public String login() {
        return "/login/userLogin";
    }

    @RequestMapping(value = "/registrationindex")
    public String registration() {
        return "/login/registration";
    }
    
    @RequestMapping(value="/logout")
    public String logout(HttpServletRequest request){
        HttpSession session= request.getSession();
        session.invalidate();
        return "redirect:/loginindex";
    }
    
    @RequestMapping(value = "/forgotpageindex")
    public String forgot(HttpServletRequest req)
    {
        return "/login/forgot";
    }
   
    

}
