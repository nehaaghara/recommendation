/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.damani.repoimpl;

import com.damani.dal.CommonDAO;
import com.damani.dal.OperationTypeEnum;
import com.damani.model.TblInstituteBranch;
import com.damani.repo.InstituteBranchRepository;
import java.math.BigInteger;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author ITMCS
 */
@Repository
public class InstituteBranchRepositoryImpl implements InstituteBranchRepository{

    @Autowired
    CommonDAO commonDAO;
    
    @Override
    public TblInstituteBranch saveInstituteBranch(TblInstituteBranch tblInstituteBranch) {
        commonDAO.save(tblInstituteBranch);
        return tblInstituteBranch;
    }

    @Override
    public List<TblInstituteBranch> fetchAllInstituteBranch() {
        return commonDAO.findEntity(TblInstituteBranch.class);
    }

    @Override
    public TblInstituteBranch fetchInstituteBranchById(BigInteger instituteBranchPk) {
        List<TblInstituteBranch> lstInstituteBranches = commonDAO.findEntity(TblInstituteBranch.class,"institutebranchPK",OperationTypeEnum.EQ,instituteBranchPk);
        return lstInstituteBranches.get(0);
    }

    @Override
    public void deleteInstituteBranchById(TblInstituteBranch tblInstituteBranch) {
        commonDAO.delete(tblInstituteBranch);
    }

    @Override
    public void updateInstituteBranchById(TblInstituteBranch tblInstituteBranch) {
        commonDAO.update(tblInstituteBranch);
    }
    
}
