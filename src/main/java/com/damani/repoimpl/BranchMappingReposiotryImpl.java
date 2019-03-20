/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.damani.repoimpl;

import com.damani.dal.CommonDAO;
import com.damani.dal.OperationTypeEnum;
import com.damani.model.TblBranchMapping;
import com.damani.repo.BranchMappingReposiotry;
import java.math.BigInteger;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author ITMCS
 */
@Repository
public class BranchMappingReposiotryImpl implements BranchMappingReposiotry{

    @Autowired
    CommonDAO commonDAO;
    
    @Override
    public void saveBranch(TblBranchMapping tblBranchMapping) {
        commonDAO.saveOrUpdate(tblBranchMapping);
    }

    @Override
    public void saveBranch(List<TblBranchMapping> lstTblBranchMapping) {
        commonDAO.saveOrUpdateAll(lstTblBranchMapping);
    }

    @Override
    public List<TblBranchMapping> fetchBranchByInstituteId(BigInteger institutePk) {
       return commonDAO.findEntity(TblBranchMapping.class,"instituteFk.institutePk",OperationTypeEnum.EQ,institutePk);
    }

    @Override
    public void updatebranchById(List<TblBranchMapping> lsttblBranchMapping) {
            commonDAO.saveOrUpdateAll(lsttblBranchMapping);
    }

    @Override
    public void deletebranchById(List<TblBranchMapping> lsttblBranchMapping) {
        commonDAO.deleteALL(lsttblBranchMapping);
    }
    
}
