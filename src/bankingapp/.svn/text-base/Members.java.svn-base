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
@Table(name = "members")
@NamedQueries({@NamedQuery(name = "Members.findById", query = "SELECT m FROM Members m WHERE m.id = :id"), @NamedQuery(name = "Members.findByUsername", query = "SELECT m FROM Members m WHERE m.username = :username"), @NamedQuery(name = "Members.findByNumber", query = "SELECT m FROM Members m WHERE m.number = :number")})
public class Members implements Serializable, Comparable {

    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);
    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "id", nullable = false)
    private Integer id;
    @Column(name = "username")
    private String username;
    @Column(name = "number")
    private String number;

    public Members() {
    }

    public Members(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        Integer oldId = this.id;
        this.id = id;
        changeSupport.firePropertyChange("id", oldId, id);
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        String oldUsername = this.username;
        this.username = username;
        changeSupport.firePropertyChange("username", oldUsername, username);
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        String oldNumber = this.number;
        this.number = number;
        changeSupport.firePropertyChange("number", oldNumber, number);
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
        if (!(object instanceof Members)) {
            return false;
        }
        Members other = (Members) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return number + "-" + username;
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public int compareTo(Object o) {
        //System.out.println("compare to");
        Members m = (Members) o;
        boolean firstC = false;
        boolean secondC = false;
        int first = 0;
        int second = 0;
        
        try {
            first = Integer.parseInt(number);
        } catch (Exception e) {
            try {
                first = Integer.parseInt(number.substring(1));
                firstC = true;
            } catch (Exception e1) {

            }
        }
        try {

            second = Integer.parseInt(m.number);

        } catch (Exception e) {
            try {
                second = Integer.parseInt(m.number.substring(1));
                secondC =true;
            } catch (Exception e1) {

            }
        }
        if(firstC){
            first +=10000;
        }
        if(secondC){
            second +=10000;
        }
        return first - second;

    }
}
