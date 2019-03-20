/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.damani.service;

import com.damani.model.TblBranchMapping;
import java.math.BigInteger;
import java.util.List;
import org.springframework.stereotype.Service;

/**
 *
 * @author ITMCS
 */
@Service
public interface BranchMappingService {
     public void saveBranch(List<TblBranchMapping> lstTblBranchMapping);
     public List<TblBranchMapping> fetchBranchById(BigInteger institutePk);
     public void updateBranchById(List<TblBranchMapping> lstTblBranchMapping,BigInteger institutePk);
  
}
