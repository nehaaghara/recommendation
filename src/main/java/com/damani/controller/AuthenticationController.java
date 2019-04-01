/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.damani.controller;

import com.damani.model.TblBranch;
import com.damani.model.TblInstitute;
import com.damani.model.TblRole;
import com.damani.model.TblUser;
import com.damani.service.AuthenticationService;
import com.damani.service.ResultService;
import java.math.BigInteger;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 *
 * @author ITMCS-PC
 */
@Controller
public class AuthenticationController {

    @Autowired
    AuthenticationService authenticationService;
    
      
    @Autowired
    ResultService resultService;

    ModelAndView mv=new ModelAndView();
    
   
    @RequestMapping(value = "/loginpage")
    public String login(Model model, HttpServletRequest req,RedirectAttributes redirectAttributes) {
        String emailAddress = req.getParameter("emailAddress");
        String password = req.getParameter("password");
        TblUser tbluser = new TblUser();
        tbluser.setEmailAddress(emailAddress);
        tbluser.setPassword(password);
        List<TblUser> lstuser = authenticationService.loginservice(tbluser);
<<<<<<< HEAD
        System.out.println("lstUser::"+lstuser);
=======
        System.out.println("lstUser::" + lstuser);
>>>>>>> 8cb771aabecfe53cda6a2c8bedf1f02124e8de79
        HttpSession session = req.getSession(true);
        lstuser.get(0).setUserName(lstuser.get(0).getUserName());
        System.out.println("role::" + lstuser.get(0).getRoleFk().getRolePk());
        session.setAttribute("UserSession", lstuser.get(0));
        if (!lstuser.isEmpty()) {
            System.out.println("in controller");
            if (lstuser.get(0).getRoleFk().getRolePk().equals(new BigInteger("1"))) {
                return "redirect:/dashboard";
            }
           if (lstuser.get(0).getRoleFk().getRolePk().equals(new BigInteger("2"))) {
                  Map<List<TblInstitute>, List<TblBranch>> allinstituteandbranch=resultService.resultpagedataservice();
                  model.addAttribute("allinstituteandbranch", allinstituteandbranch);
                  return "view/User/userauthentication";
            }
        }
        return "redirect:/loginindex";
    }
    

    @RequestMapping("/registerpage")
    public String register(Model model,HttpServletRequest req) {
        TblRole tblRole = new TblRole();
        tblRole.setRolePk(new BigInteger("2"));
        String fullname = req.getParameter("fullname");
        String username = req.getParameter("userName");
        String Email = req.getParameter("emailAddress");
        String password = req.getParameter("password");
        String conformpassword = req.getParameter("conformpassword");
        TblUser tblUser = new TblUser();
        tblUser.setFullname(fullname);
        tblUser.setUserName(username);
        tblUser.setEmailAddress(Email);
        tblUser.setPassword(password);
        tblUser.setConformpassword(conformpassword);
        tblUser.setRoleFk(tblRole);
        authenticationService.registrationservice(tblUser);
        return "redirect:/loginindex";
       
    }
    
      @RequestMapping(value = "/forgotproccess")
    public ModelAndView forgotfunctionality(HttpServletRequest req) {
        String email = req.getParameter("emailAddress");
        String pass = req.getParameter("password");
        String conformpass = req.getParameter("conformpassword");
        if (pass.equals(conformpass)) {
            String forgotuser = authenticationService.forgotfunctionalityservice(email, pass, conformpass);
            if(forgotuser.equals("successforgot")){
                  mv.addObject("result", "succ");
                  mv.addObject("forgotuser", forgotuser);
                  mv.setViewName("redirect:/loginindex");
            }
            else
            {
                 mv.addObject("result", "notvelidemailid");
                 mv.setViewName("redirect:/forgotpageindex");
            }
          
        } else {
            mv.addObject("result", "notsucc");
            mv.setViewName("redirect:/forgotpageindex");
        }
        return mv;        
    }
}
