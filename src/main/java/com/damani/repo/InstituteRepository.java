/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.damani.repo;

import com.damani.model.TblInstitute;
import com.damani.model.TblUser;
import java.math.BigInteger;
import java.util.List;
import org.springframework.stereotype.Repository;

/**
 *
 * @author ITMCS
 */
@Repository
public interface InstituteRepository {
    public TblInstitute saveInstitute(TblInstitute tblInstitute);
    public List<TblInstitute> fetchAllInstitute();
    public TblInstitute fetchInstituteById(BigInteger institutePk);
    public void deleteInstituteById(TblInstitute tblInstitute);
    public void updateInstituteById(TblInstitute tblInstitute);
    
}
