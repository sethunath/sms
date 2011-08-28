/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package bankingapp;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 *
 * @author s
 */
@Entity
@Table(name = "schemes")
@NamedQueries({@NamedQuery(name = "Schemes.findById", query = "SELECT s FROM Schemes s WHERE s.id = :id"), @NamedQuery(name = "Schemes.findByScheme", query = "SELECT s FROM Schemes s WHERE s.scheme = :scheme"), @NamedQuery(name = "Schemes.findByMaxInstallments", query = "SELECT s FROM Schemes s WHERE s.maxInstallments = :maxInstallments"), @NamedQuery(name = "Schemes.findByRateOfInterest", query = "SELECT s FROM Schemes s WHERE s.rateOfInterest = :rateOfInterest"), @NamedQuery(name = "Schemes.findByInterestDays", query = "SELECT s FROM Schemes s WHERE s.interestDays = :interestDays"), @NamedQuery(name = "Schemes.findByTypeDepositWithdrawal", query = "SELECT s FROM Schemes s WHERE s.typeDepositWithdrawal = :typeDepositWithdrawal"), @NamedQuery(name = "Schemes.findByCyclePeriod", query = "SELECT s FROM Schemes s WHERE s.cyclePeriod = :cyclePeriod"), @NamedQuery(name = "Schemes.findByLedgerHeadId", query = "SELECT s FROM Schemes s WHERE s.ledgerHeadId = :ledgerHeadId")})
public class Schemes implements Serializable {
    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);
    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "id", nullable = false)
    private Integer id;
    @Column(name = "scheme")
    private String scheme;
    @Column(name = "max_installments")
    private Integer maxInstallments;
    @Column(name = "rate_of_interest")
    private Integer rateOfInterest;
    @Column(name = "interest_days")
    private Integer interestDays;
    @Column(name = "type_deposit_withdrawal")
    private Integer typeDepositWithdrawal;
    @Column(name = "cycle_period")
    private Integer cyclePeriod;
    @Column(name = "ledger_head_id")
    private Integer ledgerHeadId;

    public Schemes() {
    }

    public Schemes(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        Integer oldId = this.id;
        this.id = id;
        changeSupport.firePropertyChange("id", oldId, id);
    }

    public String getScheme() {
        return scheme;
    }

    public void setScheme(String scheme) {
        String oldScheme = this.scheme;
        this.scheme = scheme;
        changeSupport.firePropertyChange("scheme", oldScheme, scheme);
    }

    public Integer getMaxInstallments() {
        return maxInstallments;
    }

    public void setMaxInstallments(Integer maxInstallments) {
        Integer oldMaxInstallments = this.maxInstallments;
        this.maxInstallments = maxInstallments;
        changeSupport.firePropertyChange("maxInstallments", oldMaxInstallments, maxInstallments);
    }

    public Integer getRateOfInterest() {
        return rateOfInterest;
    }

    public void setRateOfInterest(Integer rateOfInterest) {
        Integer oldRateOfInterest = this.rateOfInterest;
        this.rateOfInterest = rateOfInterest;
        changeSupport.firePropertyChange("rateOfInterest", oldRateOfInterest, rateOfInterest);
    }

    public Integer getInterestDays() {
        return interestDays;
    }

    public void setInterestDays(Integer interestDays) {
        Integer oldInterestDays = this.interestDays;
        this.interestDays = interestDays;
        changeSupport.firePropertyChange("interestDays", oldInterestDays, interestDays);
    }

    public Integer getTypeDepositWithdrawal() {
        return typeDepositWithdrawal;
    }

    public void setTypeDepositWithdrawal(Integer typeDepositWithdrawal) {
        Integer oldTypeDepositWithdrawal = this.typeDepositWithdrawal;
        this.typeDepositWithdrawal = typeDepositWithdrawal;
        changeSupport.firePropertyChange("typeDepositWithdrawal", oldTypeDepositWithdrawal, typeDepositWithdrawal);
    }

    public Integer getCyclePeriod() {
        return cyclePeriod;
    }

    public void setCyclePeriod(Integer cyclePeriod) {
        Integer oldCyclePeriod = this.cyclePeriod;
        this.cyclePeriod = cyclePeriod;
        changeSupport.firePropertyChange("cyclePeriod", oldCyclePeriod, cyclePeriod);
    }

    public Integer getLedgerHeadId() {
        return ledgerHeadId;
    }

    public void setLedgerHeadId(Integer ledgerHeadId) {
        Integer oldLedgerHeadId = this.ledgerHeadId;
        this.ledgerHeadId = ledgerHeadId;
        changeSupport.firePropertyChange("ledgerHeadId", oldLedgerHeadId, ledgerHeadId);
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
        if (!(object instanceof Schemes)) {
            return false;
        }
        Schemes other = (Schemes) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return scheme;
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

}
