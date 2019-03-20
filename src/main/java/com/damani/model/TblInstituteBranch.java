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
@Table(name = "tbl_institutebranch")
public class TblInstituteBranch {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "institutebranchPK", nullable = false)
    BigInteger institutebranchPK;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "instituteFk")
    TblInstitute instituteFk;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "branchFk")
    TblBranch branchFk;

    @Column(name = "createdOn")
    Date createdOn;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "createdBy")
    TblUser createdBy;

    public BigInteger getInstitutebranchPK() {
        return institutebranchPK;
    }

    public void setInstitutebranchPK(BigInteger institutebranchPK) {
        this.institutebranchPK = institutebranchPK;
    }

    public TblInstitute getInstituteFk() {
        return instituteFk;
    }

    public void setInstituteFk(TblInstitute instituteFk) {
        this.instituteFk = instituteFk;
    }

    public TblBranch getBranchFk() {
        return branchFk;
    }

    public void setBranchFk(TblBranch branchFk) {
        this.branchFk = branchFk;
    }

    public Date getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(Date createdOn) {
        this.createdOn = createdOn;
    }

    public TblUser getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(TblUser createdBy) {
        this.createdBy = createdBy;
    }

}
