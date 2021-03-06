/*
 * LedgerHeadCreate.java
 *
 * Created on July 14, 2010, 10:05 PM
 */
package bankingapp;

import bankingapp.HeadTypesHasLedgerHeads;
import bankingapp.LedgerHeads;
import bankingapp.HeadTypes;
import bankingapp.HeadTypesHasLedgerHeadsPK;
import java.awt.GridLayout;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;
import javax.persistence.Query;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JCheckBox;
import javax.swing.JOptionPane;
import org.jdesktop.application.Action;

/**
 *
 * @author  s
 */
public class LedgerHeadCreate extends javax.swing.JInternalFrame {

    DefaultComboBoxModel dcm;
    ArrayList checkboxes;
    ArrayList checkboxes1;
    /** Creates new form LedgerHeadCreate */
    public LedgerHeadCreate() {
        initComponents();
        Query q = entityManager1.createQuery("SELECT l FROM LedgerHeads l ORDER BY l.ledgerHead");
        
        List<LedgerHeads> l = q.getResultList();
        dcm = new DefaultComboBoxModel(l.toArray());
        jList1.setModel(dcm);
        jMenuItem1.setText("Edit Label");
        GridLayout boxLayout = new GridLayout(2,3);
        jPanel1.setLayout(new GridLayout(2,3));
        dialogPanel.setLayout(boxLayout);
        Query qry = entityManager1.createQuery("SELECT l FROM HeadTypes l");
        List<HeadTypes> ht = qry.getResultList();
        checkboxes = new ArrayList();
        
        for (Iterator<HeadTypes> it = ht.iterator(); it.hasNext();) {
            HeadTypes headTypes = it.next();
            JCheckBox jcb = new JCheckBox(headTypes.toString());
            checkboxes.add(jcb);
            jPanel1.add(jcb);
        }
        jDialog1.setVisible(false);
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        entityManager1 = javax.persistence.Persistence.createEntityManagerFactory("BankingAppPU").createEntityManager();
        jPopupMenu1 = new javax.swing.JPopupMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        buttonGroup1 = new javax.swing.ButtonGroup();
        jDialog1 = new javax.swing.JDialog();
        dialogMessageLabel = new javax.swing.JLabel();
        dialogPanel = new javax.swing.JPanel();
        jButton2 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        ledgerHeadText = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList();
        jLabel2 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();

        jPopupMenu1.setName("jPopupMenu1"); // NOI18N

        org.jdesktop.application.ResourceMap resourceMap = org.jdesktop.application.Application.getInstance(bankingapp.BankingApp.class).getContext().getResourceMap(LedgerHeadCreate.class);
        jMenuItem1.setText(resourceMap.getString("jMenuItem1.text")); // NOI18N
        jMenuItem1.setName("jMenuItem1"); // NOI18N
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jPopupMenu1.add(jMenuItem1);

        jMenuItem2.setText(resourceMap.getString("jMenuItem2.text")); // NOI18N
        jMenuItem2.setName("jMenuItem2"); // NOI18N
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jPopupMenu1.add(jMenuItem2);

        jDialog1.setTitle(resourceMap.getString("jDialog1.title")); // NOI18N
        jDialog1.setAlwaysOnTop(true);
        jDialog1.setFocusable(false);
        jDialog1.setMinimumSize(new java.awt.Dimension(400, 300));
        jDialog1.setName("jDialog1"); // NOI18N
        jDialog1.setResizable(false);

        dialogMessageLabel.setFont(resourceMap.getFont("dialogMessageLabel.font")); // NOI18N
        dialogMessageLabel.setText(resourceMap.getString("dialogMessageLabel.text")); // NOI18N
        dialogMessageLabel.setName("dialogMessageLabel"); // NOI18N

        dialogPanel.setName("dialogPanel"); // NOI18N

        javax.swing.GroupLayout dialogPanelLayout = new javax.swing.GroupLayout(dialogPanel);
        dialogPanel.setLayout(dialogPanelLayout);
        dialogPanelLayout.setHorizontalGroup(
            dialogPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 358, Short.MAX_VALUE)
        );
        dialogPanelLayout.setVerticalGroup(
            dialogPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 147, Short.MAX_VALUE)
        );

        javax.swing.ActionMap actionMap = org.jdesktop.application.Application.getInstance(bankingapp.BankingApp.class).getContext().getActionMap(LedgerHeadCreate.class, this);
        jButton2.setAction(actionMap.get("editHeadTypes")); // NOI18N
        jButton2.setText(resourceMap.getString("jButton2.text")); // NOI18N
        jButton2.setName("jButton2"); // NOI18N

        javax.swing.GroupLayout jDialog1Layout = new javax.swing.GroupLayout(jDialog1.getContentPane());
        jDialog1.getContentPane().setLayout(jDialog1Layout);
        jDialog1Layout.setHorizontalGroup(
            jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDialog1Layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(dialogMessageLabel)
                    .addGroup(jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jButton2)
                        .addComponent(dialogPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jDialog1Layout.setVerticalGroup(
            jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDialog1Layout.createSequentialGroup()
                .addGap(47, 47, 47)
                .addComponent(dialogMessageLabel)
                .addGap(30, 30, 30)
                .addComponent(dialogPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton2)
                .addContainerGap(30, Short.MAX_VALUE))
        );

        jDialog1.getAccessibleContext().setAccessibleParent(this);

        setClosable(true);
        setTitle(resourceMap.getString("Form.title")); // NOI18N
        setName("Form"); // NOI18N

        jLabel1.setFont(resourceMap.getFont("jLabel1.font")); // NOI18N
        jLabel1.setText(resourceMap.getString("jLabel1.text")); // NOI18N
        jLabel1.setName("jLabel1"); // NOI18N

        ledgerHeadText.setFont(resourceMap.getFont("jLabel1.font")); // NOI18N
        ledgerHeadText.setText(resourceMap.getString("ledgerHeadText.text")); // NOI18N
        ledgerHeadText.setName("ledgerHeadText"); // NOI18N

        jButton1.setAction(actionMap.get("addLedgerHead")); // NOI18N
        jButton1.setFont(resourceMap.getFont("jLabel1.font")); // NOI18N
        jButton1.setText(resourceMap.getString("jButton1.text")); // NOI18N
        jButton1.setName("jButton1"); // NOI18N

        jScrollPane2.setName("jScrollPane2"); // NOI18N

        jList1.setFont(resourceMap.getFont("jLabel1.font")); // NOI18N
        jList1.setName("jList1"); // NOI18N
        jList1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jList1MouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jList1);

        jLabel2.setFont(resourceMap.getFont("jLabel2.font")); // NOI18N
        jLabel2.setText(resourceMap.getString("jLabel2.text")); // NOI18N
        jLabel2.setName("jLabel2"); // NOI18N

        jPanel1.setName("jPanel1"); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 286, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 495, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(ledgerHeadText, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(448, 448, 448))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jButton1)
                                .addGap(246, 246, 246)))
                        .addGap(109, 109, 109))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(ledgerHeadText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addComponent(jLabel2)
                        .addGap(22, 22, 22)
                        .addComponent(jButton1))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 263, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(60, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    private void jList1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jList1MouseClicked
        // TODO add your handling code here:
        if (evt.getButton() == MouseEvent.BUTTON3) {
            jPopupMenu1.show(jList1, evt.getX(), evt.getY());
        }
    }//GEN-LAST:event_jList1MouseClicked

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        // TODO add your handling code here:
        LedgerHeads lh = (LedgerHeads) jList1.getSelectedValue();
        String newName = JOptionPane.showInputDialog("Provide a new label ", lh);
        entityManager1.getTransaction().begin();
        lh.setLedgerHead(newName);
        entityManager1.getTransaction().commit();
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        // TODO add your handling code here:
        LedgerHeads lh = (LedgerHeads) jList1.getSelectedValue();
        dialogMessageLabel.setText("Select Head Categories for "+lh);
        Query qry = entityManager1.createQuery("SELECT l FROM HeadTypes l");
        List<HeadTypes> ht = qry.getResultList();   
        String selectionSql = "select head_types.id from head_types join head_types_has_ledger_heads on head_types.id = head_types_has_ledger_heads.head_types_id where ledger_heads_id="+lh.getId();
        System.out.println(selectionSql);
        Query qrySelection = entityManager1.createNativeQuery(selectionSql);
        
        List<Vector> htSelection =  qrySelection.getResultList();
        System.out.println(htSelection);
        checkboxes1 = new ArrayList();   
        dialogPanel.removeAll();
        for (Iterator<HeadTypes> it = ht.iterator(); it.hasNext();) {
            HeadTypes headTypes = it.next();
            JCheckBox jcb = new JCheckBox(headTypes.toString());
            for (Iterator<Vector> ita = htSelection.iterator(); ita.hasNext();) {
                Vector v = ita.next();
  //              System.out.println(v.get(0)+"---"+headTypes.getId());
                if(((Long)v.get(0)).longValue()==headTypes.getId()){
                    jcb.setSelected(true);
                    System.out.println("selecting ..");
                }
            }

            checkboxes1.add(jcb);
            dialogPanel.add(jcb);
        }
        
        jDialog1.setVisible(true);
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    @Action
    public void addLedgerHead() {
        entityManager1.getTransaction().begin();
        LedgerHeads lh = new LedgerHeads();
        lh.setLedgerHead(ledgerHeadText.getText().trim());
        entityManager1.persist(lh);
        entityManager1.getTransaction().commit();
        Query qy = entityManager1.createQuery("SELECT l FROM LedgerHeads l ORDER BY l.id DESC");
        qy.setMaxResults(1);
        
        List<LedgerHeads> lh1 = qy.getResultList();
        LedgerHeads leHd = lh1.get(0);
        System.out.println("Latest:"+leHd);
        entityManager1.getTransaction().begin();
        for (Iterator it = checkboxes.iterator(); it.hasNext();) {
            Object object = it.next();
            JCheckBox jcb = (JCheckBox) object;
            if(!jcb.isSelected())
                continue;
            Query headTypeQuery = entityManager1.createNamedQuery("HeadTypes.findByType");
            headTypeQuery.setParameter("type",jcb.getText());
            HeadTypes ht = (HeadTypes) headTypeQuery.getSingleResult();
            HeadTypesHasLedgerHeads hthlh = new HeadTypesHasLedgerHeads();
            HeadTypesHasLedgerHeadsPK hthlhpk = new HeadTypesHasLedgerHeadsPK();
            hthlhpk.setHeadTypesId(ht.getId());
            hthlhpk.setLedgerHeadsId(leHd.getId());
            hthlh.setHeadTypesHasLedgerHeadsPK(hthlhpk);
            entityManager1.persist(hthlh);
            System.out.println(jcb.getText()+"--"+jcb.isSelected()+"--"+leHd.getId());
            
        }
        entityManager1.getTransaction().commit();
        Query q = entityManager1.createQuery("SELECT l FROM LedgerHeads l");
        List<LedgerHeads> l = q.getResultList();
        dcm = new DefaultComboBoxModel(l.toArray());
        jList1.setModel(dcm);
    }

    @Action
    public void editHeadTypes() {
        LedgerHeads lh = (LedgerHeads) jList1.getSelectedValue();
        String deleteQuery=" delete from head_types_has_ledger_heads where head_types_has_ledger_heads.ledger_heads_id="+lh.getId();
        
        entityManager1.getTransaction().begin();
        Query q = entityManager1.createNativeQuery(deleteQuery);
        q.executeUpdate();
        
        for (Iterator it = checkboxes1.iterator(); it.hasNext();) {
            Object object = it.next();
            JCheckBox jcb = (JCheckBox) object;
            if(!jcb.isSelected())
                continue;
            Query headTypeQuery = entityManager1.createNamedQuery("HeadTypes.findByType");
            headTypeQuery.setParameter("type",jcb.getText());
            HeadTypes ht = (HeadTypes) headTypeQuery.getSingleResult();
            HeadTypesHasLedgerHeads hthlh = new HeadTypesHasLedgerHeads();
            HeadTypesHasLedgerHeadsPK hthlhpk = new HeadTypesHasLedgerHeadsPK();
            hthlhpk.setHeadTypesId(ht.getId());
            hthlhpk.setLedgerHeadsId(lh.getId());
            hthlh.setHeadTypesHasLedgerHeadsPK(hthlhpk);
            entityManager1.persist(hthlh);
            System.out.println(jcb.getText()+"--"+jcb.isSelected()+"--"+lh.getId());
            
        }
        
        entityManager1.getTransaction().commit();
        jDialog1.setVisible(false);
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel dialogMessageLabel;
    private javax.swing.JPanel dialogPanel;
    private javax.persistence.EntityManager entityManager1;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JDialog jDialog1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JList jList1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField ledgerHeadText;
    // End of variables declaration//GEN-END:variables
}
