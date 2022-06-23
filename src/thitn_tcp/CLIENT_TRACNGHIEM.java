/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thitn_tcp;

import com.sun.source.tree.BreakTree;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.net.ssl.SSLEngineResult;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;

/**
 *
 * @author Gum
 */
public final class CLIENT_TRACNGHIEM extends javax.swing.JFrame {
JFrame f=new JFrame(); 
private JFrame mainFrame;
    JFileChooser c = new JFileChooser();
    Socket socket;
    DataInputStream dis;
    DataOutputStream dos;
    int soCau = 0;
    ButtonGroup G = new ButtonGroup();
     String strkq;
    String anw;
    JButton jbnt = new JButton("click");
    private Iterable<Cauhoi> listCH;
    private static int timer = 30;
    int current=-1;
    int dem =0;
    boolean checkinput = false;
      int cauHientai = -1;
       ArrayList<Cauhoi> listCauhoi = null;
      String anwClient = "";
    ArrayList<String> cauChon = null;
     ArrayList<String> ketqua = null;
    /**
     * Creates new form CLIENT_TRACNGHIEM
     */
    public CLIENT_TRACNGHIEM() throws InterruptedException, IOException, SQLException {
        initComponents();
       this.setLocationRelativeTo(null);
        G.add(jrbA);
        G.add(jrbB);
        G.add(jrbC);
        G.add(jrbD);
        
       listCauhoi = new ArrayList();
        cauChon = new ArrayList();
        ketqua=new ArrayList<>();
        ThiTracNghiem(); 
        cauHoiKeTiep();
       
       
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        String time = " Timer : " + timer;
        g.setColor(Color.RED);
        g.setFont(new Font("Tahoma", Font.BOLD, 21));

        if (timer > 0) {
            g.drawString(time, 10, 100);

        } else {
            g.drawString("Times up ", 10, 100);
           
                timer = 30;
            try {
                try {
                    cauHoiKeTiep();
                } catch (InterruptedException ex) {
                    Logger.getLogger(CLIENT_TRACNGHIEM.class.getName()).log(Level.SEVERE, null, ex);
                } catch (SQLException ex) {
                    Logger.getLogger(CLIENT_TRACNGHIEM.class.getName()).log(Level.SEVERE, null, ex);
                }
            } catch (IOException ex) {
                Logger.getLogger(CLIENT_TRACNGHIEM.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        timer--;
        try {
            Thread.sleep(1000);
            repaint();
        } catch (Exception e) {
            if (timer < 0) {
                current++;
                timer = 30;
            }
        }
    }
     private void tinhSoCauDung() throws IOException, InterruptedException{
        int cau=0;int dem =0;
        for(int i=0; i<soCau; i++){
            
           dem++;
            String dapan = listCauhoi.get(i).getDapAn();
            String chon = cauChon.get(i);
            System.out.println(dem+" SS Đáp án -- D/A của bạn: "+dapan+"--"+chon);
            strkq = dem+" Đáp án đúng -- D/A của bạn: "+dapan+"--"+chon;
            ketqua.add(strkq);
            if(chon.equals(dapan)){
                System.out.println("Đúng");
                cau++;
            }else{
                System.out.println("Sai");
           }
        }
     DapAn.diem=cau;
    
    }

  private void cauHoiKeTiep() throws IOException, InterruptedException, SQLException{
       current++;
        timer=30;
         
        if(current>0){
            if(jrbA.isSelected()){
                cauChon.add("A");
                  anwClient += dem + "///";
                  anwClient += anw + "///";
                System.out.println("A");
            }else if(jrbB.isSelected()){
                cauChon.add("B");
                System.out.println("B");
                 anwClient += dem + "///";
                  anwClient += anw + "///";
            }else if(jrbC.isSelected()){
                cauChon.add("C");
                System.out.println("C");
                 anwClient += dem + "///";
                  anwClient += anw + "///";
            }else if(jrbD.isSelected()){
                cauChon.add("D");
                System.out.println("D");
                 anwClient += dem + "///";
                  anwClient += anw + "///";
            }else{
                cauChon.add("E");
                System.out.println("E");
            } 
        }
        
        if(current<soCau){
            dem++;
            Cauhoi ch = listCauhoi.get(current);
            System.out.println(dem + ": " + ch.getNoidung());
                txtCauhoi.setText(dem + ": " + ch.getNoidung());
                System.out.println("A. " + ch.getCauA());
                jrbA.setText("A " + ch.getCauA());
                System.out.println("B. " + ch.getCauB());
                jrbB.setText("B. " + ch.getCauB());
                System.out.println("C. " + ch.getCauC());
                jrbC.setText("C. " + ch.getCauC());
                System.out.println("D. " + ch.getCauD());
                jrbD.setText("D. " + ch.getCauD());
           
           if(dem==10){
               btnNopbai.setText("NỘP BÀI");
           }
        }
        else{
         
            JOptionPane.showMessageDialog(null, "Bạn đã hoàn thành bài thi!, Nộp bài!");
            tinhSoCauDung();     
           KETQUA KQ = new KETQUA();
          KQ.setVisible(true);
          
            }
         
        }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtCauhoi = new javax.swing.JLabel();
        jrbA = new javax.swing.JRadioButton();
        jrbB = new javax.swing.JRadioButton();
        jrbC = new javax.swing.JRadioButton();
        jrbD = new javax.swing.JRadioButton();
        btnNopbai = new javax.swing.JButton();
        btnTiep = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        txtCauhoi.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        txtCauhoi.setText("CÂU 1 : mạng man được sử dụng trong phạm vi:");

        jrbA.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jrbA.setText("A. QUỐC GIA");
        jrbA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jrbAActionPerformed(evt);
            }
        });

        jrbB.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jrbB.setText("B. LỤC ĐỊA");
        jrbB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jrbBActionPerformed(evt);
            }
        });

        jrbC.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jrbC.setText("C. KHU PHỐ");
        jrbC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jrbCActionPerformed(evt);
            }
        });

        jrbD.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jrbD.setText("D. THÀNH PHỐ");
        jrbD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jrbDActionPerformed(evt);
            }
        });

        btnNopbai.setBackground(new java.awt.Color(153, 153, 255));
        btnNopbai.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnNopbai.setText("TIẾP THEO");
        btnNopbai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNopbaiActionPerformed(evt);
            }
        });

        btnTiep.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnTiep.setText("Nộp Bài");
        btnTiep.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTiepActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 3, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 255));
        jLabel1.setText("BÀI TRẮC NGHIỆM");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(285, 285, 285)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnTiep)
                .addGap(53, 53, 53))
            .addGroup(layout.createSequentialGroup()
                .addGap(127, 127, 127)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jrbA, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jrbB, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jrbC, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jrbD, javax.swing.GroupLayout.DEFAULT_SIZE, 495, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(34, Short.MAX_VALUE)
                .addComponent(txtCauhoi, javax.swing.GroupLayout.PREFERRED_SIZE, 708, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(11, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(302, 302, 302)
                .addComponent(btnNopbai)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnTiep, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtCauhoi, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jrbA, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jrbB, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jrbC, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jrbD, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnNopbai, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(22, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    public void ThiTracNghiem() {
 try {
 
            socket = new Socket("localhost", 2207);
            dis = new DataInputStream(socket.getInputStream());
            dos = new DataOutputStream(socket.getOutputStream());
            Cauhoi CH = new Cauhoi();
            String strTN = dis.readUTF();
            String[] arrStr = strTN.split("///");
            List<Cauhoi> listCH = new ArrayList<Cauhoi>();

            int i = 0;
            int dem = 0;
            for (i = 0; i < arrStr.length;) {
                if (dem < 11) {
                    CH = new Cauhoi();
                    CH.setSocau(Integer.parseInt(arrStr[i]));
                    CH.setTrinhdo(arrStr[i + 1]);
                    CH.setNoidung(arrStr[i + 2]);
                    CH.setCauA(arrStr[i + 3]);
                    CH.setCauB(arrStr[i + 4]);
                    CH.setCauC(arrStr[i + 5]);
                    CH.setCauD(arrStr[i + 6]);
                    CH.setDapAn(arrStr[i + 7]);
                    listCauhoi.add(CH);
                    i = i + 8;
                }
                dem++;
            }
            dem = 0;
            String anwClient = "";
             soCau = listCauhoi.size();
            //  CauHoi ch ;
            dem++;
           
           while (checkinput) {

                    if (anw.equals("A") || anw.equals("B") || anw.equals("C") || anw.equals("D")) {
                        anwClient += dem + "///";
                        anwClient += anw + "///";
                        checkinput = false;
                    } else {
                        System.out.println("Nhap sai vui long nhap lai!");
                        JOptionPane.showMessageDialog(null, "VUI Long click vao 1 dap an truoc khi tra loi!");
                }
            }
            dos.writeUTF(anwClient);

           String answer = dis.readUTF();
           System.out.println(answer);
           
            
           // Thread.sleep(3000);
              socket.close();
        } catch (IOException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    private void btnNopbaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNopbaiActionPerformed
   
    try {
       
        cauHoiKeTiep();
    } catch (IOException ex) {
        Logger.getLogger(CLIENT_TRACNGHIEM.class.getName()).log(Level.SEVERE, null, ex);
    } catch (InterruptedException ex) {
        Logger.getLogger(CLIENT_TRACNGHIEM.class.getName()).log(Level.SEVERE, null, ex);
    } catch (SQLException ex) {
        Logger.getLogger(CLIENT_TRACNGHIEM.class.getName()).log(Level.SEVERE, null, ex);
    }
     
    }//GEN-LAST:event_btnNopbaiActionPerformed

    private void jrbAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jrbAActionPerformed
       
    }//GEN-LAST:event_jrbAActionPerformed

    private void btnTiepActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTiepActionPerformed
                  int input = JOptionPane.showOptionDialog(null, "Bạn có chắc nộp bài", "Nộp bài", JOptionPane.OK_OPTION, JOptionPane.INFORMATION_MESSAGE, null, null, null); 
       if(input == JOptionPane.OK_OPTION)
{                                      try {                current=10;
try {
    cauHoiKeTiep();
    
    
} catch (IOException ex) {
    Logger.getLogger(CLIENT_TRACNGHIEM.class.getName()).log(Level.SEVERE, null, ex);
} catch (InterruptedException ex) {
    Logger.getLogger(CLIENT_TRACNGHIEM.class.getName()).log(Level.SEVERE, null, ex);
} catch (SQLException ex) {
    Logger.getLogger(CLIENT_TRACNGHIEM.class.getName()).log(Level.SEVERE, null, ex);
}
try {
    CLIENT_TRACNGHIEM CL = new CLIENT_TRACNGHIEM();
} catch (InterruptedException ex) {
    Logger.getLogger(CLIENT_TRACNGHIEM.class.getName()).log(Level.SEVERE, null, ex);
} catch (IOException ex) {
    Logger.getLogger(CLIENT_TRACNGHIEM.class.getName()).log(Level.SEVERE, null, ex);
}
this.setVisible(false);
KETQUA KQ = new KETQUA();
KQ.setVisible(true);
} catch (SQLException ex) {
                          Logger.getLogger(CLIENT_TRACNGHIEM.class.getName()).log(Level.SEVERE, null, ex);
                      }
}  

    }//GEN-LAST:event_btnTiepActionPerformed
    
    private void jrbBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jrbBActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jrbBActionPerformed

    private void jrbCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jrbCActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jrbCActionPerformed

    private void jrbDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jrbDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jrbDActionPerformed

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
            java.util.logging.Logger.getLogger(CLIENT_TRACNGHIEM.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CLIENT_TRACNGHIEM.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CLIENT_TRACNGHIEM.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CLIENT_TRACNGHIEM.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {

                try {
                    new CLIENT_TRACNGHIEM().setVisible(true);
                } catch (InterruptedException ex) {
                    Logger.getLogger(CLIENT_TRACNGHIEM.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IOException ex) {
                    Logger.getLogger(CLIENT_TRACNGHIEM.class.getName()).log(Level.SEVERE, null, ex);
                } catch (SQLException ex) {
                    Logger.getLogger(CLIENT_TRACNGHIEM.class.getName()).log(Level.SEVERE, null, ex);
                }

            }

        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnNopbai;
    private javax.swing.JButton btnTiep;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JRadioButton jrbA;
    private javax.swing.JRadioButton jrbB;
    private javax.swing.JRadioButton jrbC;
    private javax.swing.JRadioButton jrbD;
    private javax.swing.JLabel txtCauhoi;
    // End of variables declaration//GEN-END:variables
}
