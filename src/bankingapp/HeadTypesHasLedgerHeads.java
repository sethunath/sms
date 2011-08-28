/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package bankingapp;

import java.io.Serializable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author sethunath | mailsethu@gmail.com
 */
@Entity
@Table(name = "head_types_has_ledger_heads")
@NamedQueries({@NamedQuery(name = "HeadTypesHasLedgerHeads.findByHeadTypesId", query = "SELECT h FROM HeadTypesHasLedgerHeads h WHERE h.headTypesHasLedgerHeadsPK.headTypesId = :headTypesId"), @NamedQuery(name = "HeadTypesHasLedgerHeads.findByLedgerHeadsId", query = "SELECT h FROM HeadTypesHasLedgerHeads h WHERE h.headTypesHasLedgerHeadsPK.ledgerHeadsId = :ledgerHeadsId")})
public class HeadTypesHasLedgerHeads implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected HeadTypesHasLedgerHeadsPK headTypesHasLedgerHeadsPK;

    public HeadTypesHasLedgerHeads() {
    }

    public HeadTypesHasLedgerHeads(HeadTypesHasLedgerHeadsPK headTypesHasLedgerHeadsPK) {
        this.headTypesHasLedgerHeadsPK = headTypesHasLedgerHeadsPK;
    }

    public HeadTypesHasLedgerHeads(int headTypesId, int ledgerHeadsId) {
        this.headTypesHasLedgerHeadsPK = new HeadTypesHasLedgerHeadsPK(headTypesId, ledgerHeadsId);
    }

    public HeadTypesHasLedgerHeadsPK getHeadTypesHasLedgerHeadsPK() {
        return headTypesHasLedgerHeadsPK;
    }

    public void setHeadTypesHasLedgerHeadsPK(HeadTypesHasLedgerHeadsPK headTypesHasLedgerHeadsPK) {
        this.headTypesHasLedgerHeadsPK = headTypesHasLedgerHeadsPK;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (headTypesHasLedgerHeadsPK != null ? headTypesHasLedgerHeadsPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof HeadTypesHasLedgerHeads)) {
            return false;
        }
        HeadTypesHasLedgerHeads other = (HeadTypesHasLedgerHeads) object;
        if ((this.headTypesHasLedgerHeadsPK == null && other.headTypesHasLedgerHeadsPK != null) || (this.headTypesHasLedgerHeadsPK != null && !this.headTypesHasLedgerHeadsPK.equals(other.headTypesHasLedgerHeadsPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "bankingapp.HeadTypesHasLedgerHeads[headTypesHasLedgerHeadsPK=" + headTypesHasLedgerHeadsPK + "]";
    }

}
