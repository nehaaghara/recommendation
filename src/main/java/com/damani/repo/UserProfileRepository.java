/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.damani.repo;

import com.damani.model.TblUser;
import java.math.BigInteger;
import org.springframework.stereotype.Repository;

/**
 *
 * @author ITMCS
 */
@Repository
public interface UserProfileRepository {
     public void updateProfileInformation(TblUser tblUser);
    public TblUser fetchById(BigInteger userId);
}
