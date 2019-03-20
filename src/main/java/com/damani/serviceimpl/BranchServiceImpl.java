/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.damani.serviceimpl;

import com.damani.model.TblBranch;
import com.damani.repo.BranchRepo;
import com.damani.service.BranchService;
import java.math.BigInteger;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author ITMCS-PC
 */
@Service
public class BranchServiceImpl implements BranchService {

    @Autowired
    BranchRepo branchrepo;

    @Override
    public void addbranchservice(TblBranch tblbranch) {
        System.out.println("pk:::" + tblbranch.getBranchName());
        String str = null;
        List<TblBranch> lsBranchs = branchrepo.showbranchrepo();
        for (TblBranch tblBranchs : lsBranchs) {
            System.out.println("pkkkkkk:::" + tblBranchs.getBranchName().equalsIgnoreCase(tblbranch.getBranchName()));
            if (tblBranchs.getBranchName().equalsIgnoreCase(tblbranch.getBranchName())) {
                str = "fail";
                break;
            } else {
                str = "Success";
            }
        }
        if (str == "Success") {
            branchrepo.addbranchrepo(tblbranch);
        }
    }

    @Override
    public List<TblBranch> showbranchservice() {
        return branchrepo.showbranchrepo();
    }

    @Override
    public List<TblBranch> editbranchservice(BigInteger branchid) {

        return branchrepo.editbranchrepo(branchid);
    }

    @Override
    public void updatebranchservice(TblBranch tblbranch) {

        branchrepo.updatebranchrepo(tblbranch);
    }

    @Override
    public void deletebranchservice(BigInteger branchid) {
        branchrepo.deletebranchrepo(branchid);
    }

}
