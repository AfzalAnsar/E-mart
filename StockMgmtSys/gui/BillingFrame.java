/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package StockMgmtSys.gui;

import StockMgmtSys.dao.OrderDao;
import StockMgmtSys.dao.ProductDao;
import StockMgmtSys.pojo.ProductsPojo;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author AFZAL ANSARI
 */
public class BillingFrame extends javax.swing.JFrame {

    /**
     * Creates new form BIllingFrame
     */
    ArrayList<ProductsPojo> productsList=new ArrayList<ProductsPojo>();
    DefaultTableModel dt;
    double grTotal=0.0;
    public BillingFrame() {
        initComponents();
        this.setLocationRelativeTo(this);
        dt=(DefaultTableModel)jTable.getModel();
        TxtProductId.requestFocus();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        TxtProductId = new javax.swing.JTextField();
        jBtnBack = new javax.swing.JButton();
        jBtnLogout = new javax.swing.JButton();
        JBtnGenerateBill = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(204, 0, 0));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Billing Options", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.ABOVE_TOP, new java.awt.Font("Tahoma", 1, 24), new java.awt.Color(255, 255, 255))); // NOI18N

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Product Id");

        TxtProductId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TxtProductIdActionPerformed(evt);
            }
        });

        jBtnBack.setBackground(new java.awt.Color(204, 255, 0));
        jBtnBack.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jBtnBack.setForeground(new java.awt.Color(255, 255, 255));
        jBtnBack.setText("Back");
        jBtnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnBackActionPerformed(evt);
            }
        });

        jBtnLogout.setBackground(new java.awt.Color(153, 0, 0));
        jBtnLogout.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jBtnLogout.setForeground(new java.awt.Color(255, 255, 255));
        jBtnLogout.setText("Logout");
        jBtnLogout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnLogoutActionPerformed(evt);
            }
        });

        JBtnGenerateBill.setBackground(new java.awt.Color(204, 0, 204));
        JBtnGenerateBill.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        JBtnGenerateBill.setForeground(new java.awt.Color(255, 255, 255));
        JBtnGenerateBill.setText("Generate Bill");
        JBtnGenerateBill.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBtnGenerateBillActionPerformed(evt);
            }
        });

        jTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Product Id", "Product Name", "Product Price", "Our Price", "Product Company", "Quantity", "Tax", "Total"
            }
        ));
        jScrollPane1.setViewportView(jTable);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(TxtProductId, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(169, 169, 169)
                        .addComponent(jBtnBack)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 88, Short.MAX_VALUE)
                        .addComponent(jBtnLogout)
                        .addGap(74, 74, 74))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 871, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(351, 351, 351)
                .addComponent(JBtnGenerateBill)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TxtProductId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBtnBack)
                    .addComponent(jBtnLogout))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 348, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(JBtnGenerateBill)
                .addGap(47, 47, 47))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 517, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void TxtProductIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TxtProductIdActionPerformed
       if(TxtProductId.getText().trim().isEmpty())
       {
           JOptionPane.showMessageDialog(null, "please enter product id!!", "Error!",JOptionPane.ERROR_MESSAGE);
            return;
       }
       loadItemList(TxtProductId.getText().trim());
       
    }//GEN-LAST:event_TxtProductIdActionPerformed

    private void JBtnGenerateBillActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBtnGenerateBillActionPerformed
        try
        {
            String OrdId=OrderDao.getNextOrderId();
            if(OrderDao.addOrder(productsList, OrdId) && ProductDao.updatestacks(productsList))
            {
                JOptionPane.showMessageDialog(null, "Order of rs "+grTotal+" created successfuly", "Success!",JOptionPane.INFORMATION_MESSAGE);
                ViewOrdersFrameRe vf=new ViewOrdersFrameRe();
                vf.setVisible(true);
                this.dispose();
            }
            else
            {
                JOptionPane.showMessageDialog(null, "Order can not be generated!!", "Fail!",JOptionPane.ERROR_MESSAGE);
                return;
            }
        }
         catch(SQLException e)
        {
            JOptionPane.showMessageDialog(null, "Error in database!", "Error!",JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
            return;
        }
    }//GEN-LAST:event_JBtnGenerateBillActionPerformed

    private void jBtnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnBackActionPerformed
        ReceptionistOptionsFrame rf =new ReceptionistOptionsFrame();
        rf.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jBtnBackActionPerformed

    private void jBtnLogoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnLogoutActionPerformed
       LoginFrame lf=new LoginFrame();
       lf.setVisible(true);
       this.dispose();
    }//GEN-LAST:event_jBtnLogoutActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(BillingFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(BillingFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(BillingFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(BillingFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new BillingFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton JBtnGenerateBill;
    private javax.swing.JTextField TxtProductId;
    private javax.swing.JButton jBtnBack;
    private javax.swing.JButton jBtnLogout;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable;
    // End of variables declaration//GEN-END:variables

    private void loadItemList(String pid) {
        try
        {
            ProductsPojo p=ProductDao.getProductsDetailsById(pid);
            if(p==null)
            {
                JOptionPane.showMessageDialog(null, "please enter valid product id!", "Error!",JOptionPane.ERROR_MESSAGE);
                return;
            }
            int index=getProductId(pid);
            int quan=1;
            if(index==-1)
            {
                 Object [] rows = new Object[8];
                 p.setQuntity(quan);
                 double amt=quan*p.getOurPrice();
                 p.setTotal(amt+(amt*p.getTax()/100));
                 rows[0]=p.getProductId();
                 rows[1]=p.getProductName();
                 rows[2]=p.getProductPrice();
                 rows[3]=p.getOurPrice();
                 rows[4]=p.getProductCompany();
                 rows[5]=p.getQuntity();
                 rows[6]=p.getTax()+"%";
                 rows[7]=p.getTotal();
                 productsList.add(p);
                 dt.addRow(rows);
                 grTotal+=p.getTotal();
            }
            else
            {
                ProductsPojo prd=productsList.get(index);
                int oldq=(int)dt.getValueAt(index, 5);
                double oldT=(double)dt.getValueAt(index, 7);
                double amt=prd.getOurPrice();
                double tax=prd.getTax();
                amt=amt+(amt*tax/100);
                prd.setTotal(amt+oldT);
                prd.setQuntity(oldq+quan);
                dt.setValueAt(prd.getQuntity(), index, 5);
                dt.setValueAt(prd.getTotal(), index, 7);
                grTotal+=prd.getTotal();
                productsList.set(index, prd);
            }
        }
        catch(SQLException e)
        {
            JOptionPane.showMessageDialog(null, "Error in database!", "Error!",JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
            return;
        }
    }
       private int getProductId(String pid)
       {
           int ind=-1;
           for(int i=0;i<productsList.size();i++)
           {
                ProductsPojo p=productsList.get(i);
                if(p.getProductId().equals(pid))
                {
                    ind=i;
                    break;   
                }
           }
           return ind;
       }
   }