/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hospitalmanagmentsystem;

import java.awt.Graphics;
import java.awt.Image;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
/**
 *
 * @author singer
 */
public class billDrugInsert extends javax.swing.JFrame {

    Boolean result;
    Connection con1;
    PreparedStatement insert, delete, update;
    /**
     * Creates new form billDrugInsert
     */
    public billDrugInsert() {
        initComponents();
        setRecordsToTable();
    }
    
    
     private void setRecordsToTable() {
         try {
            // TODO add your handling code here:
            Class.forName("com.mysql.jdbc.Driver");
            try {
                con1 = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3308/channelingcenter", "root", "");
                Statement st = con1.createStatement();
                String sql = "select drug.drugName, stock.itemQty, stock.unitPrice , drug.drugID from drug,stock where drug.drugID = stock.drugID and drug.Available = 1  and stock.Available = 1";
                ResultSet rs = st.executeQuery(sql);

                while (rs.next()) {
                    //data will be added until finish
                    String drugId = rs.getString("drug.drugID");
                    String drugName = rs.getString("drug.drugName");
                    String itemQty = String.valueOf(rs.getInt("stock.itemQty"));
                    String unitPrice = String.valueOf(rs.getInt("stock.unitPrice"));

     
                    String tbData[] = {drugId, drugName, itemQty, unitPrice};
                    DefaultTableModel tblModel = (DefaultTableModel) drugtable.getModel();

                    //add string array
                    tblModel.addRow(tbData);
                }
            } catch (SQLException ex) {
                Logger.getLogger(billDrugInsert.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(billDrugInsert.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
     
     public void search(String str) {
        DefaultTableModel tblModel = (DefaultTableModel) drugtable.getModel();
        TableRowSorter<DefaultTableModel> trs = new TableRowSorter<>(tblModel);
        drugtable.setRowSorter(trs);
        trs.setRowFilter(RowFilter.regexFilter(str));

        }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel(){
            public void paintComponent(Graphics g){

                ImageIcon im = new ImageIcon("C:\\Users\\Chathunika Heenkenda\\Desktop\\ITP Project\\Main Project\\interfaces\\HospitalManagmentSystem\\src\\images\\backg1.jpg");
                Image i =im.getImage();

                g.drawImage(i,0,0,this.getSize().width,this.getSize().height,this);

            }
        };
        backg = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        searchButton = new javax.swing.JButton();
        bno = new javax.swing.JLabel();
        drugname = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        qty = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        drugtable = new javax.swing.JTable();
        addButton = new javax.swing.JButton();
        viewBillButton = new javax.swing.JButton();
        cancelButton = new javax.swing.JButton();
        did = new javax.swing.JLabel();
        Dname = new javax.swing.JLabel();
        price = new javax.swing.JLabel();
        clearButton = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        Qty = new javax.swing.JLabel();
        Oid = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jPanel2.setBackground(new java.awt.Color(214, 234, 245));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Add Drug"));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setText("Bill Number");

        searchButton.setBackground(new java.awt.Color(153, 204, 255));
        searchButton.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        searchButton.setText("Search");
        searchButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchButtonActionPerformed(evt);
            }
        });

        bno.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N

        drugname.setBackground(new java.awt.Color(204, 204, 204));
        drugname.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        drugname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                drugnameActionPerformed(evt);
            }
        });
        drugname.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                drugnameKeyReleased(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel3.setText("Drug ID");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel4.setText("Drug Name");

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel5.setText("Quantity");

        qty.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel6.setText("Price");

        drugtable.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        drugtable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Drug ID", "Drug Name", "Quantity", "Price"
            }
        ));
        drugtable.setGridColor(new java.awt.Color(153, 153, 153));
        drugtable.setRowHeight(30);
        drugtable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                drugtableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(drugtable);

        addButton.setBackground(new java.awt.Color(53, 92, 125));
        addButton.setFont(new java.awt.Font("Tahoma", 0, 22)); // NOI18N
        addButton.setForeground(new java.awt.Color(255, 255, 255));
        addButton.setText("Add");
        addButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addButtonActionPerformed(evt);
            }
        });

        viewBillButton.setBackground(new java.awt.Color(53, 92, 125));
        viewBillButton.setFont(new java.awt.Font("Tahoma", 0, 22)); // NOI18N
        viewBillButton.setForeground(new java.awt.Color(255, 255, 255));
        viewBillButton.setText("View Bill");
        viewBillButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewBillButtonActionPerformed(evt);
            }
        });

        cancelButton.setBackground(new java.awt.Color(53, 92, 125));
        cancelButton.setFont(new java.awt.Font("Tahoma", 0, 22)); // NOI18N
        cancelButton.setForeground(new java.awt.Color(255, 255, 255));
        cancelButton.setText("Cancel");
        cancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelButtonActionPerformed(evt);
            }
        });

        did.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        did.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        Dname.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        Dname.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        price.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        price.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        clearButton.setBackground(new java.awt.Color(53, 92, 125));
        clearButton.setFont(new java.awt.Font("Tahoma", 0, 22)); // NOI18N
        clearButton.setForeground(new java.awt.Color(255, 255, 255));
        clearButton.setText("Clear");
        clearButton.setActionCommand("");
        clearButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearButtonActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel2.setText("Drug Name");

        Qty.setForeground(new java.awt.Color(153, 204, 255));

        Oid.setForeground(new java.awt.Color(153, 204, 255));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(51, 51, 51)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 125, Short.MAX_VALUE)
                                .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(addButton, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(54, 54, 54)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(viewBillButton, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(Dname, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(did, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(qty, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(price, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(15, 15, 15)
                                .addComponent(cancelButton, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(97, 97, 97)
                                .addComponent(clearButton, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(60, 60, 60)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 587, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(bno, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(120, 120, 120)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(drugname, javax.swing.GroupLayout.PREFERRED_SIZE, 246, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(searchButton, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(32, 32, 32)
                .addComponent(Qty, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                    .addContainerGap(1159, Short.MAX_VALUE)
                    .addComponent(Oid, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(310, 310, 310)))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGap(48, 48, 48)
                        .addComponent(Qty, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(92, 92, 92))
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addGap(23, 23, 23)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(bno, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(41, 41, 41))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                            .addGap(73, 73, 73)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(drugname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(searchButton)))))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(7, 7, 7)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 368, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(did, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(50, 50, 50)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(Dname, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(44, 44, 44)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(price, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(39, 39, 39)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(qty, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(83, 83, 83)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(addButton, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(viewBillButton, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cancelButton, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(clearButton, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(18, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel2Layout.createSequentialGroup()
                    .addGap(55, 55, 55)
                    .addComponent(Oid, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(548, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(250, 250, 250)
                        .addComponent(backg, javax.swing.GroupLayout.PREFERRED_SIZE, 471, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(43, 43, 43)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 1166, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(43, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(backg, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(43, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void searchButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchButtonActionPerformed
        // TODO add your handling code here:
        String DrugName = drugname.getText();
        //String mgs = miligram.getText();
       
        int c;

        if(DrugName.equals(""))
        {
            JOptionPane.showMessageDialog(this, "Please enter search details");
        }

        else{
                String PATTERN1 = "^[a-zA-Z]{0,30}$";
                Pattern patt1 = Pattern.compile(PATTERN1);
                Matcher match1;
                match1 = patt1.matcher(drugname.getText());
        
                if(!match1.matches()){
                    JOptionPane.showMessageDialog(this,"Please enter valid drug name!");
                }
                else{
       
                    try{
                        Class.forName("com.mysql.jdbc.Driver");
                        con1 = DriverManager.getConnection("jdbc:mysql://localhost:3308/channelingcenter","root","");

                        insert = con1.prepareStatement("select PharmacyBillId as id from pharmacybill group by PharmacyBillId order by PharmacyBillId desc limit 1");

                        ResultSet rs1 = insert.executeQuery();

                        while(rs1.next()){

                            bno.setText(rs1.getString("id"));
                        }

                        insert = con1.prepareStatement("select * from drug, stock where drug.drugID = stock.drugID AND drugName = ?");

                        insert.setString(1,DrugName);
                        //insert.setString(2,mgs);
                        ResultSet rs = insert.executeQuery();
                        ResultSetMetaData res = rs.getMetaData();
                        c = res.getColumnCount();
                        DefaultTableModel df = (DefaultTableModel) drugtable.getModel();
                        df.setRowCount(0);

                        while(rs.next())
                        {
                            int da = Integer.parseInt(rs.getString("drug.Available"));
                            int sa = Integer.parseInt(rs.getString("stock.Available"));
                            if(da == 0){
                                JOptionPane.showMessageDialog(this,"Drug is not in the system");
                            }
                            else if(da == 0 && sa == 0)
                            {
                                JOptionPane.showMessageDialog(this,"Drug is out of stock!");
                            }
                            else{
                                if(sa == 1){
                                    Oid.setText(rs.getString("stockID"));
                                    Qty.setText(rs.getString("itemQty"));
                                    Vector v2=new Vector();
                                    for(int a=1;a<=c;a++)
                                    {
                                        v2.add(rs.getString("drug.drugID"));
                                        v2.add(rs.getString("drug.drugName"));
                                        v2.add(rs.getString("stock.itemQty"));
                                        v2.add(rs.getString("stock.unitPrice"));
                                        //v2.add(rs.getString("Mgs"));
                                    }
                                    df.addRow(v2);
                                }
                                else{
                                    JOptionPane.showMessageDialog(this,"Drug is out of stock!");
                                }
                            }
                        }
                    }
                    catch (ClassNotFoundException ex) {
                        Logger.getLogger(addPharmacyBill.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    catch (SQLException ex) {
                        Logger.getLogger(addPharmacyBill.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
        }
          
        
               
    }//GEN-LAST:event_searchButtonActionPerformed

    private void drugtableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_drugtableMouseClicked
        // TODO add your handling code here:

        int selectedIndex = drugtable.getSelectedRow();

        did.setText(drugtable.getValueAt(selectedIndex, 0).toString());
        Dname.setText(drugtable.getValueAt(selectedIndex, 1).toString());
        price.setText(drugtable.getValueAt(selectedIndex, 3).toString());
    }//GEN-LAST:event_drugtableMouseClicked

    private void addButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addButtonActionPerformed
        // TODO add your handling code here:
        String DrugName = drugname.getText();
        //String mgs = miligram.getText();
        String Did = did.getText();
        String dname = Dname.getText();
        String quantity = qty.getText();
        String prices = price.getText();
        //String docname = Docname.getText();
        String oid = null;

        try{
            //Int Userid;

            Class.forName("com.mysql.jdbc.Driver");
            con1=DriverManager.getConnection("jdbc:mysql://localhost:3308/channelingcenter","root","");
            if(Did.equals("") || dname.equals("") || quantity.equals("") || prices.equals("")){
                JOptionPane.showMessageDialog(this,"Please enter drug details!");
            }
            else{
                String PATTERN = "^[a-zA-Z]{0,30}$";
                Pattern patt = Pattern.compile(PATTERN);
                Matcher match;
                match = patt.matcher(Dname.getText());
                if(!match.matches()){
                    JOptionPane.showMessageDialog(this,"Please enter letters!");
                }
                else{
                    String PATTERN1 = "^[0-9]{0,9}$";
                    Pattern patt1 = Pattern.compile(PATTERN1);
                    Matcher match1;
                    match1 = patt1.matcher(qty.getText());

                    if(!match1.matches()){
                        JOptionPane.showMessageDialog(this,"Please enter numbers!");
                    }

                    else{
                        DefaultTableModel df = (DefaultTableModel) drugtable.getModel();
                        int selectedIndex = drugtable.getSelectedRow();

                        int tqty = Integer.parseInt(df.getValueAt(selectedIndex, 2).toString());
                        int iqty = Integer.parseInt(qty.getText());

                        if(tqty < iqty){
                            JOptionPane.showMessageDialog(this,"Quantity limit is exceeded! \n Please enter a ouantity less than" + tqty);
                        }

                        else{
                            insert = con1.prepareStatement("select PharmacyBillId from pharmacybill group by PharmacyBillId order by PharmacyBillId desc limit 1");

                            ResultSet rs = insert.executeQuery();

                            while(rs.next()){

                                bno.setText(rs.getString("PharmacyBillId"));
                            }

                            insert = con1.prepareStatement("Select 1 from billdrug where PharmacyBillID = ? AND drugId = ?");
                            insert.setString(1, bno.getText());
                            insert.setString(2, did.getText());

                            ResultSet r = insert.executeQuery();

                            int a = 0;

                            while(r.next()){
                                a = r.getInt("1");
                            }
                            if(a == 1){
                                JOptionPane.showMessageDialog(this,"Drug is already added to the bill!");
                            }
                            else{
                                insert = con1.prepareStatement("insert into billdrug(drugId, itemQty ,PharmacyBillID) values(?,?,?)");

                                insert.setString(1, did.getText());
                                insert.setString(2, qty.getText());
                                insert.setString(3, bno.getText());
                                //insert.setString(4, Docname.getText());
                                //insert.setString(5, price.getText());

                                insert.executeUpdate();

                                //JOptionPane.showMessageDialog(this, "Drug Added");

                                double totqty = Double.parseDouble(Qty.getText()) - Double.parseDouble(qty.getText());

                                System.out.println(totqty);

                                String num1="";
                                num1+=totqty;

                                System.out.println(num1);
                                //System.out.println(Oid.getText());
                                //totprice.setText(num);

                                if(totqty == 0)
                                {
                                    delete = con1.prepareStatement("Update stock set itemQty = ?, Available = 0 where stockID = ? AND drugID = ?");

                                    delete.setString(1, num1);
                                    delete.setString(2, Oid.getText());
                                    delete.setString(3, did.getText());
                                    delete.executeUpdate();
                                }
                                else
                                {
                                    update = con1.prepareStatement("Update stock set itemQty = ? where stockID = ? AND drugID = ?");

                                    update.setString(1, num1);
                                    update.setString(2, Oid.getText());
                                    update.setString(3, did.getText());
                                    update.executeUpdate();
                                }
                            }
                        }
                    }
                }
            }
        }
        catch (ClassNotFoundException ex) {
            //JOptionPane.showMessageDialog(this, "Cant insert ");
            Logger.getLogger(addPharmacyBill.class.getName()).log(Level.SEVERE, null, ex);
        }
        catch (SQLException ex) {
            Logger.getLogger(addPharmacyBill.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_addButtonActionPerformed

    private void viewBillButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewBillButtonActionPerformed
        // TODO add your handling code here:
        pharmacyBill nd = new pharmacyBill();
        nd.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_viewBillButtonActionPerformed

    private void cancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelButtonActionPerformed
        // TODO add your handling code here:
        try{
            Class.forName("com.mysql.jdbc.Driver");
            con1=DriverManager.getConnection("jdbc:mysql://localhost:3308/channelingcenter","root","");
            String billno = bno.getText();

            delete = con1.prepareStatement("delete from billdrug where PharmacyBillId = ?");
            delete.setString(1, billno);

            delete.executeUpdate();

            delete = con1.prepareStatement("delete from pharmacybill where PharmacyBillId = ?");
            delete.setString(1, billno);

            delete.executeUpdate();

            JOptionPane.showMessageDialog(this, "Pharmacy Bill Canceled");
        }
        catch (ClassNotFoundException ex) {
            //Logger.getLogger(NDrugDetails.class.getName()).log(Level.SEVERE, null, ex);
        }
        catch (SQLException ex) {
            //Logger.getLogger(NDrugDetails.class.getName()).log(Level.SEVERE, null, ex);
        }
        pharmacyMainUI nd = new pharmacyMainUI();
        nd.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_cancelButtonActionPerformed

    private void clearButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearButtonActionPerformed
        // TODO add your handling code here:
        drugname.setText(null);
        //miligram.setText(null);
        did.setText(null);
        Dname.setText(null);
        qty.setText(null);
        price.setText(null);
        //Docname.setText(null);
    }//GEN-LAST:event_clearButtonActionPerformed

    private void drugnameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_drugnameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_drugnameActionPerformed

    private void drugnameKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_drugnameKeyReleased
        // TODO add your handling code here:
        String searchString = drugname.getText();
        search(searchString);
    }//GEN-LAST:event_drugnameKeyReleased

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
            java.util.logging.Logger.getLogger(billDrugInsert.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(billDrugInsert.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(billDrugInsert.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(billDrugInsert.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new billDrugInsert().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Dname;
    private javax.swing.JLabel Oid;
    private javax.swing.JLabel Qty;
    private javax.swing.JButton addButton;
    private javax.swing.JLabel backg;
    private javax.swing.JLabel bno;
    private javax.swing.JButton cancelButton;
    private javax.swing.JButton clearButton;
    private javax.swing.JLabel did;
    private javax.swing.JTextField drugname;
    private javax.swing.JTable drugtable;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel price;
    private javax.swing.JTextField qty;
    private javax.swing.JButton searchButton;
    private javax.swing.JButton viewBillButton;
    // End of variables declaration//GEN-END:variables
}
