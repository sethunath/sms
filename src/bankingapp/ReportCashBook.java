/*
 * ReportCashBook.java
 *
 * Created on July 17, 2010, 5:36 AM
 */
package bankingapp;

import bankingapp.LedgerHeads;
import bankingapp.utils.ExcelExporter;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.io.File;
import java.io.IOException;
import java.text.MessageFormat;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JFileChooser;
import javax.swing.JTable.PrintMode;
import javax.swing.table.DefaultTableModel;
import org.jdesktop.application.Action;
import javax.swing.filechooser.FileFilter;

/**
 *
 * @author  s
 */
public class ReportCashBook extends javax.swing.JInternalFrame {

    private EntityManager BankingPUEntityManager;
    private String sourceQuery = "select members.username,members.number,transactions.deposit,transactions.withdrawal,transactions.`timestamp`,concat(ledger_heads.ledger_head,'-',ifnull(accounts.account_number,''),'-',ifnull(transaction_details.remarks,'')) as leadger_head from transactions inner join members on members.id = transactions.user_id inner join ledger_heads on transactions.lledger_head_id = ledger_heads.id left join accounts on transactions.account_id = accounts.id left join transaction_details on transactions.id=transaction_details.transaction_id ";
    private String totalQuery = "select 'Total' as username,'' as number ,sum(transactions.deposit) as deposit,sum(transactions.withdrawal) as withdrawal,NULL as `timestamp` ,'' as ledger_head from transactions inner join members on members.id = transactions.user_id inner join ledger_heads on transactions.lledger_head_id = ledger_heads.id left join accounts on transactions.account_id = accounts.id ";

    /** Creates new form ReportCashBook */
    public ReportCashBook() {
        BankingPUEntityManager = javax.persistence.Persistence.createEntityManagerFactory("BankingAppPU").createEntityManager();
        initComponents();

        SortCriteria[] sc = {new SortCriteria("Date", "transactions.`timestamp` desc"), new SortCriteria("Category", "ledger_heads.ledger_head")};
        DefaultComboBoxModel dcm = new DefaultComboBoxModel(sc);
        jComboBox1.setModel(dcm);
        populateTable();
    }

    private void populateTable() {
        String[] columns = {"Member", "Member Id", "Reciepts", "Payments", "Date", "Category"};
        String sql = sourceQuery;
        String sql1 = totalQuery;
        if (betweenCheckBox.isSelected()) {
            java.util.Date s = (java.util.Date) dateFrom.getValue();
            String dateStringFrom = (s.getYear() + 1900) + "-" + ((s.getMonth() < 10) ? "0" + (s.getMonth() + 1) : (s.getMonth() + 1)) + "-" + s.getDate();
            s = (java.util.Date) dateTo.getValue();
            String dateStringTo = (s.getYear() + 1900) + "-" + ((s.getMonth() < 10) ? "0" + (s.getMonth() + 1) : (s.getMonth() + 1)) + "-" + s.getDate();
            sql += " where transactions.`timestamp` between '" + dateStringFrom + "' and '" + dateStringTo + "' ";
            sql1 += " where transactions.`timestamp` between '" + dateStringFrom + "' and '" + dateStringTo + "' ";
        }
//        else{
//            sql+=" LIMIT 0,500";
//            sql1+=" LIMIT 0,500";
//        }
        //sql += " order by `timestamp` desc ";
        String ss = "(" + sql + ") union (" + sql1 + ")";
        ss += " order by `timestamp` desc ";
        Query q = BankingPUEntityManager.createNativeQuery(ss);
        List l = q.getResultList();
        String[][] data = new String[l.size()][6];
        int i = 0;
        for (Iterator it = l.iterator(); it.hasNext();) {
            Object object = it.next();
            Vector v = (Vector) object;
            data[i][0] = (String) v.get(0);
            data[i][1] = (String) v.get(1);
            data[i][2] = ((Double) v.get(2)) == null ? "" : ((Double) v.get(2)).toString();
            data[i][3] = ((Double) v.get(3)) == null ? "" : ((Double) v.get(3)).toString();
            data[i][4] = v.get(4) != null ? ((java.sql.Timestamp) v.get(4)).toLocaleString() : "";
            data[i][5] = (String) v.get(5);
            i++;
        }
        DefaultTableModel dtm = new DefaultTableModel(data, columns);
        jTable1.setModel(dtm);
    }

    private void populateTable(LedgerHeads lh) {
        if (lh == null) {
            return;
        }
        String[] columns = {"Member", "Member Id", "Reciepts", "Payments", "Date", "Category"};
        String sql = sourceQuery + " where transactions.lledger_head_id = " + lh.getId();
        String sql1 = totalQuery + " where transactions.lledger_head_id = " + lh.getId();
        if (betweenCheckBox.isSelected()) {
            java.util.Date s = (java.util.Date) dateFrom.getValue();
            String dateStringFrom = (s.getYear() + 1900) + "-" + ((s.getMonth() < 9) ? "0" + (s.getMonth() + 1) : (s.getMonth() + 1)) + "-" + s.getDate();
            s = (java.util.Date) dateTo.getValue();
            String dateStringTo = (s.getYear() + 1900) + "-" + ((s.getMonth() < 9) ? "0" + (s.getMonth() + 1) : (s.getMonth() + 1)) + "-" + s.getDate();
            sql += " and transactions.`timestamp` between '" + dateStringFrom + "' and '" + dateStringTo + "' ";
            sql1 += " and transactions.`timestamp` between '" + dateStringFrom + "' and '" + dateStringTo + "' ";
        }
        String ss = "(" + sql + ") union (" + sql1 + ") ";
        ss += " order by `timestamp` desc ";
        System.out.println(ss);
        Query q = BankingPUEntityManager.createNativeQuery(ss);
        List l = q.getResultList();
        String[][] data = new String[l.size()][6];
        int i = 0;
        for (Iterator it = l.iterator(); it.hasNext();) {
            Object object = it.next();
            Vector v = (Vector) object;
            data[i][0] = (String) v.get(0);
            data[i][1] = (String) v.get(1);
            data[i][2] = ((Double) v.get(2)) == null ? "" : ((Double) v.get(2)).toString();
            data[i][3] = ((Double) v.get(3)) == null ? "" : ((Double) v.get(3)).toString();

            data[i][4] = v.get(4) == null ? "" : ((java.sql.Timestamp) v.get(4)).toLocaleString();
            data[i][5] = (String) v.get(5);
            i++;
        }
        DefaultTableModel dtm = new DefaultTableModel(data, columns);
        jTable1.setModel(dtm);
    }

    private void populateTable(String order_by) {

        String[] columns = {"Member", "Member Id", "Reciepts", "Payments", "Date", "Category"};
        String sql = sourceQuery;
        if (betweenCheckBox.isSelected()) {
            java.util.Date s = (java.util.Date) dateFrom.getValue();
            String dateStringFrom = (s.getYear() + 1900) + "-" + ((s.getMonth() < 9) ? "0" + (s.getMonth() + 1) : (s.getMonth() + 1)) + "-" + s.getDate();
            s = (java.util.Date) dateTo.getValue();
            String dateStringTo = (s.getYear() + 1900) + "-" + ((s.getMonth() < 9) ? "0" + (s.getMonth() + 1) : (s.getMonth() + 1)) + "-" + s.getDate();
            sql += " where transactions.`timestamp` between '" + dateStringFrom + "' and '" + dateStringTo + "' ";
        }
        sql += " order by " + order_by;
        Query q = BankingPUEntityManager.createNativeQuery(sql);
        List l = q.getResultList();
        String[][] data = new String[l.size()][6];
        int i = 0;
        for (Iterator it = l.iterator(); it.hasNext();) {
            Object object = it.next();
            Vector v = (Vector) object;
            data[i][0] = (String) v.get(0);
            data[i][1] = (String) v.get(1);
            data[i][2] = ((Double) v.get(2)) == null ? "" : ((Double) v.get(2)).toString();
            data[i][3] = ((Double) v.get(3)) == null ? "" : ((Double) v.get(3)).toString();

            data[i][4] = ((java.sql.Timestamp) v.get(4)).toLocaleString();
            data[i][5] = (String) v.get(5);
            i++;
        }
        DefaultTableModel dtm = new DefaultTableModel(data, columns);
        jTable1.setModel(dtm);
    }

    @Action
    public void exportToExcel() {
        try {
            if (saveFileChooser.showSaveDialog(this) == JFileChooser.APPROVE_OPTION) {
                File f = saveFileChooser.getSelectedFile();
                ExcelExporter ee = new ExcelExporter();
                ee.exportTable(jTable1, f);
            }
        } catch (IOException ex) {
            Logger.getLogger(ReportCashBook.class.getName()).log(Level.SEVERE, null, ex);
        }
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
        ledgerHeadsQuery = BankingAppPUEntityManager.createQuery("SELECT l FROM LedgerHeads l");
        ledgerHeadsList = ledgerHeadsQuery.getResultList();
        saveFileChooser = new javax.swing.JFileChooser();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox();
        jComboBox2 = new javax.swing.JComboBox();
        jCheckBox1 = new javax.swing.JCheckBox();
        jButton1 = new javax.swing.JButton();
        openingBalanceLabel = new javax.swing.JLabel();
        closingBalanceLabel = new javax.swing.JLabel();
        betweenCheckBox = new javax.swing.JCheckBox();
        dateFrom = new javax.swing.JSpinner();
        jLabel2 = new javax.swing.JLabel();
        dateTo = new javax.swing.JSpinner();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();

        org.jdesktop.application.ResourceMap resourceMap = org.jdesktop.application.Application.getInstance(bankingapp.BankingApp.class).getContext().getResourceMap(ReportCashBook.class);
        saveFileChooser.setDialogTitle(resourceMap.getString("saveFileChooser.dialogTitle")); // NOI18N
        saveFileChooser.setDialogType(javax.swing.JFileChooser.SAVE_DIALOG);
        saveFileChooser.setFileFilter(new FileFilter() {
            public String getDescription(){
                return "Save as XL Sheet";
            }
            public boolean accept(File f) {
                if(f.getName().endsWith("xls")||f.isDirectory()){
                    return true;
                }
                return false;
            }

        });
        saveFileChooser.setFileSelectionMode(javax.swing.JFileChooser.FILES_AND_DIRECTORIES);
        saveFileChooser.setName("saveFileChooser"); // NOI18N

        setClosable(true);
        setMaximizable(true);
        setTitle(resourceMap.getString("Form.title")); // NOI18N
        setName("Form"); // NOI18N

        jScrollPane2.setFont(resourceMap.getFont("jScrollPane2.font")); // NOI18N
        jScrollPane2.setName("jScrollPane2"); // NOI18N

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
        jScrollPane2.setViewportView(jTable1);

        jLabel1.setFont(resourceMap.getFont("betweenCheckBox.font")); // NOI18N
        jLabel1.setText(resourceMap.getString("jLabel1.text")); // NOI18N
        jLabel1.setName("jLabel1"); // NOI18N

        jComboBox1.setFont(resourceMap.getFont("betweenCheckBox.font")); // NOI18N
        jComboBox1.setName("jComboBox1"); // NOI18N
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });

        jComboBox2.setFont(resourceMap.getFont("betweenCheckBox.font")); // NOI18N
        jComboBox2.setEnabled(false);
        jComboBox2.setName("jComboBox2"); // NOI18N

        org.jdesktop.swingbinding.JComboBoxBinding jComboBoxBinding = org.jdesktop.swingbinding.SwingBindings.createJComboBoxBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, ledgerHeadsList, jComboBox2);
        bindingGroup.addBinding(jComboBoxBinding);

        jComboBox2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox2ActionPerformed(evt);
            }
        });

        jCheckBox1.setFont(resourceMap.getFont("betweenCheckBox.font")); // NOI18N
        jCheckBox1.setText(resourceMap.getString("jCheckBox1.text")); // NOI18N
        jCheckBox1.setName("jCheckBox1"); // NOI18N
        jCheckBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox1ActionPerformed(evt);
            }
        });

        jButton1.setText(resourceMap.getString("jButton1.text")); // NOI18N
        jButton1.setName("jButton1"); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        openingBalanceLabel.setText(resourceMap.getString("openingBalanceLabel.text")); // NOI18N
        openingBalanceLabel.setName("openingBalanceLabel"); // NOI18N

        closingBalanceLabel.setText(resourceMap.getString("closingBalanceLabel.text")); // NOI18N
        closingBalanceLabel.setName("closingBalanceLabel"); // NOI18N

        betweenCheckBox.setFont(resourceMap.getFont("betweenCheckBox.font")); // NOI18N
        betweenCheckBox.setText(resourceMap.getString("betweenCheckBox.text")); // NOI18N
        betweenCheckBox.setName("betweenCheckBox"); // NOI18N
        betweenCheckBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                betweenCheckBoxActionPerformed(evt);
            }
        });

        dateFrom.setFont(resourceMap.getFont("betweenCheckBox.font")); // NOI18N
        dateFrom.setModel(new javax.swing.SpinnerDateModel());
        dateFrom.setEditor(new javax.swing.JSpinner.DateEditor(dateFrom, "dd-MM-yyyy"));
        dateFrom.setEnabled(false);
        dateFrom.setName("dateFrom"); // NOI18N

        jLabel2.setFont(resourceMap.getFont("betweenCheckBox.font")); // NOI18N
        jLabel2.setText(resourceMap.getString("jLabel2.text")); // NOI18N
        jLabel2.setName("jLabel2"); // NOI18N

        dateTo.setFont(resourceMap.getFont("betweenCheckBox.font")); // NOI18N
        dateTo.setModel(new javax.swing.SpinnerDateModel());
        dateTo.setEditor(new javax.swing.JSpinner.DateEditor(dateTo, "dd-MM-yyyy"));
        dateTo.setEnabled(false);
        dateTo.setName("dateTo"); // NOI18N

        jButton2.setFont(resourceMap.getFont("betweenCheckBox.font")); // NOI18N
        jButton2.setText(resourceMap.getString("jButton2.text")); // NOI18N
        jButton2.setName("jButton2"); // NOI18N
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.ActionMap actionMap = org.jdesktop.application.Application.getInstance(bankingapp.BankingApp.class).getContext().getActionMap(ReportCashBook.class, this);
        jButton3.setAction(actionMap.get("exportToExcel")); // NOI18N
        jButton3.setText(resourceMap.getString("jButton3.text")); // NOI18N
        jButton3.setName("jButton3"); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 857, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(openingBalanceLabel)
                        .addGap(178, 178, 178)
                        .addComponent(closingBalanceLabel))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jButton3)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(20, 20, 20)
                                .addComponent(betweenCheckBox)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(dateFrom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel2)
                                .addGap(18, 18, 18)
                                .addComponent(dateTo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(36, 36, 36)
                                .addComponent(jButton2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 6, Short.MAX_VALUE)
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(28, 28, 28)
                                .addComponent(jCheckBox1)
                                .addGap(18, 18, 18)
                                .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jButton1)))
                        .addGap(84, 84, 84)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(71, Short.MAX_VALUE)
                .addComponent(jButton3)
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jCheckBox1)
                    .addComponent(jLabel1)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(openingBalanceLabel)
                    .addComponent(closingBalanceLabel)
                    .addComponent(betweenCheckBox)
                    .addComponent(dateFrom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(dateTo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2)
                    .addComponent(jButton1))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 402, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        bindingGroup.bind();

        pack();
    }// </editor-fold>//GEN-END:initComponents
    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        // TODO add your handling code here:
        SortCriteria sc = (SortCriteria) jComboBox1.getSelectedItem();
        populateTable(sc.column + ", transactions.`timestamp` desc ");
    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void jComboBox2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox2ActionPerformed
        // TODO add your handling code here:
        populateTable((LedgerHeads) jComboBox2.getSelectedItem());
    }//GEN-LAST:event_jComboBox2ActionPerformed

    private void jCheckBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox1ActionPerformed
        jComboBox2.setEnabled(jCheckBox1.isSelected());
        if (!jCheckBox1.isSelected()) {
            populateTable();
        } else {
            jComboBox2ActionPerformed(null);
        }
    }//GEN-LAST:event_jCheckBox1ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        try {
            /*
            jTable1.print();//GEN-LAST:event_jButton1ActionPerformed
            */
            org.jdesktop.application.ResourceMap resourceMap = org.jdesktop.application.Application.getInstance(bankingapp.BankingApp.class).getContext().getResourceMap(ReportCashBook.class);
             //jTable1.print(PrintMode.FIT_WIDTH,new MessageFormat(resourceMap.getString("print.first")+"-{0}-"+resourceMap.getString("print.second")+resourceMap.getString("print.third")),null);
            
            PrinterJob job = PrinterJob.getPrinterJob();
            MessageFormat[] header = new MessageFormat[6];
            header[0] = new MessageFormat("");
            header[1] = new MessageFormat("                      "+resourceMap.getString("print.first"));
            header[2] = new MessageFormat("                      "+resourceMap.getString("print.second"));
            header[3] = new MessageFormat("                      "+resourceMap.getString("print.third"));
            header[4] = new MessageFormat("");
            header[5] = new MessageFormat("                                                     CASH BOOK");
            MessageFormat[] footer = new MessageFormat[1];
            footer[0] = new MessageFormat("--{0}--");
            job.setPrintable(new MyTablePrintable(jTable1, PrintMode.FIT_WIDTH, header, footer));
            job.print();
        } catch (PrinterException ex) {
            Logger.getLogger(ReportCashBook.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
private void betweenCheckBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_betweenCheckBoxActionPerformed
                // TODO add your handling code here:
                dateFrom.setEnabled(betweenCheckBox.isSelected());
                dateTo.setEnabled(betweenCheckBox.isSelected());
                jCheckBox1ActionPerformed(evt);
            }//GEN-LAST:event_betweenCheckBoxActionPerformed

private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
    // TODO add your handling code here:
    betweenCheckBoxActionPerformed(evt);
}//GEN-LAST:event_jButton2ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.persistence.EntityManager BankingAppPUEntityManager;
    private javax.swing.JCheckBox betweenCheckBox;
    private javax.swing.JLabel closingBalanceLabel;
    private javax.swing.JSpinner dateFrom;
    private javax.swing.JSpinner dateTo;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JComboBox jComboBox2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private java.util.List<bankingapp.LedgerHeads> ledgerHeadsList;
    private javax.persistence.Query ledgerHeadsQuery;
    private javax.swing.JLabel openingBalanceLabel;
    public static javax.swing.JFileChooser saveFileChooser;
    private org.jdesktop.beansbinding.BindingGroup bindingGroup;
    // End of variables declaration//GEN-END:variables
    
}
