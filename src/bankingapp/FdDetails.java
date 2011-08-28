/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package bankingapp;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 *
 * @author Sethunath (mailsethu@gmail.com)
 */
@Entity
@Table(name = "fd_details")
@NamedQueries({@NamedQuery(name = "FdDetails.findAll", query = "SELECT f FROM FdDetails f"), @NamedQuery(name = "FdDetails.findById", query = "SELECT f FROM FdDetails f WHERE f.id = :id"), @NamedQuery(name = "FdDetails.findByDuration", query = "SELECT f FROM FdDetails f WHERE f.duration = :duration"), @NamedQuery(name = "FdDetails.findByAccountId", query = "SELECT f FROM FdDetails f WHERE f.accountId = :accountId")})
public class FdDetails implements Serializable {
    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "duration")
    private int duration;
    @Basic(optional = false)
    @Column(name = "account_id")
    private int accountId;

    public FdDetails() {
    }

    public FdDetails(Integer id) {
        this.id = id;
    }

    public FdDetails(Integer id, int duration, int accountId) {
        this.id = id;
        this.duration = duration;
        this.accountId = accountId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        Integer oldId = this.id;
        this.id = id;
        changeSupport.firePropertyChange("id", oldId, id);
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        int oldDuration = this.duration;
        this.duration = duration;
        changeSupport.firePropertyChange("duration", oldDuration, duration);
    }

    public int getAccountId() {
        return accountId;
    }

    public void setAccountId(int accountId) {
        int oldAccountId = this.accountId;
        this.accountId = accountId;
        changeSupport.firePropertyChange("accountId", oldAccountId, accountId);
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
        if (!(object instanceof FdDetails)) {
            return false;
        }
        FdDetails other = (FdDetails) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "bankingapp.FdDetails[id=" + id + "]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

}
