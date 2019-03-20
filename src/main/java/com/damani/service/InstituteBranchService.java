/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.damani.service;

import com.damani.model.TblInstituteBranch;
import java.math.BigInteger;
import java.util.List;
import org.springframework.stereotype.Service;

/**
 *
 * @author ITMCS
 */
@Service
public interface InstituteBranchService {

    public String saveInstituteBranch(TblInstituteBranch tblInstituteBranch);

    public List<TblInstituteBranch> fetchAllInstituteBranch();

    public TblInstituteBranch fetchInstituteBranchById(BigInteger institutebranchPK);

    public String deleteInstituteBranchById(BigInteger institutebranchPK);

    public String updateInstituteBranchById(TblInstituteBranch tblInstituteBranch);

}
