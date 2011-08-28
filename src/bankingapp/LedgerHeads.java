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
@Table(name = "ledger_heads")
@NamedQueries({@NamedQuery(name = "LedgerHeads.findById", query = "SELECT l FROM LedgerHeads l WHERE l.id = :id"), @NamedQuery(name = "LedgerHeads.findByLedgerHead", query = "SELECT l FROM LedgerHeads l WHERE l.ledgerHead = :ledgerHead")})
public class LedgerHeads implements Serializable {
    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);
    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "id", nullable = false)
    private Integer id;
    @Column(name = "ledger_head", nullable = false)
    private String ledgerHead;

    public LedgerHeads() {
    }

    public LedgerHeads(Integer id) {
        this.id = id;
    }

    public LedgerHeads(Integer id, String ledgerHead) {
        this.id = id;
        this.ledgerHead = ledgerHead;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        Integer oldId = this.id;
        this.id = id;
        changeSupport.firePropertyChange("id", oldId, id);
    }

    public String getLedgerHead() {
        return ledgerHead;
    }

    public void setLedgerHead(String ledgerHead) {
        String oldLedgerHead = this.ledgerHead;
        this.ledgerHead = ledgerHead;
        changeSupport.firePropertyChange("ledgerHead", oldLedgerHead, ledgerHead);
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
        if (!(object instanceof LedgerHeads)) {
            return false;
        }
        LedgerHeads other = (LedgerHeads) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return ledgerHead;
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

}
