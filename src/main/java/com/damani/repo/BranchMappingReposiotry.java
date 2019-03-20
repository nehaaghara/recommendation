/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.damani.repo;

import com.damani.model.TblBranch;
import com.damani.model.TblBranchMapping;
import java.math.BigInteger;
import java.util.List;
import org.springframework.stereotype.Repository;

/**
 *
 * @author ITMCS
 */
@Repository
public interface BranchMappingReposiotry {

    public void saveBranch(TblBranchMapping tblBranchMapping);

    public void saveBranch(List<TblBranchMapping> lstTblBranchMapping);

    public List<TblBranchMapping> fetchBranchByInstituteId(BigInteger institutePk);

    public void updatebranchById(List<TblBranchMapping> lsttblBranchMapping);

    public void deletebranchById(List<TblBranchMapping> lsttblBranchMapping);
}
