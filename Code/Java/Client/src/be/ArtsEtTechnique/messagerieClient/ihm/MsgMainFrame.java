package be.ArtsEtTechnique.messagerieClient.ihm;

import javax.swing.*;
import java.awt.*;

public final class MsgMainFrame extends JFrame {
    private MessagerieModel model;
    public MsgMainFrame(String title, MessagerieModel model){
        super(title);
        this.model = model;
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(new Dimension(300,500));
        this.setLocationRelativeTo(null);
    }
}
