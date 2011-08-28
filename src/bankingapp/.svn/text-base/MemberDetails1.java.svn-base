/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package bankingapp;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author sethunath | mailsethu@gmail.com
 */
@Entity
@Table(name = "member_details")
@NamedQueries({@NamedQuery(name = "MemberDetails1.findById", query = "SELECT m FROM MemberDetails1 m WHERE m.id = :id"), @NamedQuery(name = "MemberDetails1.findByName", query = "SELECT m FROM MemberDetails1 m WHERE m.name = :name"), @NamedQuery(name = "MemberDetails1.findByFather", query = "SELECT m FROM MemberDetails1 m WHERE m.father = :father"), @NamedQuery(name = "MemberDetails1.findByAddress", query = "SELECT m FROM MemberDetails1 m WHERE m.address = :address"), @NamedQuery(name = "MemberDetails1.findByVillage", query = "SELECT m FROM MemberDetails1 m WHERE m.village = :village"), @NamedQuery(name = "MemberDetails1.findByTaluk", query = "SELECT m FROM MemberDetails1 m WHERE m.taluk = :taluk"), @NamedQuery(name = "MemberDetails1.findByReligion", query = "SELECT m FROM MemberDetails1 m WHERE m.religion = :religion"), @NamedQuery(name = "MemberDetails1.findByDesignation", query = "SELECT m FROM MemberDetails1 m WHERE m.designation = :designation"), @NamedQuery(name = "MemberDetails1.findByOfficeAddress", query = "SELECT m FROM MemberDetails1 m WHERE m.officeAddress = :officeAddress"), @NamedQuery(name = "MemberDetails1.findByOfficePhone", query = "SELECT m FROM MemberDetails1 m WHERE m.officePhone = :officePhone"), @NamedQuery(name = "MemberDetails1.findByDateOfEnroll", query = "SELECT m FROM MemberDetails1 m WHERE m.dateOfEnroll = :dateOfEnroll"), @NamedQuery(name = "MemberDetails1.findByDob", query = "SELECT m FROM MemberDetails1 m WHERE m.dob = :dob"), @NamedQuery(name = "MemberDetails1.findByShares", query = "SELECT m FROM MemberDetails1 m WHERE m.shares = :shares"), @NamedQuery(name = "MemberDetails1.findByClaimant", query = "SELECT m FROM MemberDetails1 m WHERE m.claimant = :claimant"), @NamedQuery(name = "MemberDetails1.findByType", query = "SELECT m FROM MemberDetails1 m WHERE m.type = :type"), @NamedQuery(name = "MemberDetails1.findByMemberId", query = "SELECT m FROM MemberDetails1 m WHERE m.memberId = :memberId"), @NamedQuery(name = "MemberDetails1.findByReferrer", query = "SELECT m FROM MemberDetails1 m WHERE m.referrer = :referrer"), @NamedQuery(name = "MemberDetails1.findByDateOfEnroll1", query = "SELECT m FROM MemberDetails1 m WHERE m.dateOfEnroll1 = :dateOfEnroll1")})
public class MemberDetails1 implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "id", nullable = false)
    private Integer id;
    @Column(name = "name")
    private String name;
    @Column(name = "father")
    private String father;
    @Column(name = "address")
    private String address;
    @Column(name = "village")
    private String village;
    @Column(name = "taluk")
    private String taluk;
    @Column(name = "religion")
    private String religion;
    @Column(name = "designation")
    private String designation;
    @Column(name = "office_address")
    private String officeAddress;
    @Column(name = "office_phone")
    private String officePhone;
    @Column(name = "date_of_enroll")
    private String dateOfEnroll;
    @Column(name = "dob")
    private String dob;
    @Column(name = "shares")
    private String shares;
    @Column(name = "claimant")
    private String claimant;
    @Column(name = "type", nullable = false)
    private int type;
    @Column(name = "member_id", nullable = false)
    private int memberId;
    @Column(name = "referrer")
    private String referrer;
    @Column(name = "dateOfEnroll")
    private String dateOfEnroll1;

    public MemberDetails1() {
    }

    public MemberDetails1(Integer id) {
        this.id = id;
    }

    public MemberDetails1(Integer id, int type, int memberId) {
        this.id = id;
        this.type = type;
        this.memberId = memberId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFather() {
        return father;
    }

    public void setFather(String father) {
        this.father = father;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getVillage() {
        return village;
    }

    public void setVillage(String village) {
        this.village = village;
    }

    public String getTaluk() {
        return taluk;
    }

    public void setTaluk(String taluk) {
        this.taluk = taluk;
    }

    public String getReligion() {
        return religion;
    }

    public void setReligion(String religion) {
        this.religion = religion;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public String getOfficeAddress() {
        return officeAddress;
    }

    public void setOfficeAddress(String officeAddress) {
        this.officeAddress = officeAddress;
    }

    public String getOfficePhone() {
        return officePhone;
    }

    public void setOfficePhone(String officePhone) {
        this.officePhone = officePhone;
    }

    public String getDateOfEnroll() {
        return dateOfEnroll;
    }

    public void setDateOfEnroll(String dateOfEnroll) {
        this.dateOfEnroll = dateOfEnroll;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getShares() {
        return shares;
    }

    public void setShares(String shares) {
        this.shares = shares;
    }

    public String getClaimant() {
        return claimant;
    }

    public void setClaimant(String claimant) {
        this.claimant = claimant;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getMemberId() {
        return memberId;
    }

    public void setMemberId(int memberId) {
        this.memberId = memberId;
    }

    public String getReferrer() {
        return referrer;
    }

    public void setReferrer(String referrer) {
        this.referrer = referrer;
    }

    public String getDateOfEnroll1() {
        return dateOfEnroll1;
    }

    public void setDateOfEnroll1(String dateOfEnroll1) {
        this.dateOfEnroll1 = dateOfEnroll1;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MemberDetails1)) {
            return false;
        }
        MemberDetails1 other = (MemberDetails1) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "bankingapp.MemberDetails1[id=" + id + "]";
    }

}
