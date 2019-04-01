/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.damani.controller;

import com.damani.model.TblBranch;
import com.damani.model.TblInstitute;
import com.damani.model.TblResult;
import com.damani.model.TblRole;
import com.damani.service.ResultService;
import java.math.BigInteger;
import com.google.gson.Gson;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author ITMCS-PC
 */
@Controller
public class ResultController {

    @Autowired
    ResultService resultService;

    ModelAndView mv = new ModelAndView();

    @RequestMapping(value = "/resultpage", method = RequestMethod.GET)
    public ModelAndView resultpagedata() {
        Map<List<TblInstitute>, List<TblBranch>> allinstituteandbranch = resultService.resultpagedataservice();
        mv.addObject("allinstituteandbranch", allinstituteandbranch);
        mv.addObject("tblResult", new TblResult());
        mv.setViewName("com.damani.resultaddtiles");
        return mv;
    }

    @RequestMapping(value = "/vikashingu", method = RequestMethod.GET)
    public ModelAndView savedatainresulttable(@ModelAttribute("tblResult") TblResult addtblresult, HttpServletRequest req) {

        resultService.savedatainresulttableservice(addtblresult);
        if (req.getParameter("saveAndNew") != null) {
            mv.setViewName("redirect:/resultpage");
        } else if (req.getParameter("save") != null) {
            mv.setViewName("redirect:/viewresultpage");
        } else {
            mv.setViewName("redirect:/viewresultpage");
        }

        return mv;
    }

    @ResponseBody
    @RequestMapping(value = "/instituteidwisebranch", method = RequestMethod.GET)
    public String instituteidwisebranchajax(HttpServletRequest req) {

        BigInteger instituteid = new BigInteger(req.getParameter("id"));
        System.out.println("");
        return new Gson().toJson(resultService.instituteidwisebranchajaxservice(instituteid));
    }

    @RequestMapping("/viewresultpage")
    public ModelAndView viewresult() {
        
        List<TblResult> lstresult = resultService.viewresultservice();
        System.out.println("lstresult"+lstresult.size());
        mv.addObject("lstresult", lstresult);
        mv.setViewName("com.damani.resultviewtiles");
        return mv;
    }

    @RequestMapping(value = "/editresult/{resultpk}", method = RequestMethod.GET)
    public ModelAndView editresultdata(@PathVariable("resultpk") BigInteger resultid, HttpServletRequest request, Model model) {
        TblResult resultobj = resultService.editresultdataservice(resultid);
        Map<List<TblInstitute>, List<TblBranch>> allinstituteandbranch = resultService.resultpagedataservice();
        mv.addObject("allinstituteandbranch", allinstituteandbranch);
        mv.addObject("tblResult", resultobj);
        mv.setViewName("com.damani.resultaddtiles");
        return mv;

    }

    @RequestMapping(value = "/deleteresult/{resultpk}", method = RequestMethod.GET)
    public void deleteresultdata(@PathVariable("resultpk") BigInteger resultid, Model model) {
        resultService.deleteresultdataservice(resultid);
    }

}
