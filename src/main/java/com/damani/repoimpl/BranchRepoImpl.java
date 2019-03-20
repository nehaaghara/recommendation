/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.damani.repoimpl;

import com.damani.dal.CommonDAO;
import com.damani.dal.OperationTypeEnum;
import com.damani.model.TblBranch;
import com.damani.repo.BranchRepo;
import java.math.BigInteger;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author ITMCS-PC
 */
@Repository
public class BranchRepoImpl implements BranchRepo{

    @Autowired
    CommonDAO commonDAO;
    
    @Override
    public void addbranchrepo(TblBranch tblbranch) {
        
        commonDAO.saveOrUpdate(tblbranch);
    }

    @Override
    public List<TblBranch> showbranchrepo() {
       return commonDAO.findEntity(TblBranch.class);
    }

    @Override
    public List<TblBranch> editbranchrepo(BigInteger branchid) {
      
      List<TblBranch> lstbranch= commonDAO.findEntity(TblBranch.class,"branchPK",OperationTypeEnum.EQ,branchid);
      return lstbranch;
    }

    @Override
    public void updatebranchrepo(TblBranch tblbranch) {
        commonDAO.update(tblbranch);
    }

    @Override
    public void deletebranchrepo(BigInteger branchid) {
        
       List<TblBranch> lstbranch= commonDAO.findEntity(TblBranch.class,"branchPK", OperationTypeEnum.EQ,branchid);
       commonDAO.delete(lstbranch.get(0));
    }
    
}
