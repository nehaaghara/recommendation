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
import com.damani.model.TblUser;
import com.damani.service.AllInstituteWiseBranchService;
import com.damani.service.AuthenticationService;
import com.damani.service.InstituteService;
import com.damani.service.ResultService;
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
public class IndexController {

    @Autowired
    InstituteService instituteService;

    @Autowired
    AuthenticationService authenticationService;

    @Autowired
    AllInstituteWiseBranchService allInstituteWiseBranchService;

    @Autowired
    ResultService resultService;

    ModelAndView mv = new ModelAndView();

    @RequestMapping(value = "/")
    public String index() {
        return "redirect:/loginindex";
    }

    @RequestMapping(value = "/dashboard")
    public String dashboard(Model model, HttpServletRequest request) {
        List<TblInstitute> lstInstitute = instituteService.fetchAllInstitute();
        model.addAttribute("lstInstitutes", lstInstitute);

        TblUser tblUser = (TblUser) request.getSession(false).getAttribute("UserSession");
        tblUser.setUserid(tblUser.getUserid());
        List<TblUser> lstUser = authenticationService.fetchAllUser();
        model.addAttribute("lstUser", lstUser);

        Map<TblInstitute, List<TblInstituteBranch>> AllInstituteWiseBranch = allInstituteWiseBranchService.AllInstituteWiseBranchservice();
        List<TblResult> lstallresult = resultService.viewresultservice();
        model.addAttribute("lstallresult", lstallresult);
        model.addAttribute("AllInstituteWiseBranch", AllInstituteWiseBranch);
        return "com.damani.adminIndex";
    }

    @RequestMapping(value = "/loginindex")
    public String login() {
        return "/login/userLogin";
    }

    @RequestMapping(value = "/registrationindex")
    public String registration() {
        return "/login/registration";
    }

    @RequestMapping(value = "/logout")
    public String logout(HttpServletRequest request) {
        HttpSession session = request.getSession();
        session.invalidate();
        return "redirect:/loginindex";
    }

    
    @RequestMapping(value = "/forgotpageindex")
    public String forgot(HttpServletRequest req) {
        return "/login/forgot";
    }


}
