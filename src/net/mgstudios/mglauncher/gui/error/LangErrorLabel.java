package net.mgstudios.mglauncher.gui.error;

import javax.swing.*;
import java.awt.*;

public class LangErrorLabel extends JLabel {
    public LangErrorLabel(String TEXT){
        super(TEXT);
        this.setForeground(Color.RED);
        this.setBounds(40, 80, 600, 35);
        this.setFont(new Font(Font.SERIF, Font.PLAIN, 20));
    }
}
