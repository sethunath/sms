/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package bankingapp.utils;

import javax.swing.InputVerifier;
import javax.swing.JComponent;
import javax.swing.JTextField;

/**
 *
 * @author sethunath | mailsethu@gmail.com
 */
public  class DoubleVerifier extends InputVerifier {

        @Override
        public boolean verify(JComponent input) {
            JTextField jtf = (JTextField) input;
            String strVal = jtf.getText();
            try {
                Double.parseDouble(strVal);
            } catch (NumberFormatException e) {
                return false;
            }
            return true;
        }
 }