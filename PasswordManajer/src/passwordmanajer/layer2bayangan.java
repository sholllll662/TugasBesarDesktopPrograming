/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package passwordmanajer;
import java.sql.*;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.awt.event.KeyEvent;
import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Level;
import java.util.logging.Logger;
import passwordmanajer.KoneksiMysql;
/**
 *
 * @author sholah799
 */
public class layer2bayangan extends javax.swing.JFrame {
private Connection C = new KoneksiMysql().fikskonek();
private DefaultTableModel tabmode;

    /**
     * Creates new form layer2bayangan
     */
    public layer2bayangan() {
        initComponents();
        ketik();
        kosong();
        table();
        tabelakun.setVisible(false);
    }
    
    private void enk(){
        String key = "java";
        String isitxt = (key.length())+key+txtpass.getText();
        String out = "";
        for(int i = 0; i < isitxt.length(); i++){
            int index = isitxt.charAt(i);
            char s = (char)(index+1);
            out = out + String.valueOf(s);
        }
        txtpass.setText(out);
    }    
    private void ketik(){
        txtnamaakun.requestFocus();
    }
    
    private void kosong(){
        txtnamaakun.setText("");
        txtlink.setText("");
        txtusername.setText("");
        txtpass.setText("");
        txtketerangan.setText("");
        txtdesk.setText("");
    }
    
    private void table(){
        //membuat kolom manual
        Object[] Baris = {"Nama Akun", "Link Platform", "Username", "Password", "Keterangan"};
        tabmode = new DefaultTableModel(null, Baris);
        try{
            String sql = "SELECT * FROM kelolaakun ORDER BY Username DESC";
            Statement start = C.createStatement();//untuk konek ke sql
            ResultSet hasil = start.executeQuery(sql);
            while(hasil.next()){
                //model.addRow(new Object[]{no++,res.getString(1),res.getString(2),res.getString(3),res.getString(4)});
                tabmode.addRow(new Object[]{
                hasil.getString(1),
                hasil.getString(2),
                hasil.getString(3),
                hasil.getString(4),
                hasil.getString(5),
            });
            }
            tabelakun.setModel(tabmode);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "data gagal dipanggil "+e);
        }
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
        jLabel2 = new javax.swing.JLabel();
        txtnamaakun = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtlink = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtusername = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtketerangan = new javax.swing.JTextArea();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabelakun = new javax.swing.JTable();
        bupluad = new javax.swing.JButton();
        bdelete = new javax.swing.JButton();
        bsave = new javax.swing.JButton();
        txtpass = new javax.swing.JPasswordField();
        btnshow = new javax.swing.JButton();
        btnhide = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        txtdesk = new javax.swing.JTextField();
        bclear = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(204, 204, 255));
        jPanel1.setLayout(new java.awt.BorderLayout());

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setText("Data Akun");
        jPanel1.add(jLabel1, java.awt.BorderLayout.CENTER);

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel2.setText("Nama Akun");

        txtnamaakun.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtnamaakunActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel3.setText("Link platform");

        txtlink.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtlinkActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel4.setText("Username");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel5.setText("Password");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel6.setText("Keterangan");

        txtketerangan.setColumns(20);
        txtketerangan.setRows(5);
        jScrollPane1.setViewportView(txtketerangan);

        tabelakun.setModel(new javax.swing.table.DefaultTableModel(
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
        tabelakun.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelakunMouseClicked(evt);
            }
        });
        tabelakun.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentHidden(java.awt.event.ComponentEvent evt) {
                tabelakunComponentHidden(evt);
            }
        });
        jScrollPane2.setViewportView(tabelakun);

        bupluad.setText("Update");
        bupluad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bupluadActionPerformed(evt);
            }
        });

        bdelete.setText("Delete");
        bdelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bdeleteActionPerformed(evt);
            }
        });

        bsave.setText("Save");
        bsave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bsaveActionPerformed(evt);
            }
        });

        btnshow.setText("Show Tabel");
        btnshow.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnshowMousePressed(evt);
            }
        });
        btnshow.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnshowActionPerformed(evt);
            }
        });

        btnhide.setText("Hide Tabel");
        btnhide.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnhideMousePressed(evt);
            }
        });
        btnhide.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnhideActionPerformed(evt);
            }
        });

        jButton1.setText("Deskripsi");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        bclear.setText("Clear");
        bclear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bclearActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 857, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnshow)
                        .addGap(41, 41, 41)
                        .addComponent(btnhide)
                        .addGap(72, 72, 72))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel6))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtnamaakun, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtlink, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtusername, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtpass, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(bupluad)
                                .addGap(34, 34, 34)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(bdelete)
                                        .addGap(37, 37, 37)
                                        .addComponent(bsave))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(bclear)
                                        .addGap(102, 102, 102)))
                                .addGap(25, 25, 25)))
                        .addGap(18, 18, 18)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jButton1)
                        .addGap(18, 18, 18)
                        .addComponent(txtdesk, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(2, 2, 2)
                                .addComponent(jLabel2)
                                .addGap(20, 20, 20)
                                .addComponent(jLabel3)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel4)
                                .addGap(20, 20, 20)
                                .addComponent(jLabel5)
                                .addGap(20, 20, 20)
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txtnamaakun, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(txtlink, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(txtusername, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(txtpass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(38, 38, 38)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(bsave)
                                    .addComponent(bdelete)
                                    .addComponent(bupluad))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGap(30, 30, 30)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnhide)
                            .addComponent(btnshow))
                        .addGap(31, 31, 31)
                        .addComponent(bclear)
                        .addGap(68, 68, 68))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtdesk, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton1))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        setSize(new java.awt.Dimension(851, 632));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txtlinkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtlinkActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtlinkActionPerformed

    private void bsaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bsaveActionPerformed
        enk();
        String sql = "insert into kelolaakun values (?,?,?,?,?)";
        try{
            PreparedStatement start = C.prepareStatement(sql);
            start.setString(1, txtnamaakun.getText());
            start.setString(2, txtlink.getText());
            start.setString(3, txtusername.getText());
            start.setString(4, txtpass.getText());
            start.setString(5, txtketerangan.getText());
            
            start.executeUpdate();
            JOptionPane.showMessageDialog(null, "data berhasil di simpan");//popup
            kosong();//manggil methode kosong
            txtnamaakun.requestFocus();//kursor ketik
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "data gagal di simpan"+e);
        }table();
    }//GEN-LAST:event_bsaveActionPerformed

    private void bupluadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bupluadActionPerformed
        // TODO add your handling code here:
        try{
            String sql = "UPDATE kelolaakun set Nama_Akun=?,Platform_Akun=?,Password=?,Keterangan=? where Username='"+txtusername.getText()+"'";
            PreparedStatement start = C.prepareStatement(sql);
            start.setString(1, txtnamaakun.getText());
            start.setString(2, txtlink.getText());
            start.setString(3, txtpass.getText());
            start.setString(4, txtketerangan.getText());
            
            start.executeUpdate();
            JOptionPane.showMessageDialog(null, "Data Berhasil update");
            kosong();
            txtnamaakun.requestFocus();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Data Gagal diubah "+ex);
    }table();
    }//GEN-LAST:event_bupluadActionPerformed

    private void bdeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bdeleteActionPerformed
        // TODO add your handling code here:
        int notip = JOptionPane.showConfirmDialog(null, "Hapus","Konfirmasi dialog",JOptionPane.YES_NO_OPTION);
        if(notip==0){
            String sql = "delete from kelolaakun where Username ='"+txtusername.getText()+"'";
            try{
                PreparedStatement start = C.prepareStatement(sql);
                start.executeUpdate();
                JOptionPane.showMessageDialog(null, "Data Berhasil dihapus");
                kosong();
                txtnamaakun.requestFocus();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Data Gagal dihapus "+ex);
            }
        }table();
    }//GEN-LAST:event_bdeleteActionPerformed

    private void tabelakunMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelakunMouseClicked
        // TODO add your handling code here:]
        int bar= tabelakun.getSelectedRow();
        String a = tabelakun.getValueAt(bar, 0).toString();
        String b = tabelakun.getValueAt(bar, 1).toString();
        String c = tabelakun.getValueAt(bar, 2).toString();
        String d = tabelakun.getValueAt(bar, 3).toString();
        String e = tabelakun.getValueAt(bar, 4).toString();
        
        txtnamaakun.setText(a);
        txtlink.setText(b);
        txtusername.setText(c);
        txtpass.setText(d);
        txtketerangan.setText(e);
        //txtdesk.setText(d);
    }//GEN-LAST:event_tabelakunMouseClicked

    private void txtnamaakunActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtnamaakunActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtnamaakunActionPerformed

    private void btnshowActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnshowActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_btnshowActionPerformed

    private void btnshowMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnshowMousePressed
        // TODO add your handling code here:
        tabelakun.setVisible(true);
    }//GEN-LAST:event_btnshowMousePressed

    private void tabelakunComponentHidden(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_tabelakunComponentHidden
        // TODO add your handling code here:
    }//GEN-LAST:event_tabelakunComponentHidden

    private void btnhideMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnhideMousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnhideMousePressed

    private void btnhideActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnhideActionPerformed
        // TODO add your handling code here:
        tabelakun.setVisible(false);
    }//GEN-LAST:event_btnhideActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        String isitext = txtpass.getText();  
        char k = (char)(isitext.charAt(0));  
        String key = "java",out = "";  
        int  jumKey = Integer.parseInt(String.valueOf(k))-1;  
        for (int i = 1 ; i <= jumKey; i++) {  
       int index = isitext.charAt(i);  
       char s = (char)(index-1) ;  
       key = key + String.valueOf(s);  
     }       
     if (key.equals(key)){ // hasil true  
        for (int i = (jumKey+1) ; i < isitext.length(); i++) {  
            int index = isitext.charAt(i);  
            char s = (char)(index-1) ;  
            out = out + String.valueOf(s);  
       }   
       txtdesk.setText(out);    
     }  
     else{  
      JOptionPane.showMessageDialog(null,"Key tidak cocok \nSilahkan coba lagi");  
     }
    
    }//GEN-LAST:event_jButton1ActionPerformed

    private void bclearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bclearActionPerformed
        // TODO add your handling code here:
        kosong();
    }//GEN-LAST:event_bclearActionPerformed

    
    
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
            java.util.logging.Logger.getLogger(layer2bayangan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(layer2bayangan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(layer2bayangan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(layer2bayangan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new layer2bayangan().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bclear;
    private javax.swing.JButton bdelete;
    private javax.swing.JButton bsave;
    private javax.swing.JButton btnhide;
    private javax.swing.JButton btnshow;
    private javax.swing.JButton bupluad;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tabelakun;
    private javax.swing.JTextField txtdesk;
    private javax.swing.JTextArea txtketerangan;
    private javax.swing.JTextField txtlink;
    private javax.swing.JTextField txtnamaakun;
    private javax.swing.JPasswordField txtpass;
    private javax.swing.JTextField txtusername;
    // End of variables declaration//GEN-END:variables
}
