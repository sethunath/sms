/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bankingapp;

import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Enumeration;

/**
 *
 * @author s
 */
public class NewMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SocketException {
        // TODO code application logic here
        Enumeration<NetworkInterface> ni = java.net.NetworkInterface.getNetworkInterfaces();
        while (ni.hasMoreElements()) {
            NetworkInterface n = ni.nextElement();
            byte arr[] = n.getHardwareAddress();
            if (n.getHardwareAddress() == null) {
                continue;
            }
//            for (byte b : arr) {
//                System.out.print(b);
//            }
            System.out.println(byteArrayToHexString(arr));
        }
    }

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
}
