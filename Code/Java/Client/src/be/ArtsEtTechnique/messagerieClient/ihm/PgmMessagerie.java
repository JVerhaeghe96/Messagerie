package be.ArtsEtTechnique.messagerieClient.ihm;

import be.ArtsEtTechnique.messagerieClient.domaine.Bundle;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class PgmMessagerie {
    public static void main(String[] args){
        MessagerieModel model = new MessagerieModel();

        new MessagePanel(model);
    }

    static class MessagePanel extends JFrame{
        private MessagerieModel model;
        private JLabel label;
        private int delai = 5;
        private Timer t;

        public MessagePanel(MessagerieModel model){
            this.setLayout(new BorderLayout());
            this.model = model;

            this.addWindowListener(new WindowAdapter() {
                @Override
                public void windowClosing(WindowEvent e) {
                    System.exit(0);
                }
            });

            this.setLocationRelativeTo(null);
            this.setVisible(true);
            this.setSize(new Dimension(300,200));

            this.connecter();
        }

        public void connecter(){
            while(!(Boolean) this.model.getBundle().get(Bundle.OPERATION_REUSSIE)){
                this.getContentPane().removeAll();

                JLabel labelMessage = new JLabel("Tentative de connexion au serveur.");
                labelMessage.setHorizontalAlignment(JLabel.CENTER);

                this.add(labelMessage);
                SwingUtilities.updateComponentTreeUI(this);
                this.delai = 5;

                this.model.connecterServer();

                if((Boolean) this.model.getBundle().get(Bundle.OPERATION_REUSSIE)){
                    MsgMainFrame mmf = new MsgMainFrame("Messagerie", model);
                    MsgFrameConnection mfc = new MsgFrameConnection("Messagerie - connexion", model, mmf);

                    this.dispose();

                }else{
                    this.getContentPane().removeAll();

                    labelMessage = new JLabel((String) this.model.getBundle().get(Bundle.MESSAGE));
                    labelMessage.setHorizontalAlignment(SwingConstants.CENTER);
                    this.add(labelMessage);

                    this.label = new JLabel("Nouvelle tentative dans " + delai);
                    this.label.setHorizontalAlignment(SwingConstants.CENTER);
                    this.label.setPreferredSize(new Dimension(100,50));
                    this.add(this.label, BorderLayout.SOUTH);

                    SwingUtilities.updateComponentTreeUI(this);

                    this.t = new Timer(1000, e -> {
                        this.label.setText("Nouvelle tentative dans " + --delai);

                        if(delai == 0)
                            MessagePanel.this.t.stop();
                    });
                    t.start();

                    try {
                        Thread.sleep(6000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}
