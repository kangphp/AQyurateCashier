package views;

import utils.ConstUtil;
import models.Item;
import controllers.ItemController;
import controllers.CategoryController;
import javax.swing.table.*;
import javax.swing.*;
import java.awt.*;
import java.text.*;
import java.awt.event.*;
import java.util.*;
import models.Category;

public class frmInventory extends javax.swing.JFrame {

    public frmInventory() {
        initComponents();
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        titleBar.init(this);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        titleBar = new customUI.SimpleTitleBar();
        pnlMain = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        btnAdd = new customUI.Buttont();
        btnBack = new customUI.Buttont();
        btnEdit = new customUI.Buttont();
        btnRefresh = new customUI.Buttont();
        buttont1 = new customUI.Buttont();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbItems = new customUI.TableDark();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(25, 26, 35));
        setUndecorated(true);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        titleBar.setBackground(new java.awt.Color(25, 26, 35));

        pnlMain.setBackground(new java.awt.Color(25, 26, 35));

        jLabel1.setFont(new java.awt.Font("Plus Jakarta Sans ExtraBold", 0, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Inventory");

        btnAdd.setBackground(new java.awt.Color(25, 26, 35));
        btnAdd.setForeground(new java.awt.Color(255, 255, 255));
        btnAdd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/Add box.png"))); // NOI18N
        btnAdd.setText("Add Item");
        btnAdd.setFont(new java.awt.Font("Plus Jakarta Sans ExtraBold", 0, 12)); // NOI18N
        btnAdd.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnAdd.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        btnBack.setForeground(new java.awt.Color(255, 255, 255));
        btnBack.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/Arrow back ios.png"))); // NOI18N
        btnBack.setFont(new java.awt.Font("Plus Jakarta Sans ExtraBold", 0, 12)); // NOI18N
        btnBack.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnBack.setPreferredSize(new java.awt.Dimension(58, 68));
        btnBack.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        btnEdit.setForeground(new java.awt.Color(255, 255, 255));
        btnEdit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/Mode edit(1).png"))); // NOI18N
        btnEdit.setText("Edit Item");
        btnEdit.setFont(new java.awt.Font("Plus Jakarta Sans ExtraBold", 0, 12)); // NOI18N
        btnEdit.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnEdit.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditActionPerformed(evt);
            }
        });

        btnRefresh.setForeground(new java.awt.Color(255, 255, 255));
        btnRefresh.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/icons8-synchronize-48.png"))); // NOI18N
        btnRefresh.setText("Refresh List");
        btnRefresh.setFont(new java.awt.Font("Plus Jakarta Sans ExtraBold", 0, 12)); // NOI18N
        btnRefresh.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnRefresh.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnRefresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRefreshActionPerformed(evt);
            }
        });

        buttont1.setForeground(new java.awt.Color(255, 255, 255));
        buttont1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/icons8-remove-48.png"))); // NOI18N
        buttont1.setText("Delete Item");
        buttont1.setFont(new java.awt.Font("Plus Jakarta Sans ExtraBold", 0, 12)); // NOI18N
        buttont1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        buttont1.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);

        tbItems.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID Item", "Kategori", "Nama Barang", "Harga"
            }
        ));
        jScrollPane2.setViewportView(tbItems);

        javax.swing.GroupLayout pnlMainLayout = new javax.swing.GroupLayout(pnlMain);
        pnlMain.setLayout(pnlMainLayout);
        pnlMainLayout.setHorizontalGroup(
            pnlMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlMainLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(pnlMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlMainLayout.createSequentialGroup()
                        .addComponent(btnBack, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 363, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(pnlMainLayout.createSequentialGroup()
                        .addComponent(btnRefresh, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(buttont1, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(pnlMainLayout.createSequentialGroup()
                        .addComponent(jScrollPane2)
                        .addGap(18, 18, 18))))
        );
        pnlMainLayout.setVerticalGroup(
            pnlMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlMainLayout.createSequentialGroup()
                .addGroup(pnlMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnBack, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(18, 18, 18)
                .addGroup(pnlMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnRefresh, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttont1, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 754, Short.MAX_VALUE)
                .addGap(18, 18, 18))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(titleBar, javax.swing.GroupLayout.DEFAULT_SIZE, 958, Short.MAX_VALUE)
            .addComponent(pnlMain, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(titleBar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(pnlMain, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    ItemController ic = new ItemController();
    CategoryController cc = new CategoryController();

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
       DefaultTableModel li = (DefaultTableModel) tbItems.getModel();
       li.setRowCount(0);
       tbItems.setModel(li);
       
       ArrayList<Item> items = ic.getAllItems();
       
       if (items.size() > 0)
       {
           int no = 0;
           String cat = "";
           for (Item i : items)
           {
               no++;              
               ArrayList<Category> catName = cc.getCategory();
               
               for (Category x : catName)
               {
                   if (x.getCatID().equals(i.getCodeCat()))
                   {
                       cat = x.getCatName();
                   }
               }
               li.addRow(new Object[]{i.getItemID(), cat, i.getName(), i.getPrice()});
               tbItems.setModel(li);
           }
       } else {
           System.out.print(items);
       }
       
      
    }//GEN-LAST:event_formWindowOpened

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        new frmAddItem().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnAddActionPerformed

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        new frmMenu().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnBackActionPerformed

    private void btnEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditActionPerformed
        frmEditItem frameItem = new frmEditItem();
        int i = tbItems.getSelectedRow();
        TableModel tm = tbItems.getModel();
        
        try
        {
            String itemID = tm.getValueAt(i, 0).toString();
            String category = tm.getValueAt(i, 1).toString();
            String name = tm.getValueAt(i, 2).toString();
            String itemPrice = tm.getValueAt(i, 3).toString();
            frameItem.cmbCat.setSelectedItem(category);
            frameItem.txtID.setText(itemID);
            frameItem.txtName.setText(name);
            //frameItem.cmbCat.addItem(category);
            frameItem.txtPrice.setText(itemPrice);
            frameItem.setVisible(true);
            this.dispose();
            tm.getValueAt(i, 0).toString();
        } catch (ArrayIndexOutOfBoundsException e)
        {
            MessageError me = new MessageError(this, true);
            me.jLabel2.setText("Gagal");
            me.jLabel3.setText("Pilih Salah Satu Data Terlebih Dahulu!");
            me.showAlert();
        }
    }//GEN-LAST:event_btnEditActionPerformed

    private void btnRefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRefreshActionPerformed
       DefaultTableModel li = (DefaultTableModel) tbItems.getModel();
       li.setRowCount(0);
       tbItems.setModel(li);
       
       ArrayList<Item> items = ic.getAllItems();
        
       if (items.size() > 0)
       {
           int no = 0;
           String cat = "";
           for (Item i : items)
           {
               no++;              
               ArrayList<Category> catName = cc.getCategory();
               
               for (Category x : catName)
               {
                   if (x.getCatID().equals(i.getCodeCat()))
                   {
                       cat = x.getCatName();
                   }
               }
               li.addRow(new Object[]{i.getItemID(), cat, i.getName(), i.getPrice()});
               tbItems.setModel(li);
           }
       } else {
           System.out.print(items);
       }
    }//GEN-LAST:event_btnRefreshActionPerformed

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmInventory().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private customUI.Buttont btnAdd;
    private customUI.Buttont btnBack;
    private customUI.Buttont btnEdit;
    private customUI.Buttont btnRefresh;
    private customUI.Buttont buttont1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JPanel pnlMain;
    private customUI.TableDark tbItems;
    private customUI.SimpleTitleBar titleBar;
    // End of variables declaration//GEN-END:variables

    private boolean getClass(String catID) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
