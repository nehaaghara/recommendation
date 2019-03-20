/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.damani.service;

import com.damani.model.TblInstitute;
import com.damani.model.TblUser;
import java.math.BigInteger;
import java.util.List;
import org.springframework.stereotype.Service;

/**
 *
 * @author ITMCS
 */
@Service
public interface InstituteService {
    public String saveInstitute(TblInstitute tblInstitute,TblUser tblUser);
    public List<TblInstitute> fetchAllInstitute();
    public TblInstitute fetchInstituteById(BigInteger institutePk);
    public String deleteInstituteById(BigInteger institutePk) ;
    public String updateInstituteById(TblInstitute tblInstitute,TblUser tblUser);
}
