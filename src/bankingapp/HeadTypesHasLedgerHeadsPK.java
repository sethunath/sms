/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package bankingapp;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author sethunath | mailsethu@gmail.com
 */
@Embeddable
public class HeadTypesHasLedgerHeadsPK implements Serializable {
    @Column(name = "head_types_id", nullable = false)
    private int headTypesId;
    @Column(name = "ledger_heads_id", nullable = false)
    private int ledgerHeadsId;

    public HeadTypesHasLedgerHeadsPK() {
    }

    public HeadTypesHasLedgerHeadsPK(int headTypesId, int ledgerHeadsId) {
        this.headTypesId = headTypesId;
        this.ledgerHeadsId = ledgerHeadsId;
    }

    public int getHeadTypesId() {
        return headTypesId;
    }

    public void setHeadTypesId(int headTypesId) {
        this.headTypesId = headTypesId;
    }

    public int getLedgerHeadsId() {
        return ledgerHeadsId;
    }

    public void setLedgerHeadsId(int ledgerHeadsId) {
        this.ledgerHeadsId = ledgerHeadsId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) headTypesId;
        hash += (int) ledgerHeadsId;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof HeadTypesHasLedgerHeadsPK)) {
            return false;
        }
        HeadTypesHasLedgerHeadsPK other = (HeadTypesHasLedgerHeadsPK) object;
        if (this.headTypesId != other.headTypesId) {
            return false;
        }
        if (this.ledgerHeadsId != other.ledgerHeadsId) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "bankingapp.HeadTypesHasLedgerHeadsPK[headTypesId=" + headTypesId + ", ledgerHeadsId=" + ledgerHeadsId + "]";
    }

}
