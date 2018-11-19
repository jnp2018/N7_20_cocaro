/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package caro.client;

import caro.common.KMessage;
import caro.common.Room;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;


public class RoomFrame extends javax.swing.JFrame implements inReceiveMessage{
    ListenServer listenServer;
  
    public RoomFrame(ListenServer listenServer) {
        initComponents();
        
        setLocationRelativeTo(null);
        this.listenServer = listenServer;
        this.listenServer.receive = this;
        
        try {
            listenServer.SendMessage(21, null);
        } catch (IOException ex) {
            Logger.getLogger(RoomFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        btnJoinRoom = new javax.swing.JButton();
        lstRoom = new java.awt.List();
        btnViewRoom = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jButton1.setText("Refesh");
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1MouseClicked(evt);
            }
        });

        btnJoinRoom.setText("Join Room");
        btnJoinRoom.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnJoinRoomMouseClicked(evt);
            }
        });

        btnViewRoom.setText("View Room");
        btnViewRoom.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnViewRoomMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(lstRoom, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnJoinRoom)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnViewRoom)
                .addContainerGap(171, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lstRoom, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(btnJoinRoom)
                    .addComponent(btnViewRoom))
                .addContainerGap(179, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseClicked
        // TODO add your handling code here:
        try {
            listenServer.SendMessage(21, null);
        } catch (Exception e) {
        }

    }//GEN-LAST:event_jButton1MouseClicked

    private void btnJoinRoomMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnJoinRoomMouseClicked
        // TODO add your handling code here:
        
        try {
            if (lstRoom.getSelectedIndex()>=0)
            {
                listenServer.SendMessage(20, lstRoom.getSelectedIndex());
            }
        } catch (Exception e) {
        }
    }//GEN-LAST:event_btnJoinRoomMouseClicked

    private void btnViewRoomMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnViewRoomMouseClicked
        // TODO add your handling code here:
        
        try {
            if (lstRoom.getSelectedIndex()>=0)
            {
                listenServer.SendMessage(41, lstRoom.getSelectedIndex());
            }
        } catch (Exception e) {
        }
    }//GEN-LAST:event_btnViewRoomMouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnJoinRoom;
    private javax.swing.JButton btnViewRoom;
    private javax.swing.JButton jButton1;
    private java.awt.List lstRoom;
    // End of variables declaration//GEN-END:variables

    @Override
    public void ReceiveMessage(KMessage msg) throws IOException {
        switch (msg.getType()) {
            case 20: // get ban co
            {
                java.awt.EventQueue.invokeLater(new Runnable() {
                    public void run() {
                        new Main(listenServer).setVisible(true);
                    }
                });
                this.dispose();
                break;
            }
            case 21: {
                lstRoom.removeAll();
                int[] arrRoom = (int[])msg.getObject();
                for (int i=0; arrRoom!=null && i<arrRoom.length; i++)
                {
                    lstRoom.add("Room " + (i+1) + ": " + arrRoom[i]);
                }
                lstRoom.select(0);
                break;
            }
            case 22: { //Room nay da full
                lstRoom.removeAll();
                int[] arrRoom = (int[])msg.getObject();
                for (int i=0; arrRoom!=null && i<arrRoom.length; i++)
                {
                    lstRoom.add("Room " + (i+1) + ": " + arrRoom[i]);
                }
                lstRoom.select(0);
                JOptionPane.showMessageDialog(null, "Room nay da full, lua chon room khac", "Error", 1);
                break;
            }
        }
    }
}
