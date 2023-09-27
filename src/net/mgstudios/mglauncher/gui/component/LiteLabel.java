package net.mgstudios.mglauncher.gui.component;

import javax.swing.*;
import java.awt.*;

public class LiteLabel extends JLabel {
    public LiteLabel(String TEXT){
        super(TEXT);
        this.setBackground(Color.BLACK);
        this.setForeground(Color.WHITE);
        this.setFont(new Font(Font.SERIF,Font.PLAIN,28));
    }
}