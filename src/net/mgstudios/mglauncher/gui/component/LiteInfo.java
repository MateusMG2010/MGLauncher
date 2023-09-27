package net.mgstudios.mglauncher.gui.component;

import java.awt.*;

public class LiteInfo extends LiteLabel{
    public LiteInfo(String TEXT){
        super(TEXT);
        this.setForeground(Color.GREEN);
        this.setFont(new Font(Font.SERIF, Font.ITALIC, 20));
    }
}
