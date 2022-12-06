package views;

import customUI.*;

import java.awt.*;
import java.awt.event.*;
import java.text.*;
import java.util.*;
import javax.swing.*;

import models.Category;
import models.Item;
  
import controllers.ItemController;
import controllers.CategoryController;
import javax.swing.table.*;

public class frmAddTransaction extends javax.swing.JFrame {
    public Integer totalTrans = 0;
    ItemController ic = new ItemController();
    CategoryController cc = new CategoryController();
    
    public void addTrans(String id)
    {
        String qty = JOptionPane.showInputDialog("Quantity");
        
        if(qty.equals("") || Integer.valueOf(qty) == 0 || qty.equals(null))
        {
            MessageError me = new MessageError(this, true);
            me.jLabel2.setText("Gagal");
            me.jLabel3.setText("Harap isi kuantitasnya dengan benar!");
            me.showAlert();
        } else {
            if (fieldInputID.getText() != null)
            {
                String itemID = fieldInputID.getText();        
                Item itemInfo = ic.getById(itemID);        
                
                if (itemInfo != null)
                {
                    DefaultTableModel listTrans = (DefaultTableModel) tbList.getModel();
                    
                    Integer itemPriceTotal = itemInfo.getPrice() * Integer.valueOf(qty);
                    totalTrans = totalTrans + itemPriceTotal;
                    Object data[] = {itemID, qty, itemInfo.getPrice(), itemPriceTotal};
                    listTrans.addRow(data);
                    fieldInputID.setText("");
                    getTotalTrans();
                }
            } else {
                int i = tbItems.getSelectedRow();
                TableModel tm = tbItems.getModel();
        
                DefaultTableModel listTrans = (DefaultTableModel) tbList.getModel();
        
                String itemID = tm.getValueAt(i, 0).toString();        
                Item itemInfo = ic.getById(itemID);        
            
                if (itemInfo != null)
                {
                    Integer itemPriceTotal = itemInfo.getPrice() * Integer.valueOf(qty);
                    totalTrans = totalTrans + itemPriceTotal;
                    Object data[] = {itemID, qty, itemInfo.getPrice(), itemPriceTotal};
                    listTrans.addRow(data);
                    fieldInputID.setText("");
                    getTotalTrans();
                }
            }
        }
    }
    
    public void showListItems()
    {
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
               no += 30;              
               ArrayList<Category> catName = cc.getCategory();
               
               for (Category x : catName)
               {
                   if (x.getCatID().equals(i.getCodeCat()))
                   {
                       cat = x.getCatName();
                   }
               }
               
               li.addRow(new Object[]{i.getItemID(), i.getName()});
               tbItems.setModel(li);
            }
        }
    }
    
    public void getTotalTrans()
    {
        DecimalFormat kursIndonesia = (DecimalFormat) DecimalFormat.getCurrencyInstance();
        DecimalFormatSymbols formatRp = new DecimalFormatSymbols();

        formatRp.setCurrencySymbol("Rp. ");
        formatRp.setMonetaryDecimalSeparator(',');
        formatRp.setGroupingSeparator('.');

        kursIndonesia.setDecimalFormatSymbols(formatRp);
        lblTotal.setText(String.valueOf(kursIndonesia.format(totalTrans)));
    }
    
    public frmAddTransaction() {
        
        initComponents();
        titleBar.init(this);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        
        fieldInputID.addKeyListener(new KeyListener() {

            @Override
            public void keyTyped(KeyEvent e) {                        
            }

            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    addTrans(fieldInputID.getText());
                    fieldInputID.requestFocusInWindow();
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {                                
            }
        });
        
        tbItems.addKeyListener(new KeyListener() {

            @Override
            public void keyTyped(KeyEvent e) {                        
            }

            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    //tampilkanInfoMember(fieldInputID.getText());
                    //fieldInputID.requestFocusInWindow();
                    //System.out.print("pressed");
                    int i = tbItems.getSelectedRow();
                    TableModel tm = tbItems.getModel();
        
                    String itemID = tm.getValueAt(i, 0).toString();
                    addTrans(itemID);
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {                                
            }
        });
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        titleBar = new customUI.SimpleTitleBar();
        pnlSearch = new customUI.PanelRound();
        jLabel1 = new javax.swing.JLabel();
        fieldInputID = new customUI.TextField();
        pnlItems = new customUI.PanelRound();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbItems = new customUI.TableDark();
        pnlTrans = new customUI.PanelRound();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbList = new customUI.TableDark();
        lblTtotal = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        lblTotal = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        titleBar.setBackground(new java.awt.Color(25, 26, 35));

        pnlSearch.setBackground(new java.awt.Color(25, 26, 35));

        jLabel1.setBackground(new java.awt.Color(25, 26, 35));
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/icons8-search-24.png"))); // NOI18N

        fieldInputID.setBackground(new java.awt.Color(25, 26, 35));
        fieldInputID.setForeground(new java.awt.Color(255, 255, 255));
        fieldInputID.setFont(new java.awt.Font("Plus Jakarta Sans ExtraBold", 1, 18)); // NOI18N
        fieldInputID.setLabelText("");

        javax.swing.GroupLayout pnlSearchLayout = new javax.swing.GroupLayout(pnlSearch);
        pnlSearch.setLayout(pnlSearchLayout);
        pnlSearchLayout.setHorizontalGroup(
            pnlSearchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlSearchLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(fieldInputID, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );
        pnlSearchLayout.setVerticalGroup(
            pnlSearchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlSearchLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(fieldInputID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlSearchLayout.createSequentialGroup()
                .addContainerGap(25, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(25, 25, 25))
        );

        pnlItems.setBackground(new java.awt.Color(25, 26, 35));

        tbItems.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "ID", "Product"
            }
        ));
        jScrollPane2.setViewportView(tbItems);

        javax.swing.GroupLayout pnlItemsLayout = new javax.swing.GroupLayout(pnlItems);
        pnlItems.setLayout(pnlItemsLayout);
        pnlItemsLayout.setHorizontalGroup(
            pnlItemsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlItemsLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 427, Short.MAX_VALUE))
        );
        pnlItemsLayout.setVerticalGroup(
            pnlItemsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlItemsLayout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 556, Short.MAX_VALUE)
                .addContainerGap())
        );

        pnlTrans.setBackground(new java.awt.Color(34, 36, 48));

        jScrollPane1.setBackground(new java.awt.Color(25, 26, 35));
        jScrollPane1.setForeground(new java.awt.Color(255, 255, 255));

        tbList.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Product", "Quantity", "Price", "Amount"
            }
        ));
        jScrollPane1.setViewportView(tbList);

        lblTtotal.setFont(new java.awt.Font("Plus Jakarta Sans ExtraBold", 1, 36)); // NOI18N
        lblTtotal.setForeground(new java.awt.Color(255, 255, 255));
        lblTtotal.setText("Total");

        jSeparator1.setForeground(new java.awt.Color(255, 255, 255));
        jSeparator1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        lblTotal.setFont(new java.awt.Font("Plus Jakarta Sans ExtraBold", 0, 24)); // NOI18N
        lblTotal.setForeground(new java.awt.Color(255, 255, 255));
        lblTotal.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);

        javax.swing.GroupLayout pnlTransLayout = new javax.swing.GroupLayout(pnlTrans);
        pnlTrans.setLayout(pnlTransLayout);
        pnlTransLayout.setHorizontalGroup(
            pnlTransLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlTransLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlTransLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlTransLayout.createSequentialGroup()
                        .addComponent(lblTtotal)
                        .addGap(18, 18, 18)
                        .addComponent(lblTotal, javax.swing.GroupLayout.DEFAULT_SIZE, 418, Short.MAX_VALUE))
                    .addComponent(jSeparator1))
                .addContainerGap())
            .addGroup(pnlTransLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(pnlTransLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 451, Short.MAX_VALUE)
                    .addGap(7, 7, 7)))
        );
        pnlTransLayout.setVerticalGroup(
            pnlTransLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlTransLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(pnlTransLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(lblTtotal, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(pnlTransLayout.createSequentialGroup()
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(46, 46, 46))
                    .addComponent(lblTotal, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(14, 14, 14))
            .addGroup(pnlTransLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(pnlTransLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 480, Short.MAX_VALUE)
                    .addGap(76, 76, 76)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(titleBar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(pnlSearch, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addComponent(pnlItems, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0)
                .addComponent(pnlTrans, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(titleBar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(pnlSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnlTrans, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnlItems, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        showListItems();
        getTotalTrans();
    }//GEN-LAST:event_formWindowOpened

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmAddTransaction().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private customUI.TextField fieldInputID;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lblTotal;
    private javax.swing.JLabel lblTtotal;
    private customUI.PanelRound pnlItems;
    private customUI.PanelRound pnlSearch;
    private customUI.PanelRound pnlTrans;
    private customUI.TableDark tbItems;
    private customUI.TableDark tbList;
    private customUI.SimpleTitleBar titleBar;
    // End of variables declaration//GEN-END:variables
}
