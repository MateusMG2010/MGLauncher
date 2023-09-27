package net.mgstudios.mglauncher.gui.component;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class InteractiveButton extends JLabel {
    String TEXT;
    public InteractiveButton(String DEFAULT_TEXT){
        TEXT = DEFAULT_TEXT;
        this.setBackground(Color.BLACK);
        this.setForeground(Color.WHITE);
        this.setFont(new Font(Font.SERIF, Font.PLAIN, 30));
        this.setText(DEFAULT_TEXT);
        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                InteractiveButton.super.setText("> %s".formatted(DEFAULT_TEXT));
            }
            @Override
            public void mouseExited(MouseEvent e) {
                InteractiveButton.super.setText(DEFAULT_TEXT);
            }
        });
    }

    public void reset(){
        this.setText(TEXT);
    }
}