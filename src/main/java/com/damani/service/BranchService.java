/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.damani.service;

import com.damani.model.TblBranch;
import java.math.BigInteger;
import java.util.List;
import org.springframework.stereotype.Service;

/**
 *
 * @author ITMCS-PC
 */
@Service
public interface BranchService {

    public List<TblBranch> showbranchservice();

    public void addbranchservice(TblBranch tblbranch);

    public List<TblBranch> editbranchservice(BigInteger branchid);

    public void updatebranchservice(TblBranch tblbranch);

    public void deletebranchservice(BigInteger branchid);
}
