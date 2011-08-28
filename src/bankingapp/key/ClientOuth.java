/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package bankingapp.key;

import bankingapp.crypto.DesEncrypter;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.net.NetworkInterface;
import java.util.Date;
import java.util.Enumeration;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author sethunath | mailsethu@gmail.com
 */
public class ClientOuth {
    public static boolean goodToGoClient(String macAddress){
        boolean b = false;
        try{
            String myMac = "002564724216";
            Enumeration<NetworkInterface> ni = MacHandler.getMac();
            while (ni.hasMoreElements()) {
                NetworkInterface n = ni.nextElement();
                byte[] arr = n.getHardwareAddress();
                if (n.getHardwareAddress() == null) {
                    continue;
                }
                String m = MacHandler.byteArrayToHexString(arr);
                if(myMac.equalsIgnoreCase(m)){
                    b=true;
                    break;
                }
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return b;
    }
    public static boolean goodToGo(){
        boolean yes = false;
        String keyStr = getKeyString();
        String timeStr = keyStr.substring(0, 13);
        String clientStr = keyStr.substring(13);
        yes = goodToGoClient(clientStr)&&goodToGoTime(Long.parseLong(timeStr));
        System.out.println(goodToGoClient(clientStr)+"-client  time-"+goodToGoTime(Long.parseLong(timeStr)));
        return yes;
    }
    public static String getKeyString(){
        BufferedReader br = null;
        String l = null;
        try {
            String ks = null;
            br = new BufferedReader(new FileReader("key.txt"));
            l = br.readLine();
            l=(new DesEncrypter()).decrypt(l);
        } catch (IOException ex) {
            Logger.getLogger(ClientOuth.class.getName()).log(Level.SEVERE, null, ex);
        }  finally {
            try {
                br.close();
            } catch (IOException ex) {
                Logger.getLogger(ClientOuth.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return l;
    }
    public static boolean goodToGoTime(long t){
        boolean b = false;
        Date d = new java.sql.Date(t);
        b = (new Date()).getTime()<(d).getTime();
        return b;
    }
    public static void main(String args[]){
        System.out.println(goodToGo());
    }
}
