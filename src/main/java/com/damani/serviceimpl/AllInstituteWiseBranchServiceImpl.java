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
import com.damani.repo.AllInstituteWiseBranchRepo;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.damani.service.AllInstituteWiseBranchService;

/**
 *
 * @author ITMCS-PC
 */
@Service
public class AllInstituteWiseBranchServiceImpl implements AllInstituteWiseBranchService{

    @Autowired
    AllInstituteWiseBranchRepo allInstituteWiseBranchRepo;
    
    @Override
    public Map<TblInstitute, List<TblInstituteBranch>> AllInstituteWiseBranchservice() {
      return  allInstituteWiseBranchRepo.AllInstituteWiseBranchrepo();
    }

    
    
    
    
}
