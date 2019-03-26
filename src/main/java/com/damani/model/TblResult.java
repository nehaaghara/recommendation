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
 * @author ITMCS-PC
 */
@Entity
@Table(name = "tbl_result ")
public class TblResult {
    
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "resultPk", nullable = false)
    BigInteger resultPk;
    
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "instituteBranchFk")
    TblInstituteBranch instituteBranchFk;
    
    @Column(name = "year")
    String year;
    
    @Column(name = "cutOffMarks")
    int cutoffmarks;

    public BigInteger getResultPk() {
        return resultPk;
    }

    public void setResultPk(BigInteger resultPk) {
        this.resultPk = resultPk;
    }

    public TblInstituteBranch getInstituteBranchFk() {
        return instituteBranchFk;
    }

    public void setInstituteBranchFk(TblInstituteBranch instituteBranchFk) {
        this.instituteBranchFk = instituteBranchFk;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

 

  

    public int getCutoffmarks() {
        return cutoffmarks;
    }

    public void setCutoffmarks(int cutoffmarks) {
        this.cutoffmarks = cutoffmarks;
    }

   
    
    
}
