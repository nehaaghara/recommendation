/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.damani.webbean;

import com.damani.model.TblBranchMapping;
import com.damani.model.TblInstitute;
import java.math.BigInteger;
import java.util.List;

/**
 *
 * @author ITMCS
 */
public class InstituteBean {

    TblInstitute tblInstitute;
    List<BigInteger> branches;
    List<TblBranchMapping> lstTblBranchMappings;

    public TblInstitute getTblInstitute() {
        return tblInstitute;
    }

    public void setTblInstitute(TblInstitute tblInstitute) {
        this.tblInstitute = tblInstitute;
    }

    public List<BigInteger> getBranches() {
        return branches;
    }

    public void setBranches(List<BigInteger> branches) {
        this.branches = branches;
    }

    public List<TblBranchMapping> getLstTblBranchMappings() {
        return lstTblBranchMappings;
    }

    public void setLstTblBranchMappings(List<TblBranchMapping> lstTblBranchMappings) {
        this.lstTblBranchMappings = lstTblBranchMappings;
    }

    
    
    
}
