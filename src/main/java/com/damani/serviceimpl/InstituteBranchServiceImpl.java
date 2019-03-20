/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.damani.serviceimpl;

import com.damani.model.TblInstituteBranch;
import com.damani.repo.InstituteBranchRepository;
import com.damani.service.InstituteBranchService;
import com.damani.utility.CustomUtility;
import java.math.BigInteger;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author ITMCS
 */
@Service
public class InstituteBranchServiceImpl implements InstituteBranchService{

    @Autowired
    InstituteBranchRepository instituteBranchRepository;
    
    @Override
    public String saveInstituteBranch(TblInstituteBranch tblInstituteBranch) {
         instituteBranchRepository.saveInstituteBranch(tblInstituteBranch);
         return "Record Saved Successfully";
    }

    @Override
    public List<TblInstituteBranch> fetchAllInstituteBranch() {
        List<TblInstituteBranch> lsInstituteBranchs = instituteBranchRepository.fetchAllInstituteBranch();
        return lsInstituteBranchs;
    }

    @Override
    public TblInstituteBranch fetchInstituteBranchById(BigInteger institutebranchPK) {
        return instituteBranchRepository.fetchInstituteBranchById(institutebranchPK);
        }

    @Override
    public String deleteInstituteBranchById(BigInteger institutebranchPK) {
        TblInstituteBranch tblInstituteBranch = new TblInstituteBranch();
        tblInstituteBranch.setInstitutebranchPK(institutebranchPK);
        instituteBranchRepository.deleteInstituteBranchById(tblInstituteBranch);
        return "Record Deleted Successfully";
    }

    @Override
    public String updateInstituteBranchById(TblInstituteBranch tblInstituteBranch) {
        TblInstituteBranch oldTblInstituteBranch = instituteBranchRepository.fetchInstituteBranchById(tblInstituteBranch.getInstitutebranchPK());
         try {
            oldTblInstituteBranch = (TblInstituteBranch) CustomUtility.setNewValuesToOld(oldTblInstituteBranch, tblInstituteBranch, TblInstituteBranch.class);
            instituteBranchRepository.updateInstituteBranchById(oldTblInstituteBranch);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return "Record Updated SuccessFully";
    }
    
}
