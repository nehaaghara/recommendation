/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.damani.serviceimpl;

import com.damani.model.TblBranchMapping;
import com.damani.repo.BranchMappingReposiotry;
import com.damani.service.BranchMappingService;
import java.math.BigInteger;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author ITMCS
 */
@Service
public class BranchMappingServiceImpl implements BranchMappingService {

    @Autowired
    BranchMappingReposiotry branchMappingReposiotry;

    @Override
    public void saveBranch(List<TblBranchMapping> lstTblBranchMapping) {
        branchMappingReposiotry.saveBranch(lstTblBranchMapping);
    }

    @Override
    public List<TblBranchMapping> fetchBranchById(BigInteger institutePk) {
        return branchMappingReposiotry.fetchBranchByInstituteId(institutePk);
    }

    @Override
    public void updateBranchById(List<TblBranchMapping> lstTblBranchMapping, BigInteger institutePk) {
        List<TblBranchMapping> oldlstBranchMappings = branchMappingReposiotry.fetchBranchByInstituteId(institutePk);
        branchMappingReposiotry.deletebranchById(oldlstBranchMappings);
        branchMappingReposiotry.saveBranch(lstTblBranchMapping);
    }

}
