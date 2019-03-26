/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.damani.service;

import com.damani.model.TblBranch;
import com.damani.model.TblInstitute;
import com.damani.model.TblInstituteBranch;
import com.damani.model.TblResult;
import java.math.BigInteger;
import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Service;

/**
 *
 * @author ITMCS-PC
 */
@Service
public interface ResultService {
    
    public Map<List<TblInstitute>,List<TblBranch>> resultpagedataservice();
    public void savedatainresulttableservice(TblResult tblresult);
    public List<TblInstituteBranch> instituteidwisebranchajaxservice(BigInteger instituteid); 
    public List<TblResult> viewresultservice();
    public TblResult editresultdataservice(BigInteger resultid);
    public void deleteresultdataservice(BigInteger resultid);
}
