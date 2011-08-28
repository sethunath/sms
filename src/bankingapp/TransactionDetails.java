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
@Table(name = "transaction_details")
@NamedQueries({@NamedQuery(name = "TransactionDetails.findById", query = "SELECT t FROM TransactionDetails t WHERE t.id = :id"), @NamedQuery(name = "TransactionDetails.findByTransactionId", query = "SELECT t FROM TransactionDetails t WHERE t.transactionId = :transactionId"), @NamedQuery(name = "TransactionDetails.findByRemarks", query = "SELECT t FROM TransactionDetails t WHERE t.remarks = :remarks")})
public class TransactionDetails implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "id", nullable = false)
    private Integer id;
    @Column(name = "transaction_id", nullable = false)
    private int transactionId;
    @Column(name = "remarks", nullable = false)
    private String remarks;

    public TransactionDetails() {
    }

    public TransactionDetails(Integer id) {
        this.id = id;
    }

    public TransactionDetails(Integer id, int transactionId, String remarks) {
        this.id = id;
        this.transactionId = transactionId;
        this.remarks = remarks;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(int transactionId) {
        this.transactionId = transactionId;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
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
        if (!(object instanceof TransactionDetails)) {
            return false;
        }
        TransactionDetails other = (TransactionDetails) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "bankingapp.TransactionDetails[id=" + id + "]";
    }

}
