
package caro.client;

import caro.common.GPos;
import caro.common.CPiece;
import caro.common.KMessage;
import caro.common.Users;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Event;
import java.awt.Graphics;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JScrollPane;

public class Main extends javax.swing.JFrame implements inReceiveMessage{

    ListenServer listenServer;
    
    JGoban Goban;
    JScrollPane jScroll;

    int GameState = 0;
    static final int WAIT = 0;
    static final int MY_TURN = 1;
    static final int YOU_WIN = 2;
    static final int YOU_LOSE = 3;
   
    public Main(ListenServer listenServer) {
        initComponents();

        setTitle("Game Caro");
        
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(700, 565);
        
        
        setLayout(new BorderLayout());
        
        InitGame();
        setLocationRelativeTo(null);
        
        
        this.listenServer = listenServer;
        this.listenServer.receive = this;
        
        try {
            listenServer.SendMessage(28, null); //Lay thong tin 2 ng
            listenServer.SendMessage(30, null); //Lay thong tin 2 ng
        } catch (IOException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    void InitGame() {

        Goban = new JGoban();
        Goban.setPreferredSize(new Dimension(500,500));
        
        
        panelCaro.setViewportView(Goban);

        Goban.Sakiyomi = true;
        Goban.Kinjite = true;

        Goban.init(500, 500);
        Goban.Initialize();
        Goban.Draw();
    }
  

    void putStatus(String strStt)
    {
        lblStatus.setText(strStt);
    }
    
    @Override
    public void paint(Graphics g) {
        super.paint(g);        

    
    }

  
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblName1 = new javax.swing.JLabel();
        lblName2 = new javax.swing.JLabel();
        lblStatus = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        lblScore1 = new javax.swing.JLabel();
        lblScore2 = new javax.swing.JLabel();
        txtChat = new javax.swing.JTextField();
        txtSendChat = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        ChatHistory = new javax.swing.JTextArea();
        btnExitRoom = new javax.swing.JButton();
        panelCaro = new javax.swing.JScrollPane();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lblName1.setText("Nguyễn Văn A");

        lblName2.setText("Nguyễn Thị B");

        lblStatus.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblStatus.setText("Doi nguoi choi thu 2");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel4.setText("X");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel5.setText("O");

        lblScore1.setText("Score: 100");

        lblScore2.setText("Score: 2000");

        txtSendChat.setText("Send");
        txtSendChat.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtSendChatMouseClicked(evt);
            }
        });

        ChatHistory.setEditable(false);
        ChatHistory.setColumns(20);
        ChatHistory.setRows(5);
        jScrollPane1.setViewportView(ChatHistory);

        btnExitRoom.setText("Exit Room");
        btnExitRoom.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnExitRoomMouseClicked(evt);
            }
        });

        panelCaro.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                panelCaroMouseClicked(evt);
            }
        });

        jButton1.setText("Replay");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(panelCaro, javax.swing.GroupLayout.PREFERRED_SIZE, 379, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txtChat, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtSendChat, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel4)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(lblScore1)
                                            .addComponent(lblName1)))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel5)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(lblScore2)
                                            .addComponent(lblName2))))
                                .addGap(0, 107, Short.MAX_VALUE))
                            .addComponent(jScrollPane1)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(37, 37, 37)
                                .addComponent(lblStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 457, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(19, 19, 19)
                                .addComponent(btnExitRoom, javax.swing.GroupLayout.PREFERRED_SIZE, 248, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(44, 44, 44)
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblName1)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblScore1)
                        .addGap(20, 20, 20)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(lblName2))
                        .addGap(8, 8, 8)
                        .addComponent(lblScore2)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtChat, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtSendChat, javax.swing.GroupLayout.Alignment.TRAILING)))
                    .addComponent(panelCaro, javax.swing.GroupLayout.PREFERRED_SIZE, 325, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(41, 41, 41)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnExitRoom, javax.swing.GroupLayout.DEFAULT_SIZE, 24, Short.MAX_VALUE)
                    .addComponent(jButton1))
                .addGap(21, 21, 21))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnExitRoomMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnExitRoomMouseClicked
        
        
        try {
            listenServer.SendMessage(39, null);   
            java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                    new RoomFrame(listenServer).setVisible(true);
                }
            });
            this.dispose();
        } catch (Exception e) {
        }
        
    }//GEN-LAST:event_btnExitRoomMouseClicked

    private void panelCaroMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelCaroMouseClicked
        // TODO add your handling code here:
        int x = evt.getX();
        int y = evt.getY();
        
        if (GameState==MY_TURN)
        {
            GPos pos = new GPos();
            int offetX = Goban.getX();
            int offetY = Goban.getY();

            if( !Goban.GetPos(x-offetX,y-offetY,pos) )
                return;

            if(Goban.Pieces[pos.x][pos.y].State == CPiece.EMPTY)
            {
                try {
                    
                    GameState = WAIT;
                    putStatus("Doi...");
                    listenServer.SendMessage(30, pos);
                } catch (IOException ex) {
                    Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            else
            {
                putStatus("Ban khong duoc danh vao vung nay!");
            }
        }

    }//GEN-LAST:event_panelCaroMouseClicked

    private void txtSendChatMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtSendChatMouseClicked
        
        String strMess = listenServer.user.getUsername() + ": " + txtChat.getText();
        if (ChatHistory.getText().isEmpty())
            ChatHistory.setText(strMess);
        else
            ChatHistory.setText(ChatHistory.getText()+'\n'+strMess);
        txtChat.setText("");
        try {
            listenServer.SendMessage(40, strMess);
        } catch (IOException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_txtSendChatMouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
       
        
        GameState= YOU_LOSE;
        putStatus("Ban da thua");
        try {
            listenServer.SendMessage(28, null);
            InitGame();
            Goban.Initialize();
            GameState=MY_TURN;
        } catch (IOException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_jButton1ActionPerformed

    
    public static void main(String args[]) {
      
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

      
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new LoginForm().setVisible(true);

            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea ChatHistory;
    private javax.swing.JButton btnExitRoom;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblName1;
    private javax.swing.JLabel lblName2;
    private javax.swing.JLabel lblScore1;
    private javax.swing.JLabel lblScore2;
    private javax.swing.JLabel lblStatus;
    private javax.swing.JScrollPane panelCaro;
    private javax.swing.JTextField txtChat;
    private javax.swing.JButton txtSendChat;
    // End of variables declaration//GEN-END:variables


    
    @Override
            public void ReceiveMessage(KMessage msg) throws IOException {
            switch (msg.getType()) {
                case 30:
                {
                    Goban.Pieces = (CPiece[][])msg.getObject();
                    Goban.Draw();

                    break;
                }
                case 31:
                {
                    putStatus("Toi luot ban");
                    GameState = MY_TURN;
                    break;
                }
                case 34: 
                {
                    Users[] arrUser = (Users[])msg.getObject();
                    if (arrUser!=null && arrUser.length>=2)
                    {
                        lblName1.setText(arrUser[0].getUsername());
                        lblScore1.setText(""+arrUser[0].getScore());
                        lblName2.setText(arrUser[1].getUsername());
                        lblScore2.setText(""+arrUser[1].getScore());
                    }
                    
                    break;
                }
                case 35:
                {
                    if ("win".equalsIgnoreCase(msg.getObject().toString()))
                    {
                        GameState = YOU_WIN;
                        putStatus("Ban da thang");
                    }
                    else if ("lose".equalsIgnoreCase(msg.getObject().toString()))
                    {
                        GameState = YOU_LOSE;
                        putStatus("Ban da thua");
                    }
                 
                    break;
                }    
                case 36:
                {
                    putStatus("Doi...");

                    break;
                }   
                case 40:
                {
                    String strMess = msg.getObject().toString();
                    if (ChatHistory.getText().isEmpty())
                        ChatHistory.setText(strMess);
                    else
                        ChatHistory.setText(ChatHistory.getText()+'\n'+strMess);
                    break;
                }   
            }
        }

    private void If(boolean b) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
