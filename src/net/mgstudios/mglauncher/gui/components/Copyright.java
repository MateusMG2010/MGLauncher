package net.mgstudios.mglauncher.gui.components;

import net.mgstudios.mglauncher.font.Fonts;

import javax.swing.*;
import java.awt.*;

public class Copyright extends JLabel {
    public Copyright(){
        super("©MGStudios -MateusMG2010");
        this.setForeground(Color.GREEN);
        this.setBackground(Color.BLACK);
        this.setFont(Fonts.COPYRIGHT_FONT);
        this.setBounds(10,725,200,30);
    }
}