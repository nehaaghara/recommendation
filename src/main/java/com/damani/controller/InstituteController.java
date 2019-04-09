/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.damani.controller;

import com.damani.model.TblBranch;
import com.damani.model.TblBranchMapping;
import com.damani.model.TblInstitute;
import com.damani.model.TblUser;
import com.damani.service.BranchMappingService;
import com.damani.service.BranchService;
import com.damani.service.InstituteService;
import com.damani.webbean.InstituteBean;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Date;
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
public class InstituteController {

    @Autowired
    InstituteService instituteService;

    @Autowired
    BranchService branchService;

    @Autowired
    BranchMappingService branchMappingService;

    @RequestMapping(value = "/addinstitute", method = RequestMethod.GET)
    public String addInstitute(Model model) {
        List<TblBranch> lstBranch = branchService.showbranchservice();
        model.addAttribute("lstBranch", lstBranch);
        InstituteBean instituteBean = new InstituteBean();
        List<BigInteger> lstBranchBigInteger = new ArrayList<>();
        for (TblBranch tblBranch : lstBranch) {
            lstBranchBigInteger.add(tblBranch.getBranchPK());
        }
        instituteBean.setBranches(lstBranchBigInteger);
        model.addAttribute("tblInstitutes", instituteBean);
        return "com.damani.addInstitute";
    }

    @RequestMapping(value = "/viewinstitute", method = RequestMethod.GET)
    public String viewInstitute(Model model) {
        List<TblInstitute> lstInstitutes = instituteService.fetchAllInstitute();
        model.addAttribute("lstInstitutes", lstInstitutes);
        return "com.damani.viewInstitute";
    }

    @RequestMapping(value = "/saveinstitute", method = RequestMethod.POST)
    public String saveInstitute(@ModelAttribute("tblInstitutes") InstituteBean addInstitute, HttpServletRequest request, RedirectAttributes redirectAttributes) {

        TblUser tblUser = (TblUser) request.getSession(false).getAttribute("UserSession");
        tblUser.setUserid(tblUser.getUserid());
        addInstitute.getTblInstitute().setCreatedBy(tblUser);
        addInstitute.getTblInstitute().setCreatedOn(new Date());

        List<TblBranchMapping> lstBranchBigInteger = new ArrayList<>();

        String response = null;
        if (addInstitute.getTblInstitute().getInstitutePk() == null) {
            response = instituteService.saveInstitute(addInstitute.getTblInstitute(), tblUser);
            redirectAttributes.addFlashAttribute("SuccessMessage", response);
            for (BigInteger branch : addInstitute.getBranches()) {
                TblBranch tblBranch = new TblBranch();
                tblBranch.setBranchPK(branch);
                TblBranchMapping tblBranchMapping = new TblBranchMapping();
                tblBranchMapping.setBranchFk(tblBranch);
                tblBranchMapping.setInstituteFk(addInstitute.getTblInstitute());
                tblBranchMapping.setCreatedBy(tblUser);
                tblBranchMapping.setCreatedOn(new Date());
                lstBranchBigInteger.add(tblBranchMapping);
            }
            branchMappingService.saveBranch(lstBranchBigInteger);
        } else {
            response = instituteService.updateInstituteById(addInstitute.getTblInstitute(), tblUser);
            redirectAttributes.addFlashAttribute("UpdateMessage", response);
            for (BigInteger branch : addInstitute.getBranches()) {
                  for (BigInteger branchPk : addInstitute.getBranches()) {
                    TblBranch tblBranch = new TblBranch();
                    tblBranch.setBranchPK(branchPk);
                    TblBranchMapping tblBranchMapping = new TblBranchMapping();
                    tblBranchMapping.setBranchFk(tblBranch);
                    tblBranchMapping.setInstituteFk(addInstitute.getTblInstitute());
                    tblBranchMapping.setCreatedBy(tblUser);
                    tblBranchMapping.setCreatedOn(new Date());
                    lstBranchBigInteger.add(tblBranchMapping);
                }
                branchMappingService.updateBranchById(lstBranchBigInteger, addInstitute.getTblInstitute().getInstitutePk());
            }
        }
        if (request.getParameter("save") != null) {
            return "redirect:/viewinstitute";
        } else if (request.getParameter("saveAndNew") != null) {
            return "redirect:/addinstitute";
        }
        return "redirect:/viewinstitute";
    }

    @RequestMapping(value = "/editinstitute/{institutePk}", method = RequestMethod.GET)
    public String editInstitute(@PathVariable("institutePk") BigInteger institutePk, HttpServletRequest request,
            Model model
    ) {
        List<TblBranch> lstBranch = branchService.showbranchservice();
        model.addAttribute("lstBranch", lstBranch);
        InstituteBean instituteBean = new InstituteBean();
        List<BigInteger> lstBranchBigInteger = new ArrayList<>();
        for (TblBranch tblBranch : lstBranch) {
            lstBranchBigInteger.add(tblBranch.getBranchPK());
        }
        instituteBean.setBranches(lstBranchBigInteger);

        TblInstitute tblInstitute = instituteService.fetchInstituteById(institutePk);
        instituteBean.setTblInstitute(tblInstitute);

        List<TblBranchMapping> lstBranchByInstitute = branchMappingService.fetchBranchById(institutePk);
        instituteBean.setLstTblBranchMappings(lstBranchByInstitute);
        model.addAttribute("tblInstitutes", instituteBean);
        model.addAttribute("lstBranchById", lstBranchByInstitute);
        return "com.damani.addInstitute";
    }

    @RequestMapping(value = "/deleteinstitute/{institutePk}", method = RequestMethod.GET)
    public String deleteInstitute(@PathVariable("institutePk") BigInteger institutePk, HttpServletRequest request
    ) {
        instituteService.deleteInstituteById(institutePk);
        return "redirect:/viewinstitute";
    }

    @RequestMapping(value = "/updateinstitute/{institutePk}", method = RequestMethod.POST)
    public String updateInstitute(@ModelAttribute("tblInstitute") InstituteBean updateInstitute, @PathVariable("institutePk") BigInteger institutePk, HttpServletRequest request, RedirectAttributes redirectAttributes) {
        TblUser tblUser = (TblUser) request.getSession(false).getAttribute("UserSession");
        tblUser.setUserid(tblUser.getUserid());
        instituteService.updateInstituteById(updateInstitute.getTblInstitute(), tblUser);
        return "redirect:/viewinstitute";
    }

}
