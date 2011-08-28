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
 * @author s
 */
@Entity
@Table(name = "mds_payments")
@NamedQueries({@NamedQuery(name = "MdsPayments.findById", query = "SELECT m FROM MdsPayments m WHERE m.id = :id"), @NamedQuery(name = "MdsPayments.findByMdsDetailsId", query = "SELECT m FROM MdsPayments m WHERE m.mdsDetailsId = :mdsDetailsId"), @NamedQuery(name = "MdsPayments.findByTransactionsId", query = "SELECT m FROM MdsPayments m WHERE m.transactionsId = :transactionsId"), @NamedQuery(name = "MdsPayments.findByUserMdsId", query = "SELECT m FROM MdsPayments m WHERE m.userMdsId = :userMdsId")})
public class MdsPayments implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "id", nullable = false)
    private Integer id;
    @Column(name = "mds_details_id")
    private Integer mdsDetailsId;
    @Column(name = "transactions_id")
    private Integer transactionsId;
    @Column(name = "user_mds_id")
    private Integer userMdsId;

    public MdsPayments() {
    }

    public MdsPayments(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getMdsDetailsId() {
        return mdsDetailsId;
    }

    public void setMdsDetailsId(Integer mdsDetailsId) {
        this.mdsDetailsId = mdsDetailsId;
    }

    public Integer getTransactionsId() {
        return transactionsId;
    }

    public void setTransactionsId(Integer transactionsId) {
        this.transactionsId = transactionsId;
    }

    public Integer getUserMdsId() {
        return userMdsId;
    }

    public void setUserMdsId(Integer userMdsId) {
        this.userMdsId = userMdsId;
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
        if (!(object instanceof MdsPayments)) {
            return false;
        }
        MdsPayments other = (MdsPayments) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "bankingapp.MdsPayments[id=" + id + "]";
    }

}
