/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bankingapp.key;

import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Enumeration;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author sethunath | mailsethu@gmail.com
 */
public class MacHandler {

    static String byteArrayToHexString(byte in[]) {

        byte ch = 0x00;

        int i = 0;

        if (in == null || in.length <= 0) {
            return null;
        }



        String pseudo[] = {"0", "1", "2",
            "3", "4", "5", "6", "7", "8",
            "9", "A", "B", "C", "D", "E",
            "F"
        };

        StringBuffer out = new StringBuffer(in.length * 2);



        while (i < in.length) {

            ch = (byte) (in[i] & 0xF0); // Strip off

            ch = (byte) (ch >>> 4);
            // shift the bits down

            ch = (byte) (ch & 0x0F);
// must do this is high order bit is on!

            out.append(pseudo[(int) ch]); // convert the

            ch = (byte) (in[i] & 0x0F); // Strip off



            out.append(pseudo[(int) ch]); // convert the






            i++;

        }

        String rslt = new String(out);

        return rslt;

    }

    static Enumeration<NetworkInterface> getMac() {
        Enumeration<NetworkInterface> ni = null;
        try {

             ni = java.net.NetworkInterface.getNetworkInterfaces();
//            while (ni.hasMoreElements()) {
//                NetworkInterface n = ni.nextElement();
//                byte[] arr = n.getHardwareAddress();
//                if (n.getHardwareAddress() == null) {
//                    continue;
//                }
////            for (byte b : arr) {
////                System.out.print(b);
////            }
//                //jEditorPane1.setText(jEditorPane1.getText() + "\n" + byteArrayToHexString(arr));
//            }
        } catch (SocketException ex) {
            Logger.getLogger(MacHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ni;
    }
}
