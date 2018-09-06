package be.ArtsEtTechnique.messagerieClient.ihm;

import javax.swing.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class MsgFrameConnection extends JFrame {
    private MessagerieModel model;
    private MsgMainFrame frame;

    public MsgFrameConnection(String title, MessagerieModel model, MsgMainFrame frame){
        super(title);
        this.model = model;
        this.frame = frame;

        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });

        this.setSize(400,500);
        this.setLocationRelativeTo(frame);
        this.setVisible(true);
    }
}
