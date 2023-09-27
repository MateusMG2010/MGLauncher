package net.mgstudios.mglauncher.gui.component;

import net.mgstudios.mglauncher.extra.Fonts;
import net.mgstudios.mglauncher.extra.Resource;
import net.mgstudios.mglauncher.gui.Frame;
import net.mgstudios.mglauncher.gui.menus.List;

import javax.swing.*;
import java.awt.*;

public class LitePanel extends JLabel {
    final LiteButton returnBtn = new LiteButton();
    final LiteLabel copyright = new LiteLabel("©MGStudios -MateusMG2010");
    public LitePanel(List Panel){
        copyright.setForeground(Color.GREEN);
        copyright.setFont(Fonts.COPYRIGHT_FONT);
        copyright.setBounds(10,725,225,30);
        returnBtn.setBounds(10,65,50,50);
        returnBtn.setFocusable(false);
        returnBtn.setIcon(new ImageIcon(Resource.getURL("assets/mglauncher/return.png")));
        returnBtn.addActionListener(e -> Frame.LOAD(Panel));
        this.add(returnBtn);
        this.setIcon(new ImageIcon(Resource.getURL("assets/mglauncher/FNAF.png")));
        this.setLayout(null);
        this.add(copyright);
        this.setBackground(Color.BLACK);
    }
}