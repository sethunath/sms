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
@Table(name = "user_mds")
@NamedQueries({@NamedQuery(name = "UserMds.findById", query = "SELECT u FROM UserMds u WHERE u.id = :id"), @NamedQuery(name = "UserMds.findByMembersId", query = "SELECT u FROM UserMds u WHERE u.membersId = :membersId"), @NamedQuery(name = "UserMds.findByMdsId", query = "SELECT u FROM UserMds u WHERE u.mdsId = :mdsId"), @NamedQuery(name = "UserMds.findByAccountsId", query = "SELECT u FROM UserMds u WHERE u.accountsId = :accountsId"), @NamedQuery(name = "UserMds.findByCommencemment", query = "SELECT u FROM UserMds u WHERE u.commencemment = :commencemment")})
public class UserMds implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "id", nullable = false)
    private Integer id;
    @Column(name = "members_id")
    private Integer membersId;
    @Column(name = "mds_id")
    private Integer mdsId;
    @Column(name = "accounts_id")
    private Integer accountsId;
    @Column(name = "commencemment")
    @Temporal(TemporalType.TIMESTAMP)
    private Date commencemment;

    public UserMds() {
    }

    public UserMds(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getMembersId() {
        return membersId;
    }

    public void setMembersId(Integer membersId) {
        this.membersId = membersId;
    }

    public Integer getMdsId() {
        return mdsId;
    }

    public void setMdsId(Integer mdsId) {
        this.mdsId = mdsId;
    }

    public Integer getAccountsId() {
        return accountsId;
    }

    public void setAccountsId(Integer accountsId) {
        this.accountsId = accountsId;
    }

    public Date getCommencemment() {
        return commencemment;
    }

    public void setCommencemment(Date commencemment) {
        this.commencemment = commencemment;
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
        if (!(object instanceof UserMds)) {
            return false;
        }
        UserMds other = (UserMds) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "bankingapp.UserMds[id=" + id + "]";
    }

}
