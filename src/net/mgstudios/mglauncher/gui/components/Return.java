package net.mgstudios.mglauncher.gui.components;

import net.mgstudios.mglauncher.font.Fonts;

import javax.swing.*;
import java.awt.*;

public class Return extends JButton {
    public Return(){
        super("<--");
        this.setFont(Fonts.RETURN_FONT);
        this.setBounds(10,65,115,35);
        this.setForeground(Color.WHITE);
        this.setBackground(Color.BLACK);
        this.setFocusable(false);
    }
}