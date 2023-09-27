package net.mgstudios.mglauncher.gui.component;

import javax.swing.*;
import java.awt.*;

public class LiteButton extends JButton {
    public LiteButton(String TEXT){
        super(TEXT);
        this.setBackground(Color.BLACK);
        this.setForeground(Color.WHITE);
        this.setFocusable(false);
        this.setFont(new Font(Font.SERIF,Font.PLAIN,23));
    }
    public LiteButton(){
        this.setBackground(Color.BLACK);
        this.setForeground(Color.WHITE);
        this.setFocusable(false);
        this.setFont(new Font(Font.SERIF,Font.PLAIN,23));
    }
}