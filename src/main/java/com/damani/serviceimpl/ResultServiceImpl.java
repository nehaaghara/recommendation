/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.damani.serviceimpl;

import com.damani.model.TblBranch;
import com.damani.model.TblInstitute;
import com.damani.model.TblInstituteBranch;
import com.damani.model.TblResult;
import com.damani.repo.ResultRepo;
import com.damani.service.ResultService;
import java.math.BigInteger;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author ITMCS-PC
 */
@Service
public class ResultServiceImpl implements  ResultService{

    @Autowired
    ResultRepo resultRepo;
    
    @Override
    public Map<List<TblInstitute>,List<TblBranch>> resultpagedataservice() {
        
       return  resultRepo.resultpagedatarepo();
    }

    @Override
    public void savedatainresulttableservice(TblResult tblresult) {
        
        resultRepo.savedatainresulttablerepo(tblresult);
    }

    @Override
    public List<TblInstituteBranch> instituteidwisebranchajaxservice(BigInteger instituteid) {
       
        return resultRepo.instituteidwisebranchajaxrepo(instituteid);
        
    }

    @Override
    public List<TblResult> viewresultservice() {
      return  resultRepo.viewresultrepo();  
        
    }

    @Override
    public TblResult editresultdataservice(BigInteger resultid) {
       
        return  resultRepo.editresultdatarepo(resultid);
        
    }

    @Override
    public void deleteresultdataservice(BigInteger resultid) {
        
        resultRepo.deleteresultdatarepo(resultid);
    }
    
}
