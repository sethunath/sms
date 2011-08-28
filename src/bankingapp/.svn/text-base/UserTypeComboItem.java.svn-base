/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package bankingapp;

/**
 *
 * @author s
 */
public class UserTypeComboItem {
    private String column;
    private String label;

    public UserTypeComboItem(String column, String label) {
        this.column = column;
        this.label = label;
    }

    public String getColumn() {
        return column;
    }

    public void setColumn(String column) {
        this.column = column;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }
    public static UserTypeComboItem[]  constructMenuItem(){
        UserTypeComboItem[] arr = new UserTypeComboItem[2];
        arr[0] = new UserTypeComboItem("username", "Username");
        arr[1] = new UserTypeComboItem("number", "Membership Number");
        return arr;
        
    }

    @Override
    public String toString() {
        return label;
    }
    
}
