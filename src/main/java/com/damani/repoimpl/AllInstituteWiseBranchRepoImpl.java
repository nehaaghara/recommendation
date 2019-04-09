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
import com.damani.repo.AllInstituteWiseBranchRepo;
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
public class AllInstituteWiseBranchRepoImpl implements AllInstituteWiseBranchRepo{

    @Autowired
    CommonDAO  commonDAO ;
    
    @Override
    public Map<TblInstitute, List<TblInstituteBranch>> AllInstituteWiseBranchrepo() {
       
        Map<TblInstitute, List<TblInstituteBranch>> AllInstituteWiseBranch=new HashMap<>();
       List<TblInstitute> lstallinstitute= commonDAO.findEntity(TblInstitute.class);
        System.out.println("lstallinstitute::"+lstallinstitute.size());
       for(int i=0;i<lstallinstitute.size();i++)
       {
          List<TblInstituteBranch> lstofinstitutewisebranch= commonDAO.findEntity(TblInstituteBranch.class,"instituteFk.institutePk",OperationTypeEnum.EQ,lstallinstitute.get(i).getInstitutePk());
          AllInstituteWiseBranch.put(lstallinstitute.get(i), lstofinstitutewisebranch);
       }
       return AllInstituteWiseBranch;
    }

   
    
    
    
}
