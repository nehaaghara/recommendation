/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.damani.repo;

import com.damani.model.TblResult;
import com.damani.model.TblUserDetails;
import java.util.List;
import org.springframework.stereotype.Service;

/**
 *
 * @author ITMCS-PC
 */
@Service
public interface UserDetailsRepo {

public List<TblResult> savedataandshowresultrepo(TblUserDetails tblUserDetails );    
}
