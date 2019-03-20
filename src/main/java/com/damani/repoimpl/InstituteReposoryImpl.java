/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.damani.repoimpl;

import com.damani.dal.CommonDAO;
import com.damani.dal.OperationTypeEnum;
import com.damani.model.TblInstitute;
import com.damani.model.TblUser;
import com.damani.repo.InstituteRepository;
import java.math.BigInteger;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author ITMCS
 */
@Repository
public class InstituteReposoryImpl implements InstituteRepository {
    
    @Autowired
    CommonDAO commonDAO;
    
    @Override
    public TblInstitute saveInstitute(TblInstitute tblInstitute) {
        commonDAO.saveOrUpdate(tblInstitute);
        return tblInstitute;
    }
    
    @Override
    public List<TblInstitute> fetchAllInstitute() {
        return commonDAO.findEntity(TblInstitute.class);
    }
    
    @Override
    public TblInstitute fetchInstituteById(BigInteger institutePk) {
        List<TblInstitute> lstInstitute = commonDAO.findEntity(TblInstitute.class, "institutePk", OperationTypeEnum.EQ, institutePk);
        return lstInstitute.get(0);
    }
    
    @Override
    public void deleteInstituteById(TblInstitute tblInstitute) {
        commonDAO.delete(tblInstitute);
    }
    
    @Override
    public void updateInstituteById(TblInstitute tblInstitute) {
        commonDAO.update(tblInstitute);
    }
    
}
