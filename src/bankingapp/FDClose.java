/*
 * FDClose.java
 *
 * Created on June 8, 2010, 7:53 PM
 */
package bankingapp;

import bankingapp.Accounts;
import bankingapp.Members;
import bankingapp.Transactions;
import java.util.Calendar;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import org.jdesktop.application.Action;

/**
 *
 * @author  s
 */
public class FDClose extends javax.swing.JInternalFrame {

    private EntityManager BankingPUEntityManager;
    private int fdSchemeId;

    /** Creates new form FDClose */
    public FDClose() {
        initComponents();
        BankingPUEntityManager = javax.persistence.Persistence.createEntityManagerFactory("BankingAppPU").createEntityManager();
        Query schemeId = BankingPUEntityManager.createQuery("SELECT s.id from Schemes s where s.scheme = 'FD'");
        Integer id = (Integer) schemeId.getSingleResult();
        fdSchemeId = id;
        ActivityByMember am = ActivityByMember.getInstance();
        if (am != null) {
            Members m = am.getMember();
            if (m != null) {
                pkText.setText(m.getUsername());
                pkTextKeyReleased1(null);
            }
        }
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pkText = new javax.swing.JTextField();
        criteriaCombo = new javax.swing.JComboBox();
        detailsLabel = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        accountsCombo = new javax.swing.JComboBox();
        jLabel2 = new javax.swing.JLabel();
        amountText = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        interestText = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        totalText = new javax.swing.JTextField();
        durationText = new javax.swing.JTextField();
        interestPercentText = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();

        setClosable(true);
        org.jdesktop.application.ResourceMap resourceMap = org.jdesktop.application.Application.getInstance(bankingapp.BankingApp.class).getContext().getResourceMap(FDClose.class);
        setTitle(resourceMap.getString("Form.title")); // NOI18N
        setName("Form"); // NOI18N

        pkText.setFont(resourceMap.getFont("pkText.font")); // NOI18N
        pkText.setName("pkText"); // NOI18N
        pkText.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                pkTextKeyReleased(evt);
                pkTextKeyReleased1(evt);
            }
        });

        criteriaCombo.setFont(resourceMap.getFont("criteriaCombo.font")); // NOI18N
        criteriaCombo.setModel(new DefaultComboBoxModel(UserTypeComboItem.constructMenuItem()));
        criteriaCombo.setName("criteriaCombo"); // NOI18N

        detailsLabel.setName("detailsLabel"); // NOI18N

        jButton1.setFont(resourceMap.getFont("criteriaCombo.font")); // NOI18N
        jButton1.setText(resourceMap.getString("jButton1.text")); // NOI18N
        jButton1.setName("jButton1"); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel1.setFont(resourceMap.getFont("criteriaCombo.font")); // NOI18N
        jLabel1.setText(resourceMap.getString("jLabel1.text")); // NOI18N
        jLabel1.setName("jLabel1"); // NOI18N

        accountsCombo.setFont(resourceMap.getFont("pkText.font")); // NOI18N
        accountsCombo.setName("accountsCombo"); // NOI18N
        accountsCombo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                accountsComboActionPerformed(evt);
            }
        });

        jLabel2.setFont(resourceMap.getFont("criteriaCombo.font")); // NOI18N
        jLabel2.setText(resourceMap.getString("jLabel2.text")); // NOI18N
        jLabel2.setName("jLabel2"); // NOI18N

        amountText.setEditable(false);
        amountText.setFont(resourceMap.getFont("pkText.font")); // NOI18N
        amountText.setText(resourceMap.getString("amountText.text")); // NOI18N
        amountText.setName("amountText"); // NOI18N

        jLabel3.setFont(resourceMap.getFont("criteriaCombo.font")); // NOI18N
        jLabel3.setText(resourceMap.getString("jLabel3.text")); // NOI18N
        jLabel3.setName("jLabel3"); // NOI18N

        interestText.setFont(resourceMap.getFont("pkText.font")); // NOI18N
        interestText.setText(resourceMap.getString("interestText.text")); // NOI18N
        interestText.setName("interestText"); // NOI18N
        interestText.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                interestTextKeyReleased(evt);
            }
        });

        jLabel4.setFont(resourceMap.getFont("criteriaCombo.font")); // NOI18N
        jLabel4.setText(resourceMap.getString("jLabel4.text")); // NOI18N
        jLabel4.setName("jLabel4"); // NOI18N

        totalText.setEditable(false);
        totalText.setFont(resourceMap.getFont("pkText.font")); // NOI18N
        totalText.setText(resourceMap.getString("totalText.text")); // NOI18N
        totalText.setName("totalText"); // NOI18N

        durationText.setFont(resourceMap.getFont("pkText.font")); // NOI18N
        durationText.setText(resourceMap.getString("durationText.text")); // NOI18N
        durationText.setName("durationText"); // NOI18N

        interestPercentText.setFont(resourceMap.getFont("pkText.font")); // NOI18N
        interestPercentText.setText(resourceMap.getString("interestPercentText.text")); // NOI18N
        interestPercentText.setName("interestPercentText"); // NOI18N
        interestPercentText.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                interestPercentTextKeyReleased(evt);
            }
        });

        jLabel5.setFont(resourceMap.getFont("criteriaCombo.font")); // NOI18N
        jLabel5.setText(resourceMap.getString("jLabel5.text")); // NOI18N
        jLabel5.setName("jLabel5"); // NOI18N

        jLabel6.setFont(resourceMap.getFont("criteriaCombo.font")); // NOI18N
        jLabel6.setText(resourceMap.getString("jLabel6.text")); // NOI18N
        jLabel6.setName("jLabel6"); // NOI18N

        javax.swing.ActionMap actionMap = org.jdesktop.application.Application.getInstance(bankingapp.BankingApp.class).getContext().getActionMap(FDClose.class, this);
        jButton2.setAction(actionMap.get("withdrawFunds")); // NOI18N
        jButton2.setText(resourceMap.getString("jButton2.text")); // NOI18N
        jButton2.setName("jButton2"); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(144, 144, 144)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(criteriaCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel1)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)))
                    .addComponent(jLabel4))
                .addGap(40, 40, 40)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(accountsCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(amountText, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 118, Short.MAX_VALUE)
                                    .addComponent(pkText, javax.swing.GroupLayout.DEFAULT_SIZE, 118, Short.MAX_VALUE)
                                    .addComponent(interestText, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 118, Short.MAX_VALUE)
                                    .addComponent(totalText, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 118, Short.MAX_VALUE))
                                .addGap(27, 27, 27)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(detailsLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                    .addComponent(durationText, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(jLabel5)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(interestPercentText, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jLabel6)
                                    .addGap(2, 2, 2)))
                            .addComponent(jButton2))
                        .addGap(22, 22, 22))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(detailsLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pkText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(criteriaCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(accountsCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(amountText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(durationText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(interestPercentText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6))
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(interestText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2))
                .addGap(17, 17, 17)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(totalText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(28, 28, 28)
                .addComponent(jButton1)
                .addContainerGap(75, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    private void pkTextKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_pkTextKeyReleased
    // TODO add your handling code here:
    }//GEN-LAST:event_pkTextKeyReleased

    List getUser() {
        Query q = BankingPUEntityManager.createQuery("SELECT m  FROM Members m where m." + ((UserTypeComboItem) criteriaCombo.getSelectedItem()).getColumn() + " = '" + pkText.getText().trim() + "'");
        List l = q.getResultList();
        return l;
    }

    private void pkTextKeyReleased1(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_pkTextKeyReleased1
        List l = getUser();
        Members m = null;
        if (l.size() != 0) {
            jButton1.setEnabled(true);
            m = (Members) l.get(0);
            detailsLabel.setText("<html>Username :" + m.getUsername() + " <br /> Membership No. :" + m.getNumber() + " </html>");
            List<Accounts> l1;
            String sql = "SELECT a FROM Accounts a WHERE a.memberId=" + m.getId() + " AND a.schemeId = " + fdSchemeId + " AND a.closed=0";
            Query q = BankingPUEntityManager.createQuery(sql);
            l1 = q.getResultList();
            accountsCombo.removeAllItems();
            accountsCombo.setModel(new DefaultComboBoxModel(l1.toArray()));
        } else {
            jButton1.setEnabled(false);
            accountsCombo.removeAllItems();
        }
        accountsComboActionPerformed(null);
    }//GEN-LAST:event_pkTextKeyReleased1

    private void accountsComboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_accountsComboActionPerformed
        // TODO add your handling code here:
        Accounts a = (Accounts) accountsCombo.getSelectedItem();
        if (a == null) {
            jButton1.setEnabled(false);
            return;
        } else {
            jButton1.setEnabled(true);
        }
        List l = getUser();
        Members m = null;
        m = (Members) l.get(0);
        String sql = "SELECT t FROM Transactions t WHERE t.userId = " + m.getId() + " AND t.accountId =" + a.getId() + " AND t.lledgerHeadId = " + Utils.getLedgerHead("FD").getId();
        //System.out.println(sql);
        /*Query q = BankingPUEntityManager.createQuery(sql);
        Transactions t = (Transactions) q.getSingleResult();
        amountText.setText("" + t.getDeposit());*/
        amountText.setText("" + Utils.getFDAccountBalance(a.getId()));
        String getDurationSql = "SELECT f.duration FROM FdDetails f where f.accountId = " + a.getId();
        Query queryDuration = BankingPUEntityManager.createQuery(getDurationSql);
        Integer duration = (Integer) queryDuration.getSingleResult();
        durationText.setText(duration.toString());
        
    }//GEN-LAST:event_accountsComboActionPerformed

    @SuppressWarnings("static-access")
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        Accounts a = (Accounts) accountsCombo.getSelectedItem();
        if (a == null) {
            jButton1.setEnabled(false);
            return;
        } else {
            jButton1.setEnabled(true);
        }
        List l = getUser();
        Members m = null;
        m = (Members) l.get(0);
        //String sql = "SELECT t FROM Transactions t WHERE t.userId = " + m.getId() + " AND t.accountId =" + a.getId() + " AND t.lledgerHeadId = " + Utils.getLedgerHead("FD").getId();
        //System.out.println(sql);
        if (Utils.getAccountExpiryDate(a.getId()).getTime() > Calendar.getInstance().getTime().getTime()) {
            JOptionPane.showMessageDialog(this, "Account has not expired yet. Expiry: " + Utils.getAccountExpiryDate(a.getId()), "Attention", JOptionPane.ERROR_MESSAGE);
            return;
        }
        //Query q = BankingPUEntityManager.createQuery(sql);
        //Transactions t = (Transactions) q.getSingleResult();
        Query q = BankingPUEntityManager.createNativeQuery("UPDATE accounts set closed=1 where id = " + a.getId());
        BankingPUEntityManager.getTransaction().begin();
        q.executeUpdate();
        Transactions insertPrincipleTransaction = new Transactions();
        insertPrincipleTransaction.setAccountId(a.getId());
        insertPrincipleTransaction.setLledgerHeadId(Utils.getLedgerHead("FD").getId());
        insertPrincipleTransaction.setUserId(m.getId());
        String amtText = amountText.getText().trim() == null ? "0" : amountText.getText().trim();
        insertPrincipleTransaction.setWithdrawal(Double.parseDouble(amtText));

        Transactions insertInterestTransaction = new Transactions();
        insertInterestTransaction.setAccountId(a.getId());
        insertInterestTransaction.setLledgerHeadId(Utils.getLedgerHead("FD Interest").getId());
        insertInterestTransaction.setUserId(m.getId());
        String intText = interestText.getText().trim() == null ? "0" : interestText.getText().trim();
        insertInterestTransaction.setWithdrawal(Double.parseDouble(intText));


        BankingPUEntityManager.persist(insertPrincipleTransaction);
        BankingPUEntityManager.persist(insertInterestTransaction);
        BankingPUEntityManager.getTransaction().commit();

        String remarks = "A/C: "+a.getAccountNumber();
        TransactionDetails td = new TransactionDetails();
        td.setTransactionId(Utils.getMaxId("transactions"));
        td.setRemarks(remarks);
        BankingPUEntityManager.getTransaction().begin();
        BankingPUEntityManager.persist(td);
        BankingPUEntityManager.getTransaction().commit();

        JOptionPane.showMessageDialog(this, "Account has been Closed", "Done", JOptionPane.INFORMATION_MESSAGE);
        int resp = JOptionPane.showConfirmDialog(this, "Do you want to add this to print ?");
        if (resp == JOptionPane.YES_OPTION) {
            String[] p = {"Fixed Deposit", amountText.getText().trim()};
            PrintDemon.getInstance().payments.add(p);
            String[] p1 = {"Fixed Deposit Interest", interestText.getText().trim()};
            PrintDemon.getInstance().payments.add(p1);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void interestPercentTextKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_interestPercentTextKeyReleased
        // TODO add your handling code here:
        double principal = Double.parseDouble(amountText.getText());
        int duration = Integer.parseInt(durationText.getText());
        double percent = Double.parseDouble(interestPercentText.getText());

        double interest = (principal * duration * percent) / (100 * 365);
        interestText.setText("" + interest);
        updateTotal();
    }//GEN-LAST:event_interestPercentTextKeyReleased

    private void interestTextKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_interestTextKeyReleased
        // TODO add your handling code here:
        updateTotal();
    }//GEN-LAST:event_interestTextKeyReleased

    private void updateTotal() {
        double principal = Double.parseDouble(amountText.getText().trim());
        double interest = Double.parseDouble(interestText.getText().trim());
        totalText.setText("" + (principal + interest));

    }

    @Action
    public void withdrawFunds() {
        Double principal = 77d;
        Double interest = 33d;
        //BankingPUEntityManager.getTransaction().begin();

    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox accountsCombo;
    private javax.swing.JTextField amountText;
    private javax.swing.JComboBox criteriaCombo;
    private javax.swing.JLabel detailsLabel;
    private javax.swing.JTextField durationText;
    private javax.swing.JTextField interestPercentText;
    private javax.swing.JTextField interestText;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JTextField pkText;
    private javax.swing.JTextField totalText;
    // End of variables declaration//GEN-END:variables
}