/*
 * MDSViewSchemes.java
 *
 * Created on June 26, 2010, 2:24 PM
 */
package bankingapp;

import bankingapp.Mds;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.beans.PropertyVetoException;
import java.text.MessageFormat;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.swing.JOptionPane;
import javax.swing.JTable.PrintMode;
import javax.swing.table.DefaultTableModel;
import org.jdesktop.application.Action;

/**
 *
 * @author  s
 */
public class MDSViewSchemes extends javax.swing.JInternalFrame {

    private EntityManager BankingPUEntityManager;

    /** Creates new form MDSViewSchemes */
    public MDSViewSchemes() {
        initComponents();
        BankingPUEntityManager = javax.persistence.Persistence.createEntityManagerFactory("BankingAppPU").createEntityManager();

        populateTable(null);
    }

    private void populateTable(Mds m) {
        //String dd = "2010-07-16";
        String[] columns = {"Installment Num.", "Installment Amt", "Chitty Amount", "Chitty"};
        String sql = "SELECT installment,installmentAmount,amount,name FROM mds_details inner join mds on mds_details.mds_id = mds.id ";
        String orderBySql = " order by name,installment ";
        if(m!=null){
            sql+= " where mds.id = "+m.getId();
        }
        sql+=orderBySql;
        System.out.println(sql);
        Query q = BankingPUEntityManager.createNativeQuery(sql);
        List l = q.getResultList();
        String[][] data = new String[l.size()][4];
        int i = 0;
        for (Iterator it = l.iterator(); it.hasNext();) {
            Object object = it.next();
            Vector v = (Vector) object;
            data[i][0] =  ((Integer) v.get(0)).toString();
            data[i][1] = ((Double) v.get(1)) == null ? "" : ((Double) v.get(1)).toString();
            data[i][2] = ((Double) v.get(2)) == null ? "" : ((Double) v.get(2)).toString();
            data[i][3] = (String) v.get(3);
            i++;
        }
        DefaultTableModel dtm = new DefaultTableModel(data, columns);
        jTable1.setModel(dtm);
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        bindingGroup = new org.jdesktop.beansbinding.BindingGroup();

        BankingAppPUEntityManager = javax.persistence.Persistence.createEntityManagerFactory("BankingAppPU").createEntityManager();
        mdsQuery = BankingAppPUEntityManager.createQuery("SELECT m FROM Mds m");
        mdsList = mdsQuery.getResultList();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton2 = new javax.swing.JButton();
        openingBalanceLabel = new javax.swing.JLabel();
        closingBalanceLabel = new javax.swing.JLabel();
        schemeCombo = new javax.swing.JComboBox();
        jButton3 = new javax.swing.JButton();

        setClosable(true);
        setMaximizable(true);
        setResizable(true);
        org.jdesktop.application.ResourceMap resourceMap = org.jdesktop.application.Application.getInstance(bankingapp.BankingApp.class).getContext().getResourceMap(MDSViewSchemes.class);
        setTitle(resourceMap.getString("Form.title")); // NOI18N
        setName("Form"); // NOI18N

        jLabel1.setFont(resourceMap.getFont("jLabel1.font")); // NOI18N
        jLabel1.setText(resourceMap.getString("jLabel1.text")); // NOI18N
        jLabel1.setName("jLabel1"); // NOI18N

        javax.swing.ActionMap actionMap = org.jdesktop.application.Application.getInstance(bankingapp.BankingApp.class).getContext().getActionMap(MDSViewSchemes.class, this);
        jButton1.setAction(actionMap.get("showSchemeWise")); // NOI18N
        jButton1.setFont(resourceMap.getFont("jLabel1.font")); // NOI18N
        jButton1.setText(resourceMap.getString("jButton1.text")); // NOI18N
        jButton1.setName("jButton1"); // NOI18N

        jScrollPane1.setName("jScrollPane1"); // NOI18N

        jTable1.setFont(resourceMap.getFont("jTable1.font")); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jTable1.setName("jTable1"); // NOI18N
        jScrollPane1.setViewportView(jTable1);

        jButton2.setAction(actionMap.get("printTable")); // NOI18N
        jButton2.setText(resourceMap.getString("jButton2.text")); // NOI18N
        jButton2.setName("jButton2"); // NOI18N

        openingBalanceLabel.setText(resourceMap.getString("openingBalanceLabel.text")); // NOI18N
        openingBalanceLabel.setName("openingBalanceLabel"); // NOI18N

        closingBalanceLabel.setText(resourceMap.getString("closingBalanceLabel.text")); // NOI18N
        closingBalanceLabel.setName("closingBalanceLabel"); // NOI18N

        schemeCombo.setName("schemeCombo"); // NOI18N

        org.jdesktop.swingbinding.JComboBoxBinding jComboBoxBinding = org.jdesktop.swingbinding.SwingBindings.createJComboBoxBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, mdsList, schemeCombo);
        bindingGroup.addBinding(jComboBoxBinding);

        jButton3.setText(resourceMap.getString("jButton3.text")); // NOI18N
        jButton3.setName("jButton3"); // NOI18N
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 731, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(66, 66, 66)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(schemeCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(59, 59, 59)
                .addComponent(jButton1)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(openingBalanceLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 254, Short.MAX_VALUE)
                        .addComponent(closingBalanceLabel)
                        .addGap(214, 214, 214))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(42, 42, 42)
                        .addComponent(jButton3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 249, Short.MAX_VALUE)
                        .addComponent(jButton2)
                        .addGap(63, 63, 63))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jButton1)
                    .addComponent(openingBalanceLabel)
                    .addComponent(closingBalanceLabel)
                    .addComponent(jButton2)
                    .addComponent(schemeCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        bindingGroup.bind();

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        deleteMds();
    }//GEN-LAST:event_jButton3ActionPerformed
    void deleteMds(){
        try {
            if (!(JOptionPane.showConfirmDialog(this, "Are you sure to delete ? Please make sure that no transactions are made on this MDS scheme.") == JOptionPane.YES_OPTION)) {
                return;
            }
            Mds m = (Mds) schemeCombo.getSelectedItem();

            BankingAppPUEntityManager.getTransaction().begin();
            BankingAppPUEntityManager.remove(m);
            BankingAppPUEntityManager.getTransaction().commit();
            JOptionPane.showMessageDialog(this, "Scheme Deleted");

            this.setClosed(true);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(),"ERROR",JOptionPane.ERROR_MESSAGE);
        }
    }
    
    @Action
    public void showSchemeWise() {
        Mds m = (Mds) schemeCombo.getSelectedItem();
        populateTable(m);
    }
    
    @Action
    public void printTable() {
        try {
            /*
            jTable1.print();                                        
             */
            org.jdesktop.application.ResourceMap resourceMap = org.jdesktop.application.Application.getInstance(bankingapp.BankingApp.class).getContext().getResourceMap(ReportCashBook.class);
            //jTable1.print(PrintMode.FIT_WIDTH,new MessageFormat(resourceMap.getString("print.first")+"-{0}-"+resourceMap.getString("print.second")+resourceMap.getString("print.third")),null);
            
            
            PrinterJob job = PrinterJob.getPrinterJob();
            MessageFormat[] header = new MessageFormat[8];
            header[0] = new MessageFormat("");
            header[1] = new MessageFormat("                      " + resourceMap.getString("print.first"));
            header[2] = new MessageFormat("                      " + resourceMap.getString("print.second"));
            header[3] = new MessageFormat("                      " + resourceMap.getString("print.third"));
            header[4] = new MessageFormat("");

            header[5] = new MessageFormat("                                    Chitty Schemes  ");
            header[6] = new MessageFormat("");
            
            MessageFormat[] footer = new MessageFormat[1];
            footer[0] = new MessageFormat("--{0}--");
            job.setPrintable(new MyTablePrintable(jTable1, PrintMode.FIT_WIDTH, header, footer));
            job.print();
        } catch (PrinterException ex) {
            Logger.getLogger(ReportCashBook.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.persistence.EntityManager BankingAppPUEntityManager;
    private javax.swing.JLabel closingBalanceLabel;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private java.util.List<bankingapp.Mds> mdsList;
    private javax.persistence.Query mdsQuery;
    private javax.swing.JLabel openingBalanceLabel;
    private javax.swing.JComboBox schemeCombo;
    private org.jdesktop.beansbinding.BindingGroup bindingGroup;
    // End of variables declaration//GEN-END:variables
}
