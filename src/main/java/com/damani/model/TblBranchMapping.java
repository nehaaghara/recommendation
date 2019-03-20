/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.damani.model;

import java.math.BigInteger;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author ITMCS
 */
@Entity
@Table(name = "tbl_branchmapping")
public class TblBranchMapping {

    @Id
    @Column(name = "branchMappingPk")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    BigInteger branchMappingPk;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "branchFk")
    TblBranch branchFk;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "instituteFk")
    TblInstitute instituteFk;
    
    @Column(name = "createdOn")
    Date createdOn;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "createdBy")
    TblUser createdBy;

    public BigInteger getBranchMappingPk() {
        return branchMappingPk;
    }

    public void setBranchMappingPk(BigInteger branchMappingPk) {
        this.branchMappingPk = branchMappingPk;
    }

    public TblBranch getBranchFk() {
        return branchFk;
    }

    public void setBranchFk(TblBranch branchFk) {
        this.branchFk = branchFk;
    }

    public TblInstitute getInstituteFk() {
        return instituteFk;
    }

    public void setInstituteFk(TblInstitute instituteFk) {
        this.instituteFk = instituteFk;
    }

    public TblUser getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(TblUser createdBy) {
        this.createdBy = createdBy;
    }

    public Date getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(Date createdOn) {
        this.createdOn = createdOn;
    }
    
    

}
