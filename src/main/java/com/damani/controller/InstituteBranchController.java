/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.damani.controller;

import com.damani.model.TblInstituteBranch;
import com.damani.service.BranchService;
import com.damani.service.InstituteBranchService;
import com.damani.service.InstituteService;
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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 *
 * @author ITMCS
 */
@Controller
public class InstituteBranchController {

    @Autowired
    BranchService branchService;

    @Autowired
    InstituteService instituteService;

    @Autowired
    InstituteBranchService instituteBranchService;

    @RequestMapping(value = "/addinstitutebranch", method = RequestMethod.GET)
    public String addInstituteBranch(HttpServletRequest request, Model model) {
        model.addAttribute("tblInstituteBranch", new TblInstituteBranch());
        model.addAttribute("lstBranches", branchService.showbranchservice());
        model.addAttribute("lstInstitute", instituteService.fetchAllInstitute());
        return "com.damani.addInstituteBranch";
    }

    @RequestMapping(value = "/viewinstitutebranch", method = RequestMethod.GET)
    public String viewInstituteBranch(Model model) {
        List<TblInstituteBranch> lstInstituteBranch = instituteBranchService.fetchAllInstituteBranch();
        model.addAttribute("lstInstituteBranch", lstInstituteBranch);
        return "com.damani.viewInstituteBranch";
    }

    @RequestMapping(value = "/saveinstitutebranch", method = RequestMethod.POST)
    public String saveInstituteBranch(@ModelAttribute("tblInstituteBranch") TblInstituteBranch addTblInstituteBranch, HttpServletRequest request, RedirectAttributes redirectAttributes) {
        String response = null;
        if (addTblInstituteBranch.getInstitutebranchPK() == null) {
            response = instituteBranchService.saveInstituteBranch(addTblInstituteBranch);
            redirectAttributes.addFlashAttribute("SuccessMessage", response);
        } else {
            response = instituteBranchService.updateInstituteBranchById(addTblInstituteBranch);
              redirectAttributes.addFlashAttribute("UpdateMessage", response);
        }
        if (request.getParameter("save") != null) {
            return "redirect:/viewinstitutebranch";
        } else if (request.getParameter("saveAndNew") != null) {
            return "redirect:/addinstitutebranch";
        }
        return "com.damani.viewinstitutebranch";
    }

    @RequestMapping(value = "/editinstitutebranch/{institutebranchPK}", method = RequestMethod.GET)
    public String editInstituteBranch(Model model, @PathVariable("institutebranchPK") BigInteger institutebranchPK) {
        Object response = instituteBranchService.fetchInstituteBranchById(institutebranchPK);
        model.addAttribute("tblInstituteBranch", response);
        return "redirect:/viewinstitutebranch";
    }

    @RequestMapping(value = "/deleteinstitutebranch/{institutebranchPK}", method = RequestMethod.GET)
    public String deleteInstituteBranch(@PathVariable("institutebranchPK") BigInteger institutebranchPK,RedirectAttributes redirectAttributes) {
       String response =  instituteBranchService.deleteInstituteBranchById(institutebranchPK);
       redirectAttributes.addFlashAttribute("DeleteMessage",response);
        return "redirect:/viewinstitutebranch";
    }

    @RequestMapping(value = "updateinstitutebranch/{institutebranchPK}", method = RequestMethod.POST)
    public String updateInstituteBranch(@PathVariable("institutebranchPK") BigInteger institutebranchPK, @ModelAttribute("tblInstituteBranch") TblInstituteBranch updateInstituteBranch) {
        instituteBranchService.updateInstituteBranchById(updateInstituteBranch);
        return "redirect:/viewinstitutebranch";
    }
}
