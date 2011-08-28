/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bankingapp;

import bankingapp.utils.EnglishNumberToWords;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author s
 */
public class PrintDemon  {

    static ArrayList payments;
    static ArrayList reciepts;
    static String user;
    static PrintDemon me;

    public PrintDemon() {
        payments = new ArrayList();
        reciepts = new ArrayList();
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        PrinterJob job = PrinterJob.getPrinterJob();
        job.setPrintable(new Printables());
        boolean doPrint = job.printDialog();
        if (doPrint) {
            try {
                job.print();
            } catch (PrinterException e) {
                /* The job did not successfully complete */
                e.printStackTrace();
            }
        }

    }
    
    public static PrintDemon getInstance(){
        if(me==null){
            me = new PrintDemon();
        }
        return me;
    }
    public void consolePrint(){
        
        Iterator i = reciepts.iterator();
        while(i.hasNext()){
            String[] a = (String[]) i.next();
            System.out.println(a[0]+"--"+a[1]);
        }
    }
    public void print(String toadd){
        PrintDemon.user = toadd;
        (new Printables()).go();
    }
}
class Printables implements Printable{
    private EntityManager BankingPUEntityManager;
    public int print(Graphics graphics, PageFormat pageFormat, int pageIndex) throws PrinterException {
        if (pageIndex > 0) { /* We have only one page, and 'page' is zero-based */
            return NO_SUCH_PAGE;
        }

        Graphics2D g2d = (Graphics2D) graphics;
        g2d.translate(pageFormat.getImageableX(), pageFormat.getImageableY());
        
        /* Now we perform our rendering */
        graphics.setFont(new Font("Serif",Font.BOLD,13));
        int y =100;
        org.jdesktop.application.ResourceMap resourceMap = org.jdesktop.application.Application.getInstance(bankingapp.BankingApp.class).getContext().getResourceMap(ReportCashBook.class);
        graphics.drawString(resourceMap.getString("print.first"), 25, 100);
        graphics.drawString(resourceMap.getString("print.second"), 30, y+=20);
        graphics.drawString(resourceMap.getString("print.third"), 55, y+=20);
        graphics.setFont(new Font("Serif",Font.PLAIN,12));
        BankingPUEntityManager = javax.persistence.Persistence.createEntityManagerFactory("BankingAppPU").createEntityManager();
        Query schemeId = BankingPUEntityManager.createQuery("SELECT s.value FROM Settings s where s.parameter='billno'");
        String sBillNo = (String) schemeId.getSingleResult();
        Query update = BankingPUEntityManager.createNativeQuery("UPDATE settings set value = '"+(Integer.parseInt(sBillNo)+1)+"' where parameter = 'billno'");
        BankingPUEntityManager.getTransaction().begin();
        System.out.println("About to update to a value "+sBillNo+"+1");
        update.executeUpdate();
        BankingPUEntityManager.getTransaction().commit();
        graphics.drawString("Serial No. "+Integer.parseInt(sBillNo)/2, 15, y+=40);
        graphics.drawString("Date. "+new Date(), 185, y);
        
        graphics.setFont(new Font("Serif",Font.BOLD,14));
        graphics.drawString("RECEIPT", 125, y+=30);
        graphics.setFont(new Font("Serif",Font.PLAIN,12));
        graphics.drawString("Recieved to the credit of  "+PrintDemon.user, 15, y+=50);
        graphics.drawString("The following amounts under the following heads of accounts", 15, y+=30);
        
        graphics.drawLine(15,y+=20, 350, y);
        int starty = y;
        graphics.drawString("Particulars/Details ", 90,y+=20);
        graphics.drawString("Amount ", 260, y);
        graphics.drawLine(15,y+=20, 350, y);
        int ycod = y+20;
        Iterator i = PrintDemon.reciepts.iterator();
        
        System.out.println("size -- "+PrintDemon.reciepts.size());
        double total = 0d;
        while(i.hasNext()){
            String[] s = (String[]) i.next();
            graphics.drawString(s[0], 40, ycod);
            graphics.drawString(s[1], 260, ycod);
            try{
                total += Double.parseDouble(s[1]);
            }
            catch(Exception e){
                
            }
            ycod += 20;
        }
        graphics.setFont(new Font("Serif",Font.BOLD,14));
        //graphics.drawLine(250,starty, 250, ycod);
        graphics.drawString("Total", 40, ycod);
        graphics.drawString(total+"", 260, ycod);
        ycod+=20;    
        graphics.drawLine(250,starty, 250, ycod);
        graphics.drawLine(15,starty, 15, ycod);
        graphics.drawLine(350,starty, 350, ycod);
        graphics.drawLine(15,ycod, 350, ycod);
        ycod+=20;
        graphics.setFont(new Font("Serif",Font.PLAIN,12));
        
        int decimal = (int)total;
        int fraction = (int)((total-decimal)*100);
        System.out.println(total);
        System.out.println(decimal);
        System.out.println(total-decimal);
        graphics.drawString("** "+EnglishNumberToWords.convert(decimal)+" Rupees "+EnglishNumberToWords.convert(fraction)+" Paise Only **", 40, ycod);
        ycod+=20;
        graphics.drawString("Secretary", 260, ycod);
        //PrintDemon.me = null;
        return PAGE_EXISTS;

    }
    public void go(){
         PrinterJob job = PrinterJob.getPrinterJob();
        job.setPrintable(new Printables());
        boolean doPrint = job.printDialog();
        if (doPrint) {
            try {
                job.print();
            } catch (PrinterException e) {
                /* The job did not successfully complete */
                e.printStackTrace();
            }
        }
    }
}