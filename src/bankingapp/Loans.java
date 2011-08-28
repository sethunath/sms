/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package bankingapp;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author s
 */
@Entity
@Table(name = "loans")
@NamedQueries({@NamedQuery(name = "Loans.findById", query = "SELECT l FROM Loans l WHERE l.id = :id"), @NamedQuery(name = "Loans.findByAmount", query = "SELECT l FROM Loans l WHERE l.amount = :amount"), @NamedQuery(name = "Loans.findByInterest", query = "SELECT l FROM Loans l WHERE l.interest = :interest"), @NamedQuery(name = "Loans.findByRepaymentMonths", query = "SELECT l FROM Loans l WHERE l.repaymentMonths = :repaymentMonths"), @NamedQuery(name = "Loans.findBySchemeId", query = "SELECT l FROM Loans l WHERE l.schemeId = :schemeId"), @NamedQuery(name = "Loans.findByMembersId", query = "SELECT l FROM Loans l WHERE l.membersId = :membersId"), @NamedQuery(name = "Loans.findByTimestamp", query = "SELECT l FROM Loans l WHERE l.timestamp = :timestamp"), @NamedQuery(name = "Loans.findByTransactionsId", query = "SELECT l FROM Loans l WHERE l.transactionsId = :transactionsId")})
public class Loans implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "id", nullable = false)
    private Integer id;
    @Column(name = "amount")
    private Double amount;
    @Column(name = "interest")
    private Double interest;
    @Column(name = "repayment_months")
    private Integer repaymentMonths;
    @Column(name = "scheme_id")
    private Integer schemeId;
    @Column(name = "members_id")
    private Integer membersId;
    @Column(name = "timestamp")
    @Temporal(TemporalType.TIMESTAMP)
    private Date timestamp;
    @Column(name = "transactions_id")
    private Integer transactionsId;

    public Loans() {
    }

    public Loans(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public Double getInterest() {
        return interest;
    }

    public void setInterest(Double interest) {
        this.interest = interest;
    }

    public Integer getRepaymentMonths() {
        return repaymentMonths;
    }

    public void setRepaymentMonths(Integer repaymentMonths) {
        this.repaymentMonths = repaymentMonths;
    }

    public Integer getSchemeId() {
        return schemeId;
    }

    public void setSchemeId(Integer schemeId) {
        this.schemeId = schemeId;
    }

    public Integer getMembersId() {
        return membersId;
    }

    public void setMembersId(Integer membersId) {
        this.membersId = membersId;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    public Integer getTransactionsId() {
        return transactionsId;
    }

    public void setTransactionsId(Integer transactionsId) {
        this.transactionsId = transactionsId;
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
        if (!(object instanceof Loans)) {
            return false;
        }
        Loans other = (Loans) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "bankingapp.Loans[id=" + id + "]";
    }

}
