/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.damani.repoimpl;

import com.damani.dal.CommonDAO;
import com.damani.dal.OperationTypeEnum;
import com.damani.model.TblUser;
import com.damani.repo.UserProfileRepository;
import java.math.BigInteger;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author ITMCS
 */
@Repository
public class UserProfileRepositoryImpl implements UserProfileRepository{

    @Autowired
    CommonDAO commonDAO;
    
    @Override
    public void updateProfileInformation(TblUser tblUser) {
        commonDAO.update(tblUser);
    }

    @Override
    public TblUser fetchById(BigInteger userId) {
        List<TblUser> lstUser = commonDAO.findEntity(TblUser.class,"userid",OperationTypeEnum.EQ,userId);
        return lstUser.get(0);
    }
    
}
