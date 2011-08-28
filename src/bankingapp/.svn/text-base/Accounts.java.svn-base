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
 * @author sethunath|mailsethu@gmail.com
 */
@Entity
@Table(name = "accounts")
@NamedQueries({@NamedQuery(name = "Accounts.findById", query = "SELECT a FROM Accounts a WHERE a.id = :id"), @NamedQuery(name = "Accounts.findByMemberId", query = "SELECT a FROM Accounts a WHERE a.memberId = :memberId"), @NamedQuery(name = "Accounts.findBySchemeId", query = "SELECT a FROM Accounts a WHERE a.schemeId = :schemeId"), @NamedQuery(name = "Accounts.findByCommencement", query = "SELECT a FROM Accounts a WHERE a.commencement = :commencement"), @NamedQuery(name = "Accounts.findByClosed", query = "SELECT a FROM Accounts a WHERE a.closed = :closed"), @NamedQuery(name = "Accounts.findByAccountNumber", query = "SELECT a FROM Accounts a WHERE a.accountNumber = :accountNumber")})
public class Accounts implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "id", nullable = false)
    private Integer id;
    @Column(name = "member_id")
    private Integer memberId;
    @Column(name = "scheme_id")
    private Integer schemeId;
    @Column(name = "commencement")
    @Temporal(TemporalType.TIMESTAMP)
    private Date commencement;
    @Column(name = "closed")
    private Integer closed;
    @Column(name = "account_number")
    private Integer accountNumber;

    public Accounts() {
    }

    public Accounts(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getMemberId() {
        return memberId;
    }

    public void setMemberId(Integer memberId) {
        this.memberId = memberId;
    }

    public Integer getSchemeId() {
        return schemeId;
    }

    public void setSchemeId(Integer schemeId) {
        this.schemeId = schemeId;
    }

    public Date getCommencement() {
        return commencement;
    }

    public void setCommencement(Date commencement) {
        this.commencement = commencement;
    }

    public Integer getClosed() {
        return closed;
    }

    public void setClosed(Integer closed) {
        this.closed = closed;
    }

    public Integer getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(Integer accountNumber) {
        this.accountNumber = accountNumber;
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
        if (!(object instanceof Accounts)) {
            return false;
        }
        Accounts other = (Accounts) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "" + accountNumber ;
    }

}
