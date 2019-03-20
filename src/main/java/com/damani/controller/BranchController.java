/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.damani.controller;

import com.damani.model.TblBranch;
import com.damani.service.BranchService;
import java.math.BigInteger;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 *
 * @author ITMCS-PC
 */
@Controller
public class BranchController {

    @Autowired
    BranchService branchservice;

    ModelAndView mv = new ModelAndView();

    @RequestMapping(value = "/addBranch", method = RequestMethod.GET)
    public String addBranch(Model model) {
        model.addAttribute("tblBranch", new TblBranch());
        return "com.damani.addBranch";
    }

    @RequestMapping(value = "/saveBranch", method = RequestMethod.POST)
    public ModelAndView saveBranchController(@ModelAttribute("tblBranch") TblBranch tblbranch, HttpServletRequest req) {
        tblbranch.setIsActive(1);
        if (tblbranch.getBranchPK() == null) {
            branchservice.addbranchservice(tblbranch);
         } else {
            branchservice.updatebranchservice(tblbranch);
        }
        if (req.getParameter("save") != null) {
            mv.setViewName("redirect:/viewbranch");
        } else if (req.getParameter("saveAndNew") != null) {
            mv.setViewName("redirect:/addBranch");
        }

        mv.setViewName("redirect:/viewbranch");
        return mv;
    }

    @RequestMapping("/viewbranch")
    public ModelAndView showbranchcontroller() {
        List<TblBranch> lstbranch = branchservice.showbranchservice();
        mv.addObject("lstbranch", lstbranch);
        mv.setViewName("com.damani.viewBranch");
        return mv;
    }

    @RequestMapping(value = "/editbranch/{Branchid}")
    public ModelAndView editbranchcontroller(@PathVariable("Branchid") BigInteger branchid, Model model) {
        List<TblBranch> lstbranch = branchservice.editbranchservice(branchid);

        mv.addObject("tblBranch", lstbranch.get(0));
        mv.setViewName("com.damani.addBranch");
        return mv;
    }

    @RequestMapping(value = "/deletebranch/{Branchid}")
    public ModelAndView deletebranchcontroller(@PathVariable("Branchid") BigInteger branchid, Model model) {
        branchservice.deletebranchservice(branchid);
        mv.setViewName("redirect:/viewbranch");
        return mv;
    }
}
