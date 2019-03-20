/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.damani.serviceimpl;

import com.damani.model.TblInstitute;
import com.damani.model.TblUser;
import com.damani.repo.InstituteRepository;
import com.damani.service.InstituteService;
import com.damani.utility.CustomUtility;
import java.math.BigInteger;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author ITMCS
 */
@Service
public class InstituteServiceImpl implements InstituteService {

    @Autowired
    InstituteRepository instituteRepository;

    @Override
    public String saveInstitute(TblInstitute tblInstitute, TblUser tblUser) {
        tblInstitute.setInstituteName(tblInstitute.getInstituteName());
        tblInstitute.setContactNo(tblInstitute.getContactNo());
        tblInstitute.setContactPerson(tblInstitute.getContactPerson());
        tblInstitute.setEmailId(tblInstitute.getEmailId());
        tblInstitute.setAddress(tblInstitute.getAddress());
        tblInstitute.setZipCode(tblInstitute.getZipCode());
        tblInstitute.setWebsite(tblInstitute.getWebsite());
        tblInstitute.setDescription(tblInstitute.getDescription());
        tblInstitute.setCreatedOn(new Date());
        tblInstitute.setCreatedBy(tblUser);
        instituteRepository.saveInstitute(tblInstitute);
        return "Institute Saved Successfully";
    }

    @Override
    public List<TblInstitute> fetchAllInstitute() {
        List<TblInstitute> lsInstitutes = instituteRepository.fetchAllInstitute();
        return lsInstitutes;
    }

    @Override
    public TblInstitute fetchInstituteById(BigInteger institutePk) {
        return instituteRepository.fetchInstituteById(institutePk);
    }

    @Override
    public String deleteInstituteById(BigInteger institutePk) {
        TblInstitute tblInstitute = new TblInstitute();
        tblInstitute.setInstitutePk(institutePk);
        if (institutePk != null) {
            instituteRepository.deleteInstituteById(tblInstitute);
            return "Record Deleted Successfully";
        }
        return "Something is Wrong";
    }

    @Override
    public String updateInstituteById(TblInstitute tblInstitute,TblUser tblUser) {
        TblInstitute tblOldInstitute = instituteRepository.fetchInstituteById(tblInstitute.getInstitutePk());
       try {
            tblOldInstitute = (TblInstitute) CustomUtility.setNewValuesToOld(tblOldInstitute, tblInstitute, TblInstitute.class);
            instituteRepository.updateInstituteById(tblOldInstitute);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return "Record Updated SuccessFully";
    }

}
