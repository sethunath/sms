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
@Table(name = "mds_details")
@NamedQueries({@NamedQuery(name = "MdsDetails.findById", query = "SELECT m FROM MdsDetails m WHERE m.id = :id"), @NamedQuery(name = "MdsDetails.findByMdsId", query = "SELECT m FROM MdsDetails m WHERE m.mdsId = :mdsId"), @NamedQuery(name = "MdsDetails.findByInstallmentAmount", query = "SELECT m FROM MdsDetails m WHERE m.installmentAmount = :installmentAmount"), @NamedQuery(name = "MdsDetails.findByAmount", query = "SELECT m FROM MdsDetails m WHERE m.amount = :amount"), @NamedQuery(name = "MdsDetails.findByInstallment", query = "SELECT m FROM MdsDetails m WHERE m.installment = :installment")})
public class MdsDetails implements Serializable {
    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);
    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "id", nullable = false)
    private Integer id;
    @Column(name = "mds_id")
    private Integer mdsId;
    @Column(name = "installmentAmount")
    private Double installmentAmount;
    @Column(name = "amount")
    private Double amount;
    @Column(name = "installment")
    private Integer installment;

    public MdsDetails() {
    }

    public MdsDetails(Integer id) {
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

    public Integer getMdsId() {
        return mdsId;
    }

    public void setMdsId(Integer mdsId) {
        Integer oldMdsId = this.mdsId;
        this.mdsId = mdsId;
        changeSupport.firePropertyChange("mdsId", oldMdsId, mdsId);
    }

    public Double getInstallmentAmount() {
        return installmentAmount;
    }

    public void setInstallmentAmount(Double installmentAmount) {
        Double oldInstallmentAmount = this.installmentAmount;
        this.installmentAmount = installmentAmount;
        changeSupport.firePropertyChange("installmentAmount", oldInstallmentAmount, installmentAmount);
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        Double oldAmount = this.amount;
        this.amount = amount;
        changeSupport.firePropertyChange("amount", oldAmount, amount);
    }

    public Integer getInstallment() {
        return installment;
    }

    public void setInstallment(Integer installment) {
        Integer oldInstallment = this.installment;
        this.installment = installment;
        changeSupport.firePropertyChange("installment", oldInstallment, installment);
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
        if (!(object instanceof MdsDetails)) {
            return false;
        }
        MdsDetails other = (MdsDetails) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return installment+" ["+amount+"]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

}
