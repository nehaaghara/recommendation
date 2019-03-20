/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.damani.repo;

import com.damani.model.TblInstituteBranch;
import java.math.BigInteger;
import java.util.List;
import org.springframework.stereotype.Repository;

/**
 *
 * @author ITMCS
 */
@Repository
public interface InstituteBranchRepository {
    public TblInstituteBranch saveInstituteBranch(TblInstituteBranch tblInstituteBranch);
    public List<TblInstituteBranch> fetchAllInstituteBranch();
    public TblInstituteBranch fetchInstituteBranchById(BigInteger instituteBranchPk);
    public void deleteInstituteBranchById(TblInstituteBranch tblInstituteBranch);
    public void updateInstituteBranchById(TblInstituteBranch tblInstituteBranch);
    
}
