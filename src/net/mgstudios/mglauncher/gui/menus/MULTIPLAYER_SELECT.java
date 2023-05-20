package net.mgstudios.mglauncher.gui.menus;

import net.mgstudios.mglauncher.gui.Frame;
import net.mgstudios.mglauncher.gui.Menus;
import net.mgstudios.mglauncher.gui.components.Copyright;
import net.mgstudios.mglauncher.gui.components.LitePanel;
import net.mgstudios.mglauncher.gui.components.LiteButton;
import net.mgstudios.mglauncher.font.Fonts;
import net.mgstudios.mglauncher.gui.components.Return;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Properties;

public class MULTIPLAYER_SELECT extends LitePanel implements ActionListener {

    final Properties properties = System.getProperties();
    final JLabel TITLE = new JLabel(properties.getProperty("gui.fnaf_1_multiplayer.title"));
    final LiteButton JOIN_BTN = new LiteButton(properties.getProperty("gui.fnaf_1_multiplayer.join"));
    final LiteButton HOST_BTN = new LiteButton(properties.getProperty("gui.fnaf_1_multiplayer.host"));
    final Return return_btn = new Return();
    final Copyright copyright = new Copyright();
    public MULTIPLAYER_SELECT(){

        TITLE.setBounds(7,15,510,41);
        TITLE.setFont(Fonts.TITLE_FONT);
        TITLE.setForeground(Color.WHITE);

        JOIN_BTN.setBounds(7,135,720,45);

        HOST_BTN.setBounds(7,185,720,45);

        return_btn.addActionListener(this);
        JOIN_BTN.addActionListener(this);
        HOST_BTN.addActionListener(this);

        this.add(TITLE);
        this.add(JOIN_BTN);
        this.add(HOST_BTN);
        this.add(return_btn);
        this.add(copyright);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==return_btn){
            Frame.LOAD(Menus.FNAF_1);
        }
        if(e.getSource()==HOST_BTN){
            Frame.LOAD(Menus.HOST);
        }
        if(e.getSource()==JOIN_BTN){
            Frame.LOAD(Menus.JOIN);
        }
    }
}