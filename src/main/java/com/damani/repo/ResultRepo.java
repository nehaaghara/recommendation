/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.damani.repo;

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
public interface ResultRepo {
    
    public  Map<List<TblInstitute>,List<TblBranch>> resultpagedatarepo();
    public void savedatainresulttablerepo(TblResult tblresult);
     List<TblInstituteBranch> instituteidwisebranchajaxrepo(BigInteger instituteid);
     List<TblResult> viewresultrepo();
     public TblResult editresultdatarepo(BigInteger resultid);
     public void deleteresultdatarepo(BigInteger resultid);
}
