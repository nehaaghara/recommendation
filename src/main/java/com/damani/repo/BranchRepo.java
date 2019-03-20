/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.damani.repo;

import com.damani.model.TblBranch;
import java.math.BigInteger;
import java.util.List;
import org.springframework.stereotype.Service;

/**
 *
 * @author ITMCS-PC
 */
@Service
public interface BranchRepo {
    
    public void addbranchrepo(TblBranch tblbranch);
    public List<TblBranch> showbranchrepo();
    public List<TblBranch> editbranchrepo(BigInteger branchid);
    public void updatebranchrepo(TblBranch tblbranch);
    public void deletebranchrepo(BigInteger branchid);
}
