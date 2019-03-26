/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.damani.repoimpl;

import com.damani.dal.CommonDAO;
import com.damani.dal.OperationTypeEnum;
import com.damani.model.TblBranch;
import com.damani.model.TblInstitute;
import com.damani.model.TblInstituteBranch;
import com.damani.model.TblResult;
import com.damani.repo.ResultRepo;
import java.math.BigInteger;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author ITMCS-PC
 */
@Repository
public class ResultRepoImpl implements ResultRepo{

    @Autowired
    CommonDAO commonDAO;
    
    @Override
    public Map<List<TblInstitute>, List<TblBranch>> resultpagedatarepo() {
       
        Map<List<TblInstitute>, List<TblBranch>> allinstituteandbranch=new HashMap<>();
        List<TblInstitute> lstinstitute=commonDAO.findEntity(TblInstitute.class);
        List<TblBranch> lstbranch=commonDAO.findEntity(TblBranch.class);
        allinstituteandbranch.put(lstinstitute, lstbranch);
        return allinstituteandbranch;
    }

    @Override
    public void savedatainresulttablerepo(TblResult tblresult) {
       List<TblInstituteBranch> lstTblInstituteBranch= commonDAO.findEntity(TblInstituteBranch.class,"instituteFk.institutePk",OperationTypeEnum.EQ,tblresult.getInstituteBranchFk().getInstituteFk().getInstitutePk(),"branchFk.branchPK",OperationTypeEnum.EQ,tblresult.getInstituteBranchFk().getBranchFk().getBranchPK());
        TblInstituteBranch tblInstituteBranch=new TblInstituteBranch();
        tblInstituteBranch.setInstitutebranchPK(lstTblInstituteBranch.get(0).getInstitutebranchPK());
       tblresult.setInstituteBranchFk(tblInstituteBranch);
       if(tblresult.getResultPk() == null)
       {
        commonDAO.saveOrUpdate(tblresult);
       }
       else
       {
         List<TblResult> lstresult= commonDAO.findEntity(TblResult.class,"resultPk",OperationTypeEnum.EQ,tblresult.getResultPk());
         
          commonDAO.saveOrUpdate(tblresult);
         
       }
       
    }

    @Override
    public List<TblInstituteBranch> instituteidwisebranchajaxrepo(BigInteger instituteid) {
       
      return commonDAO.findEntity(TblInstituteBranch.class,"instituteFk.institutePk",OperationTypeEnum.EQ,instituteid);
    }

    @Override
    public List<TblResult> viewresultrepo() {
        return commonDAO.findEntity(TblResult.class);
    }

    @Override
    public TblResult editresultdatarepo(BigInteger resultid) {
       List<TblResult> lstresultbyid= commonDAO.findEntity(TblResult.class,"resultPk",OperationTypeEnum.EQ,resultid);
       return lstresultbyid.get(0);
    }

    @Override
    public void deleteresultdatarepo(BigInteger resultid) {
       
     List<TblResult> lstresult= commonDAO.findEntity(TblResult.class,"resultPk",OperationTypeEnum.EQ,resultid);
     
        commonDAO.delete(lstresult.get(0));
        
    }
    
}
