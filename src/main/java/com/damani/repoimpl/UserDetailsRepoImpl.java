/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.damani.repoimpl;

import com.damani.dal.CommonDAO;
import com.damani.dal.OperationTypeEnum;
import com.damani.model.TblResult;
import com.damani.model.TblUserDetails;
import com.damani.repo.UserDetailsRepo;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author ITMCS-PC
 */
@Repository
public class UserDetailsRepoImpl implements UserDetailsRepo{

    @Autowired
    CommonDAO  commonDAO ;
    
   
   
    @Override
    public List<TblResult> savedataandshowresultrepo(TblUserDetails tblUserDetails) {
    
      int year =Calendar.getInstance().get(Calendar.YEAR);
       String currentyear = Integer.toString(year); 
     commonDAO.saveOrUpdate(tblUserDetails);
        List<TblResult>  lstresultofstudent=commonDAO.findEntity(TblResult.class,"year",OperationTypeEnum.EQ,tblUserDetails.getYear(),"cutoffmarks",OperationTypeEnum.LE,tblUserDetails.getScore());
     return lstresultofstudent;
    }
    
    
}
