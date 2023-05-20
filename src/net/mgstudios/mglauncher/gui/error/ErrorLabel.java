package net.mgstudios.mglauncher.gui.error;

import javax.swing.*;
import java.awt.*;

public class ErrorLabel extends JLabel {
    public ErrorLabel(String TEXT){
        super(TEXT);
        this.setForeground(Color.RED);
        this.setBounds(75, 65, 600, 30);
        this.setFont(new Font(Font.SERIF, Font.PLAIN, 25));
    }
}