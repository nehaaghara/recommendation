/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.damani.model;

import java.math.BigInteger;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author ITMCS-PC
 */
@Entity
@Table(name="tbl_branch")
public class TblBranch {
    
      
    @Id
    @Column(name = "branchPK")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    BigInteger branchPK;
    
    @Column(name="branchName")
    String branchName;
    
    @Column(name="isActive")
    int isActive ;

    public BigInteger getBranchPK() {
        return branchPK;
    }

    public void setBranchPK(BigInteger branchPK) {
        this.branchPK = branchPK;
    }

    public String getBranchName() {
        return branchName;
    }

    public void setBranchName(String branchName) {
        this.branchName = branchName;
    }

    public int getIsActive() {
        return isActive;
    }

    public void setIsActive(int isActive) {
        this.isActive = isActive;
    }
}
