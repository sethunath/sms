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
@Table(name = "transactions")
@NamedQueries({@NamedQuery(name = "Transactions.findById", query = "SELECT t FROM Transactions t WHERE t.id = :id"), @NamedQuery(name = "Transactions.findByUserId", query = "SELECT t FROM Transactions t WHERE t.userId = :userId"), @NamedQuery(name = "Transactions.findByAccountId", query = "SELECT t FROM Transactions t WHERE t.accountId = :accountId"), @NamedQuery(name = "Transactions.findByDeposit", query = "SELECT t FROM Transactions t WHERE t.deposit = :deposit"), @NamedQuery(name = "Transactions.findByWithdrawal", query = "SELECT t FROM Transactions t WHERE t.withdrawal = :withdrawal"), @NamedQuery(name = "Transactions.findByTimestamp", query = "SELECT t FROM Transactions t WHERE t.timestamp = :timestamp"), @NamedQuery(name = "Transactions.findByLledgerHeadId", query = "SELECT t FROM Transactions t WHERE t.lledgerHeadId = :lledgerHeadId")})
public class Transactions implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "id", nullable = false)
    private Integer id;
    @Column(name = "user_id")
    private Integer userId;
    @Column(name = "account_id")
    private Integer accountId;
    @Column(name = "deposit")
    private Double deposit;
    @Column(name = "withdrawal")
    private Double withdrawal;
    @Column(name = "timestamp")
    @Temporal(TemporalType.TIMESTAMP)
    private Date timestamp;
    @Column(name = "lledger_head_id")
    private Integer lledgerHeadId;

    public Transactions() {
    }

    public Transactions(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getAccountId() {
        return accountId;
    }

    public void setAccountId(Integer accountId) {
        this.accountId = accountId;
    }

    public Double getDeposit() {
        return deposit;
    }

    public void setDeposit(Double deposit) {
        this.deposit = deposit;
    }

    public Double getWithdrawal() {
        return withdrawal;
    }

    public void setWithdrawal(Double withdrawal) {
        this.withdrawal = withdrawal;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    public Integer getLledgerHeadId() {
        return lledgerHeadId;
    }

    public void setLledgerHeadId(Integer lledgerHeadId) {
        this.lledgerHeadId = lledgerHeadId;
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
        if (!(object instanceof Transactions)) {
            return false;
        }
        Transactions other = (Transactions) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "bankingapp.Transactions[id=" + id + "]";
    }

}
